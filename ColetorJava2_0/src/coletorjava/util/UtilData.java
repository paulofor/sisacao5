package coletorjava.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UtilData {

	
	public static long getNumeroData(String data_dd_mm_aaaa) {
		// DD-MM-AAAA
		// 0123456789
		String dia =  data_dd_mm_aaaa.substring(0, 2);
		String mes =  data_dd_mm_aaaa.substring(3,5);
		String ano =  data_dd_mm_aaaa.substring(6);
		return Long.parseLong(ano + mes + dia);
	}

	public static String getDataProximoMes(String data_dd_mm_aaaa) {
		// DD-MM-AAAA
		// 0123456789
		String saida = null;
		int mes = Integer.parseInt(data_dd_mm_aaaa.substring(3, 5));
		mes++;
		int ano = Integer.parseInt(data_dd_mm_aaaa.substring(6));
		if (mes>12) {
			saida = "01-01-" + ano++;
		} else {
			saida = "01-" + String.format("%02d", mes) + "-" + ano;
		}
		return saida;
	}
	
	public static String deslocaDias(String data, int dias) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(data));
		c.add(Calendar.DATE, dias);
		String dt = sdf.format(c.getTime()); 
		return dt;
	}
	
	
	public static String obtemProximaSexta(String dataSexta) throws ParseException {
		//SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		//Date date = sdf.parse(dataSexta);
		//date.
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(dataSexta));
		c.add(Calendar.DATE, 1);
		while (c.get(Calendar.DAY_OF_WEEK) != Calendar.FRIDAY) {
			c.add(Calendar.DATE, 1);
		}
		String dt = sdf.format(c.getTime()); 
		return dt;
	}
	public static String obtemAnteriorSexta(String data) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(data));
		c.add(Calendar.DATE, -1);
		while (c.get(Calendar.DAY_OF_WEEK) != Calendar.FRIDAY) {
			c.add(Calendar.DATE, -1);
		}
		String dt = sdf.format(c.getTime()); 
		return dt;
	}
	
	public static boolean ehSexta(String data) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(data));
		return (c.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY);
	}
	public static boolean ehSabado(String data) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(data));
		return (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY);
	}
	
}
