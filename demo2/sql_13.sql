
select 
distinct ca.ma_nhan_vien,
ca.ma_chuc_vu,
ca.ma_phong_ban,
findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',1) as ngay_1,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',2) as ngay_2,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',3) as ngay_3,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',4) as ngay_4,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',55) as ngay_5,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',6) as ngay_6,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',7) as ngay_7,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',8) as ngay_8,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',9) as ngay_9,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',10) as ngay_10,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',11) as ngay_11,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',12) as ngay_12,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',13) as ngay_13,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',14) as ngay_14,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',15) as ngay_15,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',16) as ngay_16,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',17) as ngay_17,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',18) as ngay_18,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',19) as ngay_19,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',20) as ngay_20,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',21) as ngay_21,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',22) as ngay_22,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',23) as ngay_23,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',24) as ngay_24,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',25) as ngay_25,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',26) as ngay_26,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',27) as ngay_27,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',28) as ngay_28,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',29) as ngay_29,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',30) as ngay_30,

findChamCongByDate_NhanVien(ca.ma_nhan_vien,'2024-02-02',31) as ngay_31
from nhan_vien ca
where ca.deleted='false'
;
