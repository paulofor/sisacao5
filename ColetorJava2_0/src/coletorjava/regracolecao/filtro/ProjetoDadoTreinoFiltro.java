
package coletorjava.regracolecao.filtro;

import java.util.List;
import coletorjava.modelo.*;
import javax.swing.JTextArea;



public class ProjetoDadoTreinoFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idTickerReferenteA = -1;
		public long getCodigoTickerReferenteA() {
			return _codigo_idTickerReferenteA;
		}
		public void setCodigoTickerReferenteA(long dado) {
			_codigo_idTickerReferenteA = dado;
		}
      	

		private ProjetoDadoTreino _Item;
		public ProjetoDadoTreino getItem () {
			return _Item ;
		}
		public void setItem (ProjetoDadoTreino value) {
			_Item  = value;
		}
		
		public ProjetoDadoTreino validaItem() {
			
			if (_Item == null) {
				throw new RuntimeException("Item eh nulo");
			}
			
			return getItem ();
		}
		



		
}