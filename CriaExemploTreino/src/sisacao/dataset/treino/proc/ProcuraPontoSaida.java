package sisacao.dataset.treino.proc;

import java.util.List;

import br.com.digicom.sisacao.modelo.CotacaoDiarioAcao;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.modelo.RegraProjecao;

public class ProcuraPontoSaida {

	private int diaLimite; // calculado
	private int sinalBaixo; // calculado
	private int sinalAlto; // calculado
	
	private boolean tipoCompra;
	
	private int diaNumSaida; // output;
	private double valorSaida; // output

	private RegraProjecao regraProjecao; // input
	
	private double limiteBaixo; // calculado - output
	private double limiteAlto; // calculado - output
	
	public int getDiaNumSaida() {
		return diaNumSaida;
	}
	public double getValorSaida() {
		return valorSaida;
	}
	public double getLimiteBaixo() {
		return limiteBaixo;
	}
	public double getLimiteAlto() {
		return limiteAlto;
	}
	
	public ProcuraPontoSaida(RegraProjecao regra) {
		this.regraProjecao = regra;
		tipoCompra = !"V".equals(regraProjecao.getTipoCompraVenda());
	}
	
	public ProcuraPontoSaida() {
		super();
	}
	public void setRegra(RegraProjecao regra) {
		this.regraProjecao = regra;
		tipoCompra = !"V".equals(regraProjecao.getTipoCompraVenda());
	}
	
	private void calculaVariaveis(double precoEntrada) {
		if (this.tipoCompra) {
			limiteBaixo = precoEntrada * (1-this.regraProjecao.getStop()); 
			limiteAlto = precoEntrada * (1+this.regraProjecao.getTarget());
		} else {
			limiteBaixo = precoEntrada * (1-this.regraProjecao.getTarget()); 
			limiteAlto = precoEntrada * (1+this.regraProjecao.getStop());
		}
		if (this.tipoCompra) {
			this.sinalBaixo = -1; // Trade com prejuizo
			this.sinalAlto = 1; // Trade com lucro
		} else {
			this.sinalBaixo = 1; // Trade com lucro
			this.sinalAlto = -1; // Trade com prejuizo
		}
	}
	
	
	public Integer procuraValor(List<DiaPregao> dias, int indDia, int indHora, double precoEntrada) {
		Integer saida = 0;
		try {
			calculaVariaveis(precoEntrada);
			int contaDia = 0;
			boolean finalizou = false;
	
			int posDia = indDia;
			int posHora = indHora;
			CotacaoDiarioAcao diario = null;
			while (indDia<dias.size() && contaDia < this.regraProjecao.getDiaLimite()) {
				contaDia++;
				DiaPregao dia = dias.get(indDia);
				//if (dia.getDiaNum()==20210610) break;
				if (dia.getCotacaoDiarioAcaos().size()>0) {
					diario = dias.get(indDia).getCotacaoDiarioAcaos().get(0);
					//System.out.println(diario + " - " + this.contaDia + " dias.");
					if (diario==null) {
						saida = null;
						//System.out.println("Saiu, sem diario");
						break;
					} else {
						this.diaNumSaida = diario.getDiaNum();
						this.valorSaida = (diario.getFechamento()!=null?diario.getFechamento():0);
					}
					if (diario.getMinimo()!=null && diario.getMinimo() <= limiteBaixo) {
						saida = this.sinalBaixo;
						this.valorSaida = limiteBaixo;
						//System.out.println("Saiu, mínimo");
						break;
					} 
					if (diario.getMaximo()!=null && diario.getMaximo() >= limiteAlto) {
						saida = this.sinalAlto;
						this.valorSaida = limiteAlto;
						//System.out.println("Saiu, máximo");
						break;
					} 
				} else {
					saida = null;
					//System.out.println("Saiu, acabou diario");
					break;
				}
				indDia++;
			}
			//System.out.println("resultado:" + saida);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-2);
		}
		return saida;
		
	}
}
