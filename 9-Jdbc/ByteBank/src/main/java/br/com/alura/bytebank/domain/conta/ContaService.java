package br.com.alura.bytebank.domain.conta;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Set;

import br.com.alura.bytebank.ConnectionFactory;
import br.com.alura.bytebank.domain.RegraDeNegocioException;

public class ContaService {
	
	private ConnectionFactory connection;
	
	public ContaService() {
		this.connection = new ConnectionFactory();
		
	}	

    public Set<Conta> listarContasAbertas() {
        Connection conn = connection.solicitaConexao();
        return new ContaDAO(conn).listar();    
    }

    public BigDecimal consultarSaldo(Integer numeroDaConta) {
        var conta = buscarContaPorNumero(numeroDaConta);
        return conta.getSaldo();
    }

    public void abrir(DadosAberturaConta dadosDaConta) {
        Connection conn = connection.solicitaConexao();
        new ContaDAO(conn).salvar(dadosDaConta);        
    }
    
    private void alterar(Conta conta, BigDecimal valor) {
        Connection conn = connection.solicitaConexao();
        
        new ContaDAO(conn).alterar(conta.getNumero(), valor);
    }

    public void realizarSaque(Integer numeroDaConta, BigDecimal valor) {
    	
        var conta = buscarContaPorNumero(numeroDaConta);
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RegraDeNegocioException("Valor do saque deve ser superior a zero!");
        }

        if (valor.compareTo(conta.getSaldo()) > 0) {
            throw new RegraDeNegocioException("Saldo insuficiente!");
        }
        
        if(!conta.getEstaAtiva()) {
        	throw new RegraDeNegocioException("Conta não está ativa!");
        }
        
        BigDecimal novoValor = conta.getSaldo().subtract(valor);
        alterar(conta, novoValor);
    }

    public void realizarDeposito(Integer numeroDaConta, BigDecimal valor) {
    	
        var conta = buscarContaPorNumero(numeroDaConta);
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RegraDeNegocioException("Valor do deposito deve ser superior a zero!");
        }
        
        if(!conta.getEstaAtiva()) {
        	throw new RegraDeNegocioException("Conta não está ativa!");
        }
        
        BigDecimal novoValor = conta.getSaldo().add(valor);
        alterar(conta, novoValor);
    }
    
    public void realizarTransferencia(Integer numeroContaOrigem, Integer numeroContaDestino, BigDecimal valor) {
    	
    	var conta = buscarContaPorNumero(numeroContaOrigem);
    	
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RegraDeNegocioException("Valor de transferência deve ser superior a zero!");
        }
        
        if (valor.compareTo(conta.getSaldo()) > 0) {
            throw new RegraDeNegocioException("Saldo insuficiente!");
        }
        
        if(!conta.getEstaAtiva()) {
        	throw new RegraDeNegocioException("Conta não está ativa!");
        }
        
        if (numeroContaOrigem.compareTo(numeroContaDestino) == 0) {
            throw new RegraDeNegocioException("Transferência Cancelada.Conta Origem e Conta Destino são iguais");
        }
    	
    	this.realizarSaque(numeroContaOrigem, valor);
    	this.realizarDeposito(numeroContaDestino, valor);   	
		
	}
    
    public Conta buscarContaPorNumero(Integer numero) {
        Connection conn = connection.solicitaConexao();
        Conta conta = new ContaDAO(conn).listarPorNumero(numero);
        if(conta != null && conta.getEstaAtiva() == true) {
            return conta;
        } else {
            throw new RegraDeNegocioException("Não existe conta cadastrada com esse número!");
        }
    }

    public void encerrar(Integer numeroDaConta) {
    	Connection conn = connection.solicitaConexao();
        var conta = buscarContaPorNumero(numeroDaConta);
        
        if (conta.possuiSaldo()) {
            throw new RegraDeNegocioException("Conta não pode ser encerrada pois ainda possui saldo!");
        }

        new ContaDAO(conn).encerrarConta(numeroDaConta);
    }  
}
