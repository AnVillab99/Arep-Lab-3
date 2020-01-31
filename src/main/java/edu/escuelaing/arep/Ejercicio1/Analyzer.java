package edu.escuelaing.arep.Ejercicio1;
import java.net.MalformedURLException;
import java.net.URL;

public class Analyzer {
	
	public Analyzer() {
	}
	
	/**
	* This method prints the info of an URL
	*/
	
	public void analyze() {
		URL url;
		try {
			url = new URL("https://arxiv.org:8080/pdf/quant-ph/0702225.pdf");
			String[] partes = new String[8];
			partes[0] = url.getProtocol();
			partes[1] = url.getAuthority();
			partes[2] = url.getHost();
			partes[3] = String.valueOf(url.getPort());
			partes[4] = url.getPath();
			partes[5] = url.getQuery();
			partes[6] = url.getFile();
			partes[7] = url.getRef();
			for (String s : partes){
				System.out.println(s);
				
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
