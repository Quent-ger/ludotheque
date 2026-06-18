package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exemplaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noExemplaire;

    @Column(unique = true, length = 13)
    private Long codeBarre;

    private boolean louable;

    @ManyToOne
    @JoinColumn (name="jeu_id")
    private Jeu jeu;

    public Exemplaire(Long codeBarre) {
        this.codeBarre = codeBarre;
    }
}
