package sisacao.fii.parser.callback;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.swing.text.html.HTML.Tag;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.CallbackParseHtml;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.modelo.AluguelFundoImobiliario;
import br.com.digicom.sisacao.modelo.FundoImobiliario;
import sisacao.fii.parser.FundoImobiliarioFacade;
import sisacao.fii.parser.dado.AluguelFIIDado;

public class AluguelFIIBrasilDetalheCallback extends CallbackParseHtml{

	private AluguelFIIDado aluguelDado;
	private FundoImobiliarioFacade facade = new FundoImobiliarioFacade();
	
	@Override
	public URL getUrl() throws MalformedURLException {
		String url = "https://fiibrasil.com/fundo/" + this.aluguelDado.getFundo().getTicker().toLowerCase();
		return new URL(url);
	}

	@Override
	public void setDados(IDadosParse paramIDadosParse) {
		this.aluguelDado = (AluguelFIIDado) paramIDadosParse;
	}
	
	
	private boolean ligaColeta = false;
	private boolean ligaDado = false;
	private int coluna = 0;
	private int linha = 2;
	
	private String dataPagamento;
	private String valor;
	private String dataCom;
	private String tipo;
	private String cotacao;
	private String percentual;
	

	@Override
	protected void inicioTagImpl(Tag t, String classeNome, String idNome) {
		if (this.ligaColeta && classeNome.indexOf("row-2")!=-1) {
			this.ligaDado = true;
		}
		if ("tablepress-14".equals(idNome.trim())) {
			this.ligaColeta = true;
		}
		if (ligaColeta && ligaDado && "column-12".equals(classeNome.trim())) {
			//System.out.println("Final: " + conteudo);
			this.finalizaAluguel();
		}
	}

	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		if (ligaColeta && ligaDado) {
			String conteudo = String.copyValueOf(data);
			if ("column-2".equals(this.getUltClasse().trim())) {
				// Valor (R$)
				//System.out.println("valor: " + conteudo);
				valor = conteudo;
			}
			if ("column-3".equals(this.getUltClasse().trim())) {
				// Dividendos
				//System.out.println("percentual: " + conteudo);
				percentual = conteudo;
			}
			if ("column-4".equals(this.getUltClasse().trim())) {
				// Data com
				//System.out.println("dataCom: " + conteudo);
				dataCom = conteudo;
			}
			if ("column-5".equals(this.getUltClasse().trim())) {
				// Pagamento
				//System.out.println("dataPagamento: " + conteudo);
				dataPagamento = conteudo;
			}
			if ("column-6".equals(this.getUltClasse().trim())) {
				// Cotação
				//System.out.println("cotacao: " + conteudo);
				//cotacao = conteudo;
			}
			if ("column-7".equals(this.getUltClasse().trim())) {
				// Tipo
				//System.out.println("tipo: " + conteudo);
				cotacao = conteudo;
			}
			if ("column-8".equals(this.getUltClasse().trim())) {
				// Mês
				tipo = conteudo;
				//System.out.println("Rendimento: " + conteudo);
			}
			if ("column-9".equals(this.getUltClasse().trim())) {
				// Ano
				//System.out.println("Rendimento: " + conteudo);
			}
			if ("column-10".equals(this.getUltClasse().trim())) {
				// Dia
				//System.out.println("Rendimento: " + conteudo);
			}
			if ("column-11".equals(this.getUltClasse().trim())) {
				// M
				//System.out.println("Rendimento: " + conteudo);
				this.finalizaAluguel();
			}
			if ("column-12".equals(this.getUltClasse().trim())) {
				System.out.println("Final: " + conteudo);
				
			}
			//System.out.println();
		}
	}
	
	
	

	private void finalizaAluguel() {
		AluguelFundoImobiliario aluguel = new AluguelFundoImobiliario();
		aluguel.setPercentual(getPercentual(this.percentual));
		aluguel.setCotacao(getMoeda(this.cotacao));
		aluguel.setDataCom(getData(this.dataCom));
		aluguel.setDataPagamento(getData(this.dataPagamento));
		aluguel.setTipo(this.tipo);
		aluguel.setTicker(this.aluguelDado.getFundo().getTicker());
		aluguel.setValor(getMoeda(this.valor));
		aluguelDado.addAluguel(aluguel);
	}
	
	private Double getPercentual(String percentual) {
		if (percentual==null) return 0D;
		String num = percentual.trim();
		num = num.replace("%", "");
		num = num.replace(',', '.');
		try {
			return Double.valueOf(num);
		} catch (Exception e) {
			e.printStackTrace();
			return 0D;
		}
	}
	private Double getMoeda(String valor) {
		if (valor==null) return 0D;
		String num = valor.trim();
		num = num.replace("$", "");
		num = num.replace("R", "");
		num = num.replace(".", "");
		num = num.replace(',', '.');
		return Double.valueOf(num);
	}
	private String getData(String valor) {
		return valor;
	}
	
	
	@Override
	public void finalizacaoErro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizacaoOk() throws DaoException {

		aluguelDado.finaliza();
	}

	@Override
	public void inicializacao() {
		// TODO Auto-generated method stub
		//this.setDebug();
	}

	@Override
	public boolean getLoop() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPost() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List camposPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCharSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URL getJsonUrl() throws MalformedURLException {
		// TODO Auto-generated method stub
		return null;
	}

}
