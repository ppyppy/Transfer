//Implement  thread-safe blocking queue

//Notice how notifyAll() is only called from enqueue() and dequeue() if the queue size is equal to 
//the size bounds (0 or limit). If the queue size is not equal to either bound when enqueue() or dequeue() 
//is called, there can be no threads waiting to either enqueue or dequeue items.

public class BlockingQueue {

	private List queue = new LinkedList();
	private int limit = 10;

	public BlockingQueue(int limit) {
		this.limit = limit;
	}

	public synchronized void enqueue(Object item) throws InterruptedException {
		while (this.queue.size() == this.limit) {
			wait();
		}
		if (this.queue.size() == 0) {
			notifyAll();  //the wait release the lock, 
						  //and reacquire the lock until the synchronized method exit
		}
		this.queue.add(item);
	}

	public synchronized Object dequeue() throws InterruptedException {
		while (this.queue.size() == 0) {
			wait();
		}
		if (this.queue.size() == this.limit) {
			notifyAll();
		}

		return this.queue.remove(0);
	}

}