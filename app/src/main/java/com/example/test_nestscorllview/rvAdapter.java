package com.example.test_nestscorllview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class rvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> list;
    private Context context;

    public rvAdapter(Context context, List<String> list) {
        this.list = list;
        this.context=context;
    }


    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_text,parent,false);
        return new TextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
         if (holder instanceof TextViewHolder){
             ((TextViewHolder) holder).tv.setText(list.get(position));
         }
    }

    private class TextViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;

        public TextViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_item);
        }
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }
}
