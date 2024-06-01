desc produto_exercicio;
desc produto_venda_exercicio;

select * from produto_exercicio;
select * from produto_venda_exercicio;

create or replace PROCEDURE incluir_venda
(
p_ID produto_venda_exercicio.id%type,
p_COD_PRODUTO produto_venda_exercicio.cod_produto%type,
p_QTD produto_venda_exercicio.quantidade%type,
p_PRECO produto_venda_exercicio.preco%type)

is
v_PERCENTUAL produto_venda_exercicio.percentual_imposto%type;
v_VALOR produto_venda_exercicio.valor_total%type;
begin

v_PERCENTUAL := imposto_produto(p_COD_PRODUTO);
v_VALOR := (p_QTD * p_PRECO);

insert into produto_venda_exercicio
values(
p_ID,
p_COD_PRODUTO,
sysdate, 
p_QTD,
p_PRECO,
v_VALOR,
v_PERCENTUAL);
commit;

end;

execute incluir_venda(2,92347, 2, 9);

-- solução Alura
CREATE OR REPLACE PROCEDURE INCLUINDO_DADOS_VENDA 
(
p_ID produto_venda_exercicio.id%type,
p_COD_PRODUTO produto_venda_exercicio.cod_produto%type,
p_DATA produto_venda_exercicio.data%type,
p_QUANTIDADE produto_venda_exercicio.quantidade%type,
p_PRECO produto_venda_exercicio.preco%type
)
IS
   v_VALOR produto_venda_exercicio.valor_total%type;
   v_PERCENTUAL produto_venda_exercicio.percentual_imposto%type;
BEGIN
   v_PERCENTUAL := retorna_imposto(p_COD_PRODUTO);
   v_VALOR := p_QUANTIDADE * p_PRECO;
   INSERT INTO PRODUTO_VENDA_EXERCICIO 
   (id, cod_produto, data, quantidade, preco, valor_total, percentual_imposto) 
   VALUES 
   (p_ID, p_COD_PRODUTO, p_DATA, p_QUANTIDADE, p_PRECO, v_VALOR, v_PERCENTUAL);
    COMMIT;
END; 

--função
create or replace function imposto_produto
(
p_cod produto_exercicio.cod%type)
return
produto_venda_exercicio.percentual_imposto%type
is
v_CATEGORIA produto_exercicio.categoria%type;
v_IMPOSTO produto_venda_exercicio.percentual_imposto%type;
begin
   -- Select categoria INTO v_categoria from produto_exercicio 
    --where cod = p_cod;
    
    v_CATEGORIA := obter_categoria_produto(p_cod);
    
    IF v_categoria = 'Sucos' THEN
        v_IMPOSTO := 10;
    ELSIF v_categoria = 'Águas' THEN
        v_IMPOSTO := 20;
    ELSE v_IMPOSTO := 15;
END IF;   
return v_IMPOSTO;
END;

variable g_IMPOSTO VARCHAR2(100);
execute :g_IMPOSTO:= imposto_produto(41232);
print g_IMPOSTO;

--solução ALURA

CREATE OR REPLACE FUNCTION RETORNA_IMPOSTO 
(p_COD_PRODUTO produto_venda_exercicio.cod_produto%type)
RETURN produto_venda_exercicio.percentual_imposto%type
IS
   v_CATEGORIA produto_exercicio.categoria%type;
   v_IMPOSTO produto_venda_exercicio.percentual_imposto%type;
BEGIN
    v_CATEGORIA := retorna_categoria(p_COD_PRODUTO);
    IF TRIM(v_CATEGORIA) = 'Sucos de Frutas' THEN
        v_IMPOSTO := 10;
    ELSIF  TRIM(v_CATEGORIA) = 'Águas' THEN
        v_IMPOSTO := 20;
    ELSIF  TRIM(v_CATEGORIA) = 'Mate' THEN
        v_IMPOSTO := 15;
    END IF;
    RETURN v_IMPOSTO;
END;