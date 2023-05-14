package entity;

import java.util.Objects;

public class ThuongHieu {
	 private String maThuongHieu;
	 private String tenThuongHieu;
	public String getMaThuongHieu() {
		return maThuongHieu;
	}
	public void setMaThuongHieu(String maThuongHieu) {
		this.maThuongHieu = maThuongHieu;
	}
	public String getTenThuongHieu() {
		return tenThuongHieu;
	}
	public void setTenThuongHieu(String tenThuongHieu) {
		this.tenThuongHieu = tenThuongHieu;
	}
	public ThuongHieu() {
	}
	public ThuongHieu(String maThuongHieu, String tenThuongHieu) {
		this.maThuongHieu = maThuongHieu;
		this.tenThuongHieu = tenThuongHieu;
	}
	@Override
	public String toString() {
		return tenThuongHieu;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maThuongHieu, tenThuongHieu);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThuongHieu other = (ThuongHieu) obj;
		return Objects.equals(maThuongHieu, other.maThuongHieu) && Objects.equals(tenThuongHieu, other.tenThuongHieu);
	}
	
	
	
	
	 
	 
}
