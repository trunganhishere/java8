package com.fpoly.exam.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="chuc_vu")
@Data
public class ChucVu {
    @Id Integer id;
    String ma;
    String ten;
}
