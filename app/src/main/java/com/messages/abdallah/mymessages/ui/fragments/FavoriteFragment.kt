package com.messages.abdallah.mymessages.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.messages.abdallah.mymessages.databinding.FragmentFavoriteBinding
import com.messages.abdallah.mymessages.ui.MainActivity

class FavoriteFragment : Fragment() {

    private var _binding : FragmentFavoriteBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        Log.e("tessst","entred")
        (activity as MainActivity).fragment = 1

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}