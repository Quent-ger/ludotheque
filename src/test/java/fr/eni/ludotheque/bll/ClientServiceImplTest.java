package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.dal.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientServiceImplTest  {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void testCreationClient() {
        // Arrange
        Adresse adresse = new Adresse("12 rue Mayflower", "26000", "Valence");


        Client client = new Client("John", "Ringo", "johnringo@mail.com");
        client.setNoTelephone("0666226644");
        client.setAdresse(adresse);


        // Act
        clientService.ajouterClient(client);

        // Assert
        Client clientBD = clientRepository.findById(client.getNoClient()).orElse(null);
        Assertions.assertNotNull(clientBD);
    }


}
