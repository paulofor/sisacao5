/*   1:    */ package sisacaoweb2online.webservice;
/*   2:    */ 
/*   3:    */ import java.rmi.RemoteException;
/*   4:    */ import javax.xml.rpc.ServiceException;
/*   5:    */ import javax.xml.rpc.Stub;
/*   6:    */ 
/*   7:    */ public class TickerWSSoapProxy
/*   8:    */   implements TickerWSSoap
/*   9:    */ {
/*  10:  4 */   private String _endpoint = null;
/*  11:  5 */   private TickerWSSoap tickerWSSoap = null;
/*  12:    */   
/*  13:    */   public TickerWSSoapProxy()
/*  14:    */   {
/*  15:  8 */     _initTickerWSSoapProxy();
/*  16:    */   }
/*  17:    */   
/*  18:    */   public TickerWSSoapProxy(String endpoint)
/*  19:    */   {
/*  20: 12 */     this._endpoint = endpoint;
/*  21: 13 */     _initTickerWSSoapProxy();
/*  22:    */   }
/*  23:    */   
/*  24:    */   private void _initTickerWSSoapProxy()
/*  25:    */   {
/*  26:    */     try
/*  27:    */     {
/*  28: 18 */       this.tickerWSSoap = new TickerWSLocator().getTickerWSSoap();
/*  29: 19 */       if (this.tickerWSSoap != null) {
/*  30: 20 */         if (this._endpoint != null) {
/*  31: 21 */           ((Stub)this.tickerWSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", this._endpoint);
/*  32:    */         } else {
/*  33: 23 */           this._endpoint = ((String)((Stub)this.tickerWSSoap)._getProperty("javax.xml.rpc.service.endpoint.address"));
/*  34:    */         }
/*  35:    */       }
/*  36:    */     }
/*  37:    */     catch (ServiceException localServiceException) {}
/*  38:    */   }
/*  39:    */   
/*  40:    */   public String getEndpoint()
/*  41:    */   {
/*  42: 31 */     return this._endpoint;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public void setEndpoint(String endpoint)
/*  46:    */   {
/*  47: 35 */     this._endpoint = endpoint;
/*  48: 36 */     if (this.tickerWSSoap != null) {
/*  49: 37 */       ((Stub)this.tickerWSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", this._endpoint);
/*  50:    */     }
/*  51:    */   }
/*  52:    */   
/*  53:    */   public TickerWSSoap getTickerWSSoap()
/*  54:    */   {
/*  55: 42 */     if (this.tickerWSSoap == null) {
/*  56: 43 */       _initTickerWSSoapProxy();
/*  57:    */     }
/*  58: 44 */     return this.tickerWSSoap;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public TickerObjetoWs[] listaCorrente()
/*  62:    */     throws RemoteException
/*  63:    */   {
/*  64: 48 */     if (this.tickerWSSoap == null) {
/*  65: 49 */       _initTickerWSSoapProxy();
/*  66:    */     }
/*  67: 50 */     return this.tickerWSSoap.listaCorrente();
/*  68:    */   }
/*  69:    */   
/*  70:    */   public TickerObjetoWs[] insereTicker(TickerObjetoWs ticker, TickerFiltro filtro)
/*  71:    */     throws RemoteException
/*  72:    */   {
/*  73: 54 */     if (this.tickerWSSoap == null) {
/*  74: 55 */       _initTickerWSSoapProxy();
/*  75:    */     }
/*  76: 56 */     return this.tickerWSSoap.insereTicker(ticker, filtro);
/*  77:    */   }
/*  78:    */   
/*  79:    */   public TickerObjetoWs[] alteraTicker(TickerObjetoWs ticker, TickerFiltro filtro)
/*  80:    */     throws RemoteException
/*  81:    */   {
/*  82: 60 */     if (this.tickerWSSoap == null) {
/*  83: 61 */       _initTickerWSSoapProxy();
/*  84:    */     }
/*  85: 62 */     return this.tickerWSSoap.alteraTicker(ticker, filtro);
/*  86:    */   }
/*  87:    */   
/*  88:    */   public TickerObjetoWs[] listaAtivoOpcao(TickerFiltro filtro)
/*  89:    */     throws RemoteException
/*  90:    */   {
/*  91: 66 */     if (this.tickerWSSoap == null) {
/*  92: 67 */       _initTickerWSSoapProxy();
/*  93:    */     }
/*  94: 68 */     return this.tickerWSSoap.listaAtivoOpcao(filtro);
/*  95:    */   }
/*  96:    */   
/*  97:    */   public TickerObjetoWs obtemPorNomeTicker(TickerFiltro filtro)
/*  98:    */     throws RemoteException
/*  99:    */   {
/* 100: 72 */     if (this.tickerWSSoap == null) {
/* 101: 73 */       _initTickerWSSoapProxy();
/* 102:    */     }
/* 103: 74 */     return this.tickerWSSoap.obtemPorNomeTicker(filtro);
/* 104:    */   }
/* 105:    */   
/* 106:    */   public TickerObjetoWs[] listaAtivo(TickerFiltro filtro)
/* 107:    */     throws RemoteException
/* 108:    */   {
/* 109: 78 */     if (this.tickerWSSoap == null) {
/* 110: 79 */       _initTickerWSSoapProxy();
/* 111:    */     }
/* 112: 80 */     return this.tickerWSSoap.listaAtivo(filtro);
/* 113:    */   }
/* 114:    */   
/* 115:    */   public TickerObjetoWs[] listaDiarioOnline(TickerFiltro filtro)
/* 116:    */     throws RemoteException
/* 117:    */   {
/* 118: 84 */     if (this.tickerWSSoap == null) {
/* 119: 85 */       _initTickerWSSoapProxy();
/* 120:    */     }
/* 121: 86 */     return this.tickerWSSoap.listaDiarioOnline(filtro);
/* 122:    */   }
/* 123:    */   
/* 124:    */   public TickerObjetoWs[] listaNaoRelacionadaEmCombinacaoExecucaoCompraListaGerou(long idCombinacaoExecucaoCompra)
/* 125:    */     throws RemoteException
/* 126:    */   {
/* 127: 90 */     if (this.tickerWSSoap == null) {
/* 128: 91 */       _initTickerWSSoapProxy();
/* 129:    */     }
/* 130: 92 */     return this.tickerWSSoap.listaNaoRelacionadaEmCombinacaoExecucaoCompraListaGerou(idCombinacaoExecucaoCompra);
/* 131:    */   }
/* 132:    */   
/* 133:    */   public TickerObjetoWs[] listaNaoRelacionadaEmSplitListaPossui(long idSplit)
/* 134:    */     throws RemoteException
/* 135:    */   {
/* 136: 96 */     if (this.tickerWSSoap == null) {
/* 137: 97 */       _initTickerWSSoapProxy();
/* 138:    */     }
/* 139: 98 */     return this.tickerWSSoap.listaNaoRelacionadaEmSplitListaPossui(idSplit);
/* 140:    */   }
/* 141:    */   
/* 142:    */   public TickerObjetoWs[] listaNaoRelacionadaEmOpcaoSisacaoListaGera(long idOpcaoSisacao)
/* 143:    */     throws RemoteException
/* 144:    */   {
/* 145:102 */     if (this.tickerWSSoap == null) {
/* 146:103 */       _initTickerWSSoapProxy();
/* 147:    */     }
/* 148:104 */     return this.tickerWSSoap.listaNaoRelacionadaEmOpcaoSisacaoListaGera(idOpcaoSisacao);
/* 149:    */   }
/* 150:    */   
/* 151:    */   public TickerObjetoWs[] listaNaoRelacionadaEmOpcaoSisacaoSerieTickerListaRelacionadoCom(long idOpcaoSisacaoSerie)
/* 152:    */     throws RemoteException
/* 153:    */   {
/* 154:108 */     if (this.tickerWSSoap == null) {
/* 155:109 */       _initTickerWSSoapProxy();
/* 156:    */     }
/* 157:110 */     return this.tickerWSSoap.listaNaoRelacionadaEmOpcaoSisacaoSerieTickerListaRelacionadoCom(idOpcaoSisacaoSerie);
/* 158:    */   }
/* 159:    */   
/* 160:    */   public TickerObjetoWs[] listaPorFiltroObjeto(TickerFiltro filtro)
/* 161:    */     throws RemoteException
/* 162:    */   {
/* 163:114 */     if (this.tickerWSSoap == null) {
/* 164:115 */       _initTickerWSSoapProxy();
/* 165:    */     }
/* 166:116 */     return this.tickerWSSoap.listaPorFiltroObjeto(filtro);
/* 167:    */   }
/* 168:    */   
/* 169:    */   public TickerObjetoWs obtemPorChave(long id)
/* 170:    */     throws RemoteException
/* 171:    */   {
/* 172:120 */     if (this.tickerWSSoap == null) {
/* 173:121 */       _initTickerWSSoapProxy();
/* 174:    */     }
/* 175:122 */     return this.tickerWSSoap.obtemPorChave(id);
/* 176:    */   }
/* 177:    */ }


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     sisacaoweb2online.webservice.TickerWSSoapProxy
 * JD-Core Version:    0.7.0.1
 */