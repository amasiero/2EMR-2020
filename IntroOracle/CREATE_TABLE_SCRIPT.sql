CREATE TABLE TB_TAREFA (
    ID NUMBER NOT NULL PRIMARY KEY,
    DESCRICAO VARCHAR2(100) NOT NULL,
    FEITA NUMBER(1) DEFAULT 0
);

CREATE SEQUENCE SQ_TAREFA INCREMENT BY 1 START WITH 1 NOCYCLE ORDER;