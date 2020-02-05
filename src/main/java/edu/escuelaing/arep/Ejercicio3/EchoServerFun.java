package edu.escuelaing.arep.Ejercicio3;

import java.net.*;
import java.io.*;

public class EchoServerFun {

    public EchoServerFun(){}
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine =null;
        String func = "cos";

        while ((inputLine = in.readLine()) != null) {
            if (inputLine.equals("Bye")){
                out.close();
                in.close();
                clientSocket.close();
                serverSocket.close();
            }
            
            System.out.println("Mensaje:" + inputLine);
            try {  
                if(!(inputLine.contains(":"))){
                    Ê  
                    String[] r = inputLine.split("/|\\*");
                    System.out.println(r[0]);
                    System.out.println(r[1]);
                    /*
                    if(func=="cos"){
                        outputLine = String.valueOf(Math.cos(Double.parseDouble(inputLine)));
                    }
                    else if(func=="sin"){
                        outputLine = String.valueOf(Math.sin(Double.parseDouble(inputLine)));
                    }
                    else if(func=="tan"){
                        outputLine = String.valueOf(Math.tan(Double.parseDouble(inputLine)));
                    }
                    else{outputLine="parametro no valido";}*/
                }
                
            } catch(Exception e){  
                
                outputLine = "Respuesta" + inputLine ; 
            }  
            out.println(outputLine);
        } 
        outputLine = "Respuesta" + inputLine ;
        

            
            
        }
        
    }
