package fr.eni.ludotheque.dal;

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
    @Transactional

    public void testCreationClientCasPositif(){
        //  AAA : Arrange, Act, Assert

        Client client = new Client();
        client.setNom("Bob");
        client.setPrenom("John");
        client.setEmail("abcdef@fakemail.com");
        client.setNoTelephone("0677667766");

        Client savedClient = clientRepository.save(client);

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
    }

}
