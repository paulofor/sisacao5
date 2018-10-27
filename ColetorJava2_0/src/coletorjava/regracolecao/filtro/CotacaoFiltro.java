
package coletorjava.regracolecao.filtro;

import java.util.List;
import coletorjava.modelo.*;
import javax.swing.JTextArea;



public class CotacaoFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}


		private String _DataPesquisa;
		public String getDataPesquisa () {
			return _DataPesquisa ;
		}
		public void setDataPesquisa (String value) {
			_DataPesquisa  = value;
		}
		
		public String validaDataPesquisa() {
			
			if (_DataPesquisa == null) {
				throw new RuntimeException("DataPesquisa eh nulo");
			}
			
			return getDataPesquisa ();
		}
		
		private String _NomeTicker;
		public String getNomeTicker () {
			return _NomeTicker ;
		}
		public void setNomeTicker (String value) {
			_NomeTicker  = value;
		}
		
		public String validaNomeTicker() {
			
			if (_NomeTicker == null) {
				throw new RuntimeException("NomeTicker eh nulo");
			}
			
			return getNomeTicker ();
		}
		
		private String _DataInicial;
		public String getDataInicial () {
			return _DataInicial ;
		}
		public void setDataInicial (String value) {
			_DataInicial  = value;
		}
		
		public String validaDataInicial() {
			
			if (_DataInicial == null) {
				throw new RuntimeException("DataInicial eh nulo");
			}
			
			return getDataInicial ();
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
		
		private Cotacao _Cotacao;
		public Cotacao getCotacao () {
			return _Cotacao ;
		}
		public void setCotacao (Cotacao value) {
			_Cotacao  = value;
		}
		
		public Cotacao validaCotacao() {
			
			if (_Cotacao == null) {
				throw new RuntimeException("Cotacao eh nulo");
			}
			
			return getCotacao ();
		}
		


		//public String DataPesquisa;
		//public String NomeTicker;
		//public String DataInicial;
		//public String DataFinal;

		
}