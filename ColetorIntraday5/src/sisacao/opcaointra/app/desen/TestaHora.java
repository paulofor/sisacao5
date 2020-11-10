package sisacao.opcaointra.app.desen;

import java.util.Calendar;
import java.util.Date;

public class TestaHora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date agora = new Date();
		System.out.println(horaAtual() );
	}

	 private static Date horaAtual() {
		 Calendar cal = Calendar.getInstance();
		 cal.add(Calendar.HOUR_OF_DAY, -1);
		 return cal.getTime();
	}
}
