package com.example.amin.project2;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.amin.adapter.ListViewAdapter;
import com.example.amin.adapter.MainAdapter;
import com.example.amin.adapter.TheLoaiAdapter;
import com.example.amin.model.Chuong;
import com.example.amin.model.Truyen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static String DATABASE_NAME="dbTruyen.sqlite";
    private static final String DB_PATH_SUFFIX = "/databases/";
    public static SQLiteDatabase database=null;

    public static ViewPager viewPagerMain;
    TabLayout tabLayoutMain;

    public static ImageView imgTrangChu;
    public static ImageView imgYeuThich;
//    public static ImageView imgTimKiemTT;
//    public static ImageView imgTimKiemYT;

    public static AutoCompleteTextView autoTimKiem;
    ArrayList<String> dsTimKiemTT = new ArrayList<>();
    ArrayList<String> dsTimKiemYT = new ArrayList<>();
    ArrayAdapter<String> timKiemAdapter;

    public static ArrayList<Truyen> dsTruyen = new ArrayList();
    public static ArrayList<Truyen> dsYeuThich = new ArrayList<>();
    public static ArrayList<String> dsTheLoai = new ArrayList<>();
    public static ArrayList<Truyen> dsTruyenTheLoai = new ArrayList<>();
    public static ArrayList<Truyen> dsTruyenThem = new ArrayList<>();
    public static int sizeTheLoai;

    ListView lvLeft;
    TheLoaiAdapter theLoaiAdapter;

    ImageView img, imgTimKiem, imgMain;
    DrawerLayout drawerMain;

    String truyenName = "dsTruyenThem.txt";
    File file = Environment.getExternalStorageDirectory();

    public static int theLoai = 0, truyen = 0, chuong = 0, soChuong = 0;
    public static String tenTruyen = "", tenTheLoai = "";
    int timKiem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();   //tạo cho layout full màn hình
//        overridePendingTransition(0,R.anim.out_right);
        viewPager();
        saoChepCSDL();
        getDanhSachTruyen();
        addControls();
        addEvent();
        hienThiTrangThaiLuuTru();
    }

    private void hienThiTrangThaiLuuTru() {
        getData();
        hienThi();
    }

    private void hienThi() {
        if (chuong == 1) {
            Intent intent = new Intent(MainActivity.this,ChuongActivity.class);
            for (Truyen truyen : dsTruyen) {
                if (truyen.getTen().toString().equals(tenTruyen)) {
                    ListViewAdapter.truyenSelected = truyen;
                    getDatabase(ListViewAdapter.truyenSelected);
                }
            }
            intent.putExtra("chuong",soChuong);
            startActivity(intent);
        }
        else if (truyen == 1) {
            Intent intent = new Intent(MainActivity.this,TruyenActivity.class);
            for (Truyen truyen : dsTruyen) {
                if (truyen.getTen().toString().equals(tenTruyen)) {
                    ListViewAdapter.truyenSelected = truyen;
                    getDatabase(ListViewAdapter.truyenSelected);
                }
            }
            startActivity(intent);
        }
        else if (theLoai == 1) {
            dsTruyenTheLoai = getDanhSachTruyenTheLoai(tenTheLoai);
            Intent intent = new Intent(MainActivity.this, TheLoaiActivity.class);
            intent.putExtra("theloai",tenTheLoai);
            startActivity(intent);
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

    private void getData() {
        SharedPreferences sharedPreferences = getSharedPreferences("TrangThaiLuuTru",MODE_PRIVATE);
        theLoai = sharedPreferences.getInt("TheLoai",0);
        truyen = sharedPreferences.getInt("Truyen",0);
        chuong = sharedPreferences.getInt("Chuong",0);
        soChuong = sharedPreferences.getInt("SoChuong",0);
        tenTruyen = sharedPreferences.getString("TenTruyen","");
        tenTheLoai = sharedPreferences.getString("TenTheLoai","");
    }

    @Override
    protected void onResume() {
        super.onResume();
        theLoai = truyen = chuong = 0;
        getTheLoai();
        theLoaiAdapter.notifyDataSetChanged();
        getDanhSachTruyen();
        getDanhSachYeuThich();
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("TrangThaiLuuTru",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("TheLoai",theLoai);
        editor.putInt("Truyen",truyen);
        editor.putInt("Chuong",chuong);
        editor.putInt("SoChuong",soChuong);
        editor.putString("TenTruyen",tenTruyen);
        editor.putString("TenTheLoai",tenTheLoai);
        editor.commit();
    }

    private void getTheLoai() {
        database = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        Cursor cursorTheLoai = database.rawQuery("select distinct theloai from truyen", null);
        dsTheLoai.clear();
        dsTheLoai.add("THỂ LOẠI");
        while (cursorTheLoai.moveToNext()) {
            dsTheLoai.add(cursorTheLoai.getString(0));
        }

        //thêm thể loại từ truyện được thêm vào
        for (Truyen truyenThem : dsTruyenThem) {
            int count =0;
            for (String theLoai : dsTheLoai ) {
                if (truyenThem.getTheLoai().toString().equals(theLoai)) {
                    count ++;
                    break;
                }
            }
            if (count == 0) {
                dsTheLoai.add(truyenThem.getTheLoai().toString());
            }
        }

        dsTheLoai.add("THÊM TRUYỆN");
        dsTheLoai.add("Thêm từ file");
        sizeTheLoai = dsTheLoai.size();
    }

    private void getDanhSachYeuThich() {
        dsYeuThich.clear();
        for (Truyen truyen : dsTruyen) {
            if (truyen.getYeuThich() == 1) {
                dsYeuThich.add(truyen);
            }
        }
    }

    private void addControls() {
//        imgTimKiemTT = (ImageView) findViewById(R.id.imgTimKiemTT);
//        imgTimKiemYT = (ImageView) findViewById(R.id.imgTimKiemYT);
//        imgTimKiemYT.setVisibility(View.INVISIBLE);

        imgTrangChu = (ImageView) findViewById(R.id.imgTrangChu);
        imgYeuThich = (ImageView) findViewById(R.id.imgYeuThich);
        imgYeuThich.setVisibility(View.INVISIBLE);

        autoTimKiem = (AutoCompleteTextView) findViewById(R.id.autoTimKiem);
        dsTimKiemTT = getDanhSachTimKiemTT();

        timKiemAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_expandable_list_item_1,dsTimKiemTT);
        autoTimKiem.setAdapter(timKiemAdapter);

        autoTimKiem.setVisibility(View.INVISIBLE);

        lvLeft = (ListView) findViewById(R.id.lvLeft);
        theLoaiAdapter = new TheLoaiAdapter(MainActivity.this,R.layout.item_the_loai,dsTheLoai);
        lvLeft.setAdapter(theLoaiAdapter);

        img = (ImageView) findViewById(R.id.img);
        imgTimKiem = (ImageView) findViewById(R.id.imgTimKiem);
        imgMain = (ImageView) findViewById(R.id.imgMain);
        drawerMain = (DrawerLayout) findViewById(R.id.drawerMain);

    }

    private ArrayList<String> getDanhSachTimKiemYT() {
        for (Truyen truyen : dsYeuThich) {
            dsTimKiemYT.add(truyen.getTen());
        }
        return dsTimKiemYT;
    }

    private ArrayList<String> getDanhSachTimKiemTT() {
        for (Truyen truyen : dsTruyen) {
            dsTimKiemTT.add(truyen.getTen());
        }
        return dsTimKiemTT;
    }

    private void addEvent() {
        //danh sách tìm kiếm cho AutoCompleteTextView
        viewPagerMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                autoTimKiem.setText("");
                if (position == 0) {
                    timKiemAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_expandable_list_item_1,dsTimKiemTT);
                    autoTimKiem.setAdapter(timKiemAdapter);
                }
                else if (position == 1) {
                    dsTimKiemYT.clear();
                    dsTimKiemYT = getDanhSachTimKiemYT();
                    timKiemAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_expandable_list_item_1,dsTimKiemYT);
                    autoTimKiem.setAdapter(timKiemAdapter);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        imgTimKiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timKiem == 0) {
                    imgMain.setVisibility(View.INVISIBLE);
                    autoTimKiem.setVisibility(View.VISIBLE);
                    timKiem = 1;
                }
                else {
                    autoTimKiem.setVisibility(View.INVISIBLE);
                    imgMain.setVisibility(View.VISIBLE);
                    timKiem = 0;
                }
            }
        });

        lvLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == sizeTheLoai - 1) {
//                    Intent intent = new Intent(MainActivity.this, ThemTruyenActivity.class);
//                    startActivity(intent);
                    final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("Thêm truyện");
                    dialog.setIcon(R.drawable.themtruyen);
                    dialog.setCancelable(false);

                    final EditText txtTimKiem = new EditText(MainActivity.this);
                    txtTimKiem.setHint("Nhập tên file (.txt)                                                 ");
                    txtTimKiem.setTextSize(14);

                    LinearLayout lnTimKiem = new LinearLayout(MainActivity.this);
                    lnTimKiem.addView(txtTimKiem);
                    lnTimKiem.setPadding(40,10,40,0);
                    dialog.setView(lnTimKiem);

                    dialog.setNegativeButton("Thêm Truyện", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //xử lý tim kiếm
                            xuLyThemTruyen(txtTimKiem.getText().toString());
                            luuDanhSachTruyenThem();
                        }
                    }).setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).create();

                    dialog.show();
                }
                else if (position != 0 && position != sizeTheLoai - 2) {
                    dsTruyenTheLoai = getDanhSachTruyenTheLoai(dsTheLoai.get(position));
                    Intent intent = new Intent(MainActivity.this, TheLoaiActivity.class);
                    intent.putExtra("theloai",dsTheLoai.get(position));
                    startActivity(intent);
                }
            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerMain.openDrawer(GravityCompat.START);
            }
        });
    }

    private void luuDanhSachTruyenThem() {
        try {
            FileOutputStream fos = openFileOutput(truyenName,MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dsTruyenThem);
            oos.close();
            fos.close();
        }
        catch (Exception e) {
        }
    }

    private void xuLyThemTruyen(String tenFile) {
        try {
            FileInputStream fis = new FileInputStream(file + "/" + tenFile + ".txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Truyen truyen = (Truyen) ois.readObject();
            int count = 0;
            for (Truyen t : dsTruyen) {
                if (t.getTen().toString().equals(truyen.getTen().toString())) {
                    count ++;
                    break;
                }
            }
            if (count == 0) {
                dsTruyenThem.add(truyen);
            }
            ois.close();
            fis.close();
            Toast.makeText(MainActivity.this,"Thêm truyện thành công",Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) {
            Toast.makeText(MainActivity.this,"Hãy nhập chính xác tên file",Toast.LENGTH_SHORT).show();
        }
    }

    private ArrayList<Truyen> getDanhSachTruyenTheLoai(String theLoai) {
        dsTruyenTheLoai.clear();
        for (Truyen truyen : dsTruyen) {
            if (truyen.getTheLoai().toString().equals(theLoai)) {
                dsTruyenTheLoai.add(truyen);
            }
        }
        return dsTruyenTheLoai;
    }

    private void getDanhSachTruyen() {
        getDanhSachTruyenBanDau();
        getDanhSachTruyenThem();
    }

    private void getDanhSachTruyenThem() {
        try {
            FileInputStream fis = openFileInput(truyenName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            dsTruyenThem = (ArrayList<Truyen>) ois.readObject();
            for (Truyen truyen : dsTruyenThem) {
                dsTruyen.add(truyen);
            }
            ois.close();
            fis.close();
        }
        catch (Exception e) {
        }
    }

    private void getDanhSachTruyenBanDau() {
        database = openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
        //        Cursor cursor = database.query("truyen",null,null,null,null,null,null);
        Cursor cursorTruyen = database.rawQuery("select * from truyen",null);
        dsTruyen.clear();
        while(cursorTruyen.moveToNext()) {
            Truyen truyen = new Truyen();
            truyen.setTen(cursorTruyen.getString(1));
            truyen.setSoChuong(cursorTruyen.getString(2));
            truyen.setImg(cursorTruyen.getBlob(3));
            truyen.setYeuThich(cursorTruyen.getInt(4));
            truyen.setTheLoai(cursorTruyen.getString(5));
            truyen.setTomTat(cursorTruyen.getString(6));
//            truyen.setTomTat("");
            truyen.setDsChuong(new ArrayList<Chuong>());
            dsTruyen.add(truyen);
        }
        cursorTruyen.close();
    }

    private void saoChepCSDL() {
        File dbFile = getDatabasePath(DATABASE_NAME);
        if (!dbFile.exists()) {
            try {
                copyDatabaseAsset();
                Toast.makeText(MainActivity.this,"ok",Toast.LENGTH_SHORT).show();
            }
            catch (Exception e) {
                Toast.makeText(MainActivity.this,"loi1",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void copyDatabaseAsset() {
        try {
            InputStream inPut = getAssets().open(DATABASE_NAME);
            String outFileName = layDuongDanLuuTru();
            File file = new File(getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if (!file.exists()) {
                file.mkdir();
            }

            OutputStream outPut = new FileOutputStream(outFileName);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inPut.read(buffer)) > 0) {
                outPut.write(buffer,0,length);
            }

            outPut.flush();
            outPut.close();
            inPut.close();
        }
        catch (Exception e) {
            Toast.makeText(MainActivity.this,e.toString(),Toast.LENGTH_LONG).show();
        }
    }

    private String layDuongDanLuuTru() {
        return getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME;
    }

    private void viewPager() {
        viewPagerMain = (ViewPager) findViewById(R.id.vpMain);
        tabLayoutMain = (TabLayout) findViewById(R.id.tlMain);
        FragmentManager frm = getSupportFragmentManager();
        MainAdapter mainAdapter = new MainAdapter(frm);
        viewPagerMain.setAdapter(mainAdapter);
        tabLayoutMain.setupWithViewPager(viewPagerMain);

//        tabLayoutMain.getTabAt(0).setIcon(R.drawable.list_view);
//        tabLayoutMain.getTabAt(1).setIcon(R.drawable.grid_view);
    }
}
