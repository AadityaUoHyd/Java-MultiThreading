package coreJava.threads;

class MyThread extends Thread{
	
	public void run() {
		
		for(int i=0; i<10; i++) {              //job of a thread
			System.out.println("Child Thread");
		}
		
	}
}

public class ThreadDemo {
	
	public static void main(String[] args) {
		
		MyThread t=new MyThread();   //instantiation of a thread
		t.start();                   //starting of a MyThread, onwards 2 threads. Thus it'll give mix output.
		
		for(int i=0; i<10; i++) {         
			System.out.println("Main Thread");
		}
		
	}

}