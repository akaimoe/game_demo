CREATE SCHEMA `game_sys_demo` ;
USE game_sys_demo;

CREATE TABLE `game_sys_demo`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  `token` VARCHAR(300) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `game_sys_demo`.`game` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `company` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `game_sys_demo`.`user_like` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `game_id` INT NOT NULL,
  PRIMARY KEY (`id`));
  
-- ALTER TABLE user_like
-- ADD CONSTRAINT fk_user_like_user
-- FOREIGN KEY (user_id) REFERENCES user(id);

-- ALTER TABLE user_like
-- ADD CONSTRAINT fk_user_like_game
-- FOREIGN KEY (game_id) REFERENCES game(id);

INSERT INTO game (id, name, company)
VALUES
    (1, '千恋万花', 'yozusoft'),
    (2, 'Riddle joker', 'yozusoft'),
    (3, '魔女的夜宴', 'yozusoft'),
    (4, '星光咖啡厅与死神之蝶', 'yozusoft'),
    (5, 'summer pocket', 'key'),
    (6, 'clannda', 'key'),
    (7, '星之迷途', 'key');
    
-- INSERT INTO user (id, username, password, nickname)
-- VALUES
--     (1, 'akai'),
--     (2, '桂木桂马'),
--     (3, '夜神月');

