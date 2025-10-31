package paynow.example.paynow.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import paynow.example.paynow.dto.UserDTO;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "users")
@Table(name = "users")
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    private BigDecimal balance;

    public User(UserDTO data) {
    }

    public void user(UserDTO data) {
        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.document = data.document();
        this.email = data.email();
        this.password = data.password();
        this.userType = UserType.valueOf(data.userType());
        this.balance = new BigDecimal(data.balance());
    }

}
