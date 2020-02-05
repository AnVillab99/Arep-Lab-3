package edu.escuelaing.arep.Ejercicio3;

import java.net.*;
import java.io.*;

public class EchoServerFun {

    public EchoServerFun() {
    }

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
        String inputLine, outputLine = null;
        String func = "cos";

        while (true) {
            inputLine = in.readLine();
            try {

                if (inputLine.equals("Bye") || inputLine == null) {
                    out.close();
                    in.close();
                    clientSocket.close();
                    serverSocket.close();
                    break;
                }

                System.out.println("Mensaje:" + inputLine);
                String[] r = inputLine.split(":");
                if (r.length == 2) {
                    func = r[1];
                    outputLine = ("funcion cambiada a " + func);

                } else {
                    double k = 0;
                    if (r[0].contains("p")) {
                        String[] res1 = r[0].split("/");
                        String[] res2 = r[0].split("\\*");
                        if (res1.length == 2) {
                            // System.out.println("/ p");
                            k = Double.parseDouble(res1[0].replace("p", "3.14159"))
                                    / Double.parseDouble(res1[1].replace("p", "3.14159"));
                        } else if (res1.length == 2) {
                            // System.out.println("* p");
                            k = Double.parseDouble(res2[0].replace("p", "3.14159"))
                                    * Double.parseDouble(res2[1].replace("p", "3.14159"));
                        } else {

                            k = Double.parseDouble(r[0].replace("p", "3.14159"));

                        }

                    } else {
                        k = Double.parseDouble(r[0]);
                    }
                    System.out.println("la  func es :" + func);
                    System.out.println("k es:" + k);
                    if (func.equals("cos")) {
                        System.out.println("entro a func cos");
                        outputLine = String.valueOf(Math.cos(k));
                    } else if (func.equals("sin")) {
                        System.out.println("entro a func sin");
                        System.out.println(String.valueOf(Math.sin(k)));
                        outputLine = String.valueOf(Math.sin(k));
                    } else if (func.equals("tan")) {
                        System.out.println("entro a func tan");
                        outputLine = String.valueOf(Math.tan(k));
                    } else {
                        outputLine = "parametro no valido";
                    }
                }
            } catch (Exception e) {
                outputLine = "Exception: " + inputLine;
            }
            out.println(outputLine);
            outputLine = "Respuesta" + inputLine;

        }

    }

}
