package fr.eni.tp_ludotheque.dal;

import fr.eni.tp_ludotheque.bo.Adresse;
import fr.eni.tp_ludotheque.bo.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
