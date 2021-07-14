use p5g8
GO

CREATE TABLE Presc_Paciente(
	Num_Utente			INT					NOT NULL,
	DataNascimento		DATETIME			NOT NULL,
	Endereco			VARCHAR(256)		NOT NULL,
	Nome				VARCHAR(256)		NOT NULL,

	PRIMARY KEY (Num_Utente)
);
GO

CREATE TABLE Presc_Medico(
	Num_SNS				INT					NOT NULL,
	Nome				VARCHAR(256)		NOT NULL,

	PRIMARY KEY (Num_SNS)	
);
GO

CREATE TABLE Presc_Especialidade(
	Especialidade		VARCHAR(32)			NOT NULL,
	Medico_num_SNS		INT					NOT NULL,

	PRIMARY KEY (Especialidade, Medico_num_SNS),
	FOREIGN KEY (Medico_num_SNS) REFERENCES Presc_Medico(Num_SNS)
);
GO

CREATE TABLE Presc_Farmacia(
	NIF			INT					NOT NULL,
	Nome		VARCHAR(64)			NOT NULL,
	Endereco	VARCHAR(256)		NOT NULL,
	Telefone	INT					NOT NULL,

	PRIMARY KEY (NIF)
);
GO

CREATE TABLE Presc_Farmaceutica(
	NumReg_Nacional			INT				NOT NULL,
	Telemovel				INT				NOT NULL,
	Nome					VARCHAR(64)		NOT NULL,
	Endereco				INT				NOT NULL,

	PRIMARY KEY (NumReg_Nacional)
);
GO

CREATE TABLE Presc_Farmaco(
	Formula							VARCHAR(64)		NOT NULL,
	Farmacia_NIF					INT				NOT NULL,
	Farmaceutica_NumReg_Nacional	INT				NOT NULL,
	NomeComercial					VARCHAR(64)		NOT NULL,
	NomeUnico						VARCHAR(64)		NOT NULL,

	PRIMARY KEY(Formula),
	FOREIGN KEY (Farmacia_NIF) REFERENCES Presc_Farmacia(NIF),
	FOREIGN KEY (Farmaceutica_NumReg_Nacional) REFERENCES Presc_Farmaceutica(NumReg_Nacional)

);
GO


CREATE TABLE Presc_Prescricao(
	NumUnico					INT				NOT NULL,
	[Data]						DATETIME		NOT NULL,
	DataProcessamento			DATETIME		NOT NULL,
	Paciente_Num_Utente			INT				NOT NULL,
	Medico_Num_SNS				INT				NOT NULL,
	Farmacia_NIF				INT				NOT NULL,

	PRIMARY KEY (NumUnico),
	FOREIGN KEY (Paciente_Num_Utente) REFERENCES Presc_Paciente(Num_Utente),
	FOREIGN KEY (Medico_Num_SNS) REFERENCES Presc_Medico(Num_SNS),
	FOREIGN KEY (Farmacia_NIF) REFERENCES Presc_Farmacia(NIF)
);
GO


CREATE TABLE Presc_Contem(
	Prescricao_NumUnico			INT				NOT NULL,
	Farmaco_Formula				VARCHAR(64)		NOT NULL,

	PRIMARY KEY(Prescricao_NumUnico , Farmaco_Formula),
	FOREIGN KEY (Prescricao_NumUnico) REFERENCES Presc_Prescricao(NumUnico),
	FOREIGN KEY (Farmaco_Formula) REFERENCES Presc_Farmaco(Formula)
);
GO
