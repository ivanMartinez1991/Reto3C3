package co.usa.ivanm.reto3.Reto3C3.controller;
import co.usa.ivanm.reto3.Reto3C3.model.Reservation;
import co.usa.ivanm.reto3.Reto3C3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all") public List<Reservation> getAll(){
        return reservationService.getAll();
    }
    @GetMapping("/{idReservation}")
    public Optional<Reservation> getReservation(@PathVariable("idReservation") int idReservation){
        return reservationService.getReservation(idReservation);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }
    @DeleteMapping("/{idReservation}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("idReservation")int idReservation){
        return reservationService.deleteReservation(idReservation);
    }

}
