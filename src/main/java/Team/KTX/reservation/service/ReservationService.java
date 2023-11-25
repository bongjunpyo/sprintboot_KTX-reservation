package Team.KTX.reservation.service;

import Team.KTX.reservation.domain.Reservation;
import Team.KTX.reservation.domain.User;
import Team.KTX.reservation.dto.AddReservationRequest;
import Team.KTX.reservation.dto.UpdateReservationRequest;
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

    public Reservation save(AddReservationRequest request,String userId){

        Reservation reservation=request.toEntity();
        User user=userRepository.findByEmail(userId);
        reservation.setWriter(user);
        return reservationRepository.save(reservation);
    }

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
    public Reservation update(long id, UpdateReservationRequest request){

        Reservation reservation = reservationRepository.findById(id).orElseThrow();
        reservation.update(request.getTnumber(), request.getSnumber(), request.getCnumber(), request.getDepartureLocation(), request.getDestinationLocation(), request.getDepartureTime(), request.getArrivalTime());
        return reservation;
    }
}
