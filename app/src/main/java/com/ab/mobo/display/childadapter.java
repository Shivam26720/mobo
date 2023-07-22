package com.ab.mobo.display;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ab.mobo.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class childadapter extends FirebaseRecyclerAdapter<childiteam,childadapter.vieholder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public childadapter(@NonNull FirebaseRecyclerOptions<childiteam> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull childadapter.vieholder holder, int position, @NonNull childiteam model) {
        holder.textView.setText(model.getName());
    }

    @NonNull
    @Override
    public childadapter.vieholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new childadapter.vieholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.childiteamdesign,parent,false));
    }


    public class vieholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public vieholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img_child_item);
            textView=itemView.findViewById(R.id.child_item_title);
        }
    }
}
