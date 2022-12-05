package com.example.kasir.API;

import com.example.kasir.Model.BarangResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIRequestDataBarang {
    @GET("retrieve.php")
    Call<BarangResponseModel> ardGetDataBarang();

    @FormUrlEncoded
    @POST("create.php")
    Call<BarangResponseModel> ardCreateDataBarang(
            @Field("nama") String nama,
            @Field("jumlah") int jumlah,
            @Field("harga") int harga
    );
}
