package com.kronos.jsonproject.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.kronos.jsonproject.R;
import com.kronos.jsonproject.exercise;
import com.kronos.jsonproject.model.ModelClass;
import com.kronos.jsonproject.view.MainActivity;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Row>
{


    private ArrayList<ModelClass> modelClasses;


    public Adapter(ArrayList<ModelClass> modelClasses) {
        this.modelClasses = modelClasses;
    }



    @NonNull
    @Override
    public Row onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rowlayout,parent,false);

        return new Row(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Row holder, int position) {

        holder.bind(modelClasses.get(position),position);


    }



    @Override
    public int getItemCount() {
        return modelClasses.size();
    }



    public class  Row extends RecyclerView.ViewHolder {
        TextView name,name2,name3;
        CardView cardView;

        public Row(@NonNull View itemView) {
            super(itemView);

        }
        public void bind(ModelClass modelClass,Integer position)
        {
            cardView = (CardView) itemView.findViewById(R.id.cardview);
            name = (TextView) itemView.findViewById(R.id.model_name);
            name2 = (TextView) itemView.findViewById(R.id.model_name2);
            name3 = (TextView) itemView.findViewById(R.id.model_name3);

            name3.setText("Department : "+modelClass.dept);

            name.setText(modelClass.name);
            name2.setText(modelClass.surname);



            ModelClass x = new ModelClass();
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent  = new Intent(itemView.getContext(), exercise.class);
                    intent.putExtra("name",modelClasses.get(position).name+" "+modelClasses.get(position).surname);
                    intent.putExtra("dept",modelClasses.get(position).dept);
                    intent.putExtra("age",modelClasses.get(position).age);
                    intent.putExtra("phone",modelClasses.get(position).Phone);
                    itemView .getContext().startActivity(intent);

                }
            });

        }


    }
}
