# Criar um novo banco de dados
CREATE DATABASE testes;

USE testes

# Criar tabelas
CREATE TABLE NOME_DA_TAELA (
id int(10) unsigned NOT NULL AUTO_INCREMENT,
nome varchar(50) DEFAULT NULL,
dataNascimento date DEFAULT NULL,
PRIMARY KEY (id)
)
/* Tipos de Campos
INT
VARCHAR
TEXT
DATE
TIME */


CREATE TABLE restaurantes (
    id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) DEFAULT NULL,
    endereco VARCHAR(256) DEFAULT NULL,
    mesas INT(5) UNSIGNED NOT NULL,
    cartoes BOOL,
    estacionamento BOOL,
    PRIMARY KEY (id)
)

ALTER TABLE restaurantes
	# DROP COLUMN nome_da_coluna
	ADD COLUMN horarioAbertura time DEFAULT NULL,
    ADD COLUMN horarioFechamento time DEFAULT NULL;
   
INSERT INTO restaurantes (id, nome, endereco, mesas, cartoes, estacionamento, horarioAbertura, horarioFechamento) VALUES (null, "Restaurante da Vóvó", "Rua das Flores", 15, true, true, "11:00", "23:00");
INSERT INTO restaurantes (id, nome, endereco, mesas, cartoes, estacionamento, horarioAbertura, horarioFechamento) VALUES (null, "Restaurante Japoês", "Rua XV", 30, true, false, "18:00", "00:00");
INSERT INTO restaurantes (id, nome, endereco, mesas, cartoes, estacionamento, horarioAbertura, horarioFechamento) VALUES (null, "Restaurante Mineiro", "Rua do Zé", 60, true, true, "11:00", "15:00");

SELECT * FROM restaurantes WHERE nome LIKE "%Japonês%" ORDER BY id DESC LIMIT 0,2;
