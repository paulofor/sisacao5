package coletorjava.dao;

import br.com.digicom.lib.dao.DaoException;
import coletorjava.dao.basica.DataSourceOnline;
import coletorjava.dao.basica.PeriodoPregaoDaoBase;
import coletorjava.modelo.PeriodoPregao;

public class PeriodoPregaoDaoExtendida extends PeriodoPregaoDaoBase implements PeriodoPregaoDao {

	public PeriodoPregaoDaoExtendida() {
		super(new DataSourceOnline());
	}

	@Override
	public PeriodoPregao obtemPorDiaAAAAMMDD(String data) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() + " where data_inicio_periodo <= '" + data + "' and data_termino_periodo >= '"
				+ data + "' ";
		return (PeriodoPregao) getObjeto(sql);
	}
}
