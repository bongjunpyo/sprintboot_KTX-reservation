package Team.KTX.reservation.dto;

import Team.KTX.reservation.domain.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddReservationRequest {

    private String title;
    private String content;

    public Reservation toEntity(){
        Reservation reservation = new Reservation(title, content);
        return reservation;
    }
}
