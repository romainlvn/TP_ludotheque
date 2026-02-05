package fr.eni.tp_ludotheque.dal;

import fr.eni.tp_ludotheque.bo.Genre;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class GenreRepositoryTest {

    @Autowired
    private GenreRepository genreRepo;

    @Test
    @DisplayName("Creation d'un genre avec JPA")
    @Transactional
    void should_save_and_find_genre() {
        Genre nouveauGenre = new Genre(1, "Action");

        Genre genreSauvegarde = genreRepo.save(nouveauGenre);

        Optional<Genre> genreRecupere = genreRepo.findById(genreSauvegarde.getNo_genre());

        assertTrue(genreRecupere.isPresent());
        assertEquals(1, genreRecupere.get().getNo_genre());
    }
}
