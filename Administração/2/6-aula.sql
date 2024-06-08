desc tabela_de_vendedores;
desc tabela_de_clientes;
desc tabela_de_produtos;
desc notas_fiscais;
desc itens_notas_fiscais;

select *
from tabela_de_clientes;

select 
nf.cpf,
to_char(nf.data_venda,'MM-YYYY') as MES_ANO,
sum(inf.quantidade) as  QUANTIDADE_TOTAL
from
notas_fiscais nf
inner join
itens_notas_fiscais inf
on nf.numero = inf.numero
group by cpf,to_char(nf.data_venda,'MM-YYYY');

select cpf, nome, volume_de_compra
from tabela_de_clientes;

select 
c.cpf, c.nome, c.volume_de_compra, tv.MES_ANO, tv.QUANTIDADE_TOTAL,
(case when  c.volume_de_compra >=tv.QUANTIDADE_TOTAL 
then 'VENDAS VÁLIDAS'
else 'VENDAS INVÁLIDAS' end) as RESULTADO,
round(((1 - (c.volume_de_compra/tv.QUANTIDADE_TOTAL)) * 100),2) as DIFERENÇA_PERC
from 
tabela_de_clientes c
inner join
(select 
nf.cpf,
to_char(nf.data_venda,'MM-YYYY') as MES_ANO,
sum(inf.quantidade) as  QUANTIDADE_TOTAL
from
notas_fiscais nf
inner join
itens_notas_fiscais inf
on nf.numero = inf.numero
group by cpf,to_char(nf.data_venda,'MM-YYYY')) TV
ON TV.cpf = c.cpf
WHERE tv.MES_ANO = '02-2015'
AND (c.volume_de_compra - tv.QUANTIDADE_TOTAL) < 0
order by 2;

SELECT
    consulta_relatorio.sabor,
    consulta_relatorio.ano,
    consulta_relatorio.quantidade_total,
    round((consulta_relatorio.quantidade_total / consulta_relatorio.quantidade_geral) * 100, 2) AS percentual_participacao
FROM
    (
        SELECT
            tp.sabor,
            EXTRACT(YEAR FROM nf.data_venda) AS ano,
            SUM(inf.quantidade)              AS quantidade_total,
            (
                SELECT
                    total_ano.quantidade_geral
                FROM
                    (
                        SELECT
                            EXTRACT(YEAR FROM nf.data_venda) AS ano,
                            SUM(inf.quantidade)              AS quantidade_geral
                        FROM
                                 notas_fiscais nf
                            INNER JOIN itens_notas_fiscais inf ON nf.numero = inf.numero
                        WHERE
                            EXTRACT(YEAR FROM nf.data_venda) = 2016
                        GROUP BY
                            EXTRACT(YEAR FROM nf.data_venda)
                    ) total_ano
            )                                AS quantidade_geral
        FROM
                 tabela_de_produtos tp
            INNER JOIN itens_notas_fiscais inf ON tp.codigo_do_produto = inf.codigo_do_produto
            INNER JOIN notas_fiscais       nf ON inf.numero = nf.numero
        WHERE
            EXTRACT(YEAR FROM nf.data_venda) = 2016
        GROUP BY
            tp.sabor,
            EXTRACT(YEAR FROM nf.data_venda)
        ORDER BY
            SUM(inf.quantidade) DESC
    ) consulta_relatorio;

