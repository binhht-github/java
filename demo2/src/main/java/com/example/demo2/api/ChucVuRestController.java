package com.example.demo2.api;

import com.example.demo2.model.ChucVu;
import com.example.demo2.modelDTO.ChucVuDTO;
import com.example.demo2.services.ChucVu.IChucVuServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChucVuRestController {
    @Autowired
    IChucVuServices services;

    @GetMapping("/chuc-vu/all")
    public ResponseEntity<List<ChucVuDTO>> findAll(){
        return  new ResponseEntity<>(services.findAll(),HttpStatus.OK);
    }

    @PostMapping("/chuc-vu/create")
    public ResponseEntity<ChucVuDTO> createChuVu(@RequestBody ChucVu chucVu){
        ChucVuDTO cvDTO = services.create(chucVu);
        if (cvDTO != null){
            return  new ResponseEntity<>(cvDTO, HttpStatus.CREATED);
        }
        return  new ResponseEntity<>(HttpStatus.CONFLICT);
    }


}
