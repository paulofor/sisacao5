package gerador.insereexemplotreinoacaosaida.passo;


import gerador.insereexemplotreinoacaosaida.loopback.DaoAplicacao;
import gerador.insereexemplotreinoacaosaida.loopback.DatasetAplicacao;
import gerador.insereexemplotreinoacaosaida.passo.impl.*;
import br.com.gersis.daobase.DaoBase;
import br.com.gersis.daobase.IDatasetComum;

public class InsereExemploTreinoAcaoSaidaObj extends DaoAplicacao { 

	@Override
	protected void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		RegraProjecao_ProximoParaProcessamento exec = new RegraProjecao_ProximoParaProcessamentoImpl();
		exec.setComum(ds);
		exec.executa();
		executaFinalizacao(ds);
		finalizar();
	}
	private void executaFinalizacao(DatasetAplicacao ds) {
		DaoBase finalizacao1 = new RegraProjecao_FinalizaInsercaoImpl();
		finalizacao1.setComum(ds);
		finalizacao1.executa();
	}
	public int getNumPasso() {
		return 1;
	}
}

