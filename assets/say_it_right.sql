drop table if exists user_tb;
CREATE TABLE user_tb (_id INTEGER PRIMARY KEY, user_name TEXT);
insert into user_tb (_id, user_name) values (1, "ПРОФИЛЬ");

drop table if exists settings_tb;
CREATE TABLE settings_tb (_id INTEGER PRIMARY KEY, settings_level TEXT, settings_user NUMERIC);
insert into settings_tb (settings_level, settings_user) values ("MEDIUM", 1);

drop table if exists history_tb;
create table history_tb (_id integer primary key, history_date integer, history_level TEXT, history_result integer, history_user numeric);

drop table if exists test_tb;
create table test_tb (_id integer primary key, test_word text, test_result integer, test_level text);
insert into test_tb (test_word, test_result, test_level) values ("АБЗАЦ", 4, "LOW");
insert into test_tb (test_word, test_result, test_level) values ("АБИТУРИЕНТ", 8, "LOW");
insert into test_tb (test_word, test_result, test_level) values ("АБОНЕНТ", 5, "LOW");
insert into test_tb (test_word, test_result, test_level) values ("АБРИКОС", 6, "LOW");
insert into test_tb (test_word, test_result, test_level) values ("АБСОЛЮТ", 6, "LOW");
insert into test_tb (test_word, test_result, test_level) values ("БАЗАЛЬТ", 4, "LOW");
insert into test_tb (test_word, test_result, test_level) values ("БАЙТ", 2, "LOW");
insert into test_tb (test_word, test_result, test_level) values ("КОТ", 2, "LOW");
insert into test_tb (test_word, test_result, test_level) values ("ДОМ", 2, "LOW");
insert into test_tb (test_word, test_result, test_level) values ("ДВЕРЬ", 3, "LOW");

insert into test_tb (test_word, test_result, test_level) values ("АБЗАЦ", 4, "MEDIUM");
insert into test_tb (test_word, test_result, test_level) values ("АБИТУРИЕНТ", 8, "MEDIUM");
insert into test_tb (test_word, test_result, test_level) values ("АБОНЕНТ", 5, "MEDIUM");
insert into test_tb (test_word, test_result, test_level) values ("АБРИКОС", 6, "MEDIUM");
insert into test_tb (test_word, test_result, test_level) values ("АБСОЛЮТ", 6, "MEDIUM");
insert into test_tb (test_word, test_result, test_level) values ("БАЗАЛЬТ", 4, "MEDIUM");
insert into test_tb (test_word, test_result, test_level) values ("БАЙТ", 2, "MEDIUM");
insert into test_tb (test_word, test_result, test_level) values ("КОТ", 2, "MEDIUM");
insert into test_tb (test_word, test_result, test_level) values ("ДОМ", 2, "MEDIUM");
insert into test_tb (test_word, test_result, test_level) values ("ДВЕРЬ", 3, "MEDIUM");

insert into test_tb (test_word, test_result, test_level) values ("АБЗАЦ", 4, "HARD");
insert into test_tb (test_word, test_result, test_level) values ("АБИТУРИЕНТ", 8, "HARD");
insert into test_tb (test_word, test_result, test_level) values ("АБОНЕНТ", 5, "HARD");
insert into test_tb (test_word, test_result, test_level) values ("АБРИКОС", 6, "HARD");
insert into test_tb (test_word, test_result, test_level) values ("АБСОЛЮТ", 6, "HARD");
insert into test_tb (test_word, test_result, test_level) values ("БАЗАЛЬТ", 4, "HARD");
insert into test_tb (test_word, test_result, test_level) values ("БАЙТ", 2, "HARD");
insert into test_tb (test_word, test_result, test_level) values ("КОТ", 2, "HARD");
insert into test_tb (test_word, test_result, test_level) values ("ДОМ", 2, "HARD");
insert into test_tb (test_word, test_result, test_level) values ("ДВЕРЬ", 3, "HARD");