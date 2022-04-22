package com.ns.thehindu.android.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ns.thehindu.android.Data
import com.squareup.picasso.Picasso
import ns.thkmmproject.android.R

class ArticleListViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
    val imageView = itemView.findViewById<ImageView>(R.id.image_article)
    val textView = itemView.findViewById<TextView>(R.id.textview_title)

    fun bind(mList: Data) {
        Picasso.get().load(mList.image).placeholder(R.drawable.transparent_black).into(imageView)
        textView.text = mList.textData
    }
}