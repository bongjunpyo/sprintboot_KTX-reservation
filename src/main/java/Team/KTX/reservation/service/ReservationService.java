package Team.KTX.reservation.service;

import Team.KTX.reservation.domain.Reservation;
import Team.KTX.reservation.dto.AddReservationRequest;
import Team.KTX.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation save(AddReservationRequest request){

        return reservationRepository.save(request.toEntity());
    }
    public List<Reservation> findAll(){
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations;
    }


    public Reservation findOne(long id){

        Reservation reservation= reservationRepository.findById(id).orElseThrow();
        return reservation;
    }

}
