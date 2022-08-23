package com.example.icecream

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.icecream.databinding.FragmentStartBinding
import com.example.icecream.model.OrderViewModel

class StartFragment : Fragment() {
    private lateinit var binding: FragmentStartBinding
    private val sharedViewModel: OrderViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentStartBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    fun nextFragment() {
        if (binding.nameEditText.text!!.isNotEmpty()) {
            setErrorTextField(false)
            sharedViewModel.setName(binding.nameEditText.text.toString())
            goToNextScreen()
        } else {
            setErrorTextField(true)
        }
    }

    private fun setErrorTextField(error: Boolean) {
        if (error) {
            binding.nameLayout.isErrorEnabled = true
            binding.nameLayout.error = getString(R.string.try_again)
        } else {
            binding.nameLayout.isErrorEnabled = false
            binding.nameEditText.text = null
        }
    }

    fun goToNextScreen() {
        if (sharedViewModel.noScoopsYet()) {
            sharedViewModel.setScoops(1)
        }
        findNavController().navigate(R.id.action_startFragment_to_orderFragment)
    }
}