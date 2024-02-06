package com.example.demo2.services.BaoHiemXaHoi;

import com.example.demo2.modelDTO.BaoHiemXaHoiDTO;

import java.util.List;

public interface IBaoHiemXaHoiServices {
    List<BaoHiemXaHoiDTO> findAll();

    BaoHiemXaHoiDTO findById(String maBHXH);

    BaoHiemXaHoiDTO create(BaoHiemXaHoiDTO baoHiemXaHoiDTO);

    BaoHiemXaHoiDTO update(BaoHiemXaHoiDTO baoHiemXaHoiDTO);

    BaoHiemXaHoiDTO delete(String maBHXH);

    Boolean exitsCheckById(String maBHXH);
}
