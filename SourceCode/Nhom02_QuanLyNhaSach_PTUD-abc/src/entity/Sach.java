package entity;

public class Sach extends SanPham {
	private TacGia tg;
	private NhaXuatBan nxb;
	private TheLoai tl;
	private String donViTinh;
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public TacGia getTg() {
		return tg;
	}
	public void setTg(TacGia tg) {
		this.tg = tg;
	}
	public NhaXuatBan getNxb() {
		return nxb;
	}
	public void setNxb(NhaXuatBan nxb) {
		this.nxb = nxb;
	}
	public TheLoai getTl() {
		return tl;
	}
	public void setTl(TheLoai tl) {
		this.tl = tl;
	}
	public Sach() {
	}
	public Sach(String maSP, String tenSP, double giaNhap, String hinhAnh, NhaCungCap ncc, int soLuongTon, TacGia tg,
			NhaXuatBan nxb, TheLoai tl, String donViTinh) {
		super(maSP, tenSP, giaNhap, hinhAnh, ncc, soLuongTon);
		this.tg = tg;
		this.nxb = nxb;
		this.tl = tl;
		this.donViTinh = donViTinh;
	}
	@Override
	public String toString() {
		return "Sach [tg=" + tg + ", nxb=" + nxb + ", tl=" + tl + "]";
	}
	
	
	
	
}
