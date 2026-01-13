package br.com.financial_service.application.mapper;

import br.com.financial_service.api.dto.request.CreateTransactionRequestDTO;
import br.com.financial_service.api.dto.response.TransactionResponseDTO;
import br.com.financial_service.domain.entity.Transaction;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class TransactionMapper {

    public Transaction toEntity(CreateTransactionRequestDTO dto) {
        Transaction transaction = new Transaction();
        transaction.setType(dto.type());
        transaction.setCategory(dto.category());
        transaction.setAmount(dto.amount());
        transaction.setDescription(dto.description());
        transaction.setDate(dto.date());
        //transaction.setCreatedBy(dto.createdBy());
        transaction.setCreatedBy(UUID.randomUUID());
        transaction.setCreatedAt(LocalDateTime.now());
        transaction.setActive(true);
        return transaction;
    }

    public TransactionResponseDTO toResponse(Transaction entity) {
        return new TransactionResponseDTO(
                entity.getId(),
                entity.getType(),
                entity.getCategory(),
                entity.getAmount(),
                entity.getDescription(),
                entity.getDate(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getActive()
        );
    }
}
