package concurrency;

import java.util.concurrent.Semaphore;

/**
 * @author Jay C Espinoza
 */
public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Semaphore writerSem = new Semaphore(1); //To prevent more than 1 writer
        Semaphore readerMutExSem = new Semaphore(1); //To prevent mutual exclusion between readers
        
        /***Readers***/
        ReaderProcess RP0 = new ReaderProcess(writerSem, readerMutExSem);
        ReaderProcess RP1 = new ReaderProcess(writerSem, readerMutExSem);
        ReaderProcess RP2 = new ReaderProcess(writerSem, readerMutExSem);
        
        /*** Writers ***/
        WriterProcess WP0 = new WriterProcess(writerSem);
        WriterProcess WP1 = new WriterProcess(writerSem);
        
        /*** Threads ***/
        Thread tr0 = new Thread(RP0);
        Thread tr1 = new Thread(RP1);
        Thread tr2 = new Thread(RP2);
        
        Thread tw0 = new Thread(WP0);
        Thread tw1 = new Thread(WP1);
        
        tr1.start();
        tw1.start();
        tr0.start();
        tw0.start();
        tr2.start();
        
        System.out.println("Main Process Finished Execution");
    }
}
