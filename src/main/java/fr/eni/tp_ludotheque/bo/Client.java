package fr.eni.tp_ludotheque.bo;

import jakarta.persistence.*;
import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of= {"no_client"})
@ToString

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer no_client;

    @Column(nullable = false, length = 50)
    @NonNull
    private String nom;

    @Column(nullable = false, length = 50)
    @NonNull private String prenom;

    @Column(nullable = false, length = 150, unique = true)
    @NonNull private String email;

    @Column(length = 50)
    @NonNull private String telephone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "no_adresse")
    private Adresse adresse;
}
