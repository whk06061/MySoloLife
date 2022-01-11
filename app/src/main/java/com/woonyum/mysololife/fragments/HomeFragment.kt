package com.woonyum.mysololife.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.woonyum.mysololife.R
import com.woonyum.mysololife.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.tabTip.setOnClickListener {

            findNavController().navigate(R.id.action_homeFragment_to_tipFragment)
        }
        binding.tabBookmark.setOnClickListener {

            findNavController().navigate(R.id.action_homeFragment_to_bookmarkFragment)
        }
        binding.tabStore.setOnClickListener {

            findNavController().navigate(R.id.action_homeFragment_to_storeFragment)
        }
        binding.tabTalk.setOnClickListener {

            findNavController().navigate(R.id.action_homeFragment_to_talkFragment)
        }
        return binding.root
    }

}