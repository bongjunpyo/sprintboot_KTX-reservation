package Team.KTX.reservation.service;

import Team.KTX.reservation.domain.User;
import Team.KTX.reservation.dto.AddUserRequest;
import Team.KTX.reservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;


    public User save(AddUserRequest request){

        return userRepository.save(request.toEntity());
    }

    public User getUserByUserId(String userId) {
        // 여기서는 예시로 UserRepository에서 userId를 이용하여 사용자 정보를 가져오는 코드를 사용합니다.
        return userRepository.findByUserId(userId); // userRepository는 실제 UserRepository 인터페이스에 의존합니다.
    }

}
