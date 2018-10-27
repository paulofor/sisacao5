package coletorjava.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;
import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class TickerVo implements Ticker
{
		
	public long getIdObj()
    {
       return idTicker;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdTicker\" : \"" + idTicker + "\" "
		+ ", \"Nome\" : \"" + nome + "\" "
		+ ", \"Empresa\" : \"" + empresa + "\" "
		+ ", \"TipoAcao\" : \"" + tipoAcao + "\" "
		+ ", \"DataInicioDiario\" : \"" + dataInicioDiario + "\" "
		+ ", \"DataMaisRecenteDiario\" : \"" + dataMaisRecenteDiario + "\" "
		+ ", \"DataInicioColetaOpcao\" : \"" + dataInicioColetaOpcao + "\" "
		+ ", \"DataFinalColetaOpcao\" : \"" + dataFinalColetaOpcao + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private TickerDerivada derivada = null;
	private TickerDerivada getDerivada() {
		if (derivada==null) {
			derivada = new TickerDerivada(this);
		}
		return derivada;
	}

	private TickerAgregado agregado = null;
	private TickerAgregado getAgregado() {
		if (agregado==null) {
			agregado = new TickerAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	
	// Montador Alternativo
	public boolean existeListaOpcaoSisacaoGeral_Possui() {
		return getAgregado().existeListaOpcaoSisacaoGeral_Possui();
	}
	public void criaVaziaListaOpcaoSisacaoGeral_Possui() {
		getAgregado().criaVaziaListaOpcaoSisacaoGeral_Possui();
	}
	public List<OpcaoSisacaoGeral> getListaOpcaoSisacaoGeral_Possui() 
	{
		return getAgregado().getListaOpcaoSisacaoGeral_Possui(); 
	} 
	public void setListaOpcaoSisacaoGeral_Possui(List<OpcaoSisacaoGeral> value) 
	{
		getAgregado().setListaOpcaoSisacaoGeral_Possui(value); 
	} 
	public void addListaOpcaoSisacaoGeral_Possui(OpcaoSisacaoGeral value) 
	{
		getAgregado().addListaOpcaoSisacaoGeral_Possui(value); 
	} 
	public OpcaoSisacaoGeral getCorrenteOpcaoSisacaoGeral_Possui()
	{
		return getAgregado().getCorrenteOpcaoSisacaoGeral_Possui(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaOpcaoSisacao_Gera() {
		return getAgregado().existeListaOpcaoSisacao_Gera();
	}
	public void criaVaziaListaOpcaoSisacao_Gera() {
		getAgregado().criaVaziaListaOpcaoSisacao_Gera();
	}
	public List<OpcaoSisacao> getListaOpcaoSisacao_Gera() 
	{
		return getAgregado().getListaOpcaoSisacao_Gera(); 
	} 
	public void setListaOpcaoSisacao_Gera(List<OpcaoSisacao> value) 
	{
		getAgregado().setListaOpcaoSisacao_Gera(value); 
	} 
	public void addListaOpcaoSisacao_Gera(OpcaoSisacao value) 
	{
		getAgregado().addListaOpcaoSisacao_Gera(value); 
	} 
	public OpcaoSisacao getCorrenteOpcaoSisacao_Gera()
	{
		return getAgregado().getCorrenteOpcaoSisacao_Gera(); 
	} 
	
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
	public boolean existeListaProjetoDadoTreino_Gera() {
		return getAgregado().existeListaProjetoDadoTreino_Gera();
	}
	public void criaVaziaListaProjetoDadoTreino_Gera() {
		getAgregado().criaVaziaListaProjetoDadoTreino_Gera();
	}
	public List<ProjetoDadoTreino> getListaProjetoDadoTreino_Gera() 
	{
		return getAgregado().getListaProjetoDadoTreino_Gera(); 
	} 
	public void setListaProjetoDadoTreino_Gera(List<ProjetoDadoTreino> value) 
	{
		getAgregado().setListaProjetoDadoTreino_Gera(value); 
	} 
	public void addListaProjetoDadoTreino_Gera(ProjetoDadoTreino value) 
	{
		getAgregado().addListaProjetoDadoTreino_Gera(value); 
	} 
	public ProjetoDadoTreino getCorrenteProjetoDadoTreino_Gera()
	{
		return getAgregado().getCorrenteProjetoDadoTreino_Gera(); 
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
	

	
	
	
	
	
	private long idTicker;
	public long getIdTicker()
	{
		return idTicker;
	}
	public  void setIdTicker(long value)
	{
		idTicker = value; 
	}
	
	
	
	
	
	private String nome;
	public String getNome()
	{
		return nome;
	}
	public  void setNome(String value)
	{
		nome = value; 
	}
	
	
	
	
	
	private String empresa;
	public String getEmpresa()
	{
		return empresa;
	}
	public  void setEmpresa(String value)
	{
		empresa = value; 
	}
	
	
	
	
	
	private String tipoAcao;
	public String getTipoAcao()
	{
		return tipoAcao;
	}
	public  void setTipoAcao(String value)
	{
		tipoAcao = value; 
	}
	
	
	
	
	
	private String dataInicioDiario;
	public String getDataInicioDiario()
	{
		return dataInicioDiario;
	}
	public  void setDataInicioDiario(String value)
	{
		dataInicioDiario = value; 
	}
	
	
	
	
	
	private String dataMaisRecenteDiario;
	public String getDataMaisRecenteDiario()
	{
		return dataMaisRecenteDiario;
	}
	public  void setDataMaisRecenteDiario(String value)
	{
		dataMaisRecenteDiario = value; 
	}
	
	
	
	
	
	private String dataInicioColetaOpcao;
	public String getDataInicioColetaOpcao()
	{
		return dataInicioColetaOpcao;
	}
	public  void setDataInicioColetaOpcao(String value)
	{
		dataInicioColetaOpcao = value; 
	}
	
	
	
	
	
	private String dataFinalColetaOpcao;
	public String getDataFinalColetaOpcao()
	{
		return dataFinalColetaOpcao;
	}
	public  void setDataFinalColetaOpcao(String value)
	{
		dataFinalColetaOpcao = value; 
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
