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

--datos de prueba
INSERT INTO usuario
VALUES ('51630541', 'Lautaro', 'da Rosa', '098334659', 'lautaro.darosa@correo.ucu.edu.uy', 'edf9cf90718610ee7de53c0dcc250739239044de9ba115bb0ca6026c3e4958a5'),
       ('12345678', 'Nicolas', 'Velazquez', '00000000', 'nicolas.velazquez@correo.ucu.edu.uy', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e'),
       ('87654321', 'Martin', 'Perciante', '11111111', 'martin.perciante@correo.ucu.edu.uy', '5fd924625f6ab16a19cc9807c7c506ae1813490e4ba675f843d5a10e0baacdb8'),
       ('14327694', 'Maria', 'Ferreira', '095346387', 'maria.ferreira@hotmail.com', 'd988874ac3e352b5953bf1e05c2e14e0d271e6f16446f74cc0ffdad8788e68c9'),
       ('23874987', 'Julieta', 'Toledo', '091314739', 'julieta.toledo@gmail.com', '2aea9c0b23308c47f0a1da7582a60c02dfeea0240f7422bb8670d393e7d44cd6');
INSERT INTO figurita
VALUES (1, 'URU', 'luis-suarez.png'),
       (1, 'ARG', 'lionel-messi.png'),
       (1, 'BRA', 'vinicius-jr.png'),
       (2, 'BRA', 'thiago-silva.png'),
       (3, 'BRA', 'ederson.png'),
       (4, 'BRA', 'allison.png'),
       (5, 'BRA', 'gabriel-jesus.png'),
       (6, 'BRA', 'raphinha.png'),
       (7, 'BRA', 'neymar-jr.png');
INSERT INTO publicacion
VALUES ('51630541', '2022-11-05 22:22:22', 'ACTIVA', 1, 'ARG', 'NUEVA'),
       ('14327694', '2022-12-09 21:00:15', 'ACTIVA', 1, 'URU', 'DOBLADA'),
       ('23874987', '2022-12-18 11:13:56', 'ACTIVA', 1, 'BRA', 'ROTA');
INSERT INTO publicacion_tiene_interesada_figurita
VALUES ('51630541', 1, 'URU', '2022-11-05 22:22:22'),
       ('51630541', 1, 'BRA', '2022-11-05 22:22:22'),
       ('14327694', 2, 'BRA', '2022-12-09 21:00:15'),
       ('14327694', 3, 'BRA', '2022-12-09 21:00:15'),
       ('14327694', 4, 'BRA', '2022-12-09 21:00:15');
INSERT INTO oferta
VALUES ('12345678', '51630541', '2022-11-05 23:00:00', '2022-11-05 22:22:22', 'OFERTA', 'PENDIENTE', null, null),
       ('87654321', '51630541', '2022-11-06 02:00:00', '2022-11-05 22:22:22', 'OFERTA', 'PENDIENTE', null, null),
       ('12345678', '14327694', '2022-12-26 02:00:15', '2022-12-09 21:00:15', 'OFERTA', 'RECHAZADA', null, null),
       ('87654321', '14327694', '2022-12-26 05:10:20', '2022-12-09 21:00:15', 'OFERTA', 'ACEPTADA', null, null);
INSERT INTO oferta_tiene_figurita
VALUES ('51630541', '2022-11-05 22:22:22', '12345678', '2022-11-05 23:00:00', 1, 'URU', 'DOBLADA'),
       ('51630541', '2022-11-05 22:22:22', '12345678', '2022-11-05 23:00:00', 1, 'BRA', 'ROTA'),
       ('51630541', '2022-11-05 22:22:22', '87654321', '2022-11-06 02:00:00', 1, 'URU', 'NUEVA'),
       ('14327694', '2022-12-09 21:00:15', '12345678', '2022-12-26 02:00:15', 3, 'BRA', 'NUEVA'),
       ('14327694', '2022-12-09 21:00:15', '87654321', '2022-12-26 05:10:20', 4, 'BRA', 'DOBLADA');
INSERT INTO oferta
VALUES ('51630541', '51630541', '2022-11-07 15:00:00', '2022-11-05 22:22:22', 'CONTRAOFERTA', 'PENDIENTE', null, null);
UPDATE oferta
SET ci_usuario_contraoferta = '51630541',
    fecha_contraoferta      = '2022-11-07 15:00:00',
    estado                  = 'CONTRAOFERTADA'
WHERE ci_usuario_oferta = '12345678'
  AND ci_usuario_publicacion = '51630541'
  AND fecha_oferta = '2022-11-05 23:00:00'
  AND fecha_publicacion = '2022-11-05 22:22:22';