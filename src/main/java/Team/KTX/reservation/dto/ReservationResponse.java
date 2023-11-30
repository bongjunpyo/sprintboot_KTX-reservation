package Team.KTX.reservation.dto;

import Team.KTX.reservation.domain.User;

public class ReservationResponse {

    private boolean success;  //성공 여부 판별
    private String message;

    private User user;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
