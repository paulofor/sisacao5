package coletorjava.modelo.ws;


import coletorjava.modelo.vo.*;
import coletorjava.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class DadoThetaObjetoWs   { 
      long _idDadoTheta;
	public long getIdDadoTheta() {
		return _idDadoTheta;
	}
	public void setIdDadoTheta( long dado ) {
		_idDadoTheta = dado;
	}
      String _nomeArquivo;
	public String getNomeArquivo() {
		return _nomeArquivo;
	}
	public void setNomeArquivo( String dado ) {
		_nomeArquivo = dado;
	}
      String _ultimaAlteracao;
	public String getUltimaAlteracao() {
		return _ultimaAlteracao;
	}
	public void setUltimaAlteracao( String dado ) {
		_ultimaAlteracao = dado;
	}
      long _idTreinoRedeGp;
	public long getIdTreinoRedeGp() {
		return _idTreinoRedeGp;
	}
	public void setIdTreinoRedeGp( long dado ) {
		_idTreinoRedeGp = dado;
	}
  private TreinoRedeObjetoWs _TreinoRedeGeradoPor;
	public TreinoRedeObjetoWs getTreinoRedeGeradoPor() {
		return _TreinoRedeGeradoPor;
	}
	public void setTreinoRedeGeradoPor( TreinoRedeObjetoWs dado ) {
		_TreinoRedeGeradoPor = dado;
	}
}
