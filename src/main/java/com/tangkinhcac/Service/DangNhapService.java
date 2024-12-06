package com.tangkinhcac.Service;

import com.tangkinhcac.model.DangNhap;
import com.tangkinhcac.repository.DangNhapRepo;

public class DangNhapService {
    private DangNhapRepo dangNhapRepo = new DangNhapRepo();

    public DangNhap getByNameAndPass(String username, String password) {
        try {
            return dangNhapRepo.getByNameAndPass(username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
