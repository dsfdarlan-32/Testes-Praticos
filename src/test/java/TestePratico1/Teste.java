package TestePratico1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import testePratico1.Cliente;
import testePratico1.Conta;
import testePratico1.Telefone;


public class Teste {
	Telefone telefone;
	Conta conta;
	Cliente cliente;

	@Before
	public void init() {
		telefone = new Telefone("349999999999", 0);
		conta = new Conta(0);
		cliente = new Cliente("Teste1", telefone, conta);

	}

	@Test
	public void TestePratico1A() {
		RecargaSaldoConta teste = new RecargaSaldoConta();
		Assert.assertTrue("Deposito não Realizado", teste.recargaSaldoConta(conta, 10));
	}
	
	@Test
	public void TestePratico1B() {
		RecargaSaldoTelefone teste = new RecargaSaldoTelefone();
		Assert.assertTrue("Deposito não Realizado", teste.recargaSaldoTelefone(telefone, 10));
	}

	@Test
	public void TestePratico1C() {
		Recarga teste = new Recarga();
		teste.recargaSaldoConta(cliente, 30);
		Assert.assertTrue("Valor da recarga maior do que saldo em conta", teste.recargaSaldoTelefoneDA(cliente, 25));
	}

	@Test
	public void TestePratico1D() {
		Recarga teste = new Recarga();
		teste.recargaSaldoConta(cliente, 30);
		Assert.assertFalse(teste.recargaSaldoTelefoneDA(cliente, 50));
	}
}
