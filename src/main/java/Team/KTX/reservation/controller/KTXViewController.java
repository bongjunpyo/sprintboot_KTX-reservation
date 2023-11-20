package Team.KTX.reservation.controller;

import Team.KTX.reservation.domain.Train;
import Team.KTX.reservation.repository.TrainRepository;
import Team.KTX.reservation.repository.UserRepository;
import Team.KTX.reservation.service.ReservationService;
import Team.KTX.reservation.service.TrainService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class KTXViewController {

    @Autowired
    ReservationService reservationService;

    TrainRepository trainRepository;

    @Autowired
    TrainService trainService;

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

    @GetMapping("/KTX_LoginedMain")
    public String showLoginedPage(Model model, HttpSession session){
        String userEmail=(String) session.getAttribute("userId");
        model.addAttribute("userEmail",userEmail);
        return "KTX_LoginedMain";
    }


    @GetMapping("/KTX_LoginedMain/KTXList")
    public ModelAndView getTrains() {

        ModelAndView mav = new ModelAndView();
        List<Train> trains = trainService.findAll();
        mav.addObject("trains", trains);
        mav.setViewName("KTX_List");
        return mav;
    }

}
