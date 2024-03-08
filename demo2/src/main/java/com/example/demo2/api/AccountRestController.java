package com.example.demo2.api;


import com.example.demo2.model.Account;
import com.example.demo2.model.NhanVien;
import com.example.demo2.modelDTO.AccountDTO;
import com.example.demo2.modelDTO.NhanVienDTO;
import com.example.demo2.services.Account.IAccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

@RestController
public class AccountRestController {
    @Autowired
    IAccountServices services;

    @PostMapping("/account/create")
    public ResponseEntity<AccountDTO> createAccHandle(AccountDTO accountDTO){
        if(services.create(
                new Account(
                        accountDTO.getNhanVien(),
                        accountDTO.getUsername(),
                        "false",
                        LocalDate.now()
                )
            ) != null
        ){
            return  new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>( HttpStatus.CONFLICT);
    }

    @PostMapping("/account/reset-pass")
    public ResponseEntity<AccountDTO> resetPass(AccountDTO accountDTO){
        if(services.update(accountDTO) != null){
            return  new ResponseEntity<>(HttpStatus.UPGRADE_REQUIRED);
        }
        return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
    }
}
