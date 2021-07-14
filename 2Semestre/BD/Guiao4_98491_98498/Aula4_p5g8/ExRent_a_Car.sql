USE p5g8
GO

CREATE TABLE Rent_a_Car_Cliente(
	NIF			VARCHAR(9)		NOT NULL	PRIMARY KEY,
	Nome		VARCHAR(256)	NOT NULL, 
	Endereco	VARCHAR(1024)	NOT NULL, 
	num_carta	VARCHAR(32)		NOT NULL,

);
GO

CREATE TABLE Rent_a_Car_Balcao(
	Numero		INT				NOT	NULL	PRIMARY KEY,
	Nome		VARCHAR(256)	NOT NULL, 
	Endereco	VARCHAR(1024)	NOT NULL,

);
GO


CREATE TABLE Rent_a_Car_TipoVeiculo(
	Codigo			INT				NOT NULL	PRIMARY KEY,
	Designacao		VARCHAR(256)	NOT NULL,
	ArCondicionado	BIT				NOT NULL,

);
GO

CREATE TABLE Rent_a_Car_Veiculo(
	Matricula			VARCHAR(8)		NOT NULL	PRIMARY KEY,
	Ano					INT				NOT NULL,
	Marca				VARCHAR(256)	NOT NULL,
	TipoVeiculo_Codigo	INT				NOT NULL	FOREIGN KEY REFERENCES Rent_a_Car_TipoVeiculo(Codigo),
	
);
GO


CREATE TABLE Rent_a_Car_Aluguer(
	Numero				INT			NOT NULL	PRIMARY KEY,
	Cliente_NIF			VARCHAR(9)	NOT NULL	FOREIGN KEY REFERENCES Rent_a_Car_Cliente(NIF),
	Balcao_numero		INT			NOT NULL	FOREIGN KEY REFERENCES Rent_a_Car_Balcao(Numero),
	Veiculo_matricula	VARCHAR(8)	NOT NULL	FOREIGN KEY REFERENCES Rent_a_Car_Veiculo(Matricula),
	Duracao				INT			NOT NULL,
	[Data]				DATETIME	NOT NULL,
);
GO

CREATE TABLE Rent_a_Car_Similaridade(
	Tipo_Veiculo_Codigo1	INT		NOT NULL	FOREIGN KEY REFERENCES Rent_a_Car_TipoVeiculo(Codigo),
	Tipo_Veiculo_Codigo2	INT		NOT NULL	FOREIGN KEY REFERENCES Rent_a_Car_TipoVeiculo(Codigo),

	PRIMARY KEY (Tipo_Veiculo_Codigo1, Tipo_Veiculo_Codigo2),
);
GO

CREATE TABLE Rent_a_Car_Ligeiro(
	Tipo_Veiculo_Codigo1	INT				NOT NULL	PRIMARY KEY		FOREIGN KEY REFERENCES Rent_a_Car_TipoVeiculo(Codigo),
	Numlugares				INT				NOT NULL,
	Portas					INT				NOT NULL,
	Combustivel				VARCHAR(16)		NOT NULL,

);
GO


CREATE TABLE Rent_a_Car_Pesado(
	Tipo_Veiculo_Codigo2	INT				NOT NULL	PRIMARY KEY		FOREIGN KEY REFERENCES Rent_a_Car_TipoVeiculo(Codigo),
	Passageiros				INT				NOT NULL,
	Peso					INT				NOT NULL,

);
GO