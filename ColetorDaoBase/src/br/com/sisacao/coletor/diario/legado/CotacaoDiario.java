package br.com.sisacao.coletor.diario.legado;


import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface CotacaoDiario extends DCIObjetoDominio , CotacaoDiarioAgregadoI , CotacaoDiarioDerivadaI
{

	
	public float getPercentual();
	public void setPercentual(float valor);
	
	public long getIdCotacaoDiario();
	public void setIdCotacaoDiario(long valor);
	
	
	public float getMinimoCorrigido();
	public void setMinimoCorrigido(float valor);
	
	public String getMinimoCorrigidoFormatada();
	
	
	public float getMaximoCorrigido();
	public void setMaximoCorrigido(float valor);
	
	public String getMaximoCorrigidoFormatada();
	
	
	public float getAberturaCorrigido();
	public void setAberturaCorrigido(float valor);
	
	public String getAberturaCorrigidoFormatada();
	
	
	public String getData();
	public void setData(String valor);
	
	
	public float getVolume();
	public void setVolume(float valor);
	
	
	public long getNegocios();
	public void setNegocios(long valor);
	
	
	public float getFechamentoOriginal();
	public void setFechamentoOriginal(float valor);
	
	public String getFechamentoOriginalFormatada();
	
	
	public float getMinimoOriginal();
	public void setMinimoOriginal(float valor);
	
	public String getMinimoOriginalFormatada();
	
	
	public float getMaximoOriginal();
	public void setMaximoOriginal(float valor);
	
	public String getMaximoOriginalFormatada();
	
	
	public float getAberturaOriginal();
	public void setAberturaOriginal(float valor);
	
	public String getAberturaOriginalFormatada();
	
	
	public float getFechamentoCorrigido();
	public void setFechamentoCorrigido(float valor);
	
	public String getFechamentoCorrigidoFormatada();
	
	
}

