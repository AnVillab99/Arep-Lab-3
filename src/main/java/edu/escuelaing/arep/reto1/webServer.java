package edu.escuelaing.arep.reto1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class webServer {

    static final File ROOT = new File("/");
    static final String DEFAULT =  "index.html";
    static final String FILE_NOT_FOUND =  "404.html";
    static final String METHOD_NOT_ALLOWED = "/405.html";
    static final String UNSUPPORTED_MEDIA_TYPE = "/415.html";
    static final int PORT=35000;




    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Abierto");
            PrintWriter out = null;
            BufferedReader in = null;
            BufferedOutputStream dataOut = null;
            Socket clientSocket = null;
            while (true){
                try {
                    clientSocket = serverSocket.accept();
                    System.out.println("Conectado");
                } catch (IOException e) {
                    System.out.println("Error al conectar al cliente");
                }
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));//leer
                out = new PrintWriter(clientSocket.getOutputStream(), true); //devolver
                String inputLine = in.readLine();
                while (inputLine != null) {
                    System.out.println("inputline " + inputLine);
                    if (!(in.ready())) {
                        break;
                    }
                    inputLine = in.readLine();
                    
                }
            }
        } catch (IOException e) {
            System.out.println(" Error opening port " + PORT + " error :"+ e );
        }
        


    }
        
}







