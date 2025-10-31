package paynow.example.paynow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import paynow.example.paynow.domain.transaction.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
