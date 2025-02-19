USE [BookManagement]
GO
/****** Object:  Table [dbo].[books]    Script Date: 17-Dec-24 10:20:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[books](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](100) NOT NULL,
	[author] [nvarchar](100) NOT NULL,
	[genre_id] [int] NOT NULL,
	[quantity] [int] NULL,
	[created_at] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[genres]    Script Date: 17-Dec-24 10:20:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[genres](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[genre_name] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[transactions]    Script Date: 17-Dec-24 10:20:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[transactions](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NOT NULL,
	[book_id] [int] NOT NULL,
	[transaction_type] [nvarchar](10) NOT NULL,
	[transaction_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 17-Dec-24 10:20:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](255) NOT NULL,
	[role] [nvarchar](20) NULL,
	[created_at] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[books] ON 

INSERT [dbo].[books] ([id], [title], [author], [genre_id], [quantity], [created_at]) VALUES (1, N'Những người khốn khổ', N'Victor Hugo', 1, 10, CAST(N'2024-12-17T10:16:51.657' AS DateTime))
INSERT [dbo].[books] ([id], [title], [author], [genre_id], [quantity], [created_at]) VALUES (2, N'Vũ trụ trong vỏ hạt dẻ', N'Stephen Hawking', 2, 5, CAST(N'2024-12-17T10:16:51.657' AS DateTime))
INSERT [dbo].[books] ([id], [title], [author], [genre_id], [quantity], [created_at]) VALUES (3, N'Dế Mèn phiêu lưu ký', N'Tô Hoài', 3, 8, CAST(N'2024-12-17T10:16:51.657' AS DateTime))
INSERT [dbo].[books] ([id], [title], [author], [genre_id], [quantity], [created_at]) VALUES (4, N'Cha giàu cha nghèo', N'Robert Kiyosaki', 4, 12, CAST(N'2024-12-17T10:16:51.657' AS DateTime))
SET IDENTITY_INSERT [dbo].[books] OFF
GO
SET IDENTITY_INSERT [dbo].[genres] ON 

INSERT [dbo].[genres] ([id], [genre_name]) VALUES (2, N'Khoa học')
INSERT [dbo].[genres] ([id], [genre_name]) VALUES (4, N'Kinh tế')
INSERT [dbo].[genres] ([id], [genre_name]) VALUES (3, N'Thiếu nhi')
INSERT [dbo].[genres] ([id], [genre_name]) VALUES (1, N'Văn học')
SET IDENTITY_INSERT [dbo].[genres] OFF
GO
SET IDENTITY_INSERT [dbo].[transactions] ON 

INSERT [dbo].[transactions] ([id], [user_id], [book_id], [transaction_type], [transaction_date]) VALUES (1, 2, 1, N'borrow', CAST(N'2024-12-17T10:17:01.377' AS DateTime))
INSERT [dbo].[transactions] ([id], [user_id], [book_id], [transaction_type], [transaction_date]) VALUES (2, 2, 2, N'borrow', CAST(N'2024-12-17T10:17:01.377' AS DateTime))
INSERT [dbo].[transactions] ([id], [user_id], [book_id], [transaction_type], [transaction_date]) VALUES (3, 1, 3, N'return', CAST(N'2024-12-17T10:17:01.377' AS DateTime))
SET IDENTITY_INSERT [dbo].[transactions] OFF
GO
SET IDENTITY_INSERT [dbo].[users] ON 

INSERT [dbo].[users] ([id], [username], [password], [role], [created_at]) VALUES (1, N'admin', N'admin123', N'admin', CAST(N'2024-12-17T10:16:56.347' AS DateTime))
INSERT [dbo].[users] ([id], [username], [password], [role], [created_at]) VALUES (2, N'user1', N'user123', N'user', CAST(N'2024-12-17T10:16:56.347' AS DateTime))
SET IDENTITY_INSERT [dbo].[users] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__genres__1E98D151812B9B0B]    Script Date: 17-Dec-24 10:20:06 ******/
ALTER TABLE [dbo].[genres] ADD UNIQUE NONCLUSTERED 
(
	[genre_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__users__F3DBC572C6965C33]    Script Date: 17-Dec-24 10:20:06 ******/
ALTER TABLE [dbo].[users] ADD UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[books] ADD  DEFAULT ((0)) FOR [quantity]
GO
ALTER TABLE [dbo].[books] ADD  DEFAULT (getdate()) FOR [created_at]
GO
ALTER TABLE [dbo].[transactions] ADD  DEFAULT (getdate()) FOR [transaction_date]
GO
ALTER TABLE [dbo].[users] ADD  DEFAULT ('user') FOR [role]
GO
ALTER TABLE [dbo].[users] ADD  DEFAULT (getdate()) FOR [created_at]
GO
ALTER TABLE [dbo].[books]  WITH CHECK ADD FOREIGN KEY([genre_id])
REFERENCES [dbo].[genres] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[transactions]  WITH CHECK ADD FOREIGN KEY([book_id])
REFERENCES [dbo].[books] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[transactions]  WITH CHECK ADD FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[transactions]  WITH CHECK ADD CHECK  (([transaction_type]='return' OR [transaction_type]='borrow'))
GO
ALTER TABLE [dbo].[users]  WITH CHECK ADD CHECK  (([role]='user' OR [role]='admin'))
GO
