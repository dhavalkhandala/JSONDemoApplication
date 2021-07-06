package com.example.jsondemoapplication.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIObject {

    private static FoodAPI foodAPI=null;

    public static FoodAPI getInstance(){
        if (foodAPI==null){
        Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.androidhive.info")
                .build();

        foodAPI=retrofit.create(FoodAPI.class);
        }
        return foodAPI;
    }
}
