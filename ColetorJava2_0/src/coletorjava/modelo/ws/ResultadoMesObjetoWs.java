package coletorjava.modelo.ws;


import coletorjava.modelo.vo.*;
import coletorjava.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class ResultadoMesObjetoWs   { 
      long _idResultadoMes;
	public long getIdResultadoMes() {
		return _idResultadoMes;
	}
	public void setIdResultadoMes( long dado ) {
		_idResultadoMes = dado;
	}
      long _qtdeTotal;
	public long getQtdeTotal() {
		return _qtdeTotal;
	}
	public void setQtdeTotal( long dado ) {
		_qtdeTotal = dado;
	}
      long _qtdeSucesso;
	public long getQtdeSucesso() {
		return _qtdeSucesso;
	}
	public void setQtdeSucesso( long dado ) {
		_qtdeSucesso = dado;
	}
      long _qtdeFracasso;
	public long getQtdeFracasso() {
		return _qtdeFracasso;
	}
	public void setQtdeFracasso( long dado ) {
		_qtdeFracasso = dado;
	}
      long _qtdeNeutro;
	public long getQtdeNeutro() {
		return _qtdeNeutro;
	}
	public void setQtdeNeutro( long dado ) {
		_qtdeNeutro = dado;
	}
      float _percentualSucesso;
	public float getPercentualSucesso() {
		return _percentualSucesso;
	}
	public void setPercentualSucesso( float dado ) {
		_percentualSucesso = dado;
	}
      String _ultimaAlteracao;
	public String getUltimaAlteracao() {
		return _ultimaAlteracao;
	}
	public void setUltimaAlteracao( String dado ) {
		_ultimaAlteracao = dado;
	}
      long _idProjetoDadoTreinoGp;
	public long getIdProjetoDadoTreinoGp() {
		return _idProjetoDadoTreinoGp;
	}
	public void setIdProjetoDadoTreinoGp( long dado ) {
		_idProjetoDadoTreinoGp = dado;
	}
      long _idMesAnoRa;
	public long getIdMesAnoRa() {
		return _idMesAnoRa;
	}
	public void setIdMesAnoRa( long dado ) {
		_idMesAnoRa = dado;
	}
  private ProjetoDadoTreinoObjetoWs _ProjetoDadoTreinoGeradoPor;
	public ProjetoDadoTreinoObjetoWs getProjetoDadoTreinoGeradoPor() {
		return _ProjetoDadoTreinoGeradoPor;
	}
	public void setProjetoDadoTreinoGeradoPor( ProjetoDadoTreinoObjetoWs dado ) {
		_ProjetoDadoTreinoGeradoPor = dado;
	}
  private MesAnoObjetoWs _MesAnoReferenteA;
	public MesAnoObjetoWs getMesAnoReferenteA() {
		return _MesAnoReferenteA;
	}
	public void setMesAnoReferenteA( MesAnoObjetoWs dado ) {
		_MesAnoReferenteA = dado;
	}
}
