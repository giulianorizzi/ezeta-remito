-- liquibase formatted sql
-- changeset liquibase:10

--preconditions onFail:HALT onError:HALT
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM information_schema.TABLES t WHERE t.TABLE_NAME = 'tax'

CREATE TABLE IF NOT EXISTS tax (
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    external_id VARCHAR(32),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP,

    total double,
    PRIMARY KEY (id)
)