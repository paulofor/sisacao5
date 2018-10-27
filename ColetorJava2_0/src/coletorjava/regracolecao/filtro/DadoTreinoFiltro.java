
package coletorjava.regracolecao.filtro;

import java.util.List;
import coletorjava.modelo.*;
import javax.swing.JTextArea;



public class DadoTreinoFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idProjetoDadoTreinoPossui = -1;
		public long getCodigoProjetoDadoTreinoPossui() {
			return _codigo_idProjetoDadoTreinoPossui;
		}
		public void setCodigoProjetoDadoTreinoPossui(long dado) {
			_codigo_idProjetoDadoTreinoPossui = dado;
		}
      	




		
}