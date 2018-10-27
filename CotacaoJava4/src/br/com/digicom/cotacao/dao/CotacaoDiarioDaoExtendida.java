 package br.com.digicom.cotacao.dao;
 
 import br.com.digicom.cotacao.vo.CotacaoDiario;
import br.com.digicom.cotacao.vo.CotacaoDiarioOpcao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
//import br.com.digicom.parse.log.ArquivoLog;
 
 public class CotacaoDiarioDaoExtendida extends CotacaoDiarioDaoBase
   implements CotacaoDiarioDao
 {
   public CotacaoDiarioDaoExtendida(DataFonte dataSource)
   {
/* 15 */     super(dataSource);
   }
 
   public void CriaTabelaSeNecessario(String nomeTabela) throws DaoException
   {
/* 20 */     String sql = "create table if not exists " + nomeTabela + "_DIARIO" + 
/* 21 */       " ( " + 
/* 22 */       " id_cotacao_diario integer unsigned not null auto_increment," + 
/* 23 */       " abertura_original decimal(7,2)," + 
/* 24 */       " maximo_original decimal(7,2)," + 
/* 25 */       " minimo_original decimal(7,2)," + 
/* 26 */       " fechamento_original decimal(7,2)," + 
/* 27 */       " abertura_corrigido decimal(8,3)," + 
/* 28 */       " maximo_corrigido decimal(8,3)," + 
/* 29 */       " minimo_corrigido decimal(8,3)," + 
/* 30 */       " fechamento_corrigido decimal(8,3)," + 
/* 31 */       " negocios integer unsigned," + 
/* 32 */       " volume decimal(14,2)," + 
/* 33 */       " data date," + 
/* 34 */       " PRIMARY KEY (id_cotacao_diario), " + 
/* 35 */       " INDEX `data_idx`(`data`) " + 
/* 36 */       " )" + 
/* 37 */       " ENGINE = MYISAM;";
/* 38 */     executaSql(sql);
   }
 
   public void testaTabela(String nomeTicker) throws DaoException
   {
/* 43 */     String sql = "select * from " + nomeTicker + "_DIARIO limite 1,1";
/* 44 */     executaSqlForcado(sql);
   }
 
   public void insereCotacao(CotacaoDiario cotacao, String nomeTicker) throws DaoException
   {
/* 49 */     cotacao.setTicker(nomeTicker);
/* 50 */     String sql = getSqlInsert(cotacao);
 
/* 54 */     executaSqlForcado(sql);
   }
 
   protected String getSqlInsert(CotacaoDiario cotacao) {
/* 58 */     StringBuffer saida = new StringBuffer("Insert into ");
/* 59 */     saida.append(cotacao.getTicker() + "_DIARIO").append(" ");
/* 60 */     saida.append("(abertura_original, maximo_original, minimo_original, fechamento_original,abertura_corrigido, maximo_corrigido, minimo_corrigido, fechamento_corrigido, negocios, volume, data)");
/* 61 */     saida.append(" Values ( ");
/* 62 */     saida.append(cotacao.getAbertura() + " , ");
/* 63 */     saida.append(cotacao.getMaximo() + " , ");
/* 64 */     saida.append(cotacao.getMinimo() + " , ");
/* 65 */     saida.append(cotacao.getFechamento() + " , ");
/* 66 */     saida.append(cotacao.getAbertura() + " , ");
/* 67 */     saida.append(cotacao.getMaximo() + " , ");
/* 68 */     saida.append(cotacao.getMinimo() + " , ");
/* 69 */     saida.append(cotacao.getFechamento() + " , ");
/* 70 */     saida.append(cotacao.getNegocios() + " , ");
/* 71 */     saida.append(cotacao.getVolumeStr() + " , ");
/* 72 */     saida.append("'" + cotacao.getDataBd() + "' )");
/* 73 */     return saida.toString();
   }

@Override
public void insereOpcaoSeNecessario(CotacaoDiarioOpcao cotacao) {
	String sql = " insert into opcao_sisacao_geral (codigo_mercado, preco_exercicio, data_inclusao, mes_ano) " +
			" values ('" + 	cotacao.getTicker() + "' , '" + cotacao.getPrecoExercicio() + "' , getDate() , '" + cotacao.getDataVencimanto() + "' )";
	//ArquivoLog.getInstancia().salvaLog(sql);
							
	
}
 }

/* Location:           D:\Java-Recuperacao\CotacaoJava2.jar
 * Qualified Name:     br.com.digicom.cotacao.dao.CotacaoDiarioDaoExtendida
 * JD-Core Version:    0.6.0
 */