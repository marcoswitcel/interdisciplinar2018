/*
Created		20/06/2018
Modified		25/06/2018
Database		Firebird 
*/


Create Table produto  (
    cproduto Integer NOT NULL,
    imagem Varchar(255) NOT NULL,
	preco Numeric(18,2) NOT NULL,
	caracteristicas blob sub_type 0 segment size 1200 NOT NULL,
	desconto Numeric(3,2) NOT NULL,
	quantidade Integer NOT NULL,
	cmarca Integer NOT NULL,
 Primary Key (cproduto)
);

Create Table cliente  (
	cpf Varchar(14) NOT NULL,
	cep Varchar(8) NOT NULL,
	rua Varchar(150) NOT NULL,
	numero Integer NOT NULL,
 Primary Key (cpf)
);

Create Table pedido  (
	cpedido Integer NOT NULL,
	cpf Varchar(14) NOT NULL,
	data Timestamp NOT NULL,
 Primary Key (cpedido)
);

Create Table categoria  (
	ccategoria Integer NOT NULL,
	nome Varchar(100) NOT NULL,
 Primary Key (ccategoria)
);

Create Table subcategoria  (
	csubcategoria Integer NOT NULL,
	ccategoria Integer NOT NULL,
	nome Varchar(100) NOT NULL,
 Primary Key (csubcategoria)
);

Create Table subcagetoriaproduto  (
	csubcategoria Integer NOT NULL,
	cproduto Integer NOT NULL
);

Create Table produtopedido  (
	cproduto Integer NOT NULL,
	cpedido Integer NOT NULL,
	quantidade Integer NOT NULL,
	preco Numeric(18,2) NOT NULL,
	desconto Numeric(18,2) NOT NULL,
 Primary Key (cproduto,cpedido)
);

Create Table marca  (
	cmarca Integer NOT NULL,
	nome Varchar(100) NOT NULL,
 Primary Key (cmarca)
);

Alter Table subcagetoriaproduto add Foreign Key (cproduto) references produto (cproduto) on update no action on delete no action ;
Alter Table produtopedido add Foreign Key (cproduto) references produto (cproduto) on update no action on delete no action ;
Alter Table pedido add Foreign Key (cpf) references cliente (cpf) on update no action on delete no action ;
Alter Table produtopedido add Foreign Key (cpedido) references pedido (cpedido) on update no action on delete no action ;
Alter Table subcategoria add Foreign Key (ccategoria) references categoria (ccategoria) on update no action on delete no action ;
Alter Table subcagetoriaproduto add Foreign Key (csubcategoria) references subcategoria (csubcategoria) on update no action on delete no action ;
Alter Table produto add Foreign Key (cmarca) references marca (cmarca) on update no action on delete no action ;

Create Table Adm  (
	cadm Integer NOT NULL,
	username Varchar(50) NOT NULL,
	password Varchar(300) NOT NULL,
 Primary Key (cadmin)
);
