-----------------------------------------------------------------------------
CREATE TABLE public.par_usuarios --Tabla Usuarios
(
  id SERIAL PRIMARY KEY,
  id_usuario integer UNIQUE,
  tipo_cedula text NOT NULL,
  nombre text NOT NULL,
  apellido text NOT NULL,
  email text NOT NULL,
  password text NOT NULL,
  perfil integer NOT NULL,
  fecha_creacion date NOT NULL,
  estado_usuario boolean NOT NULL DEFAULT TRUE
  )
WITH (
  OIDS=FALSE
);
ALTER TABLE public.par_usuarios
  OWNER TO polisilabo;
-----------------------------------------------------------------------------
CREATE TABLE public.par_facultad --Tabla Facultad
(
  id SERIAL PRIMARY KEY,
  nombre_facultad text NOT NULL,
  ciudad_facultad text NOT NULL,
  id_creador integer references par_usuarios(id) NOT NULL,
  fecha_creacion date NOT NULL,
  estado_facultad boolean NOT NULL DEFAULT TRUE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.par_facultad
  OWNER TO polisilabo;
-----------------------------------------------------------------------------  
CREATE TABLE public.par_departamento --Tabla Departamento
(
  id SERIAL PRIMARY KEY,
  id_facultad integer references par_facultad(id),
  nombre_departamento text NOT NULL,
  ciudad_departamento text NOT NULL,
  id_creador integer references par_usuarios(id) NOT NULL,
  fecha_creacion date NOT NULL,
  estado_departamento boolean NOT NULL DEFAULT TRUE
  )
WITH (
  OIDS=FALSE
);
ALTER TABLE public.par_departamento
  OWNER TO polisilabo;
-----------------------------------------------------------------------------  
CREATE TABLE public.par_materias --Tabla Materias
(
  id SERIAL PRIMARY KEY,
  cod_materia integer UNIQUE,
  nombre text NOT NULL,
  descripcion text NOT NULL,
  logro text NOT NULL,
  modalidad text NOT NULL,
  no_creditos integer NOT NULL,
  duracion text NOT NULL,
  tipo_asignatura text NOT NULL,
  id_creador integer references par_usuarios(id) NOT NULL,
  fecha_creacion date NOT NULL,
  estado_materia boolean NOT NULL DEFAULT TRUE
  )
WITH (
  OIDS=FALSE
);
ALTER TABLE public.par_materias
  OWNER TO polisilabo;
-----------------------------------------------------------------------------  
CREATE TABLE public.par_competencia --Tabla Competencia
(
  id SERIAL PRIMARY KEY,
  cod_competencia integer,
  descripcion text NOT NULL,
  id_creador integer references par_usuarios(id) NOT NULL,
  fecha_creacion date NOT NULL,
  estado_competencia boolean NOT NULL DEFAULT TRUE
  )
WITH (
  OIDS=FALSE
);
ALTER TABLE public.par_competencia
  OWNER TO polisilabo;
-----------------------------------------------------------------------------  
CREATE TABLE public.par_nucleo_tematico --Tabla Núcleo Tematico
(
  id SERIAL PRIMARY KEY,
  nombre text NOT NULL,
  cod_materia integer references par_materias(cod_materia),
  id_creador integer references par_usuarios(id) NOT NULL,
  fecha_creacion date NOT NULL,
  estado_nucleo boolean NOT NULL DEFAULT TRUE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.par_nucleo_tematico
  OWNER TO polisilabo;
-----------------------------------------------------------------------------
CREATE TABLE public.par_eje --Tabla Eje
(
  id SERIAL PRIMARY KEY,
  cod_materia integer references par_materias(cod_materia),
  descripcion text NOT NULL,
  id_creador integer references par_usuarios(id)  NOT NULL,
  fecha_creacion date NOT NULL,
  estado_nucleo boolean NOT NULL DEFAULT TRUE
 )
WITH (
  OIDS=FALSE
);
ALTER TABLE public.par_eje
  OWNER TO polisilabo;
-----------------------------------------------------------------------------
CREATE TABLE public.par_nucleo_eje --Tabla Núcleo Temático X Eje
(
  id SERIAL PRIMARY KEY,
  nucleo text references par_nucleo_tematico(id) NOT NULL,
  eje text references par_eje(id) NOT NULL
 )
WITH (
  OIDS=FALSE
);
ALTER TABLE public.par_nucleo_eje
  OWNER TO polisilabo;
----------------------------------------------------------------------------- 
CREATE TABLE public.par_objetivo --Tabla Objectivo
(
  id SERIAL PRIMARY KEY,
  cod_materia integer references par_materias(cod_materia),
  descripcion text NOT NULL,
  id_creador integer references par_usuarios(id)  NOT NULL,
  fecha_creacion date NOT NULL,
  estado_nucleo boolean NOT NULL DEFAULT TRUE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.par_objetivo
  OWNER TO polisilabo;
-----------------------------------------------------------------------------
CREATE TABLE public.par_nucleo_objectivo --Tabla Núcleo Temático X Objectivo
(
  id SERIAL PRIMARY KEY,
  nucleo integer references par_nucleo_tematico(id),
  objectivo text references par_objectivo(id) NOT NULL
 )
WITH (
  OIDS=FALSE
);
ALTER TABLE public.par_nucleo_objectivo
  OWNER TO polisilabo;
-----------------------------------------------------------------------------  
