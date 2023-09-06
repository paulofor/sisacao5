package br.inf.digicom.loopback.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DataUtils {

	
	public static int getDiaNumCorrente() {
		 Calendar now = Calendar.getInstance();
		 String data = colocaZeroEsquerda(now.get(1)) +  
		      colocaZeroEsquerda(now.get(2) + 1) +  
		      colocaZeroEsquerda(now.get(5));
		 return Integer.parseInt(data);
	}
	
	public static String getHoraCorrente() { 
		Calendar cal = Calendar.getInstance();
		Date hoje = cal.getTime();
	    DateFormat df = DateFormat.getTimeInstance(SimpleDateFormat.MEDIUM, Locale.UK);
	    return df.format(hoje);
	}
	
	private static String colocaZeroEsquerda(int num) {
		if (num > 9) return "" + num;
		return "0" + num;
	}
}
