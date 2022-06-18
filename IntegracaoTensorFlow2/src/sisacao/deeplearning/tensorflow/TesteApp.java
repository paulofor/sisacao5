package sisacao.deeplearning.tensorflow;

import org.json.JSONArray;

public class TesteApp {

	public static void main(String[] args) {
		JSONArray json = new JSONArray();
		
		JSONArray json2 = new JSONArray();
		System.out.println("json:" + json.getClass().getName());
		json.putAll(json2);
	}

}
