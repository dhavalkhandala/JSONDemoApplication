package com.example.jsondemoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String strJson="{ \"Employee\" :[{\"id\":\"101\",\"name\":\"Sonoo Jaiswal\",\"salary\":{\"id\":\"101\",\"name\":\"Sonoo Jaiswal\",\"salary\":\"50000\"}}}," +
            "{\"id\":\"102\",\"name\":\"Vimal Jaiswal\",\"salary\":{\"id\":\"101\",\"name\":\"Sonoo Jaiswal\",\"salary\":\"50000\"}}}] }";
    String data="";
    TextView textView;
    DataModel model;
    List<DataModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=new ArrayList<>();
        try {
            JSONObject jsonObject=new JSONObject(strJson);
            JSONArray jsonArray=jsonObject.getJSONArray("Employee");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object=jsonArray.getJSONObject(i);
                String id=object.getString("id");
                String name=object.getString("name");
                JSONObject salary=object.getJSONObject("salary");
                String id1=salary.getString("id");
             //   model=new DataModel(id[i],)
                list.add(model);
                data += "Node"+i+" : \n id= "+ id +" \n Name= "+ name +" \n Salary= "+ salary +" \n ";
            }
            textView.setText(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}