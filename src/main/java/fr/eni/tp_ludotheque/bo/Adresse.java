package fr.eni.tp_ludotheque.bo;

import jakarta.persistence.*;
import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of= {"no_adresse"})
@ToString

@Entity
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer no_adresse;

    @Column(nullable = false, length = 150)
    @NonNull
    private String rue;

    @Column(nullable = false, length = 5)
    @NonNull private String code_postal;

    @Column(nullable = false, length = 150)
    @NonNull private String ville;

}
