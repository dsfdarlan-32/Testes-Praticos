package TestePratico1;

import testePrático1.Telefone;

public class RecargaSaldoTelefone {

	public Boolean recargaSaldoTelefone(Telefone telefone, Integer valor) {
		telefone.setSaldo(telefone.getSaldo() + valor);
		return true;
	}
}
