package TestePratico1;

import testePrático1.Conta;

public class RecargaSaldoConta {
	
	public Boolean recargaSaldoConta(Conta ct,Integer valor) {
		ct.setSaldo(valor);
		return true;
	}
}
