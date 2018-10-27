package coletorjava.modelo.ws;


import coletorjava.modelo.vo.*;
import coletorjava.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class CotacaoProcessadaObjetoWs   { 
      long _idCotacaoProcessada;
	public long getIdCotacaoProcessada() {
		return _idCotacaoProcessada;
	}
	public void setIdCotacaoProcessada( long dado ) {
		_idCotacaoProcessada = dado;
	}
      long _negocios;
	public long getNegocios() {
		return _negocios;
	}
	public void setNegocios( long dado ) {
		_negocios = dado;
	}
      String _horaCotacao;
	public String getHoraCotacao() {
		return _horaCotacao;
	}
	public void setHoraCotacao( String dado ) {
		_horaCotacao = dado;
	}
      String _horaSerieTemporal;
	public String getHoraSerieTemporal() {
		return _horaSerieTemporal;
	}
	public void setHoraSerieTemporal( String dado ) {
		_horaSerieTemporal = dado;
	}
      String _dataVar;
	public String getData() {
		return _dataVar;
	}
	public void setData( String dado ) {
		_dataVar = dado;
	}
      long _contadorDia;
	public long getContadorDia() {
		return _contadorDia;
	}
	public void setContadorDia( long dado ) {
		_contadorDia = dado;
	}
      float _valorCorrigido;
	public float getValorCorrigido() {
		return _valorCorrigido;
	}
	public void setValorCorrigido( float dado ) {
		_valorCorrigido = dado;
	}
      float _valorTempoReal;
	public float getValorTempoReal() {
		return _valorTempoReal;
	}
	public void setValorTempoReal( float dado ) {
		_valorTempoReal = dado;
	}
      String _horaCotacaoTempoReal;
	public String getHoraCotacaoTempoReal() {
		return _horaCotacaoTempoReal;
	}
	public void setHoraCotacaoTempoReal( String dado ) {
		_horaCotacaoTempoReal = dado;
	}
      float _valor;
	public float getValor() {
		return _valor;
	}
	public void setValor( float dado ) {
		_valor = dado;
	}
      String _linhaLog;
	public String getLinhaLog() {
		return _linhaLog;
	}
	public void setLinhaLog( String dado ) {
		_linhaLog = dado;
	}
      String _linhaTreino;
	public String getLinhaTreino() {
		return _linhaTreino;
	}
	public void setLinhaTreino( String dado ) {
		_linhaTreino = dado;
	}
      DCIObjetoDominio _anterior;
	public DCIObjetoDominio getAnterior() {
		return _anterior;
	}
	public void setAnterior( DCIObjetoDominio dado ) {
		_anterior = dado;
	}
      DCIObjetoDominio _diaPregao;
	public DCIObjetoDominio getDiaPregao() {
		return _diaPregao;
	}
	public void setDiaPregao( DCIObjetoDominio dado ) {
		_diaPregao = dado;
	}
}
