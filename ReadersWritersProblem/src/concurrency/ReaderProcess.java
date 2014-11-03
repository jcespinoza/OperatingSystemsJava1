/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Jay C Espinoza
 */
public class ReaderProcess implements Runnable{
    private static Semaphore writer;
    private static Semaphore mutex;
    private static int readers;
    
    public ReaderProcess(Semaphore incomingWriterSem, Semaphore incomingMutExSem){
        writer = incomingWriterSem;
        mutex = incomingMutExSem;
        
    }

    @Override
    public void run() {
        try { mutex.acquire(); } catch (Exception ex) {}
        readers++;
        if(readers == 1)
            try {
                writer.acquire();
            } catch (Exception ex) {}

        mutex.release();
        
        //read resource
        System.out.println("I am reader[" + "] ");
        
        try { mutex.acquire(); } catch (Exception ex) {}
        readers--;
        if(readers == 0)
            try {
                writer.acquire();
            } catch (Exception ex) {}
        mutex.release();
    }
}
