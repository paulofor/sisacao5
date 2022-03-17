package br.inf.digicom.loopback;

import com.strongloop.android.loopback.RestAdapter;

import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.com.digicom.sisacao.repositorio.RepositorioDiaPregao;
import br.com.digicom.sisacao.repositorio.RepositorioExemploTreinoAcao;
import br.com.digicom.sisacao.repositorio.RepositorioRegraProjecao;
import br.inf.digicom.Constantes;



public abstract class DaoBase {

	
	private RestAdapter adapter = new RestAdapter(Constantes.UrlLoopback); 
	protected RepositorioDiaPregao repDiaPregao = adapter.createRepository(RepositorioDiaPregao.class);
	protected RepositorioRegraProjecao repRegraProjecao = adapter.createRepository(RepositorioRegraProjecao.class);
	protected RepositorioExemploTreinoAcao repExemploTreino = adapter.createRepository(RepositorioExemploTreinoAcao.class);
	protected final RepositorioAcaoBase.AtivoAcaoRepository repAcao = 
			adapter.createRepository(RepositorioAcaoBase.AtivoAcaoRepository.class);
	
	private DatasetComum comum = null;
	
	
	private boolean concluido = false;
	public void executa() {
		this.concluido = false;
		executaImpl();
	}
	protected abstract void executaImpl();
	public boolean getConcluido() {
		return this.concluido;
	}
	
	protected void setConcluido() {
		this.concluido = true;
	}
	
	
	protected void onError(Throwable t) {
		System.out.println("Erro[" + this + "] : " + t.getMessage());
		this.concluido = true;
	}

	public DatasetComum getComum() {
		return comum;
	}

	public void setComum(DatasetComum comum) {
		this.comum = comum;
	}
}
