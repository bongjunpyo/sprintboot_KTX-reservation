package Team.KTX.reservation.service;

import Team.KTX.reservation.domain.User;
import Team.KTX.reservation.dto.AddUserRequest;
import Team.KTX.reservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;



    public User save(AddUserRequest request){

        return userRepository.save(request.toEntity());
    }
}
