package br.com.digicom.parse;

import java.io.PrintStream;
import java.util.Calendar;
import java.util.Date;

public abstract class RestricaoTempo {
	private Date inicioDia = null;

	private Date finalDia = null;

	private boolean comFinalSemana = false;

	protected Date atualizaDia(Date data) {
		data.setDate(horaAtual().getDate());
		data.setMonth(horaAtual().getMonth());
		data.setYear(horaAtual().getYear());
		return data;
	}

	public void comFinalSemana() {
		this.comFinalSemana = true;
	}

	public void setHorarioDia(Date horaInicial, Date horaFinal) {
		this.inicioDia = horaInicial;
		this.finalDia = horaFinal;
	}

	public static Date ConverteHoraMinuto(int hora, int minuto) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(11, hora);
		calendar.set(12, minuto);
		calendar.set(13, 0);
		return calendar.getTime();
	}

	public boolean podeAcessar() {
		System.out.println("Testou tempo - horaAtual:" + horaAtual() + "(FS:" + fimSemana() + ")");
		Date horaCorrente = horaAtual();
		if ((!this.comFinalSemana) && (fimSemana()))
			return false;
		if ((this.inicioDia != null) && (horaCorrente.before(atualizaDia(this.inicioDia))))
			return false;
		if ((this.finalDia != null) && (horaCorrente.after(atualizaDia(this.finalDia))))
			return false;
		return testaAcesso(horaCorrente);
	}

	protected abstract boolean testaAcesso(Date paramDate);

	private Date horaAtual() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, -1);
		return cal.getTime();
	}

	private boolean fimSemana() {
		Calendar cal = Calendar.getInstance();

		return (cal.get(7) == 1) || (cal.get(7) == 7);
	}
}

/*
 * Location: D:\Java-Recuperacao\webparse.jar Qualified Name:
 * br.com.digicom.parse.RestricaoTempo JD-Core Version: 0.6.0
 */