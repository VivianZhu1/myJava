package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MyThreadTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		Callable c1 = new Task();
		Callable c2 = new Task();
		Callable c3 = new Task();
		Callable c4 = new Task();
		
		
		ExecutorService pool = Executors.newFixedThreadPool(3);
		Future f1 = pool.submit(c1);
		Future f2 = pool.submit(c2);
		Future f3 = pool.submit(c3);
		Future f4 = pool.submit(c4);
		
		Thread.sleep(5000);
		
		try {
			System.out.println(f1.get().toString());
			System.out.println(f2.get().toString());
			System.out.println(f3.get().toString());
			System.out.println(f4.get().toString());
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pool.shutdown();
	}

}


class Task implements Callable{


	@Override
	public Object call() throws Exception {
		
		String info = Thread.currentThread().getId()+":" +Thread.currentThread().getName();
		
		return info;
	}
	
}