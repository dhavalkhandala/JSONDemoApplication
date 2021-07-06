package com.example.jsondemoapplication.retrofit;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FoodAPI {

    @GET("/json/shimmer/menu.php")
    Call<ResponseBody> getMenu();

}
