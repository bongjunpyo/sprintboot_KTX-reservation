package Team.KTX.reservation.service;

import Team.KTX.reservation.domain.User;
import Team.KTX.reservation.dto.UpdateUserRequest;
import Team.KTX.reservation.dto.UserRequest;
import Team.KTX.reservation.dto.UserResponse;
import Team.KTX.reservation.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;


    public UserResponse join(UserRequest request){
        User checkUser=userRepository.findByEmail(request.getEmail());

        UserResponse response=new UserResponse();

        if(checkUser!=null){ //이미 가입된 이메일이 있는 경우
            response.setSuccess(false); //성공 여부의 값을 false로 설정
            response.setMessage("이미 가입된 이메일입니다.");
            return response;
        }
        //가입된 이메일이 없는 경우
        userRepository.save(request.toEntity()); //사용자가 입력한 데이터를 그대로 DB에 넣음.
        response.setSuccess(true);
        response.setMessage("회원가입이 완료되었습니다.");
        return response;
    }

    public UserResponse login(UserRequest request){

        UserResponse response=new UserResponse();
        User checkUser=userRepository
                .findByEmailAndPassword(request.getEmail(), request.getPassword());

        if(checkUser==null){  //아이디 또는 패스워드가 틀렸을 경우
            response.setSuccess(false);
            response.setMessage("아이디 또는 패스워드가 틀렸습니다.");
            return response;
        }

        //아이디 또는 패스워드가 맞았을 경우
        response.setSuccess(true);
        response.setMessage("로그인 성공");
        response.setUser(checkUser);
        return response;
    }

    public User findByEmail(String email) {
            return userRepository.findByEmail(email);
    }

    @Transactional
    public User updateUserInfo(HttpServletRequest httpServletRequest, UpdateUserRequest request) {
        HttpSession session = httpServletRequest.getSession(true);
        String userEmail = (String) session.getAttribute("userId");
        User user = userRepository.findByEmail(userEmail);

        if (user != null) {
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            user.setName(request.getName());
            user.setAge(request.getAge());
            user.setPhone(request.getPhone());
            return userRepository.save(user);
        } else {
            return null;
        }
    }

}
