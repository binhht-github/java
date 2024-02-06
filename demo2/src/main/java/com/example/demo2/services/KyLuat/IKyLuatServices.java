package com.example.demo2.services.KyLuat;

import com.example.demo2.modelDTO.KyLuatDTO;

import java.util.Date;
import java.util.List;

public interface IKyLuatServices {
    List<KyLuatDTO> findAll();

    KyLuatDTO findById(Long id);

    KyLuatDTO create(KyLuatDTO kyLuatDTO);

    KyLuatDTO update(KyLuatDTO kyLuatDTO);

    float tinhLuongKyLuat(Date thang);

    List<KyLuatDTO> delete(String id);
}
