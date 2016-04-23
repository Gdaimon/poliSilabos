CREATE TABLE Facultad (
	Sede_Facultad				VARCHAR(45),
	Nombre_Facultad				VARCHAR(60),
	PRIMARY KEY(Sede_Facultad,Nombre_Facultad)
);

CREATE TABLE Departamento (
	--Codigo_Dpto	    	VARCHAR(3),
	Codigo_Dpto					VARCHAR(4),
	Sede_Facultad	    		VARCHAR(45),
	Nombre_Facultad     		VARCHAR(60),
	Nombre_Dpto	    			VARCHAR(60),
	PRIMARY KEY(Codigo_Dpto)
);

CREATE TABLE Usuario (
	Tipo_cedula	     	 		VARCHAR(2),
	Cedula_Usuario	     		NUMERIC(10),
	Nombre_Usuario	     		VARCHAR(20),
	Apellido_Usuario     		VARCHAR(20),
	Perfil	             		NUMERIC(1),
	correo	             		VARCHAR(40),
	Clave	             		VARCHAR(10),
	Codigo_Dpto	         		VARCHAR(3),
	estado	             		VARCHAR(2),
	PRIMARY KEY(Tipo_Cedula,Cedula_Usuario)
);

CREATE TABLE Parametros (
	--CodigoParametro       NUMERIC(4),
	CodigoParametro       		VARCHAR(5),
	ItemParametro	      		NUMERIC(4),
	Nombre_Parametro      		VARCHAR(50),
	Tipo_Parametro        		VARCHAR(10),
	Descripcion_Parametro 		VARCHAR(60),
	PRIMARY KEY(CodigoParametro,ItemParametro)
);



CREATE TABLE Contiene_Competecia (
	Codigo_Competencia	  		VARCHAR(10),
	Version_Competencia   		NUMERIC(4),
	Codigo_Materia	      		VARCHAR(15),
	Modalidad_Materia	  		VARCHAR(1),
	Version_Nro_Materia	  		NUMERIC(4),
	PRIMARY KEY(Codigo_Competencia,Version_Competencia,Codigo_Materia,Modalidad_Materia,Version_Nro_Materia)
);

CREATE TABLE Materia (
	Codigo_Materia	  	  		VARCHAR(15),
	Modalidad_Materia     		VARCHAR(1),
	Nombre_Materia	      		VARCHAR(70),
	PRIMARY KEY(Codigo_Materia,Modalidad_Materia)
);

CREATE TABLE MateriaSilabo_Usuario (
	Codigo_Materia	  	  		VARCHAR(15),
	Modalidad_Materia 	  		VARCHAR(1),
	Tipo_cedula	   	      		VARCHAR(2),
	Cedula_Usuario	      		NUMERIC(10),
	PRIMARY KEY(Codigo_Materia,Modalidad_Materia,Tipo_cedula,Cedula_Usuario)
);

CREATE TABLE Competencia_Usuario (
	Codigo_Competencia	       	VARCHAR(10),
	Version_Competencia	       	NUMERIC(4),
	Tipo_cedula	           	   	VARCHAR(2),
	Cedula_Usuario	           	NUMERIC(10),
	PRIMARY KEY(Codigo_Competencia,Version_Competencia,Tipo_cedula,Cedula_Usuario)
);

CREATE TABLE Materia_Silabo (
	Codigo_Materia	           	VARCHAR(15),
	Modalidad_Materia          	VARCHAR(1),
	Version_Nro_Materia	 	   	NUMERIC(4),
	Creditos_Materia	       	NUMERIC(2),
	Bloque	                   	VARCHAR(15),
	Tipo_Materia	           	VARCHAR(20),
	Tipología_Modulo		   	VARCHAR(10),
	Vigencia_Desde_Materia	   	DATE,
	Estado_Materia	           	VARCHAR(10),
	Duracion_Materia		   	NUMERIC(2),
	Observaciones_Modificacion 	VARCHAR(150),
	Tipo_Cedula_Originante	   	VARCHAR(2),
	Cedula_Originante		   	NUMERIC(10),
	Codigo_Dpto	        	   	VARCHAR(3),
	PRIMARY KEY(Codigo_Materia,Modalidad_Materia,Version_Nro_Materia)
);

CREATE TABLE Descripciones_Generales (
	Codigo_Materia	           	VARCHAR(15),
	Modalidad_Materia	       	VARCHAR(1),
	Version_Nro_Materia	       	NUMERIC(4),
	Tipo_Descripcion	       	VARCHAR(10),
	Descripcion	               	VARCHAR(1600),
	PRIMARY KEY(Codigo_Materia,Modalidad_Materia,Version_Nro_Materia,Tipo_Descripcion)
);

CREATE TABLE Apoyos_Referenciales (
	Codigo_Materia	          	VARCHAR(15),
	Modalidad_Materia	      	VARCHAR(1),
	Version_Nro_Materia	      	NUMERIC(4),
	Tipo_Apoyo	              	VARCHAR(15),
	Nro_Item_Ref	         	NUMERIC(3),
	Descripcion	              	VARCHAR(250),
	PRIMARY KEY (Codigo_Materia,Modalidad_Materia,Version_Nro_Materia,Tipo_Apoyo,Nro_Item_Ref)
);

CREATE TABLE Nucleo_Tematico (
	Codigo_Materia	            VARCHAR(15),
	Modalidad_Materia	        VARCHAR(1),
	Version_Nro_Materia	        NUMERIC(4),
	Nro_Tematico	            NUMERIC(2),
	Nro_Item_Tem	            NUMERIC(3),
	Descripcion_Nucleo_Tematico VARCHAR(100),
	Ejes_Tematicos	            VARCHAR(1500),
	ObjetivoEspecifico	        VARCHAR(1000),
	PRIMARY KEY(Codigo_Materia,Modalidad_Materia,Version_Nro_Materia,Nro_Tematico,Nro_Item_Tem)
);

CREATE TABLE Prerequisito (
	Codigo_Materia	        	VARCHAR(15),
	Modalidad_Materia			VARCHAR(1),
	Version_Nro_Materia			NUMERIC(4),
	Codigo_Materia_Pre			VARCHAR(15),
	PRIMARY KEY (Codigo_Materia,Modalidad_Materia,Version_Nro_Materia,Codigo_Materia_Pre)
);

CREATE TABLE Observaciones_Silabo (
	Codigo_Materia	            VARCHAR(15),
	Modalidad_Materia	    	VARCHAR(1),
	Version_Nro_Materia	    	NUMERIC(4),
	Tipo_Cedula_Observacion	    VARCHAR(10),
	Cedula_Observacion	    	VARCHAR(10),
	Nombre_Observacion	    	VARCHAR(20),
	Apellido_Observacion	    VARCHAR(20),
	Descripcion_Observacion	    VARCHAR(200),
	Estado_observacion	    	VARCHAR(15),
	PRIMARY KEY(Codigo_Materia,Modalidad_Materia,Version_Nro_Materia,Tipo_Cedula_Observacion,Cedula_Observacion)
);

CREATE TABLE Aprobaciones_Silabo (
	Codigo_Materia	          	VARCHAR(15),
	Modalidad_Materia	  		VARCHAR(1),
	Version_Nro_Materia	  		NUMERIC(4),
	Cedula_Aprobador	  		VARCHAR(10),
	Tipo_Cedula_Aprobador     	VARCHAR(10),
	Nombre_aprobador	  		VARCHAR(20),
	Apellido_aprobador	  		VARCHAR(20),
	Nro_Aprobador	          	VARCHAR(10),
	Fecha_Aprobo	          	DATE,
	PRIMARY KEY(Codigo_Materia,Modalidad_Materia,Version_Nro_Materia,Tipo_Cedula_Aprobador,Cedula_Aprobador)
);

CREATE TABLE Silabo_Histo (
	Codigo_Materia	      		VARCHAR(15),
	Modalidad_Materia     		VARCHAR(1),
	Version_Silabo	      		VARCHAR(10),
	Codigo_Formato	      		VARCHAR(20),
	Vigencia_Desde_Silabo 		DATE,
	PRIMARY KEY(Codigo_Materia,Modalidad_Materia,Version_Silabo)
);

CREATE TABLE Seccion_Silabo (
	Codigo_Materia	           	VARCHAR(15),
	Modalidad_Materia	   		VARCHAR(1),
	Version_Silabo	           	VARCHAR(10),
	Nro_Seccion_Silabo	   		VARCHAR(4),
	Nro_Item_Silabo	           	NUMERIC(2),
	Descripcion_Seccion_Silabo 	VARCHAR(1600),
	PRIMARY KEY(Codigo_Materia,Modalidad_Materia,Version_Silabo,Nro_Seccion_Silabo,Nro_Item_Silabo)
)