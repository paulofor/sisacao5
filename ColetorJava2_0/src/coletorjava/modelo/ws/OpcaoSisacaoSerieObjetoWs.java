package coletorjava.modelo.ws;


import coletorjava.modelo.vo.*;
import coletorjava.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class OpcaoSisacaoSerieObjetoWs   { 
      long _idOpcaoSisacaoSerie;
	public long getIdOpcaoSisacaoSerie() {
		return _idOpcaoSisacaoSerie;
	}
	public void setIdOpcaoSisacaoSerie( long dado ) {
		_idOpcaoSisacaoSerie = dado;
	}
      String _mesAno;
	public String getMesAno() {
		return _mesAno;
	}
	public void setMesAno( String dado ) {
		_mesAno = dado;
	}
      String _letra;
	public String getLetra() {
		return _letra;
	}
	public void setLetra( String dado ) {
		_letra = dado;
	}
      String _dataVencimento;
	public String getDataVencimento() {
		return _dataVencimento;
	}
	public void setDataVencimento( String dado ) {
		_dataVencimento = dado;
	}
      String _dataInicioColeta;
	public String getDataInicioColeta() {
		return _dataInicioColeta;
	}
	public void setDataInicioColeta( String dado ) {
		_dataInicioColeta = dado;
	}
      boolean _construida;
	public boolean getConstruida() {
		return _construida;
	}
	public void setConstruida( boolean dado ) {
		_construida = dado;
	}
      boolean _possuiIntraday;
	public boolean getPossuiIntraday() {
		return _possuiIntraday;
	}
	public void setPossuiIntraday( boolean dado ) {
		_possuiIntraday = dado;
	}
      long _quantidadeOpcao;
	public long getQuantidadeOpcao() {
		return _quantidadeOpcao;
	}
	public void setQuantidadeOpcao( long dado ) {
		_quantidadeOpcao = dado;
	}
}
