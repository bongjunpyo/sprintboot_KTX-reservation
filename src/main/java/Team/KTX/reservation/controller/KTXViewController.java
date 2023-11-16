package Team.KTX.reservation.controller;

import Team.KTX.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import Team.KTX.reservation.domain.User;
import Team.KTX.reservation.repository.TrainRepository;
import Team.KTX.reservation.repository.UserRepository;
import Team.KTX.reservation.service.TrainService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


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
        User user = new User(userId, password, name, email, phoneNumber);
        userRepository.save(user);

        return "redirect:/KTX_Main"; // 회원가입 후 메인 페이지로 리다이렉트
    }

    @GetMapping("/KTX_Login")
    public String showLoginPage() {

        return "KTX_Login";
    }

    @GetMapping("/KTX/{userId}")
    public String showLoginedPage(@PathVariable String userId) {
        // 여기서 userId 변수를 활용하여 해당 사용자에 대한 처리를 수행할 수 있습니다.
        // 예를 들어, 해당 ID에 해당하는 정보를 조회하거나 페이지를 렌더링할 수 있습니다.
        return "KTX_LoggedInPage"; // 적절한 뷰 페이지 이름을 반환하도록 수정해주세요.
    }
}
