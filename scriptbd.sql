/*
Created		20/06/2018
Modified		19/08/2018
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

Create Table subcategoriaproduto  (
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

Alter Table subcategoriaproduto add Foreign Key (cproduto) references produto (cproduto) on update no action on delete no action ;
Alter Table produtopedido add Foreign Key (cproduto) references produto (cproduto) on update no action on delete no action ;
Alter Table pedido add Foreign Key (cpf) references cliente (cpf) on update no action on delete no action ;
Alter Table produtopedido add Foreign Key (cpedido) references pedido (cpedido) on update no action on delete no action ;
Alter Table subcategoria add Foreign Key (ccategoria) references categoria (ccategoria) on update no action on delete no action ;
Alter Table subcategoriaproduto add Foreign Key (csubcategoria) references subcategoria (csubcategoria) on update no action on delete no action ;
Alter Table produto add Foreign Key (cmarca) references marca (cmarca) on update no action on delete no action ;

Create Table Adm  (
	cadmin Integer NOT NULL,
	username Varchar(50) NOT NULL,
	password Varchar(300) NOT NULL,
 Primary Key (cadmin)
);

/* SET TERM muda o caractere que termina os comandos */

/* Pedido */
CREATE GENERATOR GENPEDIDO_ID;
SET GENERATOR GENPEDIDO_ID TO 0;

SET TERM ^;
CREATE TRIGGER triggerpedido FOR pedido
  ACTIVE BEFORE INSERT
AS
BEGIN
  IF (INSERTING AND NEW.CPEDIDO IS NULL)
    THEN NEW.CPEDIDO = GEN_ID(GENPEDIDO_ID, 1);
END^
SET TERM ;^

/* Marca */
CREATE GENERATOR GENMARCA_ID;
SET GENERATOR GENMARCA_ID TO 0;

SET TERM ^;
CREATE TRIGGER triggermarca FOR marca
  ACTIVE BEFORE INSERT
AS
BEGIN
  IF (INSERTING AND NEW.CMARCA IS NULL)
    THEN NEW.CMARCA = GEN_ID(GENMARCA_ID, 1);
END^
SET TERM ;^

/* Categoria */
CREATE GENERATOR GENCATEGORIA_ID;
SET GENERATOR GENCATEGORIA_ID TO 0;

SET TERM ^;
CREATE TRIGGER triggercategoria FOR categoria
  ACTIVE BEFORE INSERT
AS
BEGIN
  IF (INSERTING AND NEW.CCATEGORIA IS NULL)
    THEN NEW.CCATEGORIA = GEN_ID(GENCATEGORIA_ID, 1);
END^
SET TERM ;^

/* Subcategoria */
CREATE GENERATOR GENSUBCATEGORIA_ID;
SET GENERATOR GENSUBCATEGORIA_ID TO 0;

SET TERM ^;
CREATE TRIGGER triggersubcategoria FOR subcategoria
  ACTIVE BEFORE INSERT
AS
BEGIN
  IF (INSERTING AND NEW.CSUBCATEGORIA IS NULL)
    THEN NEW.CSUBCATEGORIA = GEN_ID(GENSUBCATEGORIA_ID, 1);
END^
SET TERM ;^

/* produto */
CREATE GENERATOR GENPRODUTO_ID;
SET GENERATOR GENPRODUTO_ID TO 0;

SET TERM ^;
CREATE TRIGGER triggerproduto FOR produto
  ACTIVE BEFORE INSERT
AS
BEGIN
  IF (INSERTING AND NEW.CPRODUTO IS NULL)
    THEN NEW.CPRODUTO = GEN_ID(GENPRODUTO_ID, 1);
END^
SET TERM ;^

/* adm */
CREATE GENERATOR GENADM_ID;
SET GENERATOR GENADM_ID TO 0;

SET TERM ^;
CREATE TRIGGER triggeradm FOR adm
  ACTIVE BEFORE INSERT
AS
BEGIN
  IF (INSERTING AND NEW.CADMIN IS NULL)
    THEN NEW.CADMIN = GEN_ID(GENADM_ID, 1);
END^
SET TERM ;^

/* Procedure para registrar pedido */
/*
uso:
  execute procedure ID_NOVO_PEDIDO('12345678912349', '2018/08/19');
*/
SET TERM ^;
CREATE PROCEDURE ID_NOVO_PEDIDO (
  CPF VARCHAR(14),
  DATA TIMESTAMP
)
RETURNS (
  CPEDIDO INT
)
AS
  DECLARE VARIABLE ID VARCHAR(14);
BEGIN  
  SELECT GEN_ID(GENPEDIDO_ID, 1) FROM RDB$DATABASE INTO :ID;

  INSERT INTO PEDIDO (CPEDIDO, CPF, DATA) VALUES (:ID, :CPF, :DATA) RETURNING CPEDIDO INTO :CPEDIDO;
END^
SET TERM ; ^
