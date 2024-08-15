package com.fpoly.exam.controller;

import com.fpoly.exam.entity.NhanVien;
import com.fpoly.exam.repo.NhanVienRepo;
import com.fpoly.exam.request.NhanVienRequest;
import com.fpoly.exam.response.NhanVienResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NhanVienController {
    @Autowired NhanVienRepo repo;

    @GetMapping("/nhan-vien/danh-sach")
    public List<NhanVienResponse> getDanhSach(){
        List<NhanVien> list = repo.findAll();
        List<NhanVienResponse> result = new ArrayList<>();
        for(NhanVien nv : list){
            result.add(new NhanVienResponse(nv));
        }
        return result;
    }

    @GetMapping("/nhan-vien/phan-trang")
    public List<NhanVien> phanTrang(@RequestParam(defaultValue = "0")int p){
        Pageable pageable = PageRequest.of(p, 5);
        Page<NhanVien> page = repo.findAll(pageable);
        return page.getContent();
    }

    @PutMapping("/nhan-vien/update/{id}")
    public NhanVien update(@PathVariable int id, @Valid @RequestBody NhanVienRequest body){
        NhanVien nhanVien = body.toEntity();
        nhanVien.setId(id);
        repo.save(nhanVien);
        return  nhanVien;
    }

    @GetMapping("/nhan-vien/detail/{id}")
    public NhanVien getDetail(@PathVariable int id){
        return repo.findById(id)
                .orElse(null);
    }
}
