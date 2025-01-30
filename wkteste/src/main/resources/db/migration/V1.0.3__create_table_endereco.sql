CREATE TABLE enderecos (
    id binary(16) PRIMARY KEY NOT NULL DEFAULT (UUID_TO_BIN(UUID(), TRUE)),
    cep VARCHAR(10),
    endereco VARCHAR(255),
    bairro VARCHAR(255),
    cidade VARCHAR(255),
    estado VARCHAR(2),
    user_id binary(16) UNIQUE,
    doador_id binary(16) UNIQUE,
    CONSTRAINT fk_endereco_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_endereco_doador FOREIGN KEY (doador_id) REFERENCES doadores(id) ON DELETE CASCADE
);
