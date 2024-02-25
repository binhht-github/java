package com.example.demo2.api;

import com.example.demo2.modelDTO.LuongBongDTO;
import com.example.demo2.services.LuongBong.ILuongBongServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
public class LuongBongRestController {
    @Autowired
    ILuongBongServices services;

    @GetMapping("/luong-bong/all")
    public ResponseEntity<List<LuongBongDTO>> finfAll() throws ParseException {
//          services.findAllByNhanViens(new Date());
        return new ResponseEntity<>(  services.findAllByNhanViens(new Date()),HttpStatus.OK);
    }
}
