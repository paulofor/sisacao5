package coletorjava.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;
import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class RegraEntradaVo implements RegraEntrada
{
		
	public long getIdObj()
    {
       return idRegraEntrada;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdRegraEntrada\" : \"" + idRegraEntrada + "\" "
		+ ", \"NomeRegra\" : \"" + nomeRegra + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private RegraEntradaDerivada derivada = null;
	private RegraEntradaDerivada getDerivada() {
		if (derivada==null) {
			derivada = new RegraEntradaDerivada(this);
		}
		return derivada;
	}

	private RegraEntradaAgregado agregado = null;
	private RegraEntradaAgregado getAgregado() {
		if (agregado==null) {
			agregado = new RegraEntradaAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idRegraEntrada;
	public long getIdRegraEntrada()
	{
		return idRegraEntrada;
	}
	public  void setIdRegraEntrada(long value)
	{
		idRegraEntrada = value; 
	}
	
	
	
	
	
	private String nomeRegra;
	public String getNomeRegra()
	{
		return nomeRegra;
	}
	public  void setNomeRegra(String value)
	{
		nomeRegra = value; 
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
