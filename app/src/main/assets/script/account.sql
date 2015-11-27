CREATE TABLE `user` (
	`_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`user_id`	INTEGER,
	`username`	TEXT,
	`password`	TEXT,
	`user_type`	TEXT,
	`status`	TEXT,
	`display_name`	TEXT,
	`program_abbrev`	BLOB,
	`program_display_name`	TEXT,
	`valid_start_date`	INTEGER,
	`valid_end_date`	INTEGER,
	`creation_timestamp`	INTEGER,
	`access_token`	TEXT,
	`access_token_expire`	TEXT
);

