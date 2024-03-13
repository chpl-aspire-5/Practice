package com.mycompany.practice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListDataViewHolder> {

    Context context;

    public ListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ListDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ListDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListDataViewHolder holder, int position) {
        holder.txtNo.setText("" + (position + 1));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "" + (position + 1), Toast.LENGTH_SHORT).show();
                Snackbar.make(holder.itemView, "" + (position + 1), Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    public class ListDataViewHolder extends RecyclerView.ViewHolder {

        TextView txtNo;

        public ListDataViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNo = itemView.findViewById(R.id.txtNo);
        }
    }
}
