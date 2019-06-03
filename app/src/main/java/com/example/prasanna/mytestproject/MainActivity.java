package com.example.prasanna.mytestproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    com.example.prasanna.mytestproject.DatabaseHelper mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDb = new com.example.prasanna.mytestproject.DatabaseHelper(this);
    }
    public void toAddStudent(View v){

        Intent next1 = new Intent(MainActivity.this,AddStudentClass.class);
        startActivity(next1);
    }
    public void toDeleteStudent(View v){

        Intent next2 = new Intent(MainActivity.this,DeleteStudent.class);
        startActivity(next2);
    }
    public void toShowStudent(View v){

        Intent next3 = new Intent(MainActivity.this,ShowStudent.class);
        startActivity(next3);
    }

}
