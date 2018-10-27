
package coletorjava.regracolecao.filtro;

import java.util.List;
import coletorjava.modelo.*;
import javax.swing.JTextArea;



public class OpcaoSisacaoFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idOpcaoSisacaoSeriePertenceA = -1;
		public long getCodigoOpcaoSisacaoSeriePertenceA() {
			return _codigo_idOpcaoSisacaoSeriePertenceA;
		}
		public void setCodigoOpcaoSisacaoSeriePertenceA(long dado) {
			_codigo_idOpcaoSisacaoSeriePertenceA = dado;
		}
      	
      	private long _codigo_idTickerDerivativoDe = -1;
		public long getCodigoTickerDerivativoDe() {
			return _codigo_idTickerDerivativoDe;
		}
		public void setCodigoTickerDerivativoDe(long dado) {
			_codigo_idTickerDerivativoDe = dado;
		}
      	

		private OpcaoSisacao _Item;
		public OpcaoSisacao getItem () {
			return _Item ;
		}
		public void setItem (OpcaoSisacao value) {
			_Item  = value;
		}
		
		public OpcaoSisacao validaItem() {
			
			if (_Item == null) {
				throw new RuntimeException("Item eh nulo");
			}
			
			return getItem ();
		}
		
		private String _CodigoTicker;
		public String getCodigoTicker () {
			return _CodigoTicker ;
		}
		public void setCodigoTicker (String value) {
			_CodigoTicker  = value;
		}
		
		public String validaCodigoTicker() {
			
			if (_CodigoTicker == null) {
				throw new RuntimeException("CodigoTicker eh nulo");
			}
			
			return getCodigoTicker ();
		}
		
		private String _Data;
		public String getData () {
			return _Data ;
		}
		public void setData (String value) {
			_Data  = value;
		}
		
		public String validaData() {
			
			if (_Data == null) {
				throw new RuntimeException("Data eh nulo");
			}
			
			return getData ();
		}
		
		private OpcaoSisacaoSerie _SeriePesquisa;
		public OpcaoSisacaoSerie getSeriePesquisa () {
			return _SeriePesquisa ;
		}
		public void setSeriePesquisa (OpcaoSisacaoSerie value) {
			_SeriePesquisa  = value;
		}
		
		public OpcaoSisacaoSerie validaSeriePesquisa() {
			
			if (_SeriePesquisa == null) {
				throw new RuntimeException("SeriePesquisa eh nulo");
			}
			
			return getSeriePesquisa ();
		}
		
		private Ticker _TickerPesquisa;
		public Ticker getTickerPesquisa () {
			return _TickerPesquisa ;
		}
		public void setTickerPesquisa (Ticker value) {
			_TickerPesquisa  = value;
		}
		
		public Ticker validaTickerPesquisa() {
			
			if (_TickerPesquisa == null) {
				throw new RuntimeException("TickerPesquisa eh nulo");
			}
			
			return getTickerPesquisa ();
		}
		


		//public String CodigoTicker;
		//public String Data;

		
}