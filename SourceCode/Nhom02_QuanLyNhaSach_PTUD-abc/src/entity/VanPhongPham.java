package entity;

import java.util.Objects;

public class VanPhongPham extends SanPham {
	private ThuongHieu th;
	private String donViTinh;
	private LoaiSanPham lsp;
	public LoaiSanPham getLsp() {
		return lsp;
	}
	public void setLsp(LoaiSanPham lsp) {
		this.lsp = lsp;
	}
	public ThuongHieu getTh() {
		return th;
	}
	public void setTh(ThuongHieu th) {
		this.th = th;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public VanPhongPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VanPhongPham(String maSP, String tenSP, double giaNhap, String hinhAnh, NhaCungCap ncc, int soLuongTon,
			ThuongHieu th, String donViTinh, LoaiSanPham lsp) {
		super(maSP, tenSP, giaNhap, hinhAnh, ncc, soLuongTon);
		this.th = th;
		this.donViTinh = donViTinh;
		this.lsp = lsp;
	}
	@Override
	public int hashCode() {
		return Objects.hash(donViTinh, th);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VanPhongPham other = (VanPhongPham) obj;
		return Objects.equals(donViTinh, other.donViTinh) && Objects.equals(th, other.th);
	}
	
	
}
