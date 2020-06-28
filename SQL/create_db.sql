DROP DATABASE IF EXISTS interview;
CREATE DATABASE interview;
USE interview;

CREATE TABLE bets (
	id int,
	numbets int,
	game varchar(255),
	stake decimal(7,2),
	returns decimal(7,2),
	clientid int,
	date date
);

CREATE INDEX idx_id
ON bets (id);
