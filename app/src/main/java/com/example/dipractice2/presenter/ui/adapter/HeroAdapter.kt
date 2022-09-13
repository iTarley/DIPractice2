package com.example.dipractice2.presenter.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dipractice2.data.models.HeroModel
import com.example.dipractice2.databinding.GridViewBinding
import com.example.dipractice2.extensions.setImage

typealias onClick = (card: HeroModel.Heroes) -> Unit

class HeroAdapter: ListAdapter<HeroModel.Heroes, HeroAdapter.ViewHolder>(DiffCallBack()) {

    lateinit var onClick: onClick
    private var content = emptyList<HeroModel.Heroes?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            GridViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    class DiffCallBack: DiffUtil.ItemCallback<HeroModel.Heroes>() {
        override fun areItemsTheSame(oldItem: HeroModel.Heroes, newItem: HeroModel.Heroes): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: HeroModel.Heroes, newItem: HeroModel.Heroes): Boolean {
            return oldItem == newItem
        }
    }

    inner class ViewHolder(private val binding: GridViewBinding): RecyclerView.ViewHolder(binding.root){

        private lateinit var currentHero: HeroModel.Heroes
        fun bind(){
            currentHero = getItem(adapterPosition)
            binding.apply {
                portrait.setImage(currentHero.urlVerticalPortrait!!)
            }

        }

    }



}