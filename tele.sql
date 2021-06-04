drop database TeleMedicina;

create database TeleMedicina;

use TeleMedicina;

create table paciente(
id int primary key not null auto_increment, 
nome varchar(200) not null, 
cpf varchar(15) unique not null,
idade int not null,
sexo varchar(10) not null,  
nascimento date not null, 
fone varchar(13) not null, 
endereco varchar(150) not null,
email varchar(200) unique not null, 
senha varchar(200) not null,
deletado boolean default false
);

create table clinica(
id int primary key not null auto_increment, 
cnpj varchar(15) unique not null,
nome varchar(200) not null, 
fone int not null, 
endereco varchar(150) not null
);

create table medico(
id int primary key not null auto_increment, 
nome varchar(200) not null, 
crm varchar(15) unique not null,
cpf varchar(15) unique not null,
idade int not null,
sexo varchar(10) not null,  
nascimento date not null, 
fone varchar(13) not null, 
endereco varchar(150) not null,
email varchar(200) unique not null, 
senha varchar(200) not null,
deletado boolean default false,
idClinica int not null,
FOREIGN KEY (idClinica) REFERENCES clinica(id)
);

create table consulta(
cpf varchar(15) not null,
crm varchar(15) not null,
data_consulta date,
descricao varchar(250),
FOREIGN KEY (cpf) REFERENCES paciente(cpf),
FOREIGN KEY (crm) REFERENCES medico(crm)
);

//---------------------------------------------------------------------------

INSERT INTO `paciente` (nome, 
cpf,
idade,
sexo,  
nascimento, 
fone, 
endereco,
email, 
senha) values
("Marcos", "123456789",15, "Masculino", "2001/12/24" , "123456", "Rua Maça" ,"marcos@email.com", "123");

INSERT INTO `paciente` (nome, 
cpf,
idade,
sexo,  
nascimento, 
fone, 
endereco,
email, 
senha) values
("Joao", "12345678",18, "Masculino" , "2008/08/23" , "123456", "Rua Maça" ,"joao@email.com", "123");

INSERT INTO `clinica` (cnpj,
nome, 
fone, 
endereco) values
("123456", "joão Clinica",12345678 ,"Rua das Bananas");

INSERT INTO `clinica` (cnpj,
nome, 
fone, 
endereco) values
("1234567", "marcos Clinica",123456789 ,"Rua das Uvas");

INSERT INTO `medico` ( nome,
crm,
cpf,
idade,
sexo,  
nascimento, 
fone, 
endereco,
email, 
senha,
idClinica) values
("Joao", "123456789", "12345",18 , "Masculino",  "1968/07/23", "123456", "Rua Maça" ,"joao1@email.com", "123", 1);

INSERT INTO `medico` ( nome,
crm,
cpf,
idade,
sexo,  
nascimento, 
fone, 
endereco,
email, 
senha,
idClinica) values
("Marcos", "12345678", "1234555",18, "Masculino", "1964/06/02", "123456", "Rua Maça" ,"marcos1@email.com", "123", 1);

INSERT INTO `consulta` ( cpf,
crm,
data_consulta,
descricao) values
("123456789", "123456789", "2009/05/18", "Tudo Ok");

INSERT INTO `consulta` ( cpf,
crm,
data_consulta,
descricao) values
("12345678", "12345678", "2015/03/08", "Tudo Errado");

select * from paciente;

select * from clinica;

select * from medico;

select * from consulta;

DELETE FROM clinica WHERE cnpj = 123456;

select * from medico where deletado = true;

update medico set deletado = true where crm = 12345678;