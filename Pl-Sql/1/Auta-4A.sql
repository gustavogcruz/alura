desc produto_exercicio;

select * from produto_exercicio;


--delete procedure
drop PROCEDURE incluir_produtoX;

-- INSERT
CREATE or REPLACE PROCEDURE INCLUIR_PRODUTO(
p_COD in produto_exercicio.cod%type, 
p_DESCRICAO in produto_exercicio.descricao%type,
p_CATEGORIA in produto_exercicio.categoria%type
)
IS 
BEGIN
    insert into produto_exercicio (cod, descricao, categoria) values (p_COD, p_DESCRICAO, p_CATEGORIA);
    commit;
END;

-- forma de usar a procedure
EXECUTE incluir_produto(33854,'Frescor da Montanha - Aroma Laranja - 1 Litro','Mate' );

-- forma de usar a procedure
begin
incluir_produto(89254,'Frescor da Montanha - Aroma Uva - 1 Litro', 'Águas');
end;

-- UPDATE
CREATE or REPLACE PROCEDURE ATUALIZAR_PRODUTO(
p_COD in produto_exercicio.cod%type, 
--p_DESCRICAO in produto_exercicio.descricao%type,
p_CATEGORIA in produto_exercicio.categoria%type
)
IS 
BEGIN
     update produto_exercicio SET categoria = p_CATEGORIA where cod = p_COD;
    commit;
END;

EXECUTE atualizar_produto(33854,'Águas');

--DELETE
CREATE or REPLACE PROCEDURE EXCLUIR_PRODUTO(
p_COD in produto_exercicio.cod%type
--p_DESCRICAO in produto_exercicio.descricao%type,
--p_CATEGORIA in produto_exercicio.categoria%type
)
IS 
BEGIN
     delete from produto_exercicio where cod = p_COD;
    
    commit;
END;

EXECUTE excluir_produto(89254);

-- função
create or replace function obter_categoria_produto
(p_COD in produto_exercicio.cod%type)
return produto_exercicio.categoria%type
is 
v_CATEGORIA produto_exercicio.categoria%type;
begin
    select categoria INTO v_CATEGORIA from produto_exercicio 
    where cod = p_COD;
    return v_CATEGORIA;
end;

select cod, obter_categoria_produto(cod), categoria, upper(categoria) 
from produto_exercicio;