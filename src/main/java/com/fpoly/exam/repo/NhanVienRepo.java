package com.fpoly.exam.repo;

import com.fpoly.exam.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NhanVienRepo
    extends JpaRepository<NhanVien, Integer> {
}
