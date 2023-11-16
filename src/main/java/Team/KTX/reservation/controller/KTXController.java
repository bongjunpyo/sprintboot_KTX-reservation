package Team.KTX.reservation.controller;

import Team.KTX.reservation.domain.User;
import Team.KTX.reservation.dto.AddReservationRequest;
import Team.KTX.reservation.dto.AddUserRequest;
import Team.KTX.reservation.repository.UserRepository;
import Team.KTX.reservation.service.ReservationService;
import Team.KTX.reservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class KTXController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private  UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public KTXController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/KTXReservation")
    public ResponseEntity<Reservation> addReservation(@RequestBody AddReservationRequest request){
        Reservation savedReservation = reservationService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedReservation);
    }

    @GetMapping("/api/KTXReservation")
    public ResponseEntity<List<Reservation>> findAllReservation(){
        List<Reservation> reservations = reservationService.findAll();
        return ResponseEntity.ok().body(reservations);

    }

    @GetMapping("/api/KTXReservation/{rid}")
    public ResponseEntity<Reservation> findReservation(@PathVariable long rid){

        Reservation reservation = reservationService.findOne(rid);
        return ResponseEntity.ok().body(reservation);

    }

    @PostMapping("/api/PlusUser")
    public ResponseEntity<User> addUser(@RequestBody AddUserRequest request){
        User savedUser = userService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedUser);
    }


    @PostMapping("/api/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginDetails) {
        String userId = loginDetails.get("userId");
        String password = loginDetails.get("password");

        // 여기서 userService에서 회원정보를 가져오는 코드를 추가해야 합니다.
        User existingUser = userService.getUserByUserId(userId);

        if (existingUser != null && existingUser.getUserId().equals(userId) && existingUser.getPassword().equals(password)) {
            return ResponseEntity.ok("로그인 성공");
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
        }
    }

    @GetMapping("/api/user/{userId}")
    public ResponseEntity<String> getUserId(@PathVariable Long userId) {
        // 여기에서 userId를 사용하여 사용자 정보를 가져오는 코드를 구현해야 합니다.
        // 예를 들어, UserRepository를 사용하여 userId로 사용자를 찾고 사용자의 이름 등을 반환할 수 있습니다.
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get().getName()); // 사용자의 이름 또는 필요한 다른 정보 반환
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}




