create database bank;
use bank;

CREATE TABLE clients
(
	client_id	TINYINT NOT NULL AUTO_INCREMENT,
	name		VARCHAR(40),
	address		VARCHAR(40),
	age 		TINYINT,
	PRIMARY KEY(client_id)
) ;

CREATE TABLE accounts
(
	account_id	INT NOT NULL AUTO_INCREMENT,
	client_id	TINYINT,
	sum 		INT,
	PRIMARY KEY(account_id),
	FOREIGN KEY (client_id) REFERENCES clients(client_id)
) ;

CREATE TABLE transactions
(
	transaction_id	BIGINT NOT NULL AUTO_INCREMENT,
	sender_acc_id	INT,
	getter_acc_id 	INT,
	amount			BIGINT,
	add_date		DATETIME NOT NULL,
	PRIMARY KEY(transaction_id),
	FOREIGN KEY (sender_acc_id) REFERENCES accounts(account_id),
	FOREIGN KEY (getter_acc_id) REFERENCES accounts(account_id)
) ;

CREATE USER 'bank'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON bank.* TO 'bank'@'localhost';

exit;