CREATE TABLE IF NOT EXISTS connection_group(
	id INT PRIMARY KEY,
	name VARCHAR(256)
);
-- INSERT INTO connection_group VALUES(1, 'group 1');
-- INSERT INTO connection_group VALUES(2, 'group 2');

CREATE TABLE node(
	id INT PRIMARY KEY,
	name VARCHAR(256),
	connection_group_id INT NOT NULL,
	FOREIGN KEY (connection_group_id) references connection_group(id)
);

-- INSERT INTO node VALUES(1,'node 1',1);
-- INSERT INTO node VALUES(2,'node 2',1);
-- INSERT INTO node VALUES(3,'node 3',1);
-- INSERT INTO node VALUES(4,'node 4',1);
-- INSERT INTO node VALUES(5,'node 5',2);
-- INSERT INTO node VALUES(6,'node 6',2);
-- INSERT INTO node VALUES(7,'node 7',2);

CREATE TABLE connections(
	from_node_id INT NOT NULL,
	to_node_id INT NOT NULL,
	FOREIGN KEY (from_node_id) references node(id),
	FOREIGN KEY (to_node_id) references node(id)
);

-- INSERT INTO connections VALUES (1,2);
-- INSERT INTO connections VALUES (2,3);
-- INSERT INTO connections VALUES (2,4);
-- INSERT INTO connections VALUES (5,6);
-- INSERT INTO connections VALUES (6,7);