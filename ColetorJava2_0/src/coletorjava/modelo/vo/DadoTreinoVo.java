package coletorjava.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;
import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class DadoTreinoVo implements DadoTreino
{
		
	public long getIdObj()
    {
       return idDadoTreino;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdDadoTreino\" : \"" + idDadoTreino + "\" "
		+ ", \"NomeArquivoX\" : \"" + nomeArquivoX + "\" "
		+ ", \"DiasEntradaDiario\" : \"" + diasEntradaDiario + "\" "
		+ ", \"DiasEntradaIntraday\" : \"" + diasEntradaIntraday + "\" "
		+ ", \"TipoPeriodo\" : \"" + tipoPeriodo + "\" "
		+ ", \"QtdeNeuronioEntrada\" : \"" + qtdeNeuronioEntrada + "\" "
		+ ", \"CodigoFaixa\" : \"" + codigoFaixa + "\" "
		+ ", \"UltimaAlteracao\" : \"" + ultimaAlteracao + "\" "
		+ ", \"QtdeTickIntraday\" : \"" + qtdeTickIntraday + "\" "
		+ ", \"NomeArquivoY\" : \"" + nomeArquivoY + "\" "
		+ ", \"Ano\" : \"" + ano + "\" "
		+ ", \"ContadorPorAno\" : \"" + contadorPorAno + "\" "
		+ ", \"MinutosIntraday\" : \"" + minutosIntraday + "\" "
		+ ", \"IdProjetoDadoTreinoP\" : \"" + idProjetoDadoTreinoP + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private DadoTreinoDerivada derivada = null;
	private DadoTreinoDerivada getDerivada() {
		if (derivada==null) {
			derivada = new DadoTreinoDerivada(this);
		}
		return derivada;
	}

	private DadoTreinoAgregado agregado = null;
	private DadoTreinoAgregado getAgregado() {
		if (agregado==null) {
			agregado = new DadoTreinoAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public ProjetoDadoTreino getProjetoDadoTreinoPossui(boolean lazyLoader)
	{
		return getAgregado().getProjetoDadoTreinoPossui(lazyLoader); 
	} 
	public void setProjetoDadoTreinoPossui(ProjetoDadoTreino value) 
	{
		getAgregado().setProjetoDadoTreinoPossui(value); 
	} 
	/*
	public void setProjetoDadoTreinoPossuiComReversao(ProjetoDadoTreino value) 
	{
		getAgregado().setProjetoDadoTreinoPossuiComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaProjetoDadoTreino_Possui(ProjetoDadoTreino value)
	{
		getAgregado().setProjetoDadoTreinoPossui(value); 
	} 
	public ProjetoDadoTreino getCorrenteProjetoDadoTreino_Possui()
	{
		return getAgregado().getProjetoDadoTreinoPossui(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	
	// Montador Alternativo
	public boolean existeListaTreinoRede_Gerou() {
		return getAgregado().existeListaTreinoRede_Gerou();
	}
	public void criaVaziaListaTreinoRede_Gerou() {
		getAgregado().criaVaziaListaTreinoRede_Gerou();
	}
	public List<TreinoRede> getListaTreinoRede_Gerou() 
	{
		return getAgregado().getListaTreinoRede_Gerou(); 
	} 
	public void setListaTreinoRede_Gerou(List<TreinoRede> value) 
	{
		getAgregado().setListaTreinoRede_Gerou(value); 
	} 
	public void addListaTreinoRede_Gerou(TreinoRede value) 
	{
		getAgregado().addListaTreinoRede_Gerou(value); 
	} 
	public TreinoRede getCorrenteTreinoRede_Gerou()
	{
		return getAgregado().getCorrenteTreinoRede_Gerou(); 
	} 
	

	
	
	
	
	
	private long idDadoTreino;
	public long getIdDadoTreino()
	{
		return idDadoTreino;
	}
	public  void setIdDadoTreino(long value)
	{
		idDadoTreino = value; 
	}
	
	
	
	
	
	private String nomeArquivoX;
	public String getNomeArquivoX()
	{
		return nomeArquivoX;
	}
	public  void setNomeArquivoX(String value)
	{
		nomeArquivoX = value; 
	}
	
	
	
	
	
	private long diasEntradaDiario;
	public long getDiasEntradaDiario()
	{
		return diasEntradaDiario;
	}
	public  void setDiasEntradaDiario(long value)
	{
		diasEntradaDiario = value; 
	}
	
	
	
	
	
	private long diasEntradaIntraday;
	public long getDiasEntradaIntraday()
	{
		return diasEntradaIntraday;
	}
	public  void setDiasEntradaIntraday(long value)
	{
		diasEntradaIntraday = value; 
	}
	
	
	
	
	
	private String tipoPeriodo;
	public String getTipoPeriodo()
	{
		return tipoPeriodo;
	}
	public  void setTipoPeriodo(String value)
	{
		tipoPeriodo = value; 
	}
	
	
	
	
	
	private long qtdeNeuronioEntrada;
	public long getQtdeNeuronioEntrada()
	{
		return qtdeNeuronioEntrada;
	}
	public  void setQtdeNeuronioEntrada(long value)
	{
		qtdeNeuronioEntrada = value; 
	}
	
	
	
	
	
	private long codigoFaixa;
	public long getCodigoFaixa()
	{
		return codigoFaixa;
	}
	public  void setCodigoFaixa(long value)
	{
		codigoFaixa = value; 
	}
	
	
	
	
	
	private String ultimaAlteracao;
	public String getUltimaAlteracao()
	{
		return ultimaAlteracao;
	}
	public  void setUltimaAlteracao(String value)
	{
		ultimaAlteracao = value; 
	}
	
	
	
	
	
	private long qtdeTickIntraday;
	public long getQtdeTickIntraday()
	{
		return qtdeTickIntraday;
	}
	public  void setQtdeTickIntraday(long value)
	{
		qtdeTickIntraday = value; 
	}
	
	
	
	
	
	private String nomeArquivoY;
	public String getNomeArquivoY()
	{
		return nomeArquivoY;
	}
	public  void setNomeArquivoY(String value)
	{
		nomeArquivoY = value; 
	}
	
	
	
	
	
	private long ano;
	public long getAno()
	{
		return ano;
	}
	public  void setAno(long value)
	{
		ano = value; 
	}
	
	
	
	
	
	private long contadorPorAno;
	public long getContadorPorAno()
	{
		return contadorPorAno;
	}
	public  void setContadorPorAno(long value)
	{
		contadorPorAno = value; 
	}
	
	
	
	
	
	private long minutosIntraday;
	public long getMinutosIntraday()
	{
		return minutosIntraday;
	}
	public  void setMinutosIntraday(long value)
	{
		minutosIntraday = value; 
	}
	
	
	
	
		
	private long idProjetoDadoTreinoP;
	public long getIdProjetoDadoTreinoP() {
		// relacionamento
		if (idProjetoDadoTreinoP==0 && this.getProjetoDadoTreinoPossui(false)!=null) 
			return getProjetoDadoTreinoPossui(false).getIdObj();
		else
			return idProjetoDadoTreinoP;
	}
	public void setIdProjetoDadoTreinoP(long _valor) {
		idProjetoDadoTreinoP = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
