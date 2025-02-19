USE [QLBook]
GO
/****** Object:  Table [dbo].[Books]    Script Date: 17-Dec-24 15:39:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Books](
	[BookId] [int] NOT NULL,
	[Title] [nvarchar](50) NOT NULL,
	[Price] [float] NOT NULL,
 CONSTRAINT [PK_Books] PRIMARY KEY CLUSTERED 
(
	[BookId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Books] ([BookId], [Title], [Price]) VALUES (1, N'Lập trình Java', 25.5)
INSERT [dbo].[Books] ([BookId], [Title], [Price]) VALUES (2, N'Cấu trúc dữ liệu', 30)
INSERT [dbo].[Books] ([BookId], [Title], [Price]) VALUES (3, N'Phát triển Web', 20.5)
INSERT [dbo].[Books] ([BookId], [Title], [Price]) VALUES (4, N'Hệ thống cơ sở dữ liệu', 27)
INSERT [dbo].[Books] ([BookId], [Title], [Price]) VALUES (5, N'Thuật toán', 35)
GO
