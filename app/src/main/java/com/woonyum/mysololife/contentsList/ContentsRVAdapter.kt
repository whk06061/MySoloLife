package com.woonyum.mysololife.contentsList

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.woonyum.mysololife.R
import com.woonyum.mysololife.utils.FBAuth
import com.woonyum.mysololife.utils.FBRef

class ContentsRVAdapter(
    val items: MutableList<ContentModel>,
    val keys: MutableList<String>,
    val bookmarkIds: MutableList<String>
) :
    RecyclerView.Adapter<ContentsRVAdapter.Viewholder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContentsRVAdapter.Viewholder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.contents_rv_item, parent, false)

        return Viewholder(parent.context, v)
    }

    override fun onBindViewHolder(holder: ContentsRVAdapter.Viewholder, position: Int) {
        holder.bindItems(items[position], keys[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class Viewholder(val context: Context, itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bindItems(item: ContentModel, key: String) {

            val imageView = itemView.findViewById<ImageView>(R.id.iv_rv_item)
            val textView = itemView.findViewById<TextView>(R.id.tv_title)
            val bookmark = itemView.findViewById<ImageView>(R.id.iv_bookmark)

            //대박,,,,, 스크롤 내릴때마다 bindItems 함수 실행됨 다시 올려도 실행됨 화면에 보일때마다 bind 해주는듯 대박
            //Log.d("리사이클", key)
            if (bookmarkIds.contains(key)) {
                bookmark.setImageResource(R.drawable.bookmark_color)
            } else {
                bookmark.setImageResource(R.drawable.bookmark_white)
            }

            textView.text = item.title
            Glide.with(context).load(item.imageUrl).into(imageView)

            imageView.setOnClickListener {
                val intent = Intent(context, ContentShowActivity::class.java)
                intent.putExtra("url", item.url)
                context.startActivity(intent)
            }

            bookmark.setOnClickListener {
                //북마크가 이미 되어있는 경우
                if (bookmarkIds.contains(key)) {
                    val bookmarkRef = FBRef.bookmark_ref
                    bookmarkRef.child(FBAuth.getUid()).child(key).removeValue()
                } else {
                    //북마크가 안되어있는 경우
                    val bookmarkRef = FBRef.bookmark_ref
                    bookmarkRef.child(FBAuth.getUid()).child(key).setValue("")
                }


            }
        }
    }
}