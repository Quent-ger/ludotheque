package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.dal.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
        Adresse adresse2 = new Adresse("13 rue Mayflower", "26000", "Valence");


        Client client = new Client("John", "Ringo", "johnringo@mail.com");
        client.setNoTelephone("0666226644");
        client.setAdresse(adresse);

        Client client2 = new Client("George", "Cartney", "georgecartney@mail.com");
        client2.setAdresse(adresse2);
        client2.setNoTelephone("0633142345");

        // Act
        clientService.ajouterClient(client);
        clientService.ajouterClient(client2);

        // Assert
        Client clientBD = clientRepository.findById(client.getNoClient()).orElse(null);
        Client clientBD2 = clientRepository.findById(client2.getNoClient()).orElse(null);
        Assertions.assertNotNull(clientBD);
        Assertions.assertNotNull(clientBD2);
    }

    @Test
    public void testRechercheClientParNom() {
        // Arrange
            Adresse adresse = new Adresse("12 rue Mayflower", "26000", "Valence");

            Client client = new Client("John", "Ringo", "johnringo@mail.com");
            client.setNoTelephone("0666226644");
            client.setAdresse(adresse);
            clientService.ajouterClient(client);

        // Act
            String termeDeRecherche = "Jo";
            List<Client> clients = clientService.rechercherClient(termeDeRecherche);
        // Assert
        Assertions.assertNotNull(clients);
        Assertions.assertFalse(clients.isEmpty());
        Assertions.assertEquals(1, clients.size());
        Assertions.assertEquals("John", clients.getFirst().getNom());
    }


}
