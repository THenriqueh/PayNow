package paynow.example.paynow.dto;

import paynow.example.paynow.domain.user.UserType;

import java.math.BigDecimal;

public record UserDTO(Long id,
                      String firstName,
                      String lastName,
                      String document,
                      String email,
                      String password,
                      UserType userType,
                      BigDecimal balance) {
}
