package Team.KTX.reservation.service;


import Team.KTX.reservation.domain.Seat;
import Team.KTX.reservation.domain.Train;
import Team.KTX.reservation.repository.TrainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrainService implements ApplicationRunner {

    @Autowired
    private TrainRepository trainRepository;
    private List<Seat> seats; // 이 부분에서 seats 초기화가 필요


    @Override
    public void run(ApplicationArguments args){

        Train train1 = new Train("KTX001", "서울", "부산"
                , LocalDateTime.of(2023, 11, 12, 5, 12)
                , LocalDateTime.of(2023, 11, 12, 7, 49), seats);

        Train train2 = new Train("KTX161", "동대구", "서울"
                , LocalDateTime.of(2023, 11, 12, 5, 38)
                , LocalDateTime.of(2023, 11, 12, 7, 28), seats);


        if (!trainRepository.findByTnumber(train1.getTnumber()).isPresent()) {
            trainRepository.save(train1);
        }
        if (!trainRepository.findByTnumber(train2.getTnumber()).isPresent()) {
            trainRepository.save(train2);
        }
    }

    public List<Train> findAll(){
        List<Train> trains=trainRepository.findAll();
        return trains;
    }

}
