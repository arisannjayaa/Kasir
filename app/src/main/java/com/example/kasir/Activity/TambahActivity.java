package com.example.kasir.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kasir.API.APIRequestDataBarang;
import com.example.kasir.API.RetroServer;
import com.example.kasir.Adapter.BarangAdapter;
import com.example.kasir.Model.BarangResponseModel;
import com.example.kasir.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahActivity extends AppCompatActivity {
    private EditText etNamaBarang, etJumlah, etHarga, etTotalBayar, etTglPembelian;
    private String namaBarang, tglPembelian;
    private int jumlah, harga, totalBayar;
    private Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etNamaBarang = findViewById(R.id.et_nama_barang);
        etJumlah = findViewById(R.id.et_jumlah);
        etHarga = findViewById(R.id.et_harga);
        etTotalBayar = findViewById(R.id.et_total_bayar);
        etTglPembelian = findViewById(R.id.et_tgl_pembelian);
        btnSimpan = findViewById(R.id.btn_simpan);

         btnSimpan.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 namaBarang = etNamaBarang.getText().toString();
                 jumlah = Integer.parseInt(etJumlah.getText().toString());
                 harga = Integer.parseInt(etHarga.getText().toString());
                 totalBayar = Integer.parseInt(etTotalBayar.getText().toString());
                 tglPembelian = etTglPembelian.getText().toString();

                 createBarang();
             }
         });
    }

    public void createBarang() {

        APIRequestDataBarang APIBarang = RetroServer.connection().create(APIRequestDataBarang.class);
        Call<BarangResponseModel> proses = APIBarang.ardCreateDataBarang(namaBarang, jumlah, harga, totalBayar, tglPembelian);

        proses.enqueue(new Callback<BarangResponseModel>() {
            @Override
            public void onResponse(Call<BarangResponseModel> call, Response<BarangResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(TambahActivity.this, "Kode : "+kode+" Pesan : "+pesan, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<BarangResponseModel> call, Throwable t) {
                Toast.makeText(TambahActivity.this,"Gagal mendapatkan data ke server : "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}