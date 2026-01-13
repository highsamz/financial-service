CREATE TABLE attachments (
                             id UUID PRIMARY KEY,
                             transaction_id UUID NOT NULL,
                             file_name VARCHAR(255) NOT NULL,
                             content_type VARCHAR(100),
                             size BIGINT,
                             storage_path VARCHAR(500) NOT NULL,
                             uploaded_at TIMESTAMP NOT NULL DEFAULT NOW(),
                             uploaded_by UUID NOT NULL,
                             CONSTRAINT fk_transaction
                                 FOREIGN KEY (transaction_id)
                                     REFERENCES transactions(id)
);