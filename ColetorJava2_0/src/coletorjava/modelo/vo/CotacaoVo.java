package coletorjava.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;
import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class CotacaoVo implements Cotacao
{
		
	public long getIdObj()
    {
       return id;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"Id\" : \"" + id + "\" "
		+ ", \"Neg\" : \"" + neg + "\" "
		+ ", \"Data\" : \"" + data + "\" "
		+ ", \"Ult\" : \"" + ult + "\" "
		+ ", \"HoraReal\" : \"" + horaReal + "\" "
		+ ", \"HoraNeg\" : \"" + horaNeg + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private CotacaoDerivada derivada = null;
	private CotacaoDerivada getDerivada() {
		if (derivada==null) {
			derivada = new CotacaoDerivada(this);
		}
		return derivada;
	}

	private CotacaoAgregado agregado = null;
	private CotacaoAgregado getAgregado() {
		if (agregado==null) {
			agregado = new CotacaoAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	
	
	// Um pra um
	
	
	
	
	public String getLinhaLog()
	{
		return getDerivada().getLinhaLog(); 
	} 
	public void setLinhaLog(String value)
	{
		getDerivada().setLinhaLog(value); 
	} 
	
	public String getNomeTicker()
	{
		return getDerivada().getNomeTicker(); 
	} 
	public void setNomeTicker(String value)
	{
		getDerivada().setNomeTicker(value); 
	} 
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long id;
	public long getId()
	{
		return id;
	}
	public  void setId(long value)
	{
		id = value; 
	}
	
	
	
	
	
	private long neg;
	public long getNeg()
	{
		return neg;
	}
	public  void setNeg(long value)
	{
		neg = value; 
	}
	
	
	
	
	
	private String data;
	public String getData()
	{
		return data;
	}
	public  void setData(String value)
	{
		data = value; 
	}
	
	
	
	public String getUltFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(ult);
	}
	
	
	
	private float ult;
	public float getUlt()
	{
		return ult;
	}
	public  void setUlt(float value)
	{
		ult = value; 
	}
	
	
	
	
	
	private String horaReal;
	public String getHoraReal()
	{
		return horaReal;
	}
	public  void setHoraReal(String value)
	{
		horaReal = value; 
	}
	
	
	
	
	
	private String horaNeg;
	public String getHoraNeg()
	{
		return horaNeg;
	}
	public  void setHoraNeg(String value)
	{
		horaNeg = value; 
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
