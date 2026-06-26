package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.DataNotFound;
import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.dal.AdresseRepository;
import fr.eni.ludotheque.dal.ClientRepository;
import fr.eni.ludotheque.dto.AdresseDTO;
import fr.eni.ludotheque.dto.ClientDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final AdresseRepository adresseRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, AdresseRepository adresseRepository) {
        this.clientRepository = clientRepository;
        this.adresseRepository = adresseRepository;
    }

    @Override
    public void ajouterClient(Client client) {
        clientRepository.save(client);
    }

    @Override
        public List<Client> rechercherClient(String recherche) {
            return clientRepository.findByNomStartingWith(recherche);
        }

    @Override
    public Client modifierClient(Long id, ClientDTO clientDto) {
//        Client client = clientRepository.findById(id).orElseThrow(new DataNotFound("Client", id));
        Client client = new Client();
        client.setNoClient(id);
        client.setAdresse(new Adresse());

        // MAPPERS DTO -> BO
        BeanUtils.copyProperties(clientDto, client);
        BeanUtils.copyProperties(clientDto, client.getAdresse());

        Client clientBDD = null;

        try {
            clientBDD = clientRepository.save(client);
        } catch (OptimisticLockingFailureException e) {
            //thrown if entity is assumed to be present but does not exists in db
            throw new DataNotFound("Client", id);
        }

        return clientBDD;
    }

    @Override
    public Client modifierAdresseClient(Long id, AdresseDTO adresseDTO) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new DataNotFound("Client", id));
        BeanUtils.copyProperties(adresseDTO, client.getAdresse());

        adresseRepository.save(client.getAdresse());
        return client;
    }
}
