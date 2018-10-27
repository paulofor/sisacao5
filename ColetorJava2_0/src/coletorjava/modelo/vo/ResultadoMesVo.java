package coletorjava.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;
import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class ResultadoMesVo implements ResultadoMes
{
		
	public long getIdObj()
    {
       return idResultadoMes;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdResultadoMes\" : \"" + idResultadoMes + "\" "
		+ ", \"QtdeTotal\" : \"" + qtdeTotal + "\" "
		+ ", \"QtdeSucesso\" : \"" + qtdeSucesso + "\" "
		+ ", \"QtdeFracasso\" : \"" + qtdeFracasso + "\" "
		+ ", \"QtdeNeutro\" : \"" + qtdeNeutro + "\" "
		+ ", \"PercentualSucesso\" : \"" + percentualSucesso + "\" "
		+ ", \"UltimaAlteracao\" : \"" + ultimaAlteracao + "\" "
		+ ", \"IdProjetoDadoTreinoGp\" : \"" + idProjetoDadoTreinoGp + "\" "
		+ ", \"IdMesAnoRa\" : \"" + idMesAnoRa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private ResultadoMesDerivada derivada = null;
	private ResultadoMesDerivada getDerivada() {
		if (derivada==null) {
			derivada = new ResultadoMesDerivada(this);
		}
		return derivada;
	}

	private ResultadoMesAgregado agregado = null;
	private ResultadoMesAgregado getAgregado() {
		if (agregado==null) {
			agregado = new ResultadoMesAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public ProjetoDadoTreino getProjetoDadoTreinoGeradoPor(boolean lazyLoader)
	{
		return getAgregado().getProjetoDadoTreinoGeradoPor(lazyLoader); 
	} 
	public void setProjetoDadoTreinoGeradoPor(ProjetoDadoTreino value) 
	{
		getAgregado().setProjetoDadoTreinoGeradoPor(value); 
	} 
	/*
	public void setProjetoDadoTreinoGeradoPorComReversao(ProjetoDadoTreino value) 
	{
		getAgregado().setProjetoDadoTreinoGeradoPorComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaProjetoDadoTreino_GeradoPor(ProjetoDadoTreino value)
	{
		getAgregado().setProjetoDadoTreinoGeradoPor(value); 
	} 
	public ProjetoDadoTreino getCorrenteProjetoDadoTreino_GeradoPor()
	{
		return getAgregado().getProjetoDadoTreinoGeradoPor(false); 
	} 
	
	
	// Montador Tradicional
	public MesAno getMesAnoReferenteA(boolean lazyLoader)
	{
		return getAgregado().getMesAnoReferenteA(lazyLoader); 
	} 
	public void setMesAnoReferenteA(MesAno value) 
	{
		getAgregado().setMesAnoReferenteA(value); 
	} 
	/*
	public void setMesAnoReferenteAComReversao(MesAno value) 
	{
		getAgregado().setMesAnoReferenteAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaMesAno_ReferenteA(MesAno value)
	{
		getAgregado().setMesAnoReferenteA(value); 
	} 
	public MesAno getCorrenteMesAno_ReferenteA()
	{
		return getAgregado().getMesAnoReferenteA(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	
	// Montador Alternativo
	public boolean existeListaResultadoPrevisao_Semelhante() {
		return getAgregado().existeListaResultadoPrevisao_Semelhante();
	}
	public void criaVaziaListaResultadoPrevisao_Semelhante() {
		getAgregado().criaVaziaListaResultadoPrevisao_Semelhante();
	}
	public List<ResultadoPrevisao> getListaResultadoPrevisao_Semelhante() 
	{
		return getAgregado().getListaResultadoPrevisao_Semelhante(); 
	} 
	public void setListaResultadoPrevisao_Semelhante(List<ResultadoPrevisao> value) 
	{
		getAgregado().setListaResultadoPrevisao_Semelhante(value); 
	} 
	public void addListaResultadoPrevisao_Semelhante(ResultadoPrevisao value) 
	{
		getAgregado().addListaResultadoPrevisao_Semelhante(value); 
	} 
	public ResultadoPrevisao getCorrenteResultadoPrevisao_Semelhante()
	{
		return getAgregado().getCorrenteResultadoPrevisao_Semelhante(); 
	} 
	

	
	
	
	
	
	private long idResultadoMes;
	public long getIdResultadoMes()
	{
		return idResultadoMes;
	}
	public  void setIdResultadoMes(long value)
	{
		idResultadoMes = value; 
	}
	
	
	
	
	
	private long qtdeTotal;
	public long getQtdeTotal()
	{
		return qtdeTotal;
	}
	public  void setQtdeTotal(long value)
	{
		qtdeTotal = value; 
	}
	
	
	
	
	
	private long qtdeSucesso;
	public long getQtdeSucesso()
	{
		return qtdeSucesso;
	}
	public  void setQtdeSucesso(long value)
	{
		qtdeSucesso = value; 
	}
	
	
	
	
	
	private long qtdeFracasso;
	public long getQtdeFracasso()
	{
		return qtdeFracasso;
	}
	public  void setQtdeFracasso(long value)
	{
		qtdeFracasso = value; 
	}
	
	
	
	
	
	private long qtdeNeutro;
	public long getQtdeNeutro()
	{
		return qtdeNeutro;
	}
	public  void setQtdeNeutro(long value)
	{
		qtdeNeutro = value; 
	}
	
	
	
	
	
	private float percentualSucesso;
	public float getPercentualSucesso()
	{
		return percentualSucesso;
	}
	public  void setPercentualSucesso(float value)
	{
		percentualSucesso = value; 
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
	
	
	
	
		
	private long idProjetoDadoTreinoGp;
	public long getIdProjetoDadoTreinoGp() {
		// relacionamento
		if (idProjetoDadoTreinoGp==0 && this.getProjetoDadoTreinoGeradoPor(false)!=null) 
			return getProjetoDadoTreinoGeradoPor(false).getIdObj();
		else
			return idProjetoDadoTreinoGp;
	}
	public void setIdProjetoDadoTreinoGp(long _valor) {
		idProjetoDadoTreinoGp = _valor;
	}
	
	
	
	
		
	private long idMesAnoRa;
	public long getIdMesAnoRa() {
		// relacionamento
		if (idMesAnoRa==0 && this.getMesAnoReferenteA(false)!=null) 
			return getMesAnoReferenteA(false).getIdObj();
		else
			return idMesAnoRa;
	}
	public void setIdMesAnoRa(long _valor) {
		idMesAnoRa = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
