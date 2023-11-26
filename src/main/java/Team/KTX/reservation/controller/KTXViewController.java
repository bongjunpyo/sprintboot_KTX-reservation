package Team.KTX.reservation.controller;

import Team.KTX.reservation.domain.User;
import Team.KTX.reservation.repository.UserRepository;
import Team.KTX.reservation.service.ReservationService;
import Team.KTX.reservation.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import Team.KTX.reservation.domain.Reservation;

import java.util.List;


@Controller
public class KTXViewController {

    @Autowired
    ReservationService reservationService;

    @Autowired
    UserService userService;


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
        User user = userService.findByEmail(userEmail);
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "KTX_Reservation";
    }

    @GetMapping("/KTX_List")
    public ModelAndView showList(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession(true);
        String userId = (String)session.getAttribute("userId");
        ModelAndView mav = new ModelAndView();
        List<Reservation> reservations = reservationService.findByUserId(userId);
        mav.addObject("reservations", reservations);
        mav.setViewName("KTX_List");
        return mav;
    }



}
