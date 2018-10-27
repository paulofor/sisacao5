
package coletorjava.regracolecao.filtro;

import java.util.List;
import coletorjava.modelo.*;
import javax.swing.JTextArea;



public class OpcaoReferenciaFiltro {

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
      	
      	private long _codigo_idDiaPregaoReferenteA = -1;
		public long getCodigoDiaPregaoReferenteA() {
			return _codigo_idDiaPregaoReferenteA;
		}
		public void setCodigoDiaPregaoReferenteA(long dado) {
			_codigo_idDiaPregaoReferenteA = dado;
		}
      	
      	private long _codigo_idOpcaoSisacaoReferenteA = -1;
		public long getCodigoOpcaoSisacaoReferenteA() {
			return _codigo_idOpcaoSisacaoReferenteA;
		}
		public void setCodigoOpcaoSisacaoReferenteA(long dado) {
			_codigo_idOpcaoSisacaoReferenteA = dado;
		}
      	

		private String _DataSexta;
		public String getDataSexta () {
			return _DataSexta ;
		}
		public void setDataSexta (String value) {
			_DataSexta  = value;
		}
		
		public String validaDataSexta() {
			
			if (_DataSexta == null) {
				throw new RuntimeException("DataSexta eh nulo");
			}
			
			return getDataSexta ();
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
		
		private String _DataFinal;
		public String getDataFinal () {
			return _DataFinal ;
		}
		public void setDataFinal (String value) {
			_DataFinal  = value;
		}
		
		public String validaDataFinal() {
			
			if (_DataFinal == null) {
				throw new RuntimeException("DataFinal eh nulo");
			}
			
			return getDataFinal ();
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
		


		//public String DataSexta;
		//public String CodigoTicker;
		//public String DataFinal;
		//public String Data;

		
}