package com.tangkinhcac.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cong_phap")
@ToString
public class CongPhap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "ten_cong_phap", nullable = false, length = 100)
    private String tenCongPhap;

    @Lob
    @Nationalized
    @Column(name = "mo_ta")
    private String moTa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pham_chat")
    private PhamChat phamChat;

    @Column(name = "ngay_tao")
    private LocalDate ngayTao;

    @Column(name = "ngay_cap_nhat")
    private LocalDate ngayCapNhat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_loai_cong_phap")
    private LoaiCongPhap loaiCongPhap;

    @ColumnDefault("0")
    @Column(name = "that_truyen")
    private Boolean thatTruyen;

}