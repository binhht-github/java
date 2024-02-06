package com.example.demo2.api;

import com.example.demo2.modelDTO.NhanVienDTO;
import com.example.demo2.services.NhanVien.NhanVIenServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NhanVIenRestController {
    @Autowired
    NhanVIenServices nhanVIenServices;


    @GetMapping("/nhanvien-all")
    public List<NhanVienDTO> getList(){
        System.out.println(nhanVIenServices.findAll());
        return nhanVIenServices.findAll();
    }
    @GetMapping("/nhan-vien/{maNhanVien}")
    public NhanVienDTO getById(@PathVariable("maNhanVien") String maNhanVien){
        if (nhanVIenServices.exitById(maNhanVien)){
            return nhanVIenServices.findById(maNhanVien);
        }
    return null;
    }
    @GetMapping("/nhanvien-all2")
    public List<String>  getList2(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        return list;
    }


}
