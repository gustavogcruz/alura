package br.com.alura.bytebank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class ConnectionFactory {
	
	public Connection solicitaConexao() {
		try {
			return DriverManager
			.getConnection("jdbc:mysql://localhost:3306/byte_bank?user=root&password=root");
		
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}			
	}
}
