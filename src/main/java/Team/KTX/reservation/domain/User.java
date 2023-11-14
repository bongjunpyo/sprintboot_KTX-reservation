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

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="userId")
    private String userId;

    @Column(name="password")
    private String password;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="number")
    private String number;

    @Builder
    public User(String userId, String password, String name, String email, String number){
        this.userId=userId;
        this.password=password;
        this.name=name;
        this.email=email;
        this.number=number;
    }
}
