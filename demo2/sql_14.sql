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
CREATE FUNCTION findChamCongByDate_NhanVien( a Nvarchar(50)) 
RETURNS varchar(10)
DETERMINISTIC
BEGIN
	DECLARE id varchar(10);
     if
		(select  c.ma_cham_cong
		from cham_cong c where day(c.ngay_cham_cong) = 3 and c.loai_cham_cong = 'in' limit 1)
		is not null 
	then 
    set id = 'ádasd1';
    end if;
    return (id);
END;$$
DELIMITER;

select 
findChamCongByDate_NhanVien(nv.ma_nhan_vien)
from nhan_vien nv

select 
nv.ma_nhan_vien ,
findChamCongByDate_NhanVien(nv.ma_nhan_vien,'2024-02-02',13)
from nhan_vien nv









select *
from cham_cong cOut
where 
year(cOut.ngay_cham_cong) =2024 and
month(cOut.ngay_cham_cong) =1 and
day(cOut.ngay_cham_cong) = 1 and 
date(cOut.ngay_cham_cong) in (
							select date(cIn.ngay_cham_cong)
							from cham_cong cIn
							where 
							year(cIn.ngay_cham_cong) =2024 and
							month(cIn.ngay_cham_cong) =1 and
							day(cIn.ngay_cham_cong) = 1 and 
							cIn.loai_cham_cong = 'in'	and
                            cIn.ma_nhan_vien = 'NS0002'
) and
cOut.loai_cham_cong = 'out' and
cOut.ma_nhan_vien = 'NS0002'
limit 1


