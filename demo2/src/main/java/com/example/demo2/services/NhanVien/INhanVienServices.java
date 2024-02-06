package com.example.demo2.services.NhanVien;

import com.example.demo2.modelDTO.NhanVienDTO;

import java.util.List;

public interface INhanVienServices {

    List<NhanVienDTO> findAll();

    NhanVienDTO findById(String maNhanVien);

    NhanVienDTO create(NhanVienDTO nhanVienDTO);

    NhanVienDTO update(NhanVienDTO nhanVienDTO);

    List<NhanVienDTO> delete(String id);

    Boolean exitById (String maNhanVien);

}
