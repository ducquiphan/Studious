CREATE DATABASE Studious
GO
USE Studious
GO

-- DROP DATABASE Studious

-- CREATE TABLES
CREATE TABLE TAIKHOAN (
	TenTaiKhoan	VARCHAR(50) NOT NULL,
	MatKhau	VARCHAR(30),
	VaiTro INT,
	TrangThai BIT DEFAULT 1
)
GO
CREATE TABLE GIAOVIEN (
	MaGV VARCHAR(10) NOT NULL,
	HoVaTen	NVARCHAR(50),
	GioiTinh BIT,
	NgaySinh DATE,
	ChuyenMon NVARCHAR(30),
	Email VARCHAR(50),
	SoDT VARCHAR(10),
	PathIMG VARCHAR(30),
	MaTK VARCHAR(50)
)
GO
CREATE TABLE HOCSINH (
	MaHS VARCHAR(10) NOT NULL,
	HoVaTen	NVARCHAR(50),
	GioiTinh BIT,
	NgaySinh DATE,
	Email VARCHAR(50),
	SoDT VARCHAR(10),
	Khoi INT,
	PathIMG	VARCHAR(30),
	MaTK VARCHAR(50)
)
GO
CREATE TABLE BAIHOC (
	MaBH INT IDENTITY NOT NULL,
	TenBH NVARCHAR(100),
	MonHoc NVARCHAR(30),
	Khoi INT,
	NgayTao	DATE DEFAULT GETDATE(),
	MaGV VARCHAR(10)
)
GO
CREATE TABLE BAITHI (
	MaBThi VARCHAR(10) NOT NULL,
	TieuDe NVARCHAR(100),
	MonHoc NVARCHAR(30),
	Khoi INT,
	NgayTao	DATE DEFAULT GETDATE(),
	MaGV VARCHAR(10),
	DanhSachMaCHBT VARCHAR(1000)
)
GO
CREATE TABLE TAILIEUONTAP (
	MaTL INT IDENTITY NOT NULL,
	TieuDe NVARCHAR(100),
	URLTaiLieu NVARCHAR(100),
	NgayTao	DATE DEFAULT GETDATE(),
	MaGV VARCHAR(10),
	MaBH INT
)
GO
CREATE TABLE CAUHOI (
	MaCH INT IDENTITY NOT NULL,
	De NVARCHAR(150),
	DapAn1 NVARCHAR(30),
	DapAn2 NVARCHAR(30),
	DapAn3 NVARCHAR(30),
	DapAn4 NVARCHAR(30),
	DapAnDung NVARCHAR(30),
	MaBH INT,
	MaGV VARCHAR(10)
)
GO
CREATE TABLE CAUHOIBAITHI (
	MaCHBT INT IDENTITY NOT NULL,
	MaCH INT,
	MaBThi VARCHAR(10)
)
GO
CREATE TABLE BAOCAOBAITHI (
	MaBCBT INT IDENTITY NOT NULL,
	MaBThi VARCHAR(10),
	MaHS VARCHAR(10),
	Diem FLOAT,
	ThoiGianHoanThanh INT,
	SLDung INT,
	NgayLamBai DATE DEFAULT GETDATE()
)
GO
CREATE TABLE HOIDAP (
	MaHD INT IDENTITY NOT NULL,
	NoiDung NVARCHAR(2500),
	NgayTao	DATE DEFAULT GETDATE(),
	NguoiTao VARCHAR(50),
	MaCH INT
)
GO
CREATE TABLE KETQUA (
	MaKQ INT IDENTITY NOT NULL, 
	LanThi INT,
	MaHS VARCHAR(10),
	MaBThi VARCHAR(10),
	MaCau INT,
	DanAnChon NVARCHAR(30),
	DanAnDung NVARCHAR(30),
	NgayThi DATE DEFAULT GETDATE()
)



-------------------------------------------
GO
ALTER TABLE TAIKHOAN ADD CONSTRAINT PK_TAIKHOAN PRIMARY KEY (TenTaiKhoan)
ALTER TABLE GIAOVIEN ADD CONSTRAINT PK_GIAOVIEN PRIMARY KEY (MaGV)
ALTER TABLE HOCSINH ADD CONSTRAINT PK_HOCSINH PRIMARY KEY (MaHS)
ALTER TABLE BAIHOC ADD CONSTRAINT PK_BAIHOC PRIMARY KEY (MaBH)
ALTER TABLE BAITHI ADD CONSTRAINT PK_BAITHI PRIMARY KEY (MaBThi)
ALTER TABLE TAILIEUONTAP ADD CONSTRAINT PK_TAILIEUONTAP PRIMARY KEY (MaTL)
ALTER TABLE CAUHOI ADD CONSTRAINT PK_CAUHOI PRIMARY KEY (MaCH)
ALTER TABLE CAUHOIBAITHI ADD CONSTRAINT PK_CAUHOIBAITHI PRIMARY KEY (MaCHBT)
ALTER TABLE BAOCAOBAITHI ADD CONSTRAINT PK_BAOCAOBAITHI PRIMARY KEY (MaBCBT)
ALTER TABLE HOIDAP ADD CONSTRAINT PK_HOIDAP PRIMARY KEY (MaHD)
ALTER TABLE KETQUA ADD CONSTRAINT PK_KETQUA PRIMARY KEY (MaKQ)


-------------------------------------------
GO
ALTER TABLE GIAOVIEN ADD CONSTRAINT FK_GIAOVIEN_TAIKHOAN FOREIGN KEY (MaTK) REFERENCES TAIKHOAN(TenTaiKhoan)
ALTER TABLE HOCSINH ADD CONSTRAINT FK_HOCSINH_TAIKHOAN FOREIGN KEY (MaTK) REFERENCES TAIKHOAN(TenTaiKhoan)
ALTER TABLE BAIHOC ADD CONSTRAINT FK_BAIHOC_GIAOVIEN FOREIGN KEY (MaGV) REFERENCES GIAOVIEN(MaGV) ON DELETE NO ACTION ON UPDATE CASCADE
ALTER TABLE BAITHI ADD CONSTRAINT FK_BAITHI_GIAOVIEN FOREIGN KEY (MaGV) REFERENCES GIAOVIEN(MaGV)
ALTER TABLE TAILIEUONTAP ADD CONSTRAINT FK_TAILIEUONTAP_GIAOVIEN FOREIGN KEY (MaGV) REFERENCES GIAOVIEN(MaGV)
ALTER TABLE TAILIEUONTAP ADD CONSTRAINT FK_TAILIEUONTAP_BAIHOC FOREIGN KEY (MaBH) REFERENCES BAIHOC(MaBH) ON DELETE NO ACTION ON UPDATE CASCADE
ALTER TABLE CAUHOI ADD CONSTRAINT FK_CAUHOI_GIAOVIEN FOREIGN KEY (MaGV) REFERENCES GIAOVIEN(MaGV)
ALTER TABLE CAUHOI ADD CONSTRAINT FK_CAUHOI_BAIHOC FOREIGN KEY (MaBH) REFERENCES BAIHOC(MaBH) ON DELETE NO ACTION ON UPDATE CASCADE
ALTER TABLE CAUHOIBAITHI ADD CONSTRAINT FK_CAUHOIBAITHI_BAITHI FOREIGN KEY (MaBThi) REFERENCES BAITHI(MaBThi)
ALTER TABLE CAUHOIBAITHI ADD CONSTRAINT FK_CAUHOIBAITHI_CAUHOI FOREIGN KEY (MaCH) REFERENCES CAUHOI(MaCH)
ALTER TABLE BAOCAOBAITHI ADD CONSTRAINT FK_BAOCAOBAITHI_BAITHI FOREIGN KEY (MaBThi) REFERENCES BAITHI(MaBThi)
ALTER TABLE BAOCAOBAITHI ADD CONSTRAINT FK_BAOCAOBAITHI_HOCSINH FOREIGN KEY (MaHS) REFERENCES HOCSINH(MaHS)
ALTER TABLE HOIDAP ADD CONSTRAINT FK_HOIDAP_TAIKHOAN FOREIGN KEY (NguoiTao) REFERENCES TAIKHOAN(TenTaiKhoan)
ALTER TABLE HOIDAP ADD CONSTRAINT FK_HOIDAP_CAUHOI FOREIGN KEY (MaCH) REFERENCES CAUHOI(MaCH)
ALTER TABLE KETQUA ADD CONSTRAINT FK_KETQUA_HOCSINH FOREIGN KEY (MaHS) REFERENCES HOCSINH(MaHS)
ALTER TABLE KETQUA ADD CONSTRAINT FK_KETQUA_BAITHI FOREIGN KEY (MaBThi) REFERENCES BAITHI(MaBThi)



-------------------------------------------
-- Thống kê điểm cá nhân học sinh: số thứ tự, tên bài thi, điểm, lần thi, thời gian làm bài.
GO
CREATE PROC sp_ThongKeDiemCaNhanHS (@MaHS VARCHAR(10))
AS BEGIN
	SELECT ROW_NUMBER() OVER (ORDER BY MaBThi) as 'STT', MaBThi, Diem, ROW_NUMBER() OVER (PARTITION BY MaBThi ORDER BY MaBThi) as 'LanThi', ThoiGianHoanThanh
	FROM BAOCAOBAITHI
	WHERE MaHS = @MaHS
	GROUP BY MaBCBT, MaBThi, Diem, ThoiGianHoanThanh
END

-- Thống kê câu hỏi: số thứ tự, tên môn học, số lượng câu hỏi/số thứ tự, tên giáo viên, số câu hỏi.
GO
CREATE PROC sp_ThongKeCauHoi_MonHoc (@TenMonHoc NVARCHAR(30))
AS BEGIN
	IF @TenMonHoc IS NULL
	BEGIN
		SELECT ROW_NUMBER() OVER (ORDER BY MonHoc), MonHoc, COUNT(MaCH)
		FROM CAUHOI JOIN BAIHOC ON CAUHOI.MaBH = BAIHOC.MaBH
		GROUP BY BAIHOC.MaBH, MonHoc
	END

	ELSE
	BEGIN
		SELECT ROW_NUMBER() OVER (ORDER BY MonHoc), MonHoc, COUNT(MaCH)
		FROM CAUHOI JOIN BAIHOC ON CAUHOI.MaBH = BAIHOC.MaBH
		WHERE MonHoc = @TenMonHoc
		GROUP BY BAIHOC.MaBH, MonHoc
	END
END


GO
CREATE PROC sp_ThongKeCauHoi_GiaoVien (@HoTenGV NVARCHAR(50))
AS BEGIN
	IF @HoTenGV IS NULL
	BEGIN
		SELECT ROW_NUMBER() OVER (ORDER BY HoVaTen), HoVaTen, COUNT(MaCH)
		FROM CAUHOI JOIN GIAOVIEN ON CAUHOI.MaGV = GIAOVIEN.MaGV
		GROUP BY GIAOVIEN.MaGV, HoVaTen
	END

	ELSE
	BEGIN
		SELECT ROW_NUMBER() OVER (ORDER BY HoVaTen), HoVaTen, COUNT(MaCH)
		FROM CAUHOI JOIN GIAOVIEN ON CAUHOI.MaGV = GIAOVIEN.MaGV
		WHERE HoVaTen = @HoTenGV
		GROUP BY GIAOVIEN.MaGV, HoVaTen
	END
END

-- Thống kê tài liệu: số thứ tự, tên môn học, số lượng tài liệu/số thứ tự, tên giáo viên, số lượng tài liệu.
GO
CREATE PROC sp_ThongKeTaiLieu_MonHoc (@TenMonHoc NVARCHAR(30))
AS BEGIN
	IF @TenMonHoc IS NULL
	BEGIN
		SELECT ROW_NUMBER() OVER (ORDER BY MonHoc), MonHoc, COUNT(MaTL)
		FROM TAILIEUONTAP JOIN BAIHOC ON TAILIEUONTAP.MaBH = BAIHOC.MaBH
		GROUP BY BAIHOC.MaBH, MonHoc
	END

	ELSE
	BEGIN
		SELECT ROW_NUMBER() OVER (ORDER BY MonHoc), MonHoc, COUNT(MaTL)
		FROM TAILIEUONTAP JOIN BAIHOC ON TAILIEUONTAP.MaBH = BAIHOC.MaBH
		WHERE MonHoc = @TenMonHoc
		GROUP BY BAIHOC.MaBH, MonHoc
	END
END


GO
CREATE PROC sp_ThongKeTaiLieu_GiaoVien (@HoTenGV NVARCHAR(50))
AS BEGIN
	IF @HoTenGV IS NULL
	BEGIN
		SELECT ROW_NUMBER() OVER (ORDER BY HoVaTen), HoVaTen, COUNT(MaTL)
		FROM TAILIEUONTAP JOIN GIAOVIEN ON TAILIEUONTAP.MaGV = GIAOVIEN.MaGV
		GROUP BY GIAOVIEN.MaGV, HoVaTen
	END

	ELSE
	BEGIN
		SELECT ROW_NUMBER() OVER (ORDER BY HoVaTen), HoVaTen, COUNT(MaTL)
		FROM TAILIEUONTAP JOIN GIAOVIEN ON TAILIEUONTAP.MaGV = GIAOVIEN.MaGV
		WHERE HoVaTen = @HoTenGV
		GROUP BY GIAOVIEN.MaGV, HoVaTen
	END
END

-- Thống kê điểm toàn bộ học sinh: Mã học sinh, tên học sinh, lớp, mã bài thi, tên bài thi, điểm, ngày làm.
GO
CREATE PROC sp_ThongKeDiemToanBoHS (@TenBaiThi NVARCHAR(100))
AS BEGIN
	IF @TenBaiThi IS NULL
	BEGIN
		SELECT BAOCAOBAITHI.MaHS, HoVaTen, HOCSINH.Khoi, BAOCAOBAITHI.MaBThi, TieuDe, Diem, NgayLamBai
		FROM BAITHI JOIN BAOCAOBAITHI ON BAITHI.MaBThi = BAOCAOBAITHI.MaBThi
		JOIN HOCSINH ON BAOCAOBAITHI.MaHS = HOCSINH.MaHS
		GROUP BY BAOCAOBAITHI.MaHS, HoVaTen, HOCSINH.Khoi, BAOCAOBAITHI.MaBThi, TieuDe, Diem, NgayLamBai
	END

	ELSE
	BEGIN
		SELECT BAOCAOBAITHI.MaHS, HoVaTen, HOCSINH.Khoi, BAOCAOBAITHI.MaBThi, TieuDe, Diem, NgayLamBai
		FROM BAITHI JOIN BAOCAOBAITHI ON BAITHI.MaBThi = BAOCAOBAITHI.MaBThi
		JOIN HOCSINH ON BAOCAOBAITHI.MaHS = HOCSINH.MaHS
		WHERE TieuDe = @TenBaiThi
		GROUP BY BAOCAOBAITHI.MaHS, HoVaTen, HOCSINH.Khoi, BAOCAOBAITHI.MaBThi, TieuDe, Diem, NgayLamBai
	END
END


-- Thống kê điểm trung bình: Số thứ tự, mã bài thi, tên bài thi, điểm trung hình tổng, số lần thi.
GO
CREATE PROC sp_ThongKeDiemTB (@TenBaiThi NVARCHAR(100))
AS BEGIN
	IF @TenBaiThi IS NULL
	BEGIN
		SELECT ROW_NUMBER() OVER (ORDER BY BAOCAOBAITHI.MaBThi), BAOCAOBAITHI.MaBThi, TieuDe, AVG(Diem), COUNT(BAOCAOBAITHI.MaBThi)
		FROM BAOCAOBAITHI JOIN BAITHI ON BAOCAOBAITHI.MaBThi = BAITHI.MaBThi
		GROUP BY BAOCAOBAITHI.MaBThi, TieuDe
	END

	ELSE
	BEGIN
		SELECT ROW_NUMBER() OVER (ORDER BY BAOCAOBAITHI.MaBThi), BAOCAOBAITHI.MaBThi, TieuDe, AVG(Diem), COUNT(BAOCAOBAITHI.MaBThi)
		FROM BAOCAOBAITHI JOIN BAITHI ON BAOCAOBAITHI.MaBThi = BAITHI.MaBThi
		WHERE TieuDe = @TenBaiThi
		GROUP BY BAOCAOBAITHI.MaBThi, TieuDe
	END
END


-- In danh sách môn
GO
CREATE PROC sp_DanhSachMonHoc
AS BEGIN
	SELECT MonHoc FROM BAIHOC GROUP BY MonHoc
END

-- In danh sách khối
GO
CREATE PROC sp_DanhSachBaiHocTheoMon (@MonHoc NVARCHAR(100))
AS BEGIN
	SELECT Khoi FROM BAIHOC WHERE MonHoc = @MonHoc GROUP BY Khoi
END
GO




-----------------------------------
GO
INSERT INTO TAIKHOAN(TenTaiKhoan, MatKhau, VaiTro, TrangThai) VALUES
('AD1', '123456', 1, 1),
('GV1', '123456', 2, 1),
('HS1', '123456', 3, 1),
('HS2', '123456', 3, 0)

GO
INSERT INTO GIAOVIEN(MaGV, HoVaTen, GioiTinh, NgaySinh, ChuyenMon, Email, SoDT, PathIMG, MaTK) VALUES 
('GV1', N'Trần Hoàng Danh', 1, '11/04/2003', N'Toán', 'danhth@gmail.com', '0971714478', 'image/imgGV', 'GV1')

GO
INSERT INTO HOCSINH(MaHS, HoVaTen, GioiTinh, NgaySinh, Email, SoDT, Khoi, PathIMG, MaTK) VALUES 
('HS1', N'Phan Quí Đức', 0, '06/23/2000', 'ducpq@gmail.com', '0964856254', 10, 'image/imgHS', 'HS1')

GO
INSERT INTO BAIHOC(TenBH, MonHoc, Khoi, MaGV) VALUES 
(N'TOÁN CỘNG TRỪ', N'Toán',10,'GV1'),
(N'TOÁN NHÂN CHIA', N'Toán',11,'GV1'),
(N'TOPIC 1', N'Anh văn',10,'GV1'),
(N'TOPIC 2', N'Anh văn',11,'GV1'),
(N'TOPIC 3', N'Anh văn',12,'GV1')

GO
INSERT INTO BAITHI(MaBThi, TieuDe, MonHoc, Khoi, MaGV, DanhSachMaCHBT) VALUES
('TOAN01', N'Đề thi kiểm tra cuối kỳ 1', N'Toán', 10, 'GV1', NULL)

GO
INSERT INTO TAILIEUONTAP(TieuDe, URLTaiLieu, MaGV, MaBH) VALUES
(N'Tài liệu ôn thi cuối kỳ 1 môn Toán khối 10', N'tailieu/tailieuonthi.txt', 'GV1', 1)

GO
INSERT INTO CAUHOI(De, DapAn1, DapAn2, DapAn3, DapAn4, DapAnDung, MaBH, MaGV) VALUES 
(N'1 + 1 = ?', N'1', N'3', N'0', N'2', N'd', 1,'GV1'),
(N'3 x 2 = ?', N'1', N'3', N'8', N'6', N'd', 2,'GV1'),
(N'5 + 7 = ?', N'10', N'12', N'14', N'16', N'b', 1,'GV1'),
(N'4 x 2 = ?', N'6', N'7', N'8', N'9', N'c', 2,'GV1'),
(N'3 x 1 = ?', N'3', N'1', N'0', N'2', N'a', 2,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1'),
(N'1 + 1 = ?', N'1', N'-1', N'0', N'2', N'd', 1,'GV1')

GO
INSERT INTO CAUHOIBAITHI(MaCH, MaBThi) VALUES
(1, 'TOAN01'),
(2, 'TOAN01'),
(3, 'TOAN01'),
(4, 'TOAN01'),
(5, 'TOAN01'),
(6, 'TOAN01'),
(7, 'TOAN01'),
(8, 'TOAN01'),
(9, 'TOAN01'),
(10, 'TOAN01'),
(11, 'TOAN01'),
(12, 'TOAN01'),
(13, 'TOAN01'),
(14, 'TOAN01'),
(15, 'TOAN01'),
(16, 'TOAN01'),
(17, 'TOAN01'),
(18, 'TOAN01'),
(19, 'TOAN01'),
(20, 'TOAN01'),
(21, 'TOAN01'),
(22, 'TOAN01'),
(23, 'TOAN01'),
(24, 'TOAN01'),
(25, 'TOAN01'),
(26, 'TOAN01'),
(27, 'TOAN01'),
(28, 'TOAN01'),
(29, 'TOAN01'),
(30, 'TOAN01'),
(31, 'TOAN01'),
(32, 'TOAN01'),
(33, 'TOAN01'),
(34, 'TOAN01'),
(35, 'TOAN01'),
(36, 'TOAN01'),
(37, 'TOAN01'),
(38, 'TOAN01'),
(39, 'TOAN01'),
(40, 'TOAN01'),
(41, 'TOAN01'),
(42, 'TOAN01'),
(43, 'TOAN01'),
(44, 'TOAN01'),
(45, 'TOAN01'),
(46, 'TOAN01'),
(47, 'TOAN01'),
(48, 'TOAN01'),
(49, 'TOAN01'),
(50, 'TOAN01')

GO
INSERT INTO BAOCAOBAITHI(MaBThi, MaHS, Diem, ThoiGianHoanThanh, SLDung) VALUES
('TOAN01', 'HS1', 9.0, 5, 45)

GO
INSERT INTO HOIDAP(NoiDung, NguoiTao, MaCH) VALUES
(N'Tại sao 1 cộng 1 bằng 2 mà không phải là bằng 3', 'HS1', 1),
(N'Xin cách giải bài toán', 'HS1', 2),
(N'Thắc mắc nên hỏi!', 'HS1', 3)

GO
INSERT INTO KETQUA(LanThi, MaHS, MaBThi, MaCau, DanAnChon, DanAnDung) VALUES
(1, 'HS1', 'TOAN01', 1, N'd', N'd'),
(1, 'HS1', 'TOAN01', 2, N'c', N'd'),
(1, 'HS1', 'TOAN01', 3, N'd', N'c'),
(1, 'HS1', 'TOAN01', 4, N'b', N'b'),
(1, 'HS1', 'TOAN01', 5, N'a', N'a'),
(1, 'HS1', 'TOAN01', 6, N'd', N'd'),
(1, 'HS1', 'TOAN01', 7, N'd', N'd'),
(1, 'HS1', 'TOAN01', 8, N'd', N'd'),
(1, 'HS1', 'TOAN01', 9, N'd', N'd'),
(1, 'HS1', 'TOAN01', 10, N'd', N'd'),
(1, 'HS1', 'TOAN01', 11, N'd', N'd'),
(1, 'HS1', 'TOAN01', 12, N'd', N'd'),
(1, 'HS1', 'TOAN01', 13, N'd', N'd'),
(1, 'HS1', 'TOAN01', 14, N'd', N'd'),
(1, 'HS1', 'TOAN01', 15, N'd', N'd'),
(1, 'HS1', 'TOAN01', 16, N'd', N'd'),
(1, 'HS1', 'TOAN01', 17, N'd', N'd'),
(1, 'HS1', 'TOAN01', 18, N'd', N'd'),
(1, 'HS1', 'TOAN01', 19, N'd', N'd'),
(1, 'HS1', 'TOAN01', 20, N'd', N'd'),
(1, 'HS1', 'TOAN01', 21, N'd', N'd'),
(1, 'HS1', 'TOAN01', 22, N'd', N'd'),
(1, 'HS1', 'TOAN01', 23, N'd', N'd'),
(1, 'HS1', 'TOAN01', 24, N'd', N'd'),
(1, 'HS1', 'TOAN01', 25, N'd', N'd'),
(1, 'HS1', 'TOAN01', 26, N'd', N'd'),
(1, 'HS1', 'TOAN01', 27, N'd', N'd'),
(1, 'HS1', 'TOAN01', 28, N'd', N'd'),
(1, 'HS1', 'TOAN01', 29, N'd', N'd'),
(1, 'HS1', 'TOAN01', 30, N'd', N'd'),
(1, 'HS1', 'TOAN01', 31, N'd', N'd'),
(1, 'HS1', 'TOAN01', 32, N'd', N'd'),
(1, 'HS1', 'TOAN01', 33, N'd', N'd'),
(1, 'HS1', 'TOAN01', 34, N'd', N'd'),
(1, 'HS1', 'TOAN01', 35, N'd', N'd'),
(1, 'HS1', 'TOAN01', 36, N'd', N'd'),
(1, 'HS1', 'TOAN01', 37, N'd', N'd'),
(1, 'HS1', 'TOAN01', 38, N'd', N'd'),
(1, 'HS1', 'TOAN01', 39, N'd', N'd'),
(1, 'HS1', 'TOAN01', 40, N'd', N'd'),
(1, 'HS1', 'TOAN01', 41, N'd', N'd'),
(1, 'HS1', 'TOAN01', 42, N'd', N'd'),
(1, 'HS1', 'TOAN01', 43, N'd', N'd'),
(1, 'HS1', 'TOAN01', 44, N'd', N'd'),
(1, 'HS1', 'TOAN01', 45, N'd', N'd'),
(1, 'HS1', 'TOAN01', 46, N'd', N'd'),
(1, 'HS1', 'TOAN01', 47, N'd', N'd'),
(1, 'HS1', 'TOAN01', 48, N'd', N'd'),
(1, 'HS1', 'TOAN01', 49, N'd', N'd'),
(1, 'HS1', 'TOAN01', 50, N'd', N'd')






SELECT * FROM HOCSINH WHERE MaTK = 'HS1'
exec sp_ThongKeDiemCaNhanHS 'HS1'