
package coletorjava.regracolecao.filtro;

import java.util.List;
import coletorjava.modelo.*;
import javax.swing.JTextArea;



public class OpcaoSisacaoSerieFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}


		private String _MesAnoBd;
		public String getMesAnoBd () {
			return _MesAnoBd ;
		}
		public void setMesAnoBd (String value) {
			_MesAnoBd  = value;
		}
		
		public String validaMesAnoBd() {
			
			if (_MesAnoBd == null) {
				throw new RuntimeException("MesAnoBd eh nulo");
			}
			
			return getMesAnoBd ();
		}
		
		private String _Vencimento;
		public String getVencimento () {
			return _Vencimento ;
		}
		public void setVencimento (String value) {
			_Vencimento  = value;
		}
		
		public String validaVencimento() {
			
			if (_Vencimento == null) {
				throw new RuntimeException("Vencimento eh nulo");
			}
			
			return getVencimento ();
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
		
		private long _AnoPesquisa;
		public long getAnoPesquisa () {
			return _AnoPesquisa ;
		}
		public void setAnoPesquisa (long value) {
			_AnoPesquisa  = value;
		}
		
		public long validaAnoPesquisa() {
			
			if (_AnoPesquisa == 0) {
				throw new RuntimeException("AnoPesquisa eh zero");
			}
			
			return getAnoPesquisa ();
		}
		
		private MesAno _MesAnoEstudo;
		public MesAno getMesAnoEstudo () {
			return _MesAnoEstudo ;
		}
		public void setMesAnoEstudo (MesAno value) {
			_MesAnoEstudo  = value;
		}
		
		public MesAno validaMesAnoEstudo() {
			
			if (_MesAnoEstudo == null) {
				throw new RuntimeException("MesAnoEstudo eh nulo");
			}
			
			return getMesAnoEstudo ();
		}
		


		//public String MesAnoBd;
		//public String Vencimento;
		//public String Data;
		//public long AnoPesquisa;

		
}