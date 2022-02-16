package com.example.youtube.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube.R
import com.example.youtube.model.Feed
import com.example.youtube.model.Shorts
import com.google.android.material.imageview.ShapeableImageView
import java.util.ArrayList

class ShortsAdapterWhite(var context: Context, var items: ArrayList<Shorts>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shorts_white, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val video = items[position]
        if (holder is FeedViewHolder){
            val tv_text = holder.tv_text
            val tv_views = holder.tv_views
            val iv_video = holder.iv_shorts

            tv_text.text = video.text
            tv_views.text = video.views
            iv_video.setImageResource(video.photo)
        }
    }

    class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_shorts : ShapeableImageView = view.findViewById(R.id.iv_shorts)
        var tv_text : TextView = view.findViewById(R.id.tv_text)
        var tv_views : TextView = view.findViewById(R.id.tv_views)
    }
}