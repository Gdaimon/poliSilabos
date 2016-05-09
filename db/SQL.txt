CREATE DATABASE polisilabo
  WITH OWNER = postgres

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
ALTER TABLE public.par_departamento
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

  insert into par_facultad("nombre_facultad","ciudad_facultad","id_creador","fecha_creacion","estado_facultad") values 
('Facultad de Ciencias Administrativas, Económicas y Contables','Bogotá','1','2016-06-05','TRUE'),
('Facultad de Ingeniería y Ciencias Básicas','Bogotá,'1','2016-06-05','TRUE'),
('Facultad de Mercadeo, Comunicación y Artes','Bogotá','1','2016-06-05','TRUE'),
('Facultad de Ciencias Sociales','Bogotá','1','2016-06-05','TRUE');

insert into par_departamento("id_facultad","nombre_departamento","ciudad_departamento","id_creador","fecha_creacion","estado_departamento")values 
('7','Ciencias básicas','Bogotá','1','2016-05-09','TRUE'),
('7','Ingeniería de sistemas y telecomunicaciones','Bogotá','1','2016-05-09','TRUE'),
('6','Ingeniería industrial','Bogotá','1','2016-05-09','TRUE'),
('6','Administración','Bogotá','1','2016-05-09','TRUE'),
('7','Ingeniería y Ciencias Básicas','Bogotá','1','2016-05-09','TRUE'),
('6','Economía e Internacional','Bogotá','1','2016-05-09','TRUE');

insert into par_usuarios("id_usuario","tipo_cedula","nombre","apellido","email","password","perfil","id_creador",
"fecha_creacion","estado_usuario")
values 
('99123465','CE','Mauricio','NishidaP','mauricio@poligran.edu.co','1234','1','1','2016-05-09','TRUE'),
('12345678','CC','Carlos','Charris','carlos@poligran.edu.co','1234','1','1','2016-05-09','TRUE'),
('12345677','CC','Diego','Meza','diego@poligran.edu.co','1234','1','1','2016-05-09','TRUE'),
('12345676','CC','Alejandro','Gaitan','Alejandro@poligran.edu.co','1234','1','1','2016-05-09','TRUE')
insert into par_materias("cod_materia","nombre","descripcion","logro","modalidad","no_creditos","duracion","tipo_asignatura","id_creador","fecha_creacion","estado_materia")
values
('1002','Organización y métodos','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('1045','Gerencia de producción','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('1087','Gestión de talento humano','prueba','III','P','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('1203','Matemática financiera','prueba','III','P','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('1211','Estadística I','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('1237','Probabilidad','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('1238','Estadística inferencial','prueba','III','P','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('1252','Investigación de operaciones','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('1261','Análisis y verificación de algoritmos','prueba','III','P','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('1286','Teoría de juegos','prueba','III','P','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('1801','Fundamentos de economía','prueba','III','P','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('1861','Fundamentos de producción','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('2292','Simulación gerencial','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('2626','Estructuras de datos','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('2633','Elementos de la teoría de la computación','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('2640','Autómatas, gramáticas y lenguajes','prueba','III','P','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('2655','Gerencia de proyectos informáticos','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('2657','Ingeniería del software II','prueba','III','P','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('2658','Bases de datos','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('2664','Telecomunicaciones','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('2668','Arquitectura del computador','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('2689','Sistemas Distribuidos','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('2697','Práctica aplicada','prueba','III','P','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('2701','Procesos industriales','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('2702','Producción','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('2704','Distribución de planta','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('2707','Simulación','prueba','III','P','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('2712','Metaheurísticas','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('2714','Física de plantas','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('2717','Control de la calidad','prueba','III','P','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('2718','Automatización BPM','prueba','III','P','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('2719','Automatización industrial','prueba','III','P','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('2721','Logística y transporte','prueba','III','P','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('2734','Programación estocástica','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('2791','Programación de computadores','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('2799','Seguridad y salud ocupacional','prueba','III','P','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('2801','Contabilidad general','prueba','III','P','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('2840','Costos y presupuestos','prueba','III','P','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('4001','Dibujo técnico','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('7414','Sistemas de información en gestión logística','prueba','III','P','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('8020','Empaques y manejo de materiales','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('8021','Scheduling e Inventarios','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('9019','Pensamiento Algorítmico','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('9020','Introducción a la Ingeniería y Ciencias Básicas','prueba','III','P','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('9021','Herramientas de lógica computacional','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('9022','Ingeniería del software I','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('9024','Sistemas digitales y ensambladores','prueba','III','P','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('9025','Paradigmas de programación','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('9033','Introducción a la robótica','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('9034','Programación WEB con PHP','prueba','III','V','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE'),
('9036','Fundamentos de química para ingenieros','prueba','III','P','3','Semestral','Teórico-práctica','1','2016-05-09','TRUE')

insert into par_competencia("cod_competencia","descripcion","id_creador","fecha_creacion","estado_competencia")
values 
('100','Abstraer información y comportamiento de objetos del mundo real, utilizando herramientas formales, para la construcción de modelos que permitan el diseño de soluciones.','1','2016-05-09','TRUE'),
('101','Actuar de forma autónoma, ética y responsable.','1','2016-05-09','TRUE'),
('102','Actuar de manera autónoma, ética y responsable.','1','2016-05-09','TRUE'),
('103','Adoptar nuevos conceptos y aceptar su estudio y desarrollo.','1','2016-05-09','TRUE'),
('104','Adquirir conocimientos en seguridad e higiene ocupacional para aportar a la preservación de los elementos que intervienen en una organización .','1','2016-05-09','TRUE'),
('105','Analizar e interpretar la información financiera de una organización así como también los fundamentos de economía.','1','2016-05-09','TRUE'),
('106','Analizar la información asociada con un problema de decisión, con el fin de identificar las relaciones principales entre los elementos que lo componen.','1','2016-05-09','TRUE'),
('107','Analizar y mejorar el desempeño de sistemas de telecomunicaciones.','1','2016-05-09','TRUE'),
('108','Analizar y presentar soluciones a problemas basados en los conocimientos básicos.','1','2016-05-09','TRUE'),
('109','Aplica conceptos básicos de administración y gerencia de un proyecto de software.','1','2016-05-09','TRUE'),
('110','Aplica las metodologías alternas que se tienen para el desarrollo de software.','1','2016-05-09','TRUE'),
('111','Aplicabilidad práctica de la ingeniería y la tecnología.','1','2016-05-09','TRUE'),
('112','Aplicar los conocimientos matemáticos para medir la calidad de un proceso, producto o servicio que permitan dar un diagnóstico que incorpore los conceptos y herramientas de control estadístico.','1','2016-05-09','TRUE'),
('113','Aplicar conceptos teóricos de ingeniería industrial en prácticas supervisadas en el laboratorio.','1','2016-05-09','TRUE'),
('114','Aplicar conocimientos teóricos y prácticos en la planeación, diseño y operación de servicios de redes de telecomunicaciones.','1','2016-05-09','TRUE'),
('115','Aplicar diferentes metodologías de Ingeniería de Software para la construcción de Sistemas de Tecnología de Información y Telecomunicaciones.','1','2016-05-09','TRUE'),
('116','Aplicar el campo jurídico-normativo relacionado con las telecomunicaciones y los sistemas informáticos.','1','2016-05-09','TRUE'),
('117','Aplicar esquemas de funcionamiento que requieran diversos conceptos simultáneamente, organizar situaciones complejas como estructuras basadas en principios simples, resolver matemáticamente planteamientos de casos particulares, asociar un esquema o sistema físico o químico con leyes naturales o propiedades matemáticas y entender el vínculo entre su resolución y las leyes que lo sustentan.','1','2016-05-09','TRUE'),
('118','Aplicar herramientas de análisis y diseño en la construcción y creación de sistemas de información y soluciones en telecomunicaciones.','1','2016-05-09','TRUE'),
('119','Aplicar las mejores prácticas en lo referente a la construcción y ejecución de proyectos informáticos.','1','2016-05-09','TRUE'),
('120','Aplicar las metodologías existentes en la gestión de proyectos para lograr su culminación con existo.','1','2016-05-09','TRUE'),
('121','Aplicar los modelos y algoritmos estudiados en casos particulares o problemas típicos.','1','2016-05-09','TRUE'),
('122','Aplicar modelos matemáticos en el planteamiento de problemas.','1','2016-05-09','TRUE'),
('123','Aplicar procedimientos algorítmicos avanzados para la solución de problemas.','1','2016-05-09','TRUE'),
('124','Aplicar técnicas de análisis probabilístico para el mejoramiento del desempeño de sistemas productivos y del área de servicios.','1','2016-05-09','TRUE'),
('125','Aprender a utilizar herramientas tecnológicas actuales para la implementación de soluciones tecnologicas en el sector TIC.','1','2016-05-09','TRUE'),
('126','Aprender autónomamente el dominio de las herramientas tecnológicas actuales para la implementación de soluciones de sistemas, esto incluye lenguajes de programación, ambientes de programación, metodologías, paradigmas de desarrollo, librerías, frameworks, etc.','1','2016-05-09','TRUE'),
('127','Asimilar problemas de índole tridimensional para ser aplicadas en el desarrollo de producto.','1','2016-05-09','TRUE'),
('128','Asociar conceptos, comprender sus implicaciones teóricas, predecir las consecuencias numéricas, esclarecer las diferencias entre diversos casos y componer marcos conceptuales a partir de diferentes principios.','1','2016-05-09','TRUE'),
('129','Asumir un rol en el trabajo en equipo, integrando aspectos tales como autonomía, liderazgo, responsabilidad, creatividad, puntualidad, honestidad y respeto.','1','2016-05-09','TRUE'),
('130','Asumir una postura responsable sobre los éxitos y fracasos en todas las actividades del quehacer académico.','1','2016-05-09','TRUE'),
('131','Comprender e interpretar apropiadamente los resultados obtenidos al implementar un problema de optimización.','1','2016-05-09','TRUE'),
('132','Comprender ideas principales de textos producidos en inglés y elaboración de documentos propios.','1','2016-05-09','TRUE'),
('133','Comprender una situación compleja y descomponerla en partes más simples, estableciendo relaciones lógicas entre ellas.','1','2016-05-09','TRUE'),
('134','Comprender y crear una visión crítica acerca de las implicaciones sociales, culturales, económicas, laborales y demás, de las soluciones tecnológicas que se plantean.','1','2016-05-09','TRUE'),
('135','Comunicar con claridad y precisión diferentes tipos razonamientos.','1','2016-05-09','TRUE'),
('136','Comunicar eficientemente ideas y proyectos.','1','2016-05-09','TRUE'),
('137','Comunicarse efectivamente con el otro mediante el empleo de medios de expresión oral, escrita, gráfica y formas no verbales','1','2016-05-09','TRUE'),
('138','Conocer las metodologías para la identificación , evaluación, control de riesgos y valoración de accidentes de trabajo.','1','2016-05-09','TRUE'),
('139','Conocer técnicas modernas para la mejora de la calidad de las empresas, las formas de aplicarlas y los beneficios que se pueden obtener de su implementación.','1','2016-05-09','TRUE'),
('140','Construir y analizar argumentos matemáticos que modelan y analizan situaciones tanto abstractas como físicas.','1','2016-05-09','TRUE'),
('141','Construir y evaluar propuestas de negocio asociada a proyectos de infraestructura, seguridad y servicios de TICs.','1','2016-05-09','TRUE'),
('142','Construye e interpreta los diversos indicadores utilizados para medir la calidad del software.','1','2016-05-09','TRUE'),
('143','Crear relaciones con otros profesionales de diferentes disciplinas para gestionar proyectos.','1','2016-05-09','TRUE'),
('144','Crear un juicio crítico ante problemáticas ambientales.','1','2016-05-09','TRUE'),
('145','Crear un pensamiento analítico y el conocimiento ante un panorama innovador.','1','2016-05-09','TRUE'),
('146','Desarrollar habilidades efectivas de gestión en proyectos de desarrollo de software.','1','2016-05-09','TRUE'),
('147','Desarrollar habilidades efectivas de gestión en proyectos de infraestructura, seguridad y servicios de TICs.','1','2016-05-09','TRUE'),
('148','Desarrollar la autonomía intelectual en las áreas básicas del programa como las matemáticas, física, química y lecto-escritura.','1','2016-05-09','TRUE'),
('149','Desarrollar sistemas de información, a través de simulaciones, bien sea programadas o desarrolladas desde su base.','1','2016-05-09','TRUE'),
('150','Desarrollar un pensamiento afín al desarrollo sostenible y la creación de productos basados en la investigación.','1','2016-05-09','TRUE'),
('151','Desarrollar un pensamiento innovador y emprendedor para la creación de empresa o proyectos ambientales.','1','2016-05-09','TRUE'),
('152','Detectar oportunidades de trabajo, negocio y desarrollo en beneficio de sí mismo y de su comunidad.','1','2016-05-09','TRUE'),
('153','Determinar el modelo pertinente que se deba emplear en una situación. Realizar las representaciones para aplicarlo, así como los cálculos necesarios para resolverlo, o para hacer predicciones a partir de él.','1','2016-05-09','TRUE'),
('154','Dimensionar aspectos tecnicos en proyectos de infraestructura, seguridad y servicios de TICs.','1','2016-05-09','TRUE'),
('155','Diseñar procesos, componentes y sistemas teniendo en cuenta restricciones del entorno para satisfacer las necesidades del mismo.','1','2016-05-09','TRUE'),
('156','Diseñar y conducir experimentos, analizar e interpretar datos propios de los problemas que competen al diseño y planeación de sistemas productivos automatizados y de plantas industriales.','1','2016-05-09','TRUE'),
('157','Diseñar y contrastar hipótesis, a partir de la información o de los conocimientos de una investigación, con el propósito de producir un avance en el desarrollo de nuevos conocimientos.','1','2016-05-09','TRUE'),
('158','Dominar el lenguaje y métodos matemáticos indispensables para lograr comprensión de problemas y discusiones cotidianas contemporáneas en el área de ingeniería.','1','2016-05-09','TRUE'),
('159','Emplear adecuadamente modelos interpretativos de fenómenos de la naturaleza para enfrentar un problema que implica un número mínimo de variables.','1','2016-05-09','TRUE'),
('160','Emplear estrategias de estudio efectivas que promuevan la motivación intrínseca en el proceso de aprendizaje.','1','2016-05-09','TRUE'),
('161','Entender el impacto de las soluciones de la ingeniería en un contexto económico, ambiental y social en la evolución y actualización de los mercados en los que se encuentra inmerso.','1','2016-05-09','TRUE'),
('162','Establecer relaciones entre variables e identificar las diferencias entre sus comportamientos.','1','2016-05-09','TRUE'),
('163','Evaluar Sistemas de Tecnologías de Información, tanto software como hardware, a partir de diferentes criterios.','1','2016-05-09','TRUE'),
('164','Explicar un fenómeno y generar un modelo interpretativo del mismo, que permita la fragmentación de éste en sus variables y la planificación de cómo estudiarlo.','1','2016-05-09','TRUE'),
('165','Explorar diferentes fuentes de información y conocimiento para el aprendizaje de diferentes Tecnologías de Información y Telecomunicaciones.','1','2016-05-09','TRUE'),
('166','Explorar diferentes fuentes de información y conocimiento para el aprendizaje de temas asociados a la infraestructura, la seguridad y la gestión de TICs.','1','2016-05-09','TRUE'),
('167','Fomentar un pensamiento emprendedor desde las ciencias básicas y su utilización para aquello.','1','2016-05-09','TRUE'),
('168','Fortalecer el concepto de planeación al interior de las organizaciones mediante la aplicación de conocimientos, con el fin de mejorar su competitividad.','1','2016-05-09','TRUE'),
('169','Fortalecer la capacidad para el aprendizaje autónomo y/o la aplicación de conocimientos, de técnicas y metodologías exitosas de estudio.','1','2016-05-09','TRUE'),
('170','Generar confianza en los demás a través la honestidad, sinceridad, respeto, lealtad y demás valores.','1','2016-05-09','TRUE'),
('171','Generar estrategias de trabajo efectivo en equipo.','1','2016-05-09','TRUE'),
('172','Generar iniciativas empresariales a nivel de los sistemas y las telecomunicaciones.','1','2016-05-09','TRUE'),
('173','Gestionar dispositivos pertenecientes a la infraestructura de una red de telecomunicaciones.','1','2016-05-09','TRUE'),
('174','Gestionar y auditar las normativas más relevantes para el diagnóstico, mejoramiento y seguridad industrial en las organizaciones.','1','2016-05-09','TRUE'),
('175','Hacer lectura crítico-reflexiva del impacto de las tecnologías de la información y la comunicación en lo social, político, económico, nacional e internacional.','1','2016-05-09','TRUE'),
('176','Identifica las diferentes fases del ciclo de vida de un proyecto de desarrollo de software de acuerdo a los diferentes modelos de proceso que existen actualmente.','1','2016-05-09','TRUE'),
('177','Identifica los aspectos básicos relacionados con la administración de proyectos de software y las métricas del mismo.','1','2016-05-09','TRUE'),
('178','Identifica los conceptos principales involucrados en el paradigma de la Programación Orientada a Objetos y su utilidad en el desarrollo de proyectos enfocados en el mismo.','1','2016-05-09','TRUE'),
('179','Identifica los estándares de codificación para los diferentes lenguajes de programación así como las mejores prácticas de programación para realizar un código legible de fácil entendimiento.','1','2016-05-09','TRUE'),
('180','Identificar cuales variables o parámetros son los más relevantes en la dinámica del sistema, y así mismo descartar aspectos irrelevantes, o de poca incidencia con el fin de llegar a modelos matemáticos que permitan soluciones analíticas.','1','2016-05-09','TRUE'),
('181','Identificar de manera clara y objetiva el inicio y final de todo proyecto involucrando las respectivas variables en cada fase.','1','2016-05-09','TRUE'),
('182','Identificar diferentes fenómenos y leyes físicas en el comportamiento de Sistemas de Tecnología, Información y Telecomunicaciones, y analizar su influencia en el funcionamiento de los mismos.','1','2016-05-09','TRUE'),
('183','Identificar elementos constitutivos de un problema, construir posibles vías de solución a la luz de sus variables y desarrollar procesos planificados y sistematizados de resolución.','1','2016-05-09','TRUE'),
('184','Identificar información, organizarla, seleccionarla y validar fuentes y métodos de obtención de la misma.','1','2016-05-09','TRUE'),
('185','Identificar los posibles riesgos que se pueden presentar en un proyecto.','1','2016-05-09','TRUE'),
('186','Identificar tendencias en el desarrollo de la tecnologías utilizadas en el sector TICs.','1','2016-05-09','TRUE'),
('187','Identificar variables y/o parámetros relevantes en la dinámica del sistema, y así mismo descartar aspectos irrelevantes, o de poca incidencia con el fin de llegar a modelos matemáticos que permitan soluciones analíticas.','1','2016-05-09','TRUE'),
('188','Identificar variables, constantes y parámetros, las relaciones que pueden existir entre ellos y sus diversas representaciones matemáticas.','1','2016-05-09','TRUE'),
('189','Identificar, formular y resolver problemas presentes en el control y administración de la producción, así como también en el diseño y localización de plantas industriales.','1','2016-05-09','TRUE'),
('190','Identificar, formular y resolver problemas relacionados al área de Ingeniería Industrial','1','2016-05-09','TRUE'),
('191','Implementar adecuadamente soluciones a situaciones problémicas que involucren sistemas tecnológicos.','1','2016-05-09','TRUE'),
('192','Implementar un pensamiento crítico y afectivo ante las nuevas tecnologías de un mundo globalizado.','1','2016-05-09','TRUE'),
('193','Interpretar datos presentados de diferentes formas (tablas, gráficas, esquemas, símbolos, expresión verbal); así como generar diferentes representaciones a partir de datos.','1','2016-05-09','TRUE'),
('194','Interpretar y aplicar información técnica, normativa y legal asociada a proyectos de infraestructura, seguridad y servicios de TICs.','1','2016-05-09','TRUE'),
('195','Manejar habilidades emocionales intrapersonales para un efectivo desarrollo de las actividades.','1','2016-05-09','TRUE'),
('196','Manejar sus sentimientos y pensamientos hacia el logro de sus metas y propósitos, sin perder de vista la manera como esto se relaciona con las dinámicas sociales en que está inmerso.','1','2016-05-09','TRUE'),
('197','Manejo de componentes y equipo electrónico con aplicaciones a la programación.','1','2016-05-09','TRUE'),
('198','Medir y gestionar los impactos que la incorporacón de las tecnologias de telecomunicaciones, tienen en el ambito, social, político, económico, ambiental.','1','2016-05-09','TRUE'),
('199','Modelar problemas de forma conceptual y matemática con el fin de proponer posibles soluciones a problemas propios de la ingeniería industrial.','1','2016-05-09','TRUE'),
('200','Obtener, resumir, organizar, analizar e interpretar conjuntos de información (grandes), con el propósito de contribuir al esclarecimiento de un problema o de una pregunta.','1','2016-05-09','TRUE'),
('201','Organizar estrategias de trabajo que permitan procesos eficientes y resultados exitosos.','1','2016-05-09','TRUE'),
('202','Participar activamente, en el aula de clase, en la construcción y generación de conocimiento.','1','2016-05-09','TRUE'),
('203','Participar con liderazgo en trabajos y proyectos que impliquen el trabajo en equipo.','1','2016-05-09','TRUE'),
('204','Plantear procesos relacionados con la identificación de un problema o la formulación de una pregunta, y la construcción/proposición de estrategias adecuadas para su solución en la situación presentada, además de presentar el tratamiento de datos, la modelación y el uso de herramientas cuantitativas.','1','2016-05-09','TRUE'),
('205','Plantear soluciones a los problemas empresariales, basándose en la comunicación asertiva para la toma de decisiones.','1','2016-05-09','TRUE'),
('206','Plantear, diseñar e implementar Sistemas de Tecnología, Información y Telecomunicaciones capaces de resolver una problemática en un contexto dado, con restricciones identificadas y recursos definidos.','1','2016-05-09','TRUE'),
('207','Poseer habilidades sociales efectivas a la hora de relacionarse y comunicarse.','1','2016-05-09','TRUE'),
('208','Presentar juicio crítico ante los conocimientos recibidos y sin embargo mostrar una actitud flexible ante los mismos.','1','2016-05-09','TRUE'),
('209','Proponer algoritmos y estrategias óptimas de solución a diversos problemas aplicables a ambientes reales.','1','2016-05-09','TRUE'),
('210','Realizar actividades investigativas en problemas propios de la ingeniería industrial.','1','2016-05-09','TRUE'),
('211','Realizar el análisis sistemático de conceptos y teorías relacionadas con problemas propios de la ingeniería industrial.','1','2016-05-09','TRUE'),
('212','Reconocer elementos constitutivos de un problema, construir posibles vías de solución a la luz de sus variables y desarrollar procesos planificados y sistematizados de resolución.','1','2016-05-09','TRUE'),
('213','Reconocer entornos de actuación y establecer relaciones interpersonales adecuadas, pertinentes para el desarrollo de la personalidad.','1','2016-05-09','TRUE'),
('214','Relacionar variables independientes, dependientes e intervinientes y planificar alternativas de solución con criterios bioéticos y de efecto ambiental positivo o de mínimo riesgo.','1','2016-05-09','TRUE'),
('215','Ser consciente de los valores y de los objetivos personales en relación con los objetivos de grupo y de comunidad.','1','2016-05-09','TRUE'),
('216','Ser emprendedor, capaz de decidir en condiciones de incertidumbre valorando las consecuencias que ello implica.','1','2016-05-09','TRUE'),
('217','Servirse de la autodisciplina para la ejecución de tareas de manera efectiva.','1','2016-05-09','TRUE'),
('218','Tener consciencia de la autodisciplina como elemento clave en la ejecución de tareas.','1','2016-05-09','TRUE'),
('219','Tener consciencia sobre la importancia y necesidad de un desarrollo profesional continuo.','1','2016-05-09','TRUE'),
('220','Tener la capacidad y el poder de decisión para poner en acción, actuar y crear sobre algún proyecto o plan de vida.','1','2016-05-09','TRUE'),
('221','Tomar decisiones informadas para la incorporación de nuevas tecnologías, enmarcadas en proyectos de infraestructura, seguridad y servicios de TICs.','1','2016-05-09','TRUE'),
('222','Trabajar en medio de las diferencias para fijar metas comunes y producir resultados colectivos.','1','2016-05-09','TRUE'),
('223','Traducir del lenguaje verbal al lenguaje formal o simbólico; deducir implicaciones necesarias no visibles a partir de enunciados incompletos y proponer procedimientos de solución no convencionales con base en el conocimiento de variables implicadas y rutas convencionales de solución.','1','2016-05-09','TRUE'),
('224','Utilizar de forma responsable y reflexiva, estrategias de e-learning incorporado a contextos de aprendizaje de disciplinas del conocimiento.','1','2016-05-09','TRUE'),
('225','Utilizar estrategias para la protección de la humanidad y el medio ambiente.','1','2016-05-09','TRUE'),
('226','Utilizar herramientas informáticas CAD y CAM como herramientas de comunicación en el ámbito de la ingeniería.','1','2016-05-09','TRUE'),
('227','Utilizar sistemas de Tecnología, Información y Telecomunicaciones que permitan la recreación de un modelo, que permita resolver problemas en el mundo real.','1','2016-05-09','TRUE'),
('228','Utilizar técnicas, destrezas y herramientas propias de la ingeniería para aplicarla a problemas determinísticos y estocásticos de una organización.','1','2016-05-09','TRUE'),
('229','Validar soluciones, ya sea tecnológicas o de otra índole, planteadas a problemas o necesidades del contexto local o global.','1','2016-05-09','TRUE'),
('230','Verificar resultados, hipótesis o conclusiones que se derivan de la interpretación y de la modelación de situaciones.','1','2016-05-09','TRUE')


insert into par_nucleo_tematico ("id_materia","nombre","descripcion","id_creador","fecha_creacion","estado_nucleo")
values
('1','Conceptos básicos y diseño de producto','Es importante contextualizar el diseño, desarrollo y mejora de productos y procesos en el entorno actual.','1','2016-05-09','TRUE'),
('1','Conceptos básicos y diseño de producto','Identificar las etapas que se deben concebir al momento de diseñar y elaborar innovación de productos en las organizaciones.','1','2016-05-09','TRUE'),
('1','Conceptos básicos y diseño de producto','Se realiza el análisis de las estadísticas básicas para el mejoramiento de la calidad dentro de una empresa','1','2016-05-09','TRUE'),
('1','Gestion de proyectos.','Modelos de decisión bajo incertidumbre: Programación de proyectos CPM, Ruta crítica y varianza de la duración de un proyecto.','1','2016-05-09','TRUE'),
('1','Estudio del trabajo.','Para determinar adecuadamente los elementos que componen un proceso de producción, es necesario introducir algunas definiciones relacionadas con la fabricación y disposición de la fábrica.Producción por posición fija.Producción en serie.Instalación funcional operaciones mecanizadas.Operaciones automatizadas.Tendencias productivas (maquiladores - outsourcing).Dentro de los temas para optimización del trabajo y el incremento de la productividad está asociado a la medición y análisis de los procesos productivos y los puestos de trabajo.Diseño del método de trabajo.Tiempos y movimientos.El muestreo del trabajo.Técnicas para el diseño de métodos.Diseño del puesto de trabajo.•Los aspectos humanos de la producción (ERGONOMIA).•        Las condiciones físicas de trabajo y la seguridad."','1','2016-05-09','TRUE'),
('1','Medición de la capacidad','Ningún producto o proceso, se elabora por sí solo, requiere  recursos físicos, humanos, de capital, técnicos y administrativos que es necesario optimizar.•        Cadena de valor.•        Ampliación de capacidad.•        Análisis de la capacidad de la planta.•        Requerimientos de capacidad.•        Subproductos y re-procesos.','1','2016-05-09','TRUE'),
('1','Distribución y ubicación de planta.','Uno de los factores relevantes en el mejoramiento y competitividad de las organizaciones productivas es la ubicación y distribución de sus instalaciones. •     Balanceo de líneas.•        Ubicación y distribución de instalaciones.•        Distribución de instalaciones.•        Patrones de flujo.•        Distribuciones de planta básicas.','1','2016-05-09','TRUE'),
('1','Estudio de materiales.','Uno de los factores importantes del éxito de un producto se encuentra en el tipo de material o aleación de la cual se encuentra hecho, ya que esto permite dar garantías sobre la calidad del mismo. Por tanto se debe investigar sobre:•        Propiedades físicas (moleculares).•        Resistencia, fluencia, elasticidad.•        Procesos de transformación de cada uno de los materiales.•        Procesos generalizados que se deben tener en cuenta al manejar cada tipo de producto.','1','2016-05-09','TRUE'),
('1','Conceptos básicos y diseño de producto','Conocer y aplicar las 7 herramientas por excelencia para la mejora de la calidad.','1','2016-05-09','TRUE'),
('1','Gestion de proyectos.','1. Entender los principios para la optimización de los proyectos basados en rutas críticas.','1','2016-05-09','TRUE'),
('1','Estudio del trabajo.','1. Entender los tiempos que componen un trabajo y cómo este puede ser optimizado por medio de su estudio.','1','2016-05-09','TRUE'),
('1','Medición de la capacidad','Entender porqué la capacidad de una instalación es un factor crítico para la planeación de la estrategia de una compañía.','1','2016-05-09','TRUE'),
('1','Distribución y ubicación de planta.','Entender los conceptos básicos de distribución y las configuraciones típicas para la optimización del espacio.','1','2016-05-09','TRUE'),
('1','Estudio de materiales.','Entender las propiedades fisico-químicas que contienen cada tipo de material en la industria.','1','2016-05-09','TRUE')