package br.com.digicom.cotacao.dao;

import br.com.digicom.cotacao.handle.CotacaoManipulador;
import br.com.digicom.cotacao.vo.Cotacao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;

public class CotacaoDaoExtendida extends CotacaoDaoBase implements CotacaoDao {
	public CotacaoDaoExtendida(DataFonte dataSource) {
		super(dataSource);
	}

	public void CriaTabelaSeNecessario(String nomeTabela) throws DaoException {
		String sql = "create table if not exists "
				+ nomeTabela
				+ " ( "
				+ " id_opcao_cotacao integer unsigned not null auto_increment, "
				+ " neg integer unsigned, " + " data date, "
				+ " ult decimal(6,2), " + " ultstr varchar(10), "
				+ " hora_real time, " + " hora_neg time, "
				+ " PRIMARY KEY (id_opcao_cotacao) " + " ) "
				+ " ENGINE = MYISAM;";
		executaSql(sql);
	}

	public Cotacao obtemMaisRecente(String nomeTicker) throws DaoException {
		String sql = "select " + camposOrdenadosAlias("ativo1") + " from "
				+ nomeTicker + " as ativo1 where "
				+ " data = (select max(data) from " + nomeTicker + ") "
				+ " and hora_real = (select max(hora_real) from " + nomeTicker
				+ " where ativo1.data = " + nomeTicker + ".data) ";
		return (Cotacao) getObjeto(sql);
	}

	public void testaTabela(String nomeTicker) throws DaoException {
		String sql = "select * from " + nomeTicker + " limite 1,1";
		executaSqlForcado(sql);
	}

	public void insereCotacao(Cotacao cotacao, String nomeTicker)
			throws DaoException {
		cotacao.setTicker(nomeTicker);
		String sql = getSqlInsert(cotacao);
		if (sql!=null)
			executaSqlForcado(sql);
	}

	protected String getSqlInsert(Cotacao cotacao) {
		if (cotacao.getHoraNegocio()==null) return null;
		if ("NaN".equals(cotacao.getUlt())) return null;
		StringBuffer saida = new StringBuffer("Insert into ");
		saida.append(cotacao.getTicker()).append(" ");
		saida.append("(ult, hora_neg, hora_real, neg, data, ultstr)");
		saida.append(" Values ");
		saida.append("( ").append(CotacaoManipulador.valor(cotacao.getUlt()))
				.append(", ");
		if (cotacao.getHoraNegocio().length() <= 3)
			saida.append("'00:00:00', ");
		else
			saida.append("'").append(cotacao.getHoraNegocio()).append("'").append(", ");
		saida.append("'").append(cotacao.getHoraReal()).append("'").append(", ");
		saida.append(CotacaoManipulador.qtde(cotacao.getNeg())).append(", ");
		saida.append("'").append(CotacaoManipulador.data_hoje()).append("'").append(", ");
		saida.append("'").append(cotacao.getUlt()).append("'").append(")");

		return saida.toString();
	}
}

/*
 * Location: D:\Java-Recuperacao\coletorcotacao.jar Qualified Name:
 * br.com.digicom.cotacao.dao.CotacaoDaoExtendida JD-Core Version: 0.6.0
 */