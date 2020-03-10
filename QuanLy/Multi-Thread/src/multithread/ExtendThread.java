package multithread;

public class ExtendThread extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0;i<=6;i++) {
			System.out.println(Thread.currentThread().getName()+": "+i+" dang chay");
		}
	}
	

}
