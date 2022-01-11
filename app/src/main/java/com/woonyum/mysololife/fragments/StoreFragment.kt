package com.woonyum.mysololife.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.woonyum.mysololife.R
import com.woonyum.mysololife.databinding.FragmentStoreBinding
import com.woonyum.mysololife.databinding.FragmentTalkBinding

class StoreFragment : Fragment() {

    private lateinit var binding: FragmentStoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_store, container, false)
        binding.tabHome.setOnClickListener {

            findNavController().navigate(R.id.action_storeFragment_to_homeFragment)
        }
        binding.tabBookmark.setOnClickListener {

            findNavController().navigate(R.id.action_storeFragment_to_bookmarkFragment)
        }
        binding.tabTalk.setOnClickListener {

            findNavController().navigate(R.id.action_storeFragment_to_talkFragment)
        }
        binding.tabTip.setOnClickListener {

            findNavController().navigate(R.id.action_storeFragment_to_tipFragment)
        }
        return binding.root
    }

}