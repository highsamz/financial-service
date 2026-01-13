CREATE TABLE transactions (
                              id UUID PRIMARY KEY,
                              type VARCHAR(20) NOT NULL,
                              category VARCHAR(50) NOT NULL,
                              amount NUMERIC(15,2) NOT NULL,
                              description TEXT,
                              date DATE NOT NULL,
                              created_at TIMESTAMP NOT NULL DEFAULT NOW(),
                              created_by UUID NOT NULL,
                              active BOOLEAN NOT NULL DEFAULT TRUE
);
