CREATE DATABASE loja CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

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
				`data_cadastro`  datetime NOT NULL,
				`categoria_id`       bigint NOT NULL,
				INDEX categoria_ind (categoria_id),
				FOREIGN KEY (categoria_id)
				REFERENCES categorias(id)
				ON DELETE CASCADE				
        )
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `clientes`
        (
                `id`    bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,                
                `nome`  varchar(50) DEFAULT NULL  ,
                `cpf`   varchar(7) DEFAULT NULL
        )
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;	


CREATE TABLE `pedidos`
        (
                `id`        bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,                
                `nome`  varchar(50) DEFAULT NULL  ,
				`data_pedido`  datetime NOT NULL ,                
                `valor_total`       decimal(10,0) DEFAULT NULL,				
				`cliente_id`       bigint NOT NULL,
				INDEX cliente_ind (cliente_id),
				FOREIGN KEY (cliente_id)
				REFERENCES clientes(id)
				ON DELETE CASCADE				
        )
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `itens_pedido`
        (
                `id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,  
				`preco_unitario` decimal(10,0) DEFAULT NULL,					
                `quantidade` bigint NOT NULL,				  		
				`produto_id` bigint NOT NULL,
				`pedido_id` bigint NOT NULL,
				INDEX produto_ind (produto_id),
				FOREIGN KEY (produto_id)
				REFERENCES produtos(id)
				ON DELETE CASCADE,	
				INDEX pedido_ind (pedido_id),
				FOREIGN KEY (pedido_id)
				REFERENCES pedidos(id)
				ON DELETE CASCADE				
        )
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `informatica`
        (
                `id`        bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,                
                `marca`  varchar(50) DEFAULT NULL  ,
				`modelo`  varchar(50) DEFAULT NULL  ,		
				INDEX id_ind (id),
				FOREIGN KEY (id)
				REFERENCES produtos(id)
				ON DELETE CASCADE				
        )
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;	


CREATE TABLE `livro`
        (
                `id`        bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,                
                `autor`  varchar(50) DEFAULT NULL  ,
				`numeros_paginas`  varchar(50) DEFAULT NULL  ,
				INDEX id_ind (id),
				FOREIGN KEY (id)
				REFERENCES produtos(id)
				ON DELETE CASCADE				
        )
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;				