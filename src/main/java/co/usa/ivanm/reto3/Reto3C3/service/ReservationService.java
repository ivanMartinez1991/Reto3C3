package co.usa.ivanm.reto3.Reto3C3.service;
import co.usa.ivanm.reto3.Reto3C3.model.Reservation;
import co.usa.ivanm.reto3.Reto3C3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int idReservation) {
        return reservationRepository.getReservation(idReservation);

    }
    public Reservation save (Reservation reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        }else {
            Optional<Reservation> tmpReserv=reservationRepository.getReservation(reservation.getIdReservation());
            if(!tmpReserv.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    public Reservation update(Reservation reservation){
        if (reservation.getIdReservation()!=null ){
            Optional<Reservation> tmpReserv= reservationRepository.getReservation(reservation.getIdReservation());
            if(tmpReserv.isEmpty()){
                return reservationRepository.save((reservation));
            }
        }
        return reservation;
    }
    public boolean deleteReservation(int id) {
        Boolean result = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return result;

    }

}
