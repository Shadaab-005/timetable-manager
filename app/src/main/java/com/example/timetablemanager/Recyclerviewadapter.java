package com.example.timetablemanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Recyclerviewadapter extends RecyclerView.Adapter<Recyclerviewadapter.MyViewHolder> {

    Context mContext;

    List<futuretasks> mData;

    public Recyclerviewadapter(Context mContext, List<futuretasks> mData) {
        this.mContext = mContext;
        this.mData = mData;

    }





    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.recy_design,parent,false);
        MyViewHolder vHolder= new MyViewHolder(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_Tasktobeperf.setText(mData.get(position).getTasktobeper());
        holder.tv_Time.setText(mData.get(position).getTime());
        holder.tv_Taskdesc.setText(mData.get(position).getTaskdesc());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_Tasktobeperf;
        private TextView tv_Time;
        private TextView tv_Taskdesc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_Tasktobeperf=(TextView) itemView.findViewById(R.id.textview1);
            tv_Time=(TextView) itemView.findViewById(R.id.textview2);
            tv_Taskdesc=(TextView) itemView.findViewById(R.id.textview3);

        }
    }
}
