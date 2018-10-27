
package coletorjava.regracolecao.filtro;

import java.util.List;
import coletorjava.modelo.*;
import javax.swing.JTextArea;



public class OpcaoSisacaoGeralFiltro {

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
      	

		private String _NomeCompletoArquivoBDI;
		public String getNomeCompletoArquivoBDI () {
			return _NomeCompletoArquivoBDI ;
		}
		public void setNomeCompletoArquivoBDI (String value) {
			_NomeCompletoArquivoBDI  = value;
		}
		
		public String validaNomeCompletoArquivoBDI() {
			
			if (_NomeCompletoArquivoBDI == null) {
				throw new RuntimeException("NomeCompletoArquivoBDI eh nulo");
			}
			
			return getNomeCompletoArquivoBDI ();
		}
		
		private String _MesAno;
		public String getMesAno () {
			return _MesAno ;
		}
		public void setMesAno (String value) {
			_MesAno  = value;
		}
		
		public String validaMesAno() {
			
			if (_MesAno == null) {
				throw new RuntimeException("MesAno eh nulo");
			}
			
			return getMesAno ();
		}
		
		private CotacaoDiario _CotacaoDiario;
		public CotacaoDiario getCotacaoDiario () {
			return _CotacaoDiario ;
		}
		public void setCotacaoDiario (CotacaoDiario value) {
			_CotacaoDiario  = value;
		}
		
		public CotacaoDiario validaCotacaoDiario() {
			
			if (_CotacaoDiario == null) {
				throw new RuntimeException("CotacaoDiario eh nulo");
			}
			
			return getCotacaoDiario ();
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
		


		//public String NomeCompletoArquivoBDI;
		//public String MesAno;
		//public String CodigoTicker;
		//public String Data;

		
}