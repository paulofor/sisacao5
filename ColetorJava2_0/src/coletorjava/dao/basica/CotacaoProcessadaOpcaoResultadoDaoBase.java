package coletorjava.dao.basica;

import java.util.List;

import coletorjava.dao.montador.*;
import coletorjava.modelo.CotacaoProcessadaOpcaoResultado;
import coletorjava.regracolecao.filtro.CotacaoProcessadaOpcaoResultadoFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class CotacaoProcessadaOpcaoResultadoDaoBase extends DaoAplicacao implements CotacaoProcessadaOpcaoResultadoDaoBaseI {
	
	
	public CotacaoProcessadaOpcaoResultadoDaoBase() {
		super();
	}
	public CotacaoProcessadaOpcaoResultadoDaoBase(DataFonte dataSource) {
		super(dataSource);
	}
	protected String ConsultaJoin() {
		String tabelas;
		tabelas = tabelaSelect();
		return tabelas;
	}
	protected String CamposSelectJoin() {
		String select;
		select = camposOrdenados();
		return select;
	}
	protected  MontadorDaoI criaMontadorPadrao() {
		return new CotacaoProcessadaOpcaoResultadoMontador();
	}
	public static String tabelaSelect() {
		return " cotacao_processada_opcao_resultado" ;
	}
	public  String orderByLista() {
		return orderBy();
	}
	public String getLimite() {
		return "";
	}
	public  String whereLista() {
		return "";
	}
	public  String whereListaConcatenado() {
		return "";
	}
	public   static String orderBy() {
		return " order by " + tabelaSelect() + ".id_cotacao_processada_opcao_resultado " ;
	}
	
	
	public static String camposOrdenados() {
		return " cotacao_processada_opcao_resultado.id_cotacao_processada_opcao_resultado " 
		+ " , DATE_FORMAT(cotacao_processada_opcao_resultado.data,'%d-%m-%Y') " 
		+ " , DATE_FORMAT(cotacao_processada_opcao_resultado.hora_serie_temporal,'%H:%i') " 
		+ " ,cotacao_processada_opcao_resultado.contador_dia " 
		+ " ,cotacao_processada_opcao_resultado.codigo_mercado_opcao " 
		+ " ,cotacao_processada_opcao_resultado.valor_opcao " 
		+ " ,cotacao_processada_opcao_resultado.resultado_t70_s60 " 
		+ " ,cotacao_processada_opcao_resultado.resultado_t60_s60 " 
		+ " ,cotacao_processada_opcao_resultado.resultado_t50_s60 " 
		+ " ,cotacao_processada_opcao_resultado.resultado_t40_s60 " 
		+ " ,cotacao_processada_opcao_resultado.resultado_t70_s50 " 
		+ " ,cotacao_processada_opcao_resultado.resultado_t60_s50 " 
		+ " ,cotacao_processada_opcao_resultado.resultado_t50_s50 " 
		+ " ,cotacao_processada_opcao_resultado.resultado_t40_s50 " 
		+ " ,cotacao_processada_opcao_resultado.valor_saida_t40_s60 " 
		+ " ,cotacao_processada_opcao_resultado.valor_saida_t50_s60 " 
		+ " ,cotacao_processada_opcao_resultado.valor_saida_t60_s60 " 
		+ " ,cotacao_processada_opcao_resultado.valor_saida_t70_s60 " 
		+ " ,cotacao_processada_opcao_resultado.valor_saida_t40_s50 " 
		+ " ,cotacao_processada_opcao_resultado.valor_saida_t50_s50 " 
		+ " ,cotacao_processada_opcao_resultado.valor_saida_t60_s50 " 
		+ " ,cotacao_processada_opcao_resultado.valor_saida_t70_s50 " 
		+ " , DATE_FORMAT(cotacao_processada_opcao_resultado.data_hora_saida_t40_s60,'%d-%m-%Y %H:%i:%s') " 
		+ " , DATE_FORMAT(cotacao_processada_opcao_resultado.data_hora_saida_t50_s60,'%d-%m-%Y %H:%i:%s') " 
		+ " , DATE_FORMAT(cotacao_processada_opcao_resultado.data_hora_saida_t60_s60,'%d-%m-%Y %H:%i:%s') " 
		+ " , DATE_FORMAT(cotacao_processada_opcao_resultado.data_hora_saida_t70_s60,'%d-%m-%Y %H:%i:%s') " 
		+ " , DATE_FORMAT(cotacao_processada_opcao_resultado.data_hora_saida_t40_s50,'%d-%m-%Y %H:%i:%s') " 
		+ " , DATE_FORMAT(cotacao_processada_opcao_resultado.data_hora_saida_t50_s50,'%d-%m-%Y %H:%i:%s') " 
		+ " , DATE_FORMAT(cotacao_processada_opcao_resultado.data_hora_saida_t60_s50,'%d-%m-%Y %H:%i:%s') " 
		+ " , DATE_FORMAT(cotacao_processada_opcao_resultado.data_hora_saida_t70_s50,'%d-%m-%Y %H:%i:%s') " 
		+ " ,cotacao_processada_opcao_resultado.valor_acao " 
		+ " ,cotacao_processada_opcao_resultado.limite_dia_t50_s50 " 
		+ " ,cotacao_processada_opcao_resultado.limite_dia_t60_s60 " 
		+ " ,cotacao_processada_opcao_resultado.id_opcao_sisacao_ra " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_cotacao_processada_opcao_resultado " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data,'%d-%m-%Y') " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".hora_serie_temporal,'%H:%i') " 
		+ " , " + nomeTabela + ".contador_dia " 
		+ " , " + nomeTabela + ".codigo_mercado_opcao " 
		+ " , " + nomeTabela + ".valor_opcao " 
		+ " , " + nomeTabela + ".resultado_t70_s60 " 
		+ " , " + nomeTabela + ".resultado_t60_s60 " 
		+ " , " + nomeTabela + ".resultado_t50_s60 " 
		+ " , " + nomeTabela + ".resultado_t40_s60 " 
		+ " , " + nomeTabela + ".resultado_t70_s50 " 
		+ " , " + nomeTabela + ".resultado_t60_s50 " 
		+ " , " + nomeTabela + ".resultado_t50_s50 " 
		+ " , " + nomeTabela + ".resultado_t40_s50 " 
		+ " , " + nomeTabela + ".valor_saida_t40_s60 " 
		+ " , " + nomeTabela + ".valor_saida_t50_s60 " 
		+ " , " + nomeTabela + ".valor_saida_t60_s60 " 
		+ " , " + nomeTabela + ".valor_saida_t70_s60 " 
		+ " , " + nomeTabela + ".valor_saida_t40_s50 " 
		+ " , " + nomeTabela + ".valor_saida_t50_s50 " 
		+ " , " + nomeTabela + ".valor_saida_t60_s50 " 
		+ " , " + nomeTabela + ".valor_saida_t70_s50 " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_hora_saida_t40_s60,'%d-%m-%Y %H:%i:%s') " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_hora_saida_t50_s60,'%d-%m-%Y %H:%i:%s') " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_hora_saida_t60_s60,'%d-%m-%Y %H:%i:%s') " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_hora_saida_t70_s60,'%d-%m-%Y %H:%i:%s') " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_hora_saida_t40_s50,'%d-%m-%Y %H:%i:%s') " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_hora_saida_t50_s50,'%d-%m-%Y %H:%i:%s') " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_hora_saida_t60_s50,'%d-%m-%Y %H:%i:%s') " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_hora_saida_t70_s50,'%d-%m-%Y %H:%i:%s') " 
		+ " , " + nomeTabela + ".valor_acao " 
		+ " , " + nomeTabela + ".limite_dia_t50_s50 " 
		+ " , " + nomeTabela + ".limite_dia_t60_s60 " 
		+ " , " + nomeTabela + ".id_opcao_sisacao_ra " 
		;
	}
	
	
	@Override
	public void insereItem(CotacaoProcessadaOpcaoResultado item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(CotacaoProcessadaOpcaoResultado item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(CotacaoProcessadaOpcaoResultado item) throws DaoException {
		CotacaoProcessadaOpcaoResultado teste = this.obtemPorChave(item.getIdCotacaoProcessadaOpcaoResultado());
      	if (teste == null)
      	{
        	insereItemCompleto(item);
          	return true;
      	}
      	else
      	{
          	return false;
      	}
	}
	@Override
	public void insereItemLoad(CotacaoProcessadaOpcaoResultado item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_cotacao_processada_opcao_resultado) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdCotacaoProcessadaOpcaoResultado(id);	
	}
	@Override
	public void alteraItem(CotacaoProcessadaOpcaoResultado item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_cotacao_processada_opcao_resultado = " + item.getIdCotacaoProcessadaOpcaoResultado();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(CotacaoProcessadaOpcaoResultado item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_cotacao_processada_opcao_resultado = " + item.getIdCotacaoProcessadaOpcaoResultado();
		executaSql(query);
	}
	@Override
	public CotacaoProcessadaOpcaoResultado obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_cotacao_processada_opcao_resultado = " + id;
        return (CotacaoProcessadaOpcaoResultado) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(CotacaoProcessadaOpcaoResultadoFiltro filtro) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin();
      	String where;
      	where = WhereFiltro(filtro) + whereListaConcatenado();
      	if (where.length() > 0)
        	sql += " where " + where;
      	sql += orderByLista();
      	return getListaSql(sql);
	}
	
	protected  String WhereFiltro( CotacaoProcessadaOpcaoResultadoFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoOpcaoSisacaoReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_opcao_sisacao_ra = " + filtro.getCodigoOpcaoSisacaoReferenteA();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(CotacaoProcessadaOpcaoResultadoFiltro filtro)
			throws DaoException {
		setMontador(null);
		String sql;
		sql = "select " + camposOrdenados() + " from " + tabelaSelect();
      	String where;
		where = WhereFiltro(filtro)  + whereListaConcatenado();
		if (where.length() > 0)
			sql += " where " + where;
		sql += orderByLista();
		return getListaSql(sql);
	}
	
	@Override
	public List ListaCorrente() throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenados() + " from " + tabelaSelect() + orderByLista();
      	return getListaSql(sql);
	}
	
	
	protected String valoresInsert(CotacaoProcessadaOpcaoResultado item) {
		return " ( '" + item.getIdCotacaoProcessadaOpcaoResultado() + "'  " 
		+ " ," + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  "
		+ " ," + (item.getHoraSerieTemporal()==null?"null":"'" + item.getHoraSerieTemporal() + "'") + "  "
		+ " ,'" + item.getContadorDia() + "'  "
		+ " ,'" + item.getCodigoMercadoOpcao() + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getValorOpcao()) + "'  "
		+ " ,'" + item.getResultadoT70S60() + "'  "
		+ " ,'" + item.getResultadoT60S60() + "'  "
		+ " ,'" + item.getResultadoT50S60() + "'  "
		+ " ,'" + item.getResultadoT40S60() + "'  "
		+ " ,'" + item.getResultadoT70S50() + "'  "
		+ " ,'" + item.getResultadoT60S50() + "'  "
		+ " ,'" + item.getResultadoT50S50() + "'  "
		+ " ,'" + item.getResultadoT40S50() + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getValorSaidaT40S60()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getValorSaidaT50S60()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getValorSaidaT60S60()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getValorSaidaT70S60()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getValorSaidaT40S50()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getValorSaidaT50S50()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getValorSaidaT60S50()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getValorSaidaT70S50()) + "'  "
		+ " ," + (item.getDataHoraSaidaT40S60()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHoraSaidaT40S60()) ) + "  "
		+ " ," + (item.getDataHoraSaidaT50S60()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHoraSaidaT50S60()) ) + "  "
		+ " ," + (item.getDataHoraSaidaT60S60()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHoraSaidaT60S60()) ) + "  "
		+ " ," + (item.getDataHoraSaidaT70S60()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHoraSaidaT70S60()) ) + "  "
		+ " ," + (item.getDataHoraSaidaT40S50()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHoraSaidaT40S50()) ) + "  "
		+ " ," + (item.getDataHoraSaidaT50S50()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHoraSaidaT50S50()) ) + "  "
		+ " ," + (item.getDataHoraSaidaT60S50()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHoraSaidaT60S50()) ) + "  "
		+ " ," + (item.getDataHoraSaidaT70S50()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHoraSaidaT70S50()) ) + "  "
		+ " ,'" +  DCConvert.ToDataBase(item.getValorAcao()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getLimiteDiaT50S50()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getLimiteDiaT60S60()) + "'  "
		+ " ," + item.getIdOpcaoSisacaoRa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_cotacao_processada_opcao_resultado " 
		+ " ,data " 
		+ " ,hora_serie_temporal " 
		+ " ,contador_dia " 
		+ " ,codigo_mercado_opcao " 
		+ " ,valor_opcao " 
		+ " ,resultado_t70_s60 " 
		+ " ,resultado_t60_s60 " 
		+ " ,resultado_t50_s60 " 
		+ " ,resultado_t40_s60 " 
		+ " ,resultado_t70_s50 " 
		+ " ,resultado_t60_s50 " 
		+ " ,resultado_t50_s50 " 
		+ " ,resultado_t40_s50 " 
		+ " ,valor_saida_t40_s60 " 
		+ " ,valor_saida_t50_s60 " 
		+ " ,valor_saida_t60_s60 " 
		+ " ,valor_saida_t70_s60 " 
		+ " ,valor_saida_t40_s50 " 
		+ " ,valor_saida_t50_s50 " 
		+ " ,valor_saida_t60_s50 " 
		+ " ,valor_saida_t70_s50 " 
		+ " ,data_hora_saida_t40_s60 " 
		+ " ,data_hora_saida_t50_s60 " 
		+ " ,data_hora_saida_t60_s60 " 
		+ " ,data_hora_saida_t70_s60 " 
		+ " ,data_hora_saida_t40_s50 " 
		+ " ,data_hora_saida_t50_s50 " 
		+ " ,data_hora_saida_t60_s50 " 
		+ " ,data_hora_saida_t70_s50 " 
		+ " ,valor_acao " 
		+ " ,limite_dia_t50_s50 " 
		+ " ,limite_dia_t60_s60 " 
		+ " ,id_opcao_sisacao_ra " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(CotacaoProcessadaOpcaoResultado item) {
		return " id_cotacao_processada_opcao_resultado = '" + item.getIdCotacaoProcessadaOpcaoResultado() + "'  " 
		+ " , data = " + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  "
		+ " , hora_serie_temporal = " + (item.getHoraSerieTemporal()==null?"null":"'" + item.getHoraSerieTemporal() + "'") + "  "
		+ " , contador_dia = '" + item.getContadorDia() + "'  "
		+ " , codigo_mercado_opcao = '" + item.getCodigoMercadoOpcao() + "'  "
		+ " , valor_opcao = '" +  DCConvert.ToDataBase(item.getValorOpcao()) + "'  "
		+ " , resultado_t70_s60 = '" + item.getResultadoT70S60() + "'  "
		+ " , resultado_t60_s60 = '" + item.getResultadoT60S60() + "'  "
		+ " , resultado_t50_s60 = '" + item.getResultadoT50S60() + "'  "
		+ " , resultado_t40_s60 = '" + item.getResultadoT40S60() + "'  "
		+ " , resultado_t70_s50 = '" + item.getResultadoT70S50() + "'  "
		+ " , resultado_t60_s50 = '" + item.getResultadoT60S50() + "'  "
		+ " , resultado_t50_s50 = '" + item.getResultadoT50S50() + "'  "
		+ " , resultado_t40_s50 = '" + item.getResultadoT40S50() + "'  "
		+ " , valor_saida_t40_s60 = '" +  DCConvert.ToDataBase(item.getValorSaidaT40S60()) + "'  "
		+ " , valor_saida_t50_s60 = '" +  DCConvert.ToDataBase(item.getValorSaidaT50S60()) + "'  "
		+ " , valor_saida_t60_s60 = '" +  DCConvert.ToDataBase(item.getValorSaidaT60S60()) + "'  "
		+ " , valor_saida_t70_s60 = '" +  DCConvert.ToDataBase(item.getValorSaidaT70S60()) + "'  "
		+ " , valor_saida_t40_s50 = '" +  DCConvert.ToDataBase(item.getValorSaidaT40S50()) + "'  "
		+ " , valor_saida_t50_s50 = '" +  DCConvert.ToDataBase(item.getValorSaidaT50S50()) + "'  "
		+ " , valor_saida_t60_s50 = '" +  DCConvert.ToDataBase(item.getValorSaidaT60S50()) + "'  "
		+ " , valor_saida_t70_s50 = '" +  DCConvert.ToDataBase(item.getValorSaidaT70S50()) + "'  "
		+ " , data_hora_saida_t40_s60 = " + (item.getDataHoraSaidaT40S60()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHoraSaidaT40S60()) ) + "  "
		+ " , data_hora_saida_t50_s60 = " + (item.getDataHoraSaidaT50S60()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHoraSaidaT50S60()) ) + "  "
		+ " , data_hora_saida_t60_s60 = " + (item.getDataHoraSaidaT60S60()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHoraSaidaT60S60()) ) + "  "
		+ " , data_hora_saida_t70_s60 = " + (item.getDataHoraSaidaT70S60()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHoraSaidaT70S60()) ) + "  "
		+ " , data_hora_saida_t40_s50 = " + (item.getDataHoraSaidaT40S50()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHoraSaidaT40S50()) ) + "  "
		+ " , data_hora_saida_t50_s50 = " + (item.getDataHoraSaidaT50S50()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHoraSaidaT50S50()) ) + "  "
		+ " , data_hora_saida_t60_s50 = " + (item.getDataHoraSaidaT60S50()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHoraSaidaT60S50()) ) + "  "
		+ " , data_hora_saida_t70_s50 = " + (item.getDataHoraSaidaT70S50()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHoraSaidaT70S50()) ) + "  "
		+ " , valor_acao = '" +  DCConvert.ToDataBase(item.getValorAcao()) + "'  "
		+ " , limite_dia_t50_s50 = '" +  DCConvert.ToDataBase(item.getLimiteDiaT50S50()) + "'  "
		+ " , limite_dia_t60_s60 = '" +  DCConvert.ToDataBase(item.getLimiteDiaT60S60()) + "'  "
		+ " , id_opcao_sisacao_ra = " + item.getIdOpcaoSisacaoRa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(CotacaoProcessadaOpcaoResultado item) {
		return " id_cotacao_processada_opcao_resultado = '" + item.getIdCotacaoProcessadaOpcaoResultado() + "'  " 
		+ " , data = " + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  " 
		+ " , hora_serie_temporal = " + (item.getHoraSerieTemporal()==null?"null":"'" + item.getHoraSerieTemporal() + "'") + "  " 
		+ " , contador_dia = '" + item.getContadorDia() + "'  " 
		+ " , codigo_mercado_opcao = '" + item.getCodigoMercadoOpcao() + "'  " 
		+ " , valor_opcao = '" +  DCConvert.ToDataBase(item.getValorOpcao()) + "'  " 
		+ " , resultado_t70_s60 = '" + item.getResultadoT70S60() + "'  " 
		+ " , resultado_t60_s60 = '" + item.getResultadoT60S60() + "'  " 
		+ " , resultado_t50_s60 = '" + item.getResultadoT50S60() + "'  " 
		+ " , resultado_t40_s60 = '" + item.getResultadoT40S60() + "'  " 
		+ " , resultado_t70_s50 = '" + item.getResultadoT70S50() + "'  " 
		+ " , resultado_t60_s50 = '" + item.getResultadoT60S50() + "'  " 
		+ " , resultado_t50_s50 = '" + item.getResultadoT50S50() + "'  " 
		+ " , resultado_t40_s50 = '" + item.getResultadoT40S50() + "'  " 
		+ " , valor_saida_t40_s60 = '" +  DCConvert.ToDataBase(item.getValorSaidaT40S60()) + "'  " 
		+ " , valor_saida_t50_s60 = '" +  DCConvert.ToDataBase(item.getValorSaidaT50S60()) + "'  " 
		+ " , valor_saida_t60_s60 = '" +  DCConvert.ToDataBase(item.getValorSaidaT60S60()) + "'  " 
		+ " , valor_saida_t70_s60 = '" +  DCConvert.ToDataBase(item.getValorSaidaT70S60()) + "'  " 
		+ " , valor_saida_t40_s50 = '" +  DCConvert.ToDataBase(item.getValorSaidaT40S50()) + "'  " 
		+ " , valor_saida_t50_s50 = '" +  DCConvert.ToDataBase(item.getValorSaidaT50S50()) + "'  " 
		+ " , valor_saida_t60_s50 = '" +  DCConvert.ToDataBase(item.getValorSaidaT60S50()) + "'  " 
		+ " , valor_saida_t70_s50 = '" +  DCConvert.ToDataBase(item.getValorSaidaT70S50()) + "'  " 
		+ " , data_hora_saida_t40_s60 = " + (item.getDataHoraSaidaT40S60()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHoraSaidaT40S60()) ) + "  " 
		+ " , data_hora_saida_t50_s60 = " + (item.getDataHoraSaidaT50S60()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHoraSaidaT50S60()) ) + "  " 
		+ " , data_hora_saida_t60_s60 = " + (item.getDataHoraSaidaT60S60()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHoraSaidaT60S60()) ) + "  " 
		+ " , data_hora_saida_t70_s60 = " + (item.getDataHoraSaidaT70S60()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHoraSaidaT70S60()) ) + "  " 
		+ " , data_hora_saida_t40_s50 = " + (item.getDataHoraSaidaT40S50()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHoraSaidaT40S50()) ) + "  " 
		+ " , data_hora_saida_t50_s50 = " + (item.getDataHoraSaidaT50S50()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHoraSaidaT50S50()) ) + "  " 
		+ " , data_hora_saida_t60_s50 = " + (item.getDataHoraSaidaT60S50()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHoraSaidaT60S50()) ) + "  " 
		+ " , data_hora_saida_t70_s50 = " + (item.getDataHoraSaidaT70S50()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getDataHoraSaidaT70S50()) ) + "  " 
		+ " , valor_acao = '" +  DCConvert.ToDataBase(item.getValorAcao()) + "'  " 
		+ " , limite_dia_t50_s50 = '" +  DCConvert.ToDataBase(item.getLimiteDiaT50S50()) + "'  " 
		+ " , limite_dia_t60_s60 = '" +  DCConvert.ToDataBase(item.getLimiteDiaT60S60()) + "'  " 
		+ " , id_opcao_sisacao_ra = " + item.getIdOpcaoSisacaoRa() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	//** Final Lista Sem chave Estrangeira
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteAOpcaoSisacao(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_opcao_sisacao_ra = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorOpcaoSisacaoReferenteA(long id) throws DaoException {
		return getPorReferenteAOpcaoSisacao(id);
	}
	public boolean excluiPorReferenteAOpcaoSisacao(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_opcao_sisacao_ra = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinOpcaoSisacao_ReferenteA() {
	//	return " inner join " + OpcaoSisacaoDaoBase.tabelaSelect() + " on " + OpcaoSisacaoDaoBase.tabelaSelect() + ".id_cotacao_processada_opcao_resultado_ee = " + tabelaSelect() + ".id_cotacao_processada_opcao_resultado ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemOpcaoSisacao_ReferenteA = false;
	public void setObtemOpcaoSisacao_ReferenteA() {
		_obtemOpcaoSisacao_ReferenteA = true;
	}
	protected String outterJoinOpcaoSisacao_ReferenteA() {
		return " left outer join " + OpcaoSisacaoDaoBase.tabelaSelect() + " on " + OpcaoSisacaoDaoBase.tabelaSelect() + ".id_opcao_sisacao = " + tabelaSelect() + ".id_opcao_sisacao_ra ";  
	}
	public boolean atualizaReferenteAOpcaoSisacao(long idCotacaoProcessadaOpcaoResultado, long idOpcaoSisacaoRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_opcao_sisacao_ra  = " + idOpcaoSisacaoRa +
        " where id_cotacao_processada_opcao_resultado = " +  idCotacaoProcessadaOpcaoResultado;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinOpcaoSisacao_ReferenteA() {
		return " inner join " + OpcaoSisacaoDaoBase.tabelaSelect() + " on " + OpcaoSisacaoDaoBase.tabelaSelect() + ".id_opcao_sisacao = " + tabelaSelect() + ".id_opcao_sisacao_ra ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemOpcaoSisacao_ReferenteA?" , " +OpcaoSisacaoDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemOpcaoSisacao_ReferenteA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemOpcaoSisacao_ReferenteA? outterJoinOpcaoSisacao_ReferenteA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new CotacaoProcessadaOpcaoResultadoMontador(), null);
		if (this._obtemOpcaoSisacao_ReferenteA)
            montador.adicionaMontador(new OpcaoSisacaoMontador(), "OpcaoSisacao_ReferenteA");
         return montador;
    }
	
	
}
