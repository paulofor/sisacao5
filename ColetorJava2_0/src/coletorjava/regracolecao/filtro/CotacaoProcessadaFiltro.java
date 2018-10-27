
package coletorjava.regracolecao.filtro;

import java.util.List;
import coletorjava.modelo.*;
import javax.swing.JTextArea;



public class CotacaoProcessadaFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}


		private String _DiaPregao;
		public String getDiaPregao () {
			return _DiaPregao ;
		}
		public void setDiaPregao (String value) {
			_DiaPregao  = value;
		}
		
		public String validaDiaPregao() {
			
			if (_DiaPregao == null) {
				throw new RuntimeException("DiaPregao eh nulo");
			}
			
			return getDiaPregao ();
		}
		
		private long _IntervaloTick;
		public long getIntervaloTick () {
			return _IntervaloTick ;
		}
		public void setIntervaloTick (long value) {
			_IntervaloTick  = value;
		}
		
		public long validaIntervaloTick() {
			
			if (_IntervaloTick == 0) {
				throw new RuntimeException("IntervaloTick eh zero");
			}
			
			return getIntervaloTick ();
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
		
		private CotacaoProcessada _CotacaoInsercao;
		public CotacaoProcessada getCotacaoInsercao () {
			return _CotacaoInsercao ;
		}
		public void setCotacaoInsercao (CotacaoProcessada value) {
			_CotacaoInsercao  = value;
		}
		
		public CotacaoProcessada validaCotacaoInsercao() {
			
			if (_CotacaoInsercao == null) {
				throw new RuntimeException("CotacaoInsercao eh nulo");
			}
			
			return getCotacaoInsercao ();
		}
		


		//public String DiaPregao;
		//public long IntervaloTick;
		//public String DataInicial;
		//public String DataFinal;
		//public String NomeTicker;
		//public String DataPesquisa;

		
}