package coletorjava.modelo.ws;


import coletorjava.modelo.vo.*;
import coletorjava.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class OpcaoSisacaoGeralObjetoWs   { 
      long _idOpcaoSisacaoGeral;
	public long getIdOpcaoSisacaoGeral() {
		return _idOpcaoSisacaoGeral;
	}
	public void setIdOpcaoSisacaoGeral( long dado ) {
		_idOpcaoSisacaoGeral = dado;
	}
      String _codigoMercado;
	public String getCodigoMercado() {
		return _codigoMercado;
	}
	public void setCodigoMercado( String dado ) {
		_codigoMercado = dado;
	}
      float _precoExercicio;
	public float getPrecoExercicio() {
		return _precoExercicio;
	}
	public void setPrecoExercicio( float dado ) {
		_precoExercicio = dado;
	}
      String _dataInclusao;
	public String getDataInclusao() {
		return _dataInclusao;
	}
	public void setDataInclusao( String dado ) {
		_dataInclusao = dado;
	}
      String _mesAno;
	public String getMesAno() {
		return _mesAno;
	}
	public void setMesAno( String dado ) {
		_mesAno = dado;
	}
      String _descricaoBdi;
	public String getDescricaoBdi() {
		return _descricaoBdi;
	}
	public void setDescricaoBdi( String dado ) {
		_descricaoBdi = dado;
	}
      boolean _coletaDiario;
	public boolean getColetaDiario() {
		return _coletaDiario;
	}
	public void setColetaDiario( boolean dado ) {
		_coletaDiario = dado;
	}
      boolean _possuiColetaIntraday;
	public boolean getPossuiColetaIntraday() {
		return _possuiColetaIntraday;
	}
	public void setPossuiColetaIntraday( boolean dado ) {
		_possuiColetaIntraday = dado;
	}
      boolean _possui15minutos;
	public boolean getPossui15minutos() {
		return _possui15minutos;
	}
	public void setPossui15minutos( boolean dado ) {
		_possui15minutos = dado;
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
      String _dataVencimentoStr;
	public String getDataVencimentoStr() {
		return _dataVencimentoStr;
	}
	public void setDataVencimentoStr( String dado ) {
		_dataVencimentoStr = dado;
	}
      String _especificacao;
	public String getEspecificacao() {
		return _especificacao;
	}
	public void setEspecificacao( String dado ) {
		_especificacao = dado;
	}
      String _nomeRes;
	public String getNomeRes() {
		return _nomeRes;
	}
	public void setNomeRes( String dado ) {
		_nomeRes = dado;
	}
      long _totalNegocioDiaAnterior;
	public long getTotalNegocioDiaAnterior() {
		return _totalNegocioDiaAnterior;
	}
	public void setTotalNegocioDiaAnterior( long dado ) {
		_totalNegocioDiaAnterior = dado;
	}
      float _valorCotacao;
	public float getValorCotacao() {
		return _valorCotacao;
	}
	public void setValorCotacao( float dado ) {
		_valorCotacao = dado;
	}
      long _qtdeNegocio;
	public long getQtdeNegocio() {
		return _qtdeNegocio;
	}
	public void setQtdeNegocio( long dado ) {
		_qtdeNegocio = dado;
	}
}
