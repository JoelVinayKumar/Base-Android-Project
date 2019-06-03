package com.example.prasanna.mytestproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudentClass extends AppCompatActivity {
    EditText name;
    EditText roll;
    EditText spec;
    Button back;

    DatabaseHelper mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_class);

        name = findViewById(R.id.sName);
        roll = findViewById(R.id.RollNo);
        spec = findViewById(R.id.Spec);
        back = findViewById(R.id.toHome1);

        mDb = new DatabaseHelper(this);
    }

    public void toHome(View v){

        Intent prev = new Intent(AddStudentClass.this,MainActivity.class);
        startActivity(prev);
    }

    public void addStudent(String sName,String RollNo, String Spec){
        boolean insertData = mDb.addData(sName,RollNo,Spec);

        if(insertData){
            Toast.makeText(this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Not Inserted", Toast.LENGTH_SHORT).show();
        }
    }

    public void addStud(View view) {
        String StudentName = name.getText().toString();
        String RollNumber = roll.getText().toString();
        String Specialization = spec.getText().toString();
        addStudent(StudentName,RollNumber,Specialization);
    }
}
