
package com.example.photogallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(
    private val images: List<Int>,
    private val onThumbnailClick: (Int) -> Unit
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val thumbnail: ImageView = itemView.findViewById(R.id.thumbnail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_thumbnail, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.thumbnail.setImageResource(images[position])
        holder.thumbnail.setOnClickListener { onThumbnailClick(position) }
    }

    override fun getItemCount(): Int = images.size
}
