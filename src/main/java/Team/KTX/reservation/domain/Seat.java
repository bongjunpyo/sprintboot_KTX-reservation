package Team.KTX.reservation.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SeatId")
    private Long SeatId;

    @ManyToOne
    @JoinColumn(name="tnumber", nullable = false)
    private Train train;

    @Column(name="SeatNumber", nullable=false)
    private String SeatNumber;

    @Column(name="SeatStatus", nullable=false)
    private String SeatStatus;

    public void setSeatNumber(String seatNumber) {
        SeatNumber = seatNumber;
    }

    public String getSeatStatus() {
        return SeatStatus;
    }

    public void setSeatStatus(String seatStatus) {
        SeatStatus = seatStatus;
    }

    public String getSeatNumber() {
        return SeatNumber;
    }

    public String getUserName(){
        if(train != null){
            return train.getTnumber();
        }
        else {
            return null;
        }
    }
}