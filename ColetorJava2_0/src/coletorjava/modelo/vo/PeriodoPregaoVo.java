package coletorjava.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;
import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class PeriodoPregaoVo implements PeriodoPregao
{
		
	public long getIdObj()
    {
       return idPeriodoPregao;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdPeriodoPregao\" : \"" + idPeriodoPregao + "\" "
		+ ", \"HoraInicio\" : \"" + horaInicio + "\" "
		+ ", \"HoraTermino\" : \"" + horaTermino + "\" "
		+ ", \"DataInicioPeriodo\" : \"" + dataInicioPeriodo + "\" "
		+ ", \"DataTerminoPeriodo\" : \"" + dataTerminoPeriodo + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private PeriodoPregaoDerivada derivada = null;
	private PeriodoPregaoDerivada getDerivada() {
		if (derivada==null) {
			derivada = new PeriodoPregaoDerivada(this);
		}
		return derivada;
	}

	private PeriodoPregaoAgregado agregado = null;
	private PeriodoPregaoAgregado getAgregado() {
		if (agregado==null) {
			agregado = new PeriodoPregaoAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idPeriodoPregao;
	public long getIdPeriodoPregao()
	{
		return idPeriodoPregao;
	}
	public  void setIdPeriodoPregao(long value)
	{
		idPeriodoPregao = value; 
	}
	
	
	
	
	
	private String horaInicio;
	public String getHoraInicio()
	{
		return horaInicio;
	}
	public  void setHoraInicio(String value)
	{
		horaInicio = value; 
	}
	
	
	
	
	
	private String horaTermino;
	public String getHoraTermino()
	{
		return horaTermino;
	}
	public  void setHoraTermino(String value)
	{
		horaTermino = value; 
	}
	
	
	
	
	
	private String dataInicioPeriodo;
	public String getDataInicioPeriodo()
	{
		return dataInicioPeriodo;
	}
	public  void setDataInicioPeriodo(String value)
	{
		dataInicioPeriodo = value; 
	}
	
	
	
	
	
	private String dataTerminoPeriodo;
	public String getDataTerminoPeriodo()
	{
		return dataTerminoPeriodo;
	}
	public  void setDataTerminoPeriodo(String value)
	{
		dataTerminoPeriodo = value; 
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
