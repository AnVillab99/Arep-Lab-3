package edu.escuelaing.arep.Ejercicio3;

import java.io.*;
import java.net.*;

public class EchoClientFun {


    public EchoClientFun() {
    }
    public static void main(String[] args) throws IOException {
        
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        
        try {
            echoSocket = new Socket("127.0.0.1", 35000);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don’t know about host!.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn’t get I/O for "
            + "the connection to: localhost.");
            System.exit(1);
        }
        
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        System.out.println(" cambiar funcion 'fun:funcion', puede ser sin, cos, tan.");
        System.out.println("Para seguir con la funcion actual solo escriba el numero a calcular de acuerdo a la funcion, de base esta cos.");
        while ((userInput = stdIn.readLine()) != null) {
            
            out.println(userInput);
            System.out.println("Respuesta: " + in.readLine());
            
        }
        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}