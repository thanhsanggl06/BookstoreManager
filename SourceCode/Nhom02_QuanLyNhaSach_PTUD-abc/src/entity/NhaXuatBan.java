package entity;

public class NhaXuatBan {
	private String maNXB;
	private String tenNXB;
	public String getMaNXB() {
		return maNXB;
	}
	public void setMaNXB(String maNXB) {
		this.maNXB = maNXB;
	}
	public String getTenNXB() {
		return tenNXB;
	}
	public void setTenNXB(String tenNXB) {
		this.tenNXB = tenNXB;
	}
	public NhaXuatBan() {
		
	}
	public NhaXuatBan(String maNXB, String tenNXB) {
		this.maNXB = maNXB;
		this.tenNXB = tenNXB;
	}
	@Override
	public String toString() {
		return tenNXB;
	}
	
	
	
	
}
