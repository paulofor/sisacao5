
package coletorjava.regracolecao.filtro;

import java.util.List;
import coletorjava.modelo.*;
import javax.swing.JTextArea;



public class TreinoRedeFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idRedePertenceA = -1;
		public long getCodigoRedePertenceA() {
			return _codigo_idRedePertenceA;
		}
		public void setCodigoRedePertenceA(long dado) {
			_codigo_idRedePertenceA = dado;
		}
      	
      	private long _codigo_idDadoTreinoGeradoPor = -1;
		public long getCodigoDadoTreinoGeradoPor() {
			return _codigo_idDadoTreinoGeradoPor;
		}
		public void setCodigoDadoTreinoGeradoPor(long dado) {
			_codigo_idDadoTreinoGeradoPor = dado;
		}
      	




		
}