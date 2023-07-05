package com.ab.mobo.display;
import com.ab.mobo.*;
import com.ab.mobo.internet.broadcastinternet;
import com.ab.mobo.datamodel;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Bundle;

import com.ab.mobo.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class displayhome extends AppCompatActivity {
    updateadapter adapter;

    broadcastinternet reciver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.BLACK);
        getSupportActionBar().hide();
        reciver  =new broadcastinternet();

        setContentView(R.layout.activity_displayhome);
        RecyclerView recyclerView=findViewById(R.id.recylierview);
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("domain");

     //  new LinearLayoutManager(displayhome.this,LinearLayoutManager.HORIZONTAL,false);
        FirebaseRecyclerOptions<datamodel> options=new FirebaseRecyclerOptions.Builder<datamodel>().setQuery(reference,datamodel.class).build();
        adapter=new updateadapter(options);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
        IntentFilter filter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(reciver,filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(reciver);
        adapter.stopListening();
    }
}