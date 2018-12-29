package com.example.amin.project2;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.amin.adapter.ChuongAdapter;
import com.example.amin.adapter.ListViewAdapter;
import com.example.amin.model.*;

import java.util.ArrayList;
import java.util.StringTokenizer;


public class ChuongActivity extends AppCompatActivity {

    ViewPager vpChuong;

    int kiemTra = 0;
    public static int chuongSelected;
    String noiDungBanDau;

    TextView txtTenChuong;
    ImageView imgBackTruyen;

    ScaleGestureDetector scaleGestureDetector;
    ChuongAdapter chuongAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuong);
        getSupportActionBar().hide();   //tạo cho layout full màn hình
        overridePendingTransition(R.anim.in_left,R.anim.out_left);
        getData();
        viewPager();
        addControls();
        addEvents();
        zoomTextView();
    }

    private void zoomTextView() {
        scaleGestureDetector = new ScaleGestureDetector(ChuongActivity.this, new simpleOnScaleGestureListener());
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        super.dispatchTouchEvent(ev);
        return scaleGestureDetector.onTouchEvent(ev);
    }

    public class simpleOnScaleGestureListener extends
            ScaleGestureDetector.SimpleOnScaleGestureListener {

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            // TODO Auto-generated method stub
            for (int i=0; i < vpChuong.getChildCount();++i) {
                TextView txt = (TextView) vpChuong.getChildAt(i).findViewById(R.id.txtNoiDung);
                float size = txt.getTextSize();
                float factor = detector.getScaleFactor();
                float product = size * factor;
                txt.setTextSize(TypedValue.COMPLEX_UNIT_PX, product);
            }

            return true;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.theLoai = 0;
        MainActivity.truyen = 0;
        MainActivity.chuong = 1;
        MainActivity.soChuong = vpChuong.getCurrentItem();

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
            chuongSelected = bundle.getInt("chuong",0);
        }
//        dsChuong = ListViewAdapter.truyenSelected.getDsChuong();

    }

    private void addEvents() {
        vpChuong.setPageTransformer(true,new HieuUngViewPager());

        vpChuong.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                txtTenChuong.setText(ListViewAdapter.truyenSelected.getDsChuong().get(position).getTenChuong());
//                noiDungBanDau = ListViewAdapter.truyenSelected.getDsChuong().get(position).getNoiDung();
//                if (kiemTra == 0) {
////                    vpChuong.setCurrentItem(position);
//                }
//                else {
//                    ListViewAdapter.truyenSelected.getDsChuong().get(chuongSelected).setNoiDung(noiDungBanDau);
//                    chuongAdapter.notifyDataSetChanged();
//                    kiemTra = 0;
//                }
                chuongSelected = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

//        imgMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (kiemTra == 0) {
//                    String noiDungKiemTra = "";
//                    String[] arrKiemTra = ListViewAdapter.truyenSelected.getDsChuong().get(chuongSelected).getNoiDung().toString().split(" ");
//                    for (int i = 0;i < arrKiemTra.length;++i) {
//                        KiemTraChinhTa kiemTra = new KiemTraChinhTa();
//                        if (!kiemTra.kiemTraChinhTa(arrKiemTra[i])) {
//                            arrKiemTra[i] = "<span style=\"color: red\">"+arrKiemTra[i]+"</span>";
//                        }
//                    }
//
//                    for (int i = 0;i < arrKiemTra.length;++i) {
//                        noiDungKiemTra += arrKiemTra[i]+" ";
//                    }
//                    Log.i("noidung",noiDungKiemTra);
//
//                    ListViewAdapter.truyenSelected.getDsChuong().get(chuongSelected).setNoiDung(noiDungKiemTra);
//                    chuongAdapter.notifyDataSetChanged();
//                    Toast.makeText(ChuongActivity.this,"Đã bật kiểm tra chính tả",Toast.LENGTH_SHORT).show();
//                    kiemTra = 1;
//                }
//                else {
//                    ListViewAdapter.truyenSelected.getDsChuong().get(chuongSelected).setNoiDung(noiDungBanDau);
//                    chuongAdapter.notifyDataSetChanged();
//                    Toast.makeText(ChuongActivity.this,"Đã tắt kiểm tra chính tả",Toast.LENGTH_SHORT).show();
//                    kiemTra = 0;
//                }
//            }
//        });

//        imgMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String noiDungKiemTra = "";
////                String[] arrKiemTra = ListViewAdapter.truyenSelected.getDsChuong().get(chuongSelected).getNoiDung().toString().split(" ");
//                ArrayList<String> dsNoiDungKiemTra = new ArrayList<String>();
//                ArrayList<String> arrKiemTra = new ArrayList<String>();
//                StringTokenizer stringTokenizer = new StringTokenizer(ListViewAdapter.truyenSelected.getDsChuong().get(chuongSelected).getNoiDung().toString()," \n");
//                while (stringTokenizer.hasMoreTokens()) {
//                    arrKiemTra.add(stringTokenizer.nextToken());
//                }
//
//                for (int i = 0;i < arrKiemTra.size();++i) {
////                    KiemTraChinhTa kiemTra = new KiemTraChinhTa();
//                    KiemTraChinhTa kiemTra = new KiemTraChinhTa();
////                    if (arrKiemTra[i].equals("\n")) {
////                        break;
////                    }
//                    if (!kiemTra.kiemTraChinhTa(arrKiemTra.get(i))) {
////                        noiDungKiemTra += arrKiemTra.get(i) + "  ";
//                        //kiểm tra xem từ đã có trong danh sách chưa
//                        int count = 0;
//                        for (int j = 0;j < dsNoiDungKiemTra.size();++j) {
//                            if (dsNoiDungKiemTra.get(j).equals(arrKiemTra.get(i))) {
//                                count++;
//                                break;
//                            }
//                        }
//                        if (count == 0) {
//                            dsNoiDungKiemTra.add(arrKiemTra.get(i));
//                        }
//                    }
//                }
//
//                for (int i = 0;i < dsNoiDungKiemTra.size();++i) {
//                    noiDungKiemTra += dsNoiDungKiemTra.get(i) + "  ";
//                }
//
//                AlertDialog.Builder dialog = new AlertDialog.Builder(ChuongActivity.this);
//                dialog.setTitle("Các từ sai chính tả");
//                dialog.setIcon(R.drawable.kiem_tra);
//                dialog.setMessage(noiDungKiemTra);
//                dialog.setCancelable(false);
//
//                dialog.setNegativeButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.dismiss();
//                    }
//                }).create();
//
//                dialog.show();
//            }
//        });

        imgBackTruyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChuongActivity.this,TruyenActivity.class);
                for (Truyen truyen : MainActivity.dsTruyen) {
                    if (truyen.getTen().toString().equals(MainActivity.tenTruyen)) {
                        ListViewAdapter.truyenSelected = truyen;
                    }
                }
                intent.putExtra("diChuyen",0);
                startActivity(intent);
                finish();
            }
        });
    }

    private void addControls() {
        txtTenChuong = (TextView) findViewById(R.id.txtTenChuong);
        txtTenChuong.setText(ListViewAdapter.truyenSelected.getDsChuong().get(chuongSelected).getTenChuong());

        imgBackTruyen = (ImageView) findViewById(R.id.imgBackTruyen);
    }

    private void viewPager() {
        vpChuong = (ViewPager) findViewById(R.id.vpChuong);
        chuongAdapter = new ChuongAdapter(ChuongActivity.this, ListViewAdapter.truyenSelected.getDsChuong());
        vpChuong.setAdapter(chuongAdapter);
        vpChuong.setOffscreenPageLimit(3);
        vpChuong.setCurrentItem(chuongSelected);
    }
}
