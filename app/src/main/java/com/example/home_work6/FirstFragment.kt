package com.example.home_work6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.home_work6.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private var numberCounter = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListeners()

        savedInstanceState?.let {
            numberCounter = it.getInt(COUNT, 0)
            binding.textZero.text = numberCounter.toString()
        }
    }

    private fun setupListeners() = with(binding) {
        buttonPlus.setOnClickListener {
            if (numberCounter < 10) {
                numberCounter++
                textZero.text = numberCounter.toString()
            } else {
                parentFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, SecondFragment())
                    .addToBackStack("First Fragment")
                    .commit()
            }
        }

        buttonMinus.setOnClickListener {
            if (numberCounter > 0) {
                numberCounter--
                textZero.text = numberCounter.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNT, numberCounter)
    }

    companion object {
        const val COUNT = "count"
    }
}