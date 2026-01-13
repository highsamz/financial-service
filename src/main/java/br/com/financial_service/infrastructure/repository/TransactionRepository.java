package br.com.financial_service.infrastructure.repository;

import br.com.financial_service.domain.entity.Transaction;
import br.com.financial_service.domain.enums.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    List<Transaction> findByActiveTrue();

    List<Transaction> findByTypeAndActiveTrue(TransactionType type);

    List<Transaction> findByDateBetweenAndActiveTrue(LocalDate start, LocalDate end);

    List<Transaction> findByCreatedByAndActiveTrue(UUID userId);
}
