/*   1:    */ package br.com.digicom.lib.dao;
/*   2:    */ 
/*   3:    */ import br.com.digicom.lib.DCIObjetoDominio;
/*   4:    */ import java.lang.reflect.InvocationTargetException;
/*   5:    */ import java.lang.reflect.Method;
/*   6:    */ import java.util.LinkedList;
/*   7:    */ import java.util.List;
/*   8:    */ 
/*   9:    */ public class MontadorDaoComposite
/*  10:    */   implements MontadorDaoI
/*  11:    */ {
/*  12:    */   private List classes;
/*  13:    */   private List montadores;
/*  14:    */   private List propriedades;
/*  15:    */   
/*  16:    */   public MontadorDaoComposite()
/*  17:    */   {
/*  18: 17 */     this.classes = new LinkedList();
/*  19: 18 */     this.montadores = new LinkedList();
/*  20: 19 */     this.propriedades = new LinkedList();
/*  21:    */   }
/*  22:    */   
/*  23:    */   public void adicionaMontador(MontadorDaoI montador, String nomePropriedade)
/*  24:    */   {
/*  25: 23 */     this.montadores.add(montador);
/*  26: 24 */     this.propriedades.add(nomePropriedade);
/*  27:    */   }
/*  28:    */   
/*  29:    */   private Object montaObjetoPrincipal(ResultadoLista resultadoLista, DCIObjetoDominio objeto)
/*  30:    */     throws DaoException
/*  31:    */   {
/*  32: 30 */     Object objFinal = null;
/*  33:    */     
/*  34: 32 */     int posicao = 1;
/*  35: 33 */     String propriedade = null;
/*  36: 34 */     MontadorDaoI oi = (MontadorDaoI)this.montadores.get(0);
/*  37: 35 */     objeto = oi.extraiRegistro(resultadoLista);
/*  38: 36 */     posicao += oi.quantidadeCampos();
/*  39: 37 */     for (int i = 1; i < this.montadores.size(); i++)
/*  40:    */     {
/*  41: 38 */       propriedade = (String)this.propriedades.get(i);
/*  42: 39 */       oi = (MontadorDaoI)this.montadores.get(i);
/*  43:    */       try
/*  44:    */       {
/*  45: 42 */         Class classeVo = obtemClasseVo(objeto);
/*  46: 43 */         DCIObjetoDominio dominio2 = oi.extraiRegistro(resultadoLista, 
/*  47: 44 */           posicao);
/*  48: 45 */         Class classeDominio2 = obtemClasseInterface(dominio2);
/*  49: 46 */         Method metodo = classeVo.getMethod("set" + propriedade, 
/*  50: 47 */           new Class[] { classeDominio2 });
/*  51: 48 */         metodo.invoke(objeto, new Object[] { dominio2 });
/*  52:    */       }
/*  53:    */       catch (Exception e)
/*  54:    */       {
/*  55: 50 */         e.printStackTrace();
/*  56:    */       }
/*  57: 56 */       posicao += oi.quantidadeCampos();
/*  58:    */     }
/*  59: 58 */     return objFinal;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public DCIObjetoDominio extraiRegistro(ResultadoLista resultadoLista, DCIObjetoDominio objeto, int posicao)
/*  63:    */     throws DaoException
/*  64:    */   {
/*  65: 63 */     return null;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public DCIObjetoDominio extraiRegistro(ResultadoLista resultadoLista)
/*  69:    */     throws DaoException
/*  70:    */   {
/*  71: 68 */     return null;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public DCIObjetoDominio extraiRegistro(ResultadoLista resultadoLista, int posicao)
/*  75:    */     throws DaoException
/*  76:    */   {
/*  77: 73 */     return null;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public int quantidadeCampos()
/*  81:    */   {
/*  82: 77 */     return 0;
/*  83:    */   }
/*  84:    */   
/*  85:    */   private Class obtemClasseVo(Object objeto)
/*  86:    */     throws ClassNotFoundException
/*  87:    */   {
/*  88: 81 */     return objeto.getClass();
/*  89:    */   }
/*  90:    */   
/*  91:    */   private Class obtemClasseInterface(Object objeto)
/*  92:    */     throws ClassNotFoundException
/*  93:    */   {
/*  94: 86 */     Class classe = objeto.getClass();
/*  95: 87 */     String nome = classe.getName();
/*  96: 88 */     String nome2 = nome.replaceAll(".vo", "");
/*  97: 89 */     String nomeVo = nome2.replaceAll("Vo", "");
/*  98: 90 */     Class classeVo = Class.forName(nomeVo);
/*  99: 91 */     return classeVo;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public DaoItemRetorno extraiRegistroListaInterna(ResultadoLista paramResultadoLista, DCIObjetoDominio objeto)
/* 103:    */     throws DaoException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException
/* 104:    */   {
/* 105: 99 */     DaoItemRetorno itemRetorno = new DaoItemRetorno();
/* 106:100 */     boolean saida = false;
/* 107:    */     
/* 108:102 */     Object objAux = null;
/* 109:103 */     if (objeto == null)
/* 110:    */     {
/* 111:105 */       int posicao = 1;
/* 112:106 */       String propriedade = null;
/* 113:107 */       MontadorDaoI oi = (MontadorDaoI)this.montadores.get(0);
/* 114:    */       
/* 115:109 */       objeto = oi.extraiRegistro(paramResultadoLista);
/* 116:110 */       posicao += oi.quantidadeCampos();
/* 117:111 */       for (int i = 1; i < this.montadores.size(); i++)
/* 118:    */       {
/* 119:113 */         propriedade = (String)this.propriedades.get(i);
/* 120:114 */         oi = (MontadorDaoI)this.montadores.get(i);
/* 121:    */         
/* 122:116 */         objAux = posicionaObjeto(objeto, propriedade);
/* 123:    */         
/* 124:118 */         DCIObjetoDominio obj2 = oi.extraiRegistro(paramResultadoLista, posicao);
/* 125:119 */         posicao += oi.quantidadeCampos();
/* 126:    */         
/* 127:121 */         Class classeVo = obtemClasseVo(objAux);
/* 128:122 */         Class classeDominio2 = obtemClasseInterface(obj2);
/* 129:123 */         Method metodo = classeVo.getMethod(propriedade, new Class[] { classeDominio2 });
/* 130:124 */         metodo.invoke(objAux, new Object[] { obj2 });
/* 131:    */         
/* 132:126 */         saida = true;
/* 133:    */       }
/* 134:    */     }
/* 135:    */     else
/* 136:    */     {
/* 137:130 */       int posicao = 1;
/* 138:131 */       String propriedade = null;
/* 139:132 */       MontadorDaoI oi = (MontadorDaoI)this.montadores.get(0);
/* 140:    */       
/* 141:134 */       DCIObjetoDominio objetoNovo = oi.extraiRegistro(paramResultadoLista);
/* 142:135 */       if (objetoNovo.getIdObj() == objeto.getIdObj())
/* 143:    */       {
/* 144:138 */         posicao += oi.quantidadeCampos();
/* 145:139 */         for (int i = 1; i < this.montadores.size(); i++)
/* 146:    */         {
/* 147:142 */           propriedade = (String)this.propriedades.get(i);
/* 148:143 */           oi = (MontadorDaoI)this.montadores.get(i);
/* 149:144 */           objAux = posicionaObjeto(objeto, propriedade);
/* 150:    */           
/* 151:146 */           DCIObjetoDominio obj2 = oi.extraiRegistro(paramResultadoLista, posicao);
/* 152:    */           
/* 153:148 */           Class classeVo = obtemClasseVo(objAux);
/* 154:149 */           Class classeDominio2 = obtemClasseInterface(obj2);
/* 155:150 */           Method metodo = classeVo.getMethod(propriedade, new Class[] { classeDominio2 });
/* 156:151 */           metodo.invoke(objAux, new Object[] { obj2 });
/* 157:    */           
/* 158:153 */           posicao += oi.quantidadeCampos();
/* 159:    */         }
/* 160:155 */         saida = false;
/* 161:    */       }
/* 162:    */       else
/* 163:    */       {
/* 164:158 */         objeto = objetoNovo;
/* 165:159 */         posicao += oi.quantidadeCampos();
/* 166:160 */         for (int i = 1; i < this.montadores.size(); i++)
/* 167:    */         {
/* 168:161 */           propriedade = (String)this.propriedades.get(i);
/* 169:162 */           oi = (MontadorDaoI)this.montadores.get(i);
/* 170:    */           
/* 171:164 */           objAux = posicionaObjeto(objeto, propriedade);
/* 172:    */           
/* 173:166 */           DCIObjetoDominio obj2 = oi.extraiRegistro(paramResultadoLista, posicao);
/* 174:    */           
/* 175:168 */           Class classeVo = obtemClasseVo(objAux);
/* 176:169 */           Class classeDominio2 = obtemClasseInterface(obj2);
/* 177:170 */           Method metodo = classeVo.getMethod(propriedade, new Class[] { classeDominio2 });
/* 178:171 */           metodo.invoke(objAux, new Object[] { obj2 });
/* 179:172 */           posicao += oi.quantidadeCampos();
/* 180:    */         }
/* 181:174 */         saida = true;
/* 182:    */       }
/* 183:    */     }
/* 184:178 */     itemRetorno.setInsere(saida);
/* 185:179 */     itemRetorno.setObjeto(objeto);
/* 186:180 */     return itemRetorno;
/* 187:    */   }
/* 188:    */   
/* 189:    */   public DaoItemRetorno extraiRegistroInterno(ResultadoLista paramResultadoLista, DCIObjetoDominio objeto)
/* 190:    */     throws DaoException
/* 191:    */   {
/* 192:187 */     return null;
/* 193:    */   }
/* 194:    */   
/* 195:    */   private Object posicionaObjeto(Object objetoRaiz, String propriedade)
/* 196:    */     throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException
/* 197:    */   {
/* 198:195 */     Object saida = objetoRaiz;
/* 199:196 */     if (propriedade == null) {
/* 200:196 */       return saida;
/* 201:    */     }
/* 202:197 */     String[] prop = propriedade.split(".");
/* 203:198 */     for (int i = 0; i < prop.length; i++)
/* 204:    */     {
/* 205:199 */       String propCorrente = prop[i];
/* 206:200 */       Class objetoVo = obtemClasseVo(saida);
/* 207:201 */       Class objetoI = obtemClasseInterface(saida);
/* 208:202 */       Method metodo = objetoVo.getMethod("get" + propriedade, new Class[0]);
/* 209:203 */       saida = metodo.invoke(objetoVo, new Object[0]);
/* 210:    */     }
/* 211:206 */     return saida;
/* 212:    */   }
/* 213:    */ }


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     br.com.digicom.lib.dao.MontadorDaoComposite
 * JD-Core Version:    0.7.0.1
 */