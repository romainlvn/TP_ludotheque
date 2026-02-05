package fr.eni.tp_ludotheque.dal;

import fr.eni.tp_ludotheque.bo.Jeu;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class JeuRepositoryTest {

    @Autowired
    private JeuRepository jeuRepo;

    @Test
    @DisplayName("Creation d'un jeu avec JPA")
    @Transactional
    void should_save_and_find_jeu() {
        Jeu nouveauJeu = new Jeu("tft","riotgamestft",16,"gnar po de guerre", 7.5);

        Jeu jeuSauvegarde = jeuRepo.save(nouveauJeu);

        Optional<Jeu> jeuRecupere = jeuRepo.findById(jeuSauvegarde.getNo_jeu());

        assertTrue(jeuRecupere.isPresent());
        assertEquals(1, jeuRecupere.get().getNo_jeu());
    }
}
