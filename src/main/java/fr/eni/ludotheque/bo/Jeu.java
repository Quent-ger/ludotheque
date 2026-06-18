package fr.eni.ludotheque.bo;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="JEUX")
@NoArgsConstructor
@AllArgsConstructor

public class Jeu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length = 150, nullable = false, unique = true)
    private String titre;


    @Column(nullable = false, unique = true)
    private Long reference;

    @Column(precision = 3)
    private int ageMin;

    @Column(length = 10)
    private String description;

    private int duree;


    @Column(nullable = false)
    private double tarifJour;

    @ManyToMany
    @JoinTable(
            name = "jeux_genres",
            joinColumns = @JoinColumn(name = "jeu_id"),
            inverseJoinColumns = @JoinColumn (name= "no_genre")
    )
    private List<Genre> genres = new ArrayList<>();

    public Jeu(String titre, Long reference, int ageMin, String description, int duree, double tarifJour) {
        this.titre = titre;
        this.reference = reference;
        this.ageMin = ageMin;
        this.description = description;
        this.duree = duree;
        this.tarifJour = tarifJour;
    }
}
