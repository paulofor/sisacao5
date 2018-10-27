package coletorjava.modelo.derivadas;

import coletorjava.modelo.CotacaoDiario;

public class CotacaoDiarioDerivada implements CotacaoDiarioDerivadaI {
	private CotacaoDiario principal;

	public CotacaoDiarioDerivada(CotacaoDiario itemPrincipal) {
		principal = itemPrincipal;
	}

	private boolean ehAcao = false;
	private boolean ehOpcao = false;

	@Override
	public String getLinhaArquivoHistorico() {
		return (ehAcao?"":null);
	}

	
	private String _especificacao;
	private float _precoExercicio;
	private String _dataVencimento;
	private String _nomeRes;
	private String linhaArquivo;
	
	@Override
	public void setLinhaArquivoHistorico(String linha) {
		linhaArquivo = linha;
		String tipo = linha.substring(0, 2);
		if (tipo.equals("01")) {
			ehAcao = true;
			this.nomeTicker = linha.substring(12, 24).trim();
			principal.setDataAAAAMMDD(linha.substring(2, 10).trim());
			principal.setAberturaOriginal(extraiValor(57, 69, linha));
			principal.setMaximoOriginal(extraiValor(70, 82, linha));
			principal.setMinimoOriginal(extraiValor(83, 95, linha));
			// this.medio = extraiValor(96, 108, linha);
			principal.setFechamentoOriginal(extraiValor(109, 121, linha));
			principal.setNegocios(extraiInteiro(148, 152, linha));
			principal.setVolume(extraiValor(171, 188, linha));
			
			principal.setNomeTicker(linha.substring(4, 34).trim());
			// this.qtdeTitulos = extraiInteiro(153, 170, linha);
			// Para Opções
			_especificacao = linha.substring(39, 49).trim();
			_precoExercicio = extraiValor(190, 201, linha);
			_dataVencimento = extraiData(203,210,linha);
			_nomeRes = linha.substring(27,39).trim();
			if (_precoExercicio>0) {
				this.ehOpcao = true;
			} else {
				this.ehOpcao = false;
			}
		} else {
			ehAcao = false;
		}
	}
	
	@Override
	public void setLinhaArquivoDiario(String linha) {
		String tipo = linha.substring(0, 2);
		if (tipo.equals("02") && extraiInteiro(3,4,linha) == 78) {
			ehAcao = true;
			this.nomeTicker = linha.substring(12, 24).trim();
			
			//principal.setDataAAAAMMDD(linha.substring(2, 10).trim());
			principal.setAberturaOriginal(extraiValor(91, 101, linha));
			principal.setMaximoOriginal(extraiValor(102,112 , linha));
			principal.setMinimoOriginal(extraiValor(113,123 , linha));
			principal.setFechamentoOriginal(extraiValor(135,145 , linha));
			principal.setNegocios(extraiInteiro(174,178 , linha));
			principal.setVolume(extraiValor(194,210 , linha));
			
			principal.setNomeTicker(linha.substring(57, 69).trim());
			// Para Opções
			_precoExercicio = extraiValor(211,221 , linha);
			_dataVencimento = linha.substring(221, 229).trim();
			_nomeRes = linha.substring(34, 46).trim();
			_especificacao = linha.substring(46, 56).trim();
			if (_precoExercicio>0) {
				this.ehOpcao = true;
			} else {
				this.ehOpcao = false;
			}
		} else {
			ehAcao = false;
		}

	}

	private float extraiValor(int posicaoInicial, int posicaoFinal, String linha) {
		float saida = Float.parseFloat(linha.substring(posicaoInicial - 1, posicaoFinal).trim()) / 100.0F;
		return saida;
	}

	private long extraiInteiro(int posicaoInicial, int posicaoFinal, String linha) {
		long saida = Long.parseLong(linha.substring(posicaoInicial - 1,posicaoFinal).trim());
		return saida;
	}
	private String extraiData(int posicaoInicial, int posicaoFinal, String linha) {
		//  AAAAMMDD
		//  0123456789
		String valorData = linha.substring(posicaoInicial - 1, posicaoFinal);
		String dia = valorData.substring(6);
		String mes = valorData.substring(4, 6);
		String ano = valorData.substring(0,4);
		return dia + "-" + mes + "-" + ano;
	}

	String nomeTicker = null;
	@Override
	public String getNomeTicker() {
		return nomeTicker;
	}

	@Override
	public void setNomeTicker(String dado) {
		nomeTicker = dado;
	}

	@Override
	public String getDataAAAAMMDD() {
		// DD-MM-AAAA
		// 01234567890
		String dia = this.principal.getData().substring(0, 2);
		String mes = this.principal.getData().substring(3, 5);
		String ano = this.principal.getData().substring(6);
		return (ano + mes + dia);
	}

	@Override
	public void setDataAAAAMMDD(String dado) {
		// AAAADDMM
		// 012345678
		String dia = dado.substring(6);
		String mes = dado.substring(4, 6);
		String ano = dado.substring(0, 4);
		principal.setData(dia + "-" + mes + "-" + ano);
	}

	@Override
	public String getLinhaLog() {
		return principal.getNomeTicker() + " - " + principal.getData() + " : " + principal.getFechamentoOriginalFormatada() + " (Venc:" + this.getDataVencimento() + " - " + this.getMesAnoOpcao() + " )";
	}

	@Override
	public void setLinhaLog(String dado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getEhOpcao() {
		return ehOpcao;
	}

	@Override
	public void setEhOpcao(boolean dado) {
		ehOpcao = dado;
	}

	@Override
	public float getPrecoExercicio() {
		return this._precoExercicio;
	}

	@Override
	public void setPrecoExercicio(float dado) {
		throw new RuntimeException("Preco Exercicio obtido pelo parse na linha");
	}

	@Override
	public String getDataVencimento() {
		return this._dataVencimento;
	}

	@Override
	public void setDataVencimento(String dado) {
		throw new RuntimeException("Data de vencimento obtido pelo parse na linha");
	}

	@Override
	public String getNomeResArquivo() {
		return this._nomeRes;
	}

	@Override
	public void setNomeResArquivo(String dado) {
		throw new RuntimeException("NomeRes obtido pelo parse na linha");
		
	}

	@Override
	public String getEspecificacaoArquivo() {
		return this._especificacao;
	}

	@Override
	public void setEspecificacaoArquivo(String dado) {
		throw new RuntimeException("Especificacao obtido pelo parse na linha");
	}

	@Override
	public String getMesAnoOpcao() {
		String ano = this._dataVencimento.substring(6);
		String mes = this._dataVencimento.substring(3, 5);
		return ano + "-" + mes + "-01";
	}

	
	@Override
	public void setMesAnoOpcao(String dado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getLinhaArquivoDiario() {
		return (ehAcao?"":null);
	}
}
