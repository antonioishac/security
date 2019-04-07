CREATE TABLE feed (
	codigo BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	descricao VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO feed (codigo, nome, descricao) values (1, 'Antonio', 'teste feed');

