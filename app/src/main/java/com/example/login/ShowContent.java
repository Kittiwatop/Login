package com.example.login;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.login.adapter.ListarrayAdapter;
import com.example.login.db.DatabaseHelper;
import com.example.login.model.user;

import java.util.ArrayList;

public class ShowContent extends AppCompatActivity {
    private DatabaseHelper mHelper;
    private SQLiteDatabase mDB;
    private ArrayList<user> mContactList = new ArrayList<>(); //เก็บ contact
    private ListView mContactListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_content);
        mHelper = new DatabaseHelper(this);
        mDB = mHelper.getWritableDatabase();//return ผลลัพธ์ เป็น database
        mContactListView = (ListView) findViewById(R.id.listView);
    }
    @Override
    protected void onResume() {
        super.onResume();
        Cursor cursor = mDB.query(DatabaseHelper.TABLE_NAME, null, null, null, null, null, null);

        mContactList.clear();

        while (cursor.moveToNext()) { // moveToNext ถ้าไม่เจอข้อมูลจะ return fault

            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME));
            String phone = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_USERNAME));
            String image = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PASSWORD));

            user contact = new user(name, phone, image);//สร้าง ข้อมูล
            mContactList.add(contact);//ยัดข้อมูลเข้า ArrayList
        }

        ListarrayAdapter adapter = new ListarrayAdapter(
                this,
                R.layout.list_item,
                mContactList);

        mContactListView.setAdapter(adapter);//หน้าที่ Adapter ยัดข้อมูลใส่ layout แล้วส่งกลับ ListView
    }



}
