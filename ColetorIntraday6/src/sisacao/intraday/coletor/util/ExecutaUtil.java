package sisacao.intraday.coletor.util;

public class ExecutaUtil {

	public static void main(String[] args) {
		Integer diaNum = DataHoraUtil.getDiaNum();
		System.out.println("diaNum: " + diaNum);
		String datHora = DataHoraUtil.getDataHora();
		System.out.println("datHora: " + datHora);
	}

}
