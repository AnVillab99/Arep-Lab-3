package edu.escuelaing.arep.Ejercicio3;

import java.net.*;
import java.io.*;

public class EchoServer {

    public EchoServer(){}
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
        String inputLine, outputLine;
        while ((inputLine = in.readLine()) != null) {
            if (inputLine.equals("Bye")){
                out.close();
                in.close();
                clientSocket.close();
                serverSocket.close();
            }
            System.out.println("Mensaje:" + inputLine);
            try {  
                outputLine = String.valueOf(Double.parseDouble(inputLine)*Double.parseDouble(inputLine));  
            } catch(NumberFormatException e){  
                outputLine = "Respuesta" + inputLine ; 
            }  
            out.println(outputLine);
        } 
        outputLine = "Respuesta" + inputLine ;
        

            
            
        }
        
    }
