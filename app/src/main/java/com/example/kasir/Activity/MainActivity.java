package com.example.kasir.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.kasir.API.APIRequestDataBarang;
import com.example.kasir.API.RetroServer;
import com.example.kasir.Adapter.BarangAdapter;
import com.example.kasir.Model.BarangModel;
import com.example.kasir.Model.BarangResponseModel;
import com.example.kasir.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvBarang;
    private ProgressBar pbBarang;
    private RecyclerView.Adapter adbarang;
    private RecyclerView.LayoutManager lmBarang;
    private List<BarangModel> listBarang = new ArrayList<>();
    private FloatingActionButton fabTambahData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvBarang = findViewById(R.id.rv_barang);
        pbBarang = findViewById(R.id.pb_barang);
        lmBarang = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        rvBarang.setLayoutManager(lmBarang);
        fabTambahData = findViewById(R.id.fab_add);

        fabTambahData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TambahActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        retrieveBarang();
    }

    public void retrieveBarang() {
        pbBarang.setVisibility(View.VISIBLE);

        APIRequestDataBarang APIBarang = RetroServer.connection().create(APIRequestDataBarang.class);
        Call<BarangResponseModel> proses = APIBarang.ardGetDataBarang();

        proses.enqueue(new Callback<BarangResponseModel>() {
            @Override
            public void onResponse(Call<BarangResponseModel> call, Response<BarangResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();
                listBarang = response.body().getData();

                adbarang = new BarangAdapter(MainActivity.this, listBarang);
                rvBarang.setAdapter(adbarang);
                adbarang.notifyDataSetChanged();
                pbBarang.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<BarangResponseModel> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Gagal mendapatkan data ke server : "+t.getMessage(), Toast.LENGTH_SHORT).show();
                pbBarang.setVisibility(View.GONE);
            }
        });
    }
}