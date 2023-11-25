package Team.KTX.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateReservationRequest {

    private String tnumber;
    private String snumber;
    private String cnumber;

    private String destinationLocation;
    private String departureLocation;
    private String arrivalTime;
    private String departureTime;
}
