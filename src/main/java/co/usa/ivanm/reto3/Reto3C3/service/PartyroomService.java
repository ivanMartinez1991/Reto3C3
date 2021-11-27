package co.usa.ivanm.reto3.Reto3C3.service;

import co.usa.ivanm.reto3.Reto3C3.model.Partyroom;
import co.usa.ivanm.reto3.Reto3C3.repository.PartyroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartyroomService {
    @Autowired
    private PartyroomRepository partyroomRepository;

    public List<Partyroom> getAll(){
        return partyroomRepository.getAll();
    }
    public Optional<Partyroom> getPartyroom(int id) {
        return partyroomRepository.getPartyroom(id);

    }
    public Partyroom save (Partyroom partyroom){
        if(partyroom.getId()==null){
            return partyroomRepository.save(partyroom);
        }else {
            Optional<Partyroom> Party=partyroomRepository.getPartyroom(partyroom.getId());
            if(!Party.isEmpty()){
                return partyroomRepository.save(partyroom);
            }else{
                return partyroom;
            }
        }
    }
    public Partyroom update(Partyroom partyroom){
        if (partyroom.getId()!=null ){
            Optional<Partyroom> Party = partyroomRepository.getPartyroom(partyroom.getId());
            if(Party.isEmpty()){
                return partyroomRepository.save((partyroom));
            }
        }
        return partyroom;
    }
    public boolean deletePartyroom(int id) {
        Boolean result = getPartyroom(id).map(partyroom -> {
            partyroomRepository.delete(partyroom);
            return true;
        }).orElse(false);
        return result;

    }
}
