package multithread;

public abstract class TestThread1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExtendThread th1 = new ExtendThread();
		th1.setName("Tien trinh 1");
		th1.start();
		
		ExtendThread th2 = new ExtendThread();
		th2.setName("Tien trnh 2");
		th2.start();

	}

}
