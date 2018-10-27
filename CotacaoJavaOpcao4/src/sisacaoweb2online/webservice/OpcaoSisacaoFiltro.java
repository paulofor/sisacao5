/*   1:    */ package sisacaoweb2online.webservice;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import javax.xml.namespace.QName;
/*   5:    */ import org.apache.axis.description.ElementDesc;
/*   6:    */ import org.apache.axis.description.TypeDesc;
/*   7:    */ import org.apache.axis.encoding.Deserializer;
/*   8:    */ import org.apache.axis.encoding.Serializer;
/*   9:    */ import org.apache.axis.encoding.ser.BeanDeserializer;
/*  10:    */ import org.apache.axis.encoding.ser.BeanSerializer;
/*  11:    */ 
/*  12:    */ public class OpcaoSisacaoFiltro
/*  13:    */   implements Serializable
/*  14:    */ {
/*  15:    */   private String dataAtivo;
/*  16:    */   private long codigoTickerDerivativoDe;
/*  17:    */   private long codigoOpcaoSisacaoSeriePertenceA;
/*  18:    */   
/*  19:    */   public OpcaoSisacaoFiltro(String dataAtivo, long codigoTickerDerivativoDe, long codigoOpcaoSisacaoSeriePertenceA)
/*  20:    */   {
/*  21: 24 */     this.dataAtivo = dataAtivo;
/*  22: 25 */     this.codigoTickerDerivativoDe = codigoTickerDerivativoDe;
/*  23: 26 */     this.codigoOpcaoSisacaoSeriePertenceA = codigoOpcaoSisacaoSeriePertenceA;
/*  24:    */   }
/*  25:    */   
/*  26:    */   public String getDataAtivo()
/*  27:    */   {
/*  28: 36 */     return this.dataAtivo;
/*  29:    */   }
/*  30:    */   
/*  31:    */   public void setDataAtivo(String dataAtivo)
/*  32:    */   {
/*  33: 46 */     this.dataAtivo = dataAtivo;
/*  34:    */   }
/*  35:    */   
/*  36:    */   public long getCodigoTickerDerivativoDe()
/*  37:    */   {
/*  38: 56 */     return this.codigoTickerDerivativoDe;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public void setCodigoTickerDerivativoDe(long codigoTickerDerivativoDe)
/*  42:    */   {
/*  43: 66 */     this.codigoTickerDerivativoDe = codigoTickerDerivativoDe;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public long getCodigoOpcaoSisacaoSeriePertenceA()
/*  47:    */   {
/*  48: 76 */     return this.codigoOpcaoSisacaoSeriePertenceA;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public void setCodigoOpcaoSisacaoSeriePertenceA(long codigoOpcaoSisacaoSeriePertenceA)
/*  52:    */   {
/*  53: 86 */     this.codigoOpcaoSisacaoSeriePertenceA = codigoOpcaoSisacaoSeriePertenceA;
/*  54:    */   }
/*  55:    */   
/*  56: 89 */   private Object __equalsCalc = null;
/*  57:    */   
/*  58:    */   public synchronized boolean equals(Object obj)
/*  59:    */   {
/*  60: 91 */     if (!(obj instanceof OpcaoSisacaoFiltro)) {
/*  61: 91 */       return false;
/*  62:    */     }
/*  63: 92 */     OpcaoSisacaoFiltro other = (OpcaoSisacaoFiltro)obj;
/*  64: 93 */     if (obj == null) {
/*  65: 93 */       return false;
/*  66:    */     }
/*  67: 94 */     if (this == obj) {
/*  68: 94 */       return true;
/*  69:    */     }
/*  70: 95 */     if (this.__equalsCalc != null) {
/*  71: 96 */       return this.__equalsCalc == obj;
/*  72:    */     }
/*  73: 98 */     this.__equalsCalc = obj;
/*  74:    */     
/*  75:100 */     boolean _equals = 
/*  76:101 */       ((this.dataAtivo == null) && (other.getDataAtivo() == null)) || (
/*  77:102 */       (this.dataAtivo != null) && 
/*  78:103 */       (this.dataAtivo.equals(other.getDataAtivo())) && 
/*  79:104 */       (this.codigoTickerDerivativoDe == other.getCodigoTickerDerivativoDe()) && 
/*  80:105 */       (this.codigoOpcaoSisacaoSeriePertenceA == other.getCodigoOpcaoSisacaoSeriePertenceA()));
/*  81:106 */     this.__equalsCalc = null;
/*  82:107 */     return _equals;
/*  83:    */   }
/*  84:    */   
/*  85:110 */   private boolean __hashCodeCalc = false;
/*  86:    */   
/*  87:    */   public synchronized int hashCode()
/*  88:    */   {
/*  89:112 */     if (this.__hashCodeCalc) {
/*  90:113 */       return 0;
/*  91:    */     }
/*  92:115 */     this.__hashCodeCalc = true;
/*  93:116 */     int _hashCode = 1;
/*  94:117 */     if (getDataAtivo() != null) {
/*  95:118 */       _hashCode += getDataAtivo().hashCode();
/*  96:    */     }
/*  97:120 */     _hashCode += new Long(getCodigoTickerDerivativoDe()).hashCode();
/*  98:121 */     _hashCode += new Long(getCodigoOpcaoSisacaoSeriePertenceA()).hashCode();
/*  99:122 */     this.__hashCodeCalc = false;
/* 100:123 */     return _hashCode;
/* 101:    */   }
/* 102:    */   
/* 103:128 */   private static TypeDesc typeDesc = new TypeDesc(OpcaoSisacaoFiltro.class, true);
/* 104:    */   
/* 105:    */   static
/* 106:    */   {
/* 107:131 */     typeDesc.setXmlType(new QName("http://tempuri.org/", "OpcaoSisacaoFiltro"));
/* 108:132 */     ElementDesc elemField = new ElementDesc();
/* 109:133 */     elemField.setFieldName("dataAtivo");
/* 110:134 */     elemField.setXmlName(new QName("http://tempuri.org/", "DataAtivo"));
/* 111:135 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 112:136 */     elemField.setMinOccurs(0);
/* 113:137 */     elemField.setNillable(false);
/* 114:138 */     typeDesc.addFieldDesc(elemField);
/* 115:139 */     elemField = new ElementDesc();
/* 116:140 */     elemField.setFieldName("codigoTickerDerivativoDe");
/* 117:141 */     elemField.setXmlName(new QName("http://tempuri.org/", "CodigoTickerDerivativoDe"));
/* 118:142 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
/* 119:143 */     elemField.setNillable(false);
/* 120:144 */     typeDesc.addFieldDesc(elemField);
/* 121:145 */     elemField = new ElementDesc();
/* 122:146 */     elemField.setFieldName("codigoOpcaoSisacaoSeriePertenceA");
/* 123:147 */     elemField.setXmlName(new QName("http://tempuri.org/", "CodigoOpcaoSisacaoSeriePertenceA"));
/* 124:148 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
/* 125:149 */     elemField.setNillable(false);
/* 126:150 */     typeDesc.addFieldDesc(elemField);
/* 127:    */   }
/* 128:    */   
/* 129:    */   public static TypeDesc getTypeDesc()
/* 130:    */   {
/* 131:157 */     return typeDesc;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType)
/* 135:    */   {
/* 136:167 */     return 
/* 137:168 */       new BeanSerializer(
/* 138:169 */       _javaType, _xmlType, typeDesc);
/* 139:    */   }
/* 140:    */   
/* 141:    */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType)
/* 142:    */   {
/* 143:179 */     return 
/* 144:180 */       new BeanDeserializer(
/* 145:181 */       _javaType, _xmlType, typeDesc);
/* 146:    */   }
/* 147:    */   
/* 148:    */   public OpcaoSisacaoFiltro() {}
/* 149:    */ }


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     sisacaoweb2online.webservice.OpcaoSisacaoFiltro
 * JD-Core Version:    0.7.0.1
 */