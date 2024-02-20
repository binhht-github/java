package com.example.demo2.services.Account;

import com.example.demo2.model.Account;
import com.example.demo2.modelDTO.AccountDTO;
import com.example.demo2.modelDTO.NhanVienDTO;

import java.util.List;

public interface IAccountServices {
    List<AccountDTO> findAll();

    List<AccountDTO> finds();

    AccountDTO findById(String id);

    AccountDTO create(Account account);

    AccountDTO update(AccountDTO accountDTO);

    List<AccountDTO> delete(String id);

    Boolean exitById (String id);

}
