package coreJava.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SuppressWarnings("rawtypes")
class MyCallable implements Callable {
	
	int num = 0;
	MyCallable(int num){
		this.num = num;
	}
	
	public Object call() throws Exception{
		System.out.print(Thread.currentThread().getName()+" is responsible to find sum of first "+num+" numbers => ");
		int sum=0;
		for(int i=0; i<=num; i++) {
			sum = sum + i;
		}
		return sum;
	}
}

public class CallableFutureDemo {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		MyCallable[] jobs= {
				new MyCallable(10),
				new MyCallable(20),
				new MyCallable(40),
				new MyCallable(70),
				new MyCallable(20),
				new MyCallable(50),
		};
		ExecutorService service = Executors.newFixedThreadPool(4);
		for(MyCallable job : jobs) {
			Future<?> f = service.submit(job);
			System.out.println(f.get());
		}
		service.shutdown();
	}
}