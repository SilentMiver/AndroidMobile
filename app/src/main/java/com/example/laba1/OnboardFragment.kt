package com.example.laba1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.laba1.databinding.FragmentOnboardBinding

class OnboardFragment : Fragment() {
    private var _binding: FragmentOnboardBinding? = null
    private val binding get() = _binding ?: throw RuntimeException()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.labelButton.setOnClickListener {
            findNavController().navigate(OnboardFragmentDirections.actionOnboardToSignIn())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}