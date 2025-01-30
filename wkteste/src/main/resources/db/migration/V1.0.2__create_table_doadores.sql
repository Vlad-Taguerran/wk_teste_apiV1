CREATE TABLE doadores
(
    id             BINARY(16)   NOT NULL,
    nome           VARCHAR(255) NOT NULL,
    cpf            VARCHAR(255) NOT NULL,
    rg             VARCHAR(255) NOT NULL,
    data_nasc      date         NOT NULL,
    sexo           VARCHAR(255) NULL,
    mae            VARCHAR(255) NULL,
    pai            VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    celular        VARCHAR(255) NULL,
    telefone_fixo  VARCHAR(255) NULL,
    tipo_sanguineo VARCHAR(255) NULL,
    altura         DOUBLE       NULL,
    peso           DOUBLE       NULL,
    CONSTRAINT pk_doadores PRIMARY KEY (id)
);

ALTER TABLE doadores
    ADD CONSTRAINT uc_doadores_cpf UNIQUE (cpf);

ALTER TABLE doadores
    ADD CONSTRAINT uc_doadores_email UNIQUE (email);

ALTER TABLE doadores
    ADD CONSTRAINT uc_doadores_rg UNIQUE (rg);