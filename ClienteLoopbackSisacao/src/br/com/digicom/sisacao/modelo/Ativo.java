package br.com.digicom.sisacao.modelo;

import com.strongloop.android.loopback.Model;

public abstract class Ativo extends Model{
	
	public abstract String getTicker();
	public abstract Integer getIntraday5();
	public abstract Integer getIntraday15();
	public abstract Integer getIntraday30();

	public Long minutos() {
		if (this.getIntraday5() == 1) return 5L;
		if (this.getIntraday15() == 1) return 15L;
		if (this.getIntraday30() == 1) return 30L;
		return null;
	}
	public Long milisegundos() {
		if (minutos()!=null) {
			return this.minutos() * 60000;
		} else {
			return null;
		}
	}
}
