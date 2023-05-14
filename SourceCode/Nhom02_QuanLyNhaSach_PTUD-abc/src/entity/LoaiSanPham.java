package entity;

import java.util.Objects;

public class LoaiSanPham {
	private String maLoai;
	private String tenLoai;
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public LoaiSanPham() {
		
	}
	public LoaiSanPham(String maLoai, String tenLoai) {
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
	}
	@Override
	public String toString() {
		return tenLoai;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maLoai, tenLoai);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiSanPham other = (LoaiSanPham) obj;
		return Objects.equals(maLoai, other.maLoai) && Objects.equals(tenLoai, other.tenLoai);
	}
	
	
}
