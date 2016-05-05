CREATE TABLE public.par_facultad
(
  id SERIAL PRIMARY KEY,
  nombre_facultad text NOT NULL,
  ciudad_facultad text NOT NULL,
  id_creador integer NOT NULL,
  fecha_creacion date NOT NULL,
  estado_facultad boolean NOT NULL DEFAULT TRUE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.par_facultad
  OWNER TO polisilabo
CREATE TABLE public.par_departamento
(
  id SERIAL PRIMARY KEY,
  id_facultad integer references par_facultad(id),
  nombre_departamento text NOT NULL,
  ciudad_departamento text NOT NULL,
  id_creador integer NOT NULL,
  fecha_creacion date NOT NULL,
  estado_departamento boolean NOT NULL DEFAULT TRUE
  )
WITH (
  OIDS=FALSE
);
ALTER TABLE public.nombre_departamento
  OWNER TO polisilabo;
CREATE TABLE public.par_usuarios
(
  id SERIAL PRIMARY KEY,
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
  )
WITH (
  OIDS=FALSE
);
ALTER TABLE public.par_usuarios
  OWNER TO polisilabo;
CREATE TABLE public.par_materias
(
  id SERIAL PRIMARY KEY,
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
  )
WITH (
  OIDS=FALSE
);
ALTER TABLE public.par_materias
  OWNER TO polisilabo;
CREATE TABLE public.par_competencia
(
  id SERIAL PRIMARY KEY,
  cod_competencia integer,
  descripcion text NOT NULL,
  id_creador integer NOT NULL,
  fecha_creacion date NOT NULL,
  estado_competencia boolean NOT NULL DEFAULT TRUE
  )
WITH (
  OIDS=FALSE
);
ALTER TABLE public.par_competencia
  OWNER TO polisilabo;
CREATE TABLE public.par_nucleo_tematico
(
  id SERIAL PRIMARY KEY,
  id_materia integer references par_materias(id),
  nombre text NOT NULL,
  descripcion text NOT NULL,
  id_creador integer NOT NULL,
  fecha_creacion date NOT NULL,
  estado_nucleo boolean NOT NULL DEFAULT TRUE
  
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.par_nucleo_tematico
  OWNER TO polisilabo;
CREATE TABLE public.par_titulo
(
id SERIAL PRIMARY KEY,
  id_materia integer references par_materias(id),
  descripcion text NOT NULL,
  id_creador integer NOT NULL,
  fecha_creacion date NOT NULL,
  estado_nucleo boolean NOT NULL DEFAULT TRUE

)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.par_titulo
  OWNER TO polisilabo;
CREATE TABLE public.par_objetivo
(
  id SERIAL PRIMARY KEY,
  id_materia integer references par_materias(id),
  descripcion text NOT NULL,
  id_creador integer NOT NULL,
  fecha_creacion date NOT NULL,
  estado_nucleo boolean NOT NULL DEFAULT TRUE
  
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.par_objetivo
  OWNER TO polisilabo;
  CREATE TABLE public.par_eje
(
  id SERIAL PRIMARY KEY,
  id_materia integer references par_materias(id),
  descripcion text NOT NULL,
  id_creador integer NOT NULL,
  fecha_creacion date NOT NULL,
  estado_nucleo boolean NOT NULL DEFAULT TRUE
 )
WITH (
  OIDS=FALSE
);
ALTER TABLE public.par_eje
  OWNER TO polisilabo;