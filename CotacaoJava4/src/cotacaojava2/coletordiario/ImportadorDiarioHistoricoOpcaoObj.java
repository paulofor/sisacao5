package cotacaojava2.coletordiario;

import java.util.HashSet;
import java.util.Set;

import br.com.digicom.cotacao.dao.CotacaoDiarioDao;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.util.ArquivoLog;
import cotacaojava2.dao.DBB;
import cotacaojava2.regracolecao.CotacaoDiarioRegraColecaoImpl;
import cotacaojava2.webservice.OpcaoSisacaoFiltro;
import cotacaojava2.webservice.OpcaoSisacaoObjetoWs;
import cotacaojava2.webservice.OpcaoSisacaoWSLocator;
import cotacaojava2.webservice.OpcaoSisacaoWSSoap;

public class ImportadorDiarioHistoricoOpcaoObj {
	private OpcaoSisacaoWSLocator locatorOpcaoSisacao = new OpcaoSisacaoWSLocator();

	public void main(String dataDD_MM_AAAA) {
		ArquivoLog.getInstancia().setArquivo("ImportadorDiarioOpcao.log");
		try {
			OpcaoSisacaoFiltro filtro = new OpcaoSisacaoFiltro();
			filtro.setDataAtivo(dataDD_MM_AAAA);
			OpcaoSisacaoWSSoap servico = this.locatorOpcaoSisacao.getOpcaoSisacaoWSSoap();
			OpcaoSisacaoObjetoWs[] listaAtivos = servico.listaAtivoOpcao(filtro);
			verificaTabelas(listaAtivos);

			CotacaoDiarioRegraColecaoImpl servico2 = new CotacaoDiarioRegraColecaoImpl();

			servico2.leArquivoDiarioOpcao("download/BDIN", obtemListaTicker(listaAtivos), dataDD_MM_AAAA);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Set obtemListaTicker(OpcaoSisacaoObjetoWs[] listaAtivos) {
		Set lista = new HashSet();
		for (int i = 0; i < listaAtivos.length; i++) {
			lista.add(listaAtivos[i].getCodigoMercado());
		}
		return lista;
	}

	private void verificaTabelas(OpcaoSisacaoObjetoWs[] listaAtivos) {
		CotacaoDiarioDao dao = DBB.getInstancia().getCotacaoDiarioOpcaoDao();
		try {
			DaoConexao conexao = dao.criaConexao();
			dao.setConexao(conexao);
			for (int i = 0; i < listaAtivos.length; i++) {
				try {
					dao.CriaTabelaSeNecessario(listaAtivos[i].getCodigoMercado());
				} catch (DaoException e) {
					ArquivoLog.getInstancia().salvaErro(e);
					ArquivoLog.getInstancia().salvaLog("Erro com : " + listaAtivos[i].getCodigoMercado());
				}
			}
			dao.liberaConexao(conexao);
		} catch (Exception e) {
			ArquivoLog.getInstancia().salvaLog("Exception em verificaTabelas:" + e.getMessage());
			e.printStackTrace();
		}
	}
}
