-- Get  sst ma nhan vien theo ma phong ban
SELECT 
SUBSTRING_INDEX(ma_nhan_vien, '0', 1)  AS letters,
SUBSTRING( ma_nhan_vien, -4, 4 ) AS numbers,
ma_nhan_vien as manhanvien
FROM micro_db.nhan_vien
where SUBSTRING_INDEX(ma_nhan_vien, '0', 1) like 'NV';
--
SELECT 
max(SUBSTRING( ma_nhan_vien, -4, 4 )) AS numbers
FROM micro_db.nhan_vien
where SUBSTRING_INDEX(ma_nhan_vien, '0', 1) = 'DEV';
--
SELECT 
if(max(SUBSTRING( ma_nhan_vien, -4, 4 )) is null,'0001',max(SUBSTRING( ma_nhan_vien, -4, 4 ))) AS numbers
FROM micro_db.nhan_vien
where SUBSTRING_INDEX(ma_nhan_vien, '0', 1) like 'DEV';

-- tinh số  ngày  công theo ma nhan vien  

DELIMITER $$
DROP PROCEDURE IF EXISTS getSoNgayCong $$
CREATE PROCEDURE getSoNgayCong(
IN maNhanVien varchar(255) ,
IN startDate datetime(6),
IN endDate datetime(6)
)
BEGIN
	select count(distinct date(congIn.ngay_cham_cong)) so_ngay_cong
	from cham_cong congIn
	where 
	congIn.ngay_cham_cong IS NOT NULL AND
	congIn.ma_nhan_vien = maNhanVien AND
	date(congIn.ngay_cham_cong) between date(startDate) and date(endDate) AND
	date(congIn.ngay_cham_cong) in (
		select 
		date(congOut.ngay_cham_cong)
		from cham_cong congOut
		where 
		congOut.ngay_cham_cong IS NOT NULL AND
		congOut.ma_nhan_vien = maNhanVien  AND
       date(congOut.ngay_cham_cong) between date(startDate) and date(endDate) AND
		congOut.loai_cham_cong ='in'
		group by date(congOut.ngay_cham_cong)
	)  AND
	congIn.loai_cham_cong ='out';
END; $$
DELIMITER;

CALL getSoNgayCong('NS0002','2024-02-02','2024-02-29');

DROP TRIGGER IF EXISTS  TG_Update_LuongCoBan_BF_CRE_Nhan_Vien;
DELIMITER $$
CREATE TRIGGER TG_Update_LuongCoBan_BF_CRE_Nhan_Vien before insert
 ON nhan_vien
 FOR EACH ROW
 BEGIN
		set NEW.luong_co_ban = (select mucluong_co_ban from chuc_vu cv where cv.ma_chuc_vu = NEW.ma_chuc_vu);
        set NEW.he_so_luong = (select he_so_luong from chuc_vu cv where cv.ma_chuc_vu = NEW.ma_chuc_vu);
     --   where ma_nhan_vien = NEW.ma_nhan_vien
END$$
 DELIMITER ;


-- tìm Chấm công theo ngày tháng năm và mã nhân viên
-- k dùng procedure
DELIMITER $$
DROP PROCEDURE IF EXISTS findChamCongByDate_NhanVien $$
CREATE PROCEDURE findChamCongByDate_NhanVien(
IN maNhanVien varchar(255) ,
IN checkDate datetime(6),
IN checkDay int(10)
)
BEGIN
	select *
	from cham_cong cOut
	where 
	year(cOut.ngay_cham_cong) =year(checkDate) and
	month(cOut.ngay_cham_cong) =month(checkDate) and
	day(cOut.ngay_cham_cong) = checkDay and 
	date(cOut.ngay_cham_cong) in (
								select date(cIn.ngay_cham_cong)
								from cham_cong cIn
								where 
								year(cIn.ngay_cham_cong) =year(checkDate) and
								month(cIn.ngay_cham_cong) =month(checkDate) and
								day(cIn.ngay_cham_cong) = checkDay and 
								cIn.loai_cham_cong = 'in'	and
								cIn.ma_nhan_vien = maNhanVien
	) and
	cOut.loai_cham_cong = 'out' and
	cOut.ma_nhan_vien = maNhanVien
	limit 1;
END; $$
DELIMITER;

call findChamCongByDate_NhanVien('NS0002','2024-02-02',13);

DELIMITER $$
DROP FUNCTION IF EXISTS findChamCongByDate_NhanVien $$
CREATE FUNCTION findChamCongByDate_NhanVien(
	maNhanVien varchar(255) ,
	checkDate datetime(6),
	checkDay int(10)
 ) 
RETURNS varchar(10)
DETERMINISTIC
BEGIN
	DECLARE id varchar(10);
     if
		(
			select cOut.ma_cham_cong
			from cham_cong cOut
			where 
			year(cOut.ngay_cham_cong) =year(checkDate) and
			month(cOut.ngay_cham_cong) =month(checkDate) and
			day(cOut.ngay_cham_cong) = checkDay and 
			date(cOut.ngay_cham_cong) in (
										select date(cIn.ngay_cham_cong)
										from cham_cong cIn
										where 
										year(cIn.ngay_cham_cong) =year(checkDate) and
										month(cIn.ngay_cham_cong) =month(checkDate) and
										day(cIn.ngay_cham_cong) = checkDay and 
										cIn.loai_cham_cong = 'in'	and
										cIn.ma_nhan_vien = maNhanVien
			) and
			cOut.loai_cham_cong = 'out' and
			cOut.ma_nhan_vien = maNhanVien
			limit 1
        )
		is not null 
	then 
    set id = 'TRUE';
    end if;
    return (id);
END;$$
DELIMITER;





























































-- tam

select distinct ca.ma_nhan_vien,
if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 1 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_1,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 2 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_2,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 3 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_3,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 4 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_4,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 5 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_5,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 6 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_6,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 7 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_7,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 8 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_8,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 9 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_9,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 10 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_10,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 11 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_11,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 12 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_12,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 13 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_13,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 14 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_14,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 15 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_15,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 16 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_16,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 17 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_17,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 18 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_18,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 19 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_19,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 20 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_20,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 21 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_21,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 22 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_22,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 23 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_23,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 24 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_24,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 25 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_25,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 26 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_26,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 27 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_27,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 28 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_28,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 29 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_29,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 30 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_30,
  if(
	(select  c.ma_cham_cong
	from cham_cong c where day(c.ngay_cham_cong) = 31 and c.loai_cham_cong = 'in' limit 1
) is not null , 'x',null) as ngay_31
from cham_cong ca
order by ca.ma_nhan_vien
;

