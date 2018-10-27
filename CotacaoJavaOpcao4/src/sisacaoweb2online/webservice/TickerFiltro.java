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
/*  12:    */ public class TickerFiltro
/*  13:    */   implements Serializable
/*  14:    */ {
/*  15:    */   private String dataAtivo;
/*  16:    */   private String nomeTicker;
/*  17:    */   private long codigoCombinacaoExecucaoCompraEmCombinacaoExecucaoCompraListaGerou;
/*  18:    */   private long codigoSplitEmSplitListaPossui;
/*  19:    */   private long codigoOpcaoSisacaoEmOpcaoSisacaoListaGera;
/*  20:    */   private long codigoOpcaoSisacaoSerieEmOpcaoSisacaoSerieTickerListaRelacionadoCom;
/*  21:    */   
/*  22:    */   public TickerFiltro(String dataAtivo, String nomeTicker, long codigoCombinacaoExecucaoCompraEmCombinacaoExecucaoCompraListaGerou, long codigoSplitEmSplitListaPossui, long codigoOpcaoSisacaoEmOpcaoSisacaoListaGera, long codigoOpcaoSisacaoSerieEmOpcaoSisacaoSerieTickerListaRelacionadoCom)
/*  23:    */   {
/*  24: 33 */     this.dataAtivo = dataAtivo;
/*  25: 34 */     this.nomeTicker = nomeTicker;
/*  26: 35 */     this.codigoCombinacaoExecucaoCompraEmCombinacaoExecucaoCompraListaGerou = codigoCombinacaoExecucaoCompraEmCombinacaoExecucaoCompraListaGerou;
/*  27: 36 */     this.codigoSplitEmSplitListaPossui = codigoSplitEmSplitListaPossui;
/*  28: 37 */     this.codigoOpcaoSisacaoEmOpcaoSisacaoListaGera = codigoOpcaoSisacaoEmOpcaoSisacaoListaGera;
/*  29: 38 */     this.codigoOpcaoSisacaoSerieEmOpcaoSisacaoSerieTickerListaRelacionadoCom = codigoOpcaoSisacaoSerieEmOpcaoSisacaoSerieTickerListaRelacionadoCom;
/*  30:    */   }
/*  31:    */   
/*  32:    */   public String getDataAtivo()
/*  33:    */   {
/*  34: 48 */     return this.dataAtivo;
/*  35:    */   }
/*  36:    */   
/*  37:    */   public void setDataAtivo(String dataAtivo)
/*  38:    */   {
/*  39: 58 */     this.dataAtivo = dataAtivo;
/*  40:    */   }
/*  41:    */   
/*  42:    */   public String getNomeTicker()
/*  43:    */   {
/*  44: 68 */     return this.nomeTicker;
/*  45:    */   }
/*  46:    */   
/*  47:    */   public void setNomeTicker(String nomeTicker)
/*  48:    */   {
/*  49: 78 */     this.nomeTicker = nomeTicker;
/*  50:    */   }
/*  51:    */   
/*  52:    */   public long getCodigoCombinacaoExecucaoCompraEmCombinacaoExecucaoCompraListaGerou()
/*  53:    */   {
/*  54: 88 */     return this.codigoCombinacaoExecucaoCompraEmCombinacaoExecucaoCompraListaGerou;
/*  55:    */   }
/*  56:    */   
/*  57:    */   public void setCodigoCombinacaoExecucaoCompraEmCombinacaoExecucaoCompraListaGerou(long codigoCombinacaoExecucaoCompraEmCombinacaoExecucaoCompraListaGerou)
/*  58:    */   {
/*  59: 98 */     this.codigoCombinacaoExecucaoCompraEmCombinacaoExecucaoCompraListaGerou = codigoCombinacaoExecucaoCompraEmCombinacaoExecucaoCompraListaGerou;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public long getCodigoSplitEmSplitListaPossui()
/*  63:    */   {
/*  64:108 */     return this.codigoSplitEmSplitListaPossui;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public void setCodigoSplitEmSplitListaPossui(long codigoSplitEmSplitListaPossui)
/*  68:    */   {
/*  69:118 */     this.codigoSplitEmSplitListaPossui = codigoSplitEmSplitListaPossui;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public long getCodigoOpcaoSisacaoEmOpcaoSisacaoListaGera()
/*  73:    */   {
/*  74:128 */     return this.codigoOpcaoSisacaoEmOpcaoSisacaoListaGera;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public void setCodigoOpcaoSisacaoEmOpcaoSisacaoListaGera(long codigoOpcaoSisacaoEmOpcaoSisacaoListaGera)
/*  78:    */   {
/*  79:138 */     this.codigoOpcaoSisacaoEmOpcaoSisacaoListaGera = codigoOpcaoSisacaoEmOpcaoSisacaoListaGera;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public long getCodigoOpcaoSisacaoSerieEmOpcaoSisacaoSerieTickerListaRelacionadoCom()
/*  83:    */   {
/*  84:148 */     return this.codigoOpcaoSisacaoSerieEmOpcaoSisacaoSerieTickerListaRelacionadoCom;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public void setCodigoOpcaoSisacaoSerieEmOpcaoSisacaoSerieTickerListaRelacionadoCom(long codigoOpcaoSisacaoSerieEmOpcaoSisacaoSerieTickerListaRelacionadoCom)
/*  88:    */   {
/*  89:158 */     this.codigoOpcaoSisacaoSerieEmOpcaoSisacaoSerieTickerListaRelacionadoCom = codigoOpcaoSisacaoSerieEmOpcaoSisacaoSerieTickerListaRelacionadoCom;
/*  90:    */   }
/*  91:    */   
/*  92:161 */   private Object __equalsCalc = null;
/*  93:    */   
/*  94:    */   public synchronized boolean equals(Object obj)
/*  95:    */   {
/*  96:163 */     if (!(obj instanceof TickerFiltro)) {
/*  97:163 */       return false;
/*  98:    */     }
/*  99:164 */     TickerFiltro other = (TickerFiltro)obj;
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
/* 112:173 */       ((this.dataAtivo == null) && (other.getDataAtivo() == null)) || (
/* 113:174 */       (this.dataAtivo != null) && 
/* 114:175 */       (this.dataAtivo.equals(other.getDataAtivo())) && (
/* 115:176 */       ((this.nomeTicker == null) && (other.getNomeTicker() == null)) || (
/* 116:177 */       (this.nomeTicker != null) && 
/* 117:178 */       (this.nomeTicker.equals(other.getNomeTicker())) && 
/* 118:179 */       (this.codigoCombinacaoExecucaoCompraEmCombinacaoExecucaoCompraListaGerou == other.getCodigoCombinacaoExecucaoCompraEmCombinacaoExecucaoCompraListaGerou()) && 
/* 119:180 */       (this.codigoSplitEmSplitListaPossui == other.getCodigoSplitEmSplitListaPossui()) && 
/* 120:181 */       (this.codigoOpcaoSisacaoEmOpcaoSisacaoListaGera == other.getCodigoOpcaoSisacaoEmOpcaoSisacaoListaGera()) && 
/* 121:182 */       (this.codigoOpcaoSisacaoSerieEmOpcaoSisacaoSerieTickerListaRelacionadoCom == other.getCodigoOpcaoSisacaoSerieEmOpcaoSisacaoSerieTickerListaRelacionadoCom()))));
/* 122:183 */     this.__equalsCalc = null;
/* 123:184 */     return _equals;
/* 124:    */   }
/* 125:    */   
/* 126:187 */   private boolean __hashCodeCalc = false;
/* 127:    */   
/* 128:    */   public synchronized int hashCode()
/* 129:    */   {
/* 130:189 */     if (this.__hashCodeCalc) {
/* 131:190 */       return 0;
/* 132:    */     }
/* 133:192 */     this.__hashCodeCalc = true;
/* 134:193 */     int _hashCode = 1;
/* 135:194 */     if (getDataAtivo() != null) {
/* 136:195 */       _hashCode += getDataAtivo().hashCode();
/* 137:    */     }
/* 138:197 */     if (getNomeTicker() != null) {
/* 139:198 */       _hashCode += getNomeTicker().hashCode();
/* 140:    */     }
/* 141:200 */     _hashCode += new Long(getCodigoCombinacaoExecucaoCompraEmCombinacaoExecucaoCompraListaGerou()).hashCode();
/* 142:201 */     _hashCode += new Long(getCodigoSplitEmSplitListaPossui()).hashCode();
/* 143:202 */     _hashCode += new Long(getCodigoOpcaoSisacaoEmOpcaoSisacaoListaGera()).hashCode();
/* 144:203 */     _hashCode += new Long(getCodigoOpcaoSisacaoSerieEmOpcaoSisacaoSerieTickerListaRelacionadoCom()).hashCode();
/* 145:204 */     this.__hashCodeCalc = false;
/* 146:205 */     return _hashCode;
/* 147:    */   }
/* 148:    */   
/* 149:210 */   private static TypeDesc typeDesc = new TypeDesc(TickerFiltro.class, true);
/* 150:    */   
/* 151:    */   static
/* 152:    */   {
/* 153:213 */     typeDesc.setXmlType(new QName("http://tempuri.org/", "TickerFiltro"));
/* 154:214 */     ElementDesc elemField = new ElementDesc();
/* 155:215 */     elemField.setFieldName("dataAtivo");
/* 156:216 */     elemField.setXmlName(new QName("http://tempuri.org/", "DataAtivo"));
/* 157:217 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 158:218 */     elemField.setMinOccurs(0);
/* 159:219 */     elemField.setNillable(false);
/* 160:220 */     typeDesc.addFieldDesc(elemField);
/* 161:221 */     elemField = new ElementDesc();
/* 162:222 */     elemField.setFieldName("nomeTicker");
/* 163:223 */     elemField.setXmlName(new QName("http://tempuri.org/", "NomeTicker"));
/* 164:224 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 165:225 */     elemField.setMinOccurs(0);
/* 166:226 */     elemField.setNillable(false);
/* 167:227 */     typeDesc.addFieldDesc(elemField);
/* 168:228 */     elemField = new ElementDesc();
/* 169:229 */     elemField.setFieldName("codigoCombinacaoExecucaoCompraEmCombinacaoExecucaoCompraListaGerou");
/* 170:230 */     elemField.setXmlName(new QName("http://tempuri.org/", "CodigoCombinacaoExecucaoCompraEmCombinacaoExecucaoCompraListaGerou"));
/* 171:231 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
/* 172:232 */     elemField.setNillable(false);
/* 173:233 */     typeDesc.addFieldDesc(elemField);
/* 174:234 */     elemField = new ElementDesc();
/* 175:235 */     elemField.setFieldName("codigoSplitEmSplitListaPossui");
/* 176:236 */     elemField.setXmlName(new QName("http://tempuri.org/", "CodigoSplitEmSplitListaPossui"));
/* 177:237 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
/* 178:238 */     elemField.setNillable(false);
/* 179:239 */     typeDesc.addFieldDesc(elemField);
/* 180:240 */     elemField = new ElementDesc();
/* 181:241 */     elemField.setFieldName("codigoOpcaoSisacaoEmOpcaoSisacaoListaGera");
/* 182:242 */     elemField.setXmlName(new QName("http://tempuri.org/", "CodigoOpcaoSisacaoEmOpcaoSisacaoListaGera"));
/* 183:243 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
/* 184:244 */     elemField.setNillable(false);
/* 185:245 */     typeDesc.addFieldDesc(elemField);
/* 186:246 */     elemField = new ElementDesc();
/* 187:247 */     elemField.setFieldName("codigoOpcaoSisacaoSerieEmOpcaoSisacaoSerieTickerListaRelacionadoCom");
/* 188:248 */     elemField.setXmlName(new QName("http://tempuri.org/", "CodigoOpcaoSisacaoSerieEmOpcaoSisacaoSerieTickerListaRelacionadoCom"));
/* 189:249 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
/* 190:250 */     elemField.setNillable(false);
/* 191:251 */     typeDesc.addFieldDesc(elemField);
/* 192:    */   }
/* 193:    */   
/* 194:    */   public static TypeDesc getTypeDesc()
/* 195:    */   {
/* 196:258 */     return typeDesc;
/* 197:    */   }
/* 198:    */   
/* 199:    */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType)
/* 200:    */   {
/* 201:268 */     return 
/* 202:269 */       new BeanSerializer(
/* 203:270 */       _javaType, _xmlType, typeDesc);
/* 204:    */   }
/* 205:    */   
/* 206:    */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType)
/* 207:    */   {
/* 208:280 */     return 
/* 209:281 */       new BeanDeserializer(
/* 210:282 */       _javaType, _xmlType, typeDesc);
/* 211:    */   }
/* 212:    */   
/* 213:    */   public TickerFiltro() {}
/* 214:    */ }


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     sisacaoweb2online.webservice.TickerFiltro
 * JD-Core Version:    0.7.0.1
 */