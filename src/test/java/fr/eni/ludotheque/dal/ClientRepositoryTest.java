package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.bo.Client;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;


    @Test
    public void testCreationClientCasPositif(){
        // Arrange
//        Adresse adresse = new Adresse();
//        adresse.setRue("1 rue Paul Signac");
//        adresse.setCodePostal("56000");
//        adresse.setVille("Vannes");

        Adresse adresse  = new Adresse("1 rue Paul Signac", "56000", "Vannes");

        Client client = new Client("Bob", "John", "abcdef@fakemail.com",
                "0677667766", adresse);

        // Act

        Client savedClient = clientRepository.save(client);

        // Assert

        // client
        Client clientEnBD = clientRepository.findById(savedClient.getNoClient()).orElse(null);
        assertNotNull(clientEnBD);
        assertNotNull(savedClient);
        assertThat(savedClient.getNoClient()).isNotNull();
        assertEquals("Bob", savedClient.getNom());
        assertThat(savedClient.getPrenom()).isEqualTo("John");
        assertThat(savedClient.getNoTelephone()).isEqualTo("0677667766");
        assertThat(savedClient.getEmail()).isEqualTo("abcdef@fakemail.com");

        // adresse
        assertThat(savedClient.getAdresse()).isNotNull();
        assertThat(savedClient.getAdresse().getNoAdresse()).isNotNull();
        assertThat(savedClient.getAdresse().getRue()).isNotNull();
        assertThat(savedClient.getAdresse().getCodePostal()).isNotNull();
        assertThat(savedClient.getAdresse().getVille()).isNotNull();
        assertThat(savedClient.getAdresse().getRue()).isEqualTo("1 rue Paul Signac");
        assertThat(savedClient.getAdresse().getCodePostal()).isEqualTo("56000");
        assertThat(savedClient.getAdresse().getVille()).isEqualTo("Vannes");

    }

}
