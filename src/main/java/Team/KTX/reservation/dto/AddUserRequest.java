package Team.KTX.reservation.dto;

import Team.KTX.reservation.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddUserRequest {

    private String userId;
    private String password;
    private String name;
    private String email;
    private String number;

    public User toEntity(){
        User user = new User(userId,password,name,email,number);
        return user;
    }
}
