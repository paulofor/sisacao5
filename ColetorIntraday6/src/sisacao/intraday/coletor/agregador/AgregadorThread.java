package sisacao.intraday.coletor.agregador;

public interface AgregadorThread {

	void limpaColetoresAtual();

	void disparaColetoresDia(String novoDia);

}
