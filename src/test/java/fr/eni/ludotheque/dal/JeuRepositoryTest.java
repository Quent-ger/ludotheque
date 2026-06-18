package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Genre;
import fr.eni.ludotheque.bo.Jeu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class JeuRepositoryTest {

    @Autowired
    private JeuRepository jeuRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Test
    public void testCreationJeuCasPositif(){

        // Arrange
        jeuRepository.deleteAll();

        Jeu jeu = new Jeu("Risk", 12L, 12, "une descr", 300, 5.25);
            jeu.getGenres().add(genreRepository.findById(1L).orElse(null));
        jeu.getGenres().add(genreRepository.findById(2L).orElse(null));
        System.out.println(jeu.getGenres());


        // Act
        Jeu savedJeu = jeuRepository.save(jeu);

        // Assess
        Jeu jeuEnBD = jeuRepository.findById(savedJeu.getId().intValue()).orElse(null);
        assertNotNull(savedJeu);
        assertNotNull(jeuEnBD);
        assertNotNull(jeu.getGenres());
        assertNotNull(jeu.getGenres().get(0));
        assertNotNull(jeu.getGenres().get(1));

    }

}
