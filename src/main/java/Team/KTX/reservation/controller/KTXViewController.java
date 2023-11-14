package Team.KTX.reservation.controller;

import Team.KTX.reservation.domain.User;
import Team.KTX.reservation.repository.TrainRepository;
import Team.KTX.reservation.repository.UserRepository;
import Team.KTX.reservation.service.ReservationService;
import Team.KTX.reservation.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class KTXViewController {

    @Autowired
    ReservationService reservationService;

    TrainRepository trainRepository;
    TrainService trainService;

    UserRepository userRepository;

    @GetMapping("/KTX_Main")
    public String showKTXMainPage() {
       return "KTX_Main";
    }

    /*@GetMapping("/KTX_Login")*/

    @GetMapping("/KTX_SignUp")
    public String showSignUpPage() {
        return "KTX_SignUp"; // 회원가입 페이지의 이름 (예: sign_up.html)
    }

    @PostMapping("/KTX_SignUp")
    public String signUp(@RequestParam("userId") String userId,
                         @RequestParam("password") String password,
                         @RequestParam("name") String name,
                         @RequestParam("email") String email,
                         @RequestParam("phoneNumber") String phoneNumber) {
        // 사용자 정보를 저장하기 위해 UserRepository를 사용하여 데이터베이스에 저장
        User user = new User(userId,password,name,email,phoneNumber);
        userRepository.save(user);

        return "redirect:/KTX_Main"; // 회원가입 후 메인 페이지로 리다이렉트
    }

}
