package coletorjava.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;
import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class ResultadoPrevisaoVo implements ResultadoPrevisao
{
		
	public long getIdObj()
    {
       return idResultadoPrevisao;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdResultadoPrevisao\" : \"" + idResultadoPrevisao + "\" "
		+ ", \"QtdeVerdadeiroPostivo\" : \"" + qtdeVerdadeiroPostivo + "\" "
		+ ", \"QtdeFalsoPositivo\" : \"" + qtdeFalsoPositivo + "\" "
		+ ", \"QtdeTotal\" : \"" + qtdeTotal + "\" "
		+ ", \"PercentualSucessoPrevisao\" : \"" + percentualSucessoPrevisao + "\" "
		+ ", \"PercentualPrecisao\" : \"" + percentualPrecisao + "\" "
		+ ", \"UltimaAlteracao\" : \"" + ultimaAlteracao + "\" "
		+ ", \"IdDadoThetaGd\" : \"" + idDadoThetaGd + "\" "
		+ ", \"IdResultadoMesMp\" : \"" + idResultadoMesMp + "\" "
		+ ", \"IdMesAnoRa\" : \"" + idMesAnoRa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private ResultadoPrevisaoDerivada derivada = null;
	private ResultadoPrevisaoDerivada getDerivada() {
		if (derivada==null) {
			derivada = new ResultadoPrevisaoDerivada(this);
		}
		return derivada;
	}

	private ResultadoPrevisaoAgregado agregado = null;
	private ResultadoPrevisaoAgregado getAgregado() {
		if (agregado==null) {
			agregado = new ResultadoPrevisaoAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public DadoTheta getDadoThetaGeradoDe(boolean lazyLoader)
	{
		return getAgregado().getDadoThetaGeradoDe(lazyLoader); 
	} 
	public void setDadoThetaGeradoDe(DadoTheta value) 
	{
		getAgregado().setDadoThetaGeradoDe(value); 
	} 
	/*
	public void setDadoThetaGeradoDeComReversao(DadoTheta value) 
	{
		getAgregado().setDadoThetaGeradoDeComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaDadoTheta_GeradoDe(DadoTheta value)
	{
		getAgregado().setDadoThetaGeradoDe(value); 
	} 
	public DadoTheta getCorrenteDadoTheta_GeradoDe()
	{
		return getAgregado().getDadoThetaGeradoDe(false); 
	} 
	
	
	// Montador Tradicional
	public ResultadoMes getResultadoMesMesmoPeriodo(boolean lazyLoader)
	{
		return getAgregado().getResultadoMesMesmoPeriodo(lazyLoader); 
	} 
	public void setResultadoMesMesmoPeriodo(ResultadoMes value) 
	{
		getAgregado().setResultadoMesMesmoPeriodo(value); 
	} 
	/*
	public void setResultadoMesMesmoPeriodoComReversao(ResultadoMes value) 
	{
		getAgregado().setResultadoMesMesmoPeriodoComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaResultadoMes_MesmoPeriodo(ResultadoMes value)
	{
		getAgregado().setResultadoMesMesmoPeriodo(value); 
	} 
	public ResultadoMes getCorrenteResultadoMes_MesmoPeriodo()
	{
		return getAgregado().getResultadoMesMesmoPeriodo(false); 
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
	

	
	
	
	
	
	private long idResultadoPrevisao;
	public long getIdResultadoPrevisao()
	{
		return idResultadoPrevisao;
	}
	public  void setIdResultadoPrevisao(long value)
	{
		idResultadoPrevisao = value; 
	}
	
	
	
	
	
	private long qtdeVerdadeiroPostivo;
	public long getQtdeVerdadeiroPostivo()
	{
		return qtdeVerdadeiroPostivo;
	}
	public  void setQtdeVerdadeiroPostivo(long value)
	{
		qtdeVerdadeiroPostivo = value; 
	}
	
	
	
	
	
	private long qtdeFalsoPositivo;
	public long getQtdeFalsoPositivo()
	{
		return qtdeFalsoPositivo;
	}
	public  void setQtdeFalsoPositivo(long value)
	{
		qtdeFalsoPositivo = value; 
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
	
	
	
	
	
	private long percentualSucessoPrevisao;
	public long getPercentualSucessoPrevisao()
	{
		return percentualSucessoPrevisao;
	}
	public  void setPercentualSucessoPrevisao(long value)
	{
		percentualSucessoPrevisao = value; 
	}
	
	
	
	
	
	private float percentualPrecisao;
	public float getPercentualPrecisao()
	{
		return percentualPrecisao;
	}
	public  void setPercentualPrecisao(float value)
	{
		percentualPrecisao = value; 
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
	
	
	
	
		
	private long idDadoThetaGd;
	public long getIdDadoThetaGd() {
		// relacionamento
		if (idDadoThetaGd==0 && this.getDadoThetaGeradoDe(false)!=null) 
			return getDadoThetaGeradoDe(false).getIdObj();
		else
			return idDadoThetaGd;
	}
	public void setIdDadoThetaGd(long _valor) {
		idDadoThetaGd = _valor;
	}
	
	
	
	
		
	private long idResultadoMesMp;
	public long getIdResultadoMesMp() {
		// relacionamento
		if (idResultadoMesMp==0 && this.getResultadoMesMesmoPeriodo(false)!=null) 
			return getResultadoMesMesmoPeriodo(false).getIdObj();
		else
			return idResultadoMesMp;
	}
	public void setIdResultadoMesMp(long _valor) {
		idResultadoMesMp = _valor;
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
