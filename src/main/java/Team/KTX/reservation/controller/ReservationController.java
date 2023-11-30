package Team.KTX.reservation.controller;

import Team.KTX.reservation.domain.Reservation;
import Team.KTX.reservation.domain.Seat;
import Team.KTX.reservation.dto.AddReservationRequest;
import Team.KTX.reservation.dto.AddSeatRequest;
import Team.KTX.reservation.dto.ReservationResponse;
import Team.KTX.reservation.dto.UpdateReservationRequest;
import Team.KTX.reservation.service.ReservationService;
import Team.KTX.reservation.service.SeatService;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private SeatService seatService;


    @PostMapping("/api/reservations")
    public ResponseEntity<ReservationResponse> addReservation(@RequestBody AddReservationRequest request, HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession(true);
        String userId = (String) session.getAttribute("userId");

        if (userId == null) {
            return ResponseEntity.badRequest().body(null);
        }

        ReservationResponse response = reservationService.save(request, userId);
        if (response.isSuccess()) {
            return ResponseEntity.ok().body(response);
        } else {
            return ResponseEntity.ok().body(response);
        }
    }


    @GetMapping("/api/reservations")
    public ResponseEntity<List<Reservation>> findAllReservation(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession(true);
        String userId= (String)session.getAttribute("userId");
        List<Reservation> userReservations = reservationService.findByUserId(userId);

        return ResponseEntity.ok().body(userReservations);
    }

    //@GetMapping("/api/reservations/{rid}")
    //public ResponseEntity<Reservation> findReservation(@PathVariable long rid){
     //   Reservation reservation = reservationService.findOne(rid);
       // return ResponseEntity.ok().body(reservation);
    //}

    @DeleteMapping("/api/reservations/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable long id){
        reservationService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/reservations/{id}")
    public ResponseEntity<ReservationResponse> updateReservation(@PathVariable long id, @RequestBody UpdateReservationRequest request){


        ReservationResponse response = reservationService.update(id,request);
        if (response.isSuccess()) {
            return ResponseEntity.ok().body(response);
        } else {
            return ResponseEntity.ok().body(response);
        }
    }
}
