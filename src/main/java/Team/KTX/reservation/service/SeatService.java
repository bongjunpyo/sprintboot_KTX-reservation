package Team.KTX.reservation.service;

import Team.KTX.reservation.domain.Seat;
import Team.KTX.reservation.dto.AddSeatRequest;
import Team.KTX.reservation.dto.UpdateSeatRequest;
import Team.KTX.reservation.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public Seat save(AddSeatRequest request){
        return seatRepository.save(request.toEntity());
    }

    public void delete(long id){

        seatRepository.deleteById(id);
    }

    @Transactional
    public Seat update(long id, UpdateSeatRequest request){

        Seat seat= seatRepository.findById(id).orElseThrow();
        seat.update(request.getTnumber(), request.getSnumber(), request.getCnumber(), request.getDepartureLocation(), request.getDestinationLocation(), request.getDepartureTime(), request.getArrivalTime());
        return seat;
    }
}
