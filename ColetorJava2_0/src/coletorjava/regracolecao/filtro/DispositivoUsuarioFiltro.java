
package coletorjava.regracolecao.filtro;

import java.util.List;
import coletorjava.modelo.*;
import javax.swing.JTextArea;



public class DispositivoUsuarioFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idUsuarioReferenteA = -1;
		public long getCodigoUsuarioReferenteA() {
			return _codigo_idUsuarioReferenteA;
		}
		public void setCodigoUsuarioReferenteA(long dado) {
			_codigo_idUsuarioReferenteA = dado;
		}
      	




		
}