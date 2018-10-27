package coletorjava.regracolecao.extraicotacao;

import java.text.DecimalFormat;

public class ExtraiCotacaoDiario {

	protected String tipo = null;
	protected String ticker = null;
	protected String data = null;
	protected float abertura = 0.0F;
	protected float medio = 0.0F;
	protected float maximo = 0.0F;
	protected float minimo = 0.0F;
	protected float fechamento = 0.0F;
	protected long negocios = 0L;
	protected float volume = 0.0F;
	protected long qtdeTitulos = 0L;
	protected String codigoPapel = null;
	protected long codigoBdi = 0;

	protected final int TIPOREG_INI = 1;
	protected final int TIPOREG_FIM = 2;
	private final int DATA_PREGAO_INI = 3;
	private final int DATA_PREGAO_FIM = 10;
	private final int COD_NEG_INI = 13;
	private final int COD_NEG_FIM = 24;
	private final int PREABE_INI = 57;
	private final int PREABE_FIM = 69;
	private final int PREMAX_INI = 70;
	private final int PREMAX_FIM = 82;
	private final int PREMIN_INI = 83;
	private final int PREMIN_FIM = 95;
	private final int PREMED_INI = 96;
	private final int PREMED_FIM = 108;
	private final int PREULT_INI = 109;
	private final int PREULT_FIM = 121;
	private final int TOTNEG_INI = 148;
	private final int TOTNEG_FIM = 152;
	private final int QUATOT_INI = 153;
	private final int QUATOT_FIM = 170;
	private final int VOLTOT_INI = 171;
	private final int VOLTOT_FIM = 188;

	protected final int TIPOREG_INI_D = 1;
	protected final int TIPOREG_FIM_D = 2;
	protected final int CODIGO_BDI_INI_D = 3;
	protected final int CODIGO_BDI_FIM_D = 4;
	private final int COD_NEG_INI_D = 58;
	private final int COD_NEG_FIM_D = 69;
	private final int PREABE_INI_D = 91;
	private final int PREABE_FIM_D = 101;
	private final int PREMAX_INI_D = 102;
	private final int PREMAX_FIM_D = 112;
	private final int PREMIN_INI_D = 113;
	private final int PREMIN_FIM_D = 123;
	private final int PREMED_INI_D = 124;
	private final int PREMED_FIM_D = 134;
	private final int PREULT_INI_D = 135;
	private final int PREULT_FIM_D = 145;
	private final int TOTNEG_INI_D = 174;
	private final int TOTNEG_FIM_D = 178;
	private final int QUATOT_INI_D = 179;
	private final int QUATOT_FIM_D = 193;
	private final int VOLTOT_INI_D = 194;
	private final int VOLTOT_FIM_D = 210;

	private final int COD_NEG_INI_D_IND = 5;
	private final int COD_NEG_FIM_D_IND = 34;
	private final int PREABE_INI_D_IND = 35;
	private final int PREABE_FIM_D_IND = 40;
	private final int PREMAX_INI_D_IND = 47;
	private final int PREMAX_FIM_D_IND = 52;
	private final int PREMIN_INI_D_IND = 41;
	private final int PREMIN_FIM_D_IND = 46;
	private final int PREMED_INI_D_IND = 53;
	private final int PREMED_FIM_D_IND = 58;
	private final int PREULT_INI_D_IND = 93;
	private final int PREULT_FIM_D_IND = 98;
	private final int TOTNEG_INI_D_IND = 156;
	private final int TOTNEG_FIM_D_IND = 164;
	private final int QUATOT_INI_D_IND = 165;
	private final int QUATOT_FIM_D_IND = 179;
	private final int VOLTOT_INI_D_IND = 180;
	private final int VOLTOT_FIM_D_IND = 196;

	protected void extraiLinhaArquivo(String linha) {
		this.tipo = linha.substring(0, 2);
		if (this.tipo.equals("01")) {
			this.ticker = linha.substring(12, 24).trim();
			this.data = linha.substring(2, 10).trim();
			this.abertura = extraiValor(57, 69, linha);
			this.maximo = extraiValor(70, 82, linha);
			this.minimo = extraiValor(83, 95, linha);
			this.medio = extraiValor(96, 108, linha);
			this.fechamento = extraiValor(109, 121, linha);

			this.negocios = extraiInteiro(148, 152, linha);
			this.volume = extraiValor(171, 188, linha);
			this.qtdeTitulos = extraiInteiro(153, 170, linha);
		} else {
			this.ticker = "";
		}
	}

	protected void extraiLinhaArquivoDiario(String linha) {
		this.tipo = linha.substring(0, 2);
		if (this.tipo.equals("02")) {
			this.ticker = linha.substring(57, 69).trim();

			this.data = "";
			this.abertura = extraiValor(91, 101, linha);
			this.maximo = extraiValor(102, 112, linha);
			this.minimo = extraiValor(113, 123, linha);
			this.medio = extraiValor(124, 134, linha);
			this.fechamento = extraiValor(135, 145, linha);

			this.negocios = extraiInteiro(174, 178, linha);
			this.volume = extraiValor(194, 210, linha);
			this.qtdeTitulos = extraiInteiro(179, 193, linha);

			this.codigoPapel = linha.substring(69, 72).trim();
			
			this.codigoBdi = extraiInteiro(CODIGO_BDI_INI_D,CODIGO_BDI_FIM_D,linha);
			return;
		}
		if (this.tipo.equals("01")) {
			this.ticker = linha.substring(4, 34).trim();

			this.data = "";
			this.abertura = extraiValorIndice(35, 40, linha);
			this.maximo = extraiValorIndice(47, 52, linha);
			this.minimo = extraiValorIndice(41, 46, linha);
			this.medio = extraiValorIndice(53, 58, linha);
			this.fechamento = extraiValorIndice(93, 98, linha);

			this.negocios = extraiInteiro(156, 164, linha);
			this.volume = extraiValor(180, 196, linha);
			this.qtdeTitulos = extraiInteiro(165, 179, linha);

			return;
		}
		this.ticker = "";
	}

	
	protected String extraiTexto(int posicaoInicial, int posicaoFinal, String linha) {
		return linha.substring(posicaoInicial - 1, posicaoFinal).trim();
	}
	protected float extraiValor(int posicaoInicial, int posicaoFinal, String linha) {
		float saida = Float.parseFloat(linha.substring(posicaoInicial - 1, posicaoFinal).trim()) / 100.0F;
		return saida;
	}

	protected float extraiValorIndice(int posicaoInicial, int posicaoFinal, String linha) {
		float saida = Float.parseFloat(linha.substring(posicaoInicial - 1, posicaoFinal).trim());
		return saida;
	}

	protected long extraiInteiro(int posicaoInicial, int posicaoFinal, String linha) {
		long saida = Long.parseLong(linha.substring(posicaoInicial - 1, posicaoFinal).trim());
		return saida;
	}

	protected void setTicker(String ticker) {
		this.ticker = ticker;
	}

	protected String getTicker() {
		return this.ticker;
	}

	protected String imprime() {
		return this.ticker + "(" + getDataBd() + ") : R$" + this.fechamento + " [Neg:" + this.negocios + " R$" + this.getVolumeStr() + "]";
	}

	protected float getAbertura() {
		return this.abertura;
	}

	protected float getMaximo() {
		return this.maximo;
	}

	protected float getMinimo() {
		return this.minimo;
	}

	protected float getFechamento() {
		return this.fechamento;
	}

	protected long getNegocios() {
		return this.negocios;
	}

	protected String getVolumeStr() {
		DecimalFormat df = new DecimalFormat("0.##");
		String numero = df.format(this.volume);
		numero = numero.replaceAll(",", ".");
		return numero;
	}

	protected float getVolume() {
		return this.volume;
	}

	protected String getDataDD_MM_AAAA() {
		return this.data.substring(6, 8) + "-" + this.data.substring(4, 6) + "-" + this.data.substring(0, 4);
	}

	protected void setDataDD_MM_AAAA(String data) {
		this.data = (data.substring(6, 10) + data.substring(3, 5) + data.substring(0, 2));
	}

	protected String getDataBd() {
		return this.data.substring(0, 4) + "-" + this.data.substring(4, 6) + "-" + this.data.substring(6, 8);
	}

	protected boolean candidatoAcompanhamento() {
		return (this.negocios > 50L) && (this.codigoPapel != null) && (this.codigoPapel.equals("010")) &&
		(!this.ticker.equals("CRUZ3"));
	}

	protected boolean isAcao() {
		return (this.codigoPapel != null) && (this.codigoPapel.equals("010"));
	}

}
