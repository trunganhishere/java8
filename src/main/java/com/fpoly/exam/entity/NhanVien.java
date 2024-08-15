package com.fpoly.exam.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="nhan_vien")
@Data
public class NhanVien {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;

    @NotBlank
    String ma;

    @NotBlank
    String ho;

    @NotBlank
    String ten_dem;

    @NotBlank
    String ten;

    @NotBlank
    String gioi_tinh;

    @NotBlank
    String dia_chi;

    @NotNull
    @ManyToOne @JoinColumn(name="id_cv")
    ChucVu chucVu;

    public String getHo_ten(){
        return ho + " " + ten_dem + " " + ten;
    }

}
