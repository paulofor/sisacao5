/*   1:    */ package sisacaoweb2online.webservice;
/*   2:    */ 
/*   3:    */ import java.net.MalformedURLException;
/*   4:    */ import java.net.URL;
/*   5:    */ import java.rmi.Remote;
/*   6:    */ import java.util.HashSet;
/*   7:    */ import java.util.Iterator;
/*   8:    */ import javax.xml.namespace.QName;
/*   9:    */ import javax.xml.rpc.ServiceException;
/*  10:    */ import org.apache.axis.AxisFault;
/*  11:    */ import org.apache.axis.EngineConfiguration;
/*  12:    */ import org.apache.axis.client.Service;
/*  13:    */ import org.apache.axis.client.Stub;
/*  14:    */ 
/*  15:    */ public class OpcaoSisacaoSerieTickerWSLocator
/*  16:    */   extends Service
/*  17:    */   implements OpcaoSisacaoSerieTickerWS
/*  18:    */ {
/*  19:    */   public OpcaoSisacaoSerieTickerWSLocator() {}
/*  20:    */   
/*  21:    */   public OpcaoSisacaoSerieTickerWSLocator(EngineConfiguration config)
/*  22:    */   {
/*  23: 17 */     super(config);
/*  24:    */   }
/*  25:    */   
/*  26:    */   public OpcaoSisacaoSerieTickerWSLocator(String wsdlLoc, QName sName)
/*  27:    */     throws ServiceException
/*  28:    */   {
/*  29: 21 */     super(wsdlLoc, sName);
/*  30:    */   }
/*  31:    */   
/*  32: 25 */   private String OpcaoSisacaoSerieTickerWSSoap_address = "http://digicom.kinghost.net/sisacaoweb2online/ws/OpcaoSisacaoSerieTickerWS.asmx";
/*  33:    */   
/*  34:    */   public String getOpcaoSisacaoSerieTickerWSSoapAddress()
/*  35:    */   {
/*  36: 28 */     return this.OpcaoSisacaoSerieTickerWSSoap_address;
/*  37:    */   }
/*  38:    */   
/*  39: 32 */   private String OpcaoSisacaoSerieTickerWSSoapWSDDServiceName = "OpcaoSisacaoSerieTickerWSSoap";
/*  40:    */   
/*  41:    */   public String getOpcaoSisacaoSerieTickerWSSoapWSDDServiceName()
/*  42:    */   {
/*  43: 35 */     return this.OpcaoSisacaoSerieTickerWSSoapWSDDServiceName;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public void setOpcaoSisacaoSerieTickerWSSoapWSDDServiceName(String name)
/*  47:    */   {
/*  48: 39 */     this.OpcaoSisacaoSerieTickerWSSoapWSDDServiceName = name;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public OpcaoSisacaoSerieTickerWSSoap getOpcaoSisacaoSerieTickerWSSoap()
/*  52:    */     throws ServiceException
/*  53:    */   {
				java.net.URL endpoint;
/*  54:    */     try
/*  55:    */     {
/*  56: 45 */       endpoint = new URL(this.OpcaoSisacaoSerieTickerWSSoap_address);
/*  57:    */     }
/*  58:    */     catch (MalformedURLException e)
/*  59:    */     {
/*  60:    */       throw new ServiceException(e);
/*  62:    */     }
/*  63:    */     
/*  64: 50 */     return getOpcaoSisacaoSerieTickerWSSoap(endpoint);
/*  65:    */   }
/*  66:    */   
/*  67:    */   public OpcaoSisacaoSerieTickerWSSoap getOpcaoSisacaoSerieTickerWSSoap(URL portAddress)
/*  68:    */     throws ServiceException
/*  69:    */   {
/*  70:    */     try
/*  71:    */     {
/*  72: 55 */       OpcaoSisacaoSerieTickerWSSoapStub _stub = new OpcaoSisacaoSerieTickerWSSoapStub(portAddress, this);
/*  73: 56 */       _stub.setPortName(getOpcaoSisacaoSerieTickerWSSoapWSDDServiceName());
/*  74: 57 */       return _stub;
/*  75:    */     }
/*  76:    */     catch (AxisFault e) {}
/*  77: 60 */     return null;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public void setOpcaoSisacaoSerieTickerWSSoapEndpointAddress(String address)
/*  81:    */   {
/*  82: 65 */     this.OpcaoSisacaoSerieTickerWSSoap_address = address;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public Remote getPort(Class serviceEndpointInterface)
/*  86:    */     throws ServiceException
/*  87:    */   {
/*  88:    */     try
/*  89:    */     {
/*  90: 75 */       if (OpcaoSisacaoSerieTickerWSSoap.class.isAssignableFrom(serviceEndpointInterface))
/*  91:    */       {
/*  92: 76 */         OpcaoSisacaoSerieTickerWSSoapStub _stub = new OpcaoSisacaoSerieTickerWSSoapStub(new URL(this.OpcaoSisacaoSerieTickerWSSoap_address), this);
/*  93: 77 */         _stub.setPortName(getOpcaoSisacaoSerieTickerWSSoapWSDDServiceName());
/*  94: 78 */         return _stub;
/*  95:    */       }
/*  96:    */     }
/*  97:    */     catch (Throwable t)
/*  98:    */     {
/*  99: 82 */       throw new ServiceException(t);
/* 100:    */     }
/* 101: 84 */     throw new ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
/* 102:    */   }
/* 103:    */   
/* 104:    */   public Remote getPort(QName portName, Class serviceEndpointInterface)
/* 105:    */     throws ServiceException
/* 106:    */   {
/* 107: 93 */     if (portName == null) {
/* 108: 94 */       return getPort(serviceEndpointInterface);
/* 109:    */     }
/* 110: 96 */     String inputPortName = portName.getLocalPart();
/* 111: 97 */     if ("OpcaoSisacaoSerieTickerWSSoap".equals(inputPortName)) {
/* 112: 98 */       return getOpcaoSisacaoSerieTickerWSSoap();
/* 113:    */     }
/* 114:101 */     Remote _stub = getPort(serviceEndpointInterface);
/* 115:102 */     ((Stub)_stub).setPortName(portName);
/* 116:103 */     return _stub;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public QName getServiceName()
/* 120:    */   {
/* 121:108 */     return new QName("http://tempuri.org/", "OpcaoSisacaoSerieTickerWS");
/* 122:    */   }
/* 123:    */   
/* 124:111 */   private HashSet ports = null;
/* 125:    */   
/* 126:    */   public Iterator getPorts()
/* 127:    */   {
/* 128:114 */     if (this.ports == null)
/* 129:    */     {
/* 130:115 */       this.ports = new HashSet();
/* 131:116 */       this.ports.add(new QName("http://tempuri.org/", "OpcaoSisacaoSerieTickerWSSoap"));
/* 132:    */     }
/* 133:118 */     return this.ports.iterator();
/* 134:    */   }
/* 135:    */   
/* 136:    */   public void setEndpointAddress(String portName, String address)
/* 137:    */     throws ServiceException
/* 138:    */   {
/* 139:126 */     if ("OpcaoSisacaoSerieTickerWSSoap".equals(portName)) {
/* 140:127 */       setOpcaoSisacaoSerieTickerWSSoapEndpointAddress(address);
/* 141:    */     } else {
/* 142:131 */       throw new ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
/* 143:    */     }
/* 144:    */   }
/* 145:    */   
/* 146:    */   public void setEndpointAddress(QName portName, String address)
/* 147:    */     throws ServiceException
/* 148:    */   {
/* 149:139 */     setEndpointAddress(portName.getLocalPart(), address);
/* 150:    */   }
/* 151:    */ }


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     sisacaoweb2online.webservice.OpcaoSisacaoSerieTickerWSLocator
 * JD-Core Version:    0.7.0.1
 */