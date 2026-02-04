package fr.eni.tp_ludotheque.bo;

import jakarta.persistence.*;
import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of= {"no_jeu"})
@ToString

@Entity
public class Jeu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer no_jeu;

    @Column(nullable = false, length = 50)
    @NonNull private String titre;

    @Column(nullable = false, length = 50, unique = true)
    @NonNull private String reference;

    @Column(nullable = false)
    @NonNull private Integer age_min;

    @Column(nullable = false, length = 50)
    @NonNull private String description;

    @Column(nullable = false, length = 50)
    @NonNull private Double tarif_jour;

}
