package com.example.home_work6

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.home_work6.databinding.AnimeItemBinding

class AnimeAdapter : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    private var anime = listOf<Anime>()

    fun setData(data: List<Anime>) {
        anime = data
        notifyDataSetChanged()
    }

    class AnimeViewHolder(private val binding: AnimeItemBinding) : ViewHolder(binding.root) {

        fun onBind(anime: Anime) = with(binding) {
            ivAnime.setImageResource(anime.image)
            tvNameAnime.text = anime.name
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): AnimeViewHolder {
        val binding = AnimeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.onBind(anime[position])
    }

    override fun getItemCount(): Int = anime.size
}