package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.dto.AdresseDTO;
import fr.eni.ludotheque.dto.ClientDTO;

import java.util.List;

public interface ClientService {

    void ajouterClient(Client client);
    List<Client> rechercherClient(String search);
    Client modifierClient(Long id, ClientDTO clientDTO);
    Client modifierAdresseClient(Long id, AdresseDTO adresseDTO);
}
