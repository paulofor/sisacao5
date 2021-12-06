package sisacao.intraday.coletor.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DataHoraUtil {

	
	

	public static String getDataHora() {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		TimeZone zone = TimeZone.getTimeZone("America/Sao_Paulo");
		formatter.setTimeZone(zone);
		Date date = new Date();
		return formatter.format(date);
	}

	public static Integer getDiaNum() {
		
		Calendar now = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

		Date date = new Date();
		return Integer.parseInt(formatter.format(date));
	}
	
	
}
