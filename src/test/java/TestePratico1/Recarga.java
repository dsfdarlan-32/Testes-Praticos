package TestePratico1;

import testePratico1.Cliente;
import testePratico1.Conta;

public class Recarga {

	public Boolean recargaSaldoConta(Cliente cliente, Integer valor) {
		RecargaSaldoConta recargaSaldoConta = new RecargaSaldoConta();
		Conta conta = cliente.getConta();
		recargaSaldoConta.recargaSaldoConta(conta, valor);
		return true;
	}

	public Boolean recargaSaldoTelefoneDA(Cliente cliente, Integer valor) {
		RecargaSaldoTelefone recargaSaldoTelefone = new RecargaSaldoTelefone();
		Integer saldoConta = cliente.getConta().getSaldo();
		if (saldoConta >= valor) {
			recargaSaldoTelefone.recargaSaldoTelefone(cliente.getTelefone(), valor);
			cliente.getConta().setSaldo(saldoConta - valor);
			return true;
		} else {
			return false;
		}
	}
}
