
package coletorjava.regracolecao.filtro;

import java.util.List;
import coletorjava.modelo.*;
import javax.swing.JTextArea;



public class EscolhaOpcaoFiltro {

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
      	
      	private long _codigo_idOpcaoSisacaoEscolha = -1;
		public long getCodigoOpcaoSisacaoEscolha() {
			return _codigo_idOpcaoSisacaoEscolha;
		}
		public void setCodigoOpcaoSisacaoEscolha(long dado) {
			_codigo_idOpcaoSisacaoEscolha = dado;
		}
      	
      	private long _codigo_idDiaPregaoReferenteA = -1;
		public long getCodigoDiaPregaoReferenteA() {
			return _codigo_idDiaPregaoReferenteA;
		}
		public void setCodigoDiaPregaoReferenteA(long dado) {
			_codigo_idDiaPregaoReferenteA = dado;
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
		
		private long _Ano;
		public long getAno () {
			return _Ano ;
		}
		public void setAno (long value) {
			_Ano  = value;
		}
		
		public long validaAno() {
			
			if (_Ano == 0) {
				throw new RuntimeException("Ano eh zero");
			}
			
			return getAno ();
		}
		
		private EscolhaOpcao _ItemAtualizacao;
		public EscolhaOpcao getItemAtualizacao () {
			return _ItemAtualizacao ;
		}
		public void setItemAtualizacao (EscolhaOpcao value) {
			_ItemAtualizacao  = value;
		}
		
		public EscolhaOpcao validaItemAtualizacao() {
			
			if (_ItemAtualizacao == null) {
				throw new RuntimeException("ItemAtualizacao eh nulo");
			}
			
			return getItemAtualizacao ();
		}
		
		private List _ListaDiaPregao;
		public List getListaDiaPregao () {
			return _ListaDiaPregao ;
		}
		public void setListaDiaPregao (List value) {
			_ListaDiaPregao  = value;
		}
		
		public List validaListaDiaPregao() {
			
			if (_ListaDiaPregao == null) {
				throw new RuntimeException("ListaDiaPregao eh nulo");
			}
			
			return getListaDiaPregao ();
		}
		


		//public String NomeTicker;
		//public long Ano;
		//public List ListaDiaPregao;

		
}