package co.usa.ivanm.reto3.Reto3C3.repository;
import co.usa.ivanm.reto3.Reto3C3.crudrepository.ClientCrudRepository;
import co.usa.ivanm.reto3.Reto3C3.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll() {
        return (List<Client>) clientCrudRepository.findAll();
    }
    public Optional<Client> getClient(Integer id){
        return clientCrudRepository.findById(id);
    }
    public Client save(Client client){
        return clientCrudRepository.save(client);
    }
    public void delete(Client client){
        clientCrudRepository.delete(client);
    }
}

