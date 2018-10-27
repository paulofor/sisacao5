
package coletorjava.regracolecao.filtro;

import java.util.List;
import coletorjava.modelo.*;
import javax.swing.JTextArea;



public class ResultadoMesFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idProjetoDadoTreinoGeradoPor = -1;
		public long getCodigoProjetoDadoTreinoGeradoPor() {
			return _codigo_idProjetoDadoTreinoGeradoPor;
		}
		public void setCodigoProjetoDadoTreinoGeradoPor(long dado) {
			_codigo_idProjetoDadoTreinoGeradoPor = dado;
		}
      	
      	private long _codigo_idMesAnoReferenteA = -1;
		public long getCodigoMesAnoReferenteA() {
			return _codigo_idMesAnoReferenteA;
		}
		public void setCodigoMesAnoReferenteA(long dado) {
			_codigo_idMesAnoReferenteA = dado;
		}
      	




		
}