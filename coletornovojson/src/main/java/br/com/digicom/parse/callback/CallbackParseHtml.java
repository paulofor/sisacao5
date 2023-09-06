package br.com.digicom.parse.callback;

import java.net.CookieManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.HTML.Tag;

import br.com.digicom.parse.ParserHtmlTh;
import br.com.digicom.parse.ParserThread;

public abstract class CallbackParseHtml extends HTMLEditorKit.ParserCallback implements ICallbackParse {
	
	public static String HTML4_CHARSET = "ISO-8859-1";
	public static String HTML5_CHARSET = "UTF-8";
	
	private boolean debug = false;

	private String ultConteudo = null, ultConteudo2 = null, ultConteudo3 = null, ultConteudo4 = null, ultConteudo5 = null;
	private String ultId = null;
	private String ultClasse = null, ultClasse2 = null, ultClasse3 = null;
	private String ultUrl = null, ultUrl2 = null, ultUrl3 = null;
	private HTML.Tag ultTag = null , ultTag2 = null;
	private MutableAttributeSet ultAtributoTag = null , ultAtributoTag2 = null;
	private HTML.Tag ultTagSimples = null;
	private String ultImagem = null, ultImagem2 = null, ultImagem3 = null, ultImagem4 = null, ultImagem5 = null;
	
	private String ultConteudoComTexto = null;
	
	private int contLi = 0;

	private String paginaStr = null;
	private List<String> listaScript = new ArrayList<String>();
	private int inicioScript;
	private boolean contandoScript = false;
	private String ultTipoScript = null;
	
	private MutableAttributeSet scriptAtributos;
	
	
	protected boolean concluido = false;
	
	public void setConcluidoFalse() {
		this.concluido = false;
	}
	public boolean getConcluido() {
		return this.concluido;
	}
	protected void alteraParaConcluido() {
		this.concluido = true;
	}
	
	
	
	@Override
	public void setString(String resposta) {
		// TODO Auto-generated method stub
		this.paginaStr = resposta;
		this.contandoScript = false;
		this.inicioScript = 0;
	}
	
	private String getTrecho(int ini, int termino) {
		//System.out.println(this.paginaStr.length());
		return this.paginaStr.substring(ini, termino);
	}
	
	private String getTrechoTamanho(int posicao, int tamanho) {
		return this.paginaStr.substring(posicao - tamanho, posicao);
	}
	
	
	public final ParserThread criaParse() {
		ParserThread parser = new ParserHtmlTh();
		parser.setCallback(this);
		return parser;
	}

	private CookieManager cookies = null;
	
	@Override
	public void setCookies(CookieManager cookies) {
		this.cookies = cookies;
	}
	@Override
	public CookieManager getCookies() {
		return this.cookies;
	}

	protected int getContadorLiAberto() {
		return this.contLi;
	}

	protected String getUtlUrl() {
		return ultUrl;
	}

	protected String getUtlUrl2() {
		return ultUrl2;
	}

	protected String getUtlUrl3() {
		return ultUrl3;
	}

	protected String getUltConteudo() {
		return (ultConteudo == null ? "" : ultConteudo);
	}

	protected String getUltConteudo2() {
		return (ultConteudo2 == null ? "" : ultConteudo2);
	}
	protected String getUltConteudo3() {
		return (ultConteudo3 == null ? "" : ultConteudo3);
	}
	protected String getUltConteudo4() {
		return (ultConteudo4 == null ? "" : ultConteudo4);
	}
	protected String getUltConteudo5() {
		return (ultConteudo5 == null ? "" : ultConteudo5);
	}
	protected String getUltConteudoComTexto() {
		return this.ultConteudoComTexto;
	}

	protected String getUltClasse() {
		return ultClasse;
	}

	protected String getUltClasse2() {
		return ultClasse2;
	}

	protected String getUltClasse3() {
		return ultClasse3;
	}

	protected HTML.Tag getUltTag() {
		return ultTag;
	}
	protected HTML.Tag getUltTag2() {
		return ultTag2;
	}
	
	protected MutableAttributeSet getUltAtributoTag() {
		return this.ultAtributoTag;
	}
	protected HTML.Tag getUltTagSimples() {
		return this.ultTagSimples;
	}

	protected String getUltImagem() {
		return this.ultImagem;
	}
	protected String getUltImagem2() {
		return this.ultImagem2;
	}
	protected String getUltImagem3() {
		return this.ultImagem3;
	}
	
	protected void setDebug() {
		this.debug = true;
	}

	protected void inicioTagImpl(Tag t, String classeNome, String idNome) {
		// TODO Auto-generated method stub
		
	}
	
	String bufferConteudo = null;
	public void handleText(char[] data, int pos) {
		String conteudo = String.copyValueOf(data);
		ultConteudo5 = ultConteudo4;
		ultConteudo4 = ultConteudo3;
		ultConteudo3 = ultConteudo2;
		ultConteudo2 = ultConteudo;
		ultConteudo = conteudo;
		if (conteudo.trim().length()>1) {
			ultConteudoComTexto = bufferConteudo;
			bufferConteudo = conteudo;
		}
		if (this.debug)
			System.out.println(pos + "-<dado>:" + conteudo);
	}

	protected void elementoSimples(HTML.Tag t, String nomeId, String nomeClasse, String conteudo) {
		if (this.debug)
			System.out.println("<elementoSimples>:" + t + "." + nomeClasse + "#" + nomeId + ":" + conteudo);
	}

	protected void inicioTag(HTML.Tag t, String classeNome, String idNome) {
		ultId = idNome;
		ultClasse3 = ultClasse2;
		ultClasse2 = ultClasse;
		ultClasse = classeNome;
		ultTag2 = ultTag;
		ultTag = t;
	}

	public void handleEndTag(HTML.Tag t, int pos) {
		if (HTML.Tag.LI == t) {
			this.contLi --;
		}
		if (HTML.Tag.SCRIPT == t) {
			this.inicioScript = pos;
			//System.out.println(this.getTrechoTamanho(pos + 20, 60));
			//System.out.println();
			this.contandoScript = true;
		//	this.listaScript.add(script);
		}
		if (ultConteudo != null) {
			elementoSimples(ultTag, ultId, ultClasse, ultConteudo);
		}
		if (this.debug)
			System.out.println(pos + "-<end>:" + t);
		
	}

	protected void script(String tipo, String texto) {
		
	}
	
	public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) {
		
		if (this.contandoScript) {
			String trecho = this.getTrecho(inicioScript, pos-9);
			this.contandoScript = false;
			//System.out.println("Tipo:" + this.ultTipoScript);
			//System.out.println("Script:" + trecho);
			//System.out.println("");
			this.script(this.ultTipoScript, trecho);
		}
		
		if (HTML.Tag.LI == t) {
			this.contLi ++;
		}
		
		if (HTML.Tag.SCRIPT == t) {
			//System.out.println("Atributos:" + this.scriptAtributos.getAttribute(HTML.Attribute.TYPE));
			this.ultTipoScript = (a.getAttribute(HTML.Attribute.TYPE)!=null?a.getAttribute(HTML.Attribute.TYPE).toString():null);
		}
		this.ultAtributoTag2  = this.ultAtributoTag;
		this.ultAtributoTag = a;
		String classeNome = ((a.getAttribute(HTML.Attribute.CLASS) != null) ? a.getAttribute(HTML.Attribute.CLASS).toString() : "");
		String idNome = ((a.getAttribute(HTML.Attribute.ID) != null) ? a.getAttribute(HTML.Attribute.ID).toString() : "");
		if (this.debug) {
			// System.out.print(pos + "-<inicio>:" + t);
			System.out.print(pos + "-<inicio>:" + t + "." + classeNome + "#" + idNome);
		}
		inicioTag(t, classeNome, idNome);
		inicioTagImpl(t,classeNome,idNome);
		if ((t == HTML.Tag.A) && (a.getAttribute(HTML.Attribute.HREF) != null)) {
			String urlCorrente = a.getAttribute(HTML.Attribute.HREF).toString();
			// trocas de url
			ultUrl3 = ultUrl2;
			ultUrl2 = ultUrl;
			ultUrl = urlCorrente;
			if (this.debug) {
				System.out.print(", Url:" + urlCorrente);
			}
			handleUrl(urlCorrente);
			String classeCorrente = ((a.getAttribute(HTML.Attribute.CLASS) != null) ? a.getAttribute(HTML.Attribute.CLASS).toString() : null);
			String tituloCorrente = ((a.getAttribute(HTML.Attribute.TITLE) != null) ? a.getAttribute(HTML.Attribute.TITLE).toString() : null);
			handleUrl(urlCorrente, classeCorrente, tituloCorrente, idNome);
		}
		if (t == HTML.Tag.IMG) {
			String imagem = (a.getAttribute(HTML.Attribute.SRC) != null ? a.getAttribute(HTML.Attribute.SRC).toString().trim() : null);
			if (this.debug) {
				System.out.print(", Imagem:" + imagem);
			}
			handleImagem(imagem);
		}
		if (this.debug)
			System.out.println();
	}

	public void handleSimpleTag(HTML.Tag t, MutableAttributeSet a, int pos) {
		this.ultTagSimples = t;
		if (this.debug) {
			System.out.print(pos + "-<simples>:" + t);
		}
		if (t == HTML.Tag.META) {
			String propriedade = (String) a.getAttribute("property");
			String conteudo = (String) a.getAttribute(HTML.Attribute.CONTENT);
			if (propriedade!=null) {
				if(this.debug) {
					System.out.print(pos + "<meta>:" + conteudo + "=" + propriedade);
				}
				meta(propriedade,conteudo);
			}
		}
		if (t == HTML.Tag.IMG) {
			handleImagem(a);
			String imagem = (a.getAttribute(HTML.Attribute.SRC) != null ? a.getAttribute(HTML.Attribute.SRC).toString().trim() : null);
			if (this.debug) {
				System.out.print(", Imagem:" + imagem);
			}
			handleImagem(imagem);
		}
		if (this.debug)
			System.out.println();
	}
	
	protected void meta(String propriedade, String conteudo) {
		
	}

	protected void handleImagem(MutableAttributeSet a) {

	}

	protected void handleImagem(String imagem) {
		ultImagem3 = ultImagem2;
		ultImagem2 = ultImagem;
		ultImagem = imagem;
	}

	protected void handleUrl(String url) {
	}

	protected void handleUrl(String url, String classe, String titulo, String id) {
	}
	

	public void antesLoop() {
	}
}

/*
 * Location: D:\Java-Recuperacao\webparse.jar Qualified Name:
 * br.com.digicom.parse.callback.CallbackParseHtml JD-Core Version: 0.6.0
 */