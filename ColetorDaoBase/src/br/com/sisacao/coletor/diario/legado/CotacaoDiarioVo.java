package br.com.sisacao.coletor.diario.legado;

import java.text.DecimalFormat;

import br.com.digicom.lib.dao.DaoConexao;


// Gera??o autom?tica n?o alterar
public class CotacaoDiarioVo implements CotacaoDiario
{
		
	public long getIdObj()
    {
       return idCotacaoDiario;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdCotacaoDiario\" : \"" + idCotacaoDiario + "\" "
		+ ", \"MinimoCorrigido\" : \"" + minimoCorrigido + "\" "
		+ ", \"MaximoCorrigido\" : \"" + maximoCorrigido + "\" "
		+ ", \"AberturaCorrigido\" : \"" + aberturaCorrigido + "\" "
		+ ", \"Data\" : \"" + data + "\" "
		+ ", \"Volume\" : \"" + volume + "\" "
		+ ", \"Negocios\" : \"" + negocios + "\" "
		+ ", \"FechamentoOriginal\" : \"" + fechamentoOriginal + "\" "
		+ ", \"MinimoOriginal\" : \"" + minimoOriginal + "\" "
		+ ", \"MaximoOriginal\" : \"" + maximoOriginal + "\" "
		+ ", \"AberturaOriginal\" : \"" + aberturaOriginal + "\" "
		+ ", \"FechamentoCorrigido\" : \"" + fechamentoCorrigido + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private CotacaoDiarioDerivada derivada = null;
	private CotacaoDiarioDerivada getDerivada() {
		if (derivada==null) {
			derivada = new CotacaoDiarioDerivada(this);
		}
		return derivada;
	}

	private CotacaoDiarioAgregado agregado = null;
	private CotacaoDiarioAgregado getAgregado() {
		if (agregado==null) {
			agregado = new CotacaoDiarioAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	
	
	// Um pra um
	
	
	
	
	public String getLinhaArquivoHistorico()
	{
		return getDerivada().getLinhaArquivoHistorico(); 
	} 
	public void setLinhaArquivoHistorico(String value)
	{
		getDerivada().setLinhaArquivoHistorico(value); 
	} 
	
	public String getNomeTicker()
	{
		return getDerivada().getNomeTicker(); 
	} 
	public void setNomeTicker(String value)
	{
		getDerivada().setNomeTicker(value); 
	} 
	
	public String getDataAAAAMMDD()
	{
		return getDerivada().getDataAAAAMMDD(); 
	} 
	public void setDataAAAAMMDD(String value)
	{
		getDerivada().setDataAAAAMMDD(value); 
	} 
	
	public String getLinhaLog()
	{
		return getDerivada().getLinhaLog(); 
	} 
	public void setLinhaLog(String value)
	{
		getDerivada().setLinhaLog(value); 
	} 
	
	public boolean getEhOpcao()
	{
		return getDerivada().getEhOpcao(); 
	} 
	public void setEhOpcao(boolean value)
	{
		getDerivada().setEhOpcao(value); 
	} 
	
	public float getPrecoExercicio()
	{
		return getDerivada().getPrecoExercicio(); 
	} 
	public void setPrecoExercicio(float value)
	{
		getDerivada().setPrecoExercicio(value); 
	} 
	
	public String getDataVencimento()
	{
		return getDerivada().getDataVencimento(); 
	} 
	public void setDataVencimento(String value)
	{
		getDerivada().setDataVencimento(value); 
	} 
	
	public String getNomeResArquivo()
	{
		return getDerivada().getNomeResArquivo(); 
	} 
	public void setNomeResArquivo(String value)
	{
		getDerivada().setNomeResArquivo(value); 
	} 
	
	public String getEspecificacaoArquivo()
	{
		return getDerivada().getEspecificacaoArquivo(); 
	} 
	public void setEspecificacaoArquivo(String value)
	{
		getDerivada().setEspecificacaoArquivo(value); 
	} 
	
	public String getMesAnoOpcao()
	{
		return getDerivada().getMesAnoOpcao(); 
	} 
	public void setMesAnoOpcao(String value)
	{
		getDerivada().setMesAnoOpcao(value); 
	} 
	
	public String getLinhaArquivoDiario()
	{
		return getDerivada().getLinhaArquivoDiario(); 
	} 
	public void setLinhaArquivoDiario(String value)
	{
		getDerivada().setLinhaArquivoDiario(value); 
	} 
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idCotacaoDiario;
	public long getIdCotacaoDiario()
	{
		return idCotacaoDiario;
	}
	public  void setIdCotacaoDiario(long value)
	{
		idCotacaoDiario = value; 
	}
	
	
	
	public String getMinimoCorrigidoFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(minimoCorrigido);
	}
	
	
	
	private float minimoCorrigido;
	public float getMinimoCorrigido()
	{
		return minimoCorrigido;
	}
	public  void setMinimoCorrigido(float value)
	{
		minimoCorrigido = value; 
	}
	
	
	
	public String getMaximoCorrigidoFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(maximoCorrigido);
	}
	
	
	
	private float maximoCorrigido;
	public float getMaximoCorrigido()
	{
		return maximoCorrigido;
	}
	public  void setMaximoCorrigido(float value)
	{
		maximoCorrigido = value; 
	}
	
	
	
	public String getAberturaCorrigidoFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(aberturaCorrigido);
	}
	
	
	
	private float aberturaCorrigido;
	public float getAberturaCorrigido()
	{
		return aberturaCorrigido;
	}
	public  void setAberturaCorrigido(float value)
	{
		aberturaCorrigido = value; 
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
	
	
	
	
	
	private float volume;
	public float getVolume()
	{
		return volume;
	}
	public  void setVolume(float value)
	{
		volume = value; 
	}
	
	
	
	
	
	private long negocios;
	public long getNegocios()
	{
		return negocios;
	}
	public  void setNegocios(long value)
	{
		negocios = value; 
	}
	
	
	
	public String getFechamentoOriginalFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(fechamentoOriginal);
	}
	
	
	
	private float fechamentoOriginal;
	public float getFechamentoOriginal()
	{
		return fechamentoOriginal;
	}
	public  void setFechamentoOriginal(float value)
	{
		fechamentoOriginal = value; 
	}
	
	
	
	public String getMinimoOriginalFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(minimoOriginal);
	}
	
	
	
	private float minimoOriginal;
	public float getMinimoOriginal()
	{
		return minimoOriginal;
	}
	public  void setMinimoOriginal(float value)
	{
		minimoOriginal = value; 
	}
	
	
	
	public String getMaximoOriginalFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(maximoOriginal);
	}
	
	
	
	private float maximoOriginal;
	public float getMaximoOriginal()
	{
		return maximoOriginal;
	}
	public  void setMaximoOriginal(float value)
	{
		maximoOriginal = value; 
	}
	
	
	
	public String getAberturaOriginalFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(aberturaOriginal);
	}
	
	
	
	private float aberturaOriginal;
	public float getAberturaOriginal()
	{
		return aberturaOriginal;
	}
	public  void setAberturaOriginal(float value)
	{
		aberturaOriginal = value; 
	}
	
	
	
	public String getFechamentoCorrigidoFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(fechamentoCorrigido);
	}
	
	
	
	private float fechamentoCorrigido;
	public float getFechamentoCorrigido()
	{
		return fechamentoCorrigido;
	}
	public  void setFechamentoCorrigido(float value)
	{
		fechamentoCorrigido = value; 
	}

	
	private float percentual;
	@Override
	public float getPercentual() {
		return percentual;
	}

	@Override
	public void setPercentual(float valor) {
		this.percentual = valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
