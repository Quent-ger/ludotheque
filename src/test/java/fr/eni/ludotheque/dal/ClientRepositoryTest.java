package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.bo.Client;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    
    public void testCreationClientCasPositif(){
        // Arrange
        Adresse adresse = new Adresse();
        adresse.setRue("1 rue Paul Signac");
        adresse.setCodePostal("56000");
        adresse.setVille("Vannes");

        Client client = new Client();
        client.setNom("Bob");
        client.setPrenom("John");
        client.setEmail("abcdef@fakemail.com");
        client.setNoTelephone("0677667766");
        client.setAdresse(adresse);

        // Act

        Client savedClient = clientRepository.save(client);

        // Assert

        // client
        assertThat(savedClient).isNotNull();
        assertThat(savedClient.getNoClient()).isNotNull();
        assertThat(savedClient.getNom()).isNotNull();
        assertThat(savedClient.getPrenom()).isNotNull();
        assertThat(savedClient.getEmail()).isNotNull();
        assertThat(savedClient.getNoTelephone()).isNotNull();
        assertThat(savedClient.getNom()).isEqualTo("Bob");
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
