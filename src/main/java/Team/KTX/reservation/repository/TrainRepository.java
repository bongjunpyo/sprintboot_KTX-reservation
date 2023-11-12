package Team.KTX.reservation.repository;

import Team.KTX.reservation.domain.Train;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainRepository extends JpaRepository<Train, Long> {

    Optional<Train> findByTnumber(String tnumber);
}
