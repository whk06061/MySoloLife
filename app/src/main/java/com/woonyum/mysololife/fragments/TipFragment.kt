package com.woonyum.mysololife.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.woonyum.mysololife.R
import com.woonyum.mysololife.contentsList.ContentsListActivity
import com.woonyum.mysololife.databinding.FragmentHomeBinding
import com.woonyum.mysololife.databinding.FragmentTipBinding

class TipFragment : Fragment() {

    private lateinit var binding: FragmentTipBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tip, container, false)

        binding.imageCategoryAll.setOnClickListener {
            val intent = Intent(context, ContentsListActivity::class.java)
            intent.putExtra("카테고리","all")
            startActivity(intent)
        }

        binding.imageCategoryCook.setOnClickListener {
            val intent = Intent(context, ContentsListActivity::class.java)
            intent.putExtra("카테고리","cook")
            startActivity(intent)
        }

        binding.tabHome.setOnClickListener {

            findNavController().navigate(R.id.action_tipFragment_to_homeFragment)
        }
        binding.tabBookmark.setOnClickListener {

            findNavController().navigate(R.id.action_tipFragment_to_bookmarkFragment)
        }
        binding.tabStore.setOnClickListener {

            findNavController().navigate(R.id.action_tipFragment_to_storeFragment)
        }
        binding.tabTalk.setOnClickListener {

            findNavController().navigate(R.id.action_tipFragment_to_talkFragment)
        }
        return binding.root
    }


}