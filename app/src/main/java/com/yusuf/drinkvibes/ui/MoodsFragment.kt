package com.yusuf.drinkvibes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.yusuf.drinkvibes.databinding.FragmentMoodsBinding
import com.yusuf.drinkvibes.ui.adapter.MoodsAdapter
import com.yusuf.drinkvibes.ui.viewModel.MoodsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoodsFragment : Fragment() {

    private lateinit var binding: FragmentMoodsBinding
    private lateinit var adapter: MoodsAdapter
    private val viewModel: MoodsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoodsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeData()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllMoods()
    }

    private fun setupRecyclerView() {
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.moodRecyclerView.layoutManager = layoutManager
    }

    private fun observeData() {
        viewModel.moodList.observe(viewLifecycleOwner) { moods ->
            moods?.let {
                adapter = MoodsAdapter(viewModel, requireContext(), moods)
                binding.moodRecyclerView.adapter = adapter
            }
        }

        viewModel.loading.observe(viewLifecycleOwner) { loading ->
            binding.progressBar.visibility = if (loading) ProgressBar.VISIBLE else ProgressBar.INVISIBLE
            binding.moodRecyclerView.visibility = if (loading) View.INVISIBLE else View.VISIBLE
        }
    }
}
