package br.com.financial_service.api.dto.response;

import br.com.financial_service.domain.enums.TransactionCategory;
import br.com.financial_service.domain.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record TransactionResponseDTO(
        UUID id,
        TransactionType type,
        TransactionCategory category,
        BigDecimal amount,
        String description,
        LocalDate date,
        LocalDateTime createdAt,
        UUID createdBy,
        Boolean active
) {}
