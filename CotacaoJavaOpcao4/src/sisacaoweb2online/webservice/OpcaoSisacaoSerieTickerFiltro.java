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
/*  12:    */ public class OpcaoSisacaoSerieTickerFiltro
/*  13:    */   implements Serializable
/*  14:    */ {
/*  15:    */   private String dataAtual;
/*  16:    */   private float precoReferencia;
/*  17:    */   private String nomeTicker;
/*  18:    */   private String dataCotacaoReferencia;
/*  19:    */   private long codigoTickerReferenteA;
/*  20:    */   private long codigoOpcaoSisacaoSerieReferenteA;
/*  21:    */   
/*  22:    */   public OpcaoSisacaoSerieTickerFiltro(String dataAtual, float precoReferencia, String nomeTicker, String dataCotacaoReferencia, long codigoTickerReferenteA, long codigoOpcaoSisacaoSerieReferenteA)
/*  23:    */   {
/*  24: 33 */     this.dataAtual = dataAtual;
/*  25: 34 */     this.precoReferencia = precoReferencia;
/*  26: 35 */     this.nomeTicker = nomeTicker;
/*  27: 36 */     this.dataCotacaoReferencia = dataCotacaoReferencia;
/*  28: 37 */     this.codigoTickerReferenteA = codigoTickerReferenteA;
/*  29: 38 */     this.codigoOpcaoSisacaoSerieReferenteA = codigoOpcaoSisacaoSerieReferenteA;
/*  30:    */   }
/*  31:    */   
/*  32:    */   public String getDataAtual()
/*  33:    */   {
/*  34: 48 */     return this.dataAtual;
/*  35:    */   }
/*  36:    */   
/*  37:    */   public void setDataAtual(String dataAtual)
/*  38:    */   {
/*  39: 58 */     this.dataAtual = dataAtual;
/*  40:    */   }
/*  41:    */   
/*  42:    */   public float getPrecoReferencia()
/*  43:    */   {
/*  44: 68 */     return this.precoReferencia;
/*  45:    */   }
/*  46:    */   
/*  47:    */   public void setPrecoReferencia(float precoReferencia)
/*  48:    */   {
/*  49: 78 */     this.precoReferencia = precoReferencia;
/*  50:    */   }
/*  51:    */   
/*  52:    */   public String getNomeTicker()
/*  53:    */   {
/*  54: 88 */     return this.nomeTicker;
/*  55:    */   }
/*  56:    */   
/*  57:    */   public void setNomeTicker(String nomeTicker)
/*  58:    */   {
/*  59: 98 */     this.nomeTicker = nomeTicker;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public String getDataCotacaoReferencia()
/*  63:    */   {
/*  64:108 */     return this.dataCotacaoReferencia;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public void setDataCotacaoReferencia(String dataCotacaoReferencia)
/*  68:    */   {
/*  69:118 */     this.dataCotacaoReferencia = dataCotacaoReferencia;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public long getCodigoTickerReferenteA()
/*  73:    */   {
/*  74:128 */     return this.codigoTickerReferenteA;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public void setCodigoTickerReferenteA(long codigoTickerReferenteA)
/*  78:    */   {
/*  79:138 */     this.codigoTickerReferenteA = codigoTickerReferenteA;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public long getCodigoOpcaoSisacaoSerieReferenteA()
/*  83:    */   {
/*  84:148 */     return this.codigoOpcaoSisacaoSerieReferenteA;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public void setCodigoOpcaoSisacaoSerieReferenteA(long codigoOpcaoSisacaoSerieReferenteA)
/*  88:    */   {
/*  89:158 */     this.codigoOpcaoSisacaoSerieReferenteA = codigoOpcaoSisacaoSerieReferenteA;
/*  90:    */   }
/*  91:    */   
/*  92:161 */   private Object __equalsCalc = null;
/*  93:    */   
/*  94:    */   public synchronized boolean equals(Object obj)
/*  95:    */   {
/*  96:163 */     if (!(obj instanceof OpcaoSisacaoSerieTickerFiltro)) {
/*  97:163 */       return false;
/*  98:    */     }
/*  99:164 */     OpcaoSisacaoSerieTickerFiltro other = (OpcaoSisacaoSerieTickerFiltro)obj;
/* 100:165 */     if (obj == null) {
/* 101:165 */       return false;
/* 102:    */     }
/* 103:166 */     if (this == obj) {
/* 104:166 */       return true;
/* 105:    */     }
/* 106:167 */     if (this.__equalsCalc != null) {
/* 107:168 */       return this.__equalsCalc == obj;
/* 108:    */     }
/* 109:170 */     this.__equalsCalc = obj;
/* 110:    */     
/* 111:172 */     boolean _equals = 
/* 112:173 */       ((this.dataAtual == null) && (other.getDataAtual() == null)) || (
/* 113:174 */       (this.dataAtual != null) && 
/* 114:175 */       (this.dataAtual.equals(other.getDataAtual())) && 
/* 115:176 */       (this.precoReferencia == other.getPrecoReferencia()) && (
/* 116:177 */       ((this.nomeTicker == null) && (other.getNomeTicker() == null)) || (
/* 117:178 */       (this.nomeTicker != null) && 
/* 118:179 */       (this.nomeTicker.equals(other.getNomeTicker())) && (
/* 119:180 */       ((this.dataCotacaoReferencia == null) && (other.getDataCotacaoReferencia() == null)) || (
/* 120:181 */       (this.dataCotacaoReferencia != null) && 
/* 121:182 */       (this.dataCotacaoReferencia.equals(other.getDataCotacaoReferencia())) && 
/* 122:183 */       (this.codigoTickerReferenteA == other.getCodigoTickerReferenteA()) && 
/* 123:184 */       (this.codigoOpcaoSisacaoSerieReferenteA == other.getCodigoOpcaoSisacaoSerieReferenteA()))))));
/* 124:185 */     this.__equalsCalc = null;
/* 125:186 */     return _equals;
/* 126:    */   }
/* 127:    */   
/* 128:189 */   private boolean __hashCodeCalc = false;
/* 129:    */   
/* 130:    */   public synchronized int hashCode()
/* 131:    */   {
/* 132:191 */     if (this.__hashCodeCalc) {
/* 133:192 */       return 0;
/* 134:    */     }
/* 135:194 */     this.__hashCodeCalc = true;
/* 136:195 */     int _hashCode = 1;
/* 137:196 */     if (getDataAtual() != null) {
/* 138:197 */       _hashCode += getDataAtual().hashCode();
/* 139:    */     }
/* 140:199 */     _hashCode += new Float(getPrecoReferencia()).hashCode();
/* 141:200 */     if (getNomeTicker() != null) {
/* 142:201 */       _hashCode += getNomeTicker().hashCode();
/* 143:    */     }
/* 144:203 */     if (getDataCotacaoReferencia() != null) {
/* 145:204 */       _hashCode += getDataCotacaoReferencia().hashCode();
/* 146:    */     }
/* 147:206 */     _hashCode += new Long(getCodigoTickerReferenteA()).hashCode();
/* 148:207 */     _hashCode += new Long(getCodigoOpcaoSisacaoSerieReferenteA()).hashCode();
/* 149:208 */     this.__hashCodeCalc = false;
/* 150:209 */     return _hashCode;
/* 151:    */   }
/* 152:    */   
/* 153:214 */   private static TypeDesc typeDesc = new TypeDesc(OpcaoSisacaoSerieTickerFiltro.class, true);
/* 154:    */   
/* 155:    */   static
/* 156:    */   {
/* 157:217 */     typeDesc.setXmlType(new QName("http://tempuri.org/", "OpcaoSisacaoSerieTickerFiltro"));
/* 158:218 */     ElementDesc elemField = new ElementDesc();
/* 159:219 */     elemField.setFieldName("dataAtual");
/* 160:220 */     elemField.setXmlName(new QName("http://tempuri.org/", "DataAtual"));
/* 161:221 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 162:222 */     elemField.setMinOccurs(0);
/* 163:223 */     elemField.setNillable(false);
/* 164:224 */     typeDesc.addFieldDesc(elemField);
/* 165:225 */     elemField = new ElementDesc();
/* 166:226 */     elemField.setFieldName("precoReferencia");
/* 167:227 */     elemField.setXmlName(new QName("http://tempuri.org/", "PrecoReferencia"));
/* 168:228 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "float"));
/* 169:229 */     elemField.setNillable(false);
/* 170:230 */     typeDesc.addFieldDesc(elemField);
/* 171:231 */     elemField = new ElementDesc();
/* 172:232 */     elemField.setFieldName("nomeTicker");
/* 173:233 */     elemField.setXmlName(new QName("http://tempuri.org/", "NomeTicker"));
/* 174:234 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 175:235 */     elemField.setMinOccurs(0);
/* 176:236 */     elemField.setNillable(false);
/* 177:237 */     typeDesc.addFieldDesc(elemField);
/* 178:238 */     elemField = new ElementDesc();
/* 179:239 */     elemField.setFieldName("dataCotacaoReferencia");
/* 180:240 */     elemField.setXmlName(new QName("http://tempuri.org/", "DataCotacaoReferencia"));
/* 181:241 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 182:242 */     elemField.setMinOccurs(0);
/* 183:243 */     elemField.setNillable(false);
/* 184:244 */     typeDesc.addFieldDesc(elemField);
/* 185:245 */     elemField = new ElementDesc();
/* 186:246 */     elemField.setFieldName("codigoTickerReferenteA");
/* 187:247 */     elemField.setXmlName(new QName("http://tempuri.org/", "CodigoTickerReferenteA"));
/* 188:248 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
/* 189:249 */     elemField.setNillable(false);
/* 190:250 */     typeDesc.addFieldDesc(elemField);
/* 191:251 */     elemField = new ElementDesc();
/* 192:252 */     elemField.setFieldName("codigoOpcaoSisacaoSerieReferenteA");
/* 193:253 */     elemField.setXmlName(new QName("http://tempuri.org/", "CodigoOpcaoSisacaoSerieReferenteA"));
/* 194:254 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
/* 195:255 */     elemField.setNillable(false);
/* 196:256 */     typeDesc.addFieldDesc(elemField);
/* 197:    */   }
/* 198:    */   
/* 199:    */   public static TypeDesc getTypeDesc()
/* 200:    */   {
/* 201:263 */     return typeDesc;
/* 202:    */   }
/* 203:    */   
/* 204:    */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType)
/* 205:    */   {
/* 206:273 */     return 
/* 207:274 */       new BeanSerializer(
/* 208:275 */       _javaType, _xmlType, typeDesc);
/* 209:    */   }
/* 210:    */   
/* 211:    */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType)
/* 212:    */   {
/* 213:285 */     return 
/* 214:286 */       new BeanDeserializer(
/* 215:287 */       _javaType, _xmlType, typeDesc);
/* 216:    */   }
/* 217:    */   
/* 218:    */   public OpcaoSisacaoSerieTickerFiltro() {}
/* 219:    */ }


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     sisacaoweb2online.webservice.OpcaoSisacaoSerieTickerFiltro
 * JD-Core Version:    0.7.0.1
 */