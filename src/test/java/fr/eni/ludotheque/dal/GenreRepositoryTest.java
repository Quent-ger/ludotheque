package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Genre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class GenreRepositoryTest {

    @Autowired
    private GenreRepository genreRepository;

    @Test
    void testCreationGenreCasPositif(){
        // Arrange
        Genre genre = new Genre();
        genre.setLibelle("Jeu de plateau");

        // Act
        Genre savedGenre = genreRepository.save(genre);

        // Arrange
        assertThat(savedGenre).isNotNull();
        assertThat(savedGenre.getNoGenre()).isNotNull();
        assertThat(savedGenre.getLibelle()).isEqualTo("Jeu de plateau");
    }
}
