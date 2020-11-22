CREATE TABLE TB_PERMISSAO(
CD_PERMISSAO INTEGER NOT NULL,
DS_PERMISSAO VARCHAR(120) NOT NULL,
CONSTRAINT PK_CD_PERMISSAO PRIMARY KEY(CD_PERMISSAO)
)

CREATE TABLE TB_USUARIO(
CD_USUARIO INTEGER NOT NULL,
SENHA VARCHAR(50) NOT NULL,
NM_USERNAME VARCHAR(100)NOT NULL,
DT_CADASTRO DATE NOT NULL,
CD_PERMISSAO INTEGER,
CONSTRAINT PK_CD_USUARIO PRIMARY KEY(CD_USUARIO),
CONSTRAINT FK_CD_PERMISSAO FOREIGN KEY(CD_PERMISSAO) REFERENCES TB_PERMISSAO(CD_PERMISSAO)
)

CREATE SEQUENCE SEQ_USUARIO 
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 99999
NOCACHE
NOCYCLE


CREATE SEQUENCE SEQ_PERMISSAO 
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 99999
NOCACHE
NOCYCLE