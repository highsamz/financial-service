package br.com.financial_service.api.dto.request;

import java.time.LocalDateTime;
import java.util.UUID;

public record AttachmentResponseDTO(
        UUID id,
        String fileName,
        String contentType,
        Long size,
        LocalDateTime uploadedAt,
        UUID uploadedBy
) {}
