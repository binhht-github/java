package com.example.demo2.services.PhongBan;

import com.example.demo2.model.PhongBan;
import com.example.demo2.modelDTO.PhongBanDTO;
import com.example.demo2.repository.PhongBanRepository;
import com.example.demo2.until.ModelMapperUntils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongBanServices implements IPhongBanServices{
    @Autowired
    ModelMapperUntils mapper;
    @Autowired
    PhongBanRepository repository;

    @Override
    public List<PhongBanDTO> findAll() {
        return mapper.mapList(repository.findAll(),PhongBanDTO.class);
    }

    @Override
    public PhongBanDTO findById(String id) {
        if (repository.existsById(id)){
            return mapper.mapItem(repository.findById(id).get(),PhongBanDTO.class);
        }
        return null;
    }

    @Override
    public List<PhongBanDTO> findByName(String name) {

        return mapper.mapList(repository.findByTenPhongBan(name),PhongBanDTO.class);
    }

    @Override
    public PhongBanDTO create(PhongBan phongBan) {
        if (!repository.existsById(phongBan.getMaPhongBan())){
            return mapper.mapItem(repository.save(phongBan),PhongBanDTO.class);
        }
        return null;
    }

    @Override
    public PhongBanDTO update(PhongBan phongBan) {
        if (repository.existsById(phongBan.getMaPhongBan())){
            return mapper.mapItem(repository.save(phongBan),PhongBanDTO.class);
        }
        return null;
    }

    @Override
    public List<PhongBanDTO> delete(String id) {
        return null;
    }
}
