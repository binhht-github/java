package com.example.demo2.services.ChamCong;

import com.example.demo2.model.ChamCong;
import com.example.demo2.modelDTO.ChamCongDTO;
import com.example.demo2.modelDTO.ChamCongStatisticsDTO;

import java.util.Date;
import java.util.List;

public interface IChamCongServices {
    List<ChamCongDTO> findAll();

    ChamCongDTO findById(String maChamCong);

    ChamCongDTO findByNhanVien(String maNhanVien);

    List<ChamCongDTO> findByNhanVienFromTo(String maNhanVien, Date start, Date end);

    ChamCongDTO create(ChamCong chamCong);

    ChamCongDTO update(ChamCong chamCong);

    ChamCongDTO delete(String maChamCong);

    Boolean exitsCheckById(String maChamCong);

    List<ChamCongStatisticsDTO> getChamCongStatisDTO(Date month);
}
