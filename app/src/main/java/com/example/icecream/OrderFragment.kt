package com.example.icecream

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.icecream.databinding.FragmentOrderBinding
import com.example.icecream.model.OrderViewModel

class OrderFragment : Fragment() {
    var binding: FragmentOrderBinding? = null
    val sharedViewModel: OrderViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentOrderBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    fun nextFragment() {

        goToNextScreen()
    }

    fun goToNextScreen() {
        findNavController().navigate(R.id.action_orderFragment_to_flavorFragment)
    }
}