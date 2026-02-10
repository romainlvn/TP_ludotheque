package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Jeu;
import fr.eni.ludotheque.dto.JeuDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JeuRepository extends JpaRepository<Jeu, Integer>{
    @Query(nativeQuery = true, value = "select j.no_jeu, j.titre, j.reference, j.description, j.tarif_jour, j.duree, j.age_min "
            + " from jeux j "
            + " where (:titre = 'TOUS' OR titre like '%' + :titre + '%')"
            + " order by j.titre ")
    List<Jeu> findAllJeuxFiltreTitre(@Param("titre") String titre);

    @Query(nativeQuery = true, value="select tarif_jour from jeux where no_jeu = :noJeu")
    Float findTarifJour(@Param("noJeu") Integer noJeu);

    Jeu findByReference(String reference);

    @Query(nativeQuery = true, value="select noJeu, titre, reference, ageMin, description,  duree, tarifJour, nbExemplairesDisponibles from dbo.listeJeux(:titre)")
    List<JeuDTO> findAllJeuxAvecNbExemplairesV2(@Param("titre") String titre);


}
