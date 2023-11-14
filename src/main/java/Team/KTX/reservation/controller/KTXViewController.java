package Team.KTX.reservation.controller;

import Team.KTX.reservation.repository.TrainRepository;
import Team.KTX.reservation.service.ReservationService;
import Team.KTX.reservation.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class KTXViewController {

    @Autowired
    ReservationService reservationService;

    TrainRepository trainRepository;
    TrainService trainService;

    @GetMapping("/KTXMain")
    public String showKTXMainPage() {
       return "KTX_Main";
    }

}
