-- Polisilabo
-- Version 1 18-4-2016

-- CREATE SCHEMA polisilabo
--   AUTHORIZATION postgres;

-- GRANT ALL ON SCHEMA polisilabo TO postgres;
-- GRANT ALL ON SCHEMA polisilabo TO public;
-- COMMENT ON SCHEMA polisilabo
--   IS 'standard public schema';

CREATE DATABASE polisilabo
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'C'
       LC_CTYPE = 'C'
       CONNECTION LIMIT = -1;