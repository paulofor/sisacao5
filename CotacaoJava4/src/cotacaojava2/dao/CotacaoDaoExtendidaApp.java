package cotacaojava2.dao;

import br.com.digicom.cotacao.dao.CotacaoDaoExtendida;
import br.com.digicom.cotacao.handle.CotacaoManipulador;
import br.com.digicom.cotacao.vo.Cotacao;
import br.com.digicom.lib.dao.DaoException;

public class CotacaoDaoExtendidaApp extends CotacaoDaoExtendida {
	public CotacaoDaoExtendidaApp() {
		super(new DataSourceCotacao());
	}

	public void CriaTabelaSeNecessario(String nomeTabela) throws DaoException {
		String sql = "create table if not exists " + nomeTabela + " ( "
				+ " id integer unsigned not null auto_increment, "
				+ " neg integer unsigned, " + " data date, "
				+ " ult decimal(6,2), " + " hora_real time, "
				+ " hora_neg time, " + " PRIMARY KEY (id) " + " ) "
				+ " ENGINE = MYISAM;";
		executaSql(sql);
	}

	protected String getSqlInsert(Cotacao cotacao) {
		StringBuffer saida = new StringBuffer("Insert into ");
		saida.append(cotacao.getTicker()).append(" ");
		saida.append("(ult, hora_neg, hora_real, neg, data)");
		saida.append(" Values ");
		saida.append("( ").append(CotacaoManipulador.valor(cotacao.getUlt()))
				.append(", ");
		if (cotacao.getHoraNegocio()==null || cotacao.getHoraNegocio().length() <= 3)
			saida.append("'00:00:00', ");
		else
			saida.append("'").append(cotacao.getHoraNegocio()).append("'").append(", ");
		saida.append("'").append(cotacao.getHoraReal()).append("'")	.append(", ");
		saida.append(CotacaoManipulador.qtde(cotacao.getNeg())).append(", ");
		saida.append("'").append(CotacaoManipulador.data_hoje()).append("'");

		saida.append(")");

		return saida.toString();
	}
}

/*
 * Location: D:\Java-Recuperacao\CotacaoJava2.jar Qualified Name:
 * cotacaojava2.dao.CotacaoDaoExtendidaApp JD-Core Version: 0.6.0
 */