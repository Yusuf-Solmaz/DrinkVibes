package com.yusuf.drinkvibes.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.yusuf.drinkvibes.data.roomdb.entity.FavouriteBeverages
import com.yusuf.drinkvibes.data.roomdb.repo.FavouriteBeveragesRepository
import com.yusuf.drinkvibes.databinding.FavBeveragesRowBinding
import com.yusuf.drinkvibes.ui.viewModel.FavouriteBeveragesViewModel

class FavouriteBeveragesAdapter(val viewModel: FavouriteBeveragesViewModel,val context: Context,val favBeveragesList:List<FavouriteBeverages>) :
    RecyclerView.Adapter<FavouriteBeveragesAdapter.FavouriteBeveragesHolder>() {

        class FavouriteBeveragesHolder(val binding: FavBeveragesRowBinding) : RecyclerView.ViewHolder(binding.root)
        {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteBeveragesHolder {
        val itemBinding = FavBeveragesRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FavouriteBeveragesHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return favBeveragesList.size
    }

    override fun onBindViewHolder(holder: FavouriteBeveragesHolder, position: Int) {
        holder.binding.beverageName.text = favBeveragesList[position].beverageName

        Glide.with(context)
            .load(favBeveragesList[position].imageUrl)
            // .placeholder(R.drawable.img)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(holder.binding.imageView)

        holder.binding.deleteBeverageIcon.setOnClickListener {
            viewModel.deleteBeverage(favBeveragesList[position])
            Toast.makeText(context,"${favBeveragesList[position].beverageName} Deleted",Toast.LENGTH_SHORT).show()
        }
    }
}