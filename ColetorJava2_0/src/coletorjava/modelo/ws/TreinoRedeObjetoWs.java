package coletorjava.modelo.ws;


import coletorjava.modelo.vo.*;
import coletorjava.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class TreinoRedeObjetoWs   { 
      long _idTreinoRede;
	public long getIdTreinoRede() {
		return _idTreinoRede;
	}
	public void setIdTreinoRede( long dado ) {
		_idTreinoRede = dado;
	}
      float _lambda;
	public float getLambda() {
		return _lambda;
	}
	public void setLambda( float dado ) {
		_lambda = dado;
	}
      long _iteracoes;
	public long getIteracoes() {
		return _iteracoes;
	}
	public void setIteracoes( long dado ) {
		_iteracoes = dado;
	}
      String _ultimaAlteracao;
	public String getUltimaAlteracao() {
		return _ultimaAlteracao;
	}
	public void setUltimaAlteracao( String dado ) {
		_ultimaAlteracao = dado;
	}
      long _idRedePa;
	public long getIdRedePa() {
		return _idRedePa;
	}
	public void setIdRedePa( long dado ) {
		_idRedePa = dado;
	}
      long _idDadoTreinoGp;
	public long getIdDadoTreinoGp() {
		return _idDadoTreinoGp;
	}
	public void setIdDadoTreinoGp( long dado ) {
		_idDadoTreinoGp = dado;
	}
  private RedeObjetoWs _RedePertenceA;
	public RedeObjetoWs getRedePertenceA() {
		return _RedePertenceA;
	}
	public void setRedePertenceA( RedeObjetoWs dado ) {
		_RedePertenceA = dado;
	}
  private DadoTreinoObjetoWs _DadoTreinoGeradoPor;
	public DadoTreinoObjetoWs getDadoTreinoGeradoPor() {
		return _DadoTreinoGeradoPor;
	}
	public void setDadoTreinoGeradoPor( DadoTreinoObjetoWs dado ) {
		_DadoTreinoGeradoPor = dado;
	}
}
