package coletorjava.modelo.derivadas;


import br.com.digicom.lib.*;


import coletorjava.modelo.*;


public  class OpcaoSisacaoDerivada   implements OpcaoSisacaoDerivadaI { 
  private OpcaoSisacao principal;
      public OpcaoSisacaoDerivada( OpcaoSisacao itemPrincipal )
      {
      principal = itemPrincipal;
	}
      
    private float valorCotacao;
	@Override
	public float getValorCotacao() {
		return valorCotacao;
	}
	@Override
	public void setValorCotacao(float dado) {
		valorCotacao = dado;
	}
	
	private long qtdeNegocio;
	@Override
	public long getQtdeNegocio() {
		return qtdeNegocio;
	}
	@Override
	public void setQtdeNegocio(long dado) {
		qtdeNegocio = dado;
	}
}
