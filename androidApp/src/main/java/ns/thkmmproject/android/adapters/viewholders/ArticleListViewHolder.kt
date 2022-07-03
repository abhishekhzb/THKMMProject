package com.ns.thehindu.android.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ns.thkmmproject.model.ArticleItem
import ns.thkmmproject.android.R

class ArticleListViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
    val imageView = itemView.findViewById<ImageView>(R.id.image_article)
    val textView = itemView.findViewById<TextView>(R.id.textview_title)
    val premium_imageview = itemView.findViewById<ImageView>(R.id.premium_imageview)
    val section_textview = itemView.findViewById<TextView>(R.id.section_textview)

    fun bind(mList: ArticleItem) {
        if(mList.img_url!=""){
            Picasso.get().load(mList.img_url).error(R.drawable.bg_layout)
                .placeholder(R.drawable.transparent_black).into(imageView)
        }
        textView.text = mList.title
        section_textview.text = mList.section

        if (mList.premium.equals("0")) {
            premium_imageview.visibility = View.GONE
        } else {
            premium_imageview.visibility = View.VISIBLE
        }
    }
}