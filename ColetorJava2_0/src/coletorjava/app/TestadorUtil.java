package coletorjava.app;

import java.text.ParseException;

import coletorjava.util.UtilData;

public class TestadorUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = "31-03-2016";
		try {
			String data2 = UtilData.obtemProximaSexta(data);
			System.out.println(data2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
