package com.tangkinhcac.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "dang_nhap")
public class DangNhap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ten_dang_nhap", nullable = false, length = 100)
    private String tenDangNhap;

    @Column(name = "mat_khau", nullable = false, length = 100)
    private String matKhau;

    @ColumnDefault("0")
    @Column(name = "admin")
    private Boolean admin;

}