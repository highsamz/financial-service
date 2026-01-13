package br.com.financial_service.application.service;

import br.com.financial_service.api.dto.request.CreateTransactionRequestDTO;
import br.com.financial_service.api.dto.response.TransactionResponseDTO;
import br.com.financial_service.application.mapper.TransactionMapper;
import br.com.financial_service.domain.entity.Transaction;
import br.com.financial_service.domain.enums.TransactionType;
import br.com.financial_service.infrastructure.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository repository;
    private final TransactionMapper mapper;

    public TransactionResponseDTO create(CreateTransactionRequestDTO dto) {
        validateAmount(dto.amount());

        Transaction transaction = mapper.toEntity(dto);
        return mapper.toResponse(repository.save(transaction));
    }

    public TransactionResponseDTO findById(UUID id) {
        Transaction transaction = repository.findById(id)
                .filter(Transaction::getActive)
                .orElseThrow(() -> new EntityNotFoundException("Transação não encontrada"));

        return mapper.toResponse(transaction);
    }

    public Page<TransactionResponseDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toResponse);
    }

    public void delete(UUID id) {
        Transaction transaction = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Transação não encontrada"));

        transaction.setActive(false);
        repository.save(transaction);
    }

    public BigDecimal calculateBalance() {
        return repository.findByActiveTrue()
                .stream()
                .map(t -> t.getType() == TransactionType.ENTRADA
                        ? t.getAmount()
                        : t.getAmount().negate())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<TransactionResponseDTO> findByPeriod(LocalDate start, LocalDate end) {
        return repository.findByDateBetweenAndActiveTrue(start, end)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    private void validateAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor da transação deve ser maior que zero");
        }
    }
}
