package com.woonyum.mysololife.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.woonyum.mysololife.R
import com.woonyum.mysololife.databinding.FragmentTalkBinding
import com.woonyum.mysololife.databinding.FragmentTipBinding

class TalkFragment : Fragment() {

    private lateinit var binding: FragmentTalkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_talk, container, false)
        binding.tabHome.setOnClickListener {

            findNavController().navigate(R.id.action_talkFragment_to_homeFragment)
        }
        binding.tabBookmark.setOnClickListener {

            findNavController().navigate(R.id.action_talkFragment_to_bookmarkFragment)
        }
        binding.tabStore.setOnClickListener {

            findNavController().navigate(R.id.action_talkFragment_to_storeFragment)
        }
        binding.tabTip.setOnClickListener {

            findNavController().navigate(R.id.action_talkFragment_to_tipFragment)
        }
        return binding.root
    }
}