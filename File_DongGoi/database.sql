USE [QuanLyHieuSach]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 11/12/2022 7:01:53 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[MaHoaDon] [varchar](15) NOT NULL,
	[MaSanPham] [varchar](15) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[TongTien] [money] NOT NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC,
	[MaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 11/12/2022 7:01:53 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHoaDon] [varchar](15) NOT NULL,
	[MaKhachHang] [varchar](15) NOT NULL,
	[MaNhanVien] [varchar](15) NOT NULL,
	[NgayLapHoaDon] [date] NOT NULL,
	[TongTien] [money] NOT NULL,
	[GioLap] [time](7) NULL,
	[TrangThai] [nvarchar](20) NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/12/2022 7:01:53 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKhachHang] [varchar](15) NOT NULL,
	[TenKhachHang] [nvarchar](50) NOT NULL,
	[Ngaysinh] [date] NOT NULL,
	[GioiTinh] [nvarchar](10) NOT NULL,
	[DiaChi] [nvarchar](50) NOT NULL,
	[SoDienThoai] [varchar](11) NOT NULL,
	[TinhTrang] [nchar](10) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiSanPham]    Script Date: 11/12/2022 7:01:53 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiSanPham](
	[MaLoaiSanPham] [varchar](15) NOT NULL,
	[TenLoaiSanPham] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_LoaiSanPham] PRIMARY KEY CLUSTERED 
(
	[MaLoaiSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 11/12/2022 7:01:53 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[MaNCC] [varchar](15) NOT NULL,
	[TenNCC] [nvarchar](50) NOT NULL,
	[DiaChi] [nvarchar](50) NOT NULL,
	[SoDienThoai] [varchar](11) NOT NULL,
	[Email] [varchar](100) NOT NULL,
 CONSTRAINT [PK_NhaCungCap] PRIMARY KEY CLUSTERED 
(
	[MaNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/12/2022 7:01:53 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNhanVien] [varchar](15) NOT NULL,
	[TenNhanVien] [nvarchar](50) NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[GioiTinh] [nvarchar](10) NOT NULL,
	[NgayVaoLam] [date] NOT NULL,
	[ChucVu] [nvarchar](20) NOT NULL,
	[DiaChi] [nvarchar](50) NOT NULL,
	[SoDienThoai] [varchar](11) NOT NULL,
	[Email] [varchar](100) NOT NULL,
	[TinhTrang] [nchar](10) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaXuatBan]    Script Date: 11/12/2022 7:01:53 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaXuatBan](
	[MaNXB] [varchar](15) NOT NULL,
	[TenNXB] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_NhaXuatBan] PRIMARY KEY CLUSTERED 
(
	[MaNXB] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 11/12/2022 7:01:53 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSanPham] [varchar](15) NOT NULL,
	[TenSanPham] [nvarchar](50) NOT NULL,
	[MaNXB] [varchar](15) NULL,
	[GiaNhap] [money] NOT NULL,
	[MaTheLoai] [varchar](15) NULL,
	[MaThuongHieu] [varchar](15) NULL,
	[MaLoaiSanPham] [varchar](15) NULL,
	[MaNCC] [varchar](15) NULL,
	[SoLuongTon] [int] NOT NULL,
	[Image] [varchar](150) NULL,
	[MaTacGia] [varchar](15) NULL,
	[DonViTinh] [nvarchar](20) NOT NULL,
	[TrangThai] [char](1) NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[MaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TacGia]    Script Date: 11/12/2022 7:01:53 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TacGia](
	[MaTacGia] [varchar](15) NOT NULL,
	[TenTacGia] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_TacGia] PRIMARY KEY CLUSTERED 
(
	[MaTacGia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 11/12/2022 7:01:53 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[MaNhanVien] [varchar](15) NOT NULL,
	[TenDangNhap] [varchar](50) NOT NULL,
	[Password] [varchar](50) NOT NULL,
	[phanQuyen] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[TenDangNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TheLoai]    Script Date: 11/12/2022 7:01:53 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TheLoai](
	[MaTheLoai] [varchar](15) NOT NULL,
	[TenTheLoai] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_TheLoai] PRIMARY KEY CLUSTERED 
(
	[MaTheLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThuongHieu]    Script Date: 11/12/2022 7:01:53 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThuongHieu](
	[MaThuongHieu] [varchar](15) NOT NULL,
	[TenThuongHieu] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_ThuongHieu] PRIMARY KEY CLUSTERED 
(
	[MaThuongHieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000001', N'SP2390', 2, 300000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000002', N'SP2395', 10, 300000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000003', N'SP001', 1, 105000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000003', N'SP2390', 2, 300000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000003', N'SP2391', 3, 360000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000004', N'SP2397', 1, 314850.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000004', N'SP2398', 2, 30.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000004', N'SP2399', 2, 272700.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000005', N'SP2396', 5, 150000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000006', N'SP2399', 2, 272700.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000007', N'SP2399', 1, 136350.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000008', N'SP2394', 2, 270000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000008', N'SP2399', 1, 136350.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000009', N'SP2394', 3, 405000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000011', N'SP2399', 1, 136350.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000012', N'SP2396', 1, 30000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000013', N'SP2396', 1, 30000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000014', N'SP2396', 1, 30000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000015', N'SP2396', 1, 30000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000016', N'SP2397', 1, 314850.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000016', N'SP2399', 1, 136350.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000017', N'SP2394', 1, 135000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000017', N'SP2399', 1, 136350.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000018', N'SP2397', 1, 314850.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000018', N'SP2399', 1, 136350.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000018', N'SP2403', 1, 150000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000019', N'SP2398', 5, 75000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000019', N'SP2401', 1, 150000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000020', N'SP2398', 1, 15000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000020', N'VPP0005', 1, 3000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000021', N'SP2392', 3, 450000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000022', N'SP2395', 5, 150000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000023', N'SP2391', 5, 600000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221000023', N'SP2399', 3, 409050.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221100001', N'SP2401', 1, 150000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221100002', N'SP2392', 1, 150000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221100002', N'SP2397', 1, 314850.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221200001', N'SP2397', 1, 314850.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221200002', N'SP2397', 1, 314850.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221200003', N'SP2403', 1, 150000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221200004', N'SP2390', 1, 150000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221200004', N'SP2391', 1, 120000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221200005', N'SP2390', 1, 150000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221200006', N'SP2391', 1, 120000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221200007', N'SP2406', 1, 135000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221200008', N'SP2403', 1, 150000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221200009', N'SP2403', 1, 150000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221200010', N'SP2390', 2, 300000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221200011', N'SP2391', 1, 120000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221200012', N'SP2390', 2, 300000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221200013', N'SP2390', 1, 150000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221200014', N'SP2390', 1, 150000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221200014', N'SP2391', 2, 240000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221200015', N'SP2390', 1, 150000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221200015', N'SP2396', 2, 60000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221200016', N'SP2395', 1, 30000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221200016', N'SP2396', 2, 60000.0000)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPham], [SoLuong], [TongTien]) VALUES (N'HD221200017', N'VPP0001', 1, 4500.0000)
GO
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221000001', N'KH0002', N'NV0001', CAST(N'2022-10-22' AS Date), 330000.0000, CAST(N'20:15:26' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221000002', N'KH0001', N'NV0001', CAST(N'2022-10-22' AS Date), 330000.0000, CAST(N'20:16:01' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221000003', N'KH0001', N'NV0001', CAST(N'2022-10-23' AS Date), 841500.0000, CAST(N'20:05:43' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221000004', N'KH0001', N'NV0001', CAST(N'2022-10-25' AS Date), 646338.0000, CAST(N'00:14:25' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221000005', N'KH0001', N'NV0001', CAST(N'2022-10-25' AS Date), 165000.0000, CAST(N'00:23:22' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221000006', N'KH0001', N'NV0001', CAST(N'2022-10-25' AS Date), 299970.0000, CAST(N'00:27:49' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221000007', N'KH0001', N'NV0001', CAST(N'2022-10-25' AS Date), 149985.0000, CAST(N'00:28:47' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221000008', N'KH0001', N'NV0001', CAST(N'2022-10-25' AS Date), 446985.0000, CAST(N'00:35:27' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221000009', N'KH0003', N'NV0001', CAST(N'2022-10-25' AS Date), 445500.0000, CAST(N'00:37:35' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221000011', N'KH0001', N'NV0001', CAST(N'2022-10-25' AS Date), 149985.0000, CAST(N'00:42:09' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221000012', N'KH0001', N'NV0001', CAST(N'2022-10-25' AS Date), 33000.0000, CAST(N'14:51:47' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221000013', N'KH0001', N'NV0001', CAST(N'2022-10-25' AS Date), 33000.0000, CAST(N'14:56:13' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221000014', N'KH0001', N'NV0001', CAST(N'2022-10-25' AS Date), 33000.0000, CAST(N'14:59:23' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221000015', N'KH0001', N'NV0001', CAST(N'2022-10-25' AS Date), 33000.0000, CAST(N'15:39:04' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221000016', N'KH0004', N'NV12093', CAST(N'2022-10-25' AS Date), 496320.0000, CAST(N'20:35:14' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221000017', N'KH0001', N'NV12093', CAST(N'2022-10-25' AS Date), 298485.0000, CAST(N'20:39:12' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221000018', N'KH0001', N'NV12093', CAST(N'2022-10-27' AS Date), 661320.0000, CAST(N'00:02:57' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221000019', N'KH0001', N'NV12093', CAST(N'2022-10-31' AS Date), 247500.0000, CAST(N'07:48:28' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221000020', N'KH0004', N'NV12093', CAST(N'2022-10-30' AS Date), 19800.0000, CAST(N'20:59:22' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221000021', N'KH0001', N'NV12093', CAST(N'2022-10-31' AS Date), 495000.0000, CAST(N'04:23:02' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221000022', N'KH0007', N'NV12093', CAST(N'2022-10-31' AS Date), 165000.0000, CAST(N'06:50:30' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221000023', N'KH0008', N'NV12093', CAST(N'2022-10-31' AS Date), 1109955.0000, CAST(N'07:43:04' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221100001', N'KH0001', N'NV12093', CAST(N'2022-11-04' AS Date), 165000.0000, CAST(N'06:47:57' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221100002', N'KH0009', N'NV12093', CAST(N'2022-11-04' AS Date), 511335.0000, CAST(N'13:45:15' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221100003', N'KH0001', N'NV12093', CAST(N'2022-12-05' AS Date), 300000.0000, CAST(N'17:40:00' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221100004', N'KH0004', N'NV12093', CAST(N'2022-12-04' AS Date), 5000000.0000, CAST(N'17:00:00' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221100005', N'KH0003', N'NV12093', CAST(N'2022-12-03' AS Date), 9000000.0000, CAST(N'08:00:00' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221200001', N'KH0001', N'NV12093', CAST(N'2022-12-06' AS Date), 346335.0000, CAST(N'17:41:28' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221200002', N'KH0004', N'NV12093', CAST(N'2022-12-07' AS Date), 346335.0000, CAST(N'20:09:07' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221200003', N'KH0004', N'NV12093', CAST(N'2022-12-07' AS Date), 165000.0000, CAST(N'21:24:30' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221200004', N'KH0010', N'NV12093', CAST(N'2022-12-07' AS Date), 297000.0000, CAST(N'22:06:29' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221200005', N'KH0001', N'NV0001', CAST(N'2022-12-10' AS Date), 165000.0000, CAST(N'20:49:34' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221200006', N'KH0004', N'NV12093', CAST(N'2022-12-10' AS Date), 132000.0000, CAST(N'20:51:08' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221200007', N'KH0004', N'NV12093', CAST(N'2022-12-11' AS Date), 148500.0000, CAST(N'14:49:44' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221200008', N'KH0001', N'NV12093', CAST(N'2022-12-11' AS Date), 165000.0000, CAST(N'14:50:37' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221200009', N'KH0004', N'NV0001', CAST(N'2022-12-11' AS Date), 165000.0000, CAST(N'15:06:27' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221200010', N'KH0004', N'NV12093', CAST(N'2022-12-11' AS Date), 330000.0000, CAST(N'15:40:42' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221200011', N'KH0011', N'NV12093', CAST(N'2022-12-11' AS Date), 132000.0000, CAST(N'15:42:02' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221200012', N'KH0004', N'NV12093', CAST(N'2022-12-11' AS Date), 330000.0000, CAST(N'15:53:48' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221200013', N'KH0004', N'NV12093', CAST(N'2022-12-11' AS Date), 165000.0000, CAST(N'16:17:27' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221200014', N'KH0004', N'NV12093', CAST(N'2022-12-11' AS Date), 429000.0000, CAST(N'16:40:34' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221200015', N'KH0004', N'NV12093', CAST(N'2022-12-11' AS Date), 231000.0000, CAST(N'16:54:06' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221200016', N'KH0004', N'NV12093', CAST(N'2022-12-11' AS Date), 99000.0000, CAST(N'17:07:12' AS Time), N'dtt')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GioLap], [TrangThai]) VALUES (N'HD221200017', N'KH0004', N'NV12093', CAST(N'2022-12-11' AS Date), 4950.0000, CAST(N'17:18:38' AS Time), N'dtt')
GO
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SoDienThoai], [TinhTrang]) VALUES (N'KH0001', N'Nguyễn Thúy Ngọc', CAST(N'2004-10-20' AS Date), N'Nữ', N'a', N'0372922742', N'in        ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SoDienThoai], [TinhTrang]) VALUES (N'KH0002', N'Nguyễn Thanh Tùng', CAST(N'2022-10-05' AS Date), N'Nam', N'a', N'0372922743', N'out       ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SoDienThoai], [TinhTrang]) VALUES (N'KH0003', N'Nguyễn Văn A', CAST(N'1999-10-14' AS Date), N'Nam', N'a', N'0398408939', N'in        ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SoDienThoai], [TinhTrang]) VALUES (N'KH0004', N'Lê Hoàng', CAST(N'1980-07-16' AS Date), N'Nam', N'a', N'0398408935', N'in        ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SoDienThoai], [TinhTrang]) VALUES (N'KH0005', N'Lê Thị Ý Nhi', CAST(N'2000-10-18' AS Date), N'Nữ', N'a', N'0333461289', N'in        ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SoDienThoai], [TinhTrang]) VALUES (N'KH0006', N'Nguyễn Thị Mỹ Tâm', CAST(N'1999-10-19' AS Date), N'Nữ', N'a', N'0398408937', N'in        ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SoDienThoai], [TinhTrang]) VALUES (N'KH0007', N'Lê Văn Việt', CAST(N'2000-10-09' AS Date), N'Nam', N'a', N'0333987654', N'in        ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SoDienThoai], [TinhTrang]) VALUES (N'KH0008', N'Lê Hoàng', CAST(N'2022-10-09' AS Date), N'Nam', N'a', N'0398765345', N'in        ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SoDienThoai], [TinhTrang]) VALUES (N'KH0009', N'Đặng Thị Thu Hà', CAST(N'2002-10-26' AS Date), N'Nữ', N'a', N'0333461299', N'in        ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SoDienThoai], [TinhTrang]) VALUES (N'KH0010', N'Lê Thanh Bình', CAST(N'2005-12-12' AS Date), N'Nam', N'a', N'0999888777', N'in        ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SoDienThoai], [TinhTrang]) VALUES (N'KH0011', N'Nguyễn Văn Thắng', CAST(N'2000-12-04' AS Date), N'Nam', N'a', N'0397653451', N'in        ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SoDienThoai], [TinhTrang]) VALUES (N'KH0012', N'Nguyễn Thùy Diễm', CAST(N'2000-12-13' AS Date), N'Nữ', N'a', N'0356789999', N'in        ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SoDienThoai], [TinhTrang]) VALUES (N'KH0013', N'Nguyễn Thanh Sang', CAST(N'2000-12-20' AS Date), N'Nam', N'a', N'0935674123', N'in        ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SoDienThoai], [TinhTrang]) VALUES (N'KH0014', N'Lê Thị Thủy', CAST(N'2002-12-08' AS Date), N'Nữ', N'a', N'0398568723', N'in        ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SoDienThoai], [TinhTrang]) VALUES (N'KH0015', N'Nguyễn Văn Toàn', CAST(N'1976-12-14' AS Date), N'Nam', N'a', N'0397658901', N'in        ')
GO
INSERT [dbo].[LoaiSanPham] ([MaLoaiSanPham], [TenLoaiSanPham]) VALUES (N'1', N'Giấy In')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSanPham], [TenLoaiSanPham]) VALUES (N'2', N'Balo')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSanPham], [TenLoaiSanPham]) VALUES (N'3', N'Bao Tập')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSanPham], [TenLoaiSanPham]) VALUES (N'4', N'Ghim Bấm')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSanPham], [TenLoaiSanPham]) VALUES (N'5', N'Vở')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSanPham], [TenLoaiSanPham]) VALUES (N'6', N'Dụng cụ học tập')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSanPham], [TenLoaiSanPham]) VALUES (N'7', N'Dụng cụ văn phòng')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSanPham], [TenLoaiSanPham]) VALUES (N'8', N'Dụng cụ vẽ')
GO
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SoDienThoai], [Email]) VALUES (N'11', N'Fast Focus', N'Ho Chi Minh', N'098674322', N'fastfocus7796@gmail.com')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SoDienThoai], [Email]) VALUES (N'21', N'Jonah Sachs', N'Quang Nam', N'0702254148', N'dcomo197@gmail.com')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SoDienThoai], [Email]) VALUES (N'31', N'FPTShop', N'Thanh Hoa', N'0995201107', N'html1234@gmail.com')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SoDienThoai], [Email]) VALUES (N'41', N'ZTEShop', N'Hai Phong', N'0876422999', N'ZTEhuy@gmail.com')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SoDienThoai], [Email]) VALUES (N'51', N'TS.David', N'An Giang', N'0995871180', N'ABCdavid123@gmail.com')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SoDienThoai], [Email]) VALUES (N'61', N'Tom Sachs', N'Quang Ngai', N'0971945612', N'thanhtom123@gmail.com')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SoDienThoai], [Email]) VALUES (N'NCC0001', N'Bách Việt', N'Tp. Hồ Chí Minh', N'0999874892', N'bachviet@gmail.com')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SoDienThoai], [Email]) VALUES (N'NCC0002', N'HaNoiBooks', N'Hà Nội', N'0983456789', N'hanoibooks@gmail.com')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SoDienThoai], [Email]) VALUES (N'NCC0003', N'MinhLongBook', N'Tp. Hồ Chí Minh', N'0356901678', N'minhlongbook@gmail.com')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SoDienThoai], [Email]) VALUES (N'NCC0004', N'TanViet', N'Tp. Hồ Chí Minh', N'0945999999', N'tanviet@gmail.com')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SoDienThoai], [Email]) VALUES (N'NCC0005', N'Nhã Nam', N'Tp. Đà Nẵng', N'0988888888', N'nhanam@gmail.com')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SoDienThoai], [Email]) VALUES (N'NCC0006', N'alphabooks', N'Tp. Hồ Chí Minh', N'0977777777', N'alphabook@gmail.com')
GO
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [NgayVaoLam], [ChucVu], [DiaChi], [SoDienThoai], [Email], [TinhTrang]) VALUES (N'1011', N'Ph?m Hoàng Huy', CAST(N'2001-12-25' AS Date), N'Nam', CAST(N'2022-08-11' AS Date), N'Qu?n L?', N'H? Chí Minh', N'0947492444', N'phamhuyhoang123@gmail.com', N'out       ')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [NgayVaoLam], [ChucVu], [DiaChi], [SoDienThoai], [Email], [TinhTrang]) VALUES (N'1012', N'Ph?m Văn Toàn', CAST(N'2001-01-02' AS Date), N'Nam', CAST(N'2022-09-15' AS Date), N'Nhân Viên', N'Qu?ng Nam', N'0564732016', N'PVT3255@gmail.com', N'out       ')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [NgayVaoLam], [ChucVu], [DiaChi], [SoDienThoai], [Email], [TinhTrang]) VALUES (N'1013', N'Nguyễn Thanh Sang', CAST(N'2002-06-10' AS Date), N'Nam', CAST(N'2022-10-01' AS Date), N'Nhân Viên', N'Hà N?i ', N'0705396666', N'nguyenthanhsang@gmail.com', N'out       ')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [NgayVaoLam], [ChucVu], [DiaChi], [SoDienThoai], [Email], [TinhTrang]) VALUES (N'1014', N'Ph?m Thanh Tâm', CAST(N'2002-03-02' AS Date), N'N?', CAST(N'2022-09-20' AS Date), N'Nhân Viên', N'Thanh Hóa', N'0876301301', N'thanhtam2102@gmail.com', N'out       ')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [NgayVaoLam], [ChucVu], [DiaChi], [SoDienThoai], [Email], [TinhTrang]) VALUES (N'1015', N'Nguy?n Đ?c V?', CAST(N'2002-07-05' AS Date), N'Nam', CAST(N'2022-09-01' AS Date), N'Qu?n L?', N'Thái B?nh', N'0869287774', N'ducvi2312@gmail.com', N'out       ')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [NgayVaoLam], [ChucVu], [DiaChi], [SoDienThoai], [Email], [TinhTrang]) VALUES (N'NV0001', N'Nguyễn Thanh Tùng', CAST(N'1999-10-04' AS Date), N'Nam', CAST(N'2022-10-17' AS Date), N'Nhân viên', N'Quận Gò Vấp - TPHCM', N'0398467034', N'abc123@gmail.com', N'in        ')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [NgayVaoLam], [ChucVu], [DiaChi], [SoDienThoai], [Email], [TinhTrang]) VALUES (N'NV12093', N'Nguyễn Văn A', CAST(N'2002-06-07' AS Date), N'Nam', CAST(N'2022-09-09' AS Date), N'Quản lý', N'Dak Doa - Gia Lai', N'0999990322', N'thanhsangglp06@gmail.com', N'in        ')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [NgayVaoLam], [ChucVu], [DiaChi], [SoDienThoai], [Email], [TinhTrang]) VALUES (N'NV13289', N'Nguyễn Thị T', CAST(N'2000-02-03' AS Date), N'Nữ', CAST(N'2021-10-09' AS Date), N'Nhân Viên', N'Đà Nẵng', N'0982932435', N'sghjdfjh2@gmail.com', N'in        ')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [NgayVaoLam], [ChucVu], [DiaChi], [SoDienThoai], [Email], [TinhTrang]) VALUES (N'NV13290', N'Nguyễn Thị Nhung', CAST(N'2002-10-08' AS Date), N'Nam', CAST(N'2022-10-10' AS Date), N'Nhân viên', N'Quận Bình Thạnh - TPHCM', N'0333461288', N'2abc4531@gmail.com', N'in        ')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [NgayVaoLam], [ChucVu], [DiaChi], [SoDienThoai], [Email], [TinhTrang]) VALUES (N'NV13291', N'Hạnh', CAST(N'2002-10-09' AS Date), N'Nữ', CAST(N'2022-10-11' AS Date), N'Quản lý', N'09 Nguyen Hue - Gia Lai', N'0333444555', N'myhanh@gmail.com', N'in        ')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [NgayVaoLam], [ChucVu], [DiaChi], [SoDienThoai], [Email], [TinhTrang]) VALUES (N'NV13292', N'Anh Tuấn', CAST(N'2002-10-09' AS Date), N'Nam', CAST(N'2022-10-03' AS Date), N'Nhân viên', N'09 Lê Văn Việt - Quận 9 - TpHCM', N'0333987123', N'anhtuan@gmail.com', N'in        ')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [NgayVaoLam], [ChucVu], [DiaChi], [SoDienThoai], [Email], [TinhTrang]) VALUES (N'NV13293', N'Nguyễn Văn A', CAST(N'2000-12-13' AS Date), N'Nam', CAST(N'2022-12-10' AS Date), N'Nhân viên', N'09 Nguyễn Huệ - Quận 1 - Tp. Hồ Chí Minh', N'0398761234', N'abc123@gmail.com', N'in        ')
GO
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB]) VALUES (N'111', N'Kim Đồng')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB]) VALUES (N'112', N'Thanh Niên')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB]) VALUES (N'113', N'Hồng Đức')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB]) VALUES (N'114', N'Lao Động')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB]) VALUES (N'115', N'Hội Nhà Văn')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB]) VALUES (N'116', N'Đông A')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB]) VALUES (N'117', N'Tư Pháp')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB]) VALUES (N'118', N'Hồng Đức')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB]) VALUES (N'119', N'Mỹ Thuật')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB]) VALUES (N'120', N'Tổng hợp thành phố Hồ Chí Minh')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB]) VALUES (N'121', N'Hà Nội')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB]) VALUES (N'122', N'Sân khấu')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB]) VALUES (N'123', N'Tôn giáo')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB]) VALUES (N'124', N'Bưu điện')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB]) VALUES (N'125', N'Nông nghiệp')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB]) VALUES (N'126', N'Y học')
GO
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'11101', N'Công th?c tuy?t m?t', N'111', 100000.0000, N'1', N'100', N'1', N'11', 2, N'sonnu m4 w1.png', N'20112', N'VNĐ', N'k')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'11102', N'B?n đ?t giá bao nhiêu', N'112', 300000.0000, N'2', N'200', N'2', N'21', 7, NULL, N'20113', N'VNĐ', N'k')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'11103', N'Ngư?i th?y đ?u tiên', N'113', 260000.0000, N'3', N'300', N'3', N'31', 8, NULL, N'20114', N'VNĐ', N'k')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'11104', N'Kinh doanh nh? thu l?i l?n', N'114', 170000.0000, N'4', N'400', N'4', N'41', 5, NULL, N'20115', N'VNĐ', N'k')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'11105', N'Đ?c v? b?t k? ai', N'115', 400000.0000, N'5', N'500', N'5', N'51', 3, NULL, N'20116', N'VNĐ', N'k')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'11106', N'Đ?c Nhân Tâm', N'116', 570000.0000, N'6', N'600', N'6', N'61', 9, NULL, N'20117', N'VNĐ', N'k')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP001', N'Chiến Lược Kinh Doanh', N'111', 70000.0000, N'1', NULL, NULL, N'11', 1, N'abc.png', N'20112', N'Quyển', N'k')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2390', N'Thao Túng Tâm Lý', N'111', 100000.0000, N'1', NULL, NULL, N'61', 21, N'SP2390.jpg', N'20112', N'Quyển', N'c')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2391', N'Lập Trình PyThon Căn Bản', N'111', 80000.0000, N'1', NULL, NULL, N'11', 15, N'SP2391.jpg', N'20112', N'Quyển', N'c')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2392', N'Tiểu sử Ibrahimovic', N'111', 100000.0000, N'1', NULL, NULL, N'11', 12, N'SP2392.jpg', N'20112', N'Quyển', N'c')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2393', N'Kungfu Panda', N'111', 50000.0000, N'1', NULL, NULL, N'11', 9, N'SP2393.png', N'20112', N'Quyển', N'k')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2394', N'Conan Thám Tử Lừng Danh', N'111', 90000.0000, N'1', NULL, NULL, N'11', 4, N'SP2394.jpg', N'20112', N'Quyển', N'k')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2395', N'Toán 12', N'114', 20000.0000, N'1', NULL, NULL, N'41', 82, N'SP2395.jpg', N'20115', N'Quyển', N'c')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2396', N'Văn 12', N'115', 20000.0000, N'1', NULL, NULL, N'51', 93, N'SP2396.jpg', N'20115', N'Quyển', N'c')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2397', N'Quản Lý thời Gian', N'116', 209900.0000, N'2', NULL, NULL, N'31', 4, N'SP2397.jpg', N'20117', N'Quyển', N'c')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2398', N'Chiến Lược Maketing', N'113', 10000.0000, N'5', NULL, NULL, N'21', 10, N'SP2398.png', N'20115', N'Quyển', N'c')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2399', N'Lập Trình Java Căn Bản', N'116', 90900.0000, N'3', NULL, NULL, N'61', 1, N'SP2399.png', N'20117', N'Quyển', N'c')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2400', N'Mắt Biếc', N'115', 70000.0000, N'5', NULL, NULL, N'51', 2, N'SP2400.jpg', N'20116', N'Quyển', N'c')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2401', N'Tôi thấy hoa vàng trên cỏ xanh', N'111', 100000.0000, N'1', NULL, NULL, N'11', 48, N'SP2401.jpg', N'20112', N'Quyển', N'c')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2402', N'Đừng Lựa Chọn An Nhàn Khi Còn Trẻ', N'111', 80000.0000, N'5', NULL, NULL, N'11', 50, N'SP2402.jpg', N'20112', N'Quyển', N'c')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2403', N'Đắc Nhân Tâm', N'112', 100000.0000, N'5', NULL, NULL, N'11', 46, N'SP2403.jpg', N'20112', N'Quyển', N'c')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2404', N'Văn 11', N'111', 3000.0000, N'1', NULL, NULL, N'11', 500, N'not_found.jpg', N'20112', N'Quyển', N'k')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2405', N'Văn 11', N'111', 50500.0000, N'1', NULL, NULL, N'11', 10, N'not_found.jpg', N'20112', N'Quyển', N'k')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2406', N'Hiểu về trái tim', N'120', 90000.0000, N'14', NULL, NULL, N'11', 99, N'SP2406.jpg', N'1', N'Quyển', N'c')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2407', N'Hạnh phúc đến từ sự biến mất', N'120', 100000.0000, N'14', NULL, NULL, N'11', 100, N'SP2407.jpg', N'2', N'Quyển', N'c')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2408', N'Thay đổi cuộc sóng với nhân số học', N'120', 100000.0000, N'14', NULL, NULL, N'11', 100, N'SP2408.jpg', N'3', N'Quyển', N'c')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2409', N'Cẩm nang cấu trúc tiếng Anh', N'120', 70000.0000, N'11', NULL, NULL, N'NCC0001', 100, N'SP2409.jpg', N'4', N'Quyển', N'c')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2410', N'Sổ tay kiến thức toán trung học cơ sở', N'121', 20000.0000, N'7', NULL, NULL, N'NCC0006', 100, N'SP2410.jpg', N'5', N'Quyển', N'c')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2411', N'Người đàn bà trên cầu thang', N'120', 50000.0000, N'1', NULL, NULL, N'21', 100, N'SP2411.jpg', N'7', N'Quyển', N'k')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2412', N'Cây cam ngọt của tôi', N'120', 120000.0000, N'1', NULL, NULL, N'11', 100, N'SP2412.jpg', N'6', N'Quyển', N'k')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2413', N'Hiểu về trái tim 2', N'120', 120000.0000, N'14', NULL, NULL, N'NCC0006', 100, N'SP2413.jpg', N'1', N'Quyển', N'k')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2414', N'Người đàn bà trên cầu thang', N'120', 50000.0000, N'1', NULL, NULL, N'11', 100, N'SP2414.jpg', N'7', N'Quyển', N'k')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2415', N'Tấm mạng hoa', N'120', 100000.0000, N'1', NULL, NULL, N'11', 100, N'SP2415.jpg', N'8', N'Quyển', N'k')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2416', N'Cây cam ngọt của tôi', N'120', 120000.0000, N'1', NULL, NULL, N'11', 10, N'SP2416.jpg', N'6', N'Quyển', N'k')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2417', N'Người đàn bà trên cầu thang', N'120', 50000.0000, N'1', NULL, NULL, N'11', 100, N'SP2417.jpg', N'7', N'Quyển', N'k')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2418', N'Tấm mạng hoa', N'120', 100000.0000, N'1', NULL, NULL, N'11', 100, N'SP2418.jpg', N'8', N'Quyển', N'k')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2419', N'Cây cam ngọt của tôi', N'120', 100000.0000, N'1', NULL, NULL, N'NCC0001', 10, N'SP2419.jpg', N'6', N'Quyển', N'k')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2420', N'Người đàn bà trên cầu thang', N'120', 50000.0000, N'1', NULL, NULL, N'11', 100, N'SP2420.jpg', N'7', N'Quyển', N'k')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2421', N'Tấm mạng hoa', N'120', 100000.0000, N'1', NULL, NULL, N'11', 100, N'SP2421.jpg', N'8', N'Quyển', N'k')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2422', N'Cây cam ngọt của tôi', N'120', 110000.0000, N'1', NULL, NULL, N'11', 10, N'SP2422.jpg', N'6', N'Quyển', N'k')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2423', N'Người đàn bà trên cầu thang', N'120', 50000.0000, N'1', NULL, NULL, N'11', 100, N'SP2423.jpg', N'7', N'Quyển', N'k')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2424', N'Tấm mạng hoa', N'120', 100000.0000, N'1', NULL, NULL, N'11', 100, N'SP2424.jpg', N'8', N'Quyển', N'k')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2425', N'Cây cam ngọt của tôi', N'120', 110000.0000, N'1', NULL, NULL, N'11', 100, N'SP2425.jpg', N'6', N'Quyển', N'c')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2426', N'Người đàn bà trên cầu thang', N'120', 50000.0000, N'1', NULL, NULL, N'11', 100, N'SP2426.jpg', N'7', N'Quyển', N'c')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'SP2427', N'Tấm mạng hoa', N'120', 100000.0000, N'1', NULL, NULL, N'11', 100, N'SP2427.jpg', N'8', N'Quyển', N'c')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'VPP0001', N'Bút Chì 2B', NULL, 3000.0000, NULL, N'100', N'1', N'21', 199, N'VPP0001.png', NULL, N'Cây', N'c')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'VPP0002', N'Bút Bi', NULL, 3000.0000, NULL, N'400', N'5', N'61', 200, N'VPP0002.jpg', NULL, N'Cây', N'c')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'VPP0003', N'Thước kẻ 20cm', NULL, 5000.0000, NULL, N'100', N'4', N'31', 400, N'VPP0003.jpg', NULL, N'Cây', N'c')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'VPP0004', N'a', NULL, 13213.0000, NULL, N'100', N'1', N'21', 12, N'VPP0004.jpg', NULL, N'Cây', N'k')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'VPP0005', N'abc', NULL, 2000.0000, NULL, N'100', N'1', N'21', 39, N'not_found.jpg', NULL, N'Cây', N'c')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [MaNXB], [GiaNhap], [MaTheLoai], [MaThuongHieu], [MaLoaiSanPham], [MaNCC], [SoLuongTon], [Image], [MaTacGia], [DonViTinh], [TrangThai]) VALUES (N'VPP0006', N'Giấp in double A A5/70 gsm', NULL, 35000.0000, NULL, N'100', N'1', N'11', 1000, N'VPP0006.jpg', NULL, N'Tập', N'c')
GO
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia]) VALUES (N'1', N'Minh Niệm')
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia]) VALUES (N'2', N'Ajahn Brahm')
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia]) VALUES (N'20112', N'Nguyễn Nhật Ánh')
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia]) VALUES (N'20113', N'Jeffrey Archer')
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia]) VALUES (N'20114', N'Nguyễn Du')
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia]) VALUES (N'20115', N'Nam Cao')
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia]) VALUES (N'20116', N'Lưu Trọng Lư')
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia]) VALUES (N'20117', N'Dale Carnegie')
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia]) VALUES (N'20118', N'Hoài Thanh')
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia]) VALUES (N'20119', N'Tô Hoài')
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia]) VALUES (N'20120', N'Xuân Diệu')
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia]) VALUES (N'20121', N'Ernest Hemingway')
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia]) VALUES (N'20122', N'J.R.R.Tolkien')
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia]) VALUES (N'3', N'Lê Đỗ Quỳnh Hương')
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia]) VALUES (N'4', N'Trang Anh')
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia]) VALUES (N'5', N'Nguyễn Nam Anh')
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia]) VALUES (N'6', N'José Mauro de Vasconcelos')
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia]) VALUES (N'7', N'Bernhard Schlink')
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia]) VALUES (N'8', N'W Somerset Maugham')
GO
INSERT [dbo].[TaiKhoan] ([MaNhanVien], [TenDangNhap], [Password], [phanQuyen]) VALUES (N'1011', N'01011', N'admin', N'Quản Lý')
INSERT [dbo].[TaiKhoan] ([MaNhanVien], [TenDangNhap], [Password], [phanQuyen]) VALUES (N'1012', N'01012', N'cuongnp', N'Nhân Viên')
INSERT [dbo].[TaiKhoan] ([MaNhanVien], [TenDangNhap], [Password], [phanQuyen]) VALUES (N'1013', N'01013', N'nguyen2102', N'Nhân Viên')
INSERT [dbo].[TaiKhoan] ([MaNhanVien], [TenDangNhap], [Password], [phanQuyen]) VALUES (N'1014', N'01014', N'HUYhuy12', N'Nhân Viên')
INSERT [dbo].[TaiKhoan] ([MaNhanVien], [TenDangNhap], [Password], [phanQuyen]) VALUES (N'1015', N'01015', N'diemmy12', N'Nhân Viên')
INSERT [dbo].[TaiKhoan] ([MaNhanVien], [TenDangNhap], [Password], [phanQuyen]) VALUES (N'NV0001', N'NV0001', N'12345', N'Nhân Viên')
INSERT [dbo].[TaiKhoan] ([MaNhanVien], [TenDangNhap], [Password], [phanQuyen]) VALUES (N'NV12093', N'NV12093', N'1234567', N'Quản Lý')
INSERT [dbo].[TaiKhoan] ([MaNhanVien], [TenDangNhap], [Password], [phanQuyen]) VALUES (N'NV13289', N'NV13289', N'123456', N'Nhân Viên')
INSERT [dbo].[TaiKhoan] ([MaNhanVien], [TenDangNhap], [Password], [phanQuyen]) VALUES (N'NV13290', N'NV13290', N'12345', N'Nhân Viên')
INSERT [dbo].[TaiKhoan] ([MaNhanVien], [TenDangNhap], [Password], [phanQuyen]) VALUES (N'NV13291', N'NV13291', N'12345', N'Nhân Viên')
INSERT [dbo].[TaiKhoan] ([MaNhanVien], [TenDangNhap], [Password], [phanQuyen]) VALUES (N'NV13292', N'NV13292', N'12345', N'Nhân Viên')
INSERT [dbo].[TaiKhoan] ([MaNhanVien], [TenDangNhap], [Password], [phanQuyen]) VALUES (N'NV13293', N'NV13293', N'12345', N'Nhân Viên')
GO
INSERT [dbo].[TheLoai] ([MaTheLoai], [TenTheLoai]) VALUES (N'1', N'Truyện Ngắn')
INSERT [dbo].[TheLoai] ([MaTheLoai], [TenTheLoai]) VALUES (N'10', N'Kinh doanh')
INSERT [dbo].[TheLoai] ([MaTheLoai], [TenTheLoai]) VALUES (N'11', N'Ngoại ngữ')
INSERT [dbo].[TheLoai] ([MaTheLoai], [TenTheLoai]) VALUES (N'12', N'Sách thiếu nhi')
INSERT [dbo].[TheLoai] ([MaTheLoai], [TenTheLoai]) VALUES (N'13', N'Kinh tế')
INSERT [dbo].[TheLoai] ([MaTheLoai], [TenTheLoai]) VALUES (N'14', N'Tâm lý - Kỹ năng sống')
INSERT [dbo].[TheLoai] ([MaTheLoai], [TenTheLoai]) VALUES (N'15', N'Chính trị')
INSERT [dbo].[TheLoai] ([MaTheLoai], [TenTheLoai]) VALUES (N'2', N'Tiểu sử')
INSERT [dbo].[TheLoai] ([MaTheLoai], [TenTheLoai]) VALUES (N'3', N'Dạy nấu ăn')
INSERT [dbo].[TheLoai] ([MaTheLoai], [TenTheLoai]) VALUES (N'4', N'Bài luận')
INSERT [dbo].[TheLoai] ([MaTheLoai], [TenTheLoai]) VALUES (N'5', N'Hồi kí')
INSERT [dbo].[TheLoai] ([MaTheLoai], [TenTheLoai]) VALUES (N'6', N'Lịch sử')
INSERT [dbo].[TheLoai] ([MaTheLoai], [TenTheLoai]) VALUES (N'7', N'Sách tham khảo')
INSERT [dbo].[TheLoai] ([MaTheLoai], [TenTheLoai]) VALUES (N'8', N'Sách giáo khoa')
INSERT [dbo].[TheLoai] ([MaTheLoai], [TenTheLoai]) VALUES (N'9', N'Tiểu thuyết')
GO
INSERT [dbo].[ThuongHieu] ([MaThuongHieu], [TenThuongHieu]) VALUES (N'100', N'Tom')
INSERT [dbo].[ThuongHieu] ([MaThuongHieu], [TenThuongHieu]) VALUES (N'200', N'Jonah Sachs')
INSERT [dbo].[ThuongHieu] ([MaThuongHieu], [TenThuongHieu]) VALUES (N'300', N'Alphabooks')
INSERT [dbo].[ThuongHieu] ([MaThuongHieu], [TenThuongHieu]) VALUES (N'400', N'MCBooks')
INSERT [dbo].[ThuongHieu] ([MaThuongHieu], [TenThuongHieu]) VALUES (N'500', N'ThaiHaBooks')
INSERT [dbo].[ThuongHieu] ([MaThuongHieu], [TenThuongHieu]) VALUES (N'600', N'Megabook')
GO
ALTER TABLE [dbo].[HoaDon] ADD  CONSTRAINT [DF_HoaDon_NgayLapHoaDon]  DEFAULT (getdate()) FOR [NgayLapHoaDon]
GO
ALTER TABLE [dbo].[SanPham] ADD  CONSTRAINT [DF_SanPham_image]  DEFAULT ('') FOR [Image]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([MaHoaDon])
REFERENCES [dbo].[HoaDon] ([MaHoaDon])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_SanPham] FOREIGN KEY([MaSanPham])
REFERENCES [dbo].[SanPham] ([MaSanPham])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_SanPham]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([MaKhachHang])
REFERENCES [dbo].[KhachHang] ([MaKhachHang])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_LoaiSanPham] FOREIGN KEY([MaLoaiSanPham])
REFERENCES [dbo].[LoaiSanPham] ([MaLoaiSanPham])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_LoaiSanPham]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_NhaCungCap] FOREIGN KEY([MaNCC])
REFERENCES [dbo].[NhaCungCap] ([MaNCC])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_NhaCungCap]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_NhaXuatBan] FOREIGN KEY([MaNXB])
REFERENCES [dbo].[NhaXuatBan] ([MaNXB])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_NhaXuatBan]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_TacGia] FOREIGN KEY([MaTacGia])
REFERENCES [dbo].[TacGia] ([MaTacGia])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_TacGia]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_TheLoai] FOREIGN KEY([MaTheLoai])
REFERENCES [dbo].[TheLoai] ([MaTheLoai])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_TheLoai]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_ThuongHieu] FOREIGN KEY([MaThuongHieu])
REFERENCES [dbo].[ThuongHieu] ([MaThuongHieu])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_ThuongHieu]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_NhanVien] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_NhanVien]
GO
