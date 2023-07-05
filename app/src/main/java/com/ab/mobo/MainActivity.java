package com.ab.mobo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.graphics.Color;
import android.os.Bundle;

import com.ab.mobo.account.signup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(Color.BLACK);
        setContentView(R.layout.activity_main);
        FragmentManager fr=getSupportFragmentManager();
        fr.beginTransaction().replace(R.id.main,new signup()).commit();
    }
}