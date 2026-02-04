package fr.eni.tp_ludotheque.dal;

import fr.eni.tp_ludotheque.bo.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresseRepository extends JpaRepository<Adresse, Integer> {
}
