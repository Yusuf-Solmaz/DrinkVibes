package com.yusuf.drinkvibes.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.yusuf.drinkvibes.R
import com.yusuf.drinkvibes.data.roomdb.entity.FavouriteBeverages
import com.yusuf.drinkvibes.databinding.FragmentFavouriteBeveragesBinding
import com.yusuf.drinkvibes.ui.adapter.FavouriteBeveragesAdapter
import com.yusuf.drinkvibes.ui.viewModel.BeveragesViewModel
import com.yusuf.drinkvibes.ui.viewModel.FavouriteBeveragesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouriteBeveragesFragment : Fragment() {

    private lateinit var binding: FragmentFavouriteBeveragesBinding

    private lateinit var viewModel: FavouriteBeveragesViewModel

    private lateinit var adapter: FavouriteBeveragesAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentFavouriteBeveragesBinding.inflate(inflater,container,false)


        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(requireContext())
        binding.favBeveragesRecyclerView.layoutManager = layoutManager

        viewModel = ViewModelProvider(this).get(FavouriteBeveragesViewModel::class.java)

        viewModel.getAllFavouriteBeverages()
        observeData()


    }

    private fun observeData(){
        viewModel.favouriteBeverages.observe(viewLifecycleOwner){
           favBeverages ->
            Log.i("favBeverages",favBeverages.toString())
            favBeverages?.let {
                adapter = FavouriteBeveragesAdapter(viewModel,requireContext(),favBeverages)
                binding.favBeveragesRecyclerView.adapter=adapter
            }
        }
    }

    override fun onPause() {
        super.onPause()
        val navController = findNavController()
        navController.popBackStack(R.id.favouriteBeveragesFragment, true)
    }

}