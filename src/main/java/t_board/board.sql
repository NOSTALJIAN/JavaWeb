SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS board;




/* Create Tables */

CREATE TABLE board
(
	articleNO int NOT NULL AUTO_INCREMENT,
	parentNO int DEFAULT 0 NOT NULL,
	title varchar(100) NOT NULL,
	content varchar(5000) NOT NULL,
	imageFileName varchar(100),
	writeDate date DEFAULT NOW(), SYSDATE() NOT NULL,
	uid varchar(10) NOT NULL,
	PRIMARY KEY (articleNO),
	UNIQUE (articleNO),
	UNIQUE (uid)
);



