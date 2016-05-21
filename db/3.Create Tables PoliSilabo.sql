-----------------------------------------------------------------------------
CREATE TABLE public.par_usuarios ( --Tabla Usuarios
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
) WITH (OIDS=FALSE);

ALTER TABLE public.par_usuarios OWNER TO polisilabo;
-----------------------------------------------------------------------------
CREATE TABLE public.par_facultad ( --Tabla Facultad
  id SERIAL PRIMARY KEY,
  nombre_facultad text NOT NULL,
  ciudad_facultad text NOT NULL,
  fecha_creacion date NOT NULL,
  estado_facultad boolean NOT NULL DEFAULT TRUE
) WITH (OIDS=FALSE);

ALTER TABLE public.par_facultad OWNER TO polisilabo;
-----------------------------------------------------------------------------  
CREATE TABLE public.par_departamento ( --Tabla Departamento
  id SERIAL PRIMARY KEY,
  id_facultad integer references par_facultad(id) NOT NULL,
  nombre_departamento text NOT NULL,
  ciudad_departamento text NOT NULL,
  fecha_creacion date NOT NULL,
  estado_departamento boolean NOT NULL DEFAULT TRUE
) WITH (OIDS=FALSE);

ALTER TABLE public.par_departamento OWNER TO polisilabo;
-----------------------------------------------------------------------------  
CREATE TABLE public.par_materias ( --Tabla Materias
  id SERIAL PRIMARY KEY,
  cod_materia integer UNIQUE NOT NULL,
  nombre text NOT NULL,
  descripcion text NOT NULL,
  logro text NOT NULL,
  modalidad text NOT NULL,
  no_creditos integer NOT NULL,
  duracion text NOT NULL,
  tipo_asignatura text NOT NULL,
  fecha_creacion date NOT NULL,
  estado_materia boolean NOT NULL DEFAULT TRUE
) WITH (OIDS=FALSE);

ALTER TABLE public.par_materias OWNER TO polisilabo;
-----------------------------------------------------------------------------  
CREATE TABLE public.par_competencia ( --Tabla Competencia
  id SERIAL PRIMARY KEY,
  cod_competencia integer NOT NULL,
  descripcion text NOT NULL,
  fecha_creacion date NOT NULL,
  estado_competencia boolean NOT NULL DEFAULT TRUE
) WITH (OIDS=FALSE);

ALTER TABLE public.par_competencia OWNER TO polisilabo;
-----------------------------------------------------------------------------  
CREATE TABLE public.par_nucleo_tematico ( --Tabla Núcleo Tematico
  id SERIAL PRIMARY KEY,
  nombre text NOT NULL,
  cod_materia integer references par_materias(cod_materia) NOT NULL,
  fecha_creacion date NOT NULL,
  estado_nucleo boolean NOT NULL DEFAULT TRUE
) WITH (OIDS=FALSE);

ALTER TABLE public.par_nucleo_tematico OWNER TO polisilabo;
-----------------------------------------------------------------------------
CREATE TABLE public.par_eje ( --Tabla Eje
  id SERIAL PRIMARY KEY,
  cod_materia integer references par_materias(cod_materia) NOT NULL,
  descripcion text NOT NULL,
  fecha_creacion date NOT NULL,
  estado_eje boolean NOT NULL DEFAULT TRUE
) WITH (OIDS=FALSE);

ALTER TABLE public.par_eje OWNER TO polisilabo;
-----------------------------------------------------------------------------
CREATE TABLE public.par_nucleo_eje ( --Tabla Núcleo Temático X Eje
  nucleo integer references par_nucleo_tematico(id) NOT NULL,
  eje integer references par_eje(id) NOT NULL
) WITH (OIDS=FALSE);

ALTER TABLE public.par_nucleo_eje OWNER TO polisilabo;
----------------------------------------------------------------------------- 
CREATE TABLE public.par_objetivo ( --Tabla Objetivo
  id SERIAL PRIMARY KEY,
  cod_materia integer references par_materias(cod_materia) NOT NULL,
  descripcion text NOT NULL,
  fecha_creacion date NOT NULL,
  estado_objetivo boolean NOT NULL DEFAULT TRUE
) WITH (OIDS=FALSE);

ALTER TABLE public.par_objetivo OWNER TO polisilabo;
-----------------------------------------------------------------------------
CREATE TABLE public.par_nucleo_objetivo ( --Tabla Núcleo Temático X Objetivo
  nucleo integer references par_nucleo_tematico(id) NOT NULL,
  objetivo integer references par_objetivo(id) NOT NULL
) WITH (OIDS=FALSE);

ALTER TABLE public.par_nucleo_objetivo OWNER TO polisilabo;
-----------------------------------------------------------------------------
CREATE TABLE public.par_silabo ( --Tabla Silabo
  id SERIAL PRIMARY KEY,
  departamento integer references par_departamento(id) NOT NULL,
  materia integer references par_materias(cod_materia) NOT NULL,
  desarrolloDidactico text NOT NULL,
  evaluacion text NOT NULL,
  apoyosReferenciales text NOT NULL
) WITH (OIDS=FALSE);

ALTER TABLE public.par_silabo OWNER TO polisilabo;
-----------------------------------------------------------------------------
CREATE TABLE public.par_silabo_competencia ( --Tabla Silabo X Competencia
  silabo integer references par_silabo(id) NOT NULL,
  competencia integer references par_competencia(id) NOT NULL
) WITH (OIDS=FALSE);

ALTER TABLE public.par_silabo_competencia OWNER TO polisilabo;
-----------------------------------------------------------------------------
CREATE TABLE public.par_silabo_nucleo ( --Tabla Silabo X Núcleo Temático
  silabo integer references par_silabo(id) NOT NULL,
  nucleoTematico integer references par_nucleo_tematico(id) NOT NULL
) WITH (OIDS=FALSE);

ALTER TABLE public.par_silabo_competencia OWNER TO polisilabo;
-----------------------------------------------------------------------------
CREATE TABLE public.par_usuario_facultad ( 
  id SERIAL PRIMARY KEY,
  id_usuario integer references par_usuarios(id) NOT NULL,
  id_facultad integer references par_facultad(id) NOT NULL,
  fecha_creacion date NOT NULL
  
) WITH (OIDS=FALSE);

ALTER TABLE public.par_usuario_facultad OWNER TO polisilabo;
