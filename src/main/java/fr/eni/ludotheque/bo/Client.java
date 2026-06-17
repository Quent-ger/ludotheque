package fr.eni.ludotheque.bo;

import lombok.Data;

@Data
public class Client {

    private Long noClient;
    private String nom;
    private String prenom;
    private String email;
    private String noTelephone;

}
