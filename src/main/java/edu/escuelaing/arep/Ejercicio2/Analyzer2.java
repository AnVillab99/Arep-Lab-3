package edu.escuelaing.arep.Ejercicio2;

import java.io.*;
import java.net.*;

public class Analyzer2 {
    
    public Analyzer2(){}
    
    public void saveUrl() {
        URL google;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter url:");
            String s = br.readLine();
            br.close();
            File file = new File("src\\main\\java\\edu\\escuelaing\\arep\\resources\\archivo.html");
            PrintWriter outputFile = new PrintWriter("src\\main\\java\\edu\\escuelaing\\arep\\resources\\archivo.html");
            
            
            google = new URL(s);
            
            
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(google.openStream()))) {
                String inputLine = null;
                while ((inputLine = reader.readLine()) != null) {
                    outputFile.write(inputLine);
                }
            } catch (IOException x) {
                System.err.println(x);
            }
        }
        
        catch (IOException e){System.out.println(e);}
    }
    
}

