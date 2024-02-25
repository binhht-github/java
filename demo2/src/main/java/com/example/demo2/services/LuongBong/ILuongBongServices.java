package com.example.demo2.services.LuongBong;

import com.example.demo2.modelDTO.LuongBongDTO;
import com.example.demo2.modelDTO.NhanVienDTO;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface ILuongBongServices {
    List<LuongBongDTO> findAllByNhanViens(Date month) throws ParseException;

    LuongBongDTO create(NhanVienDTO nhanVienDTO);
}
