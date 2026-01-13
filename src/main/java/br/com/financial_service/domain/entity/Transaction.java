package br.com.financial_service.domain.entity;

import br.com.financial_service.domain.enums.TransactionCategory;
import br.com.financial_service.domain.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
public class Transaction {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private TransactionType type;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private TransactionCategory category;

        @Column(nullable = false, precision = 15, scale = 2)
        private BigDecimal amount;

        @Column
        private String description;

        @Column(nullable = false)
        private LocalDate date;

        @Column(nullable = false)
        private LocalDateTime createdAt;

        @Column(nullable = false)
        private UUID createdBy;

        @Column(nullable = false)
        private Boolean active = true;
}
