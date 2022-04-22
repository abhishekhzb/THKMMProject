package com.ns.thehindu.android.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ns.thehindu.android.Data
import com.ns.thehindu.android.viewholders.*
import ns.thkmmproject.android.R


class ArticleAdapter(val context: Context, val mList: List<Data>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_HOME_TOP_BANNER = 0
        const val VIEW_TYPE_ARTICLE_LIST = 1
        const val VIEW_TYPE_ADS = 2
        const val VIEW_TYPE_HORIZONTAL_LIST = 3
        const val VIEW_TYPE_FRAGMENT = 4
        const val VIEW_TYPE_SEARCH = 5
    }

    // onCreateViewHolder()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_HOME_TOP_BANNER) {
            return TopBannerViewHolder(LayoutInflater.from(context).inflate(R.layout.top_banner_row, parent, false))
        }
        if (viewType == VIEW_TYPE_ADS) {
            return ArticleListViewHolder(LayoutInflater.from(context).inflate(R.layout.ads_row, parent, false))
        }
        if (viewType == VIEW_TYPE_HORIZONTAL_LIST) {
            return HorizontalListViewHolder(LayoutInflater.from(context).inflate(R.layout.horizontal_list_row, parent, false))
        }
        if (viewType == VIEW_TYPE_FRAGMENT) {
            return FragmentViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_row, parent, false))
        }
        if (viewType == VIEW_TYPE_SEARCH) {
            return SearchViewHolder(LayoutInflater.from(context).inflate(R.layout.search_row, parent, false))
        }
        return ArticleListViewHolder(LayoutInflater.from(context).inflate(R.layout.article_row, parent, false))
    }

    // onBindViewHolder()
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (mList[position].viewType == VIEW_TYPE_HOME_TOP_BANNER) {
            val item = mList[position]
            (holder as TopBannerViewHolder).bind(item)
        }
        if (mList[position].viewType == VIEW_TYPE_ARTICLE_LIST) {
            val item = mList[position]
            (holder as ArticleListViewHolder).bind(item)
        }
        if (mList[position].viewType == VIEW_TYPE_HORIZONTAL_LIST) {
            val item = mList[position]
            (holder as HorizontalListViewHolder).bind(item,context)
        }
        if (mList[position].viewType == VIEW_TYPE_FRAGMENT) {
            val item = mList[position]
            (holder as FragmentViewHolder).bind(item,context)
        }
        else {
            val item = mList[position]
        }
    }

    // getItemViewType ()
    override fun getItemViewType(position: Int): Int {
        if (mList[position].viewType == VIEW_TYPE_HOME_TOP_BANNER) {
            return mList[position].viewType
        }
        if (mList[position].viewType == VIEW_TYPE_ADS) {
            return mList[position].viewType
        }
        if (mList[position].viewType == VIEW_TYPE_ARTICLE_LIST) {
            return mList[position].viewType
        }
        return mList[position].viewType
    }

    // getItemCount()
    override fun getItemCount(): Int {
        return mList.size
    }

}