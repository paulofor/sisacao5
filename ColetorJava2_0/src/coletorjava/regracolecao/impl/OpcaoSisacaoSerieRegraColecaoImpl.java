package coletorjava.regracolecao.impl;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.log.DatasUtils;
import coletorjava.dao.OpcaoSisacaoSerieDao;
import coletorjava.modelo.CotacaoDiario;
import coletorjava.modelo.FabricaVo;
import coletorjava.modelo.MesAno;
import coletorjava.modelo.OpcaoSisacaoSerie;
import coletorjava.regracolecao.OpcaoSisacaoSerieRegraColecao;

public class OpcaoSisacaoSerieRegraColecaoImpl extends OpcaoSisacaoSerieRegraColecao {

	@Override
	public OpcaoSisacaoSerie ObtemCriaSeNecessario(DaoConexao conexao) throws DaoException {
		getFiltro().validaMesAnoBd();

		String dataMesAno = this.getFiltro().getMesAnoBd();
		OpcaoSisacaoSerieDao dao = getDao();
		dao.setConexao(conexao);
		OpcaoSisacaoSerie pesquisa = dao.ObtemPorMesAno(dataMesAno);
		if (pesquisa != null) {
			return pesquisa;
		} else {
			getFiltro().validaVencimento();
			OpcaoSisacaoSerie novo = FabricaVo.criaOpcaoSisacaoSerie();
			String mesAno = DatasUtils.converteAAAA_MM_DD2DD_MM_AAAA(dataMesAno);
			novo.setMesAno(mesAno);
			novo.setDataInicioColeta(this.calculaInicioColeta(mesAno));
			novo.setLetra(this.letraOpcao(mesAno));
			novo.setDataVencimento(this.getFiltro().getVencimento());
			dao.insereItem(novo);
			return novo;
		}
	}

	private String calculaInicioColeta(String mesAno) {
		String mes = mesAno.substring(3, 5);
		String ano = mesAno.substring(6);
		int anoNum = Integer.parseInt(ano);
		int anoAnterior = anoNum - 1;
		if ("01".equals(mes))
			return "20-11-" + anoAnterior;
		if ("02".equals(mes))
			return "20-12-" + anoAnterior;
		if ("03".equals(mes))
			return "20-01-" + anoNum;
		if ("04".equals(mes))
			return "20-02-" + anoNum;
		if ("05".equals(mes))
			return "20-03-" + anoNum;
		if ("06".equals(mes))
			return "20-04-" + anoNum;
		if ("07".equals(mes))
			return "20-05-" + anoNum;
		if ("08".equals(mes))
			return "20-06-" + anoNum;
		if ("09".equals(mes))
			return "20-07-" + anoNum;
		if ("10".equals(mes))
			return "20-08-" + anoNum;
		if ("11".equals(mes))
			return "20-09-" + anoNum;
		if ("12".equals(mes))
			return "20-10-" + anoNum;
		return null;
	}

	private String letraOpcao(String mesAno) {
		// DD-MM-AAAA
		// 0123456789
		String mes = mesAno.substring(3, 5);
		if ("01".equals(mes))
			return "A";
		if ("02".equals(mes))
			return "B";
		if ("03".equals(mes))
			return "C";
		if ("04".equals(mes))
			return "D";
		if ("05".equals(mes))
			return "E";
		if ("06".equals(mes))
			return "F";
		if ("07".equals(mes))
			return "G";
		if ("08".equals(mes))
			return "H";
		if ("09".equals(mes))
			return "I";
		if ("10".equals(mes))
			return "J";
		if ("11".equals(mes))
			return "K";
		if ("12".equals(mes))
			return "L";
		return null;
	}

	@Override
	public OpcaoSisacaoSerie ObtemOuCriaPorCotacaoDiario(DaoConexao conexao) throws DaoException {
		getFiltro().validaCotacaoDiario();
		CotacaoDiario cotacao = getFiltro().getCotacaoDiario();
		String mesAno = cotacao.getMesAnoOpcao();
		getFiltro().setMesAnoBd(cotacao.getMesAnoOpcao());
		getFiltro().setVencimento(cotacao.getDataVencimento());
		return this.ObtemCriaSeNecessario(conexao);
	}

	@Override
	public List<OpcaoSisacaoSerie> SeriesAtivasPorData(DaoConexao conexao) throws DaoException {
		String data = getFiltro().validaData();
		data = DatasUtils.converteDD_MM_AAAA2AAAA_MM_DD(data);
		OpcaoSisacaoSerieDao dao = getDao(conexao);
		return dao.SerieAtivasPorData(data);
	}

	@Override
	public List<OpcaoSisacaoSerie> ListaPorAno(DaoConexao conexao) throws DaoException {
		OpcaoSisacaoSerieDao dao = getDao(conexao);
		long ano = this.getFiltro().getAnoPesquisa();
		String dataInicialBd = ano + "-01-01";
		String dataFinalBd = ano + "-12-31";
		List<OpcaoSisacaoSerie> lista = dao.ListaPorDatas(dataInicialBd, dataFinalBd);
		return lista;
	}

	@Override
	public OpcaoSisacaoSerie ObtemPorMesAnoEstudo(DaoConexao conexao) throws DaoException {
		MesAno referencia = getFiltro().validaMesAnoEstudo();
		long mesPesquisa = referencia.getNumeroMes() + 1;
		long anoPesquisa = referencia.getNumeroAno();
		if (mesPesquisa==13) {
			mesPesquisa = 1;
			anoPesquisa++;
		}
		String dataBd = anoPesquisa + "-" + String.format("%02d", mesPesquisa) + "-01";
		OpcaoSisacaoSerieDao dao = getDao(conexao);
		OpcaoSisacaoSerie serie = dao.ObtemPorMesAno(dataBd);
		return serie;
	}

	

}
