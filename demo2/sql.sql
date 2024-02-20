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

-- tinh  công theo ma nhan vien  
SELECT *  -- , COUNT((ngay_cham_cong)) AS so_ngay_cham_cong -- Đếm số lượng ngày chấm công riêng biệt.
FROM cham_cong
WHERE ngay_cham_cong IS NOT NULL
and ma_nhan_vien = 'DEVBB0002'
GROUP BY date(ngay_cham_cong) -- Nhóm các bản ghi theo ngày chấm công.
HAVING COUNT(*) = 2; -- Chỉ bao gồm các nhóm có 2 bản ghi (1 bản ghi check in và 1 bản ghi check out). thừa bản ghi là k đc tính
-- lay cai nay 
select count(distinct date(congIn.ngay_cham_cong)) so_ngay_cong
from cham_cong congIn
where 
congIn.ngay_cham_cong IS NOT NULL AND
congIn.ma_nhan_vien = 'DEVBB0002'  AND
date(congIn.ngay_cham_cong) in (
	select 
    date(congOut.ngay_cham_cong)
	from cham_cong congOut
	where 
	congOut.ngay_cham_cong IS NOT NULL AND
	congOut.ma_nhan_vien = 'DEVBB0002'  AND
	congOut.loai_cham_cong ='out'
	group by date(congOut.ngay_cham_cong)
)  AND
congIn.loai_cham_cong ='in'
;


-- view mẫu
select count(distinct date(ngay_cham_cong))
from cham_cong
where 
ngay_cham_cong IS NOT NULL AND
ma_nhan_vien = 'DEVBB0002'  AND
date(ngay_cham_cong) in (
	select 
    date(ngay_cham_cong)
	from cham_cong
	where 
	ngay_cham_cong IS NOT NULL AND
	ma_nhan_vien = 'DEVBB0002'  AND
	loai_cham_cong ='out'
	group by date(ngay_cham_cong)
)  AND
loai_cham_cong ='in'
group by date(ngay_cham_cong)
;