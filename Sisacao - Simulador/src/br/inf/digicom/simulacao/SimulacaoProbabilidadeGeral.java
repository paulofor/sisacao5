package br.inf.digicom.simulacao;

import java.util.HashMap;
import java.util.List;

import br.com.digicom.sisacao.modelo.CotacaoIntradayAcao;
import br.com.digicom.sisacao.modelo.DiaPregao;

public class SimulacaoProbabilidadeGeral {
	
	private int somaLucro = 0;
	private int somaPrejuizo = 0;
	private int somaPrazo = 0;
	
	private int contaDia = 0;
	private double somaDia = 0;
	
	private double target = .07;
	private double stop = .1;
	
	
	private HashMap<Integer,Integer> dist = new HashMap<Integer,Integer>();

	public void executa(List<DiaPregao> dias) {
		// TODO Auto-generated method stub

		somaLucro = 0;
		somaPrejuizo = 0;
		somaPrazo = 0;
		
		int indDia = 0;
		int indHora = 0;
		while (dias.get(indDia).getCotacaoIntradayAcaos().size() == 0) {
			indDia++;
		}
		//System.out.println("Vai começar em " + dias.get(indDia).getDiaNum());
		indHora = 0;
		while (dias.get(indDia).getDiaNum() < 20210125) {
			while (dias.get(indDia).getCotacaoIntradayAcaos().size()>indHora) {
				testaTick(indDia,indHora,dias);
				indHora++;
			}
			indDia++;
			indHora=0;
		}
		exibeResultado(somaLucro,somaPrejuizo);
		
		
	}

	private void testaTick(int indDia, int indHora, List<DiaPregao> dias) {
		CotacaoIntradayAcao cotacao = dias.get(indDia).getCotacaoIntradayAcaos().get(indHora);
		double entrada = cotacao.getValor();
		double saidaAlta = entrada * (1+target);
		double saidaBaixa = entrada * (1-stop);
		
		int pesqDia = indDia;
		int pesqHora = indHora;
		int somaDia = 0;
		double totalDia = 0;
		
		
		pesqHora++;
		while (dias.size()>pesqDia) {
			//System.out.println("Dia: " + dias.get(pesqDia).getDiaNum());
			//this.exibeDia(pesqDia, dias);
			while (dias.get(pesqDia).getCotacaoIntradayAcaos().size()>pesqHora) {
				CotacaoIntradayAcao atual = dias.get(pesqDia).getCotacaoIntradayAcaos().get(pesqHora);
				//System.out.println("pesqHora: " + pesqHora + ", cotacao:" + atual);
				int diferencaDia = pesqDia - indDia;
				if (atual.getValor()>=saidaAlta) {
					this.somaLucro++;
					exibeResultado(indDia,indHora,pesqDia,pesqHora, dias, "lucro" , diferencaDia);
					return;
				}
				if (atual.getValor()<=saidaBaixa) {
					this.somaPrejuizo++;
					exibeResultado(indDia,indHora,pesqDia,pesqHora, dias, "prejuizo", diferencaDia);
					return;
				}
				if (diferencaDia>=15) {
					this.somaPrazo++;
					return;
				}
				pesqHora++;
			}
			pesqDia++;
			pesqHora = 0;
		}
	}
	
	
	private void exibeResultado(int dia1,int hora1,int dia2,int hora2, List<DiaPregao>dias, String resultado, int diferencaDia) {
		DiaPregao diaEntrada = dias.get(dia1);
		DiaPregao diaSaida = dias.get(dia2);
		CotacaoIntradayAcao cotacaoEntrada = diaEntrada.getCotacaoIntradayAcaos().get(hora1);
		CotacaoIntradayAcao cotacaoSaida = diaSaida.getCotacaoIntradayAcaos().get(hora2);
		System.out.println();
		System.out.println("Entrada:" + diaEntrada.getDiaNum() + ", Horario:" + cotacaoEntrada.getDataHora() + 
				", Valor:" + cotacaoEntrada.getValor() + " (" + resultado + ") - " + diferencaDia + " dias");
		System.out.println("Saida:" + diaSaida.getDiaNum() + ", Horario:" + cotacaoSaida.getDataHora() + ", Valor:" + cotacaoSaida.getValor());
	}
	
	private CotacaoIntradayAcao obtemCotacao(int indDia,int indHora, List<DiaPregao> dias) {
		return dias.get(indDia).getCotacaoIntradayAcaos().get(indHora);
	}
	
	private void exibeDia(int indDia, List<DiaPregao> dias) {
		
		for (CotacaoIntradayAcao cotacao: dias.get(indDia).getCotacaoIntradayAcaos()) {
			System.out.println("Cotacao:" + cotacao);
		}
	}
	

	private void exibeResultado(int lucro, int prejuizo) {
		double total = lucro + prejuizo;
		double dbLucro = lucro;
		double dbPrejuizo = prejuizo;
		double percLucro = (dbLucro / total) * 100;
		double percPrejuizo = (dbPrejuizo /total) * 100;
		System.out.println();
		//System.out.println("Lucro: " + lucro + " (" + percLucro + "% )");
		//System.out.println("Prejuixo: " + prejuizo + " (" + percPrejuizo + "% )");
		//System.out.println();
		System.out.printf("\nLucro: %d ( %.2f%s )", lucro, percLucro,"%");
		System.out.printf("\nPrejuizo: %d ( %.2f%s )", prejuizo, percPrejuizo,"%");
		System.out.println("\nPrazo: " + this.somaPrazo);
		
	}
}
