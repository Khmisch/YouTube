package com.example.youtube.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube.R
import com.example.youtube.adapter.FeedAdapter
import com.example.youtube.adapter.FilterAdapter
import com.example.youtube.adapter.ShortsAdapter
import com.example.youtube.model.Feed
import com.example.youtube.model.Filter
import com.example.youtube.model.Shorts
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var recyclerFeed: RecyclerView
    lateinit var recyclerShorts: RecyclerView
    lateinit var recyclerFilter: RecyclerView
    lateinit var iv_youtube: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        iv_youtube = findViewById(R.id.iv_youtube)
        recyclerFeed = findViewById(R.id.recyclerFeed)
        recyclerFilter = findViewById(R.id.recyclerFilter)
        recyclerShorts = findViewById(R.id.recyclerShorts)
        recyclerFilter.setLayoutManager(LinearLayoutManager(this,(LinearLayoutManager.HORIZONTAL), false))
        recyclerShorts.setLayoutManager(LinearLayoutManager(this,(LinearLayoutManager.HORIZONTAL), false))
        recyclerFeed.setLayoutManager(GridLayoutManager(this, 1))

        refreshFeedAdapter(getAllFeeds())
        refreshStoryAdapter(getAllFilters())
        refreshShortsAdapter(getAllShorts())
        iv_youtube.setOnClickListener( View.OnClickListener{
            callDarkModeActivity()
        })

    }

    private fun callDarkModeActivity() {
        var intent = Intent(this, MainActivityWhite::class.java)
        startActivity(intent)
    }

    private fun refreshFeedAdapter(chats: ArrayList<Feed>) {
        val adapter = FeedAdapter(this, chats)
        recyclerFeed!!.adapter = adapter

    }

    private fun refreshStoryAdapter(chats: ArrayList<Filter>) {
        val adapter = FilterAdapter(this, chats)
        recyclerFilter!!.adapter = adapter

    }
    private fun refreshShortsAdapter(chats: ArrayList<Shorts>) {
        val adapter = ShortsAdapter(this, chats)
        recyclerShorts!!.adapter = adapter

    }
    private fun getAllFeeds(): ArrayList<Feed> {
        val chats: ArrayList<Feed> = ArrayList<Feed>()
        chats.add(Feed(R.drawable.im_sample_007, R.drawable.im_user_3))
        chats.add(Feed(R.drawable.im_person_me, R.drawable.im_user_4))
        chats.add(Feed(R.drawable.im_sample_007, R.drawable.im_video))
        chats.add(Feed(R.drawable.im_person_00, R.drawable.im_user_3))
        chats.add(Feed(R.drawable.im_person_ketty, R.drawable.im_katty_perry))

        return chats
    }
    private fun getAllFilters(): ArrayList<Filter> {
        val chats: ArrayList<Filter> = ArrayList<Filter>()
        chats.add(Filter("",R.id.ll_explore_all,true))
        chats.add(Filter("Music"))
        chats.add(Filter("Computer Programming" ))
        chats.add(Filter("Android Native"))
        chats.add(Filter("Mobile Development" ))
        chats.add(Filter("Cyber security" ))
        return chats
    }
    private fun getAllShorts(): ArrayList<Shorts> {
        val chats: ArrayList<Shorts> = ArrayList<Shorts>()
        chats.add(Shorts(R.drawable.im_shorts_2,"Jimmy Fallon almost gave Taylor Swift Heart attack","149k views"))
        chats.add(Shorts(R.drawable.im_shorts_3,"#MarkRufallo almost had to transform into #Hulk for his dau...","180k views"))
        chats.add(Shorts(R.drawable.im_shorts_5,"Pair Free Skating | Gold Medal Alijona Savchenko and Bruno...","27M views"))
        chats.add(Shorts(R.drawable.im_shorts_1,"Spill your guts with Kendal Jenner","103k views"))
        chats.add(Shorts(R.drawable.im_shorts_4,"Robert Downey In Tonight Show","23M views"))
        chats.add(Shorts(R.drawable.im_shorts_6,"Sure you are joking Mr Feynman","43M views"))

        return chats
    }


}