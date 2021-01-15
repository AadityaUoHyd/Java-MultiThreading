//To execute three threads in the order of first, second and third using join method.

package test;

public class MyJoinThread {

	public static void main(String[] args) {
		Thread th1 = new Thread(new MyClass(), "th1");
		Thread th2 = new Thread(new MyClass(), "th2");
		Thread th3 = new Thread(new MyClass(), "th3");

		// Let Start the 1st thread
		th1.start();

		//2nd Thread
		try {
			th1.join();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		th2.start();

		//3rd Thread
		try {
			th2.join();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		th3.start();

		//All thread done their execution
		try {
			th3.join();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}  
		System.out.println("Successfully! all three threads have finished their executions in order.");
	}
}

class MyClass implements Runnable{

	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("Let Thread start: "+t.getName());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		System.out.println("Thread execution completion: "+t.getName());

	}
}
