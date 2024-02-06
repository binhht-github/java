package com.example.demo2.services.LuongBong;

import com.example.demo2.modelDTO.LuongBongDTO;
import com.example.demo2.modelDTO.NhanVienDTO;
import com.example.demo2.repository.LuongBongRepository;
import com.example.demo2.until.ModelMapperUntils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LuongBongServices implements ILuongBongServices{
    @Autowired
    ModelMapperUntils mapper;

    @Autowired
    LuongBongRepository repository;


    @Override
    public List<LuongBongDTO> findAll() {
        return mapper.mapList(repository.findAll(),LuongBongDTO.class);
    }

    @Override
    public LuongBongDTO findById(Long id) {
        return null;
    }

    @Override
    public LuongBongDTO create(NhanVienDTO nhanVienDTO) {

        return null;
    }

    @Override
    public LuongBongDTO update(LuongBongDTO luongBongDTO) {
        return null;
    }

    @Override
    public List<LuongBongDTO> delete(String id) {
        return null;
    }
    // lấy cột hệ số lương, lương cơ bản, mã nhân viên,

    // dk có ngày nghỉ k lương và có lương
    // nghỉ không lương
    // lương thực lĩnh = (lương cơ bản * hệ số lương) - (lương cơ bản/số công * số ngày nghỉ) - thuế thu nhập cá nhân + phụ cấp

    // nghỉ có lương            lương cơ bản                        nghỉ k lương                        nghỉ có lương                   kỷ luật          thuế               bảo hiểm            phụ cấp
    // lương thực lĩnh = (lương cơ bản * hệ số lương) - (lương cơ bản/số công * số ngày nghỉ) + (lương cơ bản/số công * số ngày nghỉ) - (kỷ luật) - thuế thu nhập cá nhân - bảo hiểm xã hội  + phụ cấp



    //
    // tạo bảng nghỉ phép
    //        Mã kỳ nghỉ (khóa chính): Mã số duy nhất để nhận diện mỗi kỳ nghỉ.
    //        Mã nhân viên: Mã số của nhân viên hưởng kỳ nghỉ.
    //        Loại kỳ nghỉ: Loại kỳ nghỉ (nghỉ phép, nghỉ ốm, ...).
    //        Ngày bắt đầu: Ngày bắt đầu nghỉ.
    //        Ngày kết thúc: Ngày kết thúc nghỉ.
    //        Số ngày nghỉ: Số ngày nghỉ.
    //        Tính lương: boolenm
    //        Lý do: Lý do nghỉ (nếu có).
    //
    //  TÍnh lương gross lương cơ bản nhân hệ số lương
    int maxNgayCong = 26;
    private Float luongGross(float luongCoBan, float heSo,float phuCap){
        return luongCoBan*heSo + phuCap;
    }
    //  nghỉ không lương  lương  vs nghi có lương (viết bên bảng kỳ nghỉ)
    private Float nghiKhongLuong(float luongCoBan, float heSo, int soNgayNghi){
        return     luongCoBan*heSo/maxNgayCong * soNgayNghi ;
    }

    private Float nghiCoLuong(float luongCoBan, float heSo, int soNgayNghi){
        return      luongCoBan*heSo/maxNgayCong * soNgayNghi ;
    }
    //      kỷ luật
    private double luongKyLuat(Date ngayBatDau,Date ngayKetThuc){
//        tìm lỗi bị trừ trong bảng kỷ luật từ ngày bắt đầu đến ngày kết thúc
        double total =0;
        return  total;
    }
    //    Mức lương ghi trong hợp đồng lao động: 10 triệu đồng.
    //    Phụ cấp chức vụ: 1 triệu đồng.
    //    Phụ cấp thâm niên: 500.000 đồng.
    //    Mức lương đóng bảo hiểm: 10 triệu đồng + 1 triệu đồng + 500.000 đồng = 11.500.000 đồng.

    //    Mức đóng: BHXH (8%), BHYT (1.5%), BHTN (1%)
    //    Bảo hiểm bắt buộc = 20,000,000 x 8% + 20,000,000 x 1.5% + 20,000,000 x 1% = 2,100,000đ
    //    Giảm trừ bản thân = 11,000,000
    //    Giảm trừ người phụ thuộc = 0 x 4,400,000 = 0
    //    Thu nhập tính thuế = 20,000,000 - 2,100,000 - 11,000,000 - 0 = 6,900,000
    //    Mức thuế áp dụng đối với 6,900,000 là 10% - 250,000 (tham khảo bảng bên dưới)
    //    Thuế thu nhập cá nhân phải nộp = 6,900,000 x 10% - 250,000 = 440,000đ
    private double tinhThue(float luongGross, float luongCoBan){
            float baoHiem=0;
            if(luongGross > 29800000){
                baoHiem = (float) (29800000 * 0.08 + 29800000 * 0.015% + luongGross * 0.01);
            }
            baoHiem = (float) (luongGross * 0.08 + luongGross * 0.015% + luongGross * 0.01);
            float giamTrubanThan = 11000000;
            int nguoiPhuThuoc = 0 * 4400000;
            float thuNhap = luongCoBan - baoHiem - giamTrubanThan - nguoiPhuThuoc;
            if (thuNhap<=5000000){
                return thuNhap*0.05;
                }
            if (thuNhap<=10000000){
                return thuNhap*0.1 -250000;
            }
            if (thuNhap<=18000000){
                return thuNhap*0.15 - 750000;
            }
            if (thuNhap<=32000000){
                return thuNhap*0.2 - 1650000;
            }
            if (thuNhap<=52000000){
                return thuNhap*0.25 - 3250000;
            }
            if (thuNhap<=80000000){
                return thuNhap*0.3 - 5850000;
            }
        return thuNhap*0.35 - 9850000;
    }

    private double tinhBaoHiemXaHoi(float luongGross){
        return  luongGross*0.08 + luongGross * 0.0005;
    }

    private float luongThucLinh (NhanVienDTO nhanVienDTO, float phuCap){
//        return luongGross(nhanVienDTO.getLuongCoBan(),nhanVienDTO.getHeSoLuong(),phuCap) - luongKyLuat(ngayBatDau,ngayKetThuc)  -tinhThue() - tinhBaoHiemXaHoi() ;
        return 0;
    }
//    private float luongThucLinh (float luongCoBan, float heSo,float phuCap,Date ngayBatDau,Date ngayKetThuc){
//        return luongGross(luongCoBan,heSo,phuCap) - luongKyLuat(ngayBatDau,ngayKetThuc) - nghiKhongLuong() -tinhThue() -tinhBaoHiemXaHoi() + nghiCoLuong();
//    }
}


