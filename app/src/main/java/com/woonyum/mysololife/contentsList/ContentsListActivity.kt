package com.woonyum.mysololife.contentsList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import com.woonyum.mysololife.R
import com.woonyum.mysololife.utils.FBAuth
import com.woonyum.mysololife.utils.FBRef

class ContentsListActivity : AppCompatActivity() {

    val items = mutableListOf<ContentModel>()
    val item_keys = mutableListOf<String>()
    val bookmarkIdList = mutableListOf<String>()
    val rvAdapter = ContentsRVAdapter(items, item_keys, bookmarkIdList)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contents_list)

        // Write a message to the database


        val category = intent.getStringExtra("카테고리")

        //무슨 카테고리를 선택했냐에 따라 reference 다르게

        if (category == "all") {
            FBRef.contents_all_ref.addValueEventListener(getContentsEventListener())
        } else if (category == "cook") {
            FBRef.contents_cook_ref.addValueEventListener(getContentsEventListener())
        }

        val rv = findViewById<RecyclerView>(R.id.recyclerView)

        rv.adapter = rvAdapter
        rv.layoutManager = GridLayoutManager(this, 2)

        FBRef.bookmark_ref.child(FBAuth.getUid()).addValueEventListener(getBookMarks())

    }

    private fun getContentsEventListener(): ValueEventListener {
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (data in dataSnapshot.children) {
                    val item = data.getValue<ContentModel>()
                    Log.d("데이터", data.toString())
                    items.add(item!!)
                    item_keys.add(data.key.toString())
                }
                //어댑터 갱신
                rvAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        }
        return postListener
    }

    private fun getBookMarks(): ValueEventListener {
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                bookmarkIdList.clear()
                for (data in dataSnapshot.children) {
                    val key = data.key
                    bookmarkIdList.add(key!!)
                }
                //어댑터 갱신
                rvAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        }
        return postListener
    }
}