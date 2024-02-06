package com.example.demo2.services.ChucVu;

import com.example.demo2.model.ChucVu;
import com.example.demo2.modelDTO.ChucVuDTO;
import com.example.demo2.repository.ChucVuRepository;
import com.example.demo2.until.ModelMapperUntils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChucVuServices implements IChucVuServices{
    @Autowired
    ModelMapperUntils mapper;
    @Autowired
    ChucVuRepository repository;

    @Override
    public List<ChucVuDTO> findAll() {
        return mapper.mapList(repository.findAll(),ChucVuDTO.class);
    }

    @Override
    public ChucVuDTO findById(String maChucVu) {
        if (repository.existsById(maChucVu)){
            return mapper.mapItem(repository.findById(maChucVu),ChucVuDTO.class);
        }
        return null;
    }

    @Override
    public ChucVuDTO create(ChucVuDTO chucVuDTO) {
        if (!repository.existsById(chucVuDTO.getMaChucVu())){
            return  mapper.mapItem(repository.save(mapper.mapItem(chucVuDTO, ChucVu.class)),ChucVuDTO.class);
        }
        return null;
    }

    @Override
    public ChucVuDTO update(ChucVuDTO chucVuDTO) {
        if (repository.existsById(chucVuDTO.getMaChucVu())){
            return  mapper.mapItem(repository.save(mapper.mapItem(chucVuDTO, ChucVu.class)),ChucVuDTO.class);
        }
        return null;
    }

    @Override
    public ChucVuDTO delete(String id) {
        return null;
    }
}
