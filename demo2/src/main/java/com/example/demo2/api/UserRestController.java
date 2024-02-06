package com.example.demo2.api;


import com.example.demo2.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UserRestController {
        @Autowired
    UserServices us;

        @GetMapping("/")
        public  void geta(){
            us.get();
//            Date date = new Date();
////            date.setYear(2022);
////    us.get();
//            System.out.println("date "+ date);
//            System.out.println("Thứ "+ date.getDay());
//            System.out.println("ngày "+ date.getDate());
//            System.out.println("Tháng "+ (date.getMonth()+1));
//            System.out.println("Năm "+ (date.getYear()+1900));
        }
}
