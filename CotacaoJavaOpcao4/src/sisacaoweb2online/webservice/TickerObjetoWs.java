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
/*  12:    */ public class TickerObjetoWs
/*  13:    */   implements Serializable
/*  14:    */ {
/*  15:    */   private long idTicker;
/*  16:    */   private String nome;
/*  17:    */   private String empresa;
/*  18:    */   private String tipoAcao;
/*  19:    */   private String dataInicio;
/*  20:    */   private boolean emEstudo;
/*  21:    */   private boolean ativoOpcao;
/*  22:    */   private boolean ativoOnline;
/*  23:    */   
/*  24:    */   public TickerObjetoWs(long idTicker, String nome, String empresa, String tipoAcao, String dataInicio, boolean emEstudo, boolean ativoOpcao, boolean ativoOnline)
/*  25:    */   {
/*  26: 39 */     this.idTicker = idTicker;
/*  27: 40 */     this.nome = nome;
/*  28: 41 */     this.empresa = empresa;
/*  29: 42 */     this.tipoAcao = tipoAcao;
/*  30: 43 */     this.dataInicio = dataInicio;
/*  31: 44 */     this.emEstudo = emEstudo;
/*  32: 45 */     this.ativoOpcao = ativoOpcao;
/*  33: 46 */     this.ativoOnline = ativoOnline;
/*  34:    */   }
/*  35:    */   
/*  36:    */   public long getIdTicker()
/*  37:    */   {
/*  38: 56 */     return this.idTicker;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public void setIdTicker(long idTicker)
/*  42:    */   {
/*  43: 66 */     this.idTicker = idTicker;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public String getNome()
/*  47:    */   {
/*  48: 76 */     return this.nome;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public void setNome(String nome)
/*  52:    */   {
/*  53: 86 */     this.nome = nome;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public String getEmpresa()
/*  57:    */   {
/*  58: 96 */     return this.empresa;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public void setEmpresa(String empresa)
/*  62:    */   {
/*  63:106 */     this.empresa = empresa;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public String getTipoAcao()
/*  67:    */   {
/*  68:116 */     return this.tipoAcao;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void setTipoAcao(String tipoAcao)
/*  72:    */   {
/*  73:126 */     this.tipoAcao = tipoAcao;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public String getDataInicio()
/*  77:    */   {
/*  78:136 */     return this.dataInicio;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void setDataInicio(String dataInicio)
/*  82:    */   {
/*  83:146 */     this.dataInicio = dataInicio;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public boolean isEmEstudo()
/*  87:    */   {
/*  88:156 */     return this.emEstudo;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public void setEmEstudo(boolean emEstudo)
/*  92:    */   {
/*  93:166 */     this.emEstudo = emEstudo;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public boolean isAtivoOpcao()
/*  97:    */   {
/*  98:176 */     return this.ativoOpcao;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public void setAtivoOpcao(boolean ativoOpcao)
/* 102:    */   {
/* 103:186 */     this.ativoOpcao = ativoOpcao;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public boolean isAtivoOnline()
/* 107:    */   {
/* 108:196 */     return this.ativoOnline;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public void setAtivoOnline(boolean ativoOnline)
/* 112:    */   {
/* 113:206 */     this.ativoOnline = ativoOnline;
/* 114:    */   }
/* 115:    */   
/* 116:209 */   private Object __equalsCalc = null;
/* 117:    */   
/* 118:    */   public synchronized boolean equals(Object obj)
/* 119:    */   {
/* 120:211 */     if (!(obj instanceof TickerObjetoWs)) {
/* 121:211 */       return false;
/* 122:    */     }
/* 123:212 */     TickerObjetoWs other = (TickerObjetoWs)obj;
/* 124:213 */     if (obj == null) {
/* 125:213 */       return false;
/* 126:    */     }
/* 127:214 */     if (this == obj) {
/* 128:214 */       return true;
/* 129:    */     }
/* 130:215 */     if (this.__equalsCalc != null) {
/* 131:216 */       return this.__equalsCalc == obj;
/* 132:    */     }
/* 133:218 */     this.__equalsCalc = obj;
/* 134:    */     
/* 135:220 */     boolean _equals = 
/* 136:221 */       (this.idTicker == other.getIdTicker()) && (
/* 137:222 */       ((this.nome == null) && (other.getNome() == null)) || (
/* 138:223 */       (this.nome != null) && 
/* 139:224 */       (this.nome.equals(other.getNome())) && (
/* 140:225 */       ((this.empresa == null) && (other.getEmpresa() == null)) || (
/* 141:226 */       (this.empresa != null) && 
/* 142:227 */       (this.empresa.equals(other.getEmpresa())) && (
/* 143:228 */       ((this.tipoAcao == null) && (other.getTipoAcao() == null)) || (
/* 144:229 */       (this.tipoAcao != null) && 
/* 145:230 */       (this.tipoAcao.equals(other.getTipoAcao())) && (
/* 146:231 */       ((this.dataInicio == null) && (other.getDataInicio() == null)) || (
/* 147:232 */       (this.dataInicio != null) && 
/* 148:233 */       (this.dataInicio.equals(other.getDataInicio())) && 
/* 149:234 */       (this.emEstudo == other.isEmEstudo()) && 
/* 150:235 */       (this.ativoOpcao == other.isAtivoOpcao()) && 
/* 151:236 */       (this.ativoOnline == other.isAtivoOnline())))))))));
/* 152:237 */     this.__equalsCalc = null;
/* 153:238 */     return _equals;
/* 154:    */   }
/* 155:    */   
/* 156:241 */   private boolean __hashCodeCalc = false;
/* 157:    */   
/* 158:    */   public synchronized int hashCode()
/* 159:    */   {
/* 160:243 */     if (this.__hashCodeCalc) {
/* 161:244 */       return 0;
/* 162:    */     }
/* 163:246 */     this.__hashCodeCalc = true;
/* 164:247 */     int _hashCode = 1;
/* 165:248 */     _hashCode += new Long(getIdTicker()).hashCode();
/* 166:249 */     if (getNome() != null) {
/* 167:250 */       _hashCode += getNome().hashCode();
/* 168:    */     }
/* 169:252 */     if (getEmpresa() != null) {
/* 170:253 */       _hashCode += getEmpresa().hashCode();
/* 171:    */     }
/* 172:255 */     if (getTipoAcao() != null) {
/* 173:256 */       _hashCode += getTipoAcao().hashCode();
/* 174:    */     }
/* 175:258 */     if (getDataInicio() != null) {
/* 176:259 */       _hashCode += getDataInicio().hashCode();
/* 177:    */     }
/* 178:261 */     _hashCode += (isEmEstudo() ? Boolean.TRUE : Boolean.FALSE).hashCode();
/* 179:262 */     _hashCode += (isAtivoOpcao() ? Boolean.TRUE : Boolean.FALSE).hashCode();
/* 180:263 */     _hashCode += (isAtivoOnline() ? Boolean.TRUE : Boolean.FALSE).hashCode();
/* 181:264 */     this.__hashCodeCalc = false;
/* 182:265 */     return _hashCode;
/* 183:    */   }
/* 184:    */   
/* 185:270 */   private static TypeDesc typeDesc = new TypeDesc(TickerObjetoWs.class, true);
/* 186:    */   
/* 187:    */   static
/* 188:    */   {
/* 189:273 */     typeDesc.setXmlType(new QName("http://tempuri.org/", "TickerObjetoWs"));
/* 190:274 */     ElementDesc elemField = new ElementDesc();
/* 191:275 */     elemField.setFieldName("idTicker");
/* 192:276 */     elemField.setXmlName(new QName("http://tempuri.org/", "IdTicker"));
/* 193:277 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
/* 194:278 */     elemField.setNillable(false);
/* 195:279 */     typeDesc.addFieldDesc(elemField);
/* 196:280 */     elemField = new ElementDesc();
/* 197:281 */     elemField.setFieldName("nome");
/* 198:282 */     elemField.setXmlName(new QName("http://tempuri.org/", "Nome"));
/* 199:283 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 200:284 */     elemField.setMinOccurs(0);
/* 201:285 */     elemField.setNillable(false);
/* 202:286 */     typeDesc.addFieldDesc(elemField);
/* 203:287 */     elemField = new ElementDesc();
/* 204:288 */     elemField.setFieldName("empresa");
/* 205:289 */     elemField.setXmlName(new QName("http://tempuri.org/", "Empresa"));
/* 206:290 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 207:291 */     elemField.setMinOccurs(0);
/* 208:292 */     elemField.setNillable(false);
/* 209:293 */     typeDesc.addFieldDesc(elemField);
/* 210:294 */     elemField = new ElementDesc();
/* 211:295 */     elemField.setFieldName("tipoAcao");
/* 212:296 */     elemField.setXmlName(new QName("http://tempuri.org/", "TipoAcao"));
/* 213:297 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 214:298 */     elemField.setMinOccurs(0);
/* 215:299 */     elemField.setNillable(false);
/* 216:300 */     typeDesc.addFieldDesc(elemField);
/* 217:301 */     elemField = new ElementDesc();
/* 218:302 */     elemField.setFieldName("dataInicio");
/* 219:303 */     elemField.setXmlName(new QName("http://tempuri.org/", "DataInicio"));
/* 220:304 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 221:305 */     elemField.setMinOccurs(0);
/* 222:306 */     elemField.setNillable(false);
/* 223:307 */     typeDesc.addFieldDesc(elemField);
/* 224:308 */     elemField = new ElementDesc();
/* 225:309 */     elemField.setFieldName("emEstudo");
/* 226:310 */     elemField.setXmlName(new QName("http://tempuri.org/", "EmEstudo"));
/* 227:311 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
/* 228:312 */     elemField.setNillable(false);
/* 229:313 */     typeDesc.addFieldDesc(elemField);
/* 230:314 */     elemField = new ElementDesc();
/* 231:315 */     elemField.setFieldName("ativoOpcao");
/* 232:316 */     elemField.setXmlName(new QName("http://tempuri.org/", "AtivoOpcao"));
/* 233:317 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
/* 234:318 */     elemField.setNillable(false);
/* 235:319 */     typeDesc.addFieldDesc(elemField);
/* 236:320 */     elemField = new ElementDesc();
/* 237:321 */     elemField.setFieldName("ativoOnline");
/* 238:322 */     elemField.setXmlName(new QName("http://tempuri.org/", "AtivoOnline"));
/* 239:323 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
/* 240:324 */     elemField.setNillable(false);
/* 241:325 */     typeDesc.addFieldDesc(elemField);
/* 242:    */   }
/* 243:    */   
/* 244:    */   public static TypeDesc getTypeDesc()
/* 245:    */   {
/* 246:332 */     return typeDesc;
/* 247:    */   }
/* 248:    */   
/* 249:    */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType)
/* 250:    */   {
/* 251:342 */     return 
/* 252:343 */       new BeanSerializer(
/* 253:344 */       _javaType, _xmlType, typeDesc);
/* 254:    */   }
/* 255:    */   
/* 256:    */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType)
/* 257:    */   {
/* 258:354 */     return 
/* 259:355 */       new BeanDeserializer(
/* 260:356 */       _javaType, _xmlType, typeDesc);
/* 261:    */   }
/* 262:    */   
/* 263:    */   public TickerObjetoWs() {}
/* 264:    */ }


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     sisacaoweb2online.webservice.TickerObjetoWs
 * JD-Core Version:    0.7.0.1
 */