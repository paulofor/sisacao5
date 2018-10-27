package coletorjava.modelo.derivadas;

import java.util.List;

import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.parse.log.DatasUtils;
import coletorjava.modelo.CotacaoProcessada;
import coletorjava.modelo.DiaPregao;

public class DiaPregaoDerivada implements DiaPregaoDerivadaI {
	private DiaPregao principal;
	private DiaPregao anterior;
	private CotacaoProcessada ultimaDia;
	
	public DiaPregaoDerivada(DiaPregao itemPrincipal) {
		principal = itemPrincipal;
	}

	@Override
	public DCIObjetoDominio getAnterior() {
		return anterior;
	}

	@Override
	public void setAnterior(DCIObjetoDominio dado) {
		anterior = (DiaPregao) dado;
	}

	@Override
	public long getDataInteiro() {
		long data = DatasUtils.converteDD_MM_AAAA2Inteiro(principal.getData());
		return data;
	}

	@Override
	public void setDataInteiro(long dado) {
	}

	@Override
	public DCIObjetoDominio getUltimaCotacaoProcessada() {
		return this.ultimaDia; 
	}

	@Override
	public void setUltimaCotacaoProcessada(DCIObjetoDominio dado) {
		this.ultimaDia = (CotacaoProcessada) dado;
	}

	private List listaCotacaoProcessada = null;
	
	@Override
	public List getListaCotacaoProcessada() {
		return listaCotacaoProcessada;
	}

	@Override
	public void setListaCotacaoProcessada(List dado) {
		listaCotacaoProcessada = dado;
	}

	
}
