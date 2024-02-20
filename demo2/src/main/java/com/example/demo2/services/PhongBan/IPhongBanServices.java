package com.example.demo2.services.PhongBan;

import com.example.demo2.model.PhongBan;
import com.example.demo2.modelDTO.PhongBanDTO;

import java.util.List;

public interface IPhongBanServices {
    List<PhongBanDTO> findAll();

    PhongBanDTO findById(String id);

    List<PhongBanDTO> findByName(String name);

    PhongBanDTO create(PhongBan phongBan);

    PhongBanDTO update(PhongBan phongBan);

    List<PhongBanDTO> delete(String id);
}
