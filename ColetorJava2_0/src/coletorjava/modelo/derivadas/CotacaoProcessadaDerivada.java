package coletorjava.modelo.derivadas;

import br.com.digicom.lib.DCIObjetoDominio;
import coletorjava.modelo.CotacaoProcessada;
import coletorjava.modelo.DiaPregao;

public class CotacaoProcessadaDerivada implements CotacaoProcessadaDerivadaI {
	
	private CotacaoProcessada principal;
	private CotacaoProcessada anterior;
	private DiaPregao mDiaPregao;

	public CotacaoProcessadaDerivada(CotacaoProcessada itemPrincipal) {
		principal = itemPrincipal;
	}

	@Override
	public String getLinhaLog() {
		return principal.getData() + " ( " + principal.getHoraSerieTemporal() + " HoraCotacao: " + principal.getHoraCotacao() + " HoraTempoReal: " + 
				principal.getHoraCotacaoTempoReal() + " ) : " + principal.getValorCorrigidoFormatada() + " [" + principal.getValorFormatada() + "]";
	}

	@Override
	public void setLinhaLog(String dado) {
	}
	private static final int LIMITE_ENTRADAS = 5;
	private static final String SEPARADOR = " , ";
	
	@Override
	public String getLinhaTreino() {
		String saida = "";
		CotacaoProcessada corrente = principal;
		DiaPregao diaCorrente = (DiaPregao) principal.getDiaPregao();
		int contEntradas = 0;
		while(diaCorrente!=null && contEntradas <= LIMITE_ENTRADAS) {
			while (corrente!=null && contEntradas <= LIMITE_ENTRADAS) {
				saida += corrente.getContadorDia() + SEPARADOR + corrente.getValor() + SEPARADOR;
				contEntradas++;
				corrente = (CotacaoProcessada) corrente.getAnterior();
			}
			diaCorrente = (DiaPregao) diaCorrente.getAnterior();
			corrente = (CotacaoProcessada) diaCorrente.getUltimaCotacaoProcessada();
		}
		saida = saida.substring(0, saida.length() - SEPARADOR.length());
		return saida;	}
	@Override
	public void setLinhaTreino(String dado) {
	}

	@Override
	public DCIObjetoDominio getAnterior() {
		return anterior;
	}

	@Override
	public void setAnterior(DCIObjetoDominio dado) {
		anterior = (CotacaoProcessada) dado;
	}

	@Override
	public DCIObjetoDominio getDiaPregao() {
		return this.mDiaPregao;
	}

	@Override
	public void setDiaPregao(DCIObjetoDominio dado) {
		this.mDiaPregao = (DiaPregao) dado;
	}
}
