package concurrency;

import java.util.concurrent.*;
/**
 *
 * @author Jay C Espinoza
 */
public class WriterProcess implements Runnable{
    private static Semaphore writer;
    
    
    public WriterProcess(Semaphore incomingWriter){
        writer = incomingWriter;
    }
    
    @Override
    public void run() {
        try {
            writer.acquire();
        } catch (Exception ex) {}
        
        //write to resource
        System.out.println("I'm a writer!");
        
        writer.release();
    }
}
