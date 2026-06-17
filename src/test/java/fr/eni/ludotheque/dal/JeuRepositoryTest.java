package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Jeu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class JeuRepositoryTest {

    @Autowired
    private JeuRepository jeuRepository;

    @Test
    public void testCreationJeuCasPositif(){

        // Arrange

        Jeu jeu = new Jeu();
        jeu.setTitre("La Bonne Paye");
        jeu.setReference(12L);
        jeu.setTarifJour(2.25);
        jeu.setDuree(120);
        jeu.setAgeMin(7);

        // Act

        Jeu savedJeu = jeuRepository.save(jeu);

        // Assess

        assertThat(savedJeu.getId()).isNotNull();
        assertThat(savedJeu.getTitre()).isNotNull();
        assertThat(savedJeu.getReference()).isNotNull();
        assertThat(savedJeu.getTarifJour()).isNotNull();
        assertThat(savedJeu.getDuree()).isNotNull();
        assertThat(savedJeu.getAgeMin()).isNotNull();
        assertThat(savedJeu.getTitre()).isEqualTo("La Bonne Paye");
        assertThat(savedJeu.getReference()).isEqualTo(12L);
        assertThat(savedJeu.getTarifJour()).isEqualTo(2.25);
        assertThat(savedJeu.getDuree()).isEqualTo(120);
        assertThat(savedJeu.getAgeMin()).isEqualTo(7);

    }

}
