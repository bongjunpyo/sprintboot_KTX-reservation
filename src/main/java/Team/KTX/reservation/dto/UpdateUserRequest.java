package Team.KTX.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateUserRequest {

    public String name;
    public int phone;
    public String email;
    public String password;
    public int age;

}
