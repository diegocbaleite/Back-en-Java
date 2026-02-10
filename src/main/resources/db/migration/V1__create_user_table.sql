create schema if not exists users;
create table users.user
(
    id            BIGINT       NOT NULL AUTO_INCREMENT,
    nome          VARCHAR(100) NOT NULL,
    cpf           VARCHAR(14)  NOT NULL,
    endereco      VARCHAR(100) NOT NULL,
    email         VARCHAR(100) NOT NULL,
    telefone      VARCHAR(20)  NOT NULL,
    data_cadastro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);