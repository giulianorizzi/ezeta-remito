-- liquibase formatted sql
-- changeset liquibase:13

--preconditions onFail:HALT onError:HALT
--precondition-sql-check expectedResult:1 SELECT COUNT(*) FROM information_schema.TABLES t WHERE t.TABLE_NAME = 'remito_detail'
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM information_schema.COLUMNS c WHERE c.TABLE_NAME = 'remito_detail' and c.COLUMN_NAME = "diameter"

ALTER TABLE remito_detail
ADD COLUMN diameter DOUBLE DEFAULT 0