package com.example.demo2.services.LuongBong;

import com.example.demo2.model.NhanVien;
import com.example.demo2.model.PhuCap;
import com.example.demo2.modelDTO.LuongBongDTO;
import com.example.demo2.modelDTO.NhanVienDTO;
import com.example.demo2.repository.ChamCongRepository;
import com.example.demo2.repository.LuongBongRepository;
import com.example.demo2.repository.NhanVienRepository;
import com.example.demo2.until.ModelMapperUntils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LuongBongServices implements ILuongBongServices{
    @Autowired
    ModelMapperUntils mapper;

    @Autowired
    LuongBongRepository repository;

    @Autowired
    NhanVienRepository nhanVienRepository;

    @Autowired
    ChamCongRepository chamCongRepository;

    @Override
    public List<LuongBongDTO> findAllByNhanViens(Date month) throws ParseException {
        String testDate = "29-Apr-2010,13:00:14 PM";
        DateFormat formatter = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss aaa");
        System.out.println(new Date());
        Date date1 = formatter.parse("01-Feb-2024,13:00:14 PM");
        Date date2 = formatter.parse("21-Feb-2024,13:00:14 PM");

//        Date date1 = new Date("2001-01-24T17:00:00.000+00:00");
//        Date date2 = new Date("2001-01-24T17:00:00.000+00:00");
//        System.out.println(date1+" "+date2);
//        System.out.println(chamCongRepository.tinhNgayCong("NS0002",date1,date2));
        List<NhanVien> listNhanVien = nhanVienRepository.findAll();
        List<LuongBongDTO> listLuongBongDTO =  new ArrayList<>();


//        int luongChinh =0;

        for(NhanVien nv :listNhanVien){
            int a[]={};
            int soNgayCong = chamCongRepository.tinhNgayCong(nv.getMaNhanVien(),date1,date2);
            int luongChinh =tinhLuonChinh(nv.getLuongCoBan(),nv.getHeSoLuong(),a,soNgayCong);
            int luongBHXH =tinhBHXH(luongChinh);
            int luongBHTN =tinhBHTN(luongChinh);
            int luongBHYT =tinhBHYT(luongChinh);
            int luongBHBB = tinhBHBatBuoc(luongBHXH,luongBHYT,luongBHTN);
            int thueTNCN = tinhThueTNCN(luongChinh,luongBHBB);
            listLuongBongDTO.add(new LuongBongDTO(
                   nv.getMaNhanVien(),
                    nv.getHoTen(),
                    nv.getChucVu().getTenChucVu(),
                    nv.getPhongBan().getTenPhongBan(),
                    month,
                    Math.round(luongChinh),
                    soNgayCong,
                    0,
                    0,
                    luongBHBB,
                    luongBHXH,
                    luongBHTN,
                    luongBHYT,
                    nv.getLuongCoBan(),
                    0,
                    nv.getHeSoLuong(),
                    "phucap",
                            thueTNCN,
                    luongChinh-thueTNCN

            ));
        }
        System.out.println(listNhanVien);
        return listLuongBongDTO;
    }

    @Override
    public LuongBongDTO create(NhanVienDTO nhanVienDTO) {
        return null;
    }

    public static String priceWithDecimal (float price) {
        DecimalFormat formatter = new DecimalFormat("###,###,###.00");
        return formatter.format(price);
    }
    //=========================================================================
    // khaon + vao luong
    private  List<Integer> tinhPhuCap(String listPhuCap){
        List<Integer> results =new ArrayList<>();
        // xăng xe-1000000;
        // ăn trưa-2800000;
        String chuoi = "xăng xe-1000000;ăn trưa-2800000;";
        String[] parts = listPhuCap.split(";");
        for(int i=0;i<parts.length;i++)
        {
            results.add(Integer.parseInt(parts[i].split("-")[1]));
            System.out.println(parts[i]+" so tien "+ parts[i].split("-")[1]);
        }
        System.out.println("list so tien "+results);
        return results;
    }

    private int tinhLuonChinh(int luongCoBan, float heSoLuong, int[] phuCap,int soNgayCong){
        if(soNgayCong ==0){
            return 0;
        }
        int result =0;
        if (phuCap.length > 0){
            for (int i : phuCap) {
                result+=i;
            }
        }
        result = (int) (result + ((luongCoBan*heSoLuong)*((float) soNgayCong/22)));
        System.out.println("thu nhap chính "+(Math.round(luongCoBan*heSoLuong))+" : "+((float)soNgayCong / 22)+" so ngay cong "+soNgayCong+"  result"+result);
        return result;
    }
    // khoan - vao luong
    private int tinhBHYT(int mucLuong){
        if(mucLuong >= 29800000){
            return (int) (29800000*0.08);
        }
        return (int) (mucLuong*0.015);
    }
    private int tinhBHXH(int mucLuong){
        if(mucLuong >= 29800000){
            return (int) (29800000*0.08);
        }
        return (int) (mucLuong*0.08);
    }
    private int tinhBHTN(int mucLuong){
        if(mucLuong >= 85172000){
            return (int) (85172000*0.08);
        }
        return (int) (mucLuong*0.01);
    }
    private int tinhBHBatBuoc(int BHXH,int BHYT,int BHTN){
        return BHXH + BHYT + BHTN;
    }
    private int tinhThueTNCN(int luongChinh, int bhbb){
        if (luongChinh == 0){
            return 0;
        }
//        luong chinh - bhbb - giam tru ban than - nguoi phu thuoc
        int thuNhap=luongChinh-bhbb-11000000-(0*4400000);
        if(thuNhap <=0){
            return 0;
        }
        if (thuNhap<=5000000){
            return (int) (thuNhap*0.05);
        }
        if (thuNhap<=10000000){
            return (int) (thuNhap*0.1 -250000);
        }
        if (thuNhap<=18000000){
            return (int) (thuNhap*0.15 - 750000);
        }
        if (thuNhap<=32000000){
            return (int) (thuNhap*0.2 - 1650000);
        }
        if (thuNhap<=52000000){
            return (int) (thuNhap*0.25 - 3250000);
        }
        if (thuNhap<=80000000){
            return (int) (thuNhap*0.3 - 5850000);
        }
        return (int) (thuNhap*0.35 - 9850000);
    }
    private int tinhViphamjKyLuat(NhanVien nv, Date startDate, Date endDate){

        return 0;
    }
//
//    mã nhân viên: lấy từ NhanVien                                     DONE
//    họ tên: lấy từ NhanVien                                           DONE
//    chúc danh: lấy từ NhanVien                                        DONE
//    lương đóng bảo hiểm bắt buộc:                                      X
//    ngày công đi làm:  call proceducer ra được ngày công từ ngày bắt đầu - ngày kết thúc
//    ngày công chuẩn:
//    - các khoản thu  nhập
//            luong chính: viết hàm tính lương chính                    DONE
//            phụ cấp: lấy phụ cấp từ api về    công tác có tính thuê   DONE
//            tăng ca:   viết hàm tính công tăng ca vào chủ nhật
//    - các khoản trừ vào lương:  viết hàm tính khoản trừ
//            bảo hiểm bắt buộc                                         DONE
//                bảo hiểm xã hội: 0.08                                 DONE
//                bảo hiểm y tếv 0.015                                  DONE
//                bảo hiểm thất nghiệp: 0.01                            DONE
//            thuế thu nhập cá nhân: viết hàm tính thuế                 DONE
//            Tạm ứng:   thêm cột tạm ứng
//    thực lĩnh: viết hàm thực lĩnh
}


