CREATE TABLE `study_metadata` (
	`_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`id`	INTEGER,
	`transaction_id`	INTEGER,
	`study_id`	INTEGER,
	`variable_id`	INTEGER,
	`abbrev`	TEXT,
	`value`	TEXT
);