package coletorjava.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;
import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class ExperimentoOpcaoCurtoPrazoVo implements ExperimentoOpcaoCurtoPrazo
{
		
	public long getIdObj()
    {
       return idExperimentoOpcaoCurtoPrazo;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdExperimentoOpcaoCurtoPrazo\" : \"" + idExperimentoOpcaoCurtoPrazo + "\" "
		+ ", \"DescricaoExperimento\" : \"" + descricaoExperimento + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private ExperimentoOpcaoCurtoPrazoDerivada derivada = null;
	private ExperimentoOpcaoCurtoPrazoDerivada getDerivada() {
		if (derivada==null) {
			derivada = new ExperimentoOpcaoCurtoPrazoDerivada(this);
		}
		return derivada;
	}

	private ExperimentoOpcaoCurtoPrazoAgregado agregado = null;
	private ExperimentoOpcaoCurtoPrazoAgregado getAgregado() {
		if (agregado==null) {
			agregado = new ExperimentoOpcaoCurtoPrazoAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idExperimentoOpcaoCurtoPrazo;
	public long getIdExperimentoOpcaoCurtoPrazo()
	{
		return idExperimentoOpcaoCurtoPrazo;
	}
	public  void setIdExperimentoOpcaoCurtoPrazo(long value)
	{
		idExperimentoOpcaoCurtoPrazo = value; 
	}
	
	
	
	
	
	private String descricaoExperimento;
	public String getDescricaoExperimento()
	{
		return descricaoExperimento;
	}
	public  void setDescricaoExperimento(String value)
	{
		descricaoExperimento = value; 
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
