package TestePratico1;

import testePratico1.Conta;

public class RecargaSaldoConta {
	
	public Boolean recargaSaldoConta(Conta ct,Integer valor) {
		ct.setSaldo(valor);
		return true;
	}
}
