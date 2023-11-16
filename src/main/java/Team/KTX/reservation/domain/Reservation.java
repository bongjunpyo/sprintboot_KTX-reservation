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
    @JoinColumn(name="name")
    private User user;

    @OneToOne
    @JoinColumn(name="SeatNumber")
    private Seat seat;

    @ManyToOne
    @JoinColumn(name="tnumber")
    private Train train;

    @Column(name = "payment")
    private String payment;

    @Column(name = "rstatus")
    private String rstatus;

    @Builder
    public Reservation(String PaymentStatus, String ReservationStatus){
        this.payment = PaymentStatus;
        this.rstatus = ReservationStatus;
    }
    public void update(String PaymentStatus, String ReservationStatus){
        this.payment = PaymentStatus;
        this.rstatus = ReservationStatus;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getRstatus() {
        return rstatus;
    }

    public void setRstatus(String rstatus) {
        this.rstatus = rstatus;
    }
}
