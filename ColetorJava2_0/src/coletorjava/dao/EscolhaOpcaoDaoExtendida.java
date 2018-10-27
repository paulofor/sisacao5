package coletorjava.dao;


import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.MontadorDaoComposite;
import coletorjava.dao.basica.EscolhaOpcaoDaoBase;
import coletorjava.dao.basica.OpcaoSisacaoDaoBase;
import coletorjava.dao.montador.EscolhaOpcaoMontador;
import coletorjava.dao.montador.OpcaoSisacaoMontador;
import coletorjava.modelo.EscolhaOpcao;


public  class EscolhaOpcaoDaoExtendida  extends EscolhaOpcaoDaoBase implements EscolhaOpcaoDao {

	@Override
	public List ListaCorrenteAgrupada() throws DaoException {
		throw new RuntimeException("Metodo nao implementado");
	}

	@Override
	public List ListaPorTickerReferenteA(long idItem) throws DaoException {
		throw new RuntimeException("Metodo nao implementado");
	}

	@Override
	public List ListaPorOpcaoSisacaoEscolha(long idItem) throws DaoException {
		throw new RuntimeException("Metodo nao implementado");
	}


	@Override
	public EscolhaOpcao obtemPorTickerDia(long idTicker, long idDia) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where id_ticker_ra = " + idTicker + " and id_dia_pregao_ra = " + idDia;
		return (EscolhaOpcao) this.getObjeto(sql);
	}

	@Override
	public List ListaPorDiaPregaoReferenteA(long idItem) throws DaoException {
		throw new RuntimeException("Metodo não implementado.");
	}

	@Override
	public EscolhaOpcao ObtemPorIdTickerDiaComOpcao(long codigoTickerReferenteA, long codigoDiaPregaoReferenteA) throws DaoException {
		String sql = "select " + camposOrdenados() + " , " +
				OpcaoSisacaoDaoBase.camposOrdenados() +
				" from " + tabelaSelect() +
				this.innerJoinOpcaoSisacao_Escolha() +
				" where id_ticker_ra = " + codigoTickerReferenteA + " and escolha_opcao.id_dia_pregao_ra = " + codigoDiaPregaoReferenteA;
		MontadorDaoComposite montador = new MontadorDaoComposite();
		montador.adicionaMontador(new EscolhaOpcaoMontador(), "");
		montador.adicionaMontador(new OpcaoSisacaoMontador(), "OpcaoSisacao_Escolha");
		this.setMontador(montador);
		return (EscolhaOpcao) this.getObjeto(sql);
	} 
}
