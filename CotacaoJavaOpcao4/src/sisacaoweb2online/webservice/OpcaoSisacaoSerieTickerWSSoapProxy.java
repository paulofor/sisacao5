/*  1:   */ package sisacaoweb2online.webservice;
/*  2:   */ 
/*  3:   */ import java.rmi.RemoteException;
/*  4:   */ import javax.xml.rpc.ServiceException;
/*  5:   */ import javax.xml.rpc.Stub;
/*  6:   */ 
/*  7:   */ public class OpcaoSisacaoSerieTickerWSSoapProxy
/*  8:   */   implements OpcaoSisacaoSerieTickerWSSoap
/*  9:   */ {
/* 10: 4 */   private String _endpoint = null;
/* 11: 5 */   private OpcaoSisacaoSerieTickerWSSoap opcaoSisacaoSerieTickerWSSoap = null;
/* 12:   */   
/* 13:   */   public OpcaoSisacaoSerieTickerWSSoapProxy()
/* 14:   */   {
/* 15: 8 */     _initOpcaoSisacaoSerieTickerWSSoapProxy();
/* 16:   */   }
/* 17:   */   
/* 18:   */   public OpcaoSisacaoSerieTickerWSSoapProxy(String endpoint)
/* 19:   */   {
/* 20:12 */     this._endpoint = endpoint;
/* 21:13 */     _initOpcaoSisacaoSerieTickerWSSoapProxy();
/* 22:   */   }
/* 23:   */   
/* 24:   */   private void _initOpcaoSisacaoSerieTickerWSSoapProxy()
/* 25:   */   {
/* 26:   */     try
/* 27:   */     {
/* 28:18 */       this.opcaoSisacaoSerieTickerWSSoap = new OpcaoSisacaoSerieTickerWSLocator().getOpcaoSisacaoSerieTickerWSSoap();
/* 29:19 */       if (this.opcaoSisacaoSerieTickerWSSoap != null) {
/* 30:20 */         if (this._endpoint != null) {
/* 31:21 */           ((Stub)this.opcaoSisacaoSerieTickerWSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", this._endpoint);
/* 32:   */         } else {
/* 33:23 */           this._endpoint = ((String)((Stub)this.opcaoSisacaoSerieTickerWSSoap)._getProperty("javax.xml.rpc.service.endpoint.address"));
/* 34:   */         }
/* 35:   */       }
/* 36:   */     }
/* 37:   */     catch (ServiceException localServiceException) {}
/* 38:   */   }
/* 39:   */   
/* 40:   */   public String getEndpoint()
/* 41:   */   {
/* 42:31 */     return this._endpoint;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public void setEndpoint(String endpoint)
/* 46:   */   {
/* 47:35 */     this._endpoint = endpoint;
/* 48:36 */     if (this.opcaoSisacaoSerieTickerWSSoap != null) {
/* 49:37 */       ((Stub)this.opcaoSisacaoSerieTickerWSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", this._endpoint);
/* 50:   */     }
/* 51:   */   }
/* 52:   */   
/* 53:   */   public OpcaoSisacaoSerieTickerWSSoap getOpcaoSisacaoSerieTickerWSSoap()
/* 54:   */   {
/* 55:42 */     if (this.opcaoSisacaoSerieTickerWSSoap == null) {
/* 56:43 */       _initOpcaoSisacaoSerieTickerWSSoapProxy();
/* 57:   */     }
/* 58:44 */     return this.opcaoSisacaoSerieTickerWSSoap;
/* 59:   */   }
/* 60:   */   
/* 61:   */   public OpcaoSisacaoSerieTickerObjetoWs[] listaCorrente()
/* 62:   */     throws RemoteException
/* 63:   */   {
/* 64:48 */     if (this.opcaoSisacaoSerieTickerWSSoap == null) {
/* 65:49 */       _initOpcaoSisacaoSerieTickerWSSoapProxy();
/* 66:   */     }
/* 67:50 */     return this.opcaoSisacaoSerieTickerWSSoap.listaCorrente();
/* 68:   */   }
/* 69:   */   
/* 70:   */   public OpcaoSisacaoSerieTickerObjetoWs[] insereOpcaoSisacaoSerieTicker(OpcaoSisacaoSerieTickerObjetoWs opcaoSisacaoSerieTicker, OpcaoSisacaoSerieTickerFiltro filtro)
/* 71:   */     throws RemoteException
/* 72:   */   {
/* 73:54 */     if (this.opcaoSisacaoSerieTickerWSSoap == null) {
/* 74:55 */       _initOpcaoSisacaoSerieTickerWSSoapProxy();
/* 75:   */     }
/* 76:56 */     return this.opcaoSisacaoSerieTickerWSSoap.insereOpcaoSisacaoSerieTicker(opcaoSisacaoSerieTicker, filtro);
/* 77:   */   }
/* 78:   */   
/* 79:   */   public OpcaoSisacaoSerieTickerObjetoWs[] alteraOpcaoSisacaoSerieTicker(OpcaoSisacaoSerieTickerObjetoWs opcaoSisacaoSerieTicker, OpcaoSisacaoSerieTickerFiltro filtro)
/* 80:   */     throws RemoteException
/* 81:   */   {
/* 82:60 */     if (this.opcaoSisacaoSerieTickerWSSoap == null) {
/* 83:61 */       _initOpcaoSisacaoSerieTickerWSSoapProxy();
/* 84:   */     }
/* 85:62 */     return this.opcaoSisacaoSerieTickerWSSoap.alteraOpcaoSisacaoSerieTicker(opcaoSisacaoSerieTicker, filtro);
/* 86:   */   }
/* 87:   */   
/* 88:   */   public OpcaoSisacaoSerieTickerObjetoWs criaOpcaoSisacaoTicker(OpcaoSisacaoSerieTickerFiltro filtro)
/* 89:   */     throws RemoteException
/* 90:   */   {
/* 91:66 */     if (this.opcaoSisacaoSerieTickerWSSoap == null) {
/* 92:67 */       _initOpcaoSisacaoSerieTickerWSSoapProxy();
/* 93:   */     }
/* 94:68 */     return this.opcaoSisacaoSerieTickerWSSoap.criaOpcaoSisacaoTicker(filtro);
/* 95:   */   }
/* 96:   */   
/* 97:   */   public OpcaoSisacaoSerieTickerObjetoWs[] alteracaoLoteOpcaoSisacaoSerieTicker(OpcaoSisacaoSerieTickerObjetoWs[] listaInsercao, OpcaoSisacaoSerieTickerObjetoWs[] listaRemocao, int codigoPerfil, int codigoParaRetorno)
/* 98:   */     throws RemoteException
/* 99:   */   {
/* :0:72 */     if (this.opcaoSisacaoSerieTickerWSSoap == null) {
/* :1:73 */       _initOpcaoSisacaoSerieTickerWSSoapProxy();
/* :2:   */     }
/* :3:74 */     return this.opcaoSisacaoSerieTickerWSSoap.alteracaoLoteOpcaoSisacaoSerieTicker(listaInsercao, listaRemocao, codigoPerfil, codigoParaRetorno);
/* :4:   */   }
/* :5:   */   
/* :6:   */   public OpcaoSisacaoSerieTickerObjetoWs[] listaPorTickerReferenteA(long idItem)
/* :7:   */     throws RemoteException
/* :8:   */   {
/* :9:78 */     if (this.opcaoSisacaoSerieTickerWSSoap == null) {
/* ;0:79 */       _initOpcaoSisacaoSerieTickerWSSoapProxy();
/* ;1:   */     }
/* ;2:80 */     return this.opcaoSisacaoSerieTickerWSSoap.listaPorTickerReferenteA(idItem);
/* ;3:   */   }
/* ;4:   */   
/* ;5:   */   public OpcaoSisacaoSerieTickerObjetoWs[] listaPorOpcaoSisacaoSerieReferenteA(long idItem)
/* ;6:   */     throws RemoteException
/* ;7:   */   {
/* ;8:84 */     if (this.opcaoSisacaoSerieTickerWSSoap == null) {
/* ;9:85 */       _initOpcaoSisacaoSerieTickerWSSoapProxy();
/* <0:   */     }
/* <1:86 */     return this.opcaoSisacaoSerieTickerWSSoap.listaPorOpcaoSisacaoSerieReferenteA(idItem);
/* <2:   */   }
/* <3:   */   
/* <4:   */   public OpcaoSisacaoSerieTickerObjetoWs[] listaPorFiltroObjeto(OpcaoSisacaoSerieTickerFiltro filtro)
/* <5:   */     throws RemoteException
/* <6:   */   {
/* <7:90 */     if (this.opcaoSisacaoSerieTickerWSSoap == null) {
/* <8:91 */       _initOpcaoSisacaoSerieTickerWSSoapProxy();
/* <9:   */     }
/* =0:92 */     return this.opcaoSisacaoSerieTickerWSSoap.listaPorFiltroObjeto(filtro);
/* =1:   */   }
/* =2:   */   
/* =3:   */   public OpcaoSisacaoSerieTickerObjetoWs obtemPorChave(long id)
/* =4:   */     throws RemoteException
/* =5:   */   {
/* =6:96 */     if (this.opcaoSisacaoSerieTickerWSSoap == null) {
/* =7:97 */       _initOpcaoSisacaoSerieTickerWSSoapProxy();
/* =8:   */     }
/* =9:98 */     return this.opcaoSisacaoSerieTickerWSSoap.obtemPorChave(id);
/* >0:   */   }
/* >1:   */ }


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     sisacaoweb2online.webservice.OpcaoSisacaoSerieTickerWSSoapProxy
 * JD-Core Version:    0.7.0.1
 */