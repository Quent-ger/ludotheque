package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Exemplaire;
import fr.eni.ludotheque.bo.Jeu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ExemplaireRepositoryTest {

    @Autowired
    private ExemplaireRepository exemplaireRepository;

    @Autowired
    private JeuRepository jeuRepository;

    @Test
    public void testCreationExemplaireCasPositif(){
        // Arrange
        exemplaireRepository.deleteAll();

        Jeu jeu = jeuRepository.findById(1).orElse(null);

        Exemplaire exemplaire = new Exemplaire(1234567891234L);
        exemplaire.setLouable(true);
        exemplaire.setJeu(jeu);

        // Act
        Exemplaire savedExemplaire = exemplaireRepository.save(exemplaire);

        // Assert
        Exemplaire exemplaireEnBd = exemplaireRepository.findById(1L).orElse(null);
        assertNotNull(exemplaireEnBd);
        assertNotNull(savedExemplaire);
        assertNotNull(savedExemplaire.getJeu());
        assertNotNull(savedExemplaire.getNoExemplaire());
        assertNotNull(savedExemplaire.getJeu().getId());
        assertEquals("Risk", savedExemplaire.getJeu().getTitre());


    }
}
