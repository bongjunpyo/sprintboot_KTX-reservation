package Team.KTX.reservation.dto;

import Team.KTX.reservation.domain.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddReservationRequest {

    private String tnumber;
    private String snumber;
    private String cnumber;

    private String destinationLocation;
    private String departureLocation;
    private String arrivalTime;
    private String departureTime;

    public Reservation toEntity() {
        Reservation reservation = new Reservation(tnumber,snumber,cnumber,departureLocation, destinationLocation, departureTime, arrivalTime);

        return reservation;
    }
}
