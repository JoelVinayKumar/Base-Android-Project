package com.example.prasanna.mytestproject;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class DeleteStudent extends AppCompatActivity {
    EditText roll;
    Button sub;
    DatabaseHelper mdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);

        roll = findViewById(R.id.RollNo);
        sub = findViewById(R.id.submit);
    }
    public void toHome(View v){

        Intent prev = new Intent(DeleteStudent.this,MainActivity.class);
        startActivity(prev);
    }

    public void submitField(View v)
    {
        String ro = roll.getText().toString();
        mdb.deleteRow(ro);
    }
}
