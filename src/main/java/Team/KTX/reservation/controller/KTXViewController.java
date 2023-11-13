package Team.KTX.reservation.controller;

import Team.KTX.reservation.domain.Reservation;
import Team.KTX.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class KTXViewController {
    @Autowired
    ReservationService reservationService;

    @GetMapping("/KTXReservation")
    public ModelAndView getReservations(){
        ModelAndView mav = new ModelAndView();
        List<Reservation> reservations = reservationService.findAll();
        mav.addObject("reservations",reservations);
        mav.setViewName("reservation");
        return mav;
    }
}
