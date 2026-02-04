package fr.eni.tp_ludotheque.dal;

import fr.eni.tp_ludotheque.bo.Client;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepo;

    @Test
    @DisplayName("Creation d'un client avec JPA")
    void should_save_and_find_client() {
        Client nouveauClient = new Client("NomTest", "PrenomTest", "test@eni.fr", "0102030405");

        Client clientSauvegarde = clientRepo.save(nouveauClient);

        Optional<Client> clientRecupere = clientRepo.findById(clientSauvegarde.getNo_client());

        assertTrue(clientRecupere.isPresent());
        assertEquals(1, clientRecupere.get().getNo_client());
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
