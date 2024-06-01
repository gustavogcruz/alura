-- exemplo 1

/*SET SERVEROUTPUT ON;

declare
--  Definição de componentes de trabalho (variáveis, constantes, etc)
    v_ID NUMBER(5) := 1;
begin
--  Comandos de execução
    dbms_output.put_line(v_id);
    v_ID := 2;
    dbms_output.put_line(v_id);
end;

-- exemplo 2

SET SERVEROUTPUT ON;
DECLARE
   v_ID VARCHAR(30) := 'Novo programa PL/SQL';
BEGIN 
   dbms_output.put_line(v_ID);
   v_ID := 2 ;
   dbms_output.put_line(v_ID);
END;*/

insert into segmercado (id, descricao)
values (1,'Varejo');

-- exemplos consultas

SELECT * FROM segmercado;

SELECT * FROM segmercado WHERE segmercado.descricao = 'Atacado';

SELECT * FROM segmercado WHERE segmercado.descricao = 'atacado';

SELECT * FROM segmercado WHERE upper(descricao) = 'ATACADO';


delete from segmercado;

-- INSERT padrão passando o tipo na variavel
DECLARE
   v_ID NUMBER(5) :=2;
   v_DESCRICAO VARCHAR2(100) := 'Industria';
BEGIN
   INSERT INTO SEGMERCADO (ID, DESCRICAO) VALUES (v_ID, v_DESCRICAO); 
   COMMIT;

END;


-- INSERT usando %TYPE
DECLARE
    v_ID segmercado.id%type := 4;
    v_DESCRICAO segmercado.descricao%type := 'Esportista';

BEGIN
    insert into segmercado (id, descricao)
    values (v_ID,upper(v_DESCRICAO));
    commit;
END;

-- update usando bloco
DECLARE
    v_ID segmercado.id%type := 3;
    v_DESCRICAO segmercado.descricao%type := 'Atacadista';

BEGIN
    update segmercado SET descricao = upper(V_DESCRICAO) where id = v_ID;
    
    v_ID := 1;
    V_DESCRICAO := 'Varejista';
    update segmercado SET descricao = upper(V_DESCRICAO) where id = v_ID;
    
    v_ID := 2;
    V_DESCRICAO := 'Industrial';
    update segmercado SET descricao = upper(V_DESCRICAO) where id = v_ID;
    
    v_ID := 4;
    V_DESCRICAO := 'ESportista';
    update segmercado SET descricao = upper(V_DESCRICAO) where id = v_ID;
    
    commit;
END;

-- delete
DECLARE
    v_ID segmercado.id%type := 4;

BEGIN
    delete from segmercado where id = v_ID;
    
    commit;
END;
