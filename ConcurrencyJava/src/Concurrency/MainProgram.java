package Concurrency;

import java.io.IOException;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Jay C Espinoza
 */
public class MainProgram {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("\"*** Ejemplo de Sincronizacion de 2 procesos *****\"");
        
        ProcessI P0, P1;
        P0 = new ProcessI(0);
        P1 = new ProcessI(1);
        
        Thread t1, t2;
        t1 = new Thread(P0);
        t2 = new Thread(P1);
        
        t1.start();
        t2.start();

        System.out.println("Press any key to continue . . .");
        try {
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(MainProgram.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
