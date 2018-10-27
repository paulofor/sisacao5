
package coletorjava.regracolecao.filtro;

import java.util.List;
import coletorjava.modelo.*;
import javax.swing.JTextArea;



public class ResultadoPrevisaoFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idDadoThetaGeradoDe = -1;
		public long getCodigoDadoThetaGeradoDe() {
			return _codigo_idDadoThetaGeradoDe;
		}
		public void setCodigoDadoThetaGeradoDe(long dado) {
			_codigo_idDadoThetaGeradoDe = dado;
		}
      	
      	private long _codigo_idResultadoMesMesmoPeriodo = -1;
		public long getCodigoResultadoMesMesmoPeriodo() {
			return _codigo_idResultadoMesMesmoPeriodo;
		}
		public void setCodigoResultadoMesMesmoPeriodo(long dado) {
			_codigo_idResultadoMesMesmoPeriodo = dado;
		}
      	
      	private long _codigo_idMesAnoReferenteA = -1;
		public long getCodigoMesAnoReferenteA() {
			return _codigo_idMesAnoReferenteA;
		}
		public void setCodigoMesAnoReferenteA(long dado) {
			_codigo_idMesAnoReferenteA = dado;
		}
      	




		
}