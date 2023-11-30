package Team.KTX.reservation.service;

import Team.KTX.reservation.domain.Reservation;
import Team.KTX.reservation.domain.User;
import Team.KTX.reservation.dto.AddReservationRequest;
import Team.KTX.reservation.dto.ReservationResponse;
import Team.KTX.reservation.dto.UpdateReservationRequest;
import Team.KTX.reservation.dto.UserResponse;
import Team.KTX.reservation.repository.ReservationRepository;
import Team.KTX.reservation.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {


    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    public ReservationResponse save(AddReservationRequest request,String userId){

        User user = userRepository.findByEmail(userId);

        // 이미 예약된 좌석인지 확인
        Reservation existingReservation = reservationRepository.findByTnumberAndSnumberAndCnumberAndDepartureLocationAndDestinationLocationAndDepartureTimeAndArrivalTime(
                request.getTnumber(), request.getSnumber(), request.getCnumber(), request.getDepartureLocation(), request.getDestinationLocation(), request.getDepartureTime(), request.getArrivalTime());

        // 예약 결과를 나타내는 객체
        ReservationResponse response = new ReservationResponse();
        Reservation savedReservation = new Reservation();

        if (existingReservation != null) {
            // 이미 예약된 좌석 처리
            response.setSuccess(false);
            response.setMessage("이미 예약된 좌석입니다. 다른 좌석을 선택해 주세요.");
            return response;
        } else {
            // 좌석이 사용 가능한 경우 예약 저장 진행
            Reservation reservation = request.toEntity();
            reservation.setWriter(user);
            savedReservation = reservationRepository.save(reservation);

            // 예약 성공 처리
            response.setSuccess(true);
            response.setMessage("예약이 완료되었습니다.");
            return response;
        }

        // 여기서 response 객체를 반환하거나, 저장된 Reservation 객체를 반환할 수 있습니다.
    }

    // 여기서 response 객체를 반환하거나, 저장된 Reservation 객체를 반환할 수 있음
    // 예를 들어, 저장된 Reservation을 반환하려면 return savedReservation; 사용

    public List<Reservation> findAll(){
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations;
    }
    public List<Reservation> findByUserId(String userId){
        User user=userRepository.findByEmail(userId);
        List<Reservation> reservations = reservationRepository.findByWriterId(user.getId());
        return reservations;
    }

    public Reservation findOne(long id){
        Reservation reservation = reservationRepository.findById(id).orElseThrow();
        return reservation;
    }

    public void delete(long id){

        reservationRepository.deleteById(id);
    }


    @Transactional
    public ReservationResponse update(long id, UpdateReservationRequest request){

        Reservation reservation = reservationRepository.findById(id).orElseThrow();


        Reservation existingReservation = reservationRepository.findByTnumberAndSnumberAndCnumberAndDepartureLocationAndDestinationLocationAndDepartureTimeAndArrivalTime(
                request.getTnumber(), request.getSnumber(), request.getCnumber(), request.getDepartureLocation(), request.getDestinationLocation(), request.getDepartureTime(), request.getArrivalTime());

        ReservationResponse response = new ReservationResponse();
        Reservation savedReservation = new Reservation();

        if (existingReservation != null) {
            // 이미 예약된 좌석 처리
            response.setSuccess(false);
            response.setMessage("이미 예약된 좌석입니다. 다른 좌석을 선택해 주세요.");
            return response;
        } else {
            // 좌석이 사용 가능한 경우 예약 저장 진R
            reservation.update(request.getTnumber(), request.getSnumber(), request.getCnumber(), request.getDepartureLocation(), request.getDestinationLocation(), request.getDepartureTime(), request.getArrivalTime());
            response.setSuccess(true);
            response.setMessage("예약이 수정되었습니다.");
            return response;
        }
    }
}
