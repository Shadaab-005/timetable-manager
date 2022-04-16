package com.example.timetablemanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapterpostponed extends RecyclerView.Adapter<RecyclerAdapterpostponed.ViewHolder> {

    private List<postponedtasks> datas;

    private Context context;
    private LayoutInflater LayoutInflater;

    public RecyclerAdapterpostponed(List<postponedtasks> datas, Context context) {
        this.datas = datas;
        this.context = context;
        this.LayoutInflater = android.view.LayoutInflater.from(context);
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.inflate(R.layout.recy_design,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {

        holder.task.setText(datas.get(i).getTasktobeper());
        holder.time.setText(datas.get(i).getTime());
        holder.desc.setText(datas.get(i).getTaskdesc());

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView task;
        TextView time;
        TextView desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            task=itemView.findViewById(R.id.textview1);
            time=itemView.findViewById(R.id.textview2);
            desc=itemView.findViewById(R.id.textview3);
        }
    }
}
