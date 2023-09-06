package org.apache.http.examples.client;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * This example demonstrates the use of the {@link ResponseHandler} to simplify
 * the process of processing the HTTP response and releasing associated resources.
 */
public class ClientWithResponseHandler {

	static String url = null;
	static String url2 = null;
	
    public final static void main(String[] args) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
        	url2 = "/api/tickers?pairs=BRLamp,BRLar,BRLaudio,BRLbat,BRLbsv,BRLbtg,BRLbtt,BRLcelo,BRLchz,BRLcomp,BRLcrv,BRLdash,BRLdcr,BRLenj,BRLhot,BRLht,BRLicx,BRLiotx,BRLkcs,BRLkda,BRLksm,BRLleo,BRLlpt,BRLlrc,BRLmina,BRLmiota,BRLmkr,BRLneo,BRLnexo,BRLokb,BRLomg,BRLone,BRLperp,BRLqnt,BRLqtum,BRLrev,BRLrune,BRLrvn,BRLsand,BRLstx,BRLsushi,BRLtfuel,BRLtusd,BRLwaves,BRLxdc,BRLxec,BRLxem,BRLyfi,BRLzec,BRLzen,BRLzil";
        	url2 = "/api/tickers?pairs=BRLamp,BRLar,BRLaudio";
        	url = "http://cdn.mercadobitcoin.com.br" + url2;
            //url = "https://watcher.foxbit.com.br/api/Ticker/";
        	//HttpGet httpget = new HttpGet("https://www.revendadecosmeticos.com.br/marcas/macrilan.html");
        	HttpGet httpget = new HttpGet(url);
        	httpget = meuTesteOk(httpget);
            System.out.println("Executing request " + httpget.getRequestLine());
            
            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                @Override
                public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                    	System.out.println("Status:" + status);
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        } finally {
            httpclient.close();
        }
    }
    
    private static HttpGet meuTeste1(HttpGet httpget) {
    	httpget.setHeader("sec-ch-ua","\"Google Chrome\";v=\"89\", \"Chromium\";v=\"89\", \";Not A Brand\";v=\"99\"");
    	httpget.setHeader("sec-ch-ua-mobile","?0");
    	httpget.setHeader("Upgrade-Insecure-Requests","1");
    	httpget.setHeader("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.114 Safari/537.36");
    	httpget.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
    	return httpget;
    }
    
    
    private static HttpGet meuTesteOk(HttpGet httpget) {
		//httpget.setHeader("accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-\n" + 
				//"exchange;v=b3;q=0.9");
		//httpget.setHeader("accept-encoding","gzip, deflate, br");
		
		System.out.println("Passei em meu teste");
		httpget.setHeader(":authority","cdn.mercadobitcoin.com.br");
		httpget.setHeader(":method","GET");
		httpget.setHeader(":path:",url2);
		httpget.setHeader(":scheme","https");
		httpget.setHeader("accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
		httpget.setHeader("accept-encoding","gzip, deflate, br");
		httpget.setHeader("accept-language","pt-BR,pt;q=0.9");
		httpget.setHeader("sec-ch-ua","\"Google Chrome\";v=\"89\", \"Chromium\";v=\"89\", \";Not A Brand\";v=\"99\"");
		httpget.setHeader("sec-ch-ua-mobile","?0");
		httpget.setHeader("sec-fetch-dest","document");
		httpget.setHeader("sec-fetch-mode","navigate");
		httpget.setHeader("sec-fetch-site","none");
		httpget.setHeader("sec-fetch-user","?1");
		httpget.setHeader("upgrade-insecure-requests","1");
		httpget.setHeader("user-agent:","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.114 Safari/537.36");
		
		return httpget;
	}
	
}
