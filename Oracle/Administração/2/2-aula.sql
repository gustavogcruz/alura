/*desc tabela_de_clientes;
desc tabela_de_vendedores;
desc tabela_de_produtos;
desc notas_fiscais;
desc itens_notas_fiscais;*/

select * from tabela_de_clientes;

select 
cpf as IDENTIFICADOR,
nome as "NOME DO CLIENTE", 
cidade,
bairro
from tabela_de_clientes TDC
order by 1;

select tdc.*
from tabela_de_clientes TDC;

--filtros quantitativos

select * from tabela_de_clientes;

select * from tabela_de_clientes
where idade = 18;

select * from tabela_de_clientes
where idade between 17 and 22;

select * from tabela_de_clientes
where data_de_nascimento >= '14/11/95';

select * from tabela_de_clientes
where data_de_nascimento >= '14/11/1995';

select * from tabela_de_clientes
where data_de_nascimento >= to_date('14/11/1995','DD/MM/YYYY');

select * from tabela_de_clientes
where data_de_nascimento >= to_date('11/14/1995','MM/DD/YYYY');

select * from tabela_de_clientes
where bairro >= 'Lapa';

-- expressões lógicas compostas

select *
from tabela_de_produtos
where sabor in ('Manga','Laranja','Melancia');

select *
from tabela_de_produtos
where sabor in ('Manga','Laranja','Melancia') and tamanho = '1 Litro';

select * from tabela_de_clientes;

select *
from tabela_de_clientes
where nome like '%Silva%';

select * from tabela_de_clientes
where cidade in ('Sao Paulo')
and (idade > 20 and idade <=25);

select *
from tabela_de_produtos
where sabor like '%Limao'
and embalagem ='PET';

