CREATE TABLE users (
    id binary(16) PRIMARY KEY NOT NULL DEFAULT (UUID_TO_BIN(UUID(), TRUE)),
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    rg VARCHAR(20) UNIQUE NOT NULL,
    data_nasc DATE NOT NULL,
    sexo ENUM ('Feminino', 'Masculino', 'Transgenero'),
    mae VARCHAR(255),
    pai VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    celular VARCHAR(20),
    telefone_fixo VARCHAR(20),
    tipo_sanguineo VARCHAR(5),
    altura DOUBLE,
    peso DOUBLE
);
