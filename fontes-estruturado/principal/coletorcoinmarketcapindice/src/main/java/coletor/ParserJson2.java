package br.com.digicom.coletor;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.CallbackParseJson;

public class ParserJson2 extends Thread {

	private ICallbackJSON callback;

	public ParserJson2(ICallbackJSON callback) {
		this.callback = callback;
	}

	public void run() {
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		CloseableHttpClient httpclient = httpClientBuilder.build();
		try {
			HttpGet httpget = new HttpGet(this.callback.getUrl().toURI());
			httpget.setHeader("X-CMC_PRO_API_KEY", "28a00eac-278a-4e79-a5bf-27d33656b9e5");
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

				public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					System.out.println("Resposta: " + status);
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity) : null;
					} else {
						throw new ClientProtocolException("Unexpected response status: " + status);
					}
				}

			};
			String responseBody = httpclient.execute(httpget, responseHandler);
			this.callback.setString(responseBody);

			this.callback.inicializacao();
			if (this.callback instanceof ICallbackJSON) {
				responseBody = responseBody.trim();
				if ('[' == (responseBody.charAt(0))) {
					JSONArray result = new JSONArray(responseBody);
					((ICallbackJSON) callback).setJsonList(result);
				} else {
					JSONObject result = new JSONObject(responseBody);
					((ICallbackJSON) callback).setJson(result);
				}

			}
			this.callback.finalizacaoOk();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
