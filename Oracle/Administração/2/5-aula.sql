desc tabela_de_vendedores;
desc tabela_de_clientes;
desc tabela_de_produtos;
desc notas_fiscais;
desc itens_notas_fiscais;

--funções string

select nome, lower(nome)
from tabela_de_clientes;

select nome, upper(nome)
from tabela_de_clientes;

select nome_do_produto, INITCAP(nome_do_produto)
from tabela_de_produtos;

select ENDERECO_1,BAIRRO, concat(concat(ENDERECO_1, ' - '), BAIRRO) 
from tabela_de_clientes;

select ENDERECO_1 || ' ' || BAIRRO || ' ' || CIDADE || ' ' || ESTADO || ' - ' || CEP
from tabela_de_clientes;

select nome_do_produto, lpad(nome_do_produto,50,'*')
from tabela_de_produtos;

select nome_do_produto, rpad(nome_do_produto,50,'*')
from tabela_de_produtos;

select nome_do_produto, SUBSTR(nome_do_produto,3,5)
from tabela_de_produtos;

select nome_do_produto, INSTR(nome_do_produto,'Campo')
from tabela_de_produtos;

select nome, INSTR(nome,'Silva')
from tabela_de_clientes;

select nome
from tabela_de_clientes
where INSTR(nome,'Silva') <> 0;

select '   CRUZ   ' as X, 
LTRIM('   CRUZ   ') as Y, 
RTRIM('   CRUZ   ') as Z, 
TRIM('   CRUZ   ') as W
from dual;

select nome_do_produto, REPLACE(nome_do_produto,'Litro','L')
from tabela_de_produtos;

select nome_do_produto, REPLACE(REPLACE(nome_do_produto,'Litro','L'),'Ls','L')
from tabela_de_produtos;

--funções data

/*
TO_CHAR
TO_DATE
SYSDATE
MONTHS_BETWEEN
ADD_MONTHS
NEXT_DAY
LAST_DAY
TRUNC (date)
ROUND (date)
*/

--calcular o número de dias que uma pessoa viveu desde o seu nascimento

SELECT (SYSDATE - DATA_DE_NASCIMENTO) 
FROM TABELA_DE_CLIENTES
where CPF = '1471156710';

select sysdate
from dual;

select to_char(sysdate, 'DD/MM/YYYY HH:MI:SS')
from dual;

select nome, to_char(data_de_nascimento, 'DD MONTH YYYY, DAY') as DT_NASC
from tabela_de_clientes;

select sysdate + 13
from dual;

select nome, idade, to_char(data_de_nascimento, 'DD MONTH YYYY, DAY') as DT_NASC
from tabela_de_clientes;

select nome, idade, (sysdate - data_de_nascimento)/365
from tabela_de_clientes;

select nome, idade, MONTHS_BETWEEN(sysdate,data_de_nascimento)/12
from tabela_de_clientes;

select ADD_MONTHS(sysdate, 12) from dual;

select NEXT_DAY(sysdate, 'DOMINGO') from dual;

select LAST_DAY(sysdate) from dual;

select sysdate, trunc(sysdate, 'YEAR')
from dual;

select sysdate, trunc(sysdate, 'MONTH')
from dual;

select sysdate, round(sysdate + 300, 'YEAR')
from dual;

--funções numéricas

/*
ROUND
TRUNC
CEIL
FLOOR
POWER
EXP
SQRT
SIGN
ABS
MOD
*/

SELECT ROUND(15.193,1) "Round" FROM DUAL;
 
SELECT ROUND(15.193,-1) "Round" FROM DUAL;
 
SELECT FLOOR(SYSDATE - DATA_DE_NASCIMENTO) FROM TABELA_DE_CLIENTES;
 
select 3.4 from dual;
 
select round(3.4) from dual;  
select round(3.6) from dual;   
select round(3.5) from dual;

select trunc(3.4) from dual;  
select trunc(3.6) from dual;   
select trunc(3.5) from dual;

select ceil(3.4) from dual;  
select ceil(3.6) from dual;   
select ceil(3.5) from dual;

select floor(3.4) from dual;  
select floor(3.6) from dual;   
select floor(3.5) from dual;

select power(10,4) from dual;
select power(34,4) from dual;

select exp(4) from dual;

select sqrt(144) from  dual;

select abs(10) from dual;
select abs(-10) from dual;

select mod(10,6) from dual;

SELECT TO_CHAR(DATA_VENDA, 'YYYY'), FLOOR(SUM(IMPOSTO * (QUANTIDADE * PRECO))) as VALOR_IMPOSTO
FROM NOTAS_FISCAIS NF
INNER JOIN ITENS_NOTAS_FISCAIS INF ON NF.NUMERO = INF.NUMERO
WHERE TO_CHAR(DATA_VENDA, 'YYYY') = 2016
GROUP BY TO_CHAR(DATA_VENDA, 'YYYY');

--funções conversão

/*
EXTRACT
TO_NUMBER - texto em número
TO_CHAR - número para texto
NVL - testa se valor é nulo, se sim, altera
GREATEST
*/

select extract(month from to_date('12/11/2019','DD/MM/YYYY')) 
from dual;

select extract(month from to_date('12/11/2019','MM/DD/YYYY')) 
from dual;

select '10' + 10 from dual;

select to_number('10') + 10 from dual;

select to_char(1234.123, '9999') from dual;
select to_char(1234.123, '9999.999') from dual;
select to_char(1234.123, '9999,999') from dual;

select nvl(10,0) from dual;

select nvl(null,0) from dual;

select
nvl(v.nome,'não encontrado') as nome_vendedor,
nvl(v.bairro,'não encontrado') as bairro_vendedor,
nvl(c.nome,'não encontrado') as nome_cliente,
nvl(v.bairro,'não encontrado') as bairro_cliente
from
tabela_de_vendedores v
full join
tabela_de_clientes c
on v.bairro = c.bairro;


SELECT 'O cliente ' || c.nome || ' comprou ' || 
TO_CHAR(ROUND(SUM(INF.QUANTIDADE * INF.preco),2)) || ' no ano de ' || TO_CHAR(DATA_VENDA, 'YYYY') AS SENTENCA 
from
tabela_de_clientes c 
inner join 
notas_fiscais nf
on c.cpf = nf.cpf
inner join 
itens_notas_fiscais inf
on nf.numero = inf.numero
where to_char(data_venda,'YYYY') = 2016
group by c.nome,to_char(data_venda,'YYYY');
--order by c.nome;
