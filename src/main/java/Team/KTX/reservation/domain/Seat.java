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

    @Column(name="tnumber", nullable=false) // 열차의 칸 정보 컬럼
    private String tnumber;

    @Column(name="cnumber", nullable=false) // 열차의 칸 정보 컬럼
    private String cnumber;

    @Column(name="snumber", nullable=false)
    private String snumber;

    @Column(name = "departure_location")
    private String departureLocation;

    @Column(name = "destination_location")
    private String destinationLocation;

    @Column(name = "departure_time")
    private String departureTime;

    @Column(name = "arrival_time")
    private String arrivalTime;


    public Long getSeatId() {
        return SeatId;
    }

    public void setSeatId(Long seatId) {
        SeatId = seatId;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    public String getSnumber() {
        return snumber;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getTnumber() {
        return tnumber;
    }

    public void setTnumber(String tnumber) {
        this.tnumber = tnumber;
    }


    public Seat(String tnumber, String snumber, String cnumber, String departureLocation, String destinationLocation, String departureTime, String arrivalTime){
        this.tnumber=tnumber;
        this.snumber=snumber;
        this.cnumber=cnumber;
        this.departureLocation=departureLocation;
        this.destinationLocation=destinationLocation;
        this.departureTime=departureTime;
        this.arrivalTime=arrivalTime;
    }

    public void update(String tnumber, String snumber, String cnumber, String departureLocation, String destinationLocation, String departureTime, String arrivalTime){
        this.tnumber=tnumber;
        this.snumber=snumber;
        this.cnumber=cnumber;
        this.departureLocation=departureLocation;
        this.destinationLocation=destinationLocation;
        this.departureTime=departureTime;
        this.arrivalTime=arrivalTime;
    }
}