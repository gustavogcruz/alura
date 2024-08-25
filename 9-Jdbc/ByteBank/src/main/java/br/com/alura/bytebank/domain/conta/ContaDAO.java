package br.com.alura.bytebank.domain.conta;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.mysql.cj.xdevapi.PreparableStatement;

import br.com.alura.bytebank.domain.cliente.Cliente;
import br.com.alura.bytebank.domain.cliente.DadosCadastroCliente;

public class ContaDAO {

	private Connection conn;

	public ContaDAO(Connection connection) {
		this.conn = connection;

	}

	public void salvar(DadosAberturaConta dadosDaConta) {
        var cliente = new Cliente(dadosDaConta.dadosCliente());
        var conta = new Conta(dadosDaConta.numero(), BigDecimal.ZERO, cliente, true);
		
		String sql = "INSERT INTO conta (numero, saldo, cliente_nome, cliente_cpf, cliente_email, esta_ativa)"
				+ "VALUES (?, ?, ?, ?, ?, ?)";		

		try
		{
			PreparedStatement prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setInt(1, conta.getNumero());
			prepareStatement.setBigDecimal(2, BigDecimal.ZERO);
			prepareStatement.setString(3, cliente.getNome());
			prepareStatement.setString(4, cliente.getCpf());
			prepareStatement.setString(5, cliente.getEmail());
			prepareStatement.setBoolean(6, true);
			
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
		
		String sql = "SELECT * FROM conta WHERE esta_ativa = ?";
		
		try
		{
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setBoolean(1, true);
			resultSet = prepareStatement.executeQuery();
			
			while(resultSet.next()) {
				Integer numero = resultSet.getInt(1);
				BigDecimal saldo = resultSet.getBigDecimal(2);
				String nome = resultSet.getString(3);
				String cpf = resultSet.getString(4);
				String email = resultSet.getString(5);
				Boolean estaAtiva = resultSet.getBoolean(6);
				DadosCadastroCliente dadosCadastroCliente = new DadosCadastroCliente(nome, cpf, email);
				Cliente cliente = new Cliente(dadosCadastroCliente);
				contas.add(new Conta(numero, saldo, cliente, estaAtiva));
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
		
        String sql = "SELECT * FROM conta WHERE numero = ? AND esta_ativa = ?";

        PreparedStatement prepareStatement;
        ResultSet resultSet;
        Conta conta = null;
        try {
        	prepareStatement = conn.prepareStatement(sql);
        	prepareStatement.setInt(1, numero);
        	prepareStatement.setBoolean(2, true);
            resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {
                Integer numeroRecuperado = resultSet.getInt(1);
                BigDecimal saldo = resultSet.getBigDecimal(2);                
                String nome = resultSet.getString(3);
                String cpf = resultSet.getString(4);
                String email = resultSet.getString(5);
                Boolean estaAtiva = resultSet.getBoolean(6);

                DadosCadastroCliente dadosCadastroCliente =
                        new DadosCadastroCliente(nome, cpf, email);
                Cliente cliente = new Cliente(dadosCadastroCliente);

                conta = new Conta(numeroRecuperado, saldo, cliente, estaAtiva);
            }
            resultSet.close();
            prepareStatement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conta;
	}
	
	public void alterar(Integer numero, BigDecimal valor) {
		
		PreparedStatement prepareStatement;
		
		String sql = "UPDATE conta SET saldo = ? WHERE numero = ?";
		
		try {
			conn.setAutoCommit(false);
			prepareStatement = conn.prepareStatement(sql);
			
			prepareStatement.setBigDecimal(1, valor);
			prepareStatement.setInt(2, numero);			
			
			prepareStatement.execute();
			conn.commit();
			prepareStatement.close();
			conn.close();
			
		}catch (SQLException e) {
			try {
				conn.rollback();
			}catch (SQLException ex) {
			throw new RuntimeException(ex);	
			}
			throw new RuntimeException(e);
		}
		
	}
	
	public void encerrarConta(Integer numero) {

		PreparedStatement prepareStatement;

		String sql = "UPDATE conta SET esta_ativa = ? WHERE numero = ?";

		try {
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setBoolean(1, false);
			prepareStatement.setInt(2, numero);
			prepareStatement.execute();

			prepareStatement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

}
