-- liquibase formatted sql
-- changeset liquibase:11

--preconditions onFail:HALT onError:HALT
--precondition-sql-check expectedResult:1 SELECT COUNT(*) FROM information_schema.TABLES t WHERE t.TABLE_NAME = 'person'

INSERT INTO person(external_id, created_at, updated_at, first_name, last_name, birth_date, identification_number, cuit) VALUES
(LEFT(MD5(UUID()), 32), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'giuliano', 'rizzi', '1997-12-30', '40833487', '20408334870')