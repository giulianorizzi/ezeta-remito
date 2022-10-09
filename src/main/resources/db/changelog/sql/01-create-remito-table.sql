-- liquibase formatted sql
-- changeset liquibase:1

--preconditions onFail:HALT onError:HALT
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM information_schema.TABLES t WHERE t.TABLE_NAME = 'remito'

CREATE TABLE IF NOT EXISTS remito (
    id BIGINT(20),
    external_id VARCHAR(32),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP,

    number VARCHAR(256),
    PRIMARY KEY (id)
)