package fr.eni.tp_ludotheque.dal;

import fr.eni.tp_ludotheque.bo.Adresse;
import fr.eni.tp_ludotheque.bo.Client;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepo;
    private AdresseRepository adresseRepo;

    @Test
    @DisplayName("Creation d'un client avec JPA")
    void should_save_and_find_client() {
        Client nouveauClient = new Client("NomTest", "PrenomTest", "test@eni.fr", "0102030405");

        Client clientSauvegarde = clientRepo.save(nouveauClient);

        Optional<Client> clientRecupere = clientRepo.findById(clientSauvegarde.getNo_client());

        assertTrue(clientRecupere.isPresent());
        assertEquals(1, clientRecupere.get().getNo_client());
    }

    @Test
    @DisplayName("Creation d'un client avec une adresse")
    void should_save_client_with_address() {
        //Arrange
        Adresse adr = new Adresse("12 rue des jeux", "75000", "Paris");
        Client client = new Client("Durand", "Marie", "marie@email.com", "0600000000");

        //Act
        client.setAdresse(adr);
        Client client1 = clientRepo.save(client);

        assertNotEquals(null, client1.getAdresse());
        assertEquals("Paris", client1.getAdresse().getVille());
    }

    /*public void testFindByIdClient() {
        //Arrange
        Integer no_client = 1;

        //Act 
        Optional<Client> clientOpt = clientRepo.findById(no_client);

        //Assert
        assertTrue(clientOpt.isPresent());
        assertEquals(1, clientOpt.get().getNo_client());

    }*/
}
