package Concurrency;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jay C Espinoza
 */
public class ProcessI implements Runnable{
    private static int turno = 1;
    private final int processNumber;
    
    public ProcessI(int i){
        processNumber = i;
        
    }
    
    public void criticalSection() throws InterruptedException{
        for(int i = 0; i < 10; i++){
            /*Wait for its turn*/
            while(turno != processNumber){/*Just Wait*/}
            
            System.out.println("Process: " + processNumber + " in Critical Section ...");
            Thread.sleep(100);
            turno = (processNumber + 1)%2;
            System.out.println("Process: " + processNumber + " in Remaining Section ...");
            Thread.sleep(100);
        }
    }

    @Override
    public void run() {
        try {
            criticalSection();
        } catch (InterruptedException ex) {
            Logger.getLogger(ProcessI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
