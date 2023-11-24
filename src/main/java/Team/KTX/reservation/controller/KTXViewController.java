package Team.KTX.reservation.controller;

import Team.KTX.reservation.repository.UserRepository;
import Team.KTX.reservation.service.ReservationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class KTXViewController {

    @Autowired
    ReservationService reservationService;


    UserRepository userRepository;
    private Object Reservation;

    @GetMapping("/KTX_Main")
    public String showKTXMainPage() {

        return "KTX_Main";
    }

    @GetMapping("/KTX_Login")
    public String showLoginPage(){

        return "KTX_Login";
    }

    @GetMapping("/KTX_SignUp")
    public String showSignUpPage(){

        return "KTX_SignUp";
    }

    @GetMapping("/KTX_Reservation")
    public String showReservation(Model model, HttpSession session){
        String userEmail=(String) session.getAttribute("userId");
        model.addAttribute("userEmail",userEmail);
        return "KTX_Reservation";
    }

    @GetMapping("/KTX_List")
    public String showList(){

        return "KTX_List";
    }



}
