-- AND (E) / OR(OU)

-- VERDADEIRA and VERDADEIRA = VERDADEIRA
-- VERDADEIRA and FALSA = FALSA
-- VERDADEIRA or VERDADEIRA = VERDADEIRA
-- VERDADEIRA or FALSA = VERDADEIRA

-- not(VERDADEIRA and VERDADEIRA) = FALSA
-- not (VERDADEIRA and FALSA) = VERDADEIRA
-- not (VERDADEIRA or VERDADEIRA) = FALSA
-- not (VERDADEIRA or FALSA) = FALSA


SELECT *
FROM tb_clientes;

SELECT nome, idade
from tb_clientes
where idade = 22;

SELECT nome, idade
from tb_clientes
where idade > 22;

SELECT nome, idade
from tb_clientes
where idade <> 22;

select nome
from tb_clientes
where data_nascimento = '25/03/92';

select nome, data_nascimento
from tb_clientes
where data_nascimento = to_date('25/03/1992','DD/MM/YYYY');

select nome, data_nascimento
from tb_clientes
where data_nascimento = to_date('03/25/1992','MM/DD/YYYY');

select nome, data_nascimento
from tb_clientes
where data_nascimento < to_date('25/03/1992','DD/MM/YYYY');

select nome, data_nascimento
from tb_clientes
where to_char(data_nascimento,'MM') = 9;

select nome
from tb_clientes
where (idade > 18 and sexo ='F')
and bairro = 'Jardins';

-----------------------
SELECT
PRODUTO as "CODIGO DO PRODUTO",
NOME as "NOME DO PRODUTO",
EMBALAGEM,
TAMANHO,
SABOR,
PRECO_LISTA
from tb_produtos;

SELECT * 
FROM TB_PRODUTOS 
WHERE PRODUTO = '1040107';

SELECT * 
FROM TB_PRODUTOS
WHERE PRECO_LISTA >= 16 AND PRECO_LISTA <=21;

SELECT * 
FROM TB_PRODUTOS
WHERE preco_lista >= 16 AND sabor = 'Laranja';

SELECT * 
FROM TB_PRODUTOS
WHERE preco_lista >= 16 OR sabor = 'Laranja';

SELECT * 
FROM TB_PRODUTOS
WHERE NOT (preco_lista >= 16 OR sabor = 'Laranja');

----------------------
SELECT * 
FROM TB_VENDEDORES 
WHERE PERCENTUAL_COMISSAO < 17;

SELECT nome, data_admissao
FROM tb_vendedores
where to_char(data_admissao,'YYYY') >= 2020;

SELECT nome, percentual_comissao
from tb_vendedores
where percentual_comissao > 19 OR percentual_comissao < 15; 
