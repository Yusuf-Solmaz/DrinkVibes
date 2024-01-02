package com.yusuf.drinkvibes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yusuf.drinkvibes.R
import com.yusuf.drinkvibes.data.retrofit.entity.Beverages
import com.yusuf.drinkvibes.data.retrofit.entity.Moods
import com.yusuf.drinkvibes.data.roomdb.entity.FavouriteBeverages
import com.yusuf.drinkvibes.databinding.FragmentBeveragesBinding
import com.yusuf.drinkvibes.ui.viewModel.BeveragesViewModel
import com.yusuf.drinkvibes.utils.Utils.Companion.toBeverages
import com.yusuf.drinkvibes.utils.Utils.Companion.toFavBeverages
import dagger.hilt.android.AndroidEntryPoint
import io.github.muddz.styleabletoast.StyleableToast
import kotlin.random.Random

@AndroidEntryPoint
class BeveragesFragment : Fragment() {

    private lateinit var binding: FragmentBeveragesBinding
    private lateinit var viewModel: BeveragesViewModel
    private lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBeveragesBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews()
        setupViewModel()
        observeArguments()

    }

    private fun setupViews() {
        bottomNavigationView = requireActivity().findViewById(R.id.bottomNavigationMain)
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this).get(BeveragesViewModel::class.java)
    }

    private fun observeArguments() {
        val bundle: BeveragesFragmentArgs by navArgs()
        val mood = bundle.mood
        val favBeverages = bundle.favBeverages

        favBeverages?.let {
            handleFavBeverage(it)
        } ?: run {
            observeMoodsData(mood!!)
        }
    }

    private fun handleFavBeverage(favBeverage: FavouriteBeverages) {
        val beverage = favBeverage.toBeverages()
        isFavControl(beverage)
        uiControl(beverage)
        binding.progressBarBeverages.visibility = ProgressBar.GONE
    }

    private fun observeMoodsData(mood: Moods) {
        viewModel.getBeverages(mood)
        viewModel.beverageList.observe(viewLifecycleOwner) { beverageList ->
            handleRandomBeverage(beverageList)
        }
    }

    private fun handleRandomBeverage(beverageList: List<Beverages>) {
        val beverage = beverageList.randomOrNull()
        beverage?.let {
            isFavControl(it)
            uiControl(it)
        }
    }


    private fun isFavControl(beverage:Beverages){
        viewModel.isFavouriteBeverage(beverage.beverageName)

        viewModel.isFavouriteBeverageLiveData.observe(viewLifecycleOwner){
                isChecked->
            binding.checkBox.isChecked = isChecked



            binding.checkBox.setOnCheckedChangeListener { checkBox, isChecked ->
                if (isChecked){
                    StyleableToast.makeText(requireContext(), "${beverage.beverageName} Favorilere Eklendi", Toast.LENGTH_LONG, R.style.customToast).show();
                    viewModel.saveFavBeverages(beverage.toFavBeverages())

                }
                else{
                    StyleableToast.makeText(requireContext(), "${beverage.beverageName} Favorilerden Çıkarıldı", Toast.LENGTH_LONG, R.style.customToast).show();
                    viewModel.deleteFromFavourite(beverage.toFavBeverages())
                }
            }
        }
    }

    private fun uiControl(beverage: Beverages){
        binding.beverageContents.text = beverage.contents
        binding.beveragePreparation.text = beverage.preparation

        binding.beverageName.text=beverage.beverageName

        Glide.with(requireContext())
            .load(beverage.imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.beverageImageView)


        binding.webView.webViewClient = WebViewClient()
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.settings.domStorageEnabled = true

        val videoId = beverage.youtubeVideoId
        val embedHTML = "<html><body><iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/$videoId\" frameborder=\"0\" allowfullscreen></iframe></body></html>"
       binding.webView.loadData(embedHTML, "text/html", "utf-8")

        viewModel.loading.observe(viewLifecycleOwner){
            if (it){
                binding.progressBarBeverages.visibility=ProgressBar.VISIBLE
            }
            else{
                binding.progressBarBeverages.visibility=ProgressBar.GONE

            }
        }
    }

    override fun onResume() {
        super.onResume()
        bottomNavigationView.visibility = View.GONE

    }


    override fun onPause() {
        super.onPause()
        bottomNavigationView.visibility = View.VISIBLE
    }

}