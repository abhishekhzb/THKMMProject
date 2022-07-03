package com.ns.thehindu.android.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ns.thehindu.android.Data
import com.ns.thehindu.android.DataWidgets
 import com.squareup.picasso.Picasso
import ns.thkmmproject.android.R
import ns.thkmmproject.model.ArticleItem
import ns.thkmmproject.model.ArticleItemWidgets

class WidgetsViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

    val imageView = itemView.findViewById<ImageView>(R.id.imageview_article)
    val textView = itemView.findViewById<TextView>(R.id.textview_title)

    fun bind(mList: ArticleItemWidgets) {
        Picasso.get().load(mList.img_url).placeholder(R.drawable.transparent_black).into(imageView)
        textView.text = mList.title
    }

}