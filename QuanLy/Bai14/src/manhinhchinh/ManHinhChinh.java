package manhinhchinh;

import java.util.Scanner;

import bai14.model.MyWindow;

public class ManHinhChinh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String title = new  Scanner(System.in).nextLine();
		MyWindow mw = new MyWindow(title);
		mw.addControl();
		mw.showWindow();
		
	}

}
