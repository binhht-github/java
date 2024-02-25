package com.example.demo2.api;

import com.example.demo2.model.NhanVien;
import com.example.demo2.modelDTO.NhanVienDTO;
import com.example.demo2.services.NhanVien.INhanVienServices;
//import com.example.demo2.services.NhanVien.NhanVIenServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NhanVIenRestController {
    @Autowired
    INhanVienServices nhanVIenServices;


    @GetMapping("/nhan-vien/all")
    public ResponseEntity<List<NhanVienDTO>>  getAll(){
        System.out.println(nhanVIenServices.findAll());
        return new ResponseEntity<>(nhanVIenServices.findAll(), HttpStatus.OK) ;
    }

    @GetMapping("/nhanviens")
    public ResponseEntity<List<NhanVienDTO>>  getList(){
        System.out.println(nhanVIenServices.findAll());
        return new ResponseEntity<>(nhanVIenServices.findAll(), HttpStatus.OK) ;
    }

    @GetMapping("/nhan-vien/id")
    public ResponseEntity<NhanVienDTO> getById(@RequestParam("maNhanVien") String maNhanVien){
        if (nhanVIenServices.exitById(maNhanVien)){
            return new ResponseEntity<>(nhanVIenServices.findById(maNhanVien),HttpStatus.OK) ;
        }
    return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }

    @PostMapping("/nhan-vien/create")
    public ResponseEntity<NhanVienDTO> createNhanVien(@RequestBody NhanVien item){
            NhanVienDTO nv = nhanVIenServices.create(item);
            if (nv != null){
                return new ResponseEntity<>(nv,HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping("repalce-nhanVien")
    public ResponseEntity<NhanVienDTO> repalceNhanVien(@RequestBody NhanVienDTO item){
        if (nhanVIenServices.exitById(item.getMaNhanVien())){
//            return new ResponseEntity<>(nhanVIenServices.create(item),HttpStatus.UPGRADE_REQUIRED);
        }
        return new ResponseEntity<>(item,HttpStatus.BAD_REQUEST);
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
