package com.example.kasir.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kasir.Model.BarangModel;
import com.example.kasir.R;

import java.util.List;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.HolderBarang>{
    private Context ctx;
    private List<BarangModel> listBarang;

    public BarangAdapter(Context ctx, List<BarangModel> listBarang) {
        this.ctx = ctx;
        this.listBarang = listBarang;
    }

    @NonNull
    @Override
    public HolderBarang onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_barang, parent, false);
        HolderBarang holder = new HolderBarang(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderBarang holder, int position) {
        BarangModel BM = listBarang.get(position);
//        holder.tvKodeBarang.setText(String.valueOf(BM.getKode_barang()));
        holder.tvNamaBarang.setText(BM.getNama_barang());
        holder.tvJumlah.setText(String.valueOf(BM.getJumlah()));
        holder.tvHarga.setText(String.valueOf(BM.getHarga()));
//        holder.tvTotalBayar.setText(String.valueOf(BM.getTotal_bayar()));
        holder.tvTglPembelian.setText(BM.getTgl_pembelian());
    }

    @Override
    public int getItemCount() {
        return listBarang.size();
    }

    public class HolderBarang extends RecyclerView.ViewHolder {
        TextView tvKodeBarang, tvNamaBarang, tvJumlah, tvHarga, tvTotalBayar, tvTglPembelian;
        public HolderBarang(@NonNull View itemView) {
            super(itemView);

//            tvKodeBarang =  itemView.findViewById(R.id.tv_kode_barang);
            tvNamaBarang = itemView.findViewById(R.id.tv_nama_barang);
            tvJumlah = itemView.findViewById(R.id.tv_jumlah);
            tvHarga = itemView.findViewById(R.id.tv_harga);
//            tvTotalBayar = itemView.findViewById(R.id.tv_total_bayar);
            tvTglPembelian = itemView.findViewById(R.id.tv_tgl_pembelian);

        }
    }
}
