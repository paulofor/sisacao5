
package coletorjava.regracolecao.filtro;

import java.util.List;
import coletorjava.modelo.*;
import javax.swing.JTextArea;



public class DiaPregaoFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
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
		
		private String _DataInicialPesquisa;
		public String getDataInicialPesquisa () {
			return _DataInicialPesquisa ;
		}
		public void setDataInicialPesquisa (String value) {
			_DataInicialPesquisa  = value;
		}
		
		public String validaDataInicialPesquisa() {
			
			if (_DataInicialPesquisa == null) {
				throw new RuntimeException("DataInicialPesquisa eh nulo");
			}
			
			return getDataInicialPesquisa ();
		}
		
		private String _DataFinalPesquisa;
		public String getDataFinalPesquisa () {
			return _DataFinalPesquisa ;
		}
		public void setDataFinalPesquisa (String value) {
			_DataFinalPesquisa  = value;
		}
		
		public String validaDataFinalPesquisa() {
			
			if (_DataFinalPesquisa == null) {
				throw new RuntimeException("DataFinalPesquisa eh nulo");
			}
			
			return getDataFinalPesquisa ();
		}
		
		private long _DiasDeslocamento;
		public long getDiasDeslocamento () {
			return _DiasDeslocamento ;
		}
		public void setDiasDeslocamento (long value) {
			_DiasDeslocamento  = value;
		}
		
		public long validaDiasDeslocamento() {
			
			if (_DiasDeslocamento == 0) {
				throw new RuntimeException("DiasDeslocamento eh zero");
			}
			
			return getDiasDeslocamento ();
		}
		
		private String _DataDeslocamento;
		public String getDataDeslocamento () {
			return _DataDeslocamento ;
		}
		public void setDataDeslocamento (String value) {
			_DataDeslocamento  = value;
		}
		
		public String validaDataDeslocamento() {
			
			if (_DataDeslocamento == null) {
				throw new RuntimeException("DataDeslocamento eh nulo");
			}
			
			return getDataDeslocamento ();
		}
		
		private DiaPregao _Item;
		public DiaPregao getItem () {
			return _Item ;
		}
		public void setItem (DiaPregao value) {
			_Item  = value;
		}
		
		public DiaPregao validaItem() {
			
			if (_Item == null) {
				throw new RuntimeException("Item eh nulo");
			}
			
			return getItem ();
		}
		
		private String _DataMesAno;
		public String getDataMesAno () {
			return _DataMesAno ;
		}
		public void setDataMesAno (String value) {
			_DataMesAno  = value;
		}
		
		public String validaDataMesAno() {
			
			if (_DataMesAno == null) {
				throw new RuntimeException("DataMesAno eh nulo");
			}
			
			return getDataMesAno ();
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
		
		private OpcaoSisacao _OpcaoVencimento;
		public OpcaoSisacao getOpcaoVencimento () {
			return _OpcaoVencimento ;
		}
		public void setOpcaoVencimento (OpcaoSisacao value) {
			_OpcaoVencimento  = value;
		}
		
		public OpcaoSisacao validaOpcaoVencimento() {
			
			if (_OpcaoVencimento == null) {
				throw new RuntimeException("OpcaoVencimento eh nulo");
			}
			
			return getOpcaoVencimento ();
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
		


		//public String NomeTicker;
		//public String DataInicialPesquisa;
		//public String DataFinalPesquisa;
		//public long DiasDeslocamento;
		//public String DataDeslocamento;
		//public String DataMesAno;
		//public String DataSexta;
		//public String DataPesquisa;

		
}