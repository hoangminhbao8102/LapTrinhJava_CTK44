USE [QuanLySanPham]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 17-Dec-24 15:56:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSP] [nvarchar](10) NOT NULL,
	[TenSP] [nvarchar](100) NULL,
	[DVT] [nvarchar](50) NULL,
	[DonGia] [int] NULL,
	[NhaCungCap] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [DVT], [DonGia], [NhaCungCap]) VALUES (N'SP01', N'Dầu gội đầu Head & Shoulder', N'Chai', 34000, N'Unilevers')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [DVT], [DonGia], [NhaCungCap]) VALUES (N'SP02', N'Xà bông Omo', N'Thùng', 124000, N'Unilevers')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [DVT], [DonGia], [NhaCungCap]) VALUES (N'SP03', N'Dầu ăn Tường An 5 lít', N'Chai', 100000, N'Tường An')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [DVT], [DonGia], [NhaCungCap]) VALUES (N'SP04', N'Mì ăn liền Hảo Hảo', N'Thùng', 75000, N'AceCook')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [DVT], [DonGia], [NhaCungCap]) VALUES (N'SP05', N'Đường tinh luyện', N'Kg', 14000, N'Đuong Biên Hòa')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [DVT], [DonGia], [NhaCungCap]) VALUES (N'SP06', N'Sữa Ông Thọ', N'Lon', 14000, N'VinaMilk')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [DVT], [DonGia], [NhaCungCap]) VALUES (N'SP07', N'Rượu Nho Nguyễn Cường', N'Chai', 130000, N'Cty Hương Nhiên')
GO
