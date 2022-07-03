package com.ns.thehindu.android.viewholders

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ns.thehindu.android.adapters.WidgetsAdapter
import ns.thkmmproject.android.R
import ns.thkmmproject.model.WidgetsModel

class VerticalListViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

    val textView = itemView.findViewById<TextView>(R.id.textview_title)
    val recyclerView = itemView.findViewById<RecyclerView>(R.id.recyclerview_widgets)

    fun bind(widgetsModel: WidgetsModel, context: Context) {
        textView.text = "SPORTSTAR"

        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter = WidgetsAdapter(context, widgetsModel.data)
        recyclerView.adapter = adapter
    }

}