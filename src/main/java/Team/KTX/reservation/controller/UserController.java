package Team.KTX.reservation.controller;

import Team.KTX.reservation.dto.UserRequest;
import Team.KTX.reservation.dto.UserResponse;
import Team.KTX.reservation.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/api/join")
    public ResponseEntity<UserResponse> join(@RequestBody UserRequest request){
        UserResponse response=userService.join(request);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/api/login")
    public ResponseEntity<UserResponse> login(@RequestBody UserRequest request,
                                              HttpServletRequest httpServletRequest){  //httpServletRequest : 웹브라우저에서 오는 데이터를 객체화 시켜서 가지고 있는 오브젝트(웹브라우저에서 온 모든 데이터가 들어있음)
        UserResponse response=userService.login(request);
        HttpSession session= httpServletRequest.getSession(true);


        //로그인이 실패한 경우
        if(!response.isSuccess()){
            return ResponseEntity.ok().body(response);
        }

        //로그인이 성공한 경우
        session.setAttribute("userId", response.getUser().getEmail());
        return ResponseEntity.ok().body(response);


    }

    @GetMapping("/api/login")  // 수정 필요한 부분: 매핑되는 엔드포인트
    public String name(Model model) {
        // 여기서 userName 값을 설정합니다. 이 값은 서비스 계층에서 가져와야 합니다.
        // 예를 들어, 세션에서 가져오거나, 사용자 정보를 저장한 데이터베이스 등에서 가져올 수 있습니다.
        String userName = "name";  // 실제 값으로 대체

        System.out.println("userName: " + userName);
        model.addAttribute("userName", userName);

        return "KTX_Reservation";  // 수정 필요한 부분: Thymeleaf 템플릿 이름
    }

}
