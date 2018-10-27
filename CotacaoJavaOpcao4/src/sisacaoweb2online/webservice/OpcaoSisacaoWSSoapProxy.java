/*  1:   */ package sisacaoweb2online.webservice;
/*  2:   */ 
/*  3:   */ import java.rmi.RemoteException;
/*  4:   */ import javax.xml.rpc.ServiceException;
/*  5:   */ import javax.xml.rpc.Stub;
/*  6:   */ 
/*  7:   */ public class OpcaoSisacaoWSSoapProxy
/*  8:   */   implements OpcaoSisacaoWSSoap
/*  9:   */ {
/* 10: 4 */   private String _endpoint = null;
/* 11: 5 */   private OpcaoSisacaoWSSoap opcaoSisacaoWSSoap = null;
/* 12:   */   
/* 13:   */   public OpcaoSisacaoWSSoapProxy()
/* 14:   */   {
/* 15: 8 */     _initOpcaoSisacaoWSSoapProxy();
/* 16:   */   }
/* 17:   */   
/* 18:   */   public OpcaoSisacaoWSSoapProxy(String endpoint)
/* 19:   */   {
/* 20:12 */     this._endpoint = endpoint;
/* 21:13 */     _initOpcaoSisacaoWSSoapProxy();
/* 22:   */   }
/* 23:   */   
/* 24:   */   private void _initOpcaoSisacaoWSSoapProxy()
/* 25:   */   {
/* 26:   */     try
/* 27:   */     {
/* 28:18 */       this.opcaoSisacaoWSSoap = new OpcaoSisacaoWSLocator().getOpcaoSisacaoWSSoap();
/* 29:19 */       if (this.opcaoSisacaoWSSoap != null) {
/* 30:20 */         if (this._endpoint != null) {
/* 31:21 */           ((Stub)this.opcaoSisacaoWSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", this._endpoint);
/* 32:   */         } else {
/* 33:23 */           this._endpoint = ((String)((Stub)this.opcaoSisacaoWSSoap)._getProperty("javax.xml.rpc.service.endpoint.address"));
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
/* 48:36 */     if (this.opcaoSisacaoWSSoap != null) {
/* 49:37 */       ((Stub)this.opcaoSisacaoWSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", this._endpoint);
/* 50:   */     }
/* 51:   */   }
/* 52:   */   
/* 53:   */   public OpcaoSisacaoWSSoap getOpcaoSisacaoWSSoap()
/* 54:   */   {
/* 55:42 */     if (this.opcaoSisacaoWSSoap == null) {
/* 56:43 */       _initOpcaoSisacaoWSSoapProxy();
/* 57:   */     }
/* 58:44 */     return this.opcaoSisacaoWSSoap;
/* 59:   */   }
/* 60:   */   
/* 61:   */   public OpcaoSisacaoObjetoWs[] listaCorrente()
/* 62:   */     throws RemoteException
/* 63:   */   {
/* 64:48 */     if (this.opcaoSisacaoWSSoap == null) {
/* 65:49 */       _initOpcaoSisacaoWSSoapProxy();
/* 66:   */     }
/* 67:50 */     return this.opcaoSisacaoWSSoap.listaCorrente();
/* 68:   */   }
/* 69:   */   
/* 70:   */   public OpcaoSisacaoObjetoWs[] insereOpcaoSisacao(OpcaoSisacaoObjetoWs opcaoSisacao, OpcaoSisacaoFiltro filtro)
/* 71:   */     throws RemoteException
/* 72:   */   {
/* 73:54 */     if (this.opcaoSisacaoWSSoap == null) {
/* 74:55 */       _initOpcaoSisacaoWSSoapProxy();
/* 75:   */     }
/* 76:56 */     return this.opcaoSisacaoWSSoap.insereOpcaoSisacao(opcaoSisacao, filtro);
/* 77:   */   }
/* 78:   */   
/* 79:   */   public OpcaoSisacaoObjetoWs[] alteraOpcaoSisacao(OpcaoSisacaoObjetoWs opcaoSisacao, OpcaoSisacaoFiltro filtro)
/* 80:   */     throws RemoteException
/* 81:   */   {
/* 82:60 */     if (this.opcaoSisacaoWSSoap == null) {
/* 83:61 */       _initOpcaoSisacaoWSSoapProxy();
/* 84:   */     }
/* 85:62 */     return this.opcaoSisacaoWSSoap.alteraOpcaoSisacao(opcaoSisacao, filtro);
/* 86:   */   }
/* 87:   */   
/* 88:   */   public OpcaoSisacaoObjetoWs[] listaAtivoOpcao(OpcaoSisacaoFiltro filtro)
/* 89:   */     throws RemoteException
/* 90:   */   {
/* 91:66 */     if (this.opcaoSisacaoWSSoap == null) {
/* 92:67 */       _initOpcaoSisacaoWSSoapProxy();
/* 93:   */     }
/* 94:68 */     return this.opcaoSisacaoWSSoap.listaAtivoOpcao(filtro);
/* 95:   */   }
/* 96:   */   
/* 97:   */   public OpcaoSisacaoObjetoWs[] listaAtivoAnoComSerie(OpcaoSisacaoFiltro filtro)
/* 98:   */     throws RemoteException
/* 99:   */   {
/* :0:72 */     if (this.opcaoSisacaoWSSoap == null) {
/* :1:73 */       _initOpcaoSisacaoWSSoapProxy();
/* :2:   */     }
/* :3:74 */     return this.opcaoSisacaoWSSoap.listaAtivoAnoComSerie(filtro);
/* :4:   */   }
/* :5:   */   
/* :6:   */   public OpcaoSisacaoObjetoWs[] listaPorTickerDerivativoDe(long idItem)
/* :7:   */     throws RemoteException
/* :8:   */   {
/* :9:78 */     if (this.opcaoSisacaoWSSoap == null) {
/* ;0:79 */       _initOpcaoSisacaoWSSoapProxy();
/* ;1:   */     }
/* ;2:80 */     return this.opcaoSisacaoWSSoap.listaPorTickerDerivativoDe(idItem);
/* ;3:   */   }
/* ;4:   */   
/* ;5:   */   public OpcaoSisacaoObjetoWs[] listaPorOpcaoSisacaoSeriePertenceA(long idItem)
/* ;6:   */     throws RemoteException
/* ;7:   */   {
/* ;8:84 */     if (this.opcaoSisacaoWSSoap == null) {
/* ;9:85 */       _initOpcaoSisacaoWSSoapProxy();
/* <0:   */     }
/* <1:86 */     return this.opcaoSisacaoWSSoap.listaPorOpcaoSisacaoSeriePertenceA(idItem);
/* <2:   */   }
/* <3:   */   
/* <4:   */   public OpcaoSisacaoObjetoWs[] listaPorFiltroObjeto(OpcaoSisacaoFiltro filtro)
/* <5:   */     throws RemoteException
/* <6:   */   {
/* <7:90 */     if (this.opcaoSisacaoWSSoap == null) {
/* <8:91 */       _initOpcaoSisacaoWSSoapProxy();
/* <9:   */     }
/* =0:92 */     return this.opcaoSisacaoWSSoap.listaPorFiltroObjeto(filtro);
/* =1:   */   }
/* =2:   */   
/* =3:   */   public OpcaoSisacaoObjetoWs obtemPorChave(long id)
/* =4:   */     throws RemoteException
/* =5:   */   {
/* =6:96 */     if (this.opcaoSisacaoWSSoap == null) {
/* =7:97 */       _initOpcaoSisacaoWSSoapProxy();
/* =8:   */     }
/* =9:98 */     return this.opcaoSisacaoWSSoap.obtemPorChave(id);
/* >0:   */   }
/* >1:   */ }


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     sisacaoweb2online.webservice.OpcaoSisacaoWSSoapProxy
 * JD-Core Version:    0.7.0.1
 */