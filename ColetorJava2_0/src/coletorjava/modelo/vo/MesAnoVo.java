package coletorjava.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;
import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class MesAnoVo implements MesAno
{
		
	public long getIdObj()
    {
       return idMesAno;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdMesAno\" : \"" + idMesAno + "\" "
		+ ", \"NomeMes\" : \"" + nomeMes + "\" "
		+ ", \"NumeroAno\" : \"" + numeroAno + "\" "
		+ ", \"MesAnoData\" : \"" + mesAnoData + "\" "
		+ ", \"NumeroMes\" : \"" + numeroMes + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private MesAnoDerivada derivada = null;
	private MesAnoDerivada getDerivada() {
		if (derivada==null) {
			derivada = new MesAnoDerivada(this);
		}
		return derivada;
	}

	private MesAnoAgregado agregado = null;
	private MesAnoAgregado getAgregado() {
		if (agregado==null) {
			agregado = new MesAnoAgregado(this);
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
	
	// Montador Alternativo
	public boolean existeListaResultadoMes_BasePara() {
		return getAgregado().existeListaResultadoMes_BasePara();
	}
	public void criaVaziaListaResultadoMes_BasePara() {
		getAgregado().criaVaziaListaResultadoMes_BasePara();
	}
	public List<ResultadoMes> getListaResultadoMes_BasePara() 
	{
		return getAgregado().getListaResultadoMes_BasePara(); 
	} 
	public void setListaResultadoMes_BasePara(List<ResultadoMes> value) 
	{
		getAgregado().setListaResultadoMes_BasePara(value); 
	} 
	public void addListaResultadoMes_BasePara(ResultadoMes value) 
	{
		getAgregado().addListaResultadoMes_BasePara(value); 
	} 
	public ResultadoMes getCorrenteResultadoMes_BasePara()
	{
		return getAgregado().getCorrenteResultadoMes_BasePara(); 
	} 
	

	
	
	
	
	
	private long idMesAno;
	public long getIdMesAno()
	{
		return idMesAno;
	}
	public  void setIdMesAno(long value)
	{
		idMesAno = value; 
	}
	
	
	
	
	
	private String nomeMes;
	public String getNomeMes()
	{
		return nomeMes;
	}
	public  void setNomeMes(String value)
	{
		nomeMes = value; 
	}
	
	
	
	
	
	private long numeroAno;
	public long getNumeroAno()
	{
		return numeroAno;
	}
	public  void setNumeroAno(long value)
	{
		numeroAno = value; 
	}
	
	
	
	
	
	private String mesAnoData;
	public String getMesAnoData()
	{
		return mesAnoData;
	}
	public  void setMesAnoData(String value)
	{
		mesAnoData = value; 
	}
	
	
	
	
	
	private long numeroMes;
	public long getNumeroMes()
	{
		return numeroMes;
	}
	public  void setNumeroMes(long value)
	{
		numeroMes = value; 
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
