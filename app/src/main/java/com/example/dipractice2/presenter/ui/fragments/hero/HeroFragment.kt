package com.example.dipractice2.presenter.ui.fragments.hero

import androidx.navigation.fragment.navArgs
import com.example.dipractice2.databinding.FragmentHeroBinding
import com.example.dipractice2.extensions.setImage
import com.example.dipractice2.presenter.ui.fragments.base.BaseFragment

class HeroFragment : BaseFragment<FragmentHeroBinding>(FragmentHeroBinding::inflate) {

    private val args : HeroFragmentArgs by navArgs()

    override fun start() {

        binding?.apply {
            portrait.setImage(args.portrait)
            portraitFull.setImage(args.fullPortrait)
            textView.text = args.name
        }

    }

    override fun initRecycler() {
    }
}