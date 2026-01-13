package br.com.financial_service.domain.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

    @Entity
    @Table(name = "attachments")
    @Getter
    @Setter
    @NoArgsConstructor
    public class Attachment {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "transaction_id", nullable = false)
        private Transaction transaction;

        @Column(nullable = false)
        private String fileName;

        @Column
        private String contentType;

        @Column
        private Long size;

        @Column(nullable = false)
        private String storagePath;

        @Column(nullable = false)
        private LocalDateTime uploadedAt;

        @Column(nullable = false)
        private UUID uploadedBy;
}
