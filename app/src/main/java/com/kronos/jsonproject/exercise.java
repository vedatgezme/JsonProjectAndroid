package com.kronos.jsonproject;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.kronos.jsonproject.model.ModelClass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class exercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView textView = (TextView)  findViewById(R.id.detailName);
        TextView textView1 = (TextView) findViewById(R.id.detailDepts);
        TextView textView2 = (TextView) findViewById(R.id.detailAge);
        TextView textView3 = (TextView) findViewById(R.id.detailphone);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String department = intent.getStringExtra("dept");
        String age = intent.getStringExtra("age");
        String phone_inf = intent.getStringExtra("phone");

        textView.setText("Name : "+name);
        textView2.setText("Age : "+age);
        textView1.setText("Department : "+ department);
        textView3.setText("Phone OS : "+phone_inf);


        /*
        *
        *  TEST for commit gitHub
        *  TEST TEST
        * */

    }

}
