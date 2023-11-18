package Team.KTX.reservation.controller;

import Team.KTX.reservation.domain.Reservation;
import Team.KTX.reservation.domain.Train;
import Team.KTX.reservation.dto.AddReservationRequest;
import Team.KTX.reservation.repository.UserRepository;
import Team.KTX.reservation.service.ReservationService;
import Team.KTX.reservation.service.TrainService;
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
    private TrainService trainService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public KTXController(UserService userService, TrainService trainService) {

        this.userService = userService;
        this.trainService = trainService;
    }

    @GetMapping("/api/trains")
    public ResponseEntity<List<Train>> findAllTrain(){
        List<Train> trains=trainService.findAll();
        return ResponseEntity.ok().body(trains);
    }



}




