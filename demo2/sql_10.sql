DELIMITER $$
DROP PROCEDURE IF EXISTS test $$
CREATE PROCEDURE test(
IN checkMonth datetime(6),
IN checkPhongBan varchar(255)
)
BEGIN

	select 
	ca.ma_nhan_vien,
    ca.ho_ten,
    cv.ma_chuc_vu,
    cv.ten_chuc_vu,
    pb.ma_phong_ban,
    pb.ten_phong_ban,
    pb.ten_phong_ban,
-- 	(select ten_chuc_vu from chuc_vu where ma_chuc_vu = ca.ma_chuc_vu) as ma_chuc_vu,
-- 	(select ma_phong_ban from phong_ban where ma_phong_ban = ca.ma_phong_ban) as ma_phong_ban,
--     (select ten_phong_ban from phong_ban where ma_phong_ban = ca.ma_phong_ban) as ten_phong_ban,
--     (select truong_phong from phong_ban where ma_phong_ban = ca.ma_phong_ban) as truong_phong,
    date(checkMonth) as thang_luong,
    
	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),1) as ngay_1,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),2) as ngay_2,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),3) as ngay_3,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),4) as ngay_4,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),5) as ngay_5,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),6) as ngay_6,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),7) as ngay_7,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),8) as ngay_8,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),9) as ngay_9,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),10) as ngay_10,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),11) as ngay_11,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),12) as ngay_12,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),13) as ngay_13,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),14) as ngay_14,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),15) as ngay_15,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),16) as ngay_16,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),17) as ngay_17,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),18) as ngay_18,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),19) as ngay_19,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),20) as ngay_20,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),21) as ngay_21,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),22) as ngay_22,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),23) as ngay_23,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),24) as ngay_24,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),25) as ngay_25,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),26) as ngay_26,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),27) as ngay_27,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),28) as ngay_28,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),29) as ngay_29,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),30) as ngay_30,

	findChamCongByDate_NhanVien(ca.ma_nhan_vien,date(checkMonth),31) as ngay_31
	from nhan_vien ca join phong_ban pb on ca.ma_phong_ban = pb.ma_phong_ban join chuc_vu cv on ca.ma_chuc_vu = cv.ma_chuc_vu
	where ca.deleted='false'
    and ca.ma_phong_ban = checkPhongBan
	;

END; $$
DELIMITER;


call test('2024-02-24','NS');