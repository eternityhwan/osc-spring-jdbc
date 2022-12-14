CREATE DATABASE jdbc;

USE jdbc;

CREATE TABLE `board` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `title` varchar(200) DEFAULT NULL,
   `contents` varchar(200) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

INSERT INTO `board` (id, title, contents)
VALUES
    (1, '제목1','JDBC 프로젝트1' ),
    (2, '제목2', 'JDBC 프로젝트2'),
    (3, '제목3', 'JDBC 프로젝트3');

commit;
