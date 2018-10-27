package coletorjava.modelo.derivadas;


import br.com.digicom.lib.*;


import coletorjava.modelo.*;


public  class OpcaoSisacaoGeralDerivada   implements OpcaoSisacaoGeralDerivadaI { 
  private OpcaoSisacaoGeral principal;
      public OpcaoSisacaoGeralDerivada( OpcaoSisacaoGeral itemPrincipal )
      {
      principal = itemPrincipal;
	}
      
    private String _especificacao;  
	@Override
	public String getEspecificacao() {
		return _especificacao;
	}
	@Override
	public void setEspecificacao(String dado) {
		_especificacao = dado;
	}
	
	private String _nomeRes = null;
	@Override
	public String getNomeRes() {
		return _nomeRes;
	}
	@Override
	public void setNomeRes(String dado) {
		_nomeRes = dado;
	}
	
	private String _dataVencimentoStr = null;
	public String getDataVencimentoStr() {
		return _dataVencimentoStr;
	}
	public void setDataVencimentoStr(String value) {
		_dataVencimentoStr = value;
	}
	
	private long negocios;
	@Override
	public long getTotalNegocioDiaAnterior() {
		return negocios;
	}
	@Override
	public void setTotalNegocioDiaAnterior(long dado) {
		negocios = dado;
	}
	
	private float valorCotacao = 0;
	@Override
	public float getValorCotacao() {
		return valorCotacao;
	}
	@Override
	public void setValorCotacao(float dado) {
		valorCotacao = dado;
	}
	
	private long mQtdeNegocios = 0;
	@Override
	public long getQtdeNegocio() {
		return mQtdeNegocios;
	}
	@Override
	public void setQtdeNegocio(long dado) {
		mQtdeNegocios = dado;
	}
}
