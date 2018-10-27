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
/*  12:    */ public class OpcaoSisacaoObjetoWs
/*  13:    */   implements Serializable
/*  14:    */ {
/*  15:    */   private long idOpcaoSisacao;
/*  16:    */   private String codigoMercado;
/*  17:    */   private float precoExercicio;
/*  18:    */   private long idTickerDd;
/*  19:    */   private long idOpcaoSisacaoSeriePa;
/*  20:    */   private TickerObjetoWs tickerDerivativoDe;
/*  21:    */   private OpcaoSisacaoSerieObjetoWs opcaoSisacaoSeriePertenceA;
/*  22:    */   
/*  23:    */   public OpcaoSisacaoObjetoWs(long idOpcaoSisacao, String codigoMercado, float precoExercicio, long idTickerDd, long idOpcaoSisacaoSeriePa, TickerObjetoWs tickerDerivativoDe, OpcaoSisacaoSerieObjetoWs opcaoSisacaoSeriePertenceA)
/*  24:    */   {
/*  25: 36 */     this.idOpcaoSisacao = idOpcaoSisacao;
/*  26: 37 */     this.codigoMercado = codigoMercado;
/*  27: 38 */     this.precoExercicio = precoExercicio;
/*  28: 39 */     this.idTickerDd = idTickerDd;
/*  29: 40 */     this.idOpcaoSisacaoSeriePa = idOpcaoSisacaoSeriePa;
/*  30: 41 */     this.tickerDerivativoDe = tickerDerivativoDe;
/*  31: 42 */     this.opcaoSisacaoSeriePertenceA = opcaoSisacaoSeriePertenceA;
/*  32:    */   }
/*  33:    */   
/*  34:    */   public long getIdOpcaoSisacao()
/*  35:    */   {
/*  36: 52 */     return this.idOpcaoSisacao;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public void setIdOpcaoSisacao(long idOpcaoSisacao)
/*  40:    */   {
/*  41: 62 */     this.idOpcaoSisacao = idOpcaoSisacao;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public String getCodigoMercado()
/*  45:    */   {
/*  46: 72 */     return this.codigoMercado;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public void setCodigoMercado(String codigoMercado)
/*  50:    */   {
/*  51: 82 */     this.codigoMercado = codigoMercado;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public float getPrecoExercicio()
/*  55:    */   {
/*  56: 92 */     return this.precoExercicio;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void setPrecoExercicio(float precoExercicio)
/*  60:    */   {
/*  61:102 */     this.precoExercicio = precoExercicio;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public long getIdTickerDd()
/*  65:    */   {
/*  66:112 */     return this.idTickerDd;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public void setIdTickerDd(long idTickerDd)
/*  70:    */   {
/*  71:122 */     this.idTickerDd = idTickerDd;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public long getIdOpcaoSisacaoSeriePa()
/*  75:    */   {
/*  76:132 */     return this.idOpcaoSisacaoSeriePa;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setIdOpcaoSisacaoSeriePa(long idOpcaoSisacaoSeriePa)
/*  80:    */   {
/*  81:142 */     this.idOpcaoSisacaoSeriePa = idOpcaoSisacaoSeriePa;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public TickerObjetoWs getTickerDerivativoDe()
/*  85:    */   {
/*  86:152 */     return this.tickerDerivativoDe;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void setTickerDerivativoDe(TickerObjetoWs tickerDerivativoDe)
/*  90:    */   {
/*  91:162 */     this.tickerDerivativoDe = tickerDerivativoDe;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public OpcaoSisacaoSerieObjetoWs getOpcaoSisacaoSeriePertenceA()
/*  95:    */   {
/*  96:172 */     return this.opcaoSisacaoSeriePertenceA;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void setOpcaoSisacaoSeriePertenceA(OpcaoSisacaoSerieObjetoWs opcaoSisacaoSeriePertenceA)
/* 100:    */   {
/* 101:182 */     this.opcaoSisacaoSeriePertenceA = opcaoSisacaoSeriePertenceA;
/* 102:    */   }
/* 103:    */   
/* 104:185 */   private Object __equalsCalc = null;
/* 105:    */   
/* 106:    */   public synchronized boolean equals(Object obj)
/* 107:    */   {
/* 108:187 */     if (!(obj instanceof OpcaoSisacaoObjetoWs)) {
/* 109:187 */       return false;
/* 110:    */     }
/* 111:188 */     OpcaoSisacaoObjetoWs other = (OpcaoSisacaoObjetoWs)obj;
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
/* 124:197 */       (this.idOpcaoSisacao == other.getIdOpcaoSisacao()) && (
/* 125:198 */       ((this.codigoMercado == null) && (other.getCodigoMercado() == null)) || (
/* 126:199 */       (this.codigoMercado != null) && 
/* 127:200 */       (this.codigoMercado.equals(other.getCodigoMercado())) && 
/* 128:201 */       (this.precoExercicio == other.getPrecoExercicio()) && 
/* 129:202 */       (this.idTickerDd == other.getIdTickerDd()) && 
/* 130:203 */       (this.idOpcaoSisacaoSeriePa == other.getIdOpcaoSisacaoSeriePa()) && (
/* 131:204 */       ((this.tickerDerivativoDe == null) && (other.getTickerDerivativoDe() == null)) || (
/* 132:205 */       (this.tickerDerivativoDe != null) && 
/* 133:206 */       (this.tickerDerivativoDe.equals(other.getTickerDerivativoDe())) && (
/* 134:207 */       ((this.opcaoSisacaoSeriePertenceA == null) && (other.getOpcaoSisacaoSeriePertenceA() == null)) || (
/* 135:208 */       (this.opcaoSisacaoSeriePertenceA != null) && 
/* 136:209 */       (this.opcaoSisacaoSeriePertenceA.equals(other.getOpcaoSisacaoSeriePertenceA()))))))));
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
/* 150:221 */     _hashCode += new Long(getIdOpcaoSisacao()).hashCode();
/* 151:222 */     if (getCodigoMercado() != null) {
/* 152:223 */       _hashCode += getCodigoMercado().hashCode();
/* 153:    */     }
/* 154:225 */     _hashCode += new Float(getPrecoExercicio()).hashCode();
/* 155:226 */     _hashCode += new Long(getIdTickerDd()).hashCode();
/* 156:227 */     _hashCode += new Long(getIdOpcaoSisacaoSeriePa()).hashCode();
/* 157:228 */     if (getTickerDerivativoDe() != null) {
/* 158:229 */       _hashCode += getTickerDerivativoDe().hashCode();
/* 159:    */     }
/* 160:231 */     if (getOpcaoSisacaoSeriePertenceA() != null) {
/* 161:232 */       _hashCode += getOpcaoSisacaoSeriePertenceA().hashCode();
/* 162:    */     }
/* 163:234 */     this.__hashCodeCalc = false;
/* 164:235 */     return _hashCode;
/* 165:    */   }
/* 166:    */   
/* 167:240 */   private static TypeDesc typeDesc = new TypeDesc(OpcaoSisacaoObjetoWs.class, true);
/* 168:    */   
/* 169:    */   static
/* 170:    */   {
/* 171:243 */     typeDesc.setXmlType(new QName("http://tempuri.org/", "OpcaoSisacaoObjetoWs"));
/* 172:244 */     ElementDesc elemField = new ElementDesc();
/* 173:245 */     elemField.setFieldName("idOpcaoSisacao");
/* 174:246 */     elemField.setXmlName(new QName("http://tempuri.org/", "IdOpcaoSisacao"));
/* 175:247 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
/* 176:248 */     elemField.setNillable(false);
/* 177:249 */     typeDesc.addFieldDesc(elemField);
/* 178:250 */     elemField = new ElementDesc();
/* 179:251 */     elemField.setFieldName("codigoMercado");
/* 180:252 */     elemField.setXmlName(new QName("http://tempuri.org/", "CodigoMercado"));
/* 181:253 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 182:254 */     elemField.setMinOccurs(0);
/* 183:255 */     elemField.setNillable(false);
/* 184:256 */     typeDesc.addFieldDesc(elemField);
/* 185:257 */     elemField = new ElementDesc();
/* 186:258 */     elemField.setFieldName("precoExercicio");
/* 187:259 */     elemField.setXmlName(new QName("http://tempuri.org/", "PrecoExercicio"));
/* 188:260 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "float"));
/* 189:261 */     elemField.setNillable(false);
/* 190:262 */     typeDesc.addFieldDesc(elemField);
/* 191:263 */     elemField = new ElementDesc();
/* 192:264 */     elemField.setFieldName("idTickerDd");
/* 193:265 */     elemField.setXmlName(new QName("http://tempuri.org/", "IdTickerDd"));
/* 194:266 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
/* 195:267 */     elemField.setNillable(false);
/* 196:268 */     typeDesc.addFieldDesc(elemField);
/* 197:269 */     elemField = new ElementDesc();
/* 198:270 */     elemField.setFieldName("idOpcaoSisacaoSeriePa");
/* 199:271 */     elemField.setXmlName(new QName("http://tempuri.org/", "IdOpcaoSisacaoSeriePa"));
/* 200:272 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
/* 201:273 */     elemField.setNillable(false);
/* 202:274 */     typeDesc.addFieldDesc(elemField);
/* 203:275 */     elemField = new ElementDesc();
/* 204:276 */     elemField.setFieldName("tickerDerivativoDe");
/* 205:277 */     elemField.setXmlName(new QName("http://tempuri.org/", "TickerDerivativoDe"));
/* 206:278 */     elemField.setXmlType(new QName("http://tempuri.org/", "TickerObjetoWs"));
/* 207:279 */     elemField.setMinOccurs(0);
/* 208:280 */     elemField.setNillable(false);
/* 209:281 */     typeDesc.addFieldDesc(elemField);
/* 210:282 */     elemField = new ElementDesc();
/* 211:283 */     elemField.setFieldName("opcaoSisacaoSeriePertenceA");
/* 212:284 */     elemField.setXmlName(new QName("http://tempuri.org/", "OpcaoSisacaoSeriePertenceA"));
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
/* 238:    */   public OpcaoSisacaoObjetoWs() {}
/* 239:    */ }


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     sisacaoweb2online.webservice.OpcaoSisacaoObjetoWs
 * JD-Core Version:    0.7.0.1
 */