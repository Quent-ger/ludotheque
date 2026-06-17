package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noGenre;

    private String libelle;

}
