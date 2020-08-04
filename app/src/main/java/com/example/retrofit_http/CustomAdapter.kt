package com.example.retrofit_http

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val albumList:ArrayList<AlbumsItem>):RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album:AlbumsItem=albumList[position]
        holder?.textAlbumId.text=album.id.toString()
        holder?.textTitle.text=album.title
        holder?.textUserId.text=album.userId.toString()

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.list_recylerview,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return albumList.size
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val textAlbumId=itemView.findViewById(R.id.Album_id) as TextView
        val textTitle=itemView.findViewById(R.id.title) as TextView
        val textUserId=itemView.findViewById(R.id.User_id) as TextView
    }

}