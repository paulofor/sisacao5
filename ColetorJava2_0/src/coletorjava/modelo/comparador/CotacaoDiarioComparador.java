package coletorjava.modelo.comparador;

import java.util.Comparator;

import coletorjava.modelo.CotacaoDiario;

public class CotacaoDiarioComparador implements Comparator<CotacaoDiario>{

	@Override
	public int compare(CotacaoDiario cotacao1, CotacaoDiario cotacao2) {
		int data1 = Integer.parseInt(cotacao1.getDataAAAAMMDD());
		int data2 = Integer.parseInt(cotacao2.getDataAAAAMMDD());
        return (int) data1 - data2;
	}

	

}
