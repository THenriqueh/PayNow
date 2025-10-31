package paynow.example.paynow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paynow.example.paynow.domain.user.User;
import paynow.example.paynow.domain.user.UserType;
import paynow.example.paynow.dto.UserDTO;
import paynow.example.paynow.mapper.UserMapper;
import paynow.example.paynow.repository.UserRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Merchants cannot initiate transactions.");
        }

        if(sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("Insufficient balance for the transaction.");
        }
    }

    public User findUserById(Long id) throws Exception {
        return this.userRepository.findById(id).orElseThrow(() -> new Exception("User not found."));
    }

    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    public User createUser(UserDTO data) {
        User newUser = userMapper.toEntity(data);
        return userRepository.save(newUser);
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }
}
