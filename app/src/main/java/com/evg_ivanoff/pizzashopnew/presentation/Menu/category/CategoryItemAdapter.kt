package com.evg_ivanoff.pizzashopnew.presentation.Menu.category

import android.location.GnssAntennaInfo.Listener
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.evg_ivanoff.pizzashopnew.databinding.CategoryOneItemBinding
import com.google.android.material.snackbar.Snackbar

class CategoryItemAdapter(val listener: OnItemClickListener):
    ListAdapter<CategoryItem, CategoryItemAdapter.CategoryViewHolder>(CategoryItemDiffCallback()) {

    class CategoryViewHolder(private val binding: CategoryOneItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CategoryItem, listener: OnItemClickListener) {
            binding.btnCategory.textOn = item.name
            binding.btnCategory.textOff = item.name
            binding.btnCategory.isChecked = item.enabled
            binding.btnCategory.setOnClickListener {
                listener.onItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = CategoryOneItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = currentList[position]
        holder.bind(item, listener)
    }

    interface OnItemClickListener {
        fun onItemClick(item: CategoryItem)
    }

    fun sortByEnabled(newList: List<CategoryItem>) {
        newList.sortedBy { it.enabled }
        submitList(newList)
    }
}