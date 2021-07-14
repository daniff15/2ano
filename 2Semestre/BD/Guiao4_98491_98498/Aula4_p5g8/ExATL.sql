use p5g8
GO

CREATE TABLE ATL_Pessoa(
	Num_CC			INT				NOT NULL, 
	DataNascimento	Datetime		NOT NULL,
	Nome			VARCHAR(128)	NOT NULL,
	Morada			VARCHAR(256)	NOT NULL,

	PRIMARY KEY (Num_CC)
);
Go

CREATE TABLE ATL_Adulto(
	Num_CC			INT				NOT NULL,
	Num_Telemovel	INT				NOT NULL,
	Email			VARCHAR(32)		NOT NULL,

	PRIMARY KEY (Num_CC),
	FOREIGN KEY (Num_CC) REFERENCES ATL_Pessoa (Num_CC)
);
GO

CREATE TABLE ATL_Encarregado(
	Num_CC			INT				NOT NULL,

	PRIMARY KEY (Num_CC),
	FOREIGN KEY (Num_CC) REFERENCES ATL_Adulto (Num_CC)
);
GO

CREATE TABLE ATL_PessoaAutorizada(
	Num_CC					INT				NOT NULL,
	AutorizacaoLevarAluno	VARCHAR(32)		NOT NULL,

	PRIMARY KEY (Num_CC),
	FOREIGN KEY (Num_CC) REFERENCES ATL_Adulto (Num_CC)
);
GO

CREATE TABLE ATL_Professor(
	Num_CC				INT				NOT NULL,
	Num_Funcionario		INT				NOT NULL,

	PRIMARY KEY (Num_CC),
	FOREIGN KEY (Num_CC) REFERENCES ATL_Adulto (Num_CC)
);
GO

CREATE TABLE ATL_Aluno(
	Num_CC				INT				NOT NULL,
	Encarregado_Num_CC	INT				NOT NULL,

	PRIMARY KEY (Num_CC),
	FOREIGN KEY (Num_CC) REFERENCES ATL_Pessoa (Num_CC),
	FOREIGN KEY (Encarregado_Num_CC) REFERENCES ATL_Encarregado (Num_CC)
);
GO

CREATE TABLE ATL_EntregaLevanta (
	PessoaAutorizada_Num_CC			INT			NOT NULL,
	Aluno_Num_CC					INT			NOT NULL,

	PRIMARY KEY (PessoaAutorizada_Num_CC , Aluno_Num_CC ),
	FOREIGN KEY (PessoaAutorizada_Num_CC) REFERENCES ATL_PessoaAutorizada (Num_CC),
	FOREIGN KEY (Aluno_Num_CC) REFERENCES ATL_Aluno (Num_CC)
);
GO


CREATE TABLE ATL_Atividade(
	Identificador			INT				NOT NULL,
	Custo					INT				NOT NULL,
	Designacao				VARCHAR(256)	NOT NULL,
	Aluno_Num_CC			INT				NOT NULL,

	PRIMARY KEY (Identificador),
	FOREIGN KEY (Aluno_Num_CC) REFERENCES ATL_Aluno(Num_CC)
);
GO


CREATE TABLE ATL_Turma(
	Identificador			INT				NOT NULL,
	Aluno_Num_CC			INT				NOT NULL,
	Professor_Num_CC		INT				NOT NULL,
	numMaxAluno				INT				NOT NULL,
	AnoLetivo				VARCHAR(16)		NOT NULL,
	Designacao				VARCHAR(256)	NOT NULL,

	PRIMARY KEY (Identificador),
	FOREIGN KEY (Aluno_Num_CC) REFERENCES ATL_Aluno(Num_CC),
	FOREIGN KEY (Professor_Num_CC) REFERENCES ATL_Professor(Num_CC)

);
GO

CREATE TABLE ATL_RelacaoAluno(
	RelacaoAluno			VARCHAR(16)			NOT NULL,
	Encarregado_Num_CC		INT					NOT NULL,

	PRIMARY KEY(RelacaoAluno ,Encarregado_Num_CC ),
	FOREIGN KEY (Encarregado_Num_CC) REFERENCES ATL_Encarregado(Num_CC),

);
GO

CREATE TABLE ATL_DisponivelPara(
	Turma_Identificador			INT			NOT NULL,
	Atividade_Identificador		INT			NOT NULL,

	PRIMARY KEY(Turma_Identificador ,Atividade_Identificador ),
	FOREIGN KEY (Turma_Identificador) REFERENCES ATL_Turma(Identificador),
	FOREIGN KEY (Atividade_Identificador) REFERENCES ATL_Atividade(Identificador),

);
GO