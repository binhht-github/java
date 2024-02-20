package com.example.demo2.api;


import com.example.demo2.model.PhongBan;
import com.example.demo2.modelDTO.PhongBanDTO;
import com.example.demo2.services.PhongBan.IPhongBanServices;
import com.example.demo2.until.ModelMapperUntils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PhongBanRestController {
    @Autowired
    ModelMapperUntils mapper;
    @Autowired
    IPhongBanServices services;



    @GetMapping("phong-ban/all")
    public ResponseEntity<List<PhongBanDTO>> getAll(){
        return new ResponseEntity<>(services.findAll(), HttpStatus.OK);
    }

    @GetMapping("phong-ban/id")
    public  ResponseEntity<PhongBanDTO> getOneByMaPhongBan(@RequestParam("maNhanVien") String maPhongBan){
        System.out.println("ma phong ban "+maPhongBan);
        return new ResponseEntity<>(new PhongBanDTO(),HttpStatus.OK);
    }

    @GetMapping("phong-ban/ten")
    public  ResponseEntity<List<PhongBanDTO>> getOneByTenPhongBan(@RequestParam("tenPhongBan") String tenPhongBan){
        System.out.println("abc "+tenPhongBan);
        System.out.println(services.findByName(tenPhongBan));
        return new ResponseEntity<>(services.findByName(tenPhongBan),HttpStatus.OK);
    }

    @PostMapping("phong-ban/create")
    public ResponseEntity<PhongBanDTO> createPhongBan(@RequestBody PhongBan phongBan){
        PhongBanDTO pb =services.create(phongBan);
        if (pb != null){
            return new ResponseEntity<>(pb,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(mapper.mapItem(phongBan,PhongBanDTO.class),HttpStatus.CONFLICT);
    }

    @PutMapping("phong-ban/update")
    public ResponseEntity<PhongBanDTO> replcePhongBan(@RequestBody PhongBan phongBan){
        System.out.println("update");
        PhongBanDTO pb =services.update(phongBan);
        if (pb != null){
            return new ResponseEntity<>(pb,HttpStatus.UPGRADE_REQUIRED);
        }
        return new ResponseEntity<>(mapper.mapItem(phongBan,PhongBanDTO.class),HttpStatus.CONFLICT);
    }
}
