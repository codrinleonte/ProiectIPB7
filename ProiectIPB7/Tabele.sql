DROP TABLE CONTURI;
DROP TABLE STUDENTI;
DROP TABLE PROFESORI;
DROP TABLE LISTA_LICENTE;
DROP TABLE DETALII_LICENTE;
DROP TABLE COMISII;
DROP TABLE INTERVAL_EVALUARE;
DROP TABLE SESIUNE;

CREATE TABLE CONTURI (
	id_cont number NOT NULL,
	username varchar(30) NOT NULL UNIQUE,
	parola varchar(30) NOT NULL,
	email varchar(50) NOT NULL UNIQUE,
	tip_utilizator varchar(20) NOT NULL,
	status number NOT NULL,
	PRIMARY KEY (id_cont)
);

CREATE TABLE STUDENTI (
	id_cont number NOT NULL,
	nr_matricol number(30) NOT NULL ,
	nume varchar(30) NOT NULL,
	prenume varchar(30) NOT NULL,
	promotia varchar(30) NOT NULL,
	PRIMARY KEY (nr_matricol)
);

CREATE TABLE PROFESORI (
	id_cont number NOT NULL,
	id_profesor number(20) NOT NULL ,
	nume varchar(20) NOT NULL,
	prenume varchar(20) NOT NULL,
	functie_in_comisie varchar(20) NOT NULL,
	grad_didactic varchar(20) NOT NULL,
	PRIMARY KEY (id_profesor)
);

CREATE TABLE LISTA_LICENTE (
	id_licenta number(20) NOT NULL ,
	id_profesor number(20) NOT NULL,
	id_student number(20) NOT NULL,
	PRIMARY KEY (id_licenta)
);

CREATE TABLE DETALII_LICENTE (
	id_licenta number NOT NULL ,
	titlu varchar(60) NOT NULL,
	materiale_licenta varchar(100) NOT NULL,
	nota_1 FLOAT(2) NOT NULL,
	nota_2 FLOAT(2) NOT NULL,
	nota_3 FLOAT(2) NOT NULL,
	nota_4_dizertatie FLOAT(2) NOT NULL,
	nota_finala FLOAT(2) NOT NULL,
	data_sustinere DATE NOT NULL,
	interval_orar varchar(10) NOT NULL,
	id_comisie varchar NOT NULL,
	PRIMARY KEY (id_licenta)
);

CREATE TABLE COMISII (
	id_comisie number NOT NULL ,
	id_prof1_sef number NOT NULL,
	id_prof2 number NOT NULL,
	id_prof3 number NOT NULL,
	id_prof4_dizertatie number NOT NULL,
	id_secretar number NOT NULL,
	tip_comisie varchar NOT NULL,
	id_evaluare number NOT NULL,
	PRIMARY KEY (id_comisie)
);

CREATE TABLE INTERVAL_EVALUARE (
	id_evaluare number NOT NULL ,
	id_sesiune number NOT NULL,
	id_comisie number NOT NULL,
	inceput_evaluare DATE NOT NULL,
	sfarsit_evaluare DATE NOT NULL,
	PRIMARY KEY (id_evaluare)
);

CREATE TABLE SESIUNE (
	id_sesiune number NOT NULL ,
	inceput_sesiune DATE NOT NULL,
	sfarsit_sesiune DATE NOT NULL,
	PRIMARY KEY (id_sesiune)
);
