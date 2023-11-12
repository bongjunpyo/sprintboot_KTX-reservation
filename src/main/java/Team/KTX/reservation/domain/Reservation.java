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
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rid", nullable = false)
    private Long rid;


    @ManyToOne
    @JoinColumn(name="id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name="SeatId", nullable = false)
    private Seat seat;

    @ManyToOne
    @JoinColumn(name="tid", nullable = false)
    private Train train;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Builder
    public Reservation(String PaymentStatus, String ReservationStatus){
        this.title=PaymentStatus;
        this.content=ReservationStatus;
    }
    public void update(String PaymentStatus, String ReservationStatus){
        this.title=PaymentStatus;
        this.content=ReservationStatus;
    }
}
