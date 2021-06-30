package com.haroldcalayan.dogs.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.haroldcalayan.dogs.BR
import com.haroldcalayan.dogs.R
import com.haroldcalayan.dogs.data.model.BreedImage
import com.haroldcalayan.dogs.databinding.AdapterDogItemBinding

class DogsAdapter(private var data: List<BreedImage>) : RecyclerView.Adapter<DogsAdapter.DogsAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogsAdapterViewHolder {
        val binding: AdapterDogItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.adapter_dog_item,
            parent,
            false
        )
        return DogsAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DogsAdapterViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    fun updateData(data: List<BreedImage>) {
        this.data = data
        notifyDataSetChanged()
    }

    class DogsAdapterViewHolder(private val binding: AdapterDogItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(breedImage: BreedImage) {
            binding.setVariable(BR.breedImage, breedImage)
            binding.executePendingBindings()
        }
    }
}