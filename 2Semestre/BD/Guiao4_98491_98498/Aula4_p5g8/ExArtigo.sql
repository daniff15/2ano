USE p5g8
GO

CREATE TABLE Artigo_Instituto(
	Endereco		VARCHAR(256)	NOT NULL,
	Nome			VARCHAR(256)	NOT NULL,

	PRIMARY KEY(Endereco)
);
GO

CREATE TABLE Artigo_Participante(
	Email			VARCHAR(256)		NOT NULL,
	Data_Incricao	DATETIME			NOT NULL,
	Morada			VARCHAR(256)		NOT NULL,

	PRIMARY KEY (Email),
	FOREIGN KEY (Email) REFERENCES Artigo_Pessoa(Email)
	
);
GO

CREATE TABLE Artigo_Pessoa(
	Email				VARCHAR(256)		NOT NULL,
	Nome				VARCHAR(256)		NOT NULL,
	Inst_Endereco		VARCHAR(256)		NOT NULL,
	
	PRIMARY KEY (Email),
	FOREIGN KEY (Inst_Endereco) REFERENCES Artigo_Instituto(Endereco)
);
GO

CREATE TABLE Artigo_Autor(
	Email				VARCHAR(256)		NOT NULL,

	PRIMARY KEY (Email),
	FOREIGN KEY (Email) REFERENCES Artigo_Pessoa(Email)
);
Go

CREATE TABLE Artigo_Estudante(
	Email				VARCHAR(256)		NOT NULL,

	PRIMARY KEY (Email),
	FOREIGN KEY (Email) REFERENCES Artigo_Participante(Email)
);
GO

CREATE TABLE Artigo_Nao_Estudante(
	Email					VARCHAR(256)		NOT NULL,
	Transacao_Bancaria		VARCHAR(256)		NOT NULL,

	PRIMARY KEY (Email),
	FOREIGN KEY (Email) REFERENCES Artigo_Participante(Email)
);
GO

CREATE TABLE Artigo_ArtigoCientifico(
	Num_Registo		INT				NOT NULL,
	Titulo			VARCHAR(1024)	NOT NULL,
	Autor_Email		VARCHAR(256)	NOT NULL,

	PRIMARY KEY (Num_Registo),
	FOREIGN KEY(Autor_Email) REFERENCES Artigo_Autor(Email)

);
GO

CREATE TABLE Artigo_Comprovativo(
	Localizacao_Eletronica		VARCHAR(256)	NOT NULL,
	Estudante_Email				VARCHAR(256)	NOT NULL,
	Inst_Endereco				VARCHAR(256)	NOT NULL, 

	PRIMARY KEY (Localizacao_Eletronica, Estudante_Email, Inst_Endereco),
	FOREIGN KEY (Inst_Endereco) REFERENCES Artigo_Instituto(Endereco),
	FOREIGN KEY (Estudante_Email) REFERENCES Artigo_Estudante(Email)

);
GO
