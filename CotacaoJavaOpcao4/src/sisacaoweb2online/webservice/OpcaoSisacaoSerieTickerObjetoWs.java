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
/*  12:    */ public class OpcaoSisacaoSerieTickerObjetoWs
/*  13:    */   implements Serializable
/*  14:    */ {
/*  15:    */   private long idOpcaoSisacaoSerieTicker;
/*  16:    */   private float precoReferencia;
/*  17:    */   private String dataPrecoReferencia;
/*  18:    */   private long idTickerRa;
/*  19:    */   private long idOpcaoSisacaoSerieRa;
/*  20:    */   private TickerObjetoWs tickerReferenteA;
/*  21:    */   private OpcaoSisacaoSerieObjetoWs opcaoSisacaoSerieReferenteA;
/*  22:    */   
/*  23:    */   public OpcaoSisacaoSerieTickerObjetoWs(long idOpcaoSisacaoSerieTicker, float precoReferencia, String dataPrecoReferencia, long idTickerRa, long idOpcaoSisacaoSerieRa, TickerObjetoWs tickerReferenteA, OpcaoSisacaoSerieObjetoWs opcaoSisacaoSerieReferenteA)
/*  24:    */   {
/*  25: 36 */     this.idOpcaoSisacaoSerieTicker = idOpcaoSisacaoSerieTicker;
/*  26: 37 */     this.precoReferencia = precoReferencia;
/*  27: 38 */     this.dataPrecoReferencia = dataPrecoReferencia;
/*  28: 39 */     this.idTickerRa = idTickerRa;
/*  29: 40 */     this.idOpcaoSisacaoSerieRa = idOpcaoSisacaoSerieRa;
/*  30: 41 */     this.tickerReferenteA = tickerReferenteA;
/*  31: 42 */     this.opcaoSisacaoSerieReferenteA = opcaoSisacaoSerieReferenteA;
/*  32:    */   }
/*  33:    */   
/*  34:    */   public long getIdOpcaoSisacaoSerieTicker()
/*  35:    */   {
/*  36: 52 */     return this.idOpcaoSisacaoSerieTicker;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public void setIdOpcaoSisacaoSerieTicker(long idOpcaoSisacaoSerieTicker)
/*  40:    */   {
/*  41: 62 */     this.idOpcaoSisacaoSerieTicker = idOpcaoSisacaoSerieTicker;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public float getPrecoReferencia()
/*  45:    */   {
/*  46: 72 */     return this.precoReferencia;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public void setPrecoReferencia(float precoReferencia)
/*  50:    */   {
/*  51: 82 */     this.precoReferencia = precoReferencia;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public String getDataPrecoReferencia()
/*  55:    */   {
/*  56: 92 */     return this.dataPrecoReferencia;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void setDataPrecoReferencia(String dataPrecoReferencia)
/*  60:    */   {
/*  61:102 */     this.dataPrecoReferencia = dataPrecoReferencia;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public long getIdTickerRa()
/*  65:    */   {
/*  66:112 */     return this.idTickerRa;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public void setIdTickerRa(long idTickerRa)
/*  70:    */   {
/*  71:122 */     this.idTickerRa = idTickerRa;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public long getIdOpcaoSisacaoSerieRa()
/*  75:    */   {
/*  76:132 */     return this.idOpcaoSisacaoSerieRa;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setIdOpcaoSisacaoSerieRa(long idOpcaoSisacaoSerieRa)
/*  80:    */   {
/*  81:142 */     this.idOpcaoSisacaoSerieRa = idOpcaoSisacaoSerieRa;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public TickerObjetoWs getTickerReferenteA()
/*  85:    */   {
/*  86:152 */     return this.tickerReferenteA;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void setTickerReferenteA(TickerObjetoWs tickerReferenteA)
/*  90:    */   {
/*  91:162 */     this.tickerReferenteA = tickerReferenteA;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public OpcaoSisacaoSerieObjetoWs getOpcaoSisacaoSerieReferenteA()
/*  95:    */   {
/*  96:172 */     return this.opcaoSisacaoSerieReferenteA;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void setOpcaoSisacaoSerieReferenteA(OpcaoSisacaoSerieObjetoWs opcaoSisacaoSerieReferenteA)
/* 100:    */   {
/* 101:182 */     this.opcaoSisacaoSerieReferenteA = opcaoSisacaoSerieReferenteA;
/* 102:    */   }
/* 103:    */   
/* 104:185 */   private Object __equalsCalc = null;
/* 105:    */   
/* 106:    */   public synchronized boolean equals(Object obj)
/* 107:    */   {
/* 108:187 */     if (!(obj instanceof OpcaoSisacaoSerieTickerObjetoWs)) {
/* 109:187 */       return false;
/* 110:    */     }
/* 111:188 */     OpcaoSisacaoSerieTickerObjetoWs other = (OpcaoSisacaoSerieTickerObjetoWs)obj;
/* 112:189 */     if (obj == null) {
/* 113:189 */       return false;
/* 114:    */     }
/* 115:190 */     if (this == obj) {
/* 116:190 */       return true;
/* 117:    */     }
/* 118:191 */     if (this.__equalsCalc != null) {
/* 119:192 */       return this.__equalsCalc == obj;
/* 120:    */     }
/* 121:194 */     this.__equalsCalc = obj;
/* 122:    */     
/* 123:196 */     boolean _equals = 
/* 124:197 */       (this.idOpcaoSisacaoSerieTicker == other.getIdOpcaoSisacaoSerieTicker()) && 
/* 125:198 */       (this.precoReferencia == other.getPrecoReferencia()) && (
/* 126:199 */       ((this.dataPrecoReferencia == null) && (other.getDataPrecoReferencia() == null)) || (
/* 127:200 */       (this.dataPrecoReferencia != null) && 
/* 128:201 */       (this.dataPrecoReferencia.equals(other.getDataPrecoReferencia())) && 
/* 129:202 */       (this.idTickerRa == other.getIdTickerRa()) && 
/* 130:203 */       (this.idOpcaoSisacaoSerieRa == other.getIdOpcaoSisacaoSerieRa()) && (
/* 131:204 */       ((this.tickerReferenteA == null) && (other.getTickerReferenteA() == null)) || (
/* 132:205 */       (this.tickerReferenteA != null) && 
/* 133:206 */       (this.tickerReferenteA.equals(other.getTickerReferenteA())) && (
/* 134:207 */       ((this.opcaoSisacaoSerieReferenteA == null) && (other.getOpcaoSisacaoSerieReferenteA() == null)) || (
/* 135:208 */       (this.opcaoSisacaoSerieReferenteA != null) && 
/* 136:209 */       (this.opcaoSisacaoSerieReferenteA.equals(other.getOpcaoSisacaoSerieReferenteA()))))))));
/* 137:210 */     this.__equalsCalc = null;
/* 138:211 */     return _equals;
/* 139:    */   }
/* 140:    */   
/* 141:214 */   private boolean __hashCodeCalc = false;
/* 142:    */   
/* 143:    */   public synchronized int hashCode()
/* 144:    */   {
/* 145:216 */     if (this.__hashCodeCalc) {
/* 146:217 */       return 0;
/* 147:    */     }
/* 148:219 */     this.__hashCodeCalc = true;
/* 149:220 */     int _hashCode = 1;
/* 150:221 */     _hashCode += new Long(getIdOpcaoSisacaoSerieTicker()).hashCode();
/* 151:222 */     _hashCode += new Float(getPrecoReferencia()).hashCode();
/* 152:223 */     if (getDataPrecoReferencia() != null) {
/* 153:224 */       _hashCode += getDataPrecoReferencia().hashCode();
/* 154:    */     }
/* 155:226 */     _hashCode += new Long(getIdTickerRa()).hashCode();
/* 156:227 */     _hashCode += new Long(getIdOpcaoSisacaoSerieRa()).hashCode();
/* 157:228 */     if (getTickerReferenteA() != null) {
/* 158:229 */       _hashCode += getTickerReferenteA().hashCode();
/* 159:    */     }
/* 160:231 */     if (getOpcaoSisacaoSerieReferenteA() != null) {
/* 161:232 */       _hashCode += getOpcaoSisacaoSerieReferenteA().hashCode();
/* 162:    */     }
/* 163:234 */     this.__hashCodeCalc = false;
/* 164:235 */     return _hashCode;
/* 165:    */   }
/* 166:    */   
/* 167:240 */   private static TypeDesc typeDesc = new TypeDesc(OpcaoSisacaoSerieTickerObjetoWs.class, true);
/* 168:    */   
/* 169:    */   static
/* 170:    */   {
/* 171:243 */     typeDesc.setXmlType(new QName("http://tempuri.org/", "OpcaoSisacaoSerieTickerObjetoWs"));
/* 172:244 */     ElementDesc elemField = new ElementDesc();
/* 173:245 */     elemField.setFieldName("idOpcaoSisacaoSerieTicker");
/* 174:246 */     elemField.setXmlName(new QName("http://tempuri.org/", "IdOpcaoSisacaoSerieTicker"));
/* 175:247 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
/* 176:248 */     elemField.setNillable(false);
/* 177:249 */     typeDesc.addFieldDesc(elemField);
/* 178:250 */     elemField = new ElementDesc();
/* 179:251 */     elemField.setFieldName("precoReferencia");
/* 180:252 */     elemField.setXmlName(new QName("http://tempuri.org/", "PrecoReferencia"));
/* 181:253 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "float"));
/* 182:254 */     elemField.setNillable(false);
/* 183:255 */     typeDesc.addFieldDesc(elemField);
/* 184:256 */     elemField = new ElementDesc();
/* 185:257 */     elemField.setFieldName("dataPrecoReferencia");
/* 186:258 */     elemField.setXmlName(new QName("http://tempuri.org/", "DataPrecoReferencia"));
/* 187:259 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 188:260 */     elemField.setMinOccurs(0);
/* 189:261 */     elemField.setNillable(false);
/* 190:262 */     typeDesc.addFieldDesc(elemField);
/* 191:263 */     elemField = new ElementDesc();
/* 192:264 */     elemField.setFieldName("idTickerRa");
/* 193:265 */     elemField.setXmlName(new QName("http://tempuri.org/", "IdTickerRa"));
/* 194:266 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
/* 195:267 */     elemField.setNillable(false);
/* 196:268 */     typeDesc.addFieldDesc(elemField);
/* 197:269 */     elemField = new ElementDesc();
/* 198:270 */     elemField.setFieldName("idOpcaoSisacaoSerieRa");
/* 199:271 */     elemField.setXmlName(new QName("http://tempuri.org/", "IdOpcaoSisacaoSerieRa"));
/* 200:272 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
/* 201:273 */     elemField.setNillable(false);
/* 202:274 */     typeDesc.addFieldDesc(elemField);
/* 203:275 */     elemField = new ElementDesc();
/* 204:276 */     elemField.setFieldName("tickerReferenteA");
/* 205:277 */     elemField.setXmlName(new QName("http://tempuri.org/", "TickerReferenteA"));
/* 206:278 */     elemField.setXmlType(new QName("http://tempuri.org/", "TickerObjetoWs"));
/* 207:279 */     elemField.setMinOccurs(0);
/* 208:280 */     elemField.setNillable(false);
/* 209:281 */     typeDesc.addFieldDesc(elemField);
/* 210:282 */     elemField = new ElementDesc();
/* 211:283 */     elemField.setFieldName("opcaoSisacaoSerieReferenteA");
/* 212:284 */     elemField.setXmlName(new QName("http://tempuri.org/", "OpcaoSisacaoSerieReferenteA"));
/* 213:285 */     elemField.setXmlType(new QName("http://tempuri.org/", "OpcaoSisacaoSerieObjetoWs"));
/* 214:286 */     elemField.setMinOccurs(0);
/* 215:287 */     elemField.setNillable(false);
/* 216:288 */     typeDesc.addFieldDesc(elemField);
/* 217:    */   }
/* 218:    */   
/* 219:    */   public static TypeDesc getTypeDesc()
/* 220:    */   {
/* 221:295 */     return typeDesc;
/* 222:    */   }
/* 223:    */   
/* 224:    */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType)
/* 225:    */   {
/* 226:305 */     return 
/* 227:306 */       new BeanSerializer(
/* 228:307 */       _javaType, _xmlType, typeDesc);
/* 229:    */   }
/* 230:    */   
/* 231:    */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType)
/* 232:    */   {
/* 233:317 */     return 
/* 234:318 */       new BeanDeserializer(
/* 235:319 */       _javaType, _xmlType, typeDesc);
/* 236:    */   }
/* 237:    */   
/* 238:    */   public OpcaoSisacaoSerieTickerObjetoWs() {}
/* 239:    */ }


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     sisacaoweb2online.webservice.OpcaoSisacaoSerieTickerObjetoWs
 * JD-Core Version:    0.7.0.1
 */