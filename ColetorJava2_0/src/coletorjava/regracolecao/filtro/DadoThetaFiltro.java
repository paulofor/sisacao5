
package coletorjava.regracolecao.filtro;

import java.util.List;
import coletorjava.modelo.*;
import javax.swing.JTextArea;



public class DadoThetaFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idTreinoRedeGeradoPor = -1;
		public long getCodigoTreinoRedeGeradoPor() {
			return _codigo_idTreinoRedeGeradoPor;
		}
		public void setCodigoTreinoRedeGeradoPor(long dado) {
			_codigo_idTreinoRedeGeradoPor = dado;
		}
      	




		
}