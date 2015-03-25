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
		
		String response = "This is the response\n";
		
		InputStream is = t.getRequestBody();
		byte[] b = new byte[1] ;
		
	    while (is.read(b) != -1) {
	    	//is.read(b);
	    	response = response + new String(b);
	    }
	    is.close();
		
		
		
		
		
		
		
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