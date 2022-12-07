package sisacao.deeplearning.desenvolvimento.processamento;

import java.util.List;

import br.com.digicom.sisacao.modelo.DiaPregao;
import br.inf.digicom.loopback.DaoBase;
import sisacao.deeplearning.desenvolvimento.dao.DaoBasePrevisao;
import sisacao.deeplearning.desenvolvimento.dao.DatasetResultadoPrevisao;

public class TrataPrevisaoDiaTreino  extends DaoBasePrevisao{

	@Override
	protected void executaImpl() {
		final DatasetResultadoPrevisao ds = (DatasetResultadoPrevisao) getComum();
		List<DiaPregao> listaDia = ds.getListaDiaPrevisao();
	}

	@Override
	protected DaoBase getProximo() {
		// TODO Auto-generated method stub
		return null;
	}

}
