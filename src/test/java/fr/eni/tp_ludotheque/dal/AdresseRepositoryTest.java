package fr.eni.tp_ludotheque.dal;

import fr.eni.tp_ludotheque.bo.Adresse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AdresseRepositoryTest {

    @Autowired
    private AdresseRepository adresseRepo;

    @Test
    @DisplayName("Creation d'un adresse avec JPA")
    void should_save_and_find_adresse() {
        Adresse nouveauAdresse = new Adresse("Rue de ici", "86000", "Poitiers");

        Adresse adresseSauvegarde = adresseRepo.save(nouveauAdresse);

        Optional<Adresse> adresseRecupere = adresseRepo.findById(adresseSauvegarde.getNo_adresse());

        assertTrue(adresseRecupere.isPresent());
        assertEquals(1, adresseRecupere.get().getNo_adresse());
    }
}
