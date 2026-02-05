package fr.eni.tp_ludotheque.bo;

import jakarta.persistence.*;
import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of= {"no_genre"})
@ToString

@Entity
public class Genre {

    @Id
    @NonNull
    private Integer no_genre;

    @Column(nullable = false, length = 50)
    @NonNull
    private String libelle;

}
