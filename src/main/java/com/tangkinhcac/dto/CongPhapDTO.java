package com.tangkinhcac.dto;

import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CongPhapDTO {
    private Integer id;
    private String tenCongPhap;
    private String moTa;
    private String phamChat;
    private LocalDate ngayTao;
    private LocalDate ngayCapNhat;
    private String tenLoaiCongPhap;
    private Boolean thatTruyen;
}
