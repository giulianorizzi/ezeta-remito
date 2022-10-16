-- liquibase formatted sql
-- changeset liquibase:12

--preconditions onFail:HALT onError:HALT
--precondition-sql-check expectedResult:1 SELECT COUNT(*) FROM information_schema.TABLES t WHERE t.TABLE_NAME = 'employee'

INSERT INTO employee(external_id, created_at, updated_at, person_id) VALUES
(LEFT(MD5(UUID()), 32), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1)