package Object;

public class ThietBi {
	public String TenThietBi;
	public String TrangThai;
	public ThietBi(){
		TenThietBi="";
		TrangThai="";
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return TenThietBi+"__"+TrangThai;
	}
}
