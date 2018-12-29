package com.example.amin.project2;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amin.adapter.ListViewAdapter;
import com.example.amin.adapter.TruyenAdapter;
import com.example.amin.model.Chuong;
import com.example.amin.model.Truyen;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TruyenActivity extends AppCompatActivity {
    static final String truyenName = "dsTruyenThem.txt";

    TextView txtTenTruyen;
    ImageView imgYeuThich,imgBackMain;

    ViewPager vpTruyen;

    int diChuyen = -1;
    int tl = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truyen);
        getSupportActionBar().hide();   //tạo cho layout full màn hình
        getData();
        if (diChuyen == 1) {
            overridePendingTransition(R.anim.in_left, R.anim.out_left);
        }
        else if (diChuyen == 0){
            overridePendingTransition(R.anim.in_right, R.anim.out_right);
        }
        viewPager();
        addControls();
        addEvents();
        //thông báo
        Toast.makeText(TruyenActivity.this,"Lướt sang phải để xem tóm tắt truyện",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        tl = MainActivity.theLoai;
        MainActivity.truyen = 1;
        MainActivity.chuong = 0;
        MainActivity.tenTruyen = ListViewAdapter.truyenSelected.getTen().toString();
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
        if (bundle !=null) {
            MainActivity.theLoai = bundle.getInt("vitri",0);
            diChuyen = bundle.getInt("diChuyen");
        }

        if (ListViewAdapter.truyenSelected.getDsChuong().size() == 0) {
            getDatabase(ListViewAdapter.truyenSelected);
        }
    }

    private void getDatabase(Truyen truyenSelected) {
        ArrayList<Chuong> dsChuong = new ArrayList<>();
        Cursor cursorChuong = MainActivity.database.rawQuery("select * from truyen,chuong where id=idtruyen and ten=?",new String[]{truyenSelected.getTen()});
        while (cursorChuong.moveToNext()) {
            Chuong chuong = new Chuong();
            chuong.setChuong(cursorChuong.getString(8));
            chuong.setTenChuong(cursorChuong.getString(9));
            chuong.setNoiDung(cursorChuong.getString(10));
            dsChuong.add(chuong);
        }
        cursorChuong.close();
        truyenSelected.setDsChuong(dsChuong);
    }

    private void addEvents() {
        imgYeuThich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 0;
                for (Truyen t : MainActivity.dsTruyenThem) {
                    if (t.getTen().toString().equals(ListViewAdapter.truyenSelected.getTen().toString())) {
                        updateTruyen(ListViewAdapter.truyenSelected);
                        count ++;
                        break;
                    }
                }
                if (count == 0) {
                    updateDatabase(ListViewAdapter.truyenSelected);

                    //thay đổi truyện ngay lập tức (vì truyện chưa được cập nhật ngay từ csdl)
                    if (ListViewAdapter.truyenSelected.getYeuThich() == 1) {
                        ListViewAdapter.truyenSelected.setYeuThich(0);
                        imgYeuThich.setImageResource(R.drawable.dislike);
                    }
                    else {
                        ListViewAdapter.truyenSelected.setYeuThich(1);
                        imgYeuThich.setImageResource(R.drawable.like);
                    }
                }
            }
        });

        imgBackMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        vpTruyen.setPageTransformer(true,new HieuUngViewPager());
    }

    private void updateTruyen(Truyen truyen) {
        if (truyen.getYeuThich() == 1) {
            truyen.setYeuThich(0);
            imgYeuThich.setImageResource(R.drawable.dislike);
        }
        else {
            truyen.setYeuThich(1);
            imgYeuThich.setImageResource(R.drawable.like);
        }
        for (Truyen t : MainActivity.dsTruyenThem) {
            if (t.getTen().toString().equals(truyen.getTen().toString())) {
                MainActivity.dsTruyenThem.remove(t);
                break;
            }
        }
        MainActivity.dsTruyenThem.add(truyen);
        writeTruyenInternal();
    }

    private void writeTruyenInternal() {
        try {
            FileOutputStream fos = openFileOutput(truyenName,MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(MainActivity.dsTruyenThem);
            oos.close();
            fos.close();
        }
        catch (Exception e) {
        }
    }

    private void updateDatabase(Truyen truyen) {
        SQLiteDatabase database = openOrCreateDatabase(MainActivity.DATABASE_NAME,MODE_PRIVATE,null);
        ContentValues value = new ContentValues();
        if (truyen.getYeuThich() == 1) {
            value.put("yeuthich", 0);
            imgYeuThich.setImageResource(R.drawable.dislike);
        }
        else {
            value.put("yeuthich",1);
            imgYeuThich.setImageResource(R.drawable.like);
        }
        database.update("truyen",value,"ten=?",new String[]{truyen.getTen()});
    }

    private void addControls() {
        txtTenTruyen = (TextView) findViewById(R.id.txtTenTruyen);
        txtTenTruyen.setText(ListViewAdapter.truyenSelected.getTen());
        imgYeuThich = (ImageView) findViewById(R.id.imgYeuThich);
        if (ListViewAdapter.truyenSelected.getYeuThich() == 1) {
            imgYeuThich.setImageResource(R.drawable.like);
        }
        else {
            imgYeuThich.setImageResource(R.drawable.dislike);
        }
        imgBackMain = (ImageView) findViewById(R.id.imgBackMain);
    }

    private void viewPager() {
        vpTruyen = (ViewPager) findViewById(R.id.vpTruyen);
        FragmentManager frm = getSupportFragmentManager();
        TruyenAdapter truyenAdapter = new TruyenAdapter(frm);
        vpTruyen.setAdapter(truyenAdapter);
    }

}
