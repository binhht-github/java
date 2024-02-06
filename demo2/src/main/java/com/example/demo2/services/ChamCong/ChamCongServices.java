package com.example.demo2.services.ChamCong;

import com.example.demo2.model.ChamCong;
import com.example.demo2.modelDTO.ChamCongDTO;
import com.example.demo2.repository.ChamCongRepository;
import com.example.demo2.until.ModelMapperUntils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamCongServices implements IChamCongServices{

    @Autowired
    ModelMapperUntils mapper;

    @Autowired
    ChamCongRepository repository;


    @Override
    public List<ChamCongDTO> findAll() {
        return mapper.mapList(repository.findAll(),ChamCongDTO.class);
    }

    @Override
    public ChamCongDTO findById(String maChamCong) {
        if (repository.existsById(maChamCong)){
            return mapper.mapItem(repository.findById(maChamCong),ChamCongDTO.class);
        }
        return  null;
    }

    @Override
    public ChamCongDTO create(ChamCongDTO chamCongDTO) {

        if (!repository.existsById(chamCongDTO.getMaChamCong())){
            return mapper.mapItem(repository.save(mapper.mapItem(chamCongDTO, ChamCong.class)),ChamCongDTO.class);
        }
        return chamCongDTO;
    }

    @Override
    public ChamCongDTO update(ChamCongDTO chamCongDTO) {
        if (repository.existsById(chamCongDTO.getMaChamCong())){
            return mapper.mapItem(repository.save(mapper.mapItem(chamCongDTO, ChamCong.class)),ChamCongDTO.class);
        }
        return chamCongDTO;
    }

    @Override
    public ChamCongDTO delete(String maChamCong) {
        if (repository.existsById(maChamCong)){
            repository.deleteById(maChamCong);
        }
        return null;
    }

    @Override
    public Boolean exitsCheckById(String maChamCong) {
        return repository.existsById(maChamCong);
    }
}
