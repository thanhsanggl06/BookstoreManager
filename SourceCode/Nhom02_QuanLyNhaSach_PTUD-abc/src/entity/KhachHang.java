package entity;

import java.sql.Date;
import java.util.Objects;

public class KhachHang {
	private String maKH;
	private String tenKH;
	private Date ngaySinh;
	private String gioiTinh;
	private String soDienThoai;
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public KhachHang() {
	}
	public KhachHang(String maKH, String tenKH, Date ngaySinh, String gioiTinh, String soDienThoai) {
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
	}
	@Override
	public int hashCode() {
		return Objects.hash(gioiTinh, maKH, ngaySinh, soDienThoai, tenKH);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(gioiTinh, other.gioiTinh) && Objects.equals(maKH, other.maKH)
				&& Objects.equals(ngaySinh, other.ngaySinh) && Objects.equals(soDienThoai, other.soDienThoai)
				&& Objects.equals(tenKH, other.tenKH);
	}
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh
				+ ", soDienThoai=" + soDienThoai + "]";
	}
	
	
	
	
}
