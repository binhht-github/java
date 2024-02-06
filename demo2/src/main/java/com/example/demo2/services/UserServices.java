package com.example.demo2.services;

import com.example.demo2.model.*;
import com.example.demo2.modelDTO.AccountDTO;
import com.example.demo2.repository.AccountRepository;
import com.example.demo2.repository.NhanVienRepository;
import com.example.demo2.until.ModelMapperUntils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServices {
    @Autowired
    ModelMapperUntils mapper;


    @Autowired
    AccountRepository ar;
    @Autowired
    NhanVienRepository nvr;

    public  void get(){
       NhanVien nv = nvr.findAll().get(0);
        System.out.println(nv.getAccount());
//        mapper.mapItem(AccountDTO,AccountDTO.class);
//        ChucVu cv = new ChucVu();
//        PhongBan pb = new PhongBan();
//        BaoHiemXaHoi bhxh = new BaoHiemXaHoi();
//        bhxh.getNhanVien().getMaNhanVien();
//        HopDongLaoDong hdld = new HopDongLaoDong();
//        hdld.getNhanVien().getHoTen();
//
//        LuongBong lb = new LuongBong();
//        lb.getNhanVien().getHeSoLuong();
//
//        ChamCong cc = new ChamCong();
//        cc.getNhanVien().getBhxh();


//        pb.get
//        cv.get
    }
}
