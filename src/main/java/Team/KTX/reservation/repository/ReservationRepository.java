package Team.KTX.reservation.repository;// ReservationRepository.java

import Team.KTX.reservation.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // 특정 열차 번호에 대한 예약 조회
    public Reservation findByTrainNumber(int trainNumber);

    // 출발지와 목적지에 대한 예약 조회
    public Reservation findByDepartureLocationAndDestinationLocation(String departureLocation, String destinationLocation);

    // 출발 시간과 도착 시간에 대한 예약 조회
    public Reservation findByDepartureTimeAndArrivalTime(String departureTime, String arrivalTime);

    // 추가적인 필요에 따라 다양한 메서드 추가 가능

}
