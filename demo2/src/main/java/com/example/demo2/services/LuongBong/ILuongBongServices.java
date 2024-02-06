package com.example.demo2.services.LuongBong;

import com.example.demo2.modelDTO.LuongBongDTO;
import com.example.demo2.modelDTO.NhanVienDTO;

import java.util.List;

public interface ILuongBongServices {
    List<LuongBongDTO> findAll();

    LuongBongDTO findById(Long id);

    LuongBongDTO create(NhanVienDTO nhanVienDTO);

    LuongBongDTO update(LuongBongDTO luongBongDTO);

    List<LuongBongDTO> delete(String id);
}
