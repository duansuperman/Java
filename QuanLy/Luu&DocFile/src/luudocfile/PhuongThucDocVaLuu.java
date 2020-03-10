package luudocfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class PhuongThucDocVaLuu {
	
	//Luu file kieu thong thuong
	
	public static boolean luuFile(ArrayList<KhachHang> arr, String path) {
		
		try
		{
			FileOutputStream fos=new FileOutputStream(path);	
			OutputStreamWriter osw=new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw=new BufferedWriter(osw);
			for(KhachHang kh: arr)
			{
				String line=kh.getMa()+";"+kh.getTen();
				bw.write(line);
				bw.newLine();
			}
			
			bw.close();
			osw.close();
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
			InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			while(line!=null) {
				String []chuoi = line.split(";");
				arr.add(new KhachHang(chuoi[0],chuoi[1]));
				line=br.readLine();
			}
			//Dong phai theo thu tu
			br.close();
			isr.close();
			fis.close();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return arr;
	}
}
