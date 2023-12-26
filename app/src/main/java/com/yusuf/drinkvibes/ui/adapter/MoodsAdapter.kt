package com.yusuf.drinkvibes.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.yusuf.drinkvibes.data.retrofit.entity.Moods
import com.yusuf.drinkvibes.databinding.MoodsRowBinding
import com.yusuf.drinkvibes.ui.MoodsFragmentDirections
import com.yusuf.drinkvibes.ui.viewModel.MoodsViewModel

class MoodsAdapter(val viewModel: MoodsViewModel, val context: Context,val moods: List<Moods>) : RecyclerView.Adapter<MoodsAdapter.MoodsHolder>(){


    class MoodsHolder(val binding: MoodsRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoodsHolder {
        val itemBinding = MoodsRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MoodsHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return moods.size
    }

    override fun onBindViewHolder(holder: MoodsHolder, position: Int) {
        holder.binding.mood.text = moods[position].moodName
        holder.binding.cardView.setOnClickListener {
            val action = MoodsFragmentDirections.actionMoodsFragmentToBeveragesFragment(moods[position])
            holder.binding.root.findNavController().navigate(action)
        }
    }

}


