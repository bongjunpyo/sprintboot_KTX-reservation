package Team.KTX.reservation.dto;

import Team.KTX.reservation.domain.Reservation;
import Team.KTX.reservation.domain.Seat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddSeatRequest {

    private String tnumber;
    private String snumber;
    private String cnumber;

    private String destinationLocation;
    private String departureLocation;
    private String arrivalTime;
    private String departureTime;

    public Seat toEntity() {
        Seat seat = new Seat(tnumber,snumber,cnumber,departureLocation, destinationLocation, departureTime, arrivalTime);

        return seat;
    }
}
