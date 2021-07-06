package com.example.jsondemoapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VolleyActivity extends AppCompatActivity {

    private static final String TAG = "VolleyActivity";
    String url="https://api.androidhive.info/json/movies.json";
    String data = "";
    DataModel model;
    List<DataModel> list = new ArrayList<DataModel>();
    RecyclerView recyclerView;
    DataAdapter adapter;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        list=new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        textView = findViewById(R.id.tx);
        StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
//                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray = new JSONArray(response);
                    for(int i = 0; i < jsonArray.length(); i++) {
                        JSONArray moviedetails = jsonArray.getJSONArray(i);
                        String title = moviedetails.getString(i);
                        int imageurl = moviedetails.getInt(i);
                        double rating = moviedetails.getDouble(i);
                        int year = moviedetails.getInt(i);
                        Log.d(TAG,title);
                        textView.setText(title);
//                        JSONArray genreArry = moviedetails.getJSONArray(i);
//                        ArrayList<String> genre = new ArrayList<String>();
//                        for (int j = 0; j < genreArry.length(); j++) {
//                            genre.add((String) genreArry.get(j));
//                        }
//
//                        DataAdapter adapter = new DataAdapter(VolleyActivity.this,list);
//                        recyclerView.setLayoutManager(new LinearLayoutManager(VolleyActivity.this));
//                        recyclerView.setAdapter(adapter);

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.d(TAG, "onResponse: "+response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: ",error );
            }
        });
        RequestQueue queue= Volley.newRequestQueue(this);
        queue.add(request);
    }
}