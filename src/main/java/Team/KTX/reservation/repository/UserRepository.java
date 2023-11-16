package Team.KTX.reservation.repository;

import Team.KTX.reservation.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByUserId(String userId);

    public User findByUserIdAndPasswordAndNameAndEmail(String userId,String password,String name,String email);
}
