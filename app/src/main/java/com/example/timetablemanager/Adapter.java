package com.example.timetablemanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<ModelClass> userlist;

    public Adapter (List<ModelClass>userlist){ this .userlist=userlist;
    }
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recy_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        String tname=userlist.get(position).getTextview1();
        String desc=userlist.get(position).getTextview2();
        String time=userlist.get(position).getTextview3();
        String line=userlist.get(position).getLinedivider();

        holder.setData(tname,desc,time,line);

    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textView1;
        private TextView textView2;
        private TextView textView3;
        private TextView linedivider;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.textview1);
            textView2=itemView.findViewById(R.id.textview2);
            textView3=itemView.findViewById(R.id.textview3);
            linedivider=itemView.findViewById(R.id.linedivider);






        }

        public void setData(String tname, String desc, String time, String line) {

            textView1.setText(tname);
            textView2.setText(desc);
            textView3.setText(time);
            linedivider.setText(line);

        }
    }
}
