package Team.KTX.reservation.domain;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rid", nullable = false)
    private int rid;


    @ManyToOne
    @JoinColumn(name="SeatNumber")
    private Seat seat;


    @Column(name = "payment")
    private String payment;

    @Column(name = "rstatus")
    private String rstatus;

    /*@ManyToOne
    @JoinColumn(name="email", nullable = false, unique = true)
    private User user;
    */
    @Builder
    public Reservation(String PaymentStatus, String ReservationStatus){
        this.payment = PaymentStatus;
        this.rstatus = ReservationStatus;
    }
    public void update(String PaymentStatus, String ReservationStatus){
        this.payment = PaymentStatus;
        this.rstatus = ReservationStatus;
    }

    public String getSeatNumber() {
        if (seat != null) {
            return seat.getSeatNumber();
        } else {
            return null; // seat가 null인 경우 처리 로직 추가
        }
    }


}