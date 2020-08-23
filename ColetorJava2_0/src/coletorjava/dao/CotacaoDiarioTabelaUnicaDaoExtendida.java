package coletorjava.dao;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import coletorjava.dao.basica.CotacaoDiarioTabelaUnicaDaoBase;
import coletorjava.dao.basica.DataSource2019;
import coletorjava.modelo.CotacaoDiario;

public class CotacaoDiarioTabelaUnicaDaoExtendida  extends CotacaoDiarioTabelaUnicaDaoBase implements CotacaoDiarioTabelaUnicaDao{

	
	public CotacaoDiarioTabelaUnicaDaoExtendida() {
		super(new DataSource2019());
	}
	
	@Override
	protected MontadorDaoI criaMontadorPadrao() {
		throw new UnsupportedOperationException();
	}
	
	public void insereDiarioAcao(CotacaoDiario cotacao) throws DaoException {
		String sql = "insert into CotacaoDiarioAcao " +
				"( ticker, data, volume, negocios, fechamento, maximo, minimo, abertura ) " +
				" values " + valoresInsert(cotacao);
		this.executaSql(sql);

	}
	
	private String valoresInsert(CotacaoDiario item) {
		return " ( '" + item.getNomeTicker() + "'  " 
		+ " ," + (item.getData()==null?"null":"'" + DCConvert.AAAAMMDD2AAAA_MM_DD(item.getData()) ) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getVolume()) + "'  "
		+ " ,'" + item.getNegocios() + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getFechamentoOriginal()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getMaximoOriginal()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getMinimoOriginal()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getAberturaOriginal()) + "'  "
		+ " ) ";
	}

}
