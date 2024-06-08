select * from produto_exercicio;

-- padrão passando o tipo na variavel
DECLARE
    v_COD NUMBER(5) := 92347;
    v_DESCRICAO VARCHAR2(100) := 'Aroma do Campo - Mate - 1 Litro';
    v_CATEGORIA VARCHAR2(100) :='Águas';

BEGIN
    insert into produto_exercicio (cod, descricao, categoria)
    values (v_COD,v_DESCRICAO, v_CATEGORIA);
    commit;
END;

-- usando %type
DECLARE
    v_COD produto_exercicio.cod%type := 32223;
    v_DESCRICAO produto_exercicio.descricao%type := 'Sabor de Verão - Limão - 1 Litro';
    v_CATEGORIA produto_exercicio.categoria%type :='Sucos de Frutas';

BEGIN
    insert into produto_exercicio (cod, descricao, categoria)
    values (v_COD,replace(v_DESCRICAO,' - ',' > '), v_CATEGORIA);
    commit;
END;

-- update usando bloco
DECLARE
    v_COD produto_exercicio.cod%type := 92347;
    --v_DESCRICAO produto_exercicio.descricao%type := 'Aroma do Campo - Mate - 1 Litro';
    v_CATEGORIA produto_exercicio.categoria%type :='Mate';

BEGIN
    update produto_exercicio SET categoria = v_CATEGORIA where cod = v_COD;
    
    --v_COD:= 41233;
   -- update produto_exercicio SET descricao = replace(v_DESCRICAO, ' - ', ' > ') where cod = v_COD;
    
    commit;
END;



