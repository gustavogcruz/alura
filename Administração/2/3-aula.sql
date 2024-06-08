-- DISTINCT - retorna as linhas que não se repetem

select embalagem
from tabela_de_produtos;

select distinct embalagem, sabor
from tabela_de_produtos;

select distinct embalagem
from tabela_de_produtos
where sabor ='Maca';

select distinct sabor
from tabela_de_produtos;

select rownum, tbp.*
from tabela_de_produtos tbp
where rownum <=5;

SELECT * 
FROM NOTAS_FISCAIS 
WHERE DATA_VENDA = TO_DATE('2017-10-01','YYYY-MM-DD') 
AND ROWNUM <= 10; 

select *
from tabela_de_produtos
order by preco_de_lista desc;

select *
from tabela_de_produtos
order by embalagem desc, nome_do_produto desc;

SELECT * FROM ITENS_NOTAS_FISCAIS
WHERE codigo_do_produto = '1101035'
ORDER BY QUANTIDADE DESC;

--GROUP BY

select *
from tabela_de_clientes;

select estado, sum(volume_de_compra)
from tabela_de_clientes
group by estado;

select embalagem, max(preco_de_lista) as maior_preço
from tabela_de_produtos
group by embalagem;

select embalagem, count(*)
from tabela_de_produtos
group by embalagem
order by embalagem;

select embalagem, count(*) as quantidade
from tabela_de_produtos
--where sabor = 'Laranja'
group by embalagem
order by embalagem;

-- HAVING

select * from tabela_de_clientes;

select estado, 
sum(limite_de_credito)
from tabela_de_clientes
group by estado
having sum(limite_de_credito) >= 900000;

select embalagem, max(preco_de_lista) as maior_preço, min(preco_de_lista)
from tabela_de_produtos
where preco_de_lista >=10
group by embalagem
having max(preco_de_lista) >= 20;

select codigo_do_produto, sum(quantidade)
from itens_notas_fiscais
group by codigo_do_produto
order by sum(quantidade) desc;

SELECT CODIGO_DO_PRODUTO, SUM(QUANTIDADE) 
FROM ITENS_NOTAS_FISCAIS 
GROUP BY CODIGO_DO_PRODUTO 
HAVING SUM(QUANTIDADE) > 394000 
ORDER BY SUM(QUANTIDADE) DESC;

-- CASE WHEN

select nome_do_produto, preco_de_lista,
(case 
when preco_de_lista >= 12 then 'Produto Caro'
when preco_de_lista >= 7 and preco_de_lista < 12 then 'Produto em Conta'
else 'Produto Barato'
end) AS Classificação  
from tabela_de_produtos
where sabor = 'Manga'
--group by Classificação
order by Classificação;

select nome, limite_de_credito,
(case 
when limite_de_credito >=  150000 then 'Clientes grandes'
when limite_de_credito <  150000 and limite_de_credito >= 110000 then 'Clientes médios'
else 'Clientes pequenos'
end) as classificacao
from tabela_de_clientes
order by classificacao,nome;

desc tabela_de_vendedores;
desc tabela_de_clientes;
desc tabela_de_produtos;
desc notas_fiscais;
desc itens_notas_fiscais;