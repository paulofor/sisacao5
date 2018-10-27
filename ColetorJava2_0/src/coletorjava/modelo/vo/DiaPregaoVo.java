package coletorjava.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;
import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class DiaPregaoVo implements DiaPregao
{
		
	public long getIdObj()
    {
       return idDiaPregao;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdDiaPregao\" : \"" + idDiaPregao + "\" "
		+ ", \"Data\" : \"" + data + "\" "
		+ ", \"Feriado\" : \"" + feriado + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private DiaPregaoDerivada derivada = null;
	private DiaPregaoDerivada getDerivada() {
		if (derivada==null) {
			derivada = new DiaPregaoDerivada(this);
		}
		return derivada;
	}

	private DiaPregaoAgregado agregado = null;
	private DiaPregaoAgregado getAgregado() {
		if (agregado==null) {
			agregado = new DiaPregaoAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	
	
	// Um pra um
	
	
	
	
	public DCIObjetoDominio getAnterior()
	{
		return getDerivada().getAnterior(); 
	} 
	public void setAnterior(DCIObjetoDominio value)
	{
		getDerivada().setAnterior(value); 
	} 
	
	public long getDataInteiro()
	{
		return getDerivada().getDataInteiro(); 
	} 
	public void setDataInteiro(long value)
	{
		getDerivada().setDataInteiro(value); 
	} 
	
	public DCIObjetoDominio getUltimaCotacaoProcessada()
	{
		return getDerivada().getUltimaCotacaoProcessada(); 
	} 
	public void setUltimaCotacaoProcessada(DCIObjetoDominio value)
	{
		getDerivada().setUltimaCotacaoProcessada(value); 
	} 
	
	public List getListaCotacaoProcessada()
	{
		return getDerivada().getListaCotacaoProcessada(); 
	} 
	public void setListaCotacaoProcessada(List value)
	{
		getDerivada().setListaCotacaoProcessada(value); 
	} 
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	
	// Montador Alternativo
	public boolean existeListaEscolhaOpcao_Possui() {
		return getAgregado().existeListaEscolhaOpcao_Possui();
	}
	public void criaVaziaListaEscolhaOpcao_Possui() {
		getAgregado().criaVaziaListaEscolhaOpcao_Possui();
	}
	public List<EscolhaOpcao> getListaEscolhaOpcao_Possui() 
	{
		return getAgregado().getListaEscolhaOpcao_Possui(); 
	} 
	public void setListaEscolhaOpcao_Possui(List<EscolhaOpcao> value) 
	{
		getAgregado().setListaEscolhaOpcao_Possui(value); 
	} 
	public void addListaEscolhaOpcao_Possui(EscolhaOpcao value) 
	{
		getAgregado().addListaEscolhaOpcao_Possui(value); 
	} 
	public EscolhaOpcao getCorrenteEscolhaOpcao_Possui()
	{
		return getAgregado().getCorrenteEscolhaOpcao_Possui(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaOpcaoReferencia_Possui() {
		return getAgregado().existeListaOpcaoReferencia_Possui();
	}
	public void criaVaziaListaOpcaoReferencia_Possui() {
		getAgregado().criaVaziaListaOpcaoReferencia_Possui();
	}
	public List<OpcaoReferencia> getListaOpcaoReferencia_Possui() 
	{
		return getAgregado().getListaOpcaoReferencia_Possui(); 
	} 
	public void setListaOpcaoReferencia_Possui(List<OpcaoReferencia> value) 
	{
		getAgregado().setListaOpcaoReferencia_Possui(value); 
	} 
	public void addListaOpcaoReferencia_Possui(OpcaoReferencia value) 
	{
		getAgregado().addListaOpcaoReferencia_Possui(value); 
	} 
	public OpcaoReferencia getCorrenteOpcaoReferencia_Possui()
	{
		return getAgregado().getCorrenteOpcaoReferencia_Possui(); 
	} 
	

	
	
	
	
	
	private long idDiaPregao;
	public long getIdDiaPregao()
	{
		return idDiaPregao;
	}
	public  void setIdDiaPregao(long value)
	{
		idDiaPregao = value; 
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
	
	
	
	
	
	private boolean feriado;
	public boolean getFeriado()
	{
		return feriado;
	}
	public  void setFeriado(boolean value)
	{
		feriado = value; 
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
