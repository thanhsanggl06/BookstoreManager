package entity;

import java.util.Objects;

public class NhaCungCap {
	private String maNCC;
	private String tenNCC;
	private String diaChi;
	private String soDT;
	private String email;
	public String getMaNCC() {
		return maNCC;
	}
	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}
	public String getTenNCC() {
		return tenNCC;
	}
	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public NhaCungCap() {
	
	}
	public NhaCungCap(String maNCC, String tenNCC, String diaChi, String soDT, String email) {
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
		this.diaChi = diaChi;
		this.soDT = soDT;
		this.email = email;
	}
	@Override
	public String toString() {
		return tenNCC;
	}
	@Override
	public int hashCode() {
		return Objects.hash(diaChi, email, maNCC, soDT, tenNCC);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhaCungCap other = (NhaCungCap) obj;
		return Objects.equals(diaChi, other.diaChi) && Objects.equals(email, other.email)
				&& Objects.equals(maNCC, other.maNCC) && Objects.equals(soDT, other.soDT)
				&& Objects.equals(tenNCC, other.tenNCC);
	}
	
}
