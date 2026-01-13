package br.com.financial_service.api.dto.request;

import br.com.financial_service.domain.enums.TransactionCategory;
import br.com.financial_service.domain.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record CreateTransactionRequestDTO(
        TransactionType type,
        TransactionCategory category,
        BigDecimal amount,
        String description,
        LocalDate date,
        UUID createdBy
) {}
