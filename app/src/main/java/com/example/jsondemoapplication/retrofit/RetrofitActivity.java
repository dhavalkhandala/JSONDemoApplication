package com.example.jsondemoapplication.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.jsondemoapplication.R;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {

    private static final String TAG = "RetrofitActivity";
    List<FoodModel> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        APIObject.getInstance().getMenu().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {

                    list=new Gson().fromJson(response.body().string(),new TypeToken<List<FoodModel>>(){}.getType());

//                    JSONArray jsonArray=new JSONArray(response.body().string());
//                    for (int i=0;i<jsonArray.length();i++){
//                        FoodModel foodModel=new Gson().fromJson(jsonArray.getJSONObject(i).toString(),FoodModel.class);
//                        list.add(foodModel);
//                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}