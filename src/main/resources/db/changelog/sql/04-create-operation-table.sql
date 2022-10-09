-- liquibase formatted sql
-- changeset liquibase:4

--preconditions onFail:HALT onError:HALT
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM information_schema.TABLES t WHERE t.TABLE_NAME = 'operation'

CREATE TABLE IF NOT EXISTS operation (
    id BIGINT(20),
    name VARCHAR(100),
    price DOUBLE DEFAULT 0,
    PRIMARY KEY (id)
)