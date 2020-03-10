package qlsv.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.util.ArrayList;

import qlsv.model.SinhVien;

public class SerializeFileFactory {
	//Luu du lieu 
	public static boolean luuFile(ArrayList<SinhVien> arr, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(arr);
			oos.close();
			fos.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	//Doc du lieu
	public static ArrayList<SinhVien> docFile(String path){
		ArrayList<SinhVien> arr =  new ArrayList<SinhVien>();
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois =  new ObjectInputStream(fis);
			Object data = ois.readObject();
			arr = (ArrayList<SinhVien>) data;
			ois.close();
			fis.close();
			return arr;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return arr;
	}
	

}
