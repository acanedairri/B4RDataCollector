CREATE TABLE `plot` (
	`_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`id`	INTEGER,
	`transaction_id`	INTEGER,
	`study_id`	INTEGER,
	`study_name`	TEXT,
	`entry_number`	INTEGER,
	`product_gid`	INTEGER,
	`product_name`	TEXT,
	`seed_source_name`	TEXT,
	`replication_number`	INTEGER,
	`plotno`	INTEGER,
	`entry_id`	INTEGER
);