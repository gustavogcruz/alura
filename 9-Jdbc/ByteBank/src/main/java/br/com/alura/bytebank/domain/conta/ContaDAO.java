package br.com.alura.bytebank.domain.conta;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import br.com.alura.bytebank.domain.cliente.Cliente;
import br.com.alura.bytebank.domain.cliente.DadosCadastroCliente;

public class ContaDAO {

	private Connection conn;

	public ContaDAO(Connection connection) {
		this.conn = connection;

	}

	public void salvar(DadosAberturaConta dadosDaConta) {
        var cliente = new Cliente(dadosDaConta.dadosCliente());
        var conta = new Conta(dadosDaConta.numero(), cliente);
		
		String sql = "INSERT INTO conta (numero, saldo, cliente_nome, cliente_cpf, cliente_email)"
				+ "VALUES (?, ?, ?, ?, ?)";		

		try
		{
			PreparedStatement prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setInt(1, conta.getNumero());
			prepareStatement.setBigDecimal(2, BigDecimal.ZERO);
			prepareStatement.setString(3, cliente.getNome());
			prepareStatement.setString(4, cliente.getCpf());
			prepareStatement.setString(5, cliente.getEmail());
			prepareStatement.execute();
			prepareStatement.close();
			conn.close();
		}catch(
		SQLException e)
		{
			throw new RuntimeException(e);
		}		
	}
	
	public Set<Conta> listar() {
		Set<Conta> contas = new HashSet<>();
		
		PreparedStatement prepareStatement;
		ResultSet resultSet;
		
		String sql = "select * from conta";
		
		try
		{
			prepareStatement = conn.prepareStatement(sql);
			resultSet = prepareStatement.executeQuery();
			
			while(resultSet.next()) {
				Integer numero = resultSet.getInt(1);
				BigDecimal saldo = resultSet.getBigDecimal(2);
				String nome = resultSet.getString(3);
				String cpf = resultSet.getString(4);
				String email = resultSet.getString(5);
				DadosCadastroCliente dadosCadastroCliente = new DadosCadastroCliente(nome, cpf, email);
				Cliente cliente = new Cliente(dadosCadastroCliente);
				contas.add(new Conta(numero, cliente));
			}
			resultSet.close();
			prepareStatement.close();
			conn.close();
			
		}catch(
		SQLException e)
		{
			throw new RuntimeException(e);
		}
		return contas;
	}

	public Conta listarPorNumero(Integer numero) {
		
        String sql = "SELECT * FROM conta WHERE numero = ?";

        PreparedStatement prepareStatement;
        ResultSet resultSet;
        Conta conta = null;
        try {
        	prepareStatement = conn.prepareStatement(sql);
        	prepareStatement.setInt(1, numero);
            resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {
                Integer numeroRecuperado = resultSet.getInt(1);
                BigDecimal saldo = resultSet.getBigDecimal(2);
                String nome = resultSet.getString(3);
                String cpf = resultSet.getString(4);
                String email = resultSet.getString(5);

                DadosCadastroCliente dadosCadastroCliente =
                        new DadosCadastroCliente(nome, cpf, email);
                Cliente cliente = new Cliente(dadosCadastroCliente);

                conta = new Conta(numeroRecuperado, cliente);
            }
            resultSet.close();
            prepareStatement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conta;
	}
}
