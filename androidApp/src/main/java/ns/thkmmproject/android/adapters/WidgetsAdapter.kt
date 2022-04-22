package com.ns.thehindu.android.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ns.thehindu.android.DataWidgets
import com.ns.thehindu.android.viewholders.WidgetsViewHolder

import ns.thkmmproject.android.R

class WidgetsAdapter(val context: Context, val mList: List<DataWidgets>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_WIDGETS_TOP_PICKS = 0
    }

    // onCreateViewHolder()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_WIDGETS_TOP_PICKS) {
            return WidgetsViewHolder(LayoutInflater.from(context).inflate(R.layout.article_horizontal_list_row, parent, false))
        }

        return WidgetsViewHolder(LayoutInflater.from(context).inflate(R.layout.article_horizontal_list_row, parent, false))
    }

    // onBindViewHolder()
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (mList[position].viewType == VIEW_WIDGETS_TOP_PICKS) {
            val item = mList[position]
            (holder as WidgetsViewHolder).bind(item)
        }
        else {
            val item = mList[position]
        }
    }

    // getItemViewType ()
    override fun getItemViewType(position: Int): Int {
        if (mList[position].viewType == VIEW_WIDGETS_TOP_PICKS) {
            return mList[position].viewType
        }
        return mList[position].viewType
    }

    // getItemCount()
    override fun getItemCount(): Int {
        return mList.size
    }

}