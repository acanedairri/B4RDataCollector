CREATE TABLE `plot_data` (
	`_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`id`	INTEGER NOT NULL,
	`transaction_id`	INTEGER,
	`key`	INTEGER,
	`study_id`	INTEGER,
	`entry_id`	TEXT,
	`plot_id`	INTEGER,
	`variable_id`	TEXT,
	`value`	TEXT,
	`creation_timestamp`	INTEGER,
	`modification_timestamp`	TEXT,
	`notes`	INTEGER
);