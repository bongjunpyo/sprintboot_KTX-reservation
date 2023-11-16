package Team.KTX.reservation.controller;

import Team.KTX.reservation.domain.Reservation;
import Team.KTX.reservation.dto.AddReservationRequest;
import Team.KTX.reservation.repository.UserRepository;
import Team.KTX.reservation.service.ReservationService;
import Team.KTX.reservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KTXController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private  UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public KTXController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/KTXReservation")
    public ResponseEntity<Reservation> addReservation(@RequestBody AddReservationRequest request){
        Reservation savedReservation = reservationService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedReservation);
    }

    @GetMapping("/api/KTXReservation")
    public ResponseEntity<List<Reservation>> findAllReservation(){
        List<Reservation> reservations = reservationService.findAll();
        return ResponseEntity.ok().body(reservations);

    }

    @GetMapping("/api/KTXReservation/{rid}")
    public ResponseEntity<Reservation> findReservation(@PathVariable long rid){

        Reservation reservation = reservationService.findOne(rid);
        return ResponseEntity.ok().body(reservation);

    }

}




