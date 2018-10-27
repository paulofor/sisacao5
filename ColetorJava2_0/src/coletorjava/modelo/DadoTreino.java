package coletorjava.modelo;

import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface DadoTreino extends DCIObjetoDominio , DadoTreinoAgregadoI , DadoTreinoDerivadaI
{

	
	public long getIdDadoTreino();
	public void setIdDadoTreino(long valor);
	
	
	public String getNomeArquivoX();
	public void setNomeArquivoX(String valor);
	
	
	public long getDiasEntradaDiario();
	public void setDiasEntradaDiario(long valor);
	
	
	public long getDiasEntradaIntraday();
	public void setDiasEntradaIntraday(long valor);
	
	
	public String getTipoPeriodo();
	public void setTipoPeriodo(String valor);
	
	
	public long getQtdeNeuronioEntrada();
	public void setQtdeNeuronioEntrada(long valor);
	
	
	public long getCodigoFaixa();
	public void setCodigoFaixa(long valor);
	
	
	public String getUltimaAlteracao();
	public void setUltimaAlteracao(String valor);
	
	
	public long getQtdeTickIntraday();
	public void setQtdeTickIntraday(long valor);
	
	
	public String getNomeArquivoY();
	public void setNomeArquivoY(String valor);
	
	
	public long getAno();
	public void setAno(long valor);
	
	
	public long getContadorPorAno();
	public void setContadorPorAno(long valor);
	
	
	public long getMinutosIntraday();
	public void setMinutosIntraday(long valor);
	
	
	public long getIdProjetoDadoTreinoP();
	public void setIdProjetoDadoTreinoP(long valor);
	
	
}

