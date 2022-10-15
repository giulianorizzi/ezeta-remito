-- liquibase formatted sql
-- changeset liquibase:11

--preconditions onFail:HALT onError:HALT
--precondition-sql-check expectedResult:1 SELECT COUNT(*) FROM information_schema.TABLES t WHERE t.TABLE_NAME = 'remito'
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM information_schema.COLUMNS c WHERE c.TABLE_NAME = 'remito' and c.COLUMN_NAME = "tax_id"

ALTER TABLE remito
ADD COLUMN tax_id BIGINT(20),
ADD FOREIGN KEY (tax_id) REFERENCES tax(id)