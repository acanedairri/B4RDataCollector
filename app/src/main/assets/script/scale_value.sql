CREATE TABLE `scale_value` (
	`_id`	INTEGER NOT NULL UNIQUE,
	`scale_id`	INTEGER,
	`value`	TEXT,
	`order_number`	TEXT,
	`display_name`	TEXT,
	`description`	TEXT,
	`remarks`	TEXT,
	PRIMARY KEY(_id)
);