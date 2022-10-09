-- liquibase formatted sql
-- changeset liquibase:5

--preconditions onFail:HALT onError:HALT
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM information_schema.TABLES t WHERE t.TABLE_NAME = 'invoice'

CREATE TABLE IF NOT EXISTS invoice (
    id BIGINT(20),
    external_id VARCHAR(32),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP,

    total DOUBLE DEFAULT 0,
    PRIMARY KEY (id)
)