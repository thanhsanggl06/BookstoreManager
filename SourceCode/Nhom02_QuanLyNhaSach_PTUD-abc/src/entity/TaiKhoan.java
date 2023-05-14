package entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class TaiKhoan {
	private NhanVien nv;
	private String tenDangNhap;
	private String passWord;
	private String phanQuyen;

	public TaiKhoan(NhanVien nv, String tenDangNhap, String passWord, String phanQuyen) {
		super();
		this.nv = nv;
		this.tenDangNhap = tenDangNhap;
		this.passWord = passWord;
		this.phanQuyen = phanQuyen;
	}

	public TaiKhoan(NhanVien nv, String tenDangNhap, String passWord) {
		super();
		this.nv = nv;
		this.tenDangNhap = tenDangNhap;
		this.passWord = passWord;
	}

	public TaiKhoan(String tenDangNhap, String passWord, String phanQuyen) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.passWord = passWord;
		this.phanQuyen = phanQuyen;
	}

	public TaiKhoan() {
		// TODO Auto-generated constructor stub
	}

	public NhanVien getNv() {
		return nv;
	}

	public void setNv(NhanVien nv) {
		this.nv = nv;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getPhanQuyen() {
		return phanQuyen;
	}

	public void setPhanQuyen(String phanQuyen) {
		this.phanQuyen = phanQuyen;
	}

	@Override
	public String toString() {
		return nv.getMaNV() + "-" + nv.getTenNV();
	}

	@Override
	public int hashCode() {
		return Objects.hash(nv, tenDangNhap, passWord, phanQuyen);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(nv, other.nv) && Objects.equals(passWord, other.passWord)
				&& Objects.equals(phanQuyen, other.phanQuyen) && Objects.equals(tenDangNhap, other.tenDangNhap);
	}

}
