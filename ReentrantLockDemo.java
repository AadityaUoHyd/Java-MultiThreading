package coreJava.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class TheThread extends Thread {
	static ReentrantLock lock = new ReentrantLock();
	
	TheThread(String name){
		super(name);
	}
	public void run() {
		do {
			try {
				if(lock.tryLock(5000,TimeUnit.MILLISECONDS)) {
					System.out.println(Thread.currentThread().getName()+"....got lock.");
					Thread.sleep(30000);
					lock.unlock();
					System.out.println(Thread.currentThread()+"....release lock.");
					break;
				}else {
					System.out.println(Thread.currentThread()+"....unable to get lock and will try again.");
				}
			}
			catch(Exception e) {}
		}
		while(true);
	}
}

public class ReentrantLockDemo {
	
	public static void main(String[] args) {
		TheThread t1 = new TheThread("First Thread");
		TheThread t2 = new TheThread("Second Thread");
		t1.start();
		t2.start();
	}

}
