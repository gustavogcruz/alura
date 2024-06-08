desc cliente;
desc segmercado;

create or replace PROCEDURE incluir_cliente
(
p_ID cliente.id%type,
p_RAZAO cliente.razao_social%type,
p_CNPJ cliente.cnpj%type,
p_SEGMERCADO cliente.segmercado_id%type,
p_FATURAMENTE cliente.faturamento_previsto%type,
p_CATEGORIA cliente.categoria%type)

is
begin

insert into cliente
values(
p_ID,
p_RAZAO,
p_CNPJ,
p_SEGMERCADO
,sysdate, 
p_FATURAMENTE, 
p_CATEGORIA);
commit;

end;

select * from cliente;
select * from segmercado;

execute incluir_cliente(1,'SUPERMERCADO CAMPEÃO', '1234567890', 1, 90000, 'MEDIO GRANDE');

/*Classificação categoria cliente*/

-- PEQUENO fatura até 10000;
-- MÉDIO 10001 e 50000;
-- MEDIO GRANDE 50001 e 100000
-- GRANDE MAIS de 100000

SET SERVEROUTPUT ON

DECLARE
v_FATURAMENTO cliente.faturamento_previsto%type := 120000;
v_CATEGORIA cliente.categoria%type;
BEGIN
    IF v_FATURAMENTO <= 10000 THEN
    v_CATEGORIA := 'PEQUENO';
    ELSIF v_FATURAMENTO <= 50000 THEN
        v_CATEGORIA := 'MÉDIO';
    ELSIF v_FATURAMENTO <= 100000 THEN
        v_CATEGORIA := 'MÉDIO GRANDE';
    ELSE v_CATEGORIA := 'GRANDE';
END IF;    
dbms_output.put_line('A Categoria é ' || v_CATEGORIA);
END;

--função

create or replace function categoria_cliente
(
p_FATURAMENTO cliente.faturamento_previsto%type)
return
cliente.categoria%type
is
v_CATEGORIA cliente.categoria%type;
begin
    IF p_FATURAMENTO <= 10000 THEN
    v_CATEGORIA := 'PEQUENO';
    ELSIF p_FATURAMENTO <= 50000 THEN
        v_CATEGORIA := 'MÉDIO';
    ELSIF p_FATURAMENTO <= 100000 THEN
        v_CATEGORIA := 'MÉDIO GRANDE';
    ELSE v_CATEGORIA := 'GRANDE';
END IF;   
return v_CATEGORIA;
END;

variable g_CATEGORIA VARCHAR2(100);
execute :g_CATEGORIA:= categoria_cliente(10000);
print g_CATEGORIA;


create or replace PROCEDURE incluir_cliente
(
p_ID cliente.id%type,
p_RAZAO cliente.razao_social%type,
p_CNPJ cliente.cnpj%type,
p_SEGMERCADO cliente.segmercado_id%type,
p_FATURAMENTO cliente.faturamento_previsto%type)

is
 v_CATEGORIA cliente.categoria%type;
begin

v_CATEGORIA := categoria_cliente(p_FATURAMENTO);

insert into cliente
values(
p_ID,
p_RAZAO,
p_CNPJ,
p_SEGMERCADO
,sysdate, 
p_FATURAMENTO, 
v_CATEGORIA);
commit;

end;

execute incluir_cliente(3,'SUPERMERCADOS CARIOCA', '1234567892', 1, 30000);