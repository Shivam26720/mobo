package com.ab.mobo;
import  com.ab.mobo.datamodel;
import android.content.Context;
import android.graphics.Color;
import android.icu.text.CaseMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.myviewholder> {
    Context context;
    ArrayList<datamodel> list;
    public adapter(Context context,ArrayList<datamodel> list){
        this.context=context;
        this.list=list;
    }
    @NonNull
    @Override
    public adapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new adapter.myviewholder(LayoutInflater.from(context).inflate(R.layout.design,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull adapter.myviewholder holder, int position) {

        holder.field.setText(new datamodel().getTitle().toString());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView field;
        CardView cardView;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            field=itemView.findViewById(R.id.textviewdesign);
            cardView=itemView.findViewById(R.id.carview);
        }
    }
}
