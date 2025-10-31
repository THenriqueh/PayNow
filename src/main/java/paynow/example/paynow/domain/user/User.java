package paynow.example.paynow.domain.user;

import jakarta.persistence.*;
import lombok.*;
import paynow.example.paynow.dto.UserDTO;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

}
