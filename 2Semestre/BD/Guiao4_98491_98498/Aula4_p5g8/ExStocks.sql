USE p5g8
GO

CREATE TABLE Stocks_Produto(
	Codigo		INT				NOT NULL,
	Preco		FLOAT			NOT NULL,
	IVA			INT				NOT NULL,
	Nome		VARCHAR(256)	NOT NULL,

	PRIMARY KEY (codigo)
);
GO

CREATE TABLE Stocks_Fornecedor(
	NIF			VARCHAR(9)		NOT NULL,
	Nome		VARCHAR(256)	NOT NULL,
	Endereco	VARCHAR(256)	NOT NULL,
	FAX			INT				NOT NULL,

	PRIMARY KEY (NIF)
);
GO

CREATE TABLE Stocks_Encomenda(
	N_Encomenda			INT			NOT NULL,
	Produto_Codigo		INT			NOT NULL,
	Fornecedor_NIF		VARCHAR(9)	NOT NULL,
	Data_Realizacao		datetime	NOT NULL,
	
	PRIMARY KEY (N_Encomenda, Produto_Codigo),
	FOREIGN KEY (Produto_Codigo) REFERENCES Stocks_Produto(Codigo),
	FOREIGN KEY (Fornecedor_NIF) REFERENCES Stocks_Fornecedor(NIF)

);
GO

CREATE TABLE Stocks_Cod_Tp_Fornecedor(
	Cod_tp_Fornecedor		INT				NOT NULL,
	Fornecedor_NIF			VARCHAR(9)		NOT NULL,
	Codigo					INT				NOT NULL,
	Designacao				VARCHAR(256)	NOT NULL,

	PRIMARY KEY (Cod_tp_Fornecedor, Fornecedor_NIF),
	FOREIGN KEY (Fornecedor_NIF) REFERENCES Stocks_Fornecedor(NIF)
);
GO

CREATE TABLE Stocks_Cond_Pagamento(
	Condicao_Pagamento		VARCHAR(256)	NOT NULL,
	Fornecedor_NIF			VARCHAR(9)		NOT NULL,

	FOREIGN KEY (Fornecedor_NIF) REFERENCES Stocks_Fornecedor(NIF)
	);
GO