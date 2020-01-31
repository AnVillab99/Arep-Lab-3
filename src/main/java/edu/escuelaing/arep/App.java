package edu.escuelaing.arep;

import edu.escuelaing.arep.Ejercicio1.Analyzer;
import edu.escuelaing.arep.Ejercicio2.Analyzer2;
import edu.escuelaing.arep.Ejercicio3.EchoClient;
import edu.escuelaing.arep.Ejercicio3.EchoServer;

public class App {

    public static void main(String[] args) {
        Analyzer ur = new Analyzer();
        //ur.analyze();
        Analyzer2 ur2 = new Analyzer2();
        //ur2.saveUrl();
        EchoServer es = new EchoServer();
        EchoClient ec = new EchoClient(); 

        
        
        
    }
}

