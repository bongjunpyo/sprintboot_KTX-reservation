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
    public ModelAndView showKTXMainPage(Model model, HttpServletRequest httpServletRequest, HttpSession session) {
        session = httpServletRequest.getSession(true);
        String userEmail = (String)session.getAttribute("userId");
        User user = userService.findByEmail(userEmail);
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        ModelAndView mav=new ModelAndView();
        boolean isLoggedIn=session.getAttribute("userId") !=null;
        mav.addObject("isLoggedIn", isLoggedIn);
        mav.setViewName("KTX_Main");
        return mav;
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
    public ModelAndView showList(Model model, HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession(true);
        String userEmail = (String)session.getAttribute("userId");
        User user = userService.findByEmail(userEmail);
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        ModelAndView mav = new ModelAndView();
        List<Reservation> reservations = reservationService.findByUserId(userEmail);
        mav.addObject("reservations", reservations);
        mav.setViewName("KTX_List");
        return mav;
    }

    @GetMapping("/KTX_UserInfo")
    public ModelAndView showUserInfo(Model model, HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession(true);
        String userEmail = (String)session.getAttribute("userId");
        User user = userService.findByEmail(userEmail);
        if (user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("UserEmail", user.getEmail());
            model.addAttribute("password", user.getPassword());
            model.addAttribute("age", user.getAge());
            model.addAttribute("phone", user.getPhone());

        }
        ModelAndView mav = new ModelAndView();
        boolean isLoggedIn=session.getAttribute("userId") !=null;
        mav.addObject("isLoggedIn", isLoggedIn);
        mav.setViewName("UserInfo");
        return mav;

    }

    @GetMapping("/KTX_ModifyInfo")
    public ModelAndView modifyUserInfo(Model model, HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession(true);
        String userEmail = (String)session.getAttribute("userId");
        User user = userService.findByEmail(userEmail);

        if (user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("UserEmail", user.getEmail());
            model.addAttribute("password", user.getPassword());
            model.addAttribute("age", user.getAge());
            model.addAttribute("phone", user.getPhone());
        }

        boolean isLoggedIn = session.getAttribute("userId") != null;
        ModelAndView mav = new ModelAndView();
        mav.addObject("isLoggedIn", isLoggedIn);
        mav.setViewName("ModifyUserInfo"); // 수정된 화면 이름으로 변경
        return mav;

    }



}
