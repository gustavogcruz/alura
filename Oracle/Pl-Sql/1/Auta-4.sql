select * from segmercado;

-- decla��o com tipos explicitos
CREATE PROCEDURE INCLUIR_SEGMERCADO
(p_ID in number, p_DESCRICAO in varchar2)
IS 
BEGIN
    insert into segmercado (id, descricao) values (p_ID,upper(p_DESCRICAO));
    commit;
END;

-- decla��o com tipos explicitos
-- inclus�o da op��o REPLACE
CREATE or REPLACE PROCEDURE INCLUIR_SEGMERCADO
(p_ID in segmercado.id%type, p_DESCRICAO in segmercado.descricao%type)
IS 
BEGIN
    insert into segmercado (id, descricao) values (p_ID,upper(p_DESCRICAO));
    commit;
END;

--delete procedure
drop PROCEDURE INCLUIR_SEGMERCADO3;

-- forma de usar a procedure
EXECUTE incluir_segmercado(5,'Farmaceuticos');

-- forma de usar a procedure
begin
incluir_segmercado(6,'Farmaceuticos');
end;

-- script passando o resultado por descritor
SET SERVEROUTPUT ON;

DECLARE
    v_ID segmercado.ID%type :=1;
    v_DESCRICAO segmercado.descricao%type;
BEGIN
    select descricao INTO v_DESCRICAO from segmercado where id = v_ID;
    dbms_output.put_line(v_DESCRICAO);
END;

-- fun��o
create or replace FUNCTION obter_descricao_segmercado
(p_ID in segmercado.id%type)
return segmercado.descricao%type
is
v_DESCRICAO segmercado.descricao%type;
begin
    select descricao INTO v_DESCRICAO from segmercado where id = p_ID;
    return v_DESCRICAO;
end;

-- exemplo uso fun��o
select id, obter_descricao_segmercado(ID), descricao, lower(descricao) from segmercado;

-- forma de usar a fun��o
variable g_DESCRICAO VARCHAR2(100);
execute :g_DESCRICAO:= obter_descricao_segmercado(3);
print g_DESCRICAO;

-- forma de usar a fun��o
SET SERVEROUTPUT ON;
declare
    v_DESCRICAO segmercado.descricao%type;
    v_ID segmercado.id%type :=1;
begin
    v_DESCRICAO := obter_descricao_segmercado(v_ID);
    dbms_output.put_line('A descri��o do segmento de mercado � ' || v_DESCRICAO);
end;