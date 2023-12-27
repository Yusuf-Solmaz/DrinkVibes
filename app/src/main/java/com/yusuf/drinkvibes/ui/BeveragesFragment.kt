package com.yusuf.drinkvibes.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.yusuf.drinkvibes.R
import com.yusuf.drinkvibes.data.retrofit.entity.Moods
import com.yusuf.drinkvibes.databinding.FragmentBeveragesBinding
import com.yusuf.drinkvibes.ui.viewModel.BeveragesViewModel
import com.yusuf.drinkvibes.ui.viewModel.MoodsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log
import kotlin.random.Random

@AndroidEntryPoint
class BeveragesFragment : Fragment() {

    private lateinit var binding: FragmentBeveragesBinding
    private lateinit var viewModel: BeveragesViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBeveragesBinding.inflate(inflater,container,false)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(BeveragesViewModel::class.java)


    }

    override fun onResume() {
        super.onResume()

        val bundle : BeveragesFragmentArgs by navArgs()
        val mood = bundle.mood

        viewModel.getBeverages(mood)
        viewModel.beverageList.observe(viewLifecycleOwner){

            val beverage = it[Random.nextInt(it.size)]

            binding.beverageContents.text = beverage.contents
            binding.beveragePreparation.text = beverage.preparation


            Glide.with(requireContext())
                .load(beverage.imageUrl)
               // .placeholder(R.drawable.img)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.beverageImageView)


            binding.webView.webViewClient = WebViewClient()
            binding.webView.settings.javaScriptEnabled = true
            binding.webView.settings.domStorageEnabled = true


            val videoId = beverage.youtubeVideoId // YouTube video ID'sini buraya yazın
            val embedHTML = "<html><body><iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/$videoId\" frameborder=\"0\" allowfullscreen></iframe></body></html>"
            binding.webView.loadData(embedHTML, "text/html", "utf-8")

            Log.i("beverage",it[Random.nextInt(it.size)].beverageName)

        }

    }



}