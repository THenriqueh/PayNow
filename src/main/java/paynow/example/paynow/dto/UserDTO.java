package paynow.example.paynow.dto;

public record UserDTO(
                      String firstName,
                      String lastName,
                      String document,
                      String email,
                      String password,
                      String userType,
                      String balance) {
}
