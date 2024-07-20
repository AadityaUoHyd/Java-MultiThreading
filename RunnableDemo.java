package coreJava.threads;

class MyRunnable implements Runnable{
	
	public void run() {
		
		for(int i=0; i<10; i++) {              //job of a thread
			System.out.println("Child Thread");
		}
		
	}
	
}

public class RunnableDemo {
	
	public static void main(String[] args) {
		
		MyRunnable r = new MyRunnable();
		Thread t = new Thread(r);
		t.start();          //starting of a MyThread, onwards 2 threads. Thus it'll give mix output.
		
		for(int i=0; i<10; i++) {         
			System.out.println("Main Thread");
		}
		
	}

}