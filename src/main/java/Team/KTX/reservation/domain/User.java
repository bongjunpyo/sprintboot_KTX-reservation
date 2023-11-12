package Team.KTX.reservation.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="SeatId", nullable = false)
    private Seat seat;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="phoneNumber")
    private String phoneNumber;

    @Builder
    public User(String name, String email, String phoneNumber){
        this.name= name;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }
}
