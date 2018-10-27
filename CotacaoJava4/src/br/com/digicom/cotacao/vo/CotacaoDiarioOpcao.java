 package br.com.digicom.cotacao.vo;
 
public class CotacaoDiarioOpcao extends CotacaoDiario {
	private final int PREEXE_INI_D = 211;
	private final int PREEXE_FIM_D = 221;
	private final int DATVEN_INI_D = 222;
	private final int DATVEN_FIM_D = 229;

	protected float preco_exercicio = 0.0F;
	protected String data_vencimento = null;
	
	private boolean ehOpcao = false;
	
	public boolean isOpcao() {
		return ehOpcao;
	}

	public void extraiLinhaArquivoDiario(String linha) {
		super.extraiLinhaArquivoDiario(linha);
		this.tipo = linha.substring(0, 2);
		if (this.tipo.equals("02")) {
			this.preco_exercicio = extraiValor(211, 221, linha);
			this.data_vencimento = linha.substring(221, 229);
			this.ehOpcao = true;
		} else {
			this.ehOpcao = false;
		}
	}

	public String imprime() {
		return super.imprime() + "(exercicio:" + this.preco_exercicio + ",venc:" + this.data_vencimento + ")";
	}

	public float getPrecoExercicio() {
		return this.preco_exercicio;
	}
	public String getDataVencimanto() {
		return this.data_vencimento;
	}

	public boolean candidatoAcompanhamento() {
		return (this.negocios > 500L) && (this.codigoPapel != null)
				&& (this.codigoPapel.equals("070"))
				&& (!this.ticker.equals("CRUZ3"));
	}
}

/* Location:           D:\Java-Recuperacao\CotacaoJava2.jar
 * Qualified Name:     br.com.digicom.cotacao.vo.CotacaoDiarioOpcao
 * JD-Core Version:    0.6.0
 */