/*
 * Este snippet cria um servidor web que simplesmente ecoa a requisição de um cliente
 * 
 * Crie um form com (por exemplo) este codigo, e use para dar submit
 * 
 * 
 * ______________________________________________________________________________________
 * <form action="http://localhost:8000" method="post">
   <p>
   Name: <input type="text" name="FirstName" value="" size="25" maxlength="50" />
   </p>
   <p>
   Email: <input type="text" name="Email" value="" size="25" maxlength="50" />
   </p>
   <p>
	<input type="submit" name="submit" value="Submit" />
	</p>
	</form>
* _______________________________________________________________________________________
* 
*  Execute o miniHttpServer.java
*  Abra o form e dê um submit
*  Será exibido o 'content' enviado pelo form através de POST
*  
*  A ideia é "treinar" para mandar POSTs dos ônibus para a central
*  recebendo as informações em um mini servidor.
*  No entanto o mini servidor não tem nenhuma proteção. Temos que analisar o custo benefício
*  
*  
 */


package tacheio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;


public class miniHttpServer implements HttpHandler{
	public void handle(HttpExchange t) throws IOException {
		
		//Aqui já tem um furo: E se recebermos um POST de 50 Giga? A String vai estourar...
		
		String response = "Isto e o que voce pediu\n";
		
		response = response +"\n" + "PROTOCOLO:" + t.getProtocol() + "\nMETODO: "+ t.getRequestMethod() +"\n" + t.getRequestURI() +"\n";
		//"RESPONSE CODE (200?):"+ t.getResponseCode() 
		
		InputStream is = t.getRequestBody();
		
		
		
		byte[] b = new byte[1] ;
		
	    while (is.read(b) != -1) {
	    	//is.read(b);
	    	response = response + new String(b);
	    }
	    is.close();
	    
	    /* Esta solução é escalavel. A solucao acima e lixo!
	 // Object exists and is a file: accept with response code 200.
	      t.sendResponseHeaders(200, 0);
	      OutputStream os = t.getResponseBody();
	      FileInputStream fs = new FileInputStream(file);
	      final byte[] buffer = new byte[0x10000];
	      int count = 0;
	      while ((count = fs.read(buffer)) >= 0) {
	        os.write(buffer,0,count);
	      }
	      */
	    
	    
		
		
		
		
		
		
		
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}

	public static void main(String[] args) throws IOException{
		HttpServer server = HttpServer.create(new InetSocketAddress(8000),0);
		server.createContext("/", new miniHttpServer());
		server.setExecutor(null); // creates a default executor
		server.start();

	}
}