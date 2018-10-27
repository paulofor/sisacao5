package coletorjava.modelo.ws;


import coletorjava.modelo.vo.*;
import coletorjava.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class ResultadoPrevisaoObjetoWs   { 
      long _idResultadoPrevisao;
	public long getIdResultadoPrevisao() {
		return _idResultadoPrevisao;
	}
	public void setIdResultadoPrevisao( long dado ) {
		_idResultadoPrevisao = dado;
	}
      long _qtdeVerdadeiroPostivo;
	public long getQtdeVerdadeiroPostivo() {
		return _qtdeVerdadeiroPostivo;
	}
	public void setQtdeVerdadeiroPostivo( long dado ) {
		_qtdeVerdadeiroPostivo = dado;
	}
      long _qtdeFalsoPositivo;
	public long getQtdeFalsoPositivo() {
		return _qtdeFalsoPositivo;
	}
	public void setQtdeFalsoPositivo( long dado ) {
		_qtdeFalsoPositivo = dado;
	}
      long _qtdeTotal;
	public long getQtdeTotal() {
		return _qtdeTotal;
	}
	public void setQtdeTotal( long dado ) {
		_qtdeTotal = dado;
	}
      long _percentualSucessoPrevisao;
	public long getPercentualSucessoPrevisao() {
		return _percentualSucessoPrevisao;
	}
	public void setPercentualSucessoPrevisao( long dado ) {
		_percentualSucessoPrevisao = dado;
	}
      float _percentualPrecisao;
	public float getPercentualPrecisao() {
		return _percentualPrecisao;
	}
	public void setPercentualPrecisao( float dado ) {
		_percentualPrecisao = dado;
	}
      String _ultimaAlteracao;
	public String getUltimaAlteracao() {
		return _ultimaAlteracao;
	}
	public void setUltimaAlteracao( String dado ) {
		_ultimaAlteracao = dado;
	}
      long _idDadoThetaGd;
	public long getIdDadoThetaGd() {
		return _idDadoThetaGd;
	}
	public void setIdDadoThetaGd( long dado ) {
		_idDadoThetaGd = dado;
	}
      long _idResultadoMesMp;
	public long getIdResultadoMesMp() {
		return _idResultadoMesMp;
	}
	public void setIdResultadoMesMp( long dado ) {
		_idResultadoMesMp = dado;
	}
      long _idMesAnoRa;
	public long getIdMesAnoRa() {
		return _idMesAnoRa;
	}
	public void setIdMesAnoRa( long dado ) {
		_idMesAnoRa = dado;
	}
  private DadoThetaObjetoWs _DadoThetaGeradoDe;
	public DadoThetaObjetoWs getDadoThetaGeradoDe() {
		return _DadoThetaGeradoDe;
	}
	public void setDadoThetaGeradoDe( DadoThetaObjetoWs dado ) {
		_DadoThetaGeradoDe = dado;
	}
  private ResultadoMesObjetoWs _ResultadoMesMesmoPeriodo;
	public ResultadoMesObjetoWs getResultadoMesMesmoPeriodo() {
		return _ResultadoMesMesmoPeriodo;
	}
	public void setResultadoMesMesmoPeriodo( ResultadoMesObjetoWs dado ) {
		_ResultadoMesMesmoPeriodo = dado;
	}
  private MesAnoObjetoWs _MesAnoReferenteA;
	public MesAnoObjetoWs getMesAnoReferenteA() {
		return _MesAnoReferenteA;
	}
	public void setMesAnoReferenteA( MesAnoObjetoWs dado ) {
		_MesAnoReferenteA = dado;
	}
}
