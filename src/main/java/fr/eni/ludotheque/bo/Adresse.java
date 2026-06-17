package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noAdresse;

    @Column(length = 150, nullable = false)
    private String rue;

    @Column(length = 5, nullable = false)
    private String codePostal;

    @Column(length = 100, nullable = false)
    private String ville;

}
