use furama;
-- yeu cau 2
select *
from furama.nhan_vien
where ho_ten like 't%' or ho_ten like 'h%' or ho_ten like 'k%' and length(ho_ten)<15;

-- yeu cau 3
select *
from khach_hang
where ((year(now())-year(ngay_sinh)) between 23 and 50) and (dia_chi = 'Đà Nẵng' or dia_chi = 'Quảng Trị');

-- yeu cau 4
select KH.ho_ten, count(HD.id_hop_dong) as 'so_lan_dat'
from khach_hang KH
inner join hop_dong HD on KH.id_khach_hang=HD.id_khach_hang
inner join loai_khach LK on KH.id_loai_khach=LK.id_loai_khach
where LK.ten_loai_khach = 'Diamond'
group by KH.id_khach_hang
order by so_lan_dat;

-- yeu cau 5
select KH.id_khach_hang, KH.ho_ten, LK.ten_loai_khach, HD.id_hop_dong, DV.ten_dich_vu, HD.ngay_lam_hop_dong, HD.ngay_ket_thuc,(DV.chi_phi_thue + HDCT.so_luong*DVDK.gia) as 'tong_tien'
from khach_hang KH
left join hop_dong HD on KH.id_khach_hang=HD.id_khach_hang
inner join loai_khach LK on KH.id_khach_hang=LK.id_loai_khach  
left join dich_vu DV on DV.id_dich_vu=HD.id_dich_vu
left join hop_dong_chi_tiet HDCT on HDCT.id_hop_dong=HD.id_hop_dong
left join dich_vu_di_kem DVDK on DVDK.id_dich_vu_di_kem=HDCT.id_dich_vu_di_kem;

-- yeu cau 6
select DV.id_dich_vu,DV.ten_dich_vu,DV.dien_tich,DV.chi_phi_thue,LDV.ten_loai_dich_vu,month(ngay_lam_hop_dong),year(ngay_lam_hop_dong)
from dich_vu DV
inner join loai_dich_vu LDV on DV.id_loai_dich_vu=LDV.id_loai_dich_vu
inner join hop_dong HD on DV.id_dich_vu = HD.id_dich_vu 
where HD.ngay_lam_hop_dong between '2019-01-01'and'2019-03-31';

-- yeu cau 7
select dich_vu.id_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.so_nguoi_toi_da,dich_vu.chi_phi_thue,loai_dich_vu.ten_loai_dich_vu
from dich_vu 
inner join loai_dich_vu  on loai_dich_vu.id_loai_dich_vu=dich_vu.id_loai_dich_vu
-- inner join hop_dong HD on DV.id_dich_vu = HD.id_dich_vu
where  exists (
	select hop_dong.id_hop_dong
    from hop_dong 
    where year(hop_dong.ngay_lam_hop_dong) = '2018' and hop_dong.id_dich_vu=dich_vu.id_dich_vu
) and not exists (
	select hop_dong.id_hop_dong
    from hop_dong 
    where year(hop_dong.ngay_lam_hop_dong) = '2019' and hop_dong.id_dich_vu=dich_vu.id_dich_vu
);

-- yeu cau 8
-- cách 1
select distinct KH.ho_ten
from khach_hang KH;

 -- cách 2 
select KH.ho_ten
from khach_hang KH
group by KH.ho_ten;
 
-- cách 3
select KH.ho_ten
from khach_hang KH
left join loai_khach LK on KH.id_loai_khach = LK.id_loai_khach
union
select KH.ho_ten
from khach_hang KH
right join loai_khach LK on KH.id_loai_khach = LK.id_loai_khach;

-- yeu cau 9
select temp.month, count(month(hop_dong.ngay_lam_hop_dong)) as so_khach_hang_dang_ki, sum(hop_dong.tong_tien) as tong_tien from
(select 1 as month
union select 2 as month
union select 3 as month
union select 4 as month
union select 5 as month
union select 6 as month
union select 7 as month
union select 8 as month
union select 9 as month
union select 10 as month
union select 11 as month
union select 12 as month) as temp

left join hop_dong on month(hop_dong.ngay_lam_hop_dong)=temp.month
left join khach_hang on khach_hang.id_khach_hang=hop_dong.id_khach_hang
where year(hop_dong.ngay_lam_hop_dong)='2019' or year(hop_dong.ngay_lam_hop_dong) is null or month (hop_dong.ngay_lam_hop_dong) is null
group by temp.month
order by temp.month;

-- yêu cầu 10
select HD.id_hop_dong,HD.ngay_lam_hop_dong, HD.ngay_ket_thuc, HD.tien_dat_coc, count(HDCT.id_dich_vu_di_kem) as so_luong_dich_vu
from hop_dong HD
inner join hop_dong_chi_tiet HDCT on HD.id_hop_dong = HDCT.id_hop_dong
group by HD.id_hop_dong;

-- yêu cầu 11
select DVDK.ten_dich_vu_di_kem, DVDK.gia, DVDK.don_vi, DVDK.trang_thai_kha_dung
from hop_dong HD
inner join hop_dong_chi_tiet HDCT on HD.id_hop_dong = HDCT.id_hop_dong
inner join dich_vu_di_kem DVDK on HDCT.id_dich_vu_di_kem=DVDK.id_dich_vu_di_kem
inner join khach_hang KH on HD.id_khach_hang = KH.id_khach_hang
inner join loai_khach LK on KH.id_loai_khach = LK.id_loai_khach
where LK.ten_loai_khach = 'diamond' and KH.dia_chi in ('Quảng Ngãi','Vinh');

-- yêu cầu 12
select HD.id_hop_dong,HD.tien_dat_coc,HD.tong_tien, NV.ho_ten, KH.ho_ten,KH.sdt,DV.ten_dich_vu,count(HDCT.id_dich_vu_di_kem) as so_luong_dich_vu_di_kem
from hop_dong HD
inner join hop_dong_chi_tiet HDCT on HD.id_hop_dong = HDCT.id_hop_dong
inner join dich_vu_di_kem DVDK on HDCT.id_dich_vu_di_kem=DVDK.id_dich_vu_di_kem
inner join nhan_vien NV on NV.id_nhan_vien = HD.id_nhan_vien
inner join khach_hang KH on KH.id_khach_hang = HD.id_khach_hang
inner join dich_vu DV on DV.id_dich_vu = HD.id_dich_vu
where not exists (
	select HD.id_hop_dong
    where HD.ngay_lam_hop_dong between "2019-01-01" and "2019-06-30"
)
and exists(
	select HD.id_hop_dong
    where HD.ngay_lam_hop_dong between "2019-09-01" and "2019-12-31"
);

-- yêu cầu 13
create temporary table temp
select DVDK.ten_dich_vu_di_kem, count(HDCT.id_dich_vu_di_kem) as so_lan_su_dung
from hop_dong_chi_tiet HDCT
inner join dich_vu_di_kem DVDK on DVDK.id_dich_vu_di_kem = HDCT.id_dich_vu_di_kem
group by DVDK.ten_dich_vu_di_kem;
select * 
from temp;
create temporary table temp1
select temp.ten_dich_vu_di_kem, max(temp.so_lan_su_dung) as max_so_lan_su_dung from temp;
select * from temp1;
drop temporary table temp;
drop temporary table temp1;

-- yêu cầu 14
select HD.id_hop_dong,LDV.ten_loai_dich_vu,DVDK.ten_dich_vu_di_kem, count(HDCT.id_dich_vu_di_kem) as so_lan_su_dung
from hop_dong HD
inner join hop_dong_chi_tiet HDCT on HD.id_hop_dong = HDCT.id_hop_dong
inner join dich_vu_di_kem DVDK on DVDK.id_dich_vu_di_kem = HDCT.id_dich_vu_di_kem
inner join dich_vu DV on DV.id_dich_vu = HD.id_dich_vu
inner join loai_dich_vu LDV on LDV.id_loai_dich_vu = DV.id_loai_dich_vu
group by (DVDK.ten_dich_vu_di_kem) 
having so_lan_su_dung=1;
 
 -- yêu cầu 15
 select NV.id_nhan_vien,NV.ho_ten,TD.trinh_do,BP.ten_bo_phan,NV.sdt,NV.dia_chi,count(HD.id_nhan_vien) as so_lan_lap_hop_dong
 from nhan_vien NV
 inner join bo_phan BP on BP.id_bo_phan = NV.id_bo_phan
 inner join trinh_do TD on TD.id_trinh_do = NV.id_trinh_do
 inner join hop_dong HD on HD.id_nhan_vien = NV.id_nhan_vien
 where HD.ngay_lam_hop_dong between "2018-01-01" and "2019-12-31"
 group by NV.ho_ten
 having so_lan_lap_hop_dong <4;
 
 -- yêu cầu 16
 delete from nhan_vien where not exists(
	select nhan_vien.id_nhan_vien
    from hop_dong
    where hop_dong.ngay_lam_hop_dong between "2017-01-01" and "2019-12-31" and hop_dong.id_nhan_vien=nhan_vien.id_nhan_vien
 );

-- yêu cầu 17
update khach_hang
inner join loai_khach LK on LK.id_loai_khach= khach_hang.id_loai_khach
inner join hop_dong HD on HD.id_khach_hang = khach_hang.id_khach_hang
set khach_hang.id_loai_khach=1
where (LK.ten_loai_khach ="Platinium") and (year(HD.ngay_lam_hop_dong)=2019) and (HD.tong_tien>10000);

-- yêu cầu 18

SET SQL_SAFE_UPDATES = 0;
delete from khach_hang
where id_khach_hang in (
select id_khach_hang
from hop_dong
where year(ngay_lam_hop_dong) <= 2016);
SET SQL_SAFE_UPDATES = 1;

-- yêu cầu 19
-- sử dụng exist
update dich_vu_di_kem
inner join hop_dong_chi_tiet HDCT on HDCT.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
inner join hop_dong on hop_dong.id_hop_dong = HDCT.id_hop_dong
set dich_vu_di_kem.gia=dich_vu_di_kem.gia*2
where exists (
	select dich_vu_di_kem.ten_dich_vu_di_kem
    from hop_dong_chi_tiet
    where hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem and year(hop_dong.ngay_lam_hop_dong)=2019
    -- inner join dich_vu_di_kem  on dich_vu_di_kem.id_dich_vu_di_kem=dich_vu_di_kem.id_dich_vu_di_kem
    group by dich_vu_di_kem.id_dich_vu_di_kem
    having count(hop_dong_chi_tiet.id_dich_vu_di_kem)>3
);

-- sử dụng in
update dich_vu_di_kem
	-- inner join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
    set dich_vu_di_kem.gia = dich_vu_di_kem.gia *2
    where dich_vu_di_kem.id_dich_vu_di_kem in (
		select * 
        from (
			select dich_vu_di_kem.id_dich_vu_di_kem 
            from dich_vu_di_kem
            inner join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
		) as temp
            group by ten_dich_vu_di_kem 
            having count(id_dich_vu_di_kem) >=3
	);

-- yêu cầu 20
select NV.id_nhan_vien, NV.ho_ten, NV.email, NV.sdt, NV.ngay_sinh, NV.dia_chi, "nhanvien" as FromTable
from nhan_vien NV
union all
select KH.id_khach_hang, KH.ho_ten, KH.email, KH.sdt, KH.ngay_sinh, KH.dia_chi, "khachhang" asFromTable
from khach_hang KH
