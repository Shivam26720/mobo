package com.ab.mobo.display;
import com.ab.mobo.*;
import com.ab.mobo.databinding.ActivityDisplayhomeBinding;
import com.ab.mobo.internet.broadcastinternet;
import com.ab.mobo.datamodel;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Bundle;

import com.ab.mobo.R;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class displayhome extends AppCompatActivity {
    ActivityDisplayhomeBinding binding;
    updateadapter adapter;
    buyadapter buyadapter;
    ArrayList<SlideModel> data;
    broadcastinternet reciver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.rgb(152,230,230));
        getSupportActionBar().hide();
        reciver  =new broadcastinternet();
        binding=ActivityDisplayhomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        RecyclerView recyclerView=findViewById(R.id.recylierview);
        RecyclerView recyclerViewgrid=findViewById(R.id.recylierviewgrid);
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("domain");
     //  new LinearLayoutManager(displayhome.this,LinearLayoutManager.HORIZONTAL,false);
        FirebaseRecyclerOptions<datamodel> options=new FirebaseRecyclerOptions.Builder<datamodel>().setQuery(reference,datamodel.class).build();
        adapter=new updateadapter(options);
    //

        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(adapter);

        DatabaseReference referencegrid= FirebaseDatabase.getInstance().getReference("latest");
        FirebaseRecyclerOptions<childiteam> optionsgrid=new FirebaseRecyclerOptions.Builder<childiteam>().setQuery(referencegrid,childiteam.class).build();
        buyadapter=new buyadapter(optionsgrid);
        recyclerViewgrid.setLayoutManager(new GridLayoutManager(this,2));
        recyclerViewgrid.setAdapter(buyadapter);
































        data=new ArrayList<SlideModel>();
        data.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/notes-1acf1.appspot.com/o/headphone.avif?alt=media&token=e2081880-a22e-4013-88d5-25d14d5f7186", ScaleTypes.FIT));
        data.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/notes-1acf1.appspot.com/o/morden.avif?alt=media&token=e7fd6e63-8ab3-446b-b2a5-2d4beee5e5a3", ScaleTypes.FIT));
        data.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/notes-1acf1.appspot.com/o/morden.avif?alt=media&token=e7fd6e63-8ab3-446b-b2a5-2d4beee5e5a3", ScaleTypes.FIT));
        binding.imageslider.setImageList(data);



    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
       buyadapter.startListening();
        IntentFilter filter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(reciver,filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(reciver);
        adapter.stopListening();
      buyadapter.stopListening();
    }
}