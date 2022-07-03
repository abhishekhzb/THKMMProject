package com.ns.thehindu.android.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ns.thehindu.android.DataWidgets
import com.ns.thehindu.android.viewholders.TopBannerViewHolder
import com.ns.thehindu.android.viewholders.WidgetsViewHolder

import ns.thkmmproject.android.R
import ns.thkmmproject.model.ArticleItem
import ns.thkmmproject.model.ArticleItemWidgets
import ns.thkmmproject.util.Constants
import ns.thkmmproject.util.Constants.Companion.VIEW_WIDGETS_HORIZONATAL
import ns.thkmmproject.util.Constants.Companion.VIEW_WIDGETS_VAERTICAL

class WidgetsAdapter(val context: Context, val mList: MutableList<ArticleItemWidgets>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            VIEW_WIDGETS_HORIZONATAL->{
                return WidgetsViewHolder(LayoutInflater.from(context).inflate(R.layout.article_horizontal_list_row, parent, false))
            }
        }
        return WidgetsViewHolder(LayoutInflater.from(context).inflate(R.layout.article_row, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = mList[position]
        when (item.viewType) {
            VIEW_WIDGETS_HORIZONATAL -> {

            }
            VIEW_WIDGETS_VAERTICAL->{
                Log.e("WidgetsAdapter",""+item)
                item.let { (holder as WidgetsViewHolder).bind(item) }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return mList[position].viewType
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}