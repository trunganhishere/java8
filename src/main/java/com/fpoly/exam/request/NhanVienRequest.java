package com.fpoly.exam.request;

import com.fpoly.exam.entity.ChucVu;
import com.fpoly.exam.entity.NhanVien;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NhanVienRequest {
    Integer id;

    @NotBlank
    String ma;

    @NotBlank
    String ho;

    @NotBlank
    String tendem;

    @NotBlank
    String ten;

    @NotBlank
    String gioitinh;

    @NotBlank
    String diachi;

    @NotNull
    Integer idCv;

    public NhanVien toEntity(){
        NhanVien nv = new NhanVien();
        nv.setId(id);
        nv.setMa(ma);
        nv.setHo(ho);
        nv.setTen(ten);
        nv.setTen_dem(tendem);
        nv.setGioi_tinh(gioitinh);
        nv.setDia_chi(diachi);
        if(idCv != null){
            ChucVu cv = new ChucVu();
            cv.setId(idCv);
            nv.setChucVu(cv);
        }
        return nv;
    }
}
