package com.openclassrooms.realestatemanager;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.openclassrooms.realestatemanager.databinding.RowRealEstateBinding;

public class RealEstateAdapter extends ListAdapter<MasterUiModel,RealEstateAdapter.RealEstateViewHolder> {

    private final OnItemClickListener onItemClickListener;

    protected RealEstateAdapter(
            @NonNull DiffUtil.ItemCallback<MasterUiModel> diffCallback,
            OnItemClickListener onItemClickListener
    ) {
        super(diffCallback);
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public RealEstateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RealEstateViewHolder(
                RowRealEstateBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false));
    }

    @Override
    public void onBindViewHolder(@NonNull RealEstateViewHolder holder, int position) {
        MasterUiModel masterUiModel = getItem(position);
        holder.rowRealEstateBinding.setMasterUiModel(masterUiModel);
    }

    public class RealEstateViewHolder extends RecyclerView.ViewHolder {

        RowRealEstateBinding rowRealEstateBinding;

        public RealEstateViewHolder(@NonNull RowRealEstateBinding rowRealEstateBinding) {
            super(rowRealEstateBinding.getRoot());
            this.rowRealEstateBinding = rowRealEstateBinding;
            this.rowRealEstateBinding.getRoot().setOnClickListener(v -> onItemClickListener.onItemClick(getAdapterPosition()));
        }

        public void bind() {}
    }

    public static final DiffUtil.ItemCallback<MasterUiModel> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<MasterUiModel>() {
                @Override
                public boolean areItemsTheSame(@NonNull MasterUiModel oldItem, @NonNull MasterUiModel newItem) {
                    return oldItem.getId().equals(newItem.getId());
                }

                @Override
                public boolean areContentsTheSame(@NonNull MasterUiModel oldItem, @NonNull MasterUiModel newItem) {
                    return oldItem.equals(newItem);
                }
            };

    public interface OnItemClickListener {
        public void onItemClick (int position);
    }
}
