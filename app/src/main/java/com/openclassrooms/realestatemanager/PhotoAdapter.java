package com.openclassrooms.realestatemanager;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.openclassrooms.realestatemanager.databinding.RowPhotoBinding;

public class PhotoAdapter extends ListAdapter<PhotoUiModel, PhotoAdapter.PhotoViewHolder> {

    protected PhotoAdapter(@NonNull DiffUtil.ItemCallback<PhotoUiModel> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhotoViewHolder(
                RowPhotoBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false));
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        PhotoUiModel photoUiModel = getItem(position);
        holder.bind(photoUiModel);
    }

    public static class PhotoViewHolder extends RecyclerView.ViewHolder {

        RowPhotoBinding rowPhotoBinding;

        public PhotoViewHolder(@NonNull RowPhotoBinding rowPhotoBinding) {
            super(rowPhotoBinding.getRoot());
            this.rowPhotoBinding = rowPhotoBinding;
        }

        public void bind(PhotoUiModel photoUiModel) {
            rowPhotoBinding.rowPhotoTitle.setText(photoUiModel.getTitle());
            Glide.with(rowPhotoBinding.rowPhotoImg)
                    .load(photoUiModel.getPhoto())
                    .transform(new CenterCrop())
                    .into(rowPhotoBinding.rowPhotoImg);
        }
    }

    public static final DiffUtil.ItemCallback<PhotoUiModel> DIFF_CALLBACK = new DiffUtil.ItemCallback<PhotoUiModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull PhotoUiModel oldItem, @NonNull PhotoUiModel newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull PhotoUiModel oldItem, @NonNull PhotoUiModel newItem) {
            return oldItem.equals(newItem);
        }
    };
}
