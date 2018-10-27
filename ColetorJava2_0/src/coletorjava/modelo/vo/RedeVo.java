package coletorjava.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;
import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class RedeVo implements Rede
{
		
	public long getIdObj()
    {
       return idRede;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdRede\" : \"" + idRede + "\" "
		+ ", \"QtdeHidden1\" : \"" + qtdeHidden1 + "\" "
		+ ", \"QtdeHidden2\" : \"" + qtdeHidden2 + "\" "
		+ ", \"QtdeHidden3\" : \"" + qtdeHidden3 + "\" "
		+ ", \"UltimaAlteracao\" : \"" + ultimaAlteracao + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private RedeDerivada derivada = null;
	private RedeDerivada getDerivada() {
		if (derivada==null) {
			derivada = new RedeDerivada(this);
		}
		return derivada;
	}

	private RedeAgregado agregado = null;
	private RedeAgregado getAgregado() {
		if (agregado==null) {
			agregado = new RedeAgregado(this);
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
	

	
	
	
	
	
	private long idRede;
	public long getIdRede()
	{
		return idRede;
	}
	public  void setIdRede(long value)
	{
		idRede = value; 
	}
	
	
	
	
	
	private long qtdeHidden1;
	public long getQtdeHidden1()
	{
		return qtdeHidden1;
	}
	public  void setQtdeHidden1(long value)
	{
		qtdeHidden1 = value; 
	}
	
	
	
	
	
	private long qtdeHidden2;
	public long getQtdeHidden2()
	{
		return qtdeHidden2;
	}
	public  void setQtdeHidden2(long value)
	{
		qtdeHidden2 = value; 
	}
	
	
	
	
	
	private long qtdeHidden3;
	public long getQtdeHidden3()
	{
		return qtdeHidden3;
	}
	public  void setQtdeHidden3(long value)
	{
		qtdeHidden3 = value; 
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
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
