package com.example.demo2.services.ChamCong;

import com.example.demo2.modelDTO.ChamCongDTO;

import java.util.List;

public interface IChamCongServices {
    List<ChamCongDTO> findAll();

    ChamCongDTO findById(String maChamCong);

    ChamCongDTO create(ChamCongDTO chamCongDTO);

    ChamCongDTO update(ChamCongDTO chamCongDTO);

    ChamCongDTO delete(String maChamCong);

    Boolean exitsCheckById(String maChamCong);
}
