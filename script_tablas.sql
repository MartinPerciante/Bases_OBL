--tablas de atributos multivaluados
CREATE TABLE IF NOT EXISTS estado_figurita
(
    estado varchar(20),
    PRIMARY KEY (estado)
);
CREATE TABLE IF NOT EXISTS pais_figurita
(
    pais varchar(3),
    PRIMARY KEY (pais)
);
CREATE TABLE IF NOT EXISTS tipo_oferta
(
    tipo varchar(20),
    PRIMARY KEY (tipo)
);
CREATE TABLE IF NOT EXISTS estado_oferta
(
    estado varchar(20),
    PRIMARY KEY (estado)
);
CREATE TABLE IF NOT EXISTS estado_publicacion
(
    estado varchar(20),
    PRIMARY KEY (estado)
);

--tablas de entidades
CREATE TABLE IF NOT EXISTS usuario
(
    ci       varchar(10),
    nombre   varchar(30),
    apellido varchar(30),
    telefono varchar(15),
    email    varchar(50),
    password varchar(70),
    PRIMARY KEY (ci)
);
CREATE TABLE IF NOT EXISTS figurita
(
    numero int,
    pais   varchar(3),
    foto   bytea,
    CONSTRAINT figurita_uniq_idx PRIMARY KEY (numero, pais),
    FOREIGN KEY (pais) REFERENCES pais_figurita (pais)
);
CREATE TABLE IF NOT EXISTS publicacion
(
    ci_usuario      varchar(10),
    fecha           timestamp,
    estado          varchar(20),
    numero_figurita int,
    pais_figurita   varchar(3),
    estado_figurita varchar(20),
    CONSTRAINT publicacion_uniq_idx PRIMARY KEY (ci_usuario, fecha),
    FOREIGN KEY (ci_usuario) REFERENCES usuario (ci),
    FOREIGN KEY (estado) REFERENCES estado_publicacion (estado),
    FOREIGN KEY (numero_figurita, pais_figurita) REFERENCES figurita (numero, pais),
    FOREIGN KEY (estado_figurita) REFERENCES estado_figurita (estado)
);
CREATE TABLE IF NOT EXISTS oferta
(
    ci_usuario_oferta       varchar(10),
    ci_usuario_publicacion  varchar(10),
    fecha_oferta            timestamp,
    fecha_publicacion       timestamp,
    tipo                    varchar(20),
    estado                  varchar(20),
    ci_usuario_contraoferta varchar(10),
    fecha_contraoferta      timestamp,
    CONSTRAINT oferta_uniq_idx PRIMARY KEY (ci_usuario_oferta, ci_usuario_publicacion, fecha_oferta,
                                            fecha_publicacion),
    FOREIGN KEY (ci_usuario_publicacion, fecha_publicacion) REFERENCES publicacion (ci_usuario, fecha),
    FOREIGN KEY (ci_usuario_oferta) REFERENCES usuario (ci),
    FOREIGN KEY (tipo) REFERENCES tipo_oferta (tipo),
    FOREIGN KEY (estado) REFERENCES estado_oferta (estado)
);

--tablas de relaciones entre entidades
CREATE TABLE IF NOT EXISTS publicacion_tiene_interesada_figurita
(
    ci_usuario_publicacion varchar(10),
    numero_figurita        int,
    pais_figurita          varchar(3),
    fecha_publicacion      timestamp,
    CONSTRAINT pub_tiene_interesada_fig_uniq_idx PRIMARY KEY (ci_usuario_publicacion, numero_figurita, pais_figurita,
                                                              fecha_publicacion),
    FOREIGN KEY (ci_usuario_publicacion, fecha_publicacion) REFERENCES publicacion (ci_usuario, fecha),
    FOREIGN KEY (numero_figurita, pais_figurita) REFERENCES figurita (numero, pais)
);
CREATE TABLE IF NOT EXISTS oferta_tiene_figurita
(
    ci_usuario_publicacion varchar(10),
    fecha_publicacion      timestamp,
    ci_usuario_oferta      varchar(10),
    fecha_oferta           timestamp,
    numero_figurita        int,
    pais_figurita          varchar(3),
    estado_figurita        varchar(20),
    CONSTRAINT oferta_tiene_figurita_uniq_idx PRIMARY KEY (ci_usuario_publicacion, fecha_publicacion,
                                                           ci_usuario_oferta,
                                                           fecha_oferta, numero_figurita, pais_figurita),
    FOREIGN KEY (ci_usuario_publicacion, fecha_publicacion, ci_usuario_oferta,
                 fecha_oferta) REFERENCES oferta (ci_usuario_publicacion, fecha_publicacion, ci_usuario_oferta,
                                                  fecha_oferta),
    FOREIGN KEY (numero_figurita, pais_figurita) REFERENCES figurita (numero, pais),
    FOREIGN KEY (estado_figurita) REFERENCES estado_figurita (estado)
);

--datos fijos
INSERT INTO estado_figurita
VALUES ('NUEVA'),
       ('DOBLADA'),
       ('ROTA');
INSERT INTO estado_oferta
VALUES ('RECHAZADA'),
       ('CONTRAOFERTADA'),
       ('PENDIENTE'),
       ('ACEPTADA');
INSERT INTO estado_publicacion
VALUES ('ACTIVA'),
       ('INACTIVA'),
       ('CONCRETADA');
INSERT INTO tipo_oferta
VALUES ('OFERTA'),
       ('CONTRAOFERTA');
INSERT INTO pais_figurita
VALUES ('QAT'),
       ('ECU'),
       ('SEN'),
       ('NED'),
       ('ENG'),
       ('IRN'),
       ('USA'),
       ('WAL'),
       ('ARG'),
       ('KSA'),
       ('MEX'),
       ('POL'),
       ('FRA'),
       ('AUS'),
       ('DEN'),
       ('TUN'),
       ('ESP'),
       ('CRC'),
       ('GER'),
       ('JPN'),
       ('BEL'),
       ('CAN'),
       ('MAR'),
       ('CRO'),
       ('BRA'),
       ('SRB'),
       ('SUI'),
       ('CMR'),
       ('POR'),
       ('GHA'),
       ('URU'),
       ('KOR'),
       ('FWC');