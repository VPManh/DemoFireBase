package com.example.a_demofirebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private TextView tx_text,tx_text2;
    DatabaseReference database;
    private  ListView lv;
    private ArrayList<String> arrayListSinhVien;
    private ArrayAdapter sinhvienArrayAdapter = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lisstview);
        tx_text = findViewById(R.id.tx_text);
        tx_text2 = findViewById(R.id.tx_text2);


        arrayListSinhVien = new ArrayList<String>();
        sinhvienArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayListSinhVien);
        lv.setAdapter(sinhvienArrayAdapter);


         database = FirebaseDatabase.getInstance().getReference();

        // Trường hợp 1
         database.child("hoTen").setValue("VanPhuManh");
        // Trường hợp 2
         Sinhvien sinhvien = new Sinhvien("Văn Phú Mạnh","Đà Nẵng",2003);
         database.child("sinhVien").setValue(sinhvien);
        // Trường hợp 3
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("xeMay",2);
        database.child("phuongTien").setValue(map);
        // Trường hợp 4
        //main( sử dụng ) // tạo tree trên firebase // dùng push để update vào DB
        Sinhvien sv1 = new Sinhvien("Văn Phú Mạnh 5","Đà Nẵng",2003);
//        database.child("hocVien").push().setValue(sv1);



        // Dùng để lưu
//        database.child("hocVien").push().setValue(sv1, new DatabaseReference.CompletionListener() {
//            @Override
//            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
//                if(error == null){
//                    Toast.makeText(MainActivity.this,"Lưu thành công",Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Toast.makeText(MainActivity.this,"Lưu 0 thành công",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        // Dùng để update dữ liệu (realtime) khi có sự thay đổi nào đó
        database.child("phuongTien").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                tx_text.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        // Dùng để đọc dữ liệu có trong DB
        database.child("hocVien").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Sinhvien sinhvien =  snapshot.getValue(Sinhvien.class);
                arrayListSinhVien.add(sinhvien.name + "-" +sinhvien.address +"-"+sinhvien.Rob+ "\n") ;
                sinhvienArrayAdapter.notifyDataSetChanged();
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





    }
}