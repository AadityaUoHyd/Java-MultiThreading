package coreJava.threads;

public class WaitNotifyPractice {	
	
	public static void main(String[] args) throws InterruptedException {
		OurThread ourThread = new OurThread();
		ourThread.start();
		
		synchronized(ourThread) {
			System.out.println("Main thread trying to call wait() method, while giving a calculation to child thread"
					+ "=> Find sum of first 100 natural numbers.");
			ourThread.wait();
			System.out.println("Main Thread got notification that child has done calculation successfully.");
			System.out.println("And the sum of first 100 natural numbers is : "+ourThread.total);
		}
	}
}

class OurThread extends Thread {
	
	int total=0;
	
	public void run() {
		synchronized(this){
			System.out.println("Child thread starts calculation.");
			for(int i=0; i<=100; i++) {
				total=total+i;
			}
				System.out.println("Child thread calculates result & now trying to give notification to main thread.");
				this.notify();			
		}
	}
}