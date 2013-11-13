drop table if exists user_tb;
CREATE TABLE user_tb (_id INTEGER PRIMARY KEY, user_name TEXT);
insert into user_tb (_id, user_name) values (1, "ПРОФИЛЬ");

drop table if exists settings_tb;
CREATE TABLE settings_tb (_id INTEGER PRIMARY KEY, settings_level TEXT, settings_user NUMERIC);
insert into settings_tb (settings_level, settings_user) values ("MEDIUM", 1);