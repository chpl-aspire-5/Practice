package com.mycompany.practice.new1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mycompany.practice.databinding.RawItemsBinding;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder> {

    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RawItemsBinding binding = RawItemsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ItemsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public static class ItemsViewHolder extends RecyclerView.ViewHolder {

        RawItemsBinding binding;

        public ItemsViewHolder(RawItemsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
