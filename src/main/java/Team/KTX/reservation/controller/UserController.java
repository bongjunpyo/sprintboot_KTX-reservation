package Team.KTX.reservation.controller;

import Team.KTX.reservation.dto.UserRequest;
import Team.KTX.reservation.dto.UserResponse;
import Team.KTX.reservation.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/api/session-status")
    public String getSessionStatus(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // 세션이 없으면 새로 생성하지 않고 null 반환

        if (session != null && session.getAttribute("userId") != null) {
            // 세션이 있고, userId가 세션에 저장되어 있는 경우 - 로그인 상태
            return "loggedIn";
        } else {
            // 세션이 없거나 userId가 저장되어 있지 않은 경우 - 로그인되지 않은 상태
            return "notLoggedIn";
        }
    }
}
