CREATE table users(
	uID				BIGINT unsigned  auto_increment, 
	username		VARCHAR(200) default null, 
	password		VARCHAR(200) default null, 
	role			VARCHAR(200) default null,
	highestscore	INTEGER(10) default 0, 
	ldayplayed		date default '0000-00-00',
	PRIMARY KEY  (uID)
)ENGINE=MyISAM; 

CREATE table options(
	uID				BIGINT unsigned default 0, 
	musicsetting	BOOLEAN default true, 
	sfxsetting		BOOLEAN default true, 
	diffsetting		VARCHAR(30) default 'Medium', 
	PRIMARY KEY  (uID)
)ENGINE=MyISAM; 