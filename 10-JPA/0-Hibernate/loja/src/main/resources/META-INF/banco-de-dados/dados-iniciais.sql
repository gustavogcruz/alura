--DROP DATABASE loja;

CREATE DATABASE loja;

--DROP TABLE categorias;
--DROP TABLE  produtos;

CREATE TABLE `categorias`
        (
                `id`    bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,                
                `nome`  varchar(50) DEFAULT NULL				
        )
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `produtos`
        (
                `id`        bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,                
                `nome`  varchar(50) DEFAULT NULL  ,
                `descricao`   varchar(50) DEFAULT NULL  ,
                `preco`       decimal(10,0) DEFAULT NULL,
				`dataCadastro`  datetime NOT NULL,
				`categoria_id`       bigint NOT NULL,
				INDEX categoria_ind (categoria_id),
				FOREIGN KEY (categoria_id)
				REFERENCES categorias(id)
				ON DELETE CASCADE				
        )
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;	