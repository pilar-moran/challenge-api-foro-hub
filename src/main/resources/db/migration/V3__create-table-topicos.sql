CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    estado BOOLEAN NOT NULL,
    usuario_id BIGINT NOT NULL,
    curso VARCHAR(100) NOT NULL,

    PRIMARY KEY (id),
    UNIQUE KEY (titulo, mensaje(255)),

    CONSTRAINT fk_topicos_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);
