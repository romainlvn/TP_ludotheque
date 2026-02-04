package fr.eni.tp_ludotheque.dal;

import fr.eni.tp_ludotheque.bo.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JeuRepository extends JpaRepository<Jeu, Integer> {
}
