package Team.KTX.reservation.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tid", nullable = false)
    public Long tid;

    @Column(name="tnumber", nullable = false)
    private String tnumber;

    @Column(name="departure", nullable=false)
    private String departure;

    @Column(name="destination",nullable=false)
    private String destination;


    @Column(name="departuretime", nullable=false, columnDefinition = "TimeSTAMP(0) default CURRENT_TIMESTAMP")
    private LocalDateTime departureTime;

    @Column(name="arrivaltime", nullable=false, columnDefinition = "TimeSTAMP(0) default CURRENT_TIMESTAMP")
    private LocalDateTime arrivalTime;

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    private List<Seat> seats;




    @Builder
    public Train(String tnumber, String departure, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime, List<Seat> seats){
        this.tnumber = tnumber;
        this.departure= departure;
        this.destination=destination;
        this.departureTime=departureTime;
        this.arrivalTime=arrivalTime;

        this.seats = seats;
    }
}
