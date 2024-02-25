select *
from cham_cong cIn
where 
year(cIn.ngay_cham_cong) =2024 and
month(cIn.ngay_cham_cong) =1 and
day(cIn.ngay_cham_cong) = 1 and 
cIn.loai_cham_cong = 'in';

select *
	from cham_cong cOut
	where 
	year(cOut.ngay_cham_cong) =year('2024-02-01') and
	month(cOut.ngay_cham_cong) =month('2024-02-01') and
	day(cOut.ngay_cham_cong) between 1 and 29 and 
	date(cOut.ngay_cham_cong) in (
								select date(cIn.ngay_cham_cong)
								from cham_cong cIn
								where 
								year(cIn.ngay_cham_cong) =year('2024-02-01') and
								month(cIn.ngay_cham_cong) =month('2024-02-01') and
								day(cIn.ngay_cham_cong)between 1 and 29 and 
								cIn.loai_cham_cong = 'in'	and
								cIn.ma_nhan_vien = 'NS0002'
	) and
	cOut.loai_cham_cong = 'out' and
	cOut.ma_nhan_vien = 'NS0002'
    ;
    
    select cOut.ma_cham_cong
			from cham_cong cOut
			where 
			year(cOut.ngay_cham_cong) =year('2024-02-01') and
			month(cOut.ngay_cham_cong) =month('2024-02-01') and
			day(cOut.ngay_cham_cong) = 5 and 
			date(cOut.ngay_cham_cong) in (
										select date(cIn.ngay_cham_cong)
										from cham_cong cIn
										where 
										year(cIn.ngay_cham_cong) =year('2024-02-01') and
										month(cIn.ngay_cham_cong) =month('2024-02-01') and
										day(cIn.ngay_cham_cong) = 5 and 
										cIn.loai_cham_cong = 'in'	and
										cIn.ma_nhan_vien = 'NS0002'
			) and
			cOut.loai_cham_cong = 'out' and
			cOut.ma_nhan_vien = 'NS0002'
			limit 1