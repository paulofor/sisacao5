package coletorjava.indicadores;

import java.text.DecimalFormat;
import java.util.List;

import coletorjava.modelo.CotacaoDiario;

public class IndicadorBasico {

	
	public static String MediaMovelSimples(List<CotacaoDiario> lista, int qtde) throws ExceptionDadosIncompletos {
		int cont = 0;
		int idx = 0;
		float total = 0;
		// Enquanto não chegou no limite de itens para a media nem no tamanho da lista
		while (cont<qtde && idx<lista.size()) {
			total += lista.get(idx).getFechamentoOriginal();
			cont++;
			idx++;
		}
		float media = total / cont;
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(media).replace(',','.');
	}
	
	public static String MediaMovelExponencial(List<CotacaoDiario> lista, int qtde) throws ExceptionDadosIncompletos {
		int cont = 0;
		int idx = 0;
		float total = 0;
		int peso = qtde;
		// Enquanto não chegou no limite de itens para a media nem no tamanho da lista
		while (cont<qtde && idx<lista.size()) {
			total += (lista.get(idx).getFechamentoOriginal()*peso);
			cont += peso;
			idx++;
			peso--;
		}
		float media = total / cont;
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(media).replace(',','.');
	}
}
