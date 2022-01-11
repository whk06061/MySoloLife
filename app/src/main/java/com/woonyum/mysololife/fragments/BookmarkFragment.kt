package com.woonyum.mysololife.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.woonyum.mysololife.R
import com.woonyum.mysololife.databinding.FragmentBookmarkBinding
import com.woonyum.mysololife.databinding.FragmentTipBinding

class BookmarkFragment : Fragment() {

    private lateinit var binding: FragmentBookmarkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bookmark, container, false)
        binding.tabHome.setOnClickListener {

            findNavController().navigate(R.id.action_bookmarkFragment_to_homeFragment)
        }
        binding.tabTip.setOnClickListener {

            findNavController().navigate(R.id.action_bookmarkFragment_to_tipFragment)
        }
        binding.tabStore.setOnClickListener {

            findNavController().navigate(R.id.action_bookmarkFragment_to_storeFragment)
        }
        binding.tabTalk.setOnClickListener {

            findNavController().navigate(R.id.action_bookmarkFragment_to_talkFragment)
        }
        return binding.root
    }
}