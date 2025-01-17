USE [Dentist]
GO
SET IDENTITY_INSERT [dbo].[Province] ON 

INSERT [dbo].[Province] ([id], [name]) VALUES (1, N'Province 1')
INSERT [dbo].[Province] ([id], [name]) VALUES (2, N'Province 2')
SET IDENTITY_INSERT [dbo].[Province] OFF
GO
SET IDENTITY_INSERT [dbo].[District] ON 

INSERT [dbo].[District] ([id], [name], [province_id]) VALUES (1, N'District 1', 2)
INSERT [dbo].[District] ([id], [name], [province_id]) VALUES (2, N'District 2', 1)
INSERT [dbo].[District] ([id], [name], [province_id]) VALUES (3, N'District 3', 2)
SET IDENTITY_INSERT [dbo].[District] OFF
GO
SET IDENTITY_INSERT [dbo].[Role] ON 

INSERT [dbo].[Role] ([id], [name]) VALUES (1, N'ROLE_ADMIM')
INSERT [dbo].[Role] ([id], [name]) VALUES (2, N'ROLE_USER')
SET IDENTITY_INSERT [dbo].[Role] OFF
GO
SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([id], [date_of_birth], [email], [full_name], [gender], [password], [phone], [status], [district_id], [role_id]) VALUES (2, CAST(N'2001-09-09' AS Date), N'hiddenwory@gmail.com', N'Bao NQ', 1, N'$2y$10$waeMWiuc3JnPGvGrekv5.O.e89aJ54LjkZqcax/whJvSkJCFjUNwi', N'012345678', 1, 1, 1)
INSERT [dbo].[Account] ([id], [date_of_birth], [email], [full_name], [gender], [password], [phone], [status], [district_id], [role_id]) VALUES (3, CAST(N'2001-09-27' AS Date), N'@Email.hiidd', N'hhh', 2, N'$2y$10$.2BTX3YT1FpOne62vDSVJuWkBh4DNXKegak2X5.bySo5EAd.6ccvW', N'0987654321', 1, 1, 1)
INSERT [dbo].[Account] ([id], [date_of_birth], [email], [full_name], [gender], [password], [phone], [status], [district_id], [role_id]) VALUES (1003, CAST(N'2001-03-03' AS Date), N'hiddenwory@fpr.com', N'Bao', 1, N'$2a$12$Qo2rnP4JlbyszBuHYhmt5.gG.d7YBcYwcrbXehimfs4upXn5Be7be', N'0123456789', 1, 1, 2)
SET IDENTITY_INSERT [dbo].[Account] OFF
GO
