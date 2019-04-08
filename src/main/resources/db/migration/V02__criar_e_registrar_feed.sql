CREATE TABLE feed (
	codigo BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	codigo_usuario BIGINT(20) NOT NULL,
	like_count BIGINT(20),
	url VARCHAR(255),
	FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO feed (codigo, codigo_usuario, like_count, url) values (1, 1, null, 'feed');




CREATE TABLE comments (
	codigo BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	codigo_feed BIGINT(20) NOT NULL,	
	codigo_usuario BIGINT(20) NOT NULL,	
	codigo_photo BIGINT(20),
	data_comments DATETIME,
	txt VARCHAR(255),
	nome VARCHAR(255),
	FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo),
	FOREIGN KEY (codigo_feed) REFERENCES feed(codigo)
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into comments (codigo, codigo_feed, codigo_usuario, codigo_photo, data_comments, txt, nome) values (1, 1, 1, 1, now(), 'teste', 'teste');
