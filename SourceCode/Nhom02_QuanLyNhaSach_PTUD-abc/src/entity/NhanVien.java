package entity;

import java.sql.Date;
import java.util.Objects;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private Date ngaySinh;
	private String gioiTinh;
	private Date ngayVaoLam;
	private String chucVu;
	private String diaChi;
	private String soDienThoai;
	private String email;
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
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
	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}
	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public NhanVien() {
		
	}
	public NhanVien(String maNV) {
		this.maNV = maNV;
	}
	public NhanVien(String maNV, String tenNV, Date ngaySinh, String gioiTinh, Date ngayVaoLam, String chucVu,
			String diaChi, String soDienThoai, String email) {
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.ngayVaoLam = ngayVaoLam;
		this.chucVu = chucVu;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh
				+ ", ngayVaoLam=" + ngayVaoLam + ", chucVu=" + chucVu + ", diaChi=" + diaChi + ", soDienThoai="
				+ soDienThoai + ", email=" + email + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(chucVu, diaChi, email, gioiTinh, maNV, ngaySinh, ngayVaoLam, soDienThoai, tenNV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(chucVu, other.chucVu) && Objects.equals(diaChi, other.diaChi)
				&& Objects.equals(email, other.email) && Objects.equals(gioiTinh, other.gioiTinh)
				&& Objects.equals(maNV, other.maNV) && Objects.equals(ngaySinh, other.ngaySinh)
				&& Objects.equals(ngayVaoLam, other.ngayVaoLam) && Objects.equals(soDienThoai, other.soDienThoai)
				&& Objects.equals(tenNV, other.tenNV);
	}
	
	
	
}
