--Crear Base de Datos
CREATE DATABASE polisilabo
  WITH ENCODING='UTF8'
       OWNER=postgres
       CONNECTION LIMIT=-1
       TABLESPACE=pg_default;

--Creacion del Rol Usuario de la Base de Datos
CREATE USER polisilabo PASSWORD 'polisilabo';
--Crear Perimisos al Usuario
ALTER ROLE polisilabo WITH SUPERUSER

--Crear Tablas
CREATE TABLE public.par_facultad
(
  id integer NOT NULL DEFAULT nextval('par_facultad_id_seq'::regclass),
  nombre_facultad text NOT NULL,
  ciudad_facultad text NOT NULL,
  id_creador integer NOT NULL,
  fecha_creacion date NOT NULL,
  estado_facultad boolean NOT NULL DEFAULT TRUE
  CONSTRAINT id PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.par_facultad
  OWNER TO polisilabo;

CREATE TABLE public.par_departamento
(
  id integer NOT NULL DEFAULT nextval('par_departamento_id_seq'::regclass),
  id_facultad integer references par_facultad(id),
  nombre_departamento text NOT NULL,
  ciudad_departamento text NOT NULL,
  id_creador integer NOT NULL,
  fecha_creacion date NOT NULL,
  estado_departamento boolean NOT NULL DEFAULT TRUE
  CONSTRAINT id PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.nombre_departamento
  OWNER TO polisilabo;

CREATE TABLE public.par_usuarios
(
  id integer NOT NULL DEFAULT nextval('par_usuarios_id_seq'::regclass),
  id_usuario integer UNIQUE,
  tipo_cedula text NOT NULL,
  nombre text NOT NULL,
  apellido text NOT NULL,
  email text NOT NULL,
  password text NOT NULL,
  perfil integer NOT NULL,
  id_creador integer NOT NULL,
  fecha_creacion date NOT NULL,
  estado_usuario boolean NOT NULL DEFAULT TRUE
  CONSTRAINT id PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.par_usuarios
  OWNER TO polisilabo;

CREATE TABLE public.par_materias
(
  id integer NOT NULL DEFAULT nextval('par_materias_id_seq'::regclass),
  cod_materia integer,
  nombre text NOT NULL,
  descripcion text NOT NULL,
  logro text NOT NULL,
  modalidad text NOT NULL,
  no_creditos integer NOT NULL,
  duracion text NOT NULL,
  tipo_asignatura text NOT NULL,
  id_creador integer NOT NULL,
  fecha_creacion date NOT NULL,
  estado_materia boolean NOT NULL DEFAULT TRUE
  CONSTRAINT id PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.par_materias
  OWNER TO polisilabo;

CREATE TABLE public.par_competencia
(
  id integer NOT NULL DEFAULT nextval('par_competencia_id_seq'::regclass),
  cod_competencia integer,
  descripcion text NOT NULL,
  id_creador integer NOT NULL,
  fecha_creacion date NOT NULL,
  estado_competencia boolean NOT NULL DEFAULT TRUE
  CONSTRAINT id PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.par_competencia
  OWNER TO polisilabo;

CREATE TABLE public.par_nucleo_tematico
(
  id integer NOT NULL DEFAULT nextval('par_nucleo_tematico_id_seq'::regclass),
  id_materia integer references par_materias(id),
  nombre text NOT NULL,
  descripcion text NOT NULL,
  id_creador integer NOT NULL,
  fecha_creacion date NOT NULL,
  estado_nucleo boolean NOT NULL DEFAULT TRUE
  CONSTRAINT id PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.par_nucleo_tematico
  OWNER TO polisilabo;

CREATE TABLE public.par_titulo
(
  id integer NOT NULL DEFAULT nextval('par_titulo_id_seq'::regclass),
  id_materia integer references par_materias(id),
  descripcion text NOT NULL,
  id_creador integer NOT NULL,
  fecha_creacion date NOT NULL,
  estado_nucleo boolean NOT NULL DEFAULT TRUE
  CONSTRAINT id PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.par_titulo
  OWNER TO polisilabo;

CREATE TABLE public.par_objetivo
(
  id integer NOT NULL DEFAULT nextval('par_objetivo_id_seq'::regclass),
  id_materia integer references par_materias(id),
  descripcion text NOT NULL,
  id_creador integer NOT NULL,
  fecha_creacion date NOT NULL,
  estado_nucleo boolean NOT NULL DEFAULT TRUE
  CONSTRAINT id PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.par_objetivo
  OWNER TO polisilabo;

CREATE TABLE public.par_eje
(
  id integer NOT NULL DEFAULT nextval('par_eje_id_seq'::regclass),
  id_materia integer references par_materias(id),
  descripcion text NOT NULL,
  id_creador integer NOT NULL,
  fecha_creacion date NOT NULL,
  estado_nucleo boolean NOT NULL DEFAULT TRUE
  CONSTRAINT id PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.par_eje
  OWNER TO polisilabo;

--Insertar Valores en las Tablas
INSERT INTO public.docente(cedula, nombre, categoria)
     VALUES (34090896763, 'Mauricio', 'Reposteria'),
            (567892098, 'Alejandro', 'Artes');

            No se puede establecer la conexión a jdbc:derby:gestiondocente;restoreFrom=/Users/DarkKlitos/Desktop/backupdbGestionDocente/gestiondocente usando org.apache.derby.jdbc.EmbeddedDriver (Se ha producido un fallo de autenticación de conexión. Motivo: Autenticación no válida..)