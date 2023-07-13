DROP TABLE PRODUCT CASCADE CONSTRAINTS ;

CREATE TABLE PRODUCT
(
    PRODUCTID   INT
        CONSTRAINT PK_PRODUCT PRIMARY KEY,
    PRODUCTNAME VARCHAR2(30) NOT NULL,
    CATEGORY    VARCHAR2(30) NOT NULL,
    PRICE       INT NOT NULL,
    STOCK       INT NOT NULL
);

DROP SEQUENCE PRODUCTID_SEQ;

CREATE SEQUENCE PRODUCTID_SEQ;
