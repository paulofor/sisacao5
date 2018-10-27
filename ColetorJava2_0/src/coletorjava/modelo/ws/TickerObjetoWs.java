package coletorjava.modelo.ws;


import coletorjava.modelo.vo.*;
import coletorjava.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class TickerObjetoWs   { 
      long _idTicker;
	public long getIdTicker() {
		return _idTicker;
	}
	public void setIdTicker( long dado ) {
		_idTicker = dado;
	}
      String _nome;
	public String getNome() {
		return _nome;
	}
	public void setNome( String dado ) {
		_nome = dado;
	}
      String _empresa;
	public String getEmpresa() {
		return _empresa;
	}
	public void setEmpresa( String dado ) {
		_empresa = dado;
	}
      String _tipoAcao;
	public String getTipoAcao() {
		return _tipoAcao;
	}
	public void setTipoAcao( String dado ) {
		_tipoAcao = dado;
	}
      String _dataInicioDiario;
	public String getDataInicioDiario() {
		return _dataInicioDiario;
	}
	public void setDataInicioDiario( String dado ) {
		_dataInicioDiario = dado;
	}
      String _dataMaisRecenteDiario;
	public String getDataMaisRecenteDiario() {
		return _dataMaisRecenteDiario;
	}
	public void setDataMaisRecenteDiario( String dado ) {
		_dataMaisRecenteDiario = dado;
	}
      String _dataInicioColetaOpcao;
	public String getDataInicioColetaOpcao() {
		return _dataInicioColetaOpcao;
	}
	public void setDataInicioColetaOpcao( String dado ) {
		_dataInicioColetaOpcao = dado;
	}
      String _dataFinalColetaOpcao;
	public String getDataFinalColetaOpcao() {
		return _dataFinalColetaOpcao;
	}
	public void setDataFinalColetaOpcao( String dado ) {
		_dataFinalColetaOpcao = dado;
	}
}
