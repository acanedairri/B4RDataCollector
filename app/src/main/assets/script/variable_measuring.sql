CREATE TABLE `variable_measuring` (
	`_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`id`	INTEGER,
	`variable_id`	INTEGER,
	`property_id`	INTEGER,
	`method_id`	INTEGER,
	`scale_id`	INTEGER,
	`abbrev`	INTEGER,
	`display_name`	TEXT,
	`data_type`	TEXT,
	`scale_value`	TEXT
);