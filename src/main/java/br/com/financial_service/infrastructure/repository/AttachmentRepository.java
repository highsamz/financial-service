package br.com.financial_service.infrastructure.repository;

import br.com.financial_service.domain.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {

    List<Attachment> findByTransactionId(UUID transactionId);
}
