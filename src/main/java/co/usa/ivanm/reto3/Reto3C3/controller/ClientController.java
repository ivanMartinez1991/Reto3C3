package co.usa.ivanm.reto3.Reto3C3.controller;
import co.usa.ivanm.reto3.Reto3C3.model.Client;
import co.usa.ivanm.reto3.Reto3C3.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all") public List<Client> getAll(){
        return clientService.getAll();
    }
    @GetMapping("/{idClient}")
    public Optional<Client> getClient(@PathVariable("idClient") Integer idClient){
        return clientService.getClient(idClient);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client){
        return clientService.save(client);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client){
        return clientService.update(client);
    }
    @DeleteMapping("/{idClient}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("idClient")Integer idClient){
        return clientService.deleteClient(idClient);
    }

}
