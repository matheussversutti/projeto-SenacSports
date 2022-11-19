--  linha abaixo cria um banco de dados
create database db_senacsports;

-- a linha a baixo escolhe o banco de dados
use db_senacsports;

-- O bloco de instruções abaixo cria uma tabela
create table cadastro_cliente(
CPF varchar(14) primary key not null unique,
nome varchar(50) not null,
endereco varchar(100) not null,
email varchar(50) not null,
sexo varchar(20) not null,
fone varchar(15),
estado_civil varchar(20)


);

select*from cadastro_cliente;
alter table cadastro_cliente
modify column CPF varchar(14);

delete from cadastro_cliente where cpf = "555.555.555-55";
Select * from cadastro_cliente WHERE CPF;




create table cadastro_produto
(
produto_id int primary key not null,
produto_name varchar(40) not null,
quant_produto int not null,
valor_produto decimal(9,2) not null


);

create table venda
(
id_compra int primary key auto_increment not null,
data_compra datetime not null,
valor_compra decimal(9,2) not null,
CPF varchar(11) not null,
pagamento varchar(20) not null,
constraint FK_CPFCom
foreign key (CPF) references cadastro_cliente (CPF)

);



insert into compra(data_compra, valor_compra, CPF, pagamento)
values(curtime(), "600", "49668945816", "Pix");
select * from venda;

create table venda
(
id_compra int primary key auto_increment not null,
data_compra datetime not null,
valor_compra decimal(9,2) not null,
CPF varchar(11) not null,
pagamento varchar(20) not null,
constraint FK_CPFCom
foreign key (CPF) references cadastro_cliente (CPF)

);




insert into tbusuario(nome_user, cpf_user, login_user, senha_user)
values('Matheus Chagas', '49668945816', 'matheuschagas', '12345678');


-- O comando abaixo descreve a tabela 
describe cadastro_cliente;
--  A linha abaixo exibe os dados da tabela 
-- read -> select
select *from cadastro_cliente;
-- A linha abaixo insere dados na tabela
-- Create
insert into cadastro_cliente (CPF, nome, endereco, fone, email, data_nascimento)
values('49668945816', 'Matheus Chagas Sversutti', 'Rua Carapicuíba n 95, São Paulo', '11958073454', 'sversuttimatheus@gmail.com', '2000-11-24');
insert into cadastro_cliente (CPF, nome, endereco, fone, email, data_nascimento)
values('15564895451', 'Lucas Gabriel', 'Rua Pirajú, São Paulo', '11985758988', 'lucas18997@gmail.com', '2000-12-17');

-- a linha abaixo modifica dados
update cadastro_cliente set fone = '8888-8888' where CPF = '15564895451';

-- A linha abaixo apaga um registro da tabela (CRUD)
-- delete
delete from cadastro_cliente where CPF = '49668945816';

delete from compra where CPF = "49668945816";

select *from cadastro_cliente;





