package com.example.amin.project2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.amin.adapter.GridViewAdapter;
import com.example.amin.adapter.ListViewAdapter;
import com.example.amin.model.Truyen;

import java.util.ArrayList;

public class TheLoaiActivity extends AppCompatActivity {

    ListView lvDanhSach;
    GridView gvDanhSach;
    ArrayList<Truyen> dsTruyenTheLoai = MainActivity.dsTruyenTheLoai;
    ListViewAdapter listViewAdapter;
    GridViewAdapter gridViewAdapter;

    ImageView imgTheLoai,imgBackMain;
    boolean viewTheLoai = true;

    TextView txtTheLoai;
    String theLoai = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_loai);
        getSupportActionBar().hide();   //tạo cho layout full màn hình
        getData();
        overridePendingTransition(R.anim.in_left, R.anim.out_left);
        addControls();
        addEvents();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MainActivity.theLoai = 1;
        MainActivity.truyen = 0;
        MainActivity.chuong = 0;
        MainActivity.tenTheLoai = theLoai;
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("TrangThaiLuuTru",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("TheLoai",MainActivity.theLoai);
        editor.putInt("Truyen",MainActivity.truyen);
        editor.putInt("Chuong",MainActivity.chuong);
        editor.putInt("SoChuong",MainActivity.soChuong);
        editor.putString("TenTruyen",MainActivity.tenTruyen);
        editor.putString("TenTheLoai",MainActivity.tenTheLoai);
        editor.commit();
    }

    private void getData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            theLoai = (String) bundle.getCharSequence("theloai");
        }
    }

    private void addEvents() {
        gvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(TheLoaiActivity.this, TruyenActivity.class);
                ListViewAdapter.truyenSelected = MainActivity.dsTruyen.get(i);
                startActivity(intent);
            }
        });

        imgTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewTheLoai == true) {
                    lvDanhSach.setAdapter(null);
                    gvDanhSach.setAdapter(gridViewAdapter);
                    imgTheLoai.setImageResource(R.drawable.grid_view);
                    viewTheLoai = false;
                } else {
                    gvDanhSach.setAdapter(null);
                    lvDanhSach.setAdapter(listViewAdapter);
                    imgTheLoai.setImageResource(R.drawable.list_view);
                    viewTheLoai = true;
                }
            }
        });

        imgBackMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(TheLoaiActivity.this,MainActivity.class);
//                startActivity(intent);
                finish();
            }
        });
    }

    private void addControls() {
        lvDanhSach = (ListView) findViewById(R.id.lvDanhSach);
        gvDanhSach = (GridView) findViewById(R.id.gvDanhSach);
        listViewAdapter = new ListViewAdapter(TheLoaiActivity.this,R.layout.item_list_view,dsTruyenTheLoai);
        gridViewAdapter = new GridViewAdapter(TheLoaiActivity.this,R.layout.item_grid_view,dsTruyenTheLoai);
        lvDanhSach.setAdapter(listViewAdapter);

        imgTheLoai = (ImageView) findViewById(R.id.imgTheLoai);
        imgBackMain = (ImageView) findViewById(R.id.imgBackMain);

        txtTheLoai = (TextView) findViewById(R.id.txtTheLoai);
        txtTheLoai.setText(theLoai);
    }
}
