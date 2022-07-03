package com.ns.thehindu.android.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ns.thehindu.android.viewholders.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import ns.thkmmproject.android.R
import ns.thkmmproject.model.SectionListItem
import ns.thkmmproject.network.ApiCall
import ns.thkmmproject.util.Constants.Companion.VIEW_TYPE_ADS
import ns.thkmmproject.util.Constants.Companion.VIEW_TYPE_ARTICLE_LIST
import ns.thkmmproject.util.Constants.Companion.VIEW_TYPE_HOME_TOP_BANNER
import ns.thkmmproject.util.Constants.Companion.VIEW_TYPE_SEARCH
import ns.thkmmproject.util.Constants.Companion.VIEW_TYPE_SUBSECTION
import ns.thkmmproject.util.Constants.Companion.VIEW_TYPE_WIDGETS_HORIZONTAL
import ns.thkmmproject.util.Constants.Companion.VIEW_TYPE_WIDGETS_VERTICAL


class ArticleAdapter(val context: Context, var mList: MutableList<SectionListItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /*var mList: MutableList<SectionListItem>
    init {
        this.mList = mList
    }*/

    // onCreateViewHolder()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_HOME_TOP_BANNER) {
            return TopBannerViewHolder(LayoutInflater.from(context).inflate(R.layout.top_banner_row, parent, false))
        }
        if (viewType == VIEW_TYPE_ADS) {
            return ArticleListViewHolder(LayoutInflater.from(context).inflate(R.layout.ads_row, parent, false))
        }
        if (viewType == VIEW_TYPE_WIDGETS_HORIZONTAL) {
            return HorizontalListViewHolder(LayoutInflater.from(context).inflate(R.layout.horizontal_list_row, parent, false))
        }
        if (viewType == VIEW_TYPE_WIDGETS_VERTICAL) {
            return VerticalListViewHolder(LayoutInflater.from(context).inflate(R.layout.vertical_list_row, parent, false))
        }
        if (viewType == VIEW_TYPE_SUBSECTION) {
            return SubsectionViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_row, parent, false))
        }
        if (viewType == VIEW_TYPE_SEARCH) {
            return SearchViewHolder(LayoutInflater.from(context).inflate(R.layout.search_row, parent, false))
        }
        return ArticleListViewHolder(LayoutInflater.from(context).inflate(R.layout.article_row, parent, false))
    }

    private val mainScope = MainScope()
    // onBindViewHolder()
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = mList[position]
        when(item.viewType) {
            VIEW_TYPE_HOME_TOP_BANNER -> {
                item.let { (holder as TopBannerViewHolder).bind(it.singleRowItem) }
            }
            VIEW_TYPE_ARTICLE_LIST -> {
                item.let { (holder as ArticleListViewHolder).bind(it.singleRowItem) }
            }
            VIEW_TYPE_WIDGETS_VERTICAL->{
              //  item.let { (holder as VerticalListViewHolder).bind(it.widgetsModel,context) }
            }
        }
    }

    // getItemViewType ()
    override fun getItemViewType(position: Int): Int {
        val item = mList[position]
        return item.viewType
    }

    // getItemCount()
    override fun getItemCount(): Int {
        return mList.size
    }

    fun insertItemData(rowItem : SectionListItem ) {
        mList.add(rowItem)
        notifyDataSetChanged()
    }

    fun insertBulkItemData(rowItems : MutableList<SectionListItem>, index : Int) {
        mList.addAll(index, rowItems)
        notifyDataSetChanged()
    }

}