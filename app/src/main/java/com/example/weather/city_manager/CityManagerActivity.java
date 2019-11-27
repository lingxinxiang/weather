
package com.example.weather.city_manager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weather.R;
import com.example.weather.db.DBManager;
import com.example.weather.db.DatabaseBean;

import java.util.ArrayList;
import java.util.List;

public class CityManagerActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView addIv, backIv, deleteIv;
    ListView cityLv;
    List<DatabaseBean> mDatas; //显示列表数据源

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_manager);
        addIv = findViewById(R.id.city_iv_add);
        backIv = findViewById(R.id.city_iv_back);
        deleteIv = findViewById(R.id.city_iv_delete);
        cityLv = findViewById(R.id.city_lv);
        mDatas = new ArrayList<>();
        //添加点击监听事情
        addIv.setOnClickListener(this);
        deleteIv.setOnClickListener(this);
        backIv.setOnClickListener(this);
        //设置适配器


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.city_iv_add:
                int cityCount = DBManager.getCityCount();
                if (cityCount < 5) {
                    Intent intent = new Intent(this, SearchCityActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "存储城市数量已达上限，请删除后再添加", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.city_iv_back:
                finish();
                break;
            case R.id.city_iv_delete:
                //删除页面跳转
                Intent intent1 = new Intent(this, DeleteCityActivity.class);
                startActivity(intent1);
                break;

        }

    }
}