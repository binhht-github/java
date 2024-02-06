package com.example.demo2.services.HopDongLaoDong;

import com.example.demo2.modelDTO.HopDongLaoDongDTO;

import java.util.List;

public interface IHopDongLaoDongServices {
    List<HopDongLaoDongDTO> findAll();

    HopDongLaoDongDTO findById(String maHopDongLaoDong);

    HopDongLaoDongDTO create(HopDongLaoDongDTO hopDongLaoDongDTO);

    HopDongLaoDongDTO update(HopDongLaoDongDTO hopDongLaoDongDTO);

    void delete(String maHopDongLaoDong);
}
