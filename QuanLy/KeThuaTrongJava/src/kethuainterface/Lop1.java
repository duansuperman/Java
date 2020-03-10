package kethuainterface;

public class Lop1 implements Comparable<Lop1> {

	String ten;
	int tuoi;
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getTuoi() {
		return tuoi;
	}
	public Lop1() {
		super();
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	
	@Override
	public String toString() {
		return "Lop1 [ten=" + ten + ", tuoi=" + tuoi + "]";
	}
	public Lop1(String ten, int tuoi) {
		super();
		this.ten = ten;
		this.tuoi = tuoi;
	}
	@Override
	public int compareTo(Lop1 o) {
		// TODO Auto-generated method stub
		//return ten.compareToIgnoreCase(o.ten);
		if(ten==o.ten) {
			if(tuoi==o.tuoi) {
				return 0;
			}
			else if(tuoi<o.tuoi) {
				return 1;
			}
			else {
				return -1;
			}
		}
		return ten.compareToIgnoreCase(o.ten);
	}

	
}
