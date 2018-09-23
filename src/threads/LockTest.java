package threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class LockTest {
	
	Object lock = new Object();
	
	public static void main(String[] args) {
		final Queue<Integer> sharedQ = new LinkedList<Integer>();
		  
	      Thread producerThread = new Thread(new Producer(sharedQ, 4), "PRODUCER");
	      Thread consumerThread = new Thread(new Consumer(sharedQ, 4), "CONSUMER");
	     
	      producerThread.start();
	      consumerThread.start();
		
	}

}
@SuppressWarnings("rawtypes")
class Consumer implements Runnable
{
  
	private final Queue sharedQ;
    @SuppressWarnings("unused")
	private int maxSize;
     
    public Consumer(Queue sharedQ, int maxSize)
    {
        this.sharedQ = sharedQ;
    }
     
    @Override
    public void run(){
        while(true)
        {
            synchronized (sharedQ) {
                while(sharedQ.isEmpty())
                {
                    try {
                        System.out.println("Que is Empty");
                        sharedQ.wait();
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace(); 
                    }
                }
                 
                int number = (int) sharedQ.poll();
                System.out.println("removing Element " + number);
                sharedQ.notify();
                 
            }
        }
    }
     
}


class Producer implements Runnable
{
    @SuppressWarnings("rawtypes")
	private final Queue sharedQ;
    private int maxSize;
     
    @SuppressWarnings("rawtypes")
	public Producer(Queue sharedQ, int maxSize)
    {
        this.sharedQ = sharedQ;
        this.maxSize = maxSize;
    }
     
    @SuppressWarnings("unchecked")
	@Override
    public void run(){
         
        while(true)
        {
            synchronized (sharedQ) {
                while(sharedQ.size()==maxSize)
                {
                    try
                    {
                        System.out.println("Queue is full");
                        sharedQ.wait();
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                     
                }
                Random random = new Random(); 
                int number = random.nextInt(100);
                System.out.println("Producing value " + number);
                sharedQ.add(number);
                sharedQ.notify();
                 
            }
             
        }
    }
}
