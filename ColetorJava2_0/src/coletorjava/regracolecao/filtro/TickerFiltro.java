
package coletorjava.regracolecao.filtro;

import java.util.List;
import coletorjava.modelo.*;
import javax.swing.JTextArea;



public class TickerFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}


		private String _CodigoEmpresa;
		public String getCodigoEmpresa () {
			return _CodigoEmpresa ;
		}
		public void setCodigoEmpresa (String value) {
			_CodigoEmpresa  = value;
		}
		
		public String validaCodigoEmpresa() {
			
			if (_CodigoEmpresa == null) {
				throw new RuntimeException("CodigoEmpresa eh nulo");
			}
			
			return getCodigoEmpresa ();
		}
		
		private String _TipoAcao;
		public String getTipoAcao () {
			return _TipoAcao ;
		}
		public void setTipoAcao (String value) {
			_TipoAcao  = value;
		}
		
		public String validaTipoAcao() {
			
			if (_TipoAcao == null) {
				throw new RuntimeException("TipoAcao eh nulo");
			}
			
			return getTipoAcao ();
		}
		
		private OpcaoSisacaoGeral _OpcaoArquivo;
		public OpcaoSisacaoGeral getOpcaoArquivo () {
			return _OpcaoArquivo ;
		}
		public void setOpcaoArquivo (OpcaoSisacaoGeral value) {
			_OpcaoArquivo  = value;
		}
		
		public OpcaoSisacaoGeral validaOpcaoArquivo() {
			
			if (_OpcaoArquivo == null) {
				throw new RuntimeException("OpcaoArquivo eh nulo");
			}
			
			return getOpcaoArquivo ();
		}
		
		private CotacaoDiario _CotacaoDiarioOpcao;
		public CotacaoDiario getCotacaoDiarioOpcao () {
			return _CotacaoDiarioOpcao ;
		}
		public void setCotacaoDiarioOpcao (CotacaoDiario value) {
			_CotacaoDiarioOpcao  = value;
		}
		
		public CotacaoDiario validaCotacaoDiarioOpcao() {
			
			if (_CotacaoDiarioOpcao == null) {
				throw new RuntimeException("CotacaoDiarioOpcao eh nulo");
			}
			
			return getCotacaoDiarioOpcao ();
		}
		


		//public String CodigoEmpresa;
		//public String TipoAcao;

		
}