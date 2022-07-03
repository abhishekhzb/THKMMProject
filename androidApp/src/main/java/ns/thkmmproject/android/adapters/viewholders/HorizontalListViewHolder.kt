package com.ns.thehindu.android.viewholders

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ns.thehindu.android.Data
import com.ns.thehindu.android.DataWidgets
import com.ns.thehindu.android.adapters.ArticleAdapter
import com.ns.thehindu.android.adapters.WidgetsAdapter
import ns.thkmmproject.android.R

class HorizontalListViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

    val textView = itemView.findViewById<TextView>(R.id.textview_title)
    val recyclerView = itemView.findViewById<RecyclerView>(R.id.recyclerview_widgets)

    fun bind(item: Data, context: Context) {
        textView.text = "Top Picks"

//        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//        val data = arrayList()
//        val adapter = WidgetsAdapter(context, data)
//        recyclerView.adapter = adapter
    }

}