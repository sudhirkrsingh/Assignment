package com.example.assignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment.R;
import com.example.assignment.model.Model;
import com.squareup.picasso.Picasso;

import java.util.List;

// This is our adapter class
public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.myviewholder> {

    List<Model> models;
    Context context;

    public ModelAdapter(List<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflating the single row which we have designed for our recyclerview
        View view = LayoutInflater.from(context).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        // Putting the data which is coming from the server in each view which we have used in our single row
        holder.name.setText(models.get(position).getName());
        holder.subject.setText(models.get(position).getSubject());
        holder.qualification.setText(models.get(position).getQualification());
        Picasso.get().load(models.get(position).getProfileImage()).into(holder.imageView);

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "This button functionality is not available in this version", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{

        //  This class will help us to get each content id which we have made in single row

        ImageView imageView;
        TextView name,subject,qualification;
        Button button;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.dommy_button);
            imageView=itemView.findViewById(R.id.imageView);
            name=itemView.findViewById(R.id.name);
            subject=itemView.findViewById(R.id.subject);
            qualification=itemView.findViewById(R.id.qualification);
        }
    }
}
