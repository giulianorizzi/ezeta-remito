-- liquibase formatted sql
-- changeset liquibase:3

--preconditions onFail:HALT onError:HALT
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM information_schema.TABLES t WHERE t.TABLE_NAME = 'employee'

CREATE TABLE IF NOT EXISTS employee (
    id BIGINT(20),
    external_id VARCHAR(32),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP,

    person_id BIGINT(20),
    PRIMARY KEY (id),
    FOREIGN KEY (person_id) REFERENCES person(id)
)