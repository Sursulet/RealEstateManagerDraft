package com.openclassrooms.realestatemanager.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.realestatemanager.databinding.RowRealEstateBinding
import com.openclassrooms.realestatemanager.uimodel.RealEstateItemUiModel

class RealEstateListAdapter(
        private val listener: OnItemClickListener
) : ListAdapter<RealEstateItemUiModel, RealEstateListAdapter.RealEstateViewHolder>(RealEstateItemDiffCallback()) {

    private class RealEstateItemDiffCallback : DiffUtil.ItemCallback<RealEstateItemUiModel>() {
        override fun areItemsTheSame(oldItem: RealEstateItemUiModel, newItem: RealEstateItemUiModel): Boolean =
                oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: RealEstateItemUiModel, newItem: RealEstateItemUiModel): Boolean =
            oldItem == newItem

    }

    class RealEstateViewHolder(
            private val binding: RowRealEstateBinding,
            private val listener: OnItemClickListener
    ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        fun bind(item: RealEstateItemUiModel) {
            binding.rowRealEstateType.text = item.type
        }

        init {
            binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if(position != RecyclerView.NO_POSITION){ listener.onItemClick(position) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RealEstateViewHolder {
        return RealEstateViewHolder(
                RowRealEstateBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                ), listener)
    }

    override fun onBindViewHolder(holder: RealEstateViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}