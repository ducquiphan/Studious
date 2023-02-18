﻿CREATE DATABASE Studious
GO
USE Studious
GO

-- CREATE TABLES
CREATE TABLE TAIKHOAN (
	TenTaiKhoan	VARCHAR(50) NOT NULL,
	MatKhau	VARCHAR(30),
	VaiTro INT,
	TrangThai BIT
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
	MaCau INT NOT NULL,
	DanAnChon VARCHAR(30),
	DanAnDung VARCHAR(30),
	MaLanThi INT,
	MaHS VARCHAR(10),
	MaBTHI VARCHAR(10)
)
GO
CREATE TABLE LANTHI (
	MaLanThi INT NOT NULL,
	MaHS VARCHAR(10) NOT NULL,
	MaBTHI VARCHAR(10) NOT NULL,
	NgayThi DATE DEFAULT GETDATE()
)

ALTER TABLE LANTHI ADD CONSTRAINT pk_LANTHI PRIMARY KEY (MaLanThi, MaHS, MaBTHI)

ALTER TABLE KETQUA ADD CONSTRAINT pk_KETQUA PRIMARY KEY (MaCau)
ALTER TABLE KETQUA ADD CONSTRAINT fk_KETQUA_LANTHI FOREIGN KEY (MaLanThi, MaHS, MaBTHI) REFERENCES LANTHI(MaLanThi, MaHS, MaBTHI)


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


-------------------------------------------
-- Thống kê điểm cá nhân học sinh: số thứ tự, tên bài thi, điểm, lần thi, thời gian làm bài.
GO
CREATE PROC sp_ThongKeDiemCaNhanHS (@MaHS VARCHAR(10))
AS BEGIN
	SELECT ROW_NUMBER() OVER (ORDER BY MaBThi), MaBThi, Diem, ROW_NUMBER() OVER (PARTITION BY MaBThi ORDER BY MaBThi), ThoiGianHoanThanh
	FROM BAOCAOBAITHI
	--WHERE MaHS = @MaHS
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

-----------------------------------
INSERT INTO BAIHOC(TenBH, MonHoc, Khoi, NgayTao, MaGV) VALUES
('TOÁN CỘNG TRỪ', 'TOÁN','10', '11-11-2020','GV25579')








