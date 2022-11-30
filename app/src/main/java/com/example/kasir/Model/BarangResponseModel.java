package com.example.kasir.Model;

import java.util.List;

public class BarangResponseModel {
    private int kode;
    private String pesan;
    private List<BarangModel> data;

    public int getKode() {
        return kode;
    }

    public String getPesan() {
        return pesan;
    }

    public List<BarangModel> getData() {
        return data;
    }
}
