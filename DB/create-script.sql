-- Table: public."DROOLSDRL"

-- DROP TABLE public."DROOLSDRL";

CREATE TABLE public."DROOLSDRL"
(
    "_ID" character varying(255) COLLATE pg_catalog."default" NOT NULL,
    "CLASSNAME" character varying(255) COLLATE pg_catalog."default",
    "DSL" text COLLATE pg_catalog."default",
    "NAME" character varying(255) COLLATE pg_catalog."default",
    "PKG" character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT "DROOLSDRL_PK" PRIMARY KEY ("_ID")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."DROOLSDRL"
    OWNER to postgres;