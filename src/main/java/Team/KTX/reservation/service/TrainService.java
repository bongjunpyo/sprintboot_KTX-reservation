package Team.KTX.reservation.service;


import Team.KTX.reservation.domain.Train;
import Team.KTX.reservation.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TrainService implements ApplicationRunner {

    private final TrainRepository trainRepository;

    @Autowired
    public TrainService(TrainRepository trainRepository) {

        this.trainRepository = trainRepository;
    }


    @Override
    public void run(ApplicationArguments args){

        Train train1 = new Train("KTX001", "서울", "부산"
                , LocalDateTime.of(2023, 11, 12, 5, 12)
                , LocalDateTime.of(2023, 11, 12, 7, 49));

        Train train2 = new Train("KTX161", "동대구", "서울"
                , LocalDateTime.of(2023, 11, 12, 5, 38)
                , LocalDateTime.of(2023, 11, 12, 7, 28));


        if (!trainRepository.findByTnumber(train1.getTnumber()).isPresent()) {
            trainRepository.save(train1);
        }
        if (!trainRepository.findByTnumber(train2.getTnumber()).isPresent()) {
            trainRepository.save(train2);
        }
    }
}
