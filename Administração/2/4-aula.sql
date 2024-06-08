select *
from tabela_de_vendedores;

select * 
from notas_fiscais;

select nf.matricula,v.nome,count(*) as NUMERO_DE_NOTAS
from tabela_de_vendedores v inner join notas_fiscais nf
on nf.matricula = v.matricula
group by nf.matricula, v.nome;

SELECT 
p.nome_do_produto,
inf.CODIGO_DO_PRODUTO, 
SUM(QUANTIDADE) 
FROM tabela_de_produtos p inner join ITENS_NOTAS_FISCAIS inf
on p.codigo_do_produto = inf.codigo_do_produto
GROUP BY p.nome_do_produto,inf.CODIGO_DO_PRODUTO 
HAVING SUM(QUANTIDADE) > 394000 
ORDER BY SUM(QUANTIDADE) DESC;

--JOIN (RIGTH, LEFT, FULL, CROSS)

select distinct
c.cpf as CFP_DO_CADASTRO, 
c.nome,
nf.cpf as CFP_NF
from
tabela_de_clientes c
inner join
notas_fiscais nf
on c.cpf = nf.cpf;

select count(*)
from tabela_de_clientes;

select distinct
c.cpf as CFP_DO_CADASTRO, 
c.nome,
nf.cpf as CFP_NF
from
tabela_de_clientes c
left join
notas_fiscais nf
on c.cpf = nf.cpf
where nf.cpf is null;

select count(*)
from tabela_de_vendedores;

select distinct
v.nome as nome_vendedor,
v.bairro as bairro_vendedor,
c.nome as nome_cliente,
c.bairro as bairro_cliente
from
tabela_de_vendedores v
full join
tabela_de_clientes c
on v.bairro = c.bairro;

--UNION (retorna distinct) - UNION ALL (retorna todos)

select distinct bairro
from tabela_de_clientes
union
select distinct bairro
from tabela_de_vendedores;

select distinct bairro, 'cliente' as origem
from tabela_de_clientes
union all
select distinct bairro, 'vendedor' as origem
from tabela_de_vendedores;

-- SUBCONSULTA

select distinct bairro from tabela_de_vendedores;

select *
from tabela_de_clientes
where bairro in(
'Tijuca',
'Jardins',
'Copacabana',
'Santo Amaro');

select *
from tabela_de_clientes
where bairro in(
select distinct bairro
from tabela_de_vendedores);

SELECT DISTINCT SABOR FROM TABELA_DE_PRODUTOS WHERE
CODIGO_DO_PRODUTO IN (
SELECT INF.CODIGO_DO_PRODUTO FROM ITENS_NOTAS_FISCAIS INF
INNER JOIN TABELA_DE_PRODUTOS TP 
ON INF.CODIGO_DO_PRODUTO = TP.CODIGO_DO_PRODUTO
GROUP BY INF.CODIGO_DO_PRODUTO, TP.NOME_DO_PRODUTO
HAVING SUM(INF.QUANTIDADE) > 394000);

-- SUBCONSULTA vs HAVING

select embalagem, sum(preco_de_lista) as soma_preco
from tabela_de_produtos 
group by embalagem
having sum(preco_de_lista) >= 80;


select soma_embalagens.embalagem,
soma_embalagens.soma_preco
from
(
select embalagem, 
sum(preco_de_lista) as soma_preco 
from tabela_de_produtos 
group by embalagem) soma_embalagens
where soma_embalagens.soma_preco >= 80;

select codigo_nome.CODIGO_DO_PRODUTO, 
codigo_nome.NOME_DO_PRODUTO,
codigo_nome.quantidade
from
(
SELECT INF.CODIGO_DO_PRODUTO, 
TP.NOME_DO_PRODUTO, 
SUM(INF.QUANTIDADE)  as quantidade
FROM ITENS_NOTAS_FISCAIS INF
INNER JOIN TABELA_DE_PRODUTOS TP 
ON INF.CODIGO_DO_PRODUTO = TP.CODIGO_DO_PRODUTO
GROUP BY INF.CODIGO_DO_PRODUTO, TP.NOME_DO_PRODUTO 
) codigo_nome
where codigo_nome.quantidade > 394000
ORDER BY codigo_nome.quantidade DESC;

-- VIEWS


select soma_embalagens.embalagem,
soma_embalagens.soma_preco
from
(
select embalagem, 
sum(preco_de_lista) as soma_preco 
from tabela_de_produtos 
group by embalagem) soma_embalagens
where soma_embalagens.soma_preco >= 80;

create view vw_soma_embalagens as
select embalagem, 
sum(preco_de_lista) as soma_preco 
from tabela_de_produtos 
group by embalagem;

select embalagem, soma_preco
from vw_soma_embalagens
where soma_preco >= 80;

select *
from tabela_de_produtos p
inner join vw_soma_embalagens vw
on p.embalagem = vw.embalagem
where vw.soma_preco >= 80;

CREATE VIEW vw_quantidade_produtos AS 
SELECT INF.CODIGO_DO_PRODUTO, 
TP.NOME_DO_PRODUTO, 
SUM(INF.QUANTIDADE) AS QUANTIDADE_TOTAL 
FROM ITENS_NOTAS_FISCAIS INF
INNER JOIN TABELA_DE_PRODUTOS TP 
ON INF.CODIGO_DO_PRODUTO = TP.CODIGO_DO_PRODUTO
GROUP BY INF.CODIGO_DO_PRODUTO, TP.NOME_DO_PRODUTO;

SELECT * FROM VW_QUANTIDADE_PRODUTOS
WHERE QUANTIDADE_TOTAL > 394000 
ORDER BY QUANTIDADE_TOTAL DESC;


desc tabela_de_vendedores;
desc tabela_de_clientes;
desc tabela_de_produtos;
desc notas_fiscais;
desc itens_notas_fiscais;
