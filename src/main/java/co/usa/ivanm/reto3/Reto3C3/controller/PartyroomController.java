package co.usa.ivanm.reto3.Reto3C3.controller;

import co.usa.ivanm.reto3.Reto3C3.model.Partyroom;
import co.usa.ivanm.reto3.Reto3C3.service.PartyroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Partyroom")
public class PartyroomController {
    @Autowired
    private PartyroomService partyroomService;

    @GetMapping("/all") public List<Partyroom> getAll(){
        return partyroomService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Partyroom> getPartyroom(@PathVariable("id") int id){
        return partyroomService.getPartyroom(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Partyroom save(@RequestBody Partyroom partyroom){
        return partyroomService.save(partyroom);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Partyroom update(@RequestBody Partyroom partyroom){
        return partyroomService.update(partyroom);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id){
        return partyroomService.deletePartyroom(id);
    }


}
