package tacheio;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
 
public class TestaComunicacao {
 
	private final String USER_AGENT = "Mozilla/5.0";
 
	public static void main(String[] args) throws Exception {
 
		TestaComunicacao http = new TestaComunicacao();
 
//		System.out.println("Testing 1 - Send Http GET request");
//		http.sendGet();
// 
//		System.out.println("\nTesting 2 - Send Http POST request");
//		http.sendPost();
//		
//		System.out.println("\nTesting 3 - Send Http POST to SPTRANS");
//		http.postSPTRANS();
//		
//		System.out.println("\nTesting 4 - Send Http GET SPTRANS Lina");
//		http.getSPTRANS();
		
		System.out.println("\nTesting 5 - Send Http GET SPTRANS Linha");
		http.testaLinha();		
 
	}
 
	// HTTP GET request
	private void sendGet() throws Exception {
 
		String url = "http://www.google.com/search?q=Vedolin";
 
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional default is GET
		con.setRequestMethod("GET");
 
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		System.out.println(response.toString());
 
	}
 
	// HTTP POST request
	private void sendPost() throws Exception {
 
		String url = "https://selfsolve.apple.com/wcResults.do";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
 
		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
 
		String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
 
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		System.out.println(response.toString());
 
	}
	
	
	
	private void postSPTRANS() throws Exception {

		//String url = "http://api.olhovivo.sptrans.com.br/v0/Login/Autenticar?token=859eeafda5d87a8a5e96cae06c4125bdc9873ca687b6888b298691dc8e63d615";
		String url = "http://api.olhovivo.sptrans.com.br/v0/Login/Autenticar?token=859eeafda5d87a8a5e96cae06c4125bdc9873ca687b6888b298691dc8e63d615";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		//con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
 
//		String urlParameters = "/Login/Autenticar?token={859eeafda5d87a8a5e96cae06c4125bdc9873ca687b6888b298691dc8e63d615} ";
		String urlParameters = "";		
 
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		System.out.println(response.toString());
 
	}
 
	// HTTP GET request
		private void getSPTRANS() throws Exception {
	 
			String url = " http://api.olhovivo.sptrans.com.br/v0/Linha/Buscar?termosBusca=Lapa";
	 
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	 
			// optional default is GET
			con.setRequestMethod("GET");
	 
			//add request header
			con.setRequestProperty("User-Agent", USER_AGENT);
	 
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
	 
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
	 
			//print result
			System.out.println(response.toString());
	 
		}
		
		
		
		
		
		
		
		
		
		
		private void testaLinha() throws Exception {

			//String url = "http://api.olhovivo.sptrans.com.br/v0/Login/Autenticar?token=859eeafda5d87a8a5e96cae06c4125bdc9873ca687b6888b298691dc8e63d615";
			String url = "http://api.olhovivo.sptrans.com.br/v0/Login/Autenticar?token=859eeafda5d87a8a5e96cae06c4125bdc9873ca687b6888b298691dc8e63d615";
			
		    CookieManager manager = new CookieManager();
		    manager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
		    CookieHandler.setDefault(manager);
		    
		    
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	 
			//add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			//con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	 
//			String urlParameters = "/Login/Autenticar?token={859eeafda5d87a8a5e96cae06c4125bdc9873ca687b6888b298691dc8e63d615} ";
			String urlParameters = "";		
	 
			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
	 
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);
	 

// Ai, caramba, pu estas linhas e dava null pointer. Imediatamente após comentar, funcionou!
//Ai, seu burro, você rodou o curl e ele é que baixou o cookie!
/*
 * curl -sv -X POST -d '' -b /tmp/cookie-jar.txt -c /tmp/cookie-jar.txt "http://api.olhovivo.sptrans.com.br/v0/Login/Autenticar?token=859eeafda5d87a8a5e96cae06c4125bdc9873ca687b6888b298691dc8e63d615"
			
 */
//			CookieStore cookieJar = manager.getCookieStore();
//		    List<HttpCookie> cookies = cookieJar.getCookies();
//		    for (HttpCookie cookie: cookies) {
//		      System.console().printf("Cookie: %s%n", cookie);}
		    
		    
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
	 
			//print result
			System.out.println(response.toString());

			
			
			
		      

		 
			//url = " http://api.olhovivo.sptrans.com.br/v0/Linha/Buscar?termosBusca=8622";
			//url = "http://api.olhovivo.sptrans.com.br/v0/Linha/CarregarDetalhes?codigoLinha=8622};
			//url = "http://api.olhovivo.sptrans.com.br/v0/Parada/Buscar?termosBusca=Paulista";
			//url = "http://api.olhovivo.sptrans.com.br/v0/Parada/BuscarParadasPorLinha?codigoLinha=438";
			//url = "http://api.olhovivo.sptrans.com.br/v0/Corredor";
			//url = "http://api.olhovivo.sptrans.com.br/v0/Parada/BuscarParadasPorCorredor?codigoCorredor=10";
			//url = "http://api.olhovivo.sptrans.com.br/v0/Posicao?codigoLinha=438";
			//url = "http://api.olhovivo.sptrans.com.br/v0/Previsao/Linha?codigoLinha=438";
			//url = "http://api.olhovivo.sptrans.com.br/v0/Previsao/Parada?codigoParada=4200953";
			
			url = "http://api.olhovivo.sptrans.com.br/v0/Parada/Buscar?termosBusca=Paulista";
			
			//540014154
			obj = new URL(url);
			con = (HttpURLConnection) obj.openConnection();
		 
				// optional default is GET
				con.setRequestMethod("GET");
		 
				//add request header
				con.setRequestProperty("User-Agent", USER_AGENT);
		 
			responseCode = con.getResponseCode();
				System.out.println("\nSending 'GET' request to URL : " + url);
				System.out.println("Response Code : " + responseCode);
		 
			in = new BufferedReader(
				        new InputStreamReader(con.getInputStream()));
			
			response = new StringBuffer();
		 
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
		 
				//print result
				System.out.println(response.toString());
		 
			}
}