package Team.KTX.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateUserRequest {

    private String name;

    private int phone;

    private String email;

    private String password;

    private int age;

}
