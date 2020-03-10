package multithread;

public class TestThread2 {

	public static void main(String[] args) {
		Thread th1 = new Thread(new ImplementRunable());
		th1.setName("Tien trinh 1");
		th1.start();
		
		Thread th2 = new Thread(new ImplementRunable());
		th2.setName("Tien trinh 2");
		th2.start();
		
	}

}
