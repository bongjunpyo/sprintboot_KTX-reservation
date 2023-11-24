package Team.KTX.reservation.controller;

import Team.KTX.reservation.repository.UserRepository;
import Team.KTX.reservation.service.ReservationService;
import Team.KTX.reservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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





}




