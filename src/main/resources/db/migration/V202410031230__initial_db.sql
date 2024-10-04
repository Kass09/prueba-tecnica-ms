CREATE TABLE IF NOT EXISTS gender
(
  id serial PRIMARY KEY not null,
  name varchar(30) not null,
  code varchar(3) not null

);

CREATE TABLE IF NOT EXISTS type_identification
(
  id serial PRIMARY KEY not null,
  name varchar(30) not null,
  code varchar(6) not null

);

CREATE TABLE IF NOT EXISTS insured
(
    id serial PRIMARY KEY not null,
    type_identification_id int not null,
    numb_identification varchar(30) not null,
    lastname varchar(30) not null,
    full_name varchar(50) not null,
    gender_id int not null,
    birthdate timestamp not null,
    FOREIGN KEY (gender_id) REFERENCES gender (id),
    FOREIGN KEY (type_identification_id) REFERENCES type_identification (id)
);

CREATE TABLE IF NOT EXISTS amparo
(
  id serial PRIMARY KEY not null,
  name varchar(30) not null

);

CREATE TABLE IF NOT EXISTS primas
(
  id serial PRIMARY KEY not null,
  amparo_id int not null,
  minimum_age int not null,
  maximum_age int not null,
  prima_percentage numeric(5, 4) not null,
  FOREIGN KEY (amparo_id) REFERENCES amparo (id)

);

insert into gender(code, name) values ('M', 'Masculino');
insert into gender(code, name) values ('F', 'Femenino');

insert into type_identification (name, code) values ('Cédula ciudadanía','CC');
insert into type_identification (name, code) values ('Cédula Extranjería','CE');

insert into amparo (name) values ('Muerte accidental');
insert into amparo (name) values ('Desmembración');
insert into amparo (name) values ('Auxilio funerario');
insert into amparo (name) values ('Renta vitalicia');