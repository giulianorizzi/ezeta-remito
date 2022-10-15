-- liquibase formatted sql
-- changeset liquibase:8

--preconditions onFail:HALT onError:HALT
--precondition-sql-check expectedResult:1 SELECT COUNT(*) FROM information_schema.TABLES t WHERE t.TABLE_NAME = 'operation'

INSERT INTO operation(external_id, created_at, updated_at, name) VALUES
(LEFT(MD5(UUID()), 32), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Cortar polietileno'),
(LEFT(MD5(UUID()), 32), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Ensamblar cartones'),
(LEFT(MD5(UUID()), 32), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Cajas SDS x 4'),
(LEFT(MD5(UUID()), 32), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Cajas SDS x 6'),
(LEFT(MD5(UUID()), 32), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Cajas x 19'),
(LEFT(MD5(UUID()), 32), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Cajas x 25'),
(LEFT(MD5(UUID()), 32), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Cortar y ensamblar cartones'),
(LEFT(MD5(UUID()), 32), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Blisters'),
(LEFT(MD5(UUID()), 32), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Cajas TCC x 6'),
(LEFT(MD5(UUID()), 32), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Tubitos'),
(LEFT(MD5(UUID()), 32), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Blisters Easy'),
(LEFT(MD5(UUID()), 32), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Blisters Centrar'),
(LEFT(MD5(UUID()), 32), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Cajas TCC y VIDIA x 9'),
(LEFT(MD5(UUID()), 32), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Cajas x 11')
