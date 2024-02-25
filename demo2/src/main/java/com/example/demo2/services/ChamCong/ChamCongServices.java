package com.example.demo2.services.ChamCong;

import com.example.demo2.model.ChamCong;
import com.example.demo2.modelDTO.ChamCongDTO;
import com.example.demo2.modelDTO.ChamCongStatisticsDTO;
import com.example.demo2.repository.ChamCongRepository;
import com.example.demo2.until.ModelMapperUntils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        System.out.println("services "+maChamCong);
        if (repository.existsById(maChamCong)){
            System.out.println("check "+repository.findById(maChamCong));
            return mapper.mapItem(repository.findById(maChamCong).get(),ChamCongDTO.class);
        }
        return  null;
    }

    @Override
    public ChamCongDTO findByNhanVien(String maNhanVien) {
        return null;
    }

    @Override
    public List<ChamCongDTO> findByNhanVienFromTo(String maNhanVien, Date start, Date end) {
        return null;
    }

    @Override
    public ChamCongDTO create(ChamCong chamCong) {
        chamCong.setNgayChamCong(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmssSSS");
        String dateStr = sdf.format(chamCong.getNgayChamCong());
        String hexStr = Long.toHexString(Long.parseLong(dateStr));
        chamCong.setMaChamCong(chamCong.getLoaiChamCong().toUpperCase()+chamCong.getNhanVien().getMaNhanVien()+hexStr);
        if (!repository.existsById(chamCong.getMaChamCong())){
            return mapper.mapItem(repository.save(chamCong),ChamCongDTO.class);
        }
        return null;
    }

    @Override
    public ChamCongDTO update(ChamCong chamCong) {
//        if (repository.existsById(chamCongDTO.getMaChamCong())){
//            return mapper.mapItem(repository.save(mapper.mapItem(chamCongDTO, ChamCong.class)),ChamCongDTO.class);
//        }
//        return chamCongDTO;
        return null;
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

    @Override
    public List<ChamCongStatisticsDTO> getChamCongStatisDTO(Date month) {
//        System.out.println(
//               mapper.mapList(repository.getChamCongStatistic(month),ChamCongStatisticsDTO.class) );
//
//        List<ChamCongStatisticsDTO> li= new ArrayList<>();

//        return repository.getChamCongStatistic(month);
        return  mapper.mapList(repository.getChamCongStatistic(month),ChamCongStatisticsDTO.class);
    }
}
