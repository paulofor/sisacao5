package sisacao.cdb.processamento;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTML.Tag;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.CallbackParseHtml;
import br.com.digicom.parse.callback.IDadosParse;

public class ListaRendaFixaYubbCallback extends CallbackParseHtml{

	private String percentual;
	private String tipo;
	private String nome;
	private String rentabilidadeAno;
	private String investimentoMinimo;
	private String dataResgate;
	private String emissor;
	private String distribuidor;
	private String ativo;
	
	private int contaItem;
	
	private boolean coletando = true;
	private boolean loop = false;
	private String proximaUrl = null;
	
	
	@Override
	protected void elementoSimples(Tag t, String nomeId, String nomeClasse, String conteudo) {
		super.elementoSimples(t, nomeId, nomeClasse, conteudo);
		if ("header__top".equals(this.getUltClasse2())) {
			this.ativo = conteudo;
			coletando = true;
		}
		if ("sugarish__number".equals(nomeClasse)) {
			this.percentual = conteudo;
		}
		if ("sugarish__cdi".equals(nomeClasse)) {
			if ("CDI".equals(conteudo)) {
				this.tipo = "CDI";
			}
			if ("a.a.".equals(conteudo)) {
				this.tipo = "PRE";
			}
		}
		if ("header__title header__title--column investmentCard__row".equals(this.getUltClasse3())) {
			if (this.nome==null) this.nome  = conteudo;
		}
		if (("Rentabilidade ao Ano").equals(this.getUltConteudo2())) {
			this.rentabilidadeAno = conteudo;
		}
		if (("Investimento Mínimo").equals(this.getUltConteudo2())) {
			this.investimentoMinimo = conteudo;
		}
		if (("Prazo de Resgate").equals(this.getUltConteudo2())) {
			this.dataResgate = conteudo;
		}
		if (("Distribuidor").equals(this.getUltConteudo2())) {
			this.distribuidor = conteudo;
		}
		if (coletando && ("Emissor").equals(this.getUltConteudo2())) {
			if (this.emissor==null) {
				this.emissor = conteudo;
				coletando = false;
				finalizaItem();
			}
		}
	}

	private void finalizaItem() {
		System.out.println(this.nome);
		System.out.println("Tipo:" + this.tipo);
		System.out.println("Rentabilidade Anual: " + this.rentabilidadeAno);
		System.out.println("Valor Minimo:" + this.investimentoMinimo);
		System.out.println("Vencimento: " + this.dataResgate);
		System.out.println();
		
		this.emissor = null;
		this.distribuidor = null;
		this.dataResgate = null;
		this.rentabilidadeAno = null;
		this.tipo = null;
		this.investimentoMinimo = null;
		this.percentual = null;
		this.nome = null;
		this.ativo = null;
		

		
	}
	
	@Override
	public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) {
		super.handleStartTag(t, a, pos);
		if ("page next".equals(this.getUltClasse2())) {
			this.loop = true;
			this.proximaUrl = this.getUtlUrl();
		}
	}
	
	@Override
	public URL getUrl() throws MalformedURLException {
		String url = null;
		if (this.proximaUrl==null) {
			url = "https://172.66.40.254/investimentos/renda-fixa?investment_type=renda-fixa&months=24&principal=5000.0&risk%5Bmax%5D=&risk%5Bmin%5D=&sort_by=net_return";
 		} else {
 			url = "https://yubb.com.br" + this.proximaUrl;
 		}
		//url = "https://yubb.com.br/investimentos/renda-fixa?collection_page=2&investment_type=renda-fixa&months=24&principal=5000.0&risk%5Bmax%5D=&risk%5Bmin%5D=&sort_by=net_return";
		return new URL(url);
	}

	@Override
	public void setDados(IDadosParse paramIDadosParse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizacaoErro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizacaoOk() throws DaoException {
		System.out.println("finalizou");
	}

	@Override
	public void inicializacao() {
		//this.setDebug();
		this.loop = false;
		this.emissor = null;
		this.distribuidor = null;
		this.dataResgate = null;
		this.rentabilidadeAno = null;
		this.tipo = null;
		this.investimentoMinimo = null;
		this.percentual = null;
		this.nome = null;
		this.proximaUrl = null;
	}

	@Override
	public boolean getLoop() {
		return loop;
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
