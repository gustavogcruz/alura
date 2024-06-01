desc tb_clientes;

alter table tb_clientes
add constraint PK_TB_CLIENTES primary key (CPF);

insert into tb_clientes
(CPF, NOME,ENDERECO1,ENDERECO2,BAIRRO,CIDADE,ESTADO,CEP,DATA_NASCIMENTO,IDADE,SEXO,LIMITE_CREDITO,PRIMEIRA_COMPRA)
values('00333434577', 'João da Silva', 'Rua Projetada número 10', NULL, 'VILA ROMAN', 'TRÊS RIOS', 'RJ', '22222222', '12/10/1965', 56, 'M', 100000, 0);

insert into tb_clientes
(CPF, NOME,ENDERECO1,ENDERECO2,BAIRRO,CIDADE,ESTADO,CEP,DATA_NASCIMENTO,IDADE,SEXO,LIMITE_CREDITO,PRIMEIRA_COMPRA)
values('00333434578', 'João da Silva', 'Rua Projetada número 10', NULL, 'VILA ROMAN', 'TRÊS RIOS', 'RJ', '22222222', 
to_date('12/10/1965','MM/DD/YYYY'), 56, 'M', 100000, 0);

select to_char(data_nascimento,'MM') from tb_clientes;


delete from tb_clientes
where tb_clientes.cpf = '00333434577';




/*---------------------------*/

desc tb_vendedores;

ALTER TABLE tb_vendedores
ADD CONSTRAINT PK_TB_VENDEDORES PRIMARY KEY (matricula);

insert into tb_vendedores
(matricula, nome,data_admissao,percentual_comissao)
values
('00729',
'Patricia Martins',
'02/01/2022',
9);

insert into tb_vendedores
(matricula, nome,data_admissao,percentual_comissao)
values
('00777',
'Katy Peterson',
to_date('02/04/2020','MM/DD/YYYY'),
10);

select to_char(data_admissao,'MM') from tb_vendedores;

select *
from tb_vendedores;

update tb_vendedores
set tb_vendedores.percentual_comissao = 20
where tb_vendedores.matricula = '00934';

delete from
tb_vendedores
where tb_vendedores.matricula = '00400';


/*---------------------------*/

desc tb_produtos;

ALTER TABLE TB_PRODUTOS
ADD CONSTRAINT PK_TB_PRODUTOS PRIMARY KEY (PRODUTO);

insert INTO tb_produtos
(PRODUTO, 
NOME,
EMBALAGEM,
TAMANHO,
SABOR,
PRECO_LISTA) 
values
('1004327',
'Videira do Campo',
'Pet',
'1,5L',
'Melancia'
,19.51);

DELETE FROM 
TB_PRODUTOS 
WHERE PRODUTO = '1037797';

select *
from tb_produtos;


