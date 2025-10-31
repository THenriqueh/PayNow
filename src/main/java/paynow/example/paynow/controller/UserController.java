package paynow.example.paynow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import paynow.example.paynow.domain.user.User;
import paynow.example.paynow.dto.UserDTO;
import paynow.example.paynow.service.UserService;

import java.util.List;

@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO user) {
        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

      List<User> users = this.userService.getAllUsers();
      return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
