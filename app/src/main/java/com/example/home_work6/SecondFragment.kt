package com.example.home_work6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.home_work6.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private var anime = mutableListOf<Anime>()
    private lateinit var binding: FragmentSecondBinding
    private val animeAdapter = AnimeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageAnime()
        setupRecyclerView()
    }

    private fun imageAnime() {
        anime.apply {
            add(Anime(R.drawable.hunter, " хантер х хантер"))
            add(Anime(R.drawable.berserk, "берсерк"))
            add(Anime(R.drawable.anime3, " кибер панк"))
            add(Anime(R.drawable.bleach, "блич"))

        }
    }

    private fun setupRecyclerView() {
        binding.recyclerview.adapter = animeAdapter
        animeAdapter.setData(anime)
    }
}
