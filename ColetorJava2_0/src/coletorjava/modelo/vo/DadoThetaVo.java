package coletorjava.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;
import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class DadoThetaVo implements DadoTheta
{
		
	public long getIdObj()
    {
       return idDadoTheta;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdDadoTheta\" : \"" + idDadoTheta + "\" "
		+ ", \"NomeArquivo\" : \"" + nomeArquivo + "\" "
		+ ", \"UltimaAlteracao\" : \"" + ultimaAlteracao + "\" "
		+ ", \"IdTreinoRedeGp\" : \"" + idTreinoRedeGp + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private DadoThetaDerivada derivada = null;
	private DadoThetaDerivada getDerivada() {
		if (derivada==null) {
			derivada = new DadoThetaDerivada(this);
		}
		return derivada;
	}

	private DadoThetaAgregado agregado = null;
	private DadoThetaAgregado getAgregado() {
		if (agregado==null) {
			agregado = new DadoThetaAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public TreinoRede getTreinoRedeGeradoPor(boolean lazyLoader)
	{
		return getAgregado().getTreinoRedeGeradoPor(lazyLoader); 
	} 
	public void setTreinoRedeGeradoPor(TreinoRede value) 
	{
		getAgregado().setTreinoRedeGeradoPor(value); 
	} 
	/*
	public void setTreinoRedeGeradoPorComReversao(TreinoRede value) 
	{
		getAgregado().setTreinoRedeGeradoPorComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaTreinoRede_GeradoPor(TreinoRede value)
	{
		getAgregado().setTreinoRedeGeradoPor(value); 
	} 
	public TreinoRede getCorrenteTreinoRede_GeradoPor()
	{
		return getAgregado().getTreinoRedeGeradoPor(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	
	// Montador Alternativo
	public boolean existeListaResultadoPrevisao_Gera() {
		return getAgregado().existeListaResultadoPrevisao_Gera();
	}
	public void criaVaziaListaResultadoPrevisao_Gera() {
		getAgregado().criaVaziaListaResultadoPrevisao_Gera();
	}
	public List<ResultadoPrevisao> getListaResultadoPrevisao_Gera() 
	{
		return getAgregado().getListaResultadoPrevisao_Gera(); 
	} 
	public void setListaResultadoPrevisao_Gera(List<ResultadoPrevisao> value) 
	{
		getAgregado().setListaResultadoPrevisao_Gera(value); 
	} 
	public void addListaResultadoPrevisao_Gera(ResultadoPrevisao value) 
	{
		getAgregado().addListaResultadoPrevisao_Gera(value); 
	} 
	public ResultadoPrevisao getCorrenteResultadoPrevisao_Gera()
	{
		return getAgregado().getCorrenteResultadoPrevisao_Gera(); 
	} 
	

	
	
	
	
	
	private long idDadoTheta;
	public long getIdDadoTheta()
	{
		return idDadoTheta;
	}
	public  void setIdDadoTheta(long value)
	{
		idDadoTheta = value; 
	}
	
	
	
	
	
	private String nomeArquivo;
	public String getNomeArquivo()
	{
		return nomeArquivo;
	}
	public  void setNomeArquivo(String value)
	{
		nomeArquivo = value; 
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
	
	
	
	
		
	private long idTreinoRedeGp;
	public long getIdTreinoRedeGp() {
		// relacionamento
		if (idTreinoRedeGp==0 && this.getTreinoRedeGeradoPor(false)!=null) 
			return getTreinoRedeGeradoPor(false).getIdObj();
		else
			return idTreinoRedeGp;
	}
	public void setIdTreinoRedeGp(long _valor) {
		idTreinoRedeGp = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
