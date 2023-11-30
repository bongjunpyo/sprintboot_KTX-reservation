package Team.KTX.reservation.repository;// ReservationRepository.java

import Team.KTX.reservation.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {


    public List<Reservation> findByWriterId(int writerId);

    public Reservation findByTnumberAndSnumberAndCnumberAndDepartureLocationAndDestinationLocationAndDepartureTimeAndArrivalTime(String tnumber, String snumber, String cnumber, String departureLocation, String destinationLocation, String departureTime,String arrivalTime);


}