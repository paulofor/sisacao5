package br.com.digicom.parse;

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
import br.com.digicom.parse.callback.ICallbackParse;
import br.com.digicom.parse.callback.IDadosParse;

public class ExecutadorParseApache2 extends ExecutadorParseApache{

	private ICallbackParse callbackParse;
	private IDadosParse dadosParse;

	public void setCallbackParse(ICallbackParse callbackParse) {
		this.callbackParse = callbackParse;
	}

	public void setDadosParse(IDadosParse dadosParse) {
		this.dadosParse = dadosParse;
	}

	public void executa() throws DaoException {
		this.callbackParse.setDados(this.dadosParse);
		do {
			main();
		} while (this.callbackParse.getLoop());
		
	}
	
	public void main() throws DaoException {
		//CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		CloseableHttpClient httpclient = httpClientBuilder.build();
		try {
			HttpGet httpget = new HttpGet(this.callbackParse.getUrl().toURI());
			System.out.println("Executing request " + httpget.getRequestLine());
			// Create a custom response handler
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

				@Override
				public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity) : null;
					} else {
						throw new ClientProtocolException("Unexpected response status: " + status);
					}
				}

			};
			String responseBody = httpclient.execute(httpget, responseHandler);
			this.callbackParse.setString(responseBody);
			//System.out.println(responseBody);
			this.callbackParse.inicializacao();
			if (this.callbackParse instanceof CallbackParseJson) {
				responseBody = responseBody.trim();
				if ('[' == (responseBody.charAt(0))) {
					JSONArray result = new JSONArray(responseBody);
					((CallbackParseJson)callbackParse).setJsonList(result);
				} else {
					JSONObject result = new JSONObject(responseBody);
					((CallbackParseJson)callbackParse).setJson(result);
				}
				
				
			} else {
				Reader reader = new StringReader(responseBody);
				new ParserDelegator().parse(reader, (HTMLEditorKit.ParserCallback) this.callbackParse, true);
			}
			this.callbackParse.finalizacaoOk();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	
}
