package coletorjava.regracolecao.extraicotacao;

import coletorjava.modelo.CotacaoDiario;
import coletorjava.modelo.FabricaVo;


/*
 * Essa classe precisa de um refactoring foi feita aproveitando outras para um solução simples
 * de um problema.
 */

public class ExtraiCotacaoDiarioOpcao extends ExtraiCotacaoDiario {
	private final int PREEXE_INI_D = 211;
	private final int PREEXE_FIM_D = 221;
	private final int DATVEN_INI_D = 222;
	private final int DATVEN_FIM_D = 229;
	
	private final int NOMERES_INI_D = 35; // Nome da ação
	private final int NOMERES_FIM_D = 46;
	private final int ESPECI_INI_D = 47; // Tipo ON/PN
	private final int ESPECI_FIM_D = 56;

	protected float preco_exercicio = 0.0F;
	protected String data_vencimento = null;
	
	protected String nomeAcao = null;
	protected String tipoAcao = null;
	
	private boolean ehOpcao = false;
	
	
	public CotacaoDiario getCotacao(String linha) {
		CotacaoDiario cotacao = null;
		extraiLinhaArquivoDiario(linha);
		cotacao = FabricaVo.criaCotacaoDiario();
		cotacao.setLinhaArquivoDiario(linha);
		if (cotacao.getEhOpcao()) {
			System.out.println("Opção: " + cotacao.getNomeTicker() + " Neg: " + cotacao.getNegocios());
		}
		return cotacao;
	}
	
	protected boolean isOpcao() {
		return ehOpcao;
	}


	protected String imprime() {
		return super.imprime() + "(exercicio:" + this.preco_exercicio + ",venc:" + this.data_vencimento + ")";
	}

	protected float getPrecoExercicio() {
		return this.preco_exercicio;
	}
	protected String getDataVencimanto() {
		return this.data_vencimento;
	}

	protected boolean candidatoAcompanhamento() {
		return (this.negocios > 500L) && (this.codigoPapel != null)
				&& (this.codigoPapel.equals("070"))
				&& (!this.ticker.equals("CRUZ3"));
	}
}
