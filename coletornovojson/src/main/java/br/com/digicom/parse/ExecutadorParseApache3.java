package br.com.digicom.parse;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.ICallbackParse;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.log.ArquivoLog;

public class ExecutadorParseApache3 extends ExecutadorParseApache {

	private ICallbackParse callbackParse;
	private IDadosParse dadosParse;
	
	private String urlAtual = "";
	private int contaErro = 0;
	private boolean concluido;

	public void setCallbackParse(ICallbackParse callbackParse) {
		this.callbackParse = callbackParse;
	}

	public void setDadosParse(IDadosParse dadosParse) {
		this.dadosParse = dadosParse;
	}

	public void executa() throws DaoException {
		System.out.println(this.callbackParse.getClass().getName());
		this.callbackParse.setDados(this.dadosParse);
		this.callbackParse.antesLoop();
		int contaPagina = 0;
		boolean loop = false;
		do {
			//ArquivoLog.getInstancia().salvaLog("Antes do main: ");
			main();
			contaPagina++;
			if (contaPagina % 30 == 0) {
				try {
					System.out.println("vai para o sleep do loop");
					Thread.sleep(120000); // 2 minutos
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			loop = this.callbackParse.getLoop();
			//ArquivoLog.getInstancia().salvaLog("Loop: " + loop);
		} while (loop);

	}

	public void main() throws DaoException {
		// CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		//this.setProxy(httpClientBuilder);
		
		CloseableHttpClient httpclient = null;
		try {
			certificado(httpClientBuilder);
			httpclient = httpClientBuilder.build();
			HttpGet httpget = new HttpGet(this.callbackParse.getUrl().toURI());

			if (this.callbackParse.getUrl().getHost().contains("casasbahia") || 
				this.callbackParse.getUrl().getHost().contains("pontofrio")	|| 
				this.callbackParse.getUrl().getHost().contains("extra")) {
				
			} else {
				
				
				httpget.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.87 Safari/537.36");
				httpget.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
				httpget.setHeader("Accept-Charset", "ISO-8859-1,utf-8;q=0.7,*;q=0.3");
				httpget.setHeader("Accept-Encoding", "gzip,deflate,sdch");
				httpget.setHeader("Cache-Control", "max-age=0");
				httpget.setHeader("Connection", "keep-alive");
				httpget.setHeader("Content-Type", "application/x-www-form-urlencoded");
				
				/*
				if (this.callbackParse.getUrl().getHost().contains("americanas")) {
					//httpget = meuTeste(httpget);
				}
				*/
				
			}
		    
		    System.out.println("Executing request " + httpget.getRequestLine());
		    concluido=false;

			// Create a custom response handler
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

				@Override
				public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException , ForbiddenException{
					concluido = false;
					int status = response.getStatusLine().getStatusCode();
					//System.out.println("3_Resposta:" + status);
					if (status >= 200 && status < 300) {
						ProcessaParser proc = new ProcessaParser();
						HttpEntity entity = response.getEntity();
						String responseBody = entity != null ? EntityUtils.toString(entity) : null;
						//salvaArquivo(responseBody,callbackParse.getUrl().toString());
						proc.executa(responseBody,callbackParse);
						//System.out.println(responseBody);
						
						
						return null;
					} else {
						ArquivoLog.getInstancia().salvaLog(callbackParse.getUrl().toString());
						ArquivoLog.getInstancia().salvaLog("status: " + status + "(" + contaErro + ")");
						ArquivoLog.getInstancia().salvaLog("");
						if (status==403) {
							if (callbackParse.getUrl().toString().compareTo(urlAtual)==0) {
								contaErro++;
								System.out.println("Conta erro: " + contaErro);
								if (contaErro>=10) {
									contaErro=0;
									throw new ForbiddenException(callbackParse.getUrl().toString());
								}
							} else {
								urlAtual = callbackParse.getUrl().toString();
								contaErro = 0;
							}
							try {
								Thread.sleep(120000);
							} catch (InterruptedException e) {
								ArquivoLog.getInstancia().salvaLog("Erro no sleep: " + e.getMessage());
							}
						}
						concluido = true;
						throw new ClientProtocolException("Unexpected response status: " + status);
					}
				}

			};
			
			//System.out.println("2_vai_chamar_get");
			httpclient.execute(httpget, responseHandler);
			while (this.callbackParse.getConcluido()) {
				Thread.sleep(2000);
				System.out.println("estou no loop");
			}
			//ArquivoLog.getInstancia().salvaLog("Vai executar: " + callbackParse.getUrl().toString());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ForbiddenException e) {
			ArquivoLog.getInstancia().salvaErro(e);;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
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

	
	int num = 0;
	private void salvaArquivo2(String conteudo, String nome) {
		nome = "arq" + (num++) + ".html";
		Path path = Paths.get(nome);
		System.out.println("*** Arquivo: " + path.getFileName());
		byte[] bytes = conteudo.getBytes();

		try {
		    Files.write(path, bytes);
		} catch (IOException ex) {
			// Handle exception
			ex.printStackTrace();
		}

	}
	
	private HttpGet meuTeste(HttpGet httpget) {
		//httpget.setHeader("accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-\n" + 
				//"exchange;v=b3;q=0.9");
		//httpget.setHeader("accept-encoding","gzip, deflate, br");
		
		System.out.println("Passei em meu teste");
		httpget.setHeader("accept-language","pt-BR,pt;q=0.9,en-US;q=0.8,en;q=0.7,es;q=0.6");
		httpget.setHeader("cache-control","max-age=0");
		httpget.setHeader("referer","https://www.americanas.com.br/");
		httpget.setHeader("sec-fetch-dest","document");
		httpget.setHeader("sec-fetch-mode","navigate");
		httpget.setHeader("sec-fetch-site","same-origin");
		httpget.setHeader("sec-fetch-user","?1");
		httpget.setHeader("upgrade-insecure-requests","1");
		httpget.setHeader("user-agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.75 Safari/537.36");
		httpget.setHeader(":authority:","www.americanas.com.br");
		httpget.setHeader(":method:","GET");
		httpget.setHeader(":path","/categoria/beleza-e-perfumaria/maquiagem");
		httpget.setHeader(":scheme:","https");
		
		String cookie = 
				"_px_uAB=MTI4OTV8dHJ1ZQ==; " +
						"B2W-UID=va_202062223210_862.2560329437205; " + 
						"B2W-PID=15940345678931.0.6726877461554222; " +
						"_pxvid=17e462d4-bf8a-12ea-b6af-0242ac120004; " +
						"_px_f394gi7Fvmc43dfg_user_id=MWJkMGJjYTAtYmY4ZC0xMWVhLTg5YzgtZDk2ODg0OGJiMTBh; " + 
						"_ga=GA1.3.1009783929.1594042347; " +
						"ftr_ncd=6; " +
						"persistentCep=20500090; " +
						"_hjid=21cd7cf1-c172-4677-99a7-ad620102436f; " + 
						"forterToken=1ef5153a4a724efd86a4c2aa2ececdc4_1598721328045__UDF43_9ck; " +
						"_gcl_au=1.1.518189587.1602039234; " +
						"_gcl_dc=GCL.1603644443.CjkKEQjwxNT8BRC0-4WyzuGUi5IBEiQATZzD3Om33j2Z6r44KkougJAwTg3M-kKxmYVfg-tbe8PfdWbw_wcB; " +
						"persistentAddress=20515B4nio-Bas%25C3%25ADlio_Tijuca_Rio-de-Janeiro_RJ; " + "__gads=ID=75d4235fbbf6b976:T=1604114959:S=ALNI_MarfUoHw1M7Dw26jVE9CM2Zasc6iA; " + 
						"feather.rank=%7B%22search%22%3A%22balan%C3%A7a%20digital%E2%86%871%E2%86%88aquecedor%20a%20gas%E2%86%871%E2%86%88aquecedor%E2%86%871%E2%86%88impressora%E2%86%871%E2%86%88raspberry%E2%86%871%22%7D; " +
						"_gac_UA-97626372-1=1.1604115302.CjwKCAjw8-78BRA0EiwAFUw8LDyIO2YFAWyvO87gEoHueQvNPIHmhZfcmud4nu0xnbtZTsuimZ05vBoCEQsQAvD_BwE; " + "_gcl_aw=GCL.1604115303.CjwKCAjw8-78BRA0EiwAFUw8LDyIO2YFAWyvO87gEoHueQvNPIHmhZfcmud4nu0xnbtZTsuimZ05vBoCEQsQAvD_BwE; " + 
						"MobileOptOut=1; " + "b2wDevice=eyJvcyI6IkxpbnV4Iiwib3NWZXJzaW9uIjoieDg2XzY0IiwidmVuZG9yIjoiQ2hyb21lIiwidHlwZSI6ImRlc2t0b3AiLCJta3ROYW1lIjoiQ2hyb21lIDg2IiwibW9kZWwiOiI4NiIsIm1vYmlsZU9wdE91dCI6ImZhbHNlIn0=;" + "b2wDeviceType=desktop; " +
						"searchTestAB=new; " +
						"b2wChannel=ACOM; " +
						"B2W-IU=false; " +
						"bm_mi=5DD28430B9D270A16666665554308292~7Br49Olc1Fu5IgUSnYObmzE8vRtCTAEzgi8fK307qFNCS7pXTkPOQhn5BbYa3fyOtTi/m7PpWRcSMWcmr14ihAT+FTNCIn1OxGSCzkO5d/7l6ms3u8GloIMzseDQFqaoVnUWdr8rLnxoUDXKc1RUWzRXSNP5PgFJ+4bAR9lNC2dxwNGLx6O2tCubRMT54XAoJUsnQlRgeoFxqWeqlbw4yNf1wN4n9aG8Hp1g4EMEcgUs1ssyGHuSesGKxKoqIb+a3gX4EucjsdeaJmFSiEi2fw==; " +
						"ak_bmsc=383B14F72C50A177777654540A2604917434C05643A0000DDE8AF5FD5333F66~pld7FMR338RNjOZQoP9bQPj/Va2tqOFiPrmuN8sJ5NmVT7kBSvZrdmEVzOtYr/ZfEkWNt3o/xB1PYtrn+RoQdAMdxP3pyQh6EtIWNYyUV0vRE9v574BcTfrxy4QsAAQWKr8YmPn5HwdFVQRYFlTTOtUWHY2Q13FJlGo2yTQu2fzVaDztGHfuRblmjKup7L5eLUJb0GLh9hLXsaBeuHe39PIf8EQ2FbD4cAG0lMTaCuYvWCUqj7J6DsEdgs1NlL048c; " +
						"AMCVS_14B422CE52782FA90A490D4D%40AdobeOrg=1; " +
						"AMCV_14B422CE52782FA90A490D4D%40AdobeOrg=870038026%7CMCIDTS%7C18581%7CMCMID%7C55214875268269991271060002731333958673%7CMCAAMLH-1605968692%7C4%7CMCAAMB-1605968692%7CRKhpRz8krg2tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y%7CMCOPTOUT-1605371092s%7CNONE%7CMCAID%7CNONE%7CvVersion%7C5.0.0%7CMCSYNCSOP%7C411-18554; " +
						"B2W-SID=740.996185329802820201461124694; " +
						"s_cc=true; " +
						"_gid=GA1.3.1120682660.1605363897; " +
						"_hjIncludedInSessionSample=0; " + 
						"_hjTLDTest=1; " +
						"_hjAbsoluteSessionInProgress=1; " +
						"bm_sv=7AD3E97A4ACA62FEF33AC97916778861~/ilL8rt832RXU84XDe1C0ir5IXOocp77blXlNEQfS1djy7EFy+shIORrSmXEpyuDzu/Al03kVzrDMXgiW03hG+hvhbOw1I7yrA/p8rNwOf7kh12kefErRsXnzJCXC5GTewIsPLznqD7Fp2MzBGAxjgBTucMorONX48KJ+3OquyA=; " +
						"_px_nAflV=MTYwNTM2MzkxODcwNQ==; " +
						"c_privacyPolicy=1; " +
						"_px3=14c998b22212cf515b7ccaec5b8f0dbf578427bb586d44077217b24856914cd9:U0n5PHQ5tTa3dLLE5Jzc1s6L77wVvhtmbXR10QioLgfwSn4o7FNumQnQwwHb0o/Zf9fq3HtVEDKeZdUSLYj2Xw==:1000:DMljnrXbqMkdwpIydX9rlBkg7mUAKDfjZLISWHda5mT8Rjeggt2xmzQC8CpuGxA3fGjL/DmLUtvZEQn2DXBeh22nRgWPTLPhEH8cwoO9ink3nH9JFE+COtolbNL4hY30UYrTa1ygzGvmQXUlSfcLkVbzKa/aO52Ut5WtrjiOm2Q=; " +
						"s_sq=%5B%5BB%5D%5D; " +
						"_px_9573499949_cs=eyJpZCI6IjFkODg3NGMwLTI2ODUtMTFlYi1hYTNjLTA1NzcyM2Q1MzViNiIsInN0b3JhZ2UiOnsiZyI6dHJ1ZX0sImV4cGlyYXRpb24iOjE2MDUzNjU3NzU2ODR9" +
						"";
		//httpget.setHeader("cookie","_px_uAB=MTI4OTV8dHJ1ZQ==; B2W-UID=va_202061103210_862.2560329437205; B2W-PID=1594042332931.0.6726877461554222; _pxvid=17e462d4-bf8d-11ea-a6af-0242ac120004; _px_f394gi7Fvmc43dfg_user_id=MWJkMGJjYTAtYmY4ZC0xMWVhLTg5YzgtZDk2ODg0OGJiMTBh; _ga=GA1.3.1009783929.1594042347; ftr_ncd=6; persistentCep=20511190; _hjid=21cd7cf1-c172-4677-99a7-ad620102436f; forterToken=1ef5153a4a724efd86a4c2aa2ececdc4_1598721328045__UDF43_9ck; _gcl_au=1.1.518189587.1602039234; _gcl_dc=GCL.1603644443.CjkKEQjwxNT8BRC0-4WyzuGUi5IBEiQATZzD3Om33j2Z6r44KkougJAwTg3M-kKxmYVfg-tbe8PfdWbw_wcB; persistentAddress=20511190_Rua-Ant%25C3%25B4nio-Bas%25C3%25ADlio_Tijuca_Rio-de-Janeiro_RJ; __gads=ID=75d4235fbbf6b976:T=1604114959:S=ALNI_MarfUoHw1M7Dw26jVE9CM2Zasc6iA; feather.rank=%7B%22search%22%3A%22balan%C3%A7a%20digital%E2%86%871%E2%86%88aquecedor%20a%20gas%E2%86%871%E2%86%88aquecedor%E2%86%871%E2%86%88impressora%E2%86%871%E2%86%88raspberry%E2%86%871%22%7D; _gac_UA-97626372-1=1.1604115302.CjwKCAjw8-78BRA0EiwAFUw8LDyIO2YFAWyvO87gEoHueQvNPIHmhZfcmud4nu0xnbtZTsuimZ05vBoCEQsQAvD_BwE; _gcl_aw=GCL.1604115303.CjwKCAjw8-78BRA0EiwAFUw8LDyIO2YFAWyvO87gEoHueQvNPIHmhZfcmud4nu0xnbtZTsuimZ05vBoCEQsQAvD_BwE; MobileOptOut=1; b2wDevice=eyJvcyI6IkxpbnV4Iiwib3NWZXJzaW9uIjoieDg2XzY0IiwidmVuZG9yIjoiQ2hyb21lIiwidHlwZSI6ImRlc2t0b3AiLCJta3ROYW1lIjoiQ2hyb21lIDg2IiwibW9kZWwiOiI4NiIsIm1vYmlsZU9wdE91dCI6ImZhbHNlIn0=; b2wDeviceType=desktop; searchTestAB=new; b2wChannel=ACOM; B2W-IU=false; bm_mi=5DD28430B9D270A1CD71295811A08292~7Br49Olc1Fu5IgUSnYObmzE8vRtCTAEzgi8fK307qFNCS7pXTkPOQhn5BbYa3fyOtTi/m7PpWRcSMWcmr14ihAT+FTNCIn1OxGSCzkO5d/7l6ms3u8GloIMzseDQFqaoVnUWdr8rLnxoUDXKc1RUWzRXSNP5PgFJ+4bAR9lNC2dxwNGLx6O2tCubRMT54XAoJUsnQlRgeoFxqWeqlbw4yNf1wN4n9aG8Hp1g4EMEcgUs1ssyGHuSesGKxKoqIb+a3gX4EucjsdeaJmFSiEi2fw==; ak_bmsc=383B14F72C50A1F8AC195F2FF0A2604917434C05643A0000DDE8AF5FD5333F66~pld7FMR338RNjOZQoP9bQPj/Va2tqOFiPrmuN8sJ5NmVT7kBSvZrdmEVzOtYr/ZfEkWNt3o/xB1PYtrn+RoQdAMdxP3pyQh6EtIWNYyUV0vRE9v574BcTfrxy4QsAAQWKr8YmPn5HwdFVQRYFlTTOtUWHY2Q13FJlGo2yTQu2fzVaDztGHfuRblmjKup7L5eLUJb0GLh9hLXsaBeuHe39PIf8EQ2FbD4cAG0lMTaCuYvWCUqj7J6DsEdgs1NlL048c; AMCVS_14B422CE52782FA90A490D4D%40AdobeOrg=1; AMCV_14B422CE52782FA90A490D4D%40AdobeOrg=870038026%7CMCIDTS%7C18581%7CMCMID%7C55214875268269991271060002731333958673%7CMCAAMLH-1605968692%7C4%7CMCAAMB-1605968692%7CRKhpRz8krg2tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y%7CMCOPTOUT-1605371092s%7CNONE%7CMCAID%7CNONE%7CvVersion%7C5.0.0%7CMCSYNCSOP%7C411-18554; B2W-SID=740.996185329802820201461124694; s_cc=true; _gid=GA1.3.1120682660.1605363897; _hjIncludedInSessionSample=0; _hjTLDTest=1; _hjAbsoluteSessionInProgress=1; bm_sv=7AD3E97A4ACA62FEF33AC97916778861~/ilL8rt832RXU84XDe1C0ir5IXOocp77blXlNEQfS1djy7EFy+shIORrSmXEpyuDzu/Al03kVzrDMXgiW03hG+hvhbOw1I7yrA/p8rNwOf7kh12kefErRsXnzJCXC5GTewIsPLznqD7Fp2MzBGAxjgBTucMorONX48KJ+3OquyA=; _px_nAflV=MTYwNTM2MzkxODcwNQ==; c_privacyPolicy=1; _px3=14c998b22212cf515b7ccaec5b8f0dbf578427bb586d44077217b24856914cd9:U0n5PHQ5tTa3dLLE5Jzc1s6L77wVvhtmbXR10QioLgfwSn4o7FNumQnQwwHb0o/Zf9fq3HtVEDKeZdUSLYj2Xw==:1000:DMljnrXbqMkdwpIydX9rlBkg7mUAKDfjZLISWHda5mT8Rjeggt2xmzQC8CpuGxA3fGjL/DmLUtvZEQn2DXBeh22nRgWPTLPhEH8cwoO9ink3nH9JFE+COtolbNL4hY30UYrTa1ygzGvmQXUlSfcLkVbzKa/aO52Ut5WtrjiOm2Q=; s_sq=%5B%5BB%5D%5D; _px_9573499949_cs=eyJpZCI6IjFkODg3NGMwLTI2ODUtMTFlYi1hYTNjLTA1NzcyM2Q1MzViNiIsInN0b3JhZ2UiOnsiZyI6dHJ1ZX0sImV4cGlyYXRpb24iOjE2MDUzNjU3NzU2ODR9\n" + 
		//		"");
		httpget.setHeader("cookie",cookie);
		
		
		
		
		return httpget;
	}

	
	
	
	
	private HttpGet meuTesteOk(HttpGet httpget) {
		//httpget.setHeader("accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-\n" + 
				//"exchange;v=b3;q=0.9");
		//httpget.setHeader("accept-encoding","gzip, deflate, br");
		
		System.out.println("Passei em meu teste");
		httpget.setHeader("accept-language","pt-BR,pt;q=0.9,en-US;q=0.8,en;q=0.7,es;q=0.6");
		httpget.setHeader("cache-control","max-age=0");
		httpget.setHeader("referer","https://www.americanas.com.br/");
		httpget.setHeader("sec-fetch-dest","document");
		httpget.setHeader("sec-fetch-mode","navigate");
		httpget.setHeader("sec-fetch-site","same-origin");
		httpget.setHeader("sec-fetch-user","?1");
		httpget.setHeader("upgrade-insecure-requests","1");
		httpget.setHeader("user-agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.75 Safari/537.36");
		httpget.setHeader(":authority:","www.americanas.com.br");
		httpget.setHeader(":method:","GET");
		httpget.setHeader(":path","/categoria/beleza-e-perfumaria/maquiagem");
		httpget.setHeader(":scheme:","https");
		
		String cookie = 
				"_px_uAB=MTI4OTV8dHJ1ZQ==; " +
						"B2W-UID=va_202061103210_862.2560329437205; " + 
						"B2W-PID=1594042332931.0.6726877461554222; " +
						"_pxvid=17e462d4-bf8d-11ea-a6af-0242ac120004; " +
						"_px_f394gi7Fvmc43dfg_user_id=MWJkMGJjYTAtYmY4ZC0xMWVhLTg5YzgtZDk2ODg0OGJiMTBh; " + 
						"_ga=GA1.3.1009783929.1594042347; " +
						"ftr_ncd=6; " +
						"persistentCep=20500090; " +
						"_hjid=21cd7cf1-c172-4677-99a7-ad620102436f; " + 
						"forterToken=1ef5153a4a724efd86a4c2aa2ececdc4_1598721328045__UDF43_9ck; " +
						"_gcl_au=1.1.518189587.1602039234; " +
						"_gcl_dc=GCL.1603644443.CjkKEQjwxNT8BRC0-4WyzuGUi5IBEiQATZzD3Om33j2Z6r44KkougJAwTg3M-kKxmYVfg-tbe8PfdWbw_wcB; " +
						"persistentAddress=20515B4nio-Bas%25C3%25ADlio_Tijuca_Rio-de-Janeiro_RJ; " + "__gads=ID=75d4235fbbf6b976:T=1604114959:S=ALNI_MarfUoHw1M7Dw26jVE9CM2Zasc6iA; " + 
						"feather.rank=%7B%22search%22%3A%22balan%C3%A7a%20digital%E2%86%871%E2%86%88aquecedor%20a%20gas%E2%86%871%E2%86%88aquecedor%E2%86%871%E2%86%88impressora%E2%86%871%E2%86%88raspberry%E2%86%871%22%7D; " +
						"_gac_UA-97626372-1=1.1604115302.CjwKCAjw8-78BRA0EiwAFUw8LDyIO2YFAWyvO87gEoHueQvNPIHmhZfcmud4nu0xnbtZTsuimZ05vBoCEQsQAvD_BwE; " + "_gcl_aw=GCL.1604115303.CjwKCAjw8-78BRA0EiwAFUw8LDyIO2YFAWyvO87gEoHueQvNPIHmhZfcmud4nu0xnbtZTsuimZ05vBoCEQsQAvD_BwE; " + 
						"MobileOptOut=1; " + "b2wDevice=eyJvcyI6IkxpbnV4Iiwib3NWZXJzaW9uIjoieDg2XzY0IiwidmVuZG9yIjoiQ2hyb21lIiwidHlwZSI6ImRlc2t0b3AiLCJta3ROYW1lIjoiQ2hyb21lIDg2IiwibW9kZWwiOiI4NiIsIm1vYmlsZU9wdE91dCI6ImZhbHNlIn0=;" + "b2wDeviceType=desktop; " +
						"searchTestAB=new; " +
						"b2wChannel=ACOM; " +
						"B2W-IU=false; " +
						"bm_mi=5DD28430B9D270A1CD71295811A08292~7Br49Olc1Fu5IgUSnYObmzE8vRtCTAEzgi8fK307qFNCS7pXTkPOQhn5BbYa3fyOtTi/m7PpWRcSMWcmr14ihAT+FTNCIn1OxGSCzkO5d/7l6ms3u8GloIMzseDQFqaoVnUWdr8rLnxoUDXKc1RUWzRXSNP5PgFJ+4bAR9lNC2dxwNGLx6O2tCubRMT54XAoJUsnQlRgeoFxqWeqlbw4yNf1wN4n9aG8Hp1g4EMEcgUs1ssyGHuSesGKxKoqIb+a3gX4EucjsdeaJmFSiEi2fw==; " +
						"ak_bmsc=383B14F72C50A1F8AC195F2FF0A2604917434C05643A0000DDE8AF5FD5333F66~pld7FMR338RNjOZQoP9bQPj/Va2tqOFiPrmuN8sJ5NmVT7kBSvZrdmEVzOtYr/ZfEkWNt3o/xB1PYtrn+RoQdAMdxP3pyQh6EtIWNYyUV0vRE9v574BcTfrxy4QsAAQWKr8YmPn5HwdFVQRYFlTTOtUWHY2Q13FJlGo2yTQu2fzVaDztGHfuRblmjKup7L5eLUJb0GLh9hLXsaBeuHe39PIf8EQ2FbD4cAG0lMTaCuYvWCUqj7J6DsEdgs1NlL048c; " +
						"AMCVS_14B422CE52782FA90A490D4D%40AdobeOrg=1; " +
						"AMCV_14B422CE52782FA90A490D4D%40AdobeOrg=870038026%7CMCIDTS%7C18581%7CMCMID%7C55214875268269991271060002731333958673%7CMCAAMLH-1605968692%7C4%7CMCAAMB-1605968692%7CRKhpRz8krg2tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y%7CMCOPTOUT-1605371092s%7CNONE%7CMCAID%7CNONE%7CvVersion%7C5.0.0%7CMCSYNCSOP%7C411-18554; " +
						"B2W-SID=740.996185329802820201461124694; " +
						"s_cc=true; " +
						"_gid=GA1.3.1120682660.1605363897; " +
						"_hjIncludedInSessionSample=0; " + 
						"_hjTLDTest=1; " +
						"_hjAbsoluteSessionInProgress=1; " +
						"bm_sv=7AD3E97A4ACA62FEF33AC97916778861~/ilL8rt832RXU84XDe1C0ir5IXOocp77blXlNEQfS1djy7EFy+shIORrSmXEpyuDzu/Al03kVzrDMXgiW03hG+hvhbOw1I7yrA/p8rNwOf7kh12kefErRsXnzJCXC5GTewIsPLznqD7Fp2MzBGAxjgBTucMorONX48KJ+3OquyA=; " +
						"_px_nAflV=MTYwNTM2MzkxODcwNQ==; " +
						"c_privacyPolicy=1; " +
						"_px3=14c998b22212cf515b7ccaec5b8f0dbf578427bb586d44077217b24856914cd9:U0n5PHQ5tTa3dLLE5Jzc1s6L77wVvhtmbXR10QioLgfwSn4o7FNumQnQwwHb0o/Zf9fq3HtVEDKeZdUSLYj2Xw==:1000:DMljnrXbqMkdwpIydX9rlBkg7mUAKDfjZLISWHda5mT8Rjeggt2xmzQC8CpuGxA3fGjL/DmLUtvZEQn2DXBeh22nRgWPTLPhEH8cwoO9ink3nH9JFE+COtolbNL4hY30UYrTa1ygzGvmQXUlSfcLkVbzKa/aO52Ut5WtrjiOm2Q=; " +
						"s_sq=%5B%5BB%5D%5D; " +
						"_px_9573499949_cs=eyJpZCI6IjFkODg3NGMwLTI2ODUtMTFlYi1hYTNjLTA1NzcyM2Q1MzViNiIsInN0b3JhZ2UiOnsiZyI6dHJ1ZX0sImV4cGlyYXRpb24iOjE2MDUzNjU3NzU2ODR9" +
						"";
		//httpget.setHeader("cookie","_px_uAB=MTI4OTV8dHJ1ZQ==; B2W-UID=va_202061103210_862.2560329437205; B2W-PID=1594042332931.0.6726877461554222; _pxvid=17e462d4-bf8d-11ea-a6af-0242ac120004; _px_f394gi7Fvmc43dfg_user_id=MWJkMGJjYTAtYmY4ZC0xMWVhLTg5YzgtZDk2ODg0OGJiMTBh; _ga=GA1.3.1009783929.1594042347; ftr_ncd=6; persistentCep=20511190; _hjid=21cd7cf1-c172-4677-99a7-ad620102436f; forterToken=1ef5153a4a724efd86a4c2aa2ececdc4_1598721328045__UDF43_9ck; _gcl_au=1.1.518189587.1602039234; _gcl_dc=GCL.1603644443.CjkKEQjwxNT8BRC0-4WyzuGUi5IBEiQATZzD3Om33j2Z6r44KkougJAwTg3M-kKxmYVfg-tbe8PfdWbw_wcB; persistentAddress=20511190_Rua-Ant%25C3%25B4nio-Bas%25C3%25ADlio_Tijuca_Rio-de-Janeiro_RJ; __gads=ID=75d4235fbbf6b976:T=1604114959:S=ALNI_MarfUoHw1M7Dw26jVE9CM2Zasc6iA; feather.rank=%7B%22search%22%3A%22balan%C3%A7a%20digital%E2%86%871%E2%86%88aquecedor%20a%20gas%E2%86%871%E2%86%88aquecedor%E2%86%871%E2%86%88impressora%E2%86%871%E2%86%88raspberry%E2%86%871%22%7D; _gac_UA-97626372-1=1.1604115302.CjwKCAjw8-78BRA0EiwAFUw8LDyIO2YFAWyvO87gEoHueQvNPIHmhZfcmud4nu0xnbtZTsuimZ05vBoCEQsQAvD_BwE; _gcl_aw=GCL.1604115303.CjwKCAjw8-78BRA0EiwAFUw8LDyIO2YFAWyvO87gEoHueQvNPIHmhZfcmud4nu0xnbtZTsuimZ05vBoCEQsQAvD_BwE; MobileOptOut=1; b2wDevice=eyJvcyI6IkxpbnV4Iiwib3NWZXJzaW9uIjoieDg2XzY0IiwidmVuZG9yIjoiQ2hyb21lIiwidHlwZSI6ImRlc2t0b3AiLCJta3ROYW1lIjoiQ2hyb21lIDg2IiwibW9kZWwiOiI4NiIsIm1vYmlsZU9wdE91dCI6ImZhbHNlIn0=; b2wDeviceType=desktop; searchTestAB=new; b2wChannel=ACOM; B2W-IU=false; bm_mi=5DD28430B9D270A1CD71295811A08292~7Br49Olc1Fu5IgUSnYObmzE8vRtCTAEzgi8fK307qFNCS7pXTkPOQhn5BbYa3fyOtTi/m7PpWRcSMWcmr14ihAT+FTNCIn1OxGSCzkO5d/7l6ms3u8GloIMzseDQFqaoVnUWdr8rLnxoUDXKc1RUWzRXSNP5PgFJ+4bAR9lNC2dxwNGLx6O2tCubRMT54XAoJUsnQlRgeoFxqWeqlbw4yNf1wN4n9aG8Hp1g4EMEcgUs1ssyGHuSesGKxKoqIb+a3gX4EucjsdeaJmFSiEi2fw==; ak_bmsc=383B14F72C50A1F8AC195F2FF0A2604917434C05643A0000DDE8AF5FD5333F66~pld7FMR338RNjOZQoP9bQPj/Va2tqOFiPrmuN8sJ5NmVT7kBSvZrdmEVzOtYr/ZfEkWNt3o/xB1PYtrn+RoQdAMdxP3pyQh6EtIWNYyUV0vRE9v574BcTfrxy4QsAAQWKr8YmPn5HwdFVQRYFlTTOtUWHY2Q13FJlGo2yTQu2fzVaDztGHfuRblmjKup7L5eLUJb0GLh9hLXsaBeuHe39PIf8EQ2FbD4cAG0lMTaCuYvWCUqj7J6DsEdgs1NlL048c; AMCVS_14B422CE52782FA90A490D4D%40AdobeOrg=1; AMCV_14B422CE52782FA90A490D4D%40AdobeOrg=870038026%7CMCIDTS%7C18581%7CMCMID%7C55214875268269991271060002731333958673%7CMCAAMLH-1605968692%7C4%7CMCAAMB-1605968692%7CRKhpRz8krg2tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y%7CMCOPTOUT-1605371092s%7CNONE%7CMCAID%7CNONE%7CvVersion%7C5.0.0%7CMCSYNCSOP%7C411-18554; B2W-SID=740.996185329802820201461124694; s_cc=true; _gid=GA1.3.1120682660.1605363897; _hjIncludedInSessionSample=0; _hjTLDTest=1; _hjAbsoluteSessionInProgress=1; bm_sv=7AD3E97A4ACA62FEF33AC97916778861~/ilL8rt832RXU84XDe1C0ir5IXOocp77blXlNEQfS1djy7EFy+shIORrSmXEpyuDzu/Al03kVzrDMXgiW03hG+hvhbOw1I7yrA/p8rNwOf7kh12kefErRsXnzJCXC5GTewIsPLznqD7Fp2MzBGAxjgBTucMorONX48KJ+3OquyA=; _px_nAflV=MTYwNTM2MzkxODcwNQ==; c_privacyPolicy=1; _px3=14c998b22212cf515b7ccaec5b8f0dbf578427bb586d44077217b24856914cd9:U0n5PHQ5tTa3dLLE5Jzc1s6L77wVvhtmbXR10QioLgfwSn4o7FNumQnQwwHb0o/Zf9fq3HtVEDKeZdUSLYj2Xw==:1000:DMljnrXbqMkdwpIydX9rlBkg7mUAKDfjZLISWHda5mT8Rjeggt2xmzQC8CpuGxA3fGjL/DmLUtvZEQn2DXBeh22nRgWPTLPhEH8cwoO9ink3nH9JFE+COtolbNL4hY30UYrTa1ygzGvmQXUlSfcLkVbzKa/aO52Ut5WtrjiOm2Q=; s_sq=%5B%5BB%5D%5D; _px_9573499949_cs=eyJpZCI6IjFkODg3NGMwLTI2ODUtMTFlYi1hYTNjLTA1NzcyM2Q1MzViNiIsInN0b3JhZ2UiOnsiZyI6dHJ1ZX0sImV4cGlyYXRpb24iOjE2MDUzNjU3NzU2ODR9\n" + 
		//		"");
		httpget.setHeader("cookie",cookie);
		
		
		
		
		return httpget;
	}
	
	private void colocandoCookie() {
		
	}
	

	private void setProxy(HttpClientBuilder httpClientBuilder) {
		// Tratamento de Proxy
		HttpHost proxy = new HttpHost("10.21.7.10", 82);
		httpClientBuilder.setProxy(proxy);
		CredentialsProvider credProvider = new BasicCredentialsProvider();
		credProvider.setCredentials(new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
				new UsernamePasswordCredentials("tr626987", "Piquet08"));
		httpClientBuilder.setDefaultCredentialsProvider(credProvider);
		// ---------------------------------------------------------
	}

	private void certificado(HttpClientBuilder client) throws GeneralSecurityException {
		SSLContext ctx = SSLContext.getInstance("TLS");
		ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() }, new SecureRandom());
		SSLContext.setDefault(ctx);
		client.setSSLContext(ctx);
	}
	
	 private void setSSL(HttpClientBuilder client) 
	            throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {

	        // use the TrustSelfSignedStrategy to allow Self Signed Certificates
	        SSLContext sslContext = SSLContextBuilder
	                .create()
	                .loadTrustMaterial(new TrustSelfSignedStrategy())
	                .build();

	        // we can optionally disable hostname verification. 
	        // if you don't want to further weaken the security, you don't have to include this.
	        HostnameVerifier allowAllHosts = new NoopHostnameVerifier();
	        
	        // create an SSL Socket Factory to use the SSLContext with the trust self signed certificate strategy
	        // and allow all hosts verifier.
	        SSLConnectionSocketFactory connectionFactory = new SSLConnectionSocketFactory(sslContext, allowAllHosts);
	        
	        // finally create the HttpClient using HttpClient factory methods and assign the ssl socket factory
	        //client.setSslcontext(sslcontext)  .custom()
	        //        .setSSLSocketFactory(connectionFactory)
	 }
	
	 private static class DefaultTrustManager implements X509TrustManager {

	        @Override
	        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}

	        @Override
	        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}

	        @Override
	        public X509Certificate[] getAcceptedIssuers() {
	            return null;
	        }
	    }

}
