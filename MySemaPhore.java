//Program to use Semaphores as Locks, and also preventing race condition.

package test;

import java.util.concurrent.Semaphore; 
   
class Shared  
{ 
    static int count = 0; 
} 
  
class MyThread extends Thread 
{ 
    Semaphore sem; 
    String threadName; 
    public MyThread(Semaphore sem, String threadName)  
    { 
        super(threadName); 
        this.sem = sem; 
        this.threadName = threadName; 
    } 
  
    @Override
    public void run() { 
          
        // run by thread X 
        if(this.getName().equals("X")) 
        { 
            System.out.println("Starting " + threadName); 
            try 
            { 
                // First, get a permit. 
                System.out.println(threadName + " is waiting for a permit."); 
              
                // lock acquired
                sem.acquire(); 
              
                System.out.println(threadName + " gets a permit."); 
          
                // Now, accessing the shared resource. 
                // other waiting threads will wait, until this  
                // thread release the lock 
                for(int i=0; i < 10; i++) 
                { 
                    Shared.count++; 
                    System.out.println(threadName + ": " + Shared.count); 
          
                    // Now, allowing a context switch -- if possible. 
                    // for thread Y to execute 
                    Thread.sleep(10); 
                } 
            } catch (InterruptedException exc) { 
                    System.out.println(exc); 
                } 
          
                // Release the permit. 
                System.out.println(threadName + " releases the permit."); 
                sem.release(); 
        } 
          
        // run by thread Y 
        else
        { 
            System.out.println("Starting " + threadName); 
            try 
            { 
                // First, get a permit. 
                System.out.println(threadName + " is waiting for a permit."); 
              
                // acquiring the lock 
                sem.acquire(); 
              
                System.out.println(threadName + " gets a permit."); 
          
                // Now, accessing the shared resource. 
                // other waiting threads will wait, until this  
                // thread release the lock 
                for(int i=0; i < 10; i++) 
                { 
                    Shared.count--; 
                    System.out.println(threadName + ": " + Shared.count); 
          
                    // Now, allowing a context switch -- if possible. 
                    // for thread X to execute 
                    Thread.sleep(10); 
                } 
            } catch (InterruptedException exc) { 
                    System.out.println(exc); 
                } 
                // Release the permit. 
                System.out.println(threadName + " releases the permit."); 
                sem.release(); 
        } 
    } 
} 
  
// And here comes, Main class of Java 
public class MySemaPhore { 
    public static void main(String args[]) throws InterruptedException  
    { 
        // with 1 permission, launching a Semaphore 
        Semaphore sem = new Semaphore(1); 
          
       
        // Here, thread X going to increse count value where as Y will decrease.
        MyThread mt1 = new MyThread(sem, "X"); 
        MyThread mt2 = new MyThread(sem, "Y"); 
          
        // Threads X and Y started
        mt1.start(); 
        mt2.start(); 
          
        // Waits for X and Y threads  
        mt1.join(); 
        mt2.join(); 
          
        System.out.println("count: " + Shared.count); 
    } 
} 
