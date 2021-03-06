CREATE DATABASE DBRanking;
USE DBRanking;
DROP TABLE ESCOLA_MED;
CREATE TABLE ESCOLA_MED(
ID_ESC INT PRIMARY KEY,
RANK_ESC INT,
NOME_ESC VARCHAR(100)NOT NULL,
MED_MED DECIMAL(4,2),
MED_IDEB DECIMAL(4,2)
);
DELETE FROM ESCOLA_MED WHERE ID_ESC > 0;
SELECT * FROM ESCOLA_MED ORDER BY MED_MED DESC LIMIT 10;
SELECT COUNT(*) FROM ESCOLA_MED;
ALTER TABLE ESCOLA_MED
MODIFY RANK_ESC INT DEFAULT 0;

INSERT INTO ESCOLA_MED VALUES (1,NULL,'OBA',10,NULL,NULL,10);

CREATE TABLE ESCOLA_INI(
ID_ESC INT PRIMARY KEY,
RANK_ESC INT,
NOME_ESC VARCHAR(100) NOT NULL,
MED_INI DECIMAL(4,2),
MED_IDEB DECIMAL(4,2)
);
SELECT * FROM ESCOLA_INI ORDER BY MED_INI DESC LIMIT 10;
DELETE FROM ESCOLA_INI WHERE ID_ESC > -1;
DROP TABLE ESCOLA_INI;
SELECT COUNT(*) FROM ESCOLA_INI;

CREATE TABLE ESCOLA_FIN(
ID_ESC INT PRIMARY KEY,
RANK_ESC INT,
NOME_FIN VARCHAR(100)NOT NULL,
MED_FIN DECIMAL(4,2),
IDEB_FIN DECIMAL(4,2)
);
SELECT COUNT(*) FROM ESCOLA_FIN;
SELECT * FROM ESCOLA_FIN ORDER BY IDEB_FIN DESC LIMIT 10;
DELETE FROM ESCOLA_FIN WHERE ID_ESC > -1;
DROP TABLE ESCOLA_FIN;

SELECT NOME_ESC,MED_INI,MED_MED,MED_FIN,IDEB_INI,IDEB_MED,IDEB_FIN
FROM ESCOLA_INI
LEFT JOIN ESCOLA_FIN
ON ESCOLA_INI.ID_ESC = ESCOLA_FIN.ID_ESC
LEFT JOIN ESCOLA_MED
ON ESCOLA_INI.ID_ESC = ESCOLA_MED.ID_ESC
ORDER BY MED_MED DESC;

ALTER TABLE ESCOLA_FIN
ADD CONSTRAINT FK_ID_ESC FOREIGN KEY (ID_ESC) REFERENCES ESCOLA_INI(ID_ESC);

ALTER TABLE ESCOLA_MED CHANGE NOME_ESC NOME_MED VARCHAR(100);
ALTER TABLE ESCOLA_FIN CHANGE NOME_ESC NOME_FIN VARCHAR(100);
ALTER TABLE ESCOLA_MED CHANGE MED_IDEB IDEB_MED VARCHAR(100);
ALTER TABLE ESCOLA_FIN CHANGE MED_IDEB IDEB_FIN VARCHAR(100);
ALTER TABLE ESCOLA_INI CHANGE MED_IDEB IDEB_INI VARCHAR(100);

CREATE TABLE SUGESTAO(
ID_SUG INT PRIMARY KEY auto_increment,
SUG Varchar(280),
DATA_SUG DATE,
RA_ALU VARCHAR(12) NOT NULL,
ID_ESC INT NOT NULL
);

SELECT SUG, DATA_SUG, NOME_ALU,NOME_ESC
FROM SUGESTAO
LEFT JOIN ESCOLA_INI
ON SUGESTAO.ID_ESC = ESCOLA_INI.ID_ESC
LEFT JOIN ALUNO
ON SUGESTAO.RA_ALU = ALUNO.RA_ALU;

SELECT * FROM SUGESTAO;
DROP TABLE SUGESTAO;
INSERT INTO SUGESTAO VALUES (1,'OBA',curdate(),1,1);

CREATE TABLE ALUNO(
RA_ALU varchar(12) PRIMARY KEY,
NOME_ALU VARCHAR(100) NOT NULL,
ANO_ALU VARCHAR(5) NOT NULL,
SENHA_ALU VARCHAR(20) NOT NULL,
ID_ESC INT NOT NULL
);

SELECT * FROM ALUNO;
DROP TABLE ALUNO;
SELECT NOME_ALU FROM ALUNO WHERE RA_ALU = 'd710bc6';

SELECT ALUNO.ID_ESC
FROM ALUNO
LEFT JOIN ESCOLA_INI
ON ALUNO.ID_ESC = ESCOLA_INI.ID_ESC
WHERE RA_ALU = 'd710bc6';