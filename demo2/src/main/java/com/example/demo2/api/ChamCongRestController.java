package com.example.demo2.api;

import com.example.demo2.model.ChamCong;
import com.example.demo2.modelDTO.ChamCongDTO;
import com.example.demo2.modelDTO.ChamCongStatisticsDTO;
import com.example.demo2.services.ChamCong.IChamCongServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
public class ChamCongRestController {
    @Autowired
    IChamCongServices services;


    @GetMapping("cham-cong/id")
    public ResponseEntity<ChamCongDTO> getOneChamCongById(@RequestParam  String maChamCong){
        System.out.println("api "+maChamCong);
        ChamCongDTO chamCongDTO = services.findById(maChamCong);
        if (chamCongDTO != null){
            return new ResponseEntity<>(chamCongDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

//    @GetMapping("cham-cong/{maNhanVien}-{start}-{end}")
    @GetMapping("cham-cong/nhan-vien")
    public ResponseEntity<List<ChamCongDTO>> getChamCongByNhanVien(@RequestParam  String maNhanVien, @RequestParam String start, @RequestParam  String end){
        System.out.println("api 2 "+maNhanVien+" "+start +" "+end);
        String sDate1="2024/02/19";
        Date date1=new SimpleDateFormat("dd/MM/yyyy", Locale.US).parse(sDate1, new ParsePosition(0));
        System.out.println(sDate1+"\t"+date1);
//        System.out.println("date "+ new SimpleDateFormat("dd/MM/yyyy").parse("06/27/2007"));
//        List<ChamCongDTO> list = services.findByNhanVienFromTo()
//        if (chamCongDTO != null){
//            return new ResponseEntity<>(chamCongDTO, HttpStatus.OK);
//        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("cham-cong/create")
    public ResponseEntity<ChamCongDTO> createChamCong(@RequestBody ChamCong chamCong){
        System.out.println(chamCong.getLoaiChamCong().equalsIgnoreCase("in"));
        if(!chamCong.getLoaiChamCong().equalsIgnoreCase("in") && !chamCong.getLoaiChamCong().equalsIgnoreCase("out")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ChamCongDTO chamCongDTO = services.create(chamCong);
        if (chamCongDTO != null){
            return  new ResponseEntity<>(chamCongDTO,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    @GetMapping("cham-cong/statistic")
    public ResponseEntity<List<ChamCongStatisticsDTO>> getChamCongStatistic(){
        System.out.println("statistic");
        return  new ResponseEntity<>(services.getChamCongStatisDTO(new Date()),HttpStatus.OK);
    }

}
