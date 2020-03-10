package luudocfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class SerializeFileFactory {
	public static boolean luuFile(ArrayList<KhachHang> arr, String path) {
		
		try
		{
			FileOutputStream fos=new FileOutputStream(path);	
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(arr);
			oos.close();
			fos.close();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
		
	}
	public static ArrayList<KhachHang> DocFile(String path){
		ArrayList<KhachHang> arr = new ArrayList<KhachHang>();
		try {
			//Lay du lieu tu  o cung day len ram
			FileInputStream fis = new FileInputStream(path);
			//Chuyen dinh dang UTF-8
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object data = ois.readObject();
			arr=(ArrayList<KhachHang>)data;
			ois.close();
			fis.close();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return arr;
	}
}
