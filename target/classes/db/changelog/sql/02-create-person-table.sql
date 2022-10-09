-- liquibase formatted sql
-- changeset liquibase:2

--preconditions onFail:HALT onError:HALT
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM information_schema.TABLES t WHERE t.TABLE_NAME = 'person'

CREATE TABLE IF NOT EXISTS person (
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    external_id VARCHAR(32),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP,

    first_name VARCHAR(50),
    last_name VARCHAR(50),
    birth_date DATE,
    identification_number VARCHAR(50),
    cuit VARCHAR(50),
    PRIMARY KEY (id),
    UNIQUE(identification_number, cuit)
)