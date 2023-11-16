package Team.KTX.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddReservationRequest {

    private String payment;
    private String rstatus;


    public Reservation toEntity(){
        Reservation reservation = new Reservation(payment,rstatus);
        return reservation;
    }

}
