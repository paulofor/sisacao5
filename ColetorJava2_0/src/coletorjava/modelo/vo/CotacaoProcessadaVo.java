package coletorjava.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;
import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class CotacaoProcessadaVo implements CotacaoProcessada
{
		
	public long getIdObj()
    {
       return idCotacaoProcessada;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdCotacaoProcessada\" : \"" + idCotacaoProcessada + "\" "
		+ ", \"HoraCotacaoTempoReal\" : \"" + horaCotacaoTempoReal + "\" "
		+ ", \"ValorTempoReal\" : \"" + valorTempoReal + "\" "
		+ ", \"ValorCorrigido\" : \"" + valorCorrigido + "\" "
		+ ", \"ContadorDia\" : \"" + contadorDia + "\" "
		+ ", \"Data\" : \"" + data + "\" "
		+ ", \"HoraSerieTemporal\" : \"" + horaSerieTemporal + "\" "
		+ ", \"HoraCotacao\" : \"" + horaCotacao + "\" "
		+ ", \"Negocios\" : \"" + negocios + "\" "
		+ ", \"Valor\" : \"" + valor + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private CotacaoProcessadaDerivada derivada = null;
	private CotacaoProcessadaDerivada getDerivada() {
		if (derivada==null) {
			derivada = new CotacaoProcessadaDerivada(this);
		}
		return derivada;
	}

	private CotacaoProcessadaAgregado agregado = null;
	private CotacaoProcessadaAgregado getAgregado() {
		if (agregado==null) {
			agregado = new CotacaoProcessadaAgregado(this);
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
	
	public String getLinhaTreino()
	{
		return getDerivada().getLinhaTreino(); 
	} 
	public void setLinhaTreino(String value)
	{
		getDerivada().setLinhaTreino(value); 
	} 
	
	public DCIObjetoDominio getAnterior()
	{
		return getDerivada().getAnterior(); 
	} 
	public void setAnterior(DCIObjetoDominio value)
	{
		getDerivada().setAnterior(value); 
	} 
	
	public DCIObjetoDominio getDiaPregao()
	{
		return getDerivada().getDiaPregao(); 
	} 
	public void setDiaPregao(DCIObjetoDominio value)
	{
		getDerivada().setDiaPregao(value); 
	} 
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idCotacaoProcessada;
	public long getIdCotacaoProcessada()
	{
		return idCotacaoProcessada;
	}
	public  void setIdCotacaoProcessada(long value)
	{
		idCotacaoProcessada = value; 
	}
	
	
	
	
	
	private String horaCotacaoTempoReal;
	public String getHoraCotacaoTempoReal()
	{
		return horaCotacaoTempoReal;
	}
	public  void setHoraCotacaoTempoReal(String value)
	{
		horaCotacaoTempoReal = value; 
	}
	
	
	
	public String getValorTempoRealFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valorTempoReal);
	}
	
	
	
	private float valorTempoReal;
	public float getValorTempoReal()
	{
		return valorTempoReal;
	}
	public  void setValorTempoReal(float value)
	{
		valorTempoReal = value; 
	}
	
	
	
	public String getValorCorrigidoFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valorCorrigido);
	}
	
	
	
	private float valorCorrigido;
	public float getValorCorrigido()
	{
		return valorCorrigido;
	}
	public  void setValorCorrigido(float value)
	{
		valorCorrigido = value; 
	}
	
	
	
	
	
	private long contadorDia;
	public long getContadorDia()
	{
		return contadorDia;
	}
	public  void setContadorDia(long value)
	{
		contadorDia = value; 
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
	
	
	
	
	
	private String horaSerieTemporal;
	public String getHoraSerieTemporal()
	{
		return horaSerieTemporal;
	}
	public  void setHoraSerieTemporal(String value)
	{
		horaSerieTemporal = value; 
	}
	
	
	
	
	
	private String horaCotacao;
	public String getHoraCotacao()
	{
		return horaCotacao;
	}
	public  void setHoraCotacao(String value)
	{
		horaCotacao = value; 
	}
	
	
	
	
	
	private long negocios;
	public long getNegocios()
	{
		return negocios;
	}
	public  void setNegocios(long value)
	{
		negocios = value; 
	}
	
	
	
	public String getValorFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valor);
	}
	
	
	
	private float valor;
	public float getValor()
	{
		return valor;
	}
	public  void setValor(float value)
	{
		valor = value; 
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
