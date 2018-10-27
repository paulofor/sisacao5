package coletorjava.regracolecao.impl;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.log.DatasUtils;
import coletorjava.dao.PeriodoPregaoDao;
import coletorjava.modelo.PeriodoPregao;
import coletorjava.regracolecao.PeriodoPregaoRegraColecao;


public  class PeriodoPregaoRegraColecaoImpl  extends PeriodoPregaoRegraColecao {

	@Override
	public PeriodoPregao PesquisaPorDia(DaoConexao conexao) throws DaoException {
		PeriodoPregao periodo = null;
		getFiltro().validaDataPesquisa();
		PeriodoPregaoDao dao = getDao(conexao);
		String data = DatasUtils.converteDD_MM_AAAA2AAAA_MM_DD(getFiltro().getDataPesquisa());
		periodo = dao.obtemPorDiaAAAAMMDD(data);
		return periodo;
	} 
}
