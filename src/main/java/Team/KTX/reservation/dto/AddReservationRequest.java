package Team.KTX.reservation.dto;

import Team.KTX.reservation.domain.Reservation;

public class AddReservationRequest {

    private Integer trainNumber;
    private String departureLocation;
    private String destinationLocation;
    private String departureTime;
    private String arrivalTime;

    // 생성자, Getter, Setter 등...

    public Integer getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(Integer trainNumber) {
        this.trainNumber = trainNumber;
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

    public Reservation toEntity() {
        Reservation reservation = new Reservation();
        reservation.setTrainNumber(trainNumber);
        reservation.setDepartureLocation(departureLocation);
        reservation.setDestinationLocation(destinationLocation);
        reservation.setDepartureTime(departureTime);
        reservation.setArrivalTime(arrivalTime);
        return reservation;
    }
}
