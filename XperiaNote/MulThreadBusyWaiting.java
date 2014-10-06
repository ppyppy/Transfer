//Busy waiting(Thred is executing even though is doing nothing but wait for the second thread to stop or release
//shared resource. 

//How it can be avoid:
void func(){
	Thead task = new TheTask();
	Sychronized(task){
		task.start();
		try{
			task.wait(); //release the sychronize lock
			...//this mechnism can make sure to wait till the run starts then excute next line of code
		}catch(){
			
		}
	}
}

Class TheTask extends Thread{
	public void run(){
		Synchoronized(this){
			this.notify();
		}
	}
}

//Simple implementation of producer and consumer
public class IntBuffer{
	private int index;
	private int[] buffer = new int[len];
	public Synchronized void add(int num){
		while(index==buffer.length-1){
			try{
				wait();
			}catch{
				
			}
		}
		buffer[index++] = num;
		notifyAll();
	}
	
	public Synchronized int remove(){
		while(index==0){
			try{
				wait();
			}catch{
				
			}
		}
		int ret = buffer[--index];
		notifyAll();
		return ret;
	}
}

