package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="GENRES")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="no_genre")
    private Long noGenre;

    @Column(nullable = false,  unique = true, length = 100)
    private String libelle;

}
