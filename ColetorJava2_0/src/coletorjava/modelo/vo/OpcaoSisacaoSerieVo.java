package coletorjava.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;
import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class OpcaoSisacaoSerieVo implements OpcaoSisacaoSerie
{
		
	public long getIdObj()
    {
       return idOpcaoSisacaoSerie;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdOpcaoSisacaoSerie\" : \"" + idOpcaoSisacaoSerie + "\" "
		+ ", \"MesAno\" : \"" + mesAno + "\" "
		+ ", \"Letra\" : \"" + letra + "\" "
		+ ", \"DataVencimento\" : \"" + dataVencimento + "\" "
		+ ", \"DataInicioColeta\" : \"" + dataInicioColeta + "\" "
		+ ", \"Construida\" : \"" + construida + "\" "
		+ ", \"PossuiIntraday\" : \"" + possuiIntraday + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private OpcaoSisacaoSerieDerivada derivada = null;
	private OpcaoSisacaoSerieDerivada getDerivada() {
		if (derivada==null) {
			derivada = new OpcaoSisacaoSerieDerivada(this);
		}
		return derivada;
	}

	private OpcaoSisacaoSerieAgregado agregado = null;
	private OpcaoSisacaoSerieAgregado getAgregado() {
		if (agregado==null) {
			agregado = new OpcaoSisacaoSerieAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	
	
	// Um pra um
	
	
	
	
	public long getQuantidadeOpcao()
	{
		return getDerivada().getQuantidadeOpcao(); 
	} 
	public void setQuantidadeOpcao(long value)
	{
		getDerivada().setQuantidadeOpcao(value); 
	} 
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	
	// Montador Alternativo
	public boolean existeListaOpcaoSisacao_Possui() {
		return getAgregado().existeListaOpcaoSisacao_Possui();
	}
	public void criaVaziaListaOpcaoSisacao_Possui() {
		getAgregado().criaVaziaListaOpcaoSisacao_Possui();
	}
	public List<OpcaoSisacao> getListaOpcaoSisacao_Possui() 
	{
		return getAgregado().getListaOpcaoSisacao_Possui(); 
	} 
	public void setListaOpcaoSisacao_Possui(List<OpcaoSisacao> value) 
	{
		getAgregado().setListaOpcaoSisacao_Possui(value); 
	} 
	public void addListaOpcaoSisacao_Possui(OpcaoSisacao value) 
	{
		getAgregado().addListaOpcaoSisacao_Possui(value); 
	} 
	public OpcaoSisacao getCorrenteOpcaoSisacao_Possui()
	{
		return getAgregado().getCorrenteOpcaoSisacao_Possui(); 
	} 
	

	
	
	
	
	
	private long idOpcaoSisacaoSerie;
	public long getIdOpcaoSisacaoSerie()
	{
		return idOpcaoSisacaoSerie;
	}
	public  void setIdOpcaoSisacaoSerie(long value)
	{
		idOpcaoSisacaoSerie = value; 
	}
	
	
	
	
	
	private String mesAno;
	public String getMesAno()
	{
		return mesAno;
	}
	public  void setMesAno(String value)
	{
		mesAno = value; 
	}
	
	
	
	
	
	private String letra;
	public String getLetra()
	{
		return letra;
	}
	public  void setLetra(String value)
	{
		letra = value; 
	}
	
	
	
	
	
	private String dataVencimento;
	public String getDataVencimento()
	{
		return dataVencimento;
	}
	public  void setDataVencimento(String value)
	{
		dataVencimento = value; 
	}
	
	
	
	
	
	private String dataInicioColeta;
	public String getDataInicioColeta()
	{
		return dataInicioColeta;
	}
	public  void setDataInicioColeta(String value)
	{
		dataInicioColeta = value; 
	}
	
	
	
	
	
	private boolean construida;
	public boolean getConstruida()
	{
		return construida;
	}
	public  void setConstruida(boolean value)
	{
		construida = value; 
	}
	
	
	
	
	
	private boolean possuiIntraday;
	public boolean getPossuiIntraday()
	{
		return possuiIntraday;
	}
	public  void setPossuiIntraday(boolean value)
	{
		possuiIntraday = value; 
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
