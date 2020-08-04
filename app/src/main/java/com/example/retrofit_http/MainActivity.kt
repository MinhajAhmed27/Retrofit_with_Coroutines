package com.example.retrofit_http

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retService= RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java)

        val responseLiveData: LiveData<Response<Albums>> = liveData {
            val response=retService.getAlbums()
                emit(response)
        }
        responseLiveData.observe(this, Observer {
//            val data = it.body()
            val listItem = ArrayList<AlbumsItem>()

            val albumsList=it.body()?.listIterator()
            if(albumsList!=null){
                while (albumsList.hasNext()){
                    val albumsItem= albumsList.next()
                    listItem.add(albumsItem)
                }
            }

            val recyclerView=findViewById(R.id.recyclerView) as RecyclerView
            recyclerView.layoutManager=LinearLayoutManager(this,RecyclerView.VERTICAL,false)
            val adapter =CustomAdapter(listItem)
            recyclerView.adapter=adapter

        })
    }
}