package cotacaojava2.dao;

import br.com.digicom.cotacao.dao.CotacaoDiarioDaoExtendida;
import br.com.digicom.cotacao.vo.CotacaoDiario;
import br.com.digicom.cotacao.vo.CotacaoDiarioOpcao;
import br.com.digicom.lib.dao.DaoException;

public class CotacaoDiarioOpcaoDaoExtendidaApp extends
		CotacaoDiarioDaoExtendida {
	public CotacaoDiarioOpcaoDaoExtendidaApp() {
		super(new DataSourceCotacaoOpcaoDiario());
	}

	public void CriaTabelaSeNecessario(String nomeTabela) throws DaoException {
		String sql = "create table if not exists "
				+ nomeTabela
				+ "_DIARIO"
				+ " ( "
				+ " id_cotacao_diario integer unsigned not null auto_increment,"
				+ " abertura_original decimal(7,2),"
				+ " maximo_original decimal(7,2),"
				+ " minimo_original decimal(7,2),"
				+ " fechamento_original decimal(7,2),"
				+ " abertura_corrigido decimal(7,3),"
				+ " maximo_corrigido decimal(7,3),"
				+ " minimo_corrigido decimal(7,3),"
				+ " fechamento_corrigido decimal(7,3),"
				+ " negocios integer unsigned," + " volume decimal(14,2),"
				+ " data date," + " preco_exercicio decimal(7,2),"
				+ " PRIMARY KEY (id_cotacao_diario), "
				+ " INDEX `data_idx`(`data`) " + " )" + " ENGINE = MYISAM;";
		executaSql(sql);
	}

	protected String getSqlInsert(CotacaoDiario cotacaoObj) {
		CotacaoDiarioOpcao cotacao = (CotacaoDiarioOpcao) cotacaoObj;
		StringBuffer saida = new StringBuffer("Insert into ");
		saida.append(cotacao.getTicker() + "_DIARIO").append(" ");
		saida.append("(abertura_original, maximo_original, minimo_original, fechamento_original,abertura_corrigido, maximo_corrigido, minimo_corrigido, fechamento_corrigido, negocios, volume, preco_exercicio, data )");
		saida.append(" Values ( ");
		saida.append(cotacao.getAbertura() + " , ");
		saida.append(cotacao.getMaximo() + " , ");
		saida.append(cotacao.getMinimo() + " , ");
		saida.append(cotacao.getFechamento() + " , ");
		saida.append(cotacao.getAbertura() + " , ");
		saida.append(cotacao.getMaximo() + " , ");
		saida.append(cotacao.getMinimo() + " , ");
		saida.append(cotacao.getFechamento() + " , ");
		saida.append(cotacao.getNegocios() + " , ");
		saida.append(cotacao.getVolumeStr() + " , ");
		saida.append(cotacao.getPrecoExercicio() + " , ");
		saida.append("'" + cotacao.getDataBd() + "' )");
		return saida.toString();
	}
}

/*
 * Location: D:\Java-Recuperacao\CotacaoJava2.jar Qualified Name:
 * cotacaojava2.dao.CotacaoDiarioOpcaoDaoExtendidaApp JD-Core Version: 0.6.0
 */