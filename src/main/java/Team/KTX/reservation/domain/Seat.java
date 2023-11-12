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
    @JoinColumn(name="tid", nullable = false)
    public Train train;


    @Column(name="SeatNumber", nullable=false)
    private String SeatNumber;

    @Column(name="SeatStatus", nullable=false)
    private String SeatStatus;
}
