package com.example.demo2.services.ChucVu;

import com.example.demo2.model.ChucVu;
import com.example.demo2.modelDTO.ChucVuDTO;

import java.util.List;

public interface IChucVuServices {
    List<ChucVuDTO> findAll();

    ChucVuDTO findById(String maChucVu);

    ChucVuDTO create(ChucVu chucVu);

    ChucVuDTO update(ChucVu chucVu);

    ChucVuDTO delete(String id);
}
