CREATE TABLE IF NOT EXISTS usuarios(
    "id"           UUID PRIMARY KEY,
    "nome"         VARCHAR(255) NOT NULL,
    "telefone"     VARCHAR(255) NOT NULL,
    "data_criacao" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "email"        VARCHAR(255) NOT NULL UNIQUE,
    "senha"        VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS usuario_role(
    "usuario_id" UUID NOT NULL,
    "role_id"    UUID NOT NULL,
    FOREIGN KEY(usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY(role_id) REFERENCES roles(id)
);