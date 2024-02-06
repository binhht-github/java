package com.example.demo2.services.KyLuat;

import com.example.demo2.model.KyLuat;
import com.example.demo2.modelDTO.KyLuatDTO;
import com.example.demo2.repository.KyLuatRepository;
import com.example.demo2.until.ModelMapperUntils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KyLuatServices implements IKyLuatServices{
    @Autowired
    ModelMapperUntils mapper;
    @Autowired
    KyLuatRepository repository;

    @Override
    public List<KyLuatDTO> findAll() {
        return mapper.mapList(repository.findAll(),KyLuatDTO.class);
    }

    @Override
    public KyLuatDTO findById(Long id) {
        if (repository.existsById(id)){
            return mapper.mapItem(repository.findById(id),KyLuatDTO.class);
        }
        return null;
    }

    @Override
    public KyLuatDTO create(KyLuatDTO kyLuatDTO) {
        if (!repository.existsById(kyLuatDTO.getId())){
            return mapper.mapItem(repository.save(mapper.mapItem(kyLuatDTO, KyLuat.class)),KyLuatDTO.class);
        }
        return null;
    }

    @Override
    public KyLuatDTO update(KyLuatDTO kyLuatDTO) {
        if (repository.existsById(kyLuatDTO.getId())){
            return mapper.mapItem(repository.save(mapper.mapItem(kyLuatDTO, KyLuat.class)),KyLuatDTO.class);
        }
        return null;
    }

    @Override
    public float tinhLuongKyLuat(Date thang) {
        float total=0;
        List<KyLuat> list =new ArrayList<>();
        for(KyLuat s : list){
            total=total+s.getMucPhat();
        }
//        total = (float) list.stream().map(item -> item.getMucPhat()).collect(Collectors.toList());
        return 0;
    }

    @Override
    public List<KyLuatDTO> delete(String id) {
        return null;
    }
}
