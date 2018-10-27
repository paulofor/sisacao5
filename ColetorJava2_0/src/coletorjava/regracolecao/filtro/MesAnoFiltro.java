
package coletorjava.regracolecao.filtro;

import java.util.List;
import coletorjava.modelo.*;
import javax.swing.JTextArea;



public class MesAnoFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}


		private long _AnoPesquisa;
		public long getAnoPesquisa () {
			return _AnoPesquisa ;
		}
		public void setAnoPesquisa (long value) {
			_AnoPesquisa  = value;
		}
		
		public long validaAnoPesquisa() {
			
			if (_AnoPesquisa == 0) {
				throw new RuntimeException("AnoPesquisa eh zero");
			}
			
			return getAnoPesquisa ();
		}
		
		private String _DataSimples;
		public String getDataSimples () {
			return _DataSimples ;
		}
		public void setDataSimples (String value) {
			_DataSimples  = value;
		}
		
		public String validaDataSimples() {
			
			if (_DataSimples == null) {
				throw new RuntimeException("DataSimples eh nulo");
			}
			
			return getDataSimples ();
		}
		


		//public long AnoPesquisa;
		//public String DataSimples;

		
}