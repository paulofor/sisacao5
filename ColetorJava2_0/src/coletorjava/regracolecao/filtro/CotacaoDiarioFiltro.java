
package coletorjava.regracolecao.filtro;

import java.util.List;
import coletorjava.modelo.*;
import javax.swing.JTextArea;



public class CotacaoDiarioFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}


		private Ticker _Ticker;
		public Ticker getTicker () {
			return _Ticker ;
		}
		public void setTicker (Ticker value) {
			_Ticker  = value;
		}
		
		public Ticker validaTicker() {
			
			if (_Ticker == null) {
				throw new RuntimeException("Ticker eh nulo");
			}
			
			return getTicker ();
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
		
		private String _Ano;
		public String getAno () {
			return _Ano ;
		}
		public void setAno (String value) {
			_Ano  = value;
		}
		
		public String validaAno() {
			
			if (_Ano == null) {
				throw new RuntimeException("Ano eh nulo");
			}
			
			return getAno ();
		}
		
		private CotacaoDiario _Item;
		public CotacaoDiario getItem () {
			return _Item ;
		}
		public void setItem (CotacaoDiario value) {
			_Item  = value;
		}
		
		public CotacaoDiario validaItem() {
			
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
		
		private String _MesAnoPesquisa;
		public String getMesAnoPesquisa () {
			return _MesAnoPesquisa ;
		}
		public void setMesAnoPesquisa (String value) {
			_MesAnoPesquisa  = value;
		}
		
		public String validaMesAnoPesquisa() {
			
			if (_MesAnoPesquisa == null) {
				throw new RuntimeException("MesAnoPesquisa eh nulo");
			}
			
			return getMesAnoPesquisa ();
		}
		
		private String _LinhaArquivoDiario;
		public String getLinhaArquivoDiario () {
			return _LinhaArquivoDiario ;
		}
		public void setLinhaArquivoDiario (String value) {
			_LinhaArquivoDiario  = value;
		}
		
		public String validaLinhaArquivoDiario() {
			
			if (_LinhaArquivoDiario == null) {
				throw new RuntimeException("LinhaArquivoDiario eh nulo");
			}
			
			return getLinhaArquivoDiario ();
		}
		


		//public String Data;
		//public String Ano;
		//public String CodigoTicker;
		//public String MesAnoPesquisa;
		//public String LinhaArquivoDiario;

		
}