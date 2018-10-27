package coletorjava.modelo.ws;


import coletorjava.modelo.vo.*;
import coletorjava.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class ProjetoDadoTreinoObjetoWs   { 
      long _idProjetoDadoTreino;
	public long getIdProjetoDadoTreino() {
		return _idProjetoDadoTreino;
	}
	public void setIdProjetoDadoTreino( long dado ) {
		_idProjetoDadoTreino = dado;
	}
      float _target;
	public float getTarget() {
		return _target;
	}
	public void setTarget( float dado ) {
		_target = dado;
	}
      float _stop;
	public float getStop() {
		return _stop;
	}
	public void setStop( float dado ) {
		_stop = dado;
	}
      String _posicaoCompraVenda;
	public String getPosicaoCompraVenda() {
		return _posicaoCompraVenda;
	}
	public void setPosicaoCompraVenda( String dado ) {
		_posicaoCompraVenda = dado;
	}
      String _ultimaAlteracao;
	public String getUltimaAlteracao() {
		return _ultimaAlteracao;
	}
	public void setUltimaAlteracao( String dado ) {
		_ultimaAlteracao = dado;
	}
      long _idTickerRa;
	public long getIdTickerRa() {
		return _idTickerRa;
	}
	public void setIdTickerRa( long dado ) {
		_idTickerRa = dado;
	}
  private TickerObjetoWs _TickerReferenteA;
	public TickerObjetoWs getTickerReferenteA() {
		return _TickerReferenteA;
	}
	public void setTickerReferenteA( TickerObjetoWs dado ) {
		_TickerReferenteA = dado;
	}
}
