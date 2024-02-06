package com.example.demo2.services.HopDongLaoDong;

import com.example.demo2.model.HopDongLaoDong;
import com.example.demo2.modelDTO.HopDongLaoDongDTO;
import com.example.demo2.repository.HopDongLaoDongRepository;
import com.example.demo2.until.ModelMapperUntils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HopDongLaoDongServices implements IHopDongLaoDongServices{
    @Autowired
    ModelMapperUntils mapper;

    @Autowired
    HopDongLaoDongRepository repository;


    @Override
    public List<HopDongLaoDongDTO> findAll() {
        return mapper.mapList(repository.findAll(),HopDongLaoDongDTO.class);
    }

    @Override
    public HopDongLaoDongDTO findById(String maHopDongLaoDong) {
        if (repository.existsById(maHopDongLaoDong)){
            return mapper.mapItem(repository.findById(maHopDongLaoDong),HopDongLaoDongDTO.class);
        }
        return null;
    }

    @Override
    public HopDongLaoDongDTO create(HopDongLaoDongDTO hopDongLaoDongDTO) {
        if (!repository.existsById(hopDongLaoDongDTO.getMaHopDongLaoDong())){
            return mapper.mapItem(repository.save(mapper.mapItem(hopDongLaoDongDTO, HopDongLaoDong.class)),HopDongLaoDongDTO.class);
        }
        return null;
    }

    @Override
    public HopDongLaoDongDTO update(HopDongLaoDongDTO hopDongLaoDongDTO) {
        if (repository.existsById(hopDongLaoDongDTO.getMaHopDongLaoDong())){
            return mapper.mapItem(repository.save(mapper.mapItem(hopDongLaoDongDTO, HopDongLaoDong.class)),HopDongLaoDongDTO.class);
        }
        return null;
    }

    @Override
    public void delete(String maHopDongLaoDong) {

    }
}
