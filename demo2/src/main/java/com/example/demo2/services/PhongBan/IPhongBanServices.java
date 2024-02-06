package com.example.demo2.services.PhongBan;

import com.example.demo2.modelDTO.PhongBanDTO;

import java.util.List;

public interface IPhongBanServices {
    List<PhongBanDTO> findAll();

    PhongBanDTO findById(Long id);

    PhongBanDTO create(PhongBanDTO phongBanDTO);

    PhongBanDTO update(PhongBanDTO phongBanDTO);

    List<PhongBanDTO> delete(String id);
}
