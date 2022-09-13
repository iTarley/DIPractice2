package com.example.dipractice2.presenter.ui.fragments.main

import android.opengl.Visibility
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.dipractice2.databinding.FragmentMainBinding
import com.example.dipractice2.presenter.ui.adapter.HeroAdapter
import com.example.dipractice2.presenter.ui.fragments.base.BaseFragment
import com.example.dipractice2.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val viewModel: MainViewModel by viewModels()
    private val adapter by lazy {
        HeroAdapter()
    }

    override fun start() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getHero()
                viewModel.heroFlow.collect {
                    when (it) {
                        is Resource.Error -> Log.d("error", "start: ${it.errorMessage}")
                        is Resource.Loading -> {
                            binding?.progressBar?.visibility = View.VISIBLE
                        }
                        is Resource.Success -> {
                            adapter.submitList(it.result)
                            binding?.progressBar?.visibility = View.INVISIBLE

                        }
                    }
                }
            }
        }
    }


    override fun initRecycler() {
        binding?.recycler?.adapter = adapter

    }
}