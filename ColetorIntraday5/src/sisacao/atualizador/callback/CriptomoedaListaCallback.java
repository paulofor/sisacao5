package sisacao.atualizador.callback;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.swing.text.html.HTML.Tag;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.CallbackParseHtml;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.modelo.AtivoCriptomoeda;

public class CriptomoedaListaCallback extends CallbackParseHtml{
	
	private String ticker;
	private String nome;
	private String valor;
	
	private boolean liga = false;
	private boolean inicioTabela = false;
	private int contaColuna = 0;
	private int contaLinha = 0;
	private int contaPosicao = 0;
	
	private CriptomoedaListaDado dado = null;
	private AtivoCriptomoeda ativo = null;
	
	@Override
	public URL getUrl() throws MalformedURLException {
		return new URL("https://coinmarketcap.com/pt-br/");
	}

	
	
	
	@Override
	protected void inicioTagImpl(Tag t, String classeNome, String idNome) {
		super.inicioTagImpl(t, classeNome, idNome);
		if (this.inicioTabela && t==Tag.TD) {
			contaColuna++;
			
			System.out.println("UltCont: " + this.getUltConteudo());
			System.out.println("UltCont2: " + this.getUltConteudo2());
			System.out.println("UltCont3: " + this.getUltConteudo3());
			System.out.println("UltCont4: " + this.getUltConteudo4());
			System.out.println("UltCont5: " + this.getUltConteudo5());
			System.out.println("Linha:" + this.contaLinha);
			System.out.println("Coluna:" + contaColuna);
			System.out.println();
			
			
			if (this.contaColuna==4) {
				if ("Compre".equals(this.getUltConteudo())) {
					this.ticker = this.getUltConteudo2();
					this.nome = this.getUltConteudo4();
				} else {
					if ("crypto-symbol".equals(this.getUltClasse2())) {
						this.ticker = this.getUltConteudo();
						this.nome = this.getUltConteudo2();
					} else {
						this.ticker = this.getUltConteudo();
						this.nome = this.getUltConteudo3();
					}

				}
				ativo = new AtivoCriptomoeda();
				ativo.setNome(this.nome);
				ativo.setTicker(this.ticker);
			}
			
			
			if (this.contaColuna==6) {
				System.out.println("Parei aqui");
			}

			

			if (this.contaColuna==8) {
				this.valor = this.getUltConteudo();
				ativo.setValorMercado(this.getValor(this.valor));
				
			}
		}
		if (this.liga && t==Tag.TR) {
			if (ativo!=null) {
				ativo.setPosicao(++this.contaPosicao);
				this.dado.adicionaAtivo(ativo);
				ativo = null;
			}
			this.contaColuna = 0;
			this.inicioTabela = true;
			this.contaLinha++;
		}
		if (classeNome.indexOf("cmc-table")!=-1) {
			this.liga = true;
			this.contaLinha = 0;
		}
	}

	
	private double getValor(String numero) {
		double saida = 0;
		String numero1 = numero.substring(2);
		String numero2 = numero1.replaceAll(",","");
		return saida = Double.parseDouble(numero2);
	}



	@Override
	public void setDados(IDadosParse paramIDadosParse) {
		this.dado = (CriptomoedaListaDado) paramIDadosParse;
	}

	@Override
	public void finalizacaoErro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizacaoOk() throws DaoException {
		if (ativo!=null) {
			ativo.setPosicao(++this.contaPosicao);
			this.dado.adicionaAtivo(ativo);
			ativo = null;
		}
		System.out.println("Terminou: " + this.dado.getLista().size() + " itens.");
		this.dado.enviaDados();
	}

	@Override
	public void inicializacao() {
		//this.setDebug();
	}

	@Override
	public boolean getLoop() {
		return false;
	}

	@Override
	public boolean isPost() {
		return false;
	}

	@Override
	public List camposPost() {
		return null;
	}

	@Override
	public String getCharSet() {
		return null;
	}

	@Override
	public URL getJsonUrl() throws MalformedURLException {
		return null;
	}

}
