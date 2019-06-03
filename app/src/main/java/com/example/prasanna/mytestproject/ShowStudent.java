package com.example.prasanna.mytestproject;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowStudent extends AppCompatActivity {
    DatabaseHelper mdb;
    ListView lView;
    ArrayAdapter<Fields> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_student);
        lView = findViewById(R.id.lists);
        mdb = new DatabaseHelper(this);
        display();
    }
    public void toHome(View v){

        Intent prev = new Intent(ShowStudent.this,MainActivity.class);
        startActivity(prev);
    }

    private void display(){
        Cursor data = mdb.getData();

        ArrayList<Fields> listVals = new ArrayList<>();
        while(data.moveToNext()){
            String Name = data.getString(0).toString();
            String RollNo = data.getString(1).toString();
            String Spec = data.getString(2).toString();

            Fields fd = new Fields(Name,RollNo,Spec);
            listVals.add(fd);
        }
        data.close();
        System.out.println(listVals);
        if (listVals!=null){
            Log.d("ll",listVals.toString());
        }
        adapter = new ArrayAdapter<>(ShowStudent.this,android.R.layout.simple_list_item_1,listVals);
        if (adapter!=null){
            lView.setAdapter(adapter);}
    }
}
