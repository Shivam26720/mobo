package com.ab.mobo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.w3c.dom.Text;

public class updateadapter extends FirebaseRecyclerAdapter<datamodel, updateadapter.viewholder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public updateadapter(@NonNull FirebaseRecyclerOptions<datamodel> options) {
        super(options);
    }
    int selectedPosition = 0;
    int lastSelectedPosition = -1;
    @Override
    protected void onBindViewHolder(@NonNull updateadapter.viewholder holder, int position, @NonNull datamodel model) {
        holder.field.setText(model.getTitle());

        holder.field.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    lastSelectedPosition = selectedPosition;
                    selectedPosition = holder.getBindingAdapterPosition();
                    notifyItemChanged(lastSelectedPosition);
                    notifyItemChanged(selectedPosition);

            }
        });
    }

    @NonNull
    @Override
    public updateadapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.design,parent,false);
        return new updateadapter.viewholder(view) ;
    }

    public class viewholder extends RecyclerView.ViewHolder {

      TextView field;
     // ImageView imageView;
     ConstraintLayout cardView;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            field=itemView.findViewById(R.id.textviewdesign);
            cardView=itemView.findViewById(R.id.carview);
           // imageView=itemView.findViewById(R.id.imageview);
        }


    }
}
