package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="CLIENTS")
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noClient;

    @Column(length = 50, nullable = false)
    private String nom;

    @Column(length = 50, nullable = false)
    private String prenom;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(length = 10)
    private String noTelephone;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},  fetch = FetchType.EAGER)
    @JoinColumn(name= "no_adresse")
    private Adresse adresse;

    public Client(String nom, String prenom, String email, String noTelephone, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.noTelephone = noTelephone;
        this.adresse = adresse;
    }

    public Client(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }
}
