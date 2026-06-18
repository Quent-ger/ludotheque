package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name="ADRESSES")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noAdresse;

    @Column(length = 150, nullable = false)
    @NonNull
    private String rue;

    @Column(length = 5, nullable = false)
    @NonNull
    private String codePostal;

    @Column(length = 100, nullable = false)
    @NonNull
    private String ville;

//    public Adresse(String rue, String codePostal, String ville) {
//        this.rue = rue;
//        this.codePostal = codePostal;
//        this.ville = ville;
//    }
}
