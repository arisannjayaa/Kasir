package com.example.kasir.Model;

public class BarangModel {
    private int kode_barang, jumlah, harga, total_bayar;
    private String nama_barang, tgl_pembelian;

    public int getKode_barang() {
        return kode_barang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getHarga() {
        return harga;
    }

    public int getTotal_bayar() {
        return total_bayar;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public String getTgl_pembelian() {
        return tgl_pembelian;
    }
}
