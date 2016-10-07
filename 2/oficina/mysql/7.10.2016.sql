# Criar um novo banco de dados
CREATE DATABASE testes;

# Criar tabelas
# CREATE TABLE NOME_DA_TAELA (
#	id int(10) unsigned NOT NULL AUTO_INCREMENT,
#    nome varchar(50) DEFAULT NULL,
#    dataNascimento date DEFAULT NULL,
#    PRIMARY KEY (id)
# )
# Tipos de Campos
# INT
# VARCHAR
# TEXT
# DATE
# TIME


CREATE TABLE restaurantes (
    id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) DEFAULT NULL,
    endereco VARCHAR(256) DEFAULT NULL,
    mesas INT(5) UNSIGNED NOT NULL,
    cartoes BOOL,
    estacionamento BOOL,
    PRIMARY KEY (id)
)
