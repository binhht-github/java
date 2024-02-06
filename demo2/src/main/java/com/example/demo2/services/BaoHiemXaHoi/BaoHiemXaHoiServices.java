package com.example.demo2.services.BaoHiemXaHoi;

import com.example.demo2.model.BaoHiemXaHoi;
import com.example.demo2.modelDTO.BaoHiemXaHoiDTO;
import com.example.demo2.repository.BaoHiemXaHoiRepository;
import com.example.demo2.until.ModelMapperUntils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaoHiemXaHoiServices implements IBaoHiemXaHoiServices{

    @Autowired
    ModelMapperUntils mapper;

    @Autowired
    BaoHiemXaHoiRepository repository;

    @Override
    public List<BaoHiemXaHoiDTO> findAll() {
      List<BaoHiemXaHoi> list = repository.findAll();
      return mapper.mapList(list,BaoHiemXaHoiDTO.class);
    }

    @Override
    public BaoHiemXaHoiDTO findById(String maBHXH) {
        if (repository.existsById(maBHXH)){
            return mapper.mapItem(repository.findById(maBHXH).get(),BaoHiemXaHoiDTO.class);
        }
        return null;
    }

    @Override
    public BaoHiemXaHoiDTO create(BaoHiemXaHoiDTO baoHiemXaHoiDTO) {
        if (!repository.existsById(baoHiemXaHoiDTO.getMaBHXH())){
            //create repository.save(mapper.mapItem(baoHiemXaHoiDTO,BaoHiemXaHoi.class))
            return mapper.mapItem(repository.save(mapper.mapItem(baoHiemXaHoiDTO,BaoHiemXaHoi.class)),BaoHiemXaHoiDTO.class);
        }
        return baoHiemXaHoiDTO;
    }

    @Override
    public BaoHiemXaHoiDTO update(BaoHiemXaHoiDTO baoHiemXaHoiDTO) {
        if (repository.existsById(baoHiemXaHoiDTO.getMaBHXH())){
            //update repository.save(mapper.mapItem(baoHiemXaHoiDTO,BaoHiemXaHoi.class))
            return mapper.mapItem(repository.save(mapper.mapItem(baoHiemXaHoiDTO,BaoHiemXaHoi.class)),BaoHiemXaHoiDTO.class);
        }
        return baoHiemXaHoiDTO;
    }

    @Override
    public BaoHiemXaHoiDTO delete(String maBHXH) {
        BaoHiemXaHoiDTO item = new BaoHiemXaHoiDTO();
        if (repository.existsById(maBHXH)){
            item = findById(maBHXH);
            //update repository.save(mapper.mapItem(baoHiemXaHoiDTO,BaoHiemXaHoi.class))
            repository.delete(mapper.mapItem(item,BaoHiemXaHoi.class));
        }
        return item;
    }

    @Override
    public Boolean exitsCheckById(String maBHXH) {
        return repository.existsById(maBHXH);
    }


}
