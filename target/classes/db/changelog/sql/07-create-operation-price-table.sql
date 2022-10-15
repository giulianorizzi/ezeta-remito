-- liquibase formatted sql
-- changeset liquibase:7

--preconditions onFail:HALT onError:HALT
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM information_schema.TABLES t WHERE t.TABLE_NAME = 'operation_price'

CREATE TABLE IF NOT EXISTS operation_price (
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    external_id VARCHAR(32),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP,

    price DOUBLE DEFAULT 0,
    until_diameter DOUBLE DEFAULT 1,
    operation_id BIGINT(20),
    PRIMARY KEY (id),
    FOREIGN KEY (operation_id) REFERENCES operation(id),
    UNIQUE KEY `operation_diameter` (operation_id, until_diameter)
)