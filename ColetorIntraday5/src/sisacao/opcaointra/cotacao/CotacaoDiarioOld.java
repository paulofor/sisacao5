package sisacao.opcaointra.cotacao;

public class CotacaoDiarioOld {

	private float abertura;
	private float fechamento;
	private float maximo;
	private float minimo;
	private float volume;
	
	private int negocios;
	private String data;
	private String ticker;
	
	public CotacaoDiarioOld(String ticker) {
		this.ticker = ticker;
	}
	
	public float getAbertura() {
		return abertura;
	}
	public void setAbertura(float abertura) {
		this.abertura = abertura;
	}
	public float getFechamento() {
		return fechamento;
	}
	public void setFechamento(float fechamento) {
		this.fechamento = fechamento;
	}
	public float getMaximo() {
		return maximo;
	}
	public void setMaximo(float maximo) {
		this.maximo = maximo;
	}
	public float getMinimo() {
		return minimo;
	}
	public void setMinimo(float minimo) {
		this.minimo = minimo;
	}
	public float getVolume() {
		return volume;
	}
	public void setVolume(float volume) {
		this.volume = volume;
	}
	public int getNegocios() {
		return negocios;
	}
	public void setNegocios(int negocios) {
		this.negocios = negocios;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	
	public String toString() {
		return this.ticker + ": " + this.fechamento + " ( " + this.negocios + " )";
	}
	
}
