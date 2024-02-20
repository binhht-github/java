package com.example.demo2.services.NhanVien;

import com.example.demo2.model.NhanVien;
import com.example.demo2.modelDTO.NhanVienDTO;

import java.util.List;

public interface INhanVienServices {

    List<NhanVienDTO> findAll();

    List<NhanVienDTO> finds();

    NhanVienDTO findById(String maNhanVien);

    NhanVienDTO create(NhanVien nhanVien);

    NhanVienDTO update(NhanVien nhanVien);

    List<NhanVienDTO> delete(String id);

    Boolean exitById (String maNhanVien);

}
