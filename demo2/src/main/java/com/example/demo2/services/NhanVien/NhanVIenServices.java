package com.example.demo2.services.NhanVien;

import com.example.demo2.modelDTO.NhanVienDTO;
import com.example.demo2.repository.NhanVienRepository;
import com.example.demo2.until.ModelMapperUntils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVIenServices implements INhanVienServices{
    @Autowired
    ModelMapperUntils mapper;
    @Autowired
    NhanVienRepository repository;

    @Override
    public List<NhanVienDTO> findAll() {
        return mapper.mapList(repository.findAll(),NhanVienDTO.class);
    }

    @Override
    public NhanVienDTO findById(String maNhanVien) {
        System.out.println(maNhanVien);
        if (repository.existsById(maNhanVien)){
            System.out.println(repository.findById(maNhanVien));
            return mapper.mapItem(repository.findById(maNhanVien).get(),NhanVienDTO.class);
        }

        return null;
    }

    @Override
    public NhanVienDTO create(NhanVienDTO nhanVienDTO) {
        return null;
    }

    @Override
    public NhanVienDTO update(NhanVienDTO nhanVienDTO) {
        return null;
    }

    @Override
    public List<NhanVienDTO> delete(String id) {
        return null;
    }

    @Override
    public Boolean exitById(String maNhanVien) {
        return repository.existsById(maNhanVien);
    }
}
