package co.usa.ivanm.reto3.Reto3C3.service;

import co.usa.ivanm.reto3.Reto3C3.model.Client;
import co.usa.ivanm.reto3.Reto3C3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getClient(String idClient) {
        return clientRepository.getClient(idClient);

    }
    public Client save (Client client){
        if(client.getIdClient()==null){
            return clientRepository.save(client);
        }else {
            Optional<Client> pClient=clientRepository.getClient(client.getIdClient());
            if(!pClient.isEmpty()){
                return clientRepository.save(client);
            }else{
                return client;
            }
        }
    }
    public Client update(Client client){
        if (client.getIdClient()!=null ){
            Optional<Client> pClient = clientRepository.getClient(client.getIdClient());
            if(pClient.isEmpty()){
                return clientRepository.save((client));
            }
        }
        return client;
    }
    public boolean deleteClient(String id) {
        Boolean result = getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return result;

    }

}
