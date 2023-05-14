package entity;

import java.util.Objects;

public class TacGia {
	private String maTacGia;
	private String tenTacGia;
	public String getMaTacGia() {
		return maTacGia;
	}
	public void setMaTacGia(String maTacGia) {
		this.maTacGia = maTacGia;
	}
	public String getTenTacGia() {
		return tenTacGia;
	}
	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}
	public TacGia() {
		
	}
	public TacGia(String maTacGia, String tenTacGia) {
		this.maTacGia = maTacGia;
		this.tenTacGia = tenTacGia;
	}
	@Override
	public String toString() {
		return tenTacGia;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maTacGia, tenTacGia);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TacGia other = (TacGia) obj;
		return Objects.equals(maTacGia, other.maTacGia) && Objects.equals(tenTacGia, other.tenTacGia);
	}
	
	
	
}
