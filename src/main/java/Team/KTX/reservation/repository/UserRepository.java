package Team.KTX.reservation.repository;

import Team.KTX.reservation.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
