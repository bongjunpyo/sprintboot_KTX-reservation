package Team.KTX.reservation.dto;

import Team.KTX.reservation.domain.User;

public class UserRequest {

    private String email;

    private String password;

    private String name;
    private int age;
    private int phone;

    public User toEntity(){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        user.setAge(String.valueOf(age));
        user.setPhone(phone);
        return user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = Integer.parseInt(age);
    }
    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = Integer.parseInt(String.valueOf(phone));
    }
}
