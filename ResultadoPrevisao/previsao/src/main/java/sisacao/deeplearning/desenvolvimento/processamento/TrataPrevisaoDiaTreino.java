package sisacao.deeplearning.desenvolvimento.processamento;

import java.util.ArrayList;
import java.util.List;

import br.com.digicom.sisacao.modelo.Ativo;
import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.modelo.PrevisaoRede;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.comum.ativoacao.CotacaoDiarioAcao_ListaTickerDia;
import sisacao.deeplearning.comum.TradeI;
import sisacao.deeplearning.desenvolvimento.dao.DaoBasePrevisao;
import sisacao.deeplearning.desenvolvimento.dao.DatasetResultadoPrevisao;

public class TrataPrevisaoDiaTreino  extends DaoBasePrevisao{

	@Override
	protected void executaImpl() {
		final DatasetResultadoPrevisao ds = (DatasetResultadoPrevisao) getComum();
		List<DiaPregao> listaDia = ds.getListaDiaPrevisao();
		for (DiaPregao dia : listaDia) {
			System.out.println();
			System.out.println(" *** " + dia.getDiaNum() + " *** ");
			List<Ativo> listaAtivo = new ArrayList<Ativo>();
			for (PrevisaoRede previsao : dia.getPrevisaoRedes()) {
				AtivoAcao ativo = new AtivoAcao();
				ativo.setTicker(previsao.getTicker());
				listaAtivo.add(ativo);
			}
			for (TradeI trade : ds.getListaTradeAberto()) {
				AtivoAcao ativo = new AtivoAcao();
				ativo.setTicker(trade.getTicker());
				listaAtivo.add(ativo);
			}
			ds.setListaTicker(listaAtivo);
			ds.setDiaNum(dia.getDiaNum());
			ds.setListaPrevisaoExecucao(dia.getPrevisaoRedes());
			executaProximoSemFinalizar();
		}
		finalizar();
	}
	
	

	@Override
	protected DaoBase getProximo() {
		return new CotacaoDiarioAcao_ListaTickerDia();
	}

}
