
package coletorjava.regracolecao.filtro;

import java.util.List;
import coletorjava.modelo.*;
import javax.swing.JTextArea;



public class CotacaoProcessadaOpcaoResultadoFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idOpcaoSisacaoReferenteA = -1;
		public long getCodigoOpcaoSisacaoReferenteA() {
			return _codigo_idOpcaoSisacaoReferenteA;
		}
		public void setCodigoOpcaoSisacaoReferenteA(long dado) {
			_codigo_idOpcaoSisacaoReferenteA = dado;
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
		
		private String _DataInicio;
		public String getDataInicio () {
			return _DataInicio ;
		}
		public void setDataInicio (String value) {
			_DataInicio  = value;
		}
		
		public String validaDataInicio() {
			
			if (_DataInicio == null) {
				throw new RuntimeException("DataInicio eh nulo");
			}
			
			return getDataInicio ();
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
		
		private long _CodigoFaixa;
		public long getCodigoFaixa () {
			return _CodigoFaixa ;
		}
		public void setCodigoFaixa (long value) {
			_CodigoFaixa  = value;
		}
		
		public long validaCodigoFaixa() {
			
			if (_CodigoFaixa == 0) {
				throw new RuntimeException("CodigoFaixa eh zero");
			}
			
			return getCodigoFaixa ();
		}
		
		private List _ListaCotacaoOpcao;
		public List getListaCotacaoOpcao () {
			return _ListaCotacaoOpcao ;
		}
		public void setListaCotacaoOpcao (List value) {
			_ListaCotacaoOpcao  = value;
		}
		
		public List validaListaCotacaoOpcao() {
			
			if (_ListaCotacaoOpcao == null) {
				throw new RuntimeException("ListaCotacaoOpcao eh nulo");
			}
			
			return getListaCotacaoOpcao ();
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
		
		private String _NomeOpcao;
		public String getNomeOpcao () {
			return _NomeOpcao ;
		}
		public void setNomeOpcao (String value) {
			_NomeOpcao  = value;
		}
		
		public String validaNomeOpcao() {
			
			if (_NomeOpcao == null) {
				throw new RuntimeException("NomeOpcao eh nulo");
			}
			
			return getNomeOpcao ();
		}
		
		private long _QuantidadeDiaIntradayArquivo;
		public long getQuantidadeDiaIntradayArquivo () {
			return _QuantidadeDiaIntradayArquivo ;
		}
		public void setQuantidadeDiaIntradayArquivo (long value) {
			_QuantidadeDiaIntradayArquivo  = value;
		}
		
		public long validaQuantidadeDiaIntradayArquivo() {
			
			if (_QuantidadeDiaIntradayArquivo == 0) {
				throw new RuntimeException("QuantidadeDiaIntradayArquivo eh zero");
			}
			
			return getQuantidadeDiaIntradayArquivo ();
		}
		
		private long _SaltoTickerIntraArquivo;
		public long getSaltoTickerIntraArquivo () {
			return _SaltoTickerIntraArquivo ;
		}
		public void setSaltoTickerIntraArquivo (long value) {
			_SaltoTickerIntraArquivo  = value;
		}
		
		public long validaSaltoTickerIntraArquivo() {
			
			if (_SaltoTickerIntraArquivo == 0) {
				throw new RuntimeException("SaltoTickerIntraArquivo eh zero");
			}
			
			return getSaltoTickerIntraArquivo ();
		}
		
		private long _TargetArquivo;
		public long getTargetArquivo () {
			return _TargetArquivo ;
		}
		public void setTargetArquivo (long value) {
			_TargetArquivo  = value;
		}
		
		public long validaTargetArquivo() {
			
			if (_TargetArquivo == 0) {
				throw new RuntimeException("TargetArquivo eh zero");
			}
			
			return getTargetArquivo ();
		}
		
		private long _StopArquivo;
		public long getStopArquivo () {
			return _StopArquivo ;
		}
		public void setStopArquivo (long value) {
			_StopArquivo  = value;
		}
		
		public long validaStopArquivo() {
			
			if (_StopArquivo == 0) {
				throw new RuntimeException("StopArquivo eh zero");
			}
			
			return getStopArquivo ();
		}
		
		private String _PosicaoCompraVendaArquivo;
		public String getPosicaoCompraVendaArquivo () {
			return _PosicaoCompraVendaArquivo ;
		}
		public void setPosicaoCompraVendaArquivo (String value) {
			_PosicaoCompraVendaArquivo  = value;
		}
		
		public String validaPosicaoCompraVendaArquivo() {
			
			if (_PosicaoCompraVendaArquivo == null) {
				throw new RuntimeException("PosicaoCompraVendaArquivo eh nulo");
			}
			
			return getPosicaoCompraVendaArquivo ();
		}
		
		private long _IdTickerArquivo;
		public long getIdTickerArquivo () {
			return _IdTickerArquivo ;
		}
		public void setIdTickerArquivo (long value) {
			_IdTickerArquivo  = value;
		}
		
		public long validaIdTickerArquivo() {
			
			if (_IdTickerArquivo == 0) {
				throw new RuntimeException("IdTickerArquivo eh zero");
			}
			
			return getIdTickerArquivo ();
		}
		
		private long _QuantidadeDiaDiarioArquivo;
		public long getQuantidadeDiaDiarioArquivo () {
			return _QuantidadeDiaDiarioArquivo ;
		}
		public void setQuantidadeDiaDiarioArquivo (long value) {
			_QuantidadeDiaDiarioArquivo  = value;
		}
		
		public long validaQuantidadeDiaDiarioArquivo() {
			
			if (_QuantidadeDiaDiarioArquivo == 0) {
				throw new RuntimeException("QuantidadeDiaDiarioArquivo eh zero");
			}
			
			return getQuantidadeDiaDiarioArquivo ();
		}
		
		private long _TipoDadoBruto;
		public long getTipoDadoBruto () {
			return _TipoDadoBruto ;
		}
		public void setTipoDadoBruto (long value) {
			_TipoDadoBruto  = value;
		}
		
		public long validaTipoDadoBruto() {
			
			if (_TipoDadoBruto == 0) {
				throw new RuntimeException("TipoDadoBruto eh zero");
			}
			
			return getTipoDadoBruto ();
		}
		
		private long _TipoDadoIntraday;
		public long getTipoDadoIntraday () {
			return _TipoDadoIntraday ;
		}
		public void setTipoDadoIntraday (long value) {
			_TipoDadoIntraday  = value;
		}
		
		public long validaTipoDadoIntraday() {
			
			if (_TipoDadoIntraday == 0) {
				throw new RuntimeException("TipoDadoIntraday eh zero");
			}
			
			return getTipoDadoIntraday ();
		}
		
		private long _TipoDadoStopTarget;
		public long getTipoDadoStopTarget () {
			return _TipoDadoStopTarget ;
		}
		public void setTipoDadoStopTarget (long value) {
			_TipoDadoStopTarget  = value;
		}
		
		public long validaTipoDadoStopTarget() {
			
			if (_TipoDadoStopTarget == 0) {
				throw new RuntimeException("TipoDadoStopTarget eh zero");
			}
			
			return getTipoDadoStopTarget ();
		}
		


		//public String NomeTicker;
		//public String DataInicio;
		//public String DataFinal;
		//public List ListaDiaPregao;
		//public long CodigoFaixa;
		//public List ListaCotacaoOpcao;
		//public String Ano;
		//public String NomeOpcao;
		//public long QuantidadeDiaIntradayArquivo;
		//public long SaltoTickerIntraArquivo;
		//public long TargetArquivo;
		//public long StopArquivo;
		//public String PosicaoCompraVendaArquivo;
		//public long IdTickerArquivo;
		//public long QuantidadeDiaDiarioArquivo;
		//public long TipoDadoBruto;
		//public long TipoDadoIntraday;
		//public long TipoDadoStopTarget;

		
}