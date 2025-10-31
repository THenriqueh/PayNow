package paynow.example.paynow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import paynow.example.paynow.domain.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByDocument(String document);

    Optional<User> findById(String id);
}