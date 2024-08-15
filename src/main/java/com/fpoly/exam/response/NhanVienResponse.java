package com.fpoly.exam.response;

import com.fpoly.exam.entity.NhanVien;
import lombok.Data;

@Data
public class NhanVienResponse {
    Integer id;
    String ma;
    String hoten;
    String gioitinh;
    String diachi;
    String chucvu;

    public NhanVienResponse(NhanVien nv){
        id = nv.getId();
        ma = nv.getMa();
        hoten = nv.getHo_ten();
        gioitinh = nv.getGioi_tinh();
        diachi = nv.getDia_chi();
        if(nv.getChucVu() != null){
            chucvu = nv.getChucVu().getTen();
        }
    }
}
