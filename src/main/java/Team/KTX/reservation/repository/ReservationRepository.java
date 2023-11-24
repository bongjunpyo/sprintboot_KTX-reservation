package Team.KTX.reservation.repository;// ReservationRepository.java

import Team.KTX.reservation.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {


    public Reservation findByTrainNumber(int trainNumber);


    public Reservation findByDepartureLocationAndDestinationLocation(String departureLocation, String destinationLocation);


    public Reservation findByDepartureTimeAndArrivalTime(String departureTime, String arrivalTime);



}
