package fr.eni.tp_ludotheque.dal;

import fr.eni.tp_ludotheque.bo.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
