package com.example.demo2.services.ChucVu;

import com.example.demo2.modelDTO.ChucVuDTO;

import java.util.List;

public interface IChucVuServices {
    List<ChucVuDTO> findAll();

    ChucVuDTO findById(String maChucVu);

    ChucVuDTO create(ChucVuDTO chucVuDTO);

    ChucVuDTO update(ChucVuDTO chucVuDTO);

    ChucVuDTO delete(String id);
}
