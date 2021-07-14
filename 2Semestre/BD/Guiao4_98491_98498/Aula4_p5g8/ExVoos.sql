USE p5g8
GO

CREATE TABLE Voos_Airport(
	Airport_Code	INT				NOT NULL,
	City			VARCHAR(64)		NOT NULL,
	[State]			VARCHAR(64)		NOT NULL,
	[Name]			VARCHAR(64)		NOT NULL,

	PRIMARY KEY(Airport_Code)
);
GO

CREATE TABLE Voos_Airplane_Type(
	[Type_Name]		VARCHAR(64)		NOT NULL,
	Max_Seats		INT				NOT NULL,
	Company			VARCHAR(64)		NOT NULL,

	PRIMARY KEY ([Type_Name])
);
GO

CREATE TABLE Voos_Airplane(
	Airplane_ID					INT				NOT NULL,
	Total_No_of_Seats			INT				NOT NULL,
	Airplane_Type_Type_Name		VARCHAR(64)		NOT NULL,

	PRIMARY KEY (Airplane_ID),
	FOREIGN KEY(Airplane_Type_Type_Name) REFERENCES Voos_Airplane_Type([Type_Name])
);
GO

CREATE TABLE Voos_Flight(
	Number		INT				NOT NULL,
	Airline		VARCHAR(32)		NOT NULL,
	WeedDays	VARCHAR(64)		NOT NULL,

	PRIMARY KEY (Number)
);
GO

CREATE TABLE Voos_FARE(
	Code			INT				NOT NULL,
	Restrictions	VARCHAR(1024)	NOT NULL,
	Amount			INT				NOT NULL,
	Flight_No		INT				NOT NULL,

	PRIMARY KEY (Code, Flight_No),
	FOREIGN KEY (Flight_No) REFERENCES Voos_Flight(Number)
);
GO

CREATE TABLE Voos_CanLand(
	Airport_Airport_Code		INT				NOT NULL,
	Airplane_Type_Name			VARCHAR(64)		NOT NULL,
		
	PRIMARY KEY (Airport_Airport_Code, Airplane_Type_Name),
	FOREIGN KEY (Airport_Airport_Code) REFERENCES Voos_Airport(Airport_Code),
	FOREIGN KEY (Airplane_Type_Name) REFERENCES Voos_Airplane_Type([Type_Name])
);
GO

CREATE TABLE Voos_Seat(
	Seat_No				INT				NOT NULL,
	Leg_Instance_Date	datetime		NOT NULL,
	Leg_No				INT				NOT NULL,
	Flight_Number		INT				NOT NULL,
	CostumerName		VARCHAR(256)	NOT NULL,
	CostumerPhone		VARCHAR(14)		NOT NULL,

	PRIMARY KEY (Seat_No, Leg_Instance_Date, Leg_No, Flight_Number),
	FOREIGN KEY (Leg_Instance_Date, Flight_Number) REFERENCES Voos_Leg_Instance([Date], Flight_Number),
	FOREIGN KEY (Leg_No, Flight_Number) REFERENCES Voos_Flight_Leg(Leg_No, Flight_Number),
);
GO


CREATE TABLE Voos_Flight_Leg(
	Leg_No				INT			NOT NULL,
	Flight_Number		INT			NOT NULL,
	Arr_Airport_Code	INT			NOT NULL,
	Dep_Airport_Code	INT			NOT NULL,
	SchArrTime			datetime	NOT NULL,
	SchDepTime			datetime	NOT NULL,

	PRIMARY KEY (Leg_No, Flight_Number),
	FOREIGN KEY (Flight_Number) REFERENCES Voos_Flight(Number),
	FOREIGN KEY (Arr_Airport_Code) REFERENCES Voos_Airport(Airport_Code),
	FOREIGN KEY (Dep_Airport_Code) REFERENCES Voos_Airport(Airport_Code)
);
GO

DROP TABLE Voos_Leg_Instance
GO

CREATE TABLE Voos_Leg_Instance(
	[Date]					datetime		NOT NULL,
	Flight_Leg_No			INT				NOT NULL,
	Flight_Number			INT				NOT NULL,
	No_Available_seats		INT				NOT NULL,
	Arr_Airport_Code		INT				NOT NULL,
	Dep_Airport_Code		INT				NOT NULL,
	SchArrTime				datetime		NOT NULL,
	SchDepTime				datetime		NOT NULL,

	PRIMARY KEY ([Date], Flight_Number),
	FOREIGN KEY (Flight_Leg_No, Flight_Number) REFERENCES Voos_Flight_Leg(Leg_No, Flight_Number),
	FOREIGN KEY (Arr_Airport_Code) REFERENCES Voos_Airport(Airport_Code),
	FOREIGN KEY (Dep_Airport_Code) REFERENCES Voos_Airport(Airport_Code)
);
GO