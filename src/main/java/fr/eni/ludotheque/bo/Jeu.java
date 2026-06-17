package fr.eni.ludotheque.bo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
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

}
