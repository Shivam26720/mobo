package com.ab.mobo.display;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ab.mobo.R;
import com.ab.mobo.datamodel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class buyadapter extends FirebaseRecyclerAdapter<childiteam,buyadapter.viewholder> {
  Context context1;

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public buyadapter(@NonNull FirebaseRecyclerOptions<childiteam> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull buyadapter.viewholder holder, int position, @NonNull childiteam model) {
        holder.textView.setText(model.getName());
    }

    @NonNull
    @Override
    public buyadapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new buyadapter.viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.griddesign,parent,false));


    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.parent_item_title);
            imageView=itemView.findViewById(R.id.imageviewgrid);
        }
    }
}

