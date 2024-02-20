package com.example.demo2.services.Account;

import com.example.demo2.model.Account;
import com.example.demo2.modelDTO.AccountDTO;
import com.example.demo2.modelDTO.NhanVienDTO;
import com.example.demo2.repository.AccountRepository;
import com.example.demo2.until.ModelMapperUntils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServices implements IAccountServices{
    @Autowired
    ModelMapperUntils mapper;
    @Autowired
    AccountRepository repository;

    @Override
    public List<AccountDTO> findAll() {
        return mapper.mapList(repository.findAll(), AccountDTO.class);
    }

    @Override
    public List<AccountDTO> finds() {
        return null;
    }

    @Override
    public AccountDTO findById(String id) {
        return null;
    }

    @Override
    public AccountDTO create(Account account) {
        if (repository.existsByUsername(account.getUsername()) == null){
            account.setPassword(createPassWord());
            return mapper.mapItem( repository.save(account),AccountDTO.class);
        }
        return null;
    }

    @Override
    public AccountDTO update(AccountDTO accountDTO) {
        Account acc =repository.existsByUsername(accountDTO.getUsername());
        if (acc != null){
            acc.setPassword(createPassWord());
            return mapper.mapItem( repository.save(acc),AccountDTO.class);
        }
        return null;
    }

    @Override
    public List<AccountDTO> delete(String id) {
        return null;
    }

    @Override
    public Boolean exitById(String id) {
    return  null;
//        return repository.existsByUsername(id);
    }

    private  String createPassWord(){
        int length = 6;
        String randomString = RandomStringUtils.random(length, true, true);
        return randomString;
    }

}
