-- liquibase formatted sql
-- changeset liquibase:5

--preconditions onFail:HALT onError:HALT
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM information_schema.TABLES t WHERE t.TABLE_NAME = 'remito_detail'

CREATE TABLE IF NOT EXISTS remito_detail (
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    external_id VARCHAR(32),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP,

    quantity INT DEFAULT 0,
    remito_id BIGINT(20) NOT NULL,
    employee_id BIGINT(20) NOT NULL,
    operation_id BIGINT(20) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (remito_id) REFERENCES remito(id),
    FOREIGN KEY (employee_id) REFERENCES employee(id),
    FOREIGN KEY (operation_id) REFERENCES operation(id)
)