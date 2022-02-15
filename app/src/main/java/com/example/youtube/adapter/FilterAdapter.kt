package com.example.youtube.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube.R
import com.example.youtube.model.Feed
import com.example.youtube.model.Filter
import com.google.android.material.imageview.ShapeableImageView
import java.util.ArrayList

class FilterAdapter (var context: Context, var items: ArrayList<Filter>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ADDED_YES = 0
    private val TYPE_ADDED_NO = 1


    override fun getItemViewType(position: Int): Int {

        val chat: Filter = items[position]
        return if (!chat.isExplore) {
            TYPE_ADDED_NO
        }
        else TYPE_ADDED_YES
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if(viewType == TYPE_ADDED_YES){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_filter_explore, parent, false)
            return FeedViewHolderExplore(view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_filter, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val video = items[position]
        if (holder is FeedViewHolder){
            val tv_title = holder.tv_title

            tv_title.text = video.title
        }else if (holder is FeedViewHolderExplore){
            val ll_explore = holder.ll_explore

            ll_explore.layout(video?.layout!!,0,0,0)
        }
    }

    class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tv_title : TextView = view.findViewById(R.id.tv_title)
    }
    class FeedViewHolderExplore(view: View) : RecyclerView.ViewHolder(view) {
        var ll_explore : LinearLayout = view.findViewById(R.id.ll_explore_all)
    }
}