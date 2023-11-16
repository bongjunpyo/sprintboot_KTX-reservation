package Team.KTX.reservation.dto;

import Team.KTX.reservation.domain.User;

public class UserRequest {
    private String userId;

    private String password;

    private String name;
    private String email;


    public User toEntity(){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setUserId(userId);
        user.setName(name);

        return user;
    }

    public String getEmail(){
        return email;
    }

    public String getUserId(){
        return userId;
    }

    public String getPassword(){
        return password;
    }

    public String getName(){
        return name;
    }



    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
