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
/*  12:    */ public class OpcaoSisacaoSerieObjetoWs
/*  13:    */   implements Serializable
/*  14:    */ {
/*  15:    */   private long idOpcaoSisacaoSerie;
/*  16:    */   private boolean construida;
/*  17:    */   private boolean possuiIntraday;
/*  18:    */   private String mesAno;
/*  19:    */   private String letra;
/*  20:    */   private String dataVencimento;
/*  21:    */   private String dataInicioColeta;
/*  22:    */   
/*  23:    */   public OpcaoSisacaoSerieObjetoWs(long idOpcaoSisacaoSerie, boolean construida, boolean possuiIntraday, String mesAno, String letra, String dataVencimento, String dataInicioColeta)
/*  24:    */   {
/*  25: 36 */     this.idOpcaoSisacaoSerie = idOpcaoSisacaoSerie;
/*  26: 37 */     this.construida = construida;
/*  27: 38 */     this.possuiIntraday = possuiIntraday;
/*  28: 39 */     this.mesAno = mesAno;
/*  29: 40 */     this.letra = letra;
/*  30: 41 */     this.dataVencimento = dataVencimento;
/*  31: 42 */     this.dataInicioColeta = dataInicioColeta;
/*  32:    */   }
/*  33:    */   
/*  34:    */   public long getIdOpcaoSisacaoSerie()
/*  35:    */   {
/*  36: 52 */     return this.idOpcaoSisacaoSerie;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public void setIdOpcaoSisacaoSerie(long idOpcaoSisacaoSerie)
/*  40:    */   {
/*  41: 62 */     this.idOpcaoSisacaoSerie = idOpcaoSisacaoSerie;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public boolean isConstruida()
/*  45:    */   {
/*  46: 72 */     return this.construida;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public void setConstruida(boolean construida)
/*  50:    */   {
/*  51: 82 */     this.construida = construida;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public boolean isPossuiIntraday()
/*  55:    */   {
/*  56: 92 */     return this.possuiIntraday;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void setPossuiIntraday(boolean possuiIntraday)
/*  60:    */   {
/*  61:102 */     this.possuiIntraday = possuiIntraday;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public String getMesAno()
/*  65:    */   {
/*  66:112 */     return this.mesAno;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public void setMesAno(String mesAno)
/*  70:    */   {
/*  71:122 */     this.mesAno = mesAno;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public String getLetra()
/*  75:    */   {
/*  76:132 */     return this.letra;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setLetra(String letra)
/*  80:    */   {
/*  81:142 */     this.letra = letra;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public String getDataVencimento()
/*  85:    */   {
/*  86:152 */     return this.dataVencimento;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void setDataVencimento(String dataVencimento)
/*  90:    */   {
/*  91:162 */     this.dataVencimento = dataVencimento;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public String getDataInicioColeta()
/*  95:    */   {
/*  96:172 */     return this.dataInicioColeta;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void setDataInicioColeta(String dataInicioColeta)
/* 100:    */   {
/* 101:182 */     this.dataInicioColeta = dataInicioColeta;
/* 102:    */   }
/* 103:    */   
/* 104:185 */   private Object __equalsCalc = null;
/* 105:    */   
/* 106:    */   public synchronized boolean equals(Object obj)
/* 107:    */   {
/* 108:187 */     if (!(obj instanceof OpcaoSisacaoSerieObjetoWs)) {
/* 109:187 */       return false;
/* 110:    */     }
/* 111:188 */     OpcaoSisacaoSerieObjetoWs other = (OpcaoSisacaoSerieObjetoWs)obj;
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
/* 124:197 */       (this.idOpcaoSisacaoSerie == other.getIdOpcaoSisacaoSerie()) && 
/* 125:198 */       (this.construida == other.isConstruida()) && 
/* 126:199 */       (this.possuiIntraday == other.isPossuiIntraday()) && (
/* 127:200 */       ((this.mesAno == null) && (other.getMesAno() == null)) || (
/* 128:201 */       (this.mesAno != null) && 
/* 129:202 */       (this.mesAno.equals(other.getMesAno())) && (
/* 130:203 */       ((this.letra == null) && (other.getLetra() == null)) || (
/* 131:204 */       (this.letra != null) && 
/* 132:205 */       (this.letra.equals(other.getLetra())) && (
/* 133:206 */       ((this.dataVencimento == null) && (other.getDataVencimento() == null)) || (
/* 134:207 */       (this.dataVencimento != null) && 
/* 135:208 */       (this.dataVencimento.equals(other.getDataVencimento())) && (
/* 136:209 */       ((this.dataInicioColeta == null) && (other.getDataInicioColeta() == null)) || (
/* 137:210 */       (this.dataInicioColeta != null) && 
/* 138:211 */       (this.dataInicioColeta.equals(other.getDataInicioColeta()))))))))));
/* 139:212 */     this.__equalsCalc = null;
/* 140:213 */     return _equals;
/* 141:    */   }
/* 142:    */   
/* 143:216 */   private boolean __hashCodeCalc = false;
/* 144:    */   
/* 145:    */   public synchronized int hashCode()
/* 146:    */   {
/* 147:218 */     if (this.__hashCodeCalc) {
/* 148:219 */       return 0;
/* 149:    */     }
/* 150:221 */     this.__hashCodeCalc = true;
/* 151:222 */     int _hashCode = 1;
/* 152:223 */     _hashCode += new Long(getIdOpcaoSisacaoSerie()).hashCode();
/* 153:224 */     _hashCode += (isConstruida() ? Boolean.TRUE : Boolean.FALSE).hashCode();
/* 154:225 */     _hashCode += (isPossuiIntraday() ? Boolean.TRUE : Boolean.FALSE).hashCode();
/* 155:226 */     if (getMesAno() != null) {
/* 156:227 */       _hashCode += getMesAno().hashCode();
/* 157:    */     }
/* 158:229 */     if (getLetra() != null) {
/* 159:230 */       _hashCode += getLetra().hashCode();
/* 160:    */     }
/* 161:232 */     if (getDataVencimento() != null) {
/* 162:233 */       _hashCode += getDataVencimento().hashCode();
/* 163:    */     }
/* 164:235 */     if (getDataInicioColeta() != null) {
/* 165:236 */       _hashCode += getDataInicioColeta().hashCode();
/* 166:    */     }
/* 167:238 */     this.__hashCodeCalc = false;
/* 168:239 */     return _hashCode;
/* 169:    */   }
/* 170:    */   
/* 171:244 */   private static TypeDesc typeDesc = new TypeDesc(OpcaoSisacaoSerieObjetoWs.class, true);
/* 172:    */   
/* 173:    */   static
/* 174:    */   {
/* 175:247 */     typeDesc.setXmlType(new QName("http://tempuri.org/", "OpcaoSisacaoSerieObjetoWs"));
/* 176:248 */     ElementDesc elemField = new ElementDesc();
/* 177:249 */     elemField.setFieldName("idOpcaoSisacaoSerie");
/* 178:250 */     elemField.setXmlName(new QName("http://tempuri.org/", "IdOpcaoSisacaoSerie"));
/* 179:251 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
/* 180:252 */     elemField.setNillable(false);
/* 181:253 */     typeDesc.addFieldDesc(elemField);
/* 182:254 */     elemField = new ElementDesc();
/* 183:255 */     elemField.setFieldName("construida");
/* 184:256 */     elemField.setXmlName(new QName("http://tempuri.org/", "Construida"));
/* 185:257 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
/* 186:258 */     elemField.setNillable(false);
/* 187:259 */     typeDesc.addFieldDesc(elemField);
/* 188:260 */     elemField = new ElementDesc();
/* 189:261 */     elemField.setFieldName("possuiIntraday");
/* 190:262 */     elemField.setXmlName(new QName("http://tempuri.org/", "PossuiIntraday"));
/* 191:263 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
/* 192:264 */     elemField.setNillable(false);
/* 193:265 */     typeDesc.addFieldDesc(elemField);
/* 194:266 */     elemField = new ElementDesc();
/* 195:267 */     elemField.setFieldName("mesAno");
/* 196:268 */     elemField.setXmlName(new QName("http://tempuri.org/", "MesAno"));
/* 197:269 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 198:270 */     elemField.setMinOccurs(0);
/* 199:271 */     elemField.setNillable(false);
/* 200:272 */     typeDesc.addFieldDesc(elemField);
/* 201:273 */     elemField = new ElementDesc();
/* 202:274 */     elemField.setFieldName("letra");
/* 203:275 */     elemField.setXmlName(new QName("http://tempuri.org/", "Letra"));
/* 204:276 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 205:277 */     elemField.setMinOccurs(0);
/* 206:278 */     elemField.setNillable(false);
/* 207:279 */     typeDesc.addFieldDesc(elemField);
/* 208:280 */     elemField = new ElementDesc();
/* 209:281 */     elemField.setFieldName("dataVencimento");
/* 210:282 */     elemField.setXmlName(new QName("http://tempuri.org/", "DataVencimento"));
/* 211:283 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 212:284 */     elemField.setMinOccurs(0);
/* 213:285 */     elemField.setNillable(false);
/* 214:286 */     typeDesc.addFieldDesc(elemField);
/* 215:287 */     elemField = new ElementDesc();
/* 216:288 */     elemField.setFieldName("dataInicioColeta");
/* 217:289 */     elemField.setXmlName(new QName("http://tempuri.org/", "DataInicioColeta"));
/* 218:290 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 219:291 */     elemField.setMinOccurs(0);
/* 220:292 */     elemField.setNillable(false);
/* 221:293 */     typeDesc.addFieldDesc(elemField);
/* 222:    */   }
/* 223:    */   
/* 224:    */   public static TypeDesc getTypeDesc()
/* 225:    */   {
/* 226:300 */     return typeDesc;
/* 227:    */   }
/* 228:    */   
/* 229:    */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType)
/* 230:    */   {
/* 231:310 */     return 
/* 232:311 */       new BeanSerializer(
/* 233:312 */       _javaType, _xmlType, typeDesc);
/* 234:    */   }
/* 235:    */   
/* 236:    */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType)
/* 237:    */   {
/* 238:322 */     return 
/* 239:323 */       new BeanDeserializer(
/* 240:324 */       _javaType, _xmlType, typeDesc);
/* 241:    */   }
/* 242:    */   
/* 243:    */   public OpcaoSisacaoSerieObjetoWs() {}
/* 244:    */ }


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     sisacaoweb2online.webservice.OpcaoSisacaoSerieObjetoWs
 * JD-Core Version:    0.7.0.1
 */