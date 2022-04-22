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

        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val data = arrayList()
        val adapter = WidgetsAdapter(context, data)
        recyclerView.adapter = adapter
    }


    private fun arrayList(): ArrayList<DataWidgets> {
        val data = ArrayList<DataWidgets>()
        // for (i in 1..20) {
        data.add(
            DataWidgets(
                WidgetsAdapter.VIEW_WIDGETS_TOP_PICKS,
                "https://www.thehindu.com/incoming/hl6klt/article65292087.ece/alternates/FREE_1200/Elon_Musk_Twitter_21218.jpg-b14e7.jpg",
                "Elon Musk sued over delay in disclosing Twitter stake"
            )
        )
        data.add(
            DataWidgets(
                WidgetsAdapter.VIEW_WIDGETS_TOP_PICKS,
                "https://www.thehindu.com/incoming/tk3tyh/article65310947.ece/alternates/FREE_1200/Palmking%20in%20Tenkasi.jpg",
                "Rare butterfly Palmking spotted for the first time in Tamil Nadu"
            )
        )
        data.add(
            DataWidgets(
                WidgetsAdapter.VIEW_WIDGETS_TOP_PICKS,
                "https://www.thehindu.com/news/national/qhfhq2/article65313785.ece/alternates/FREE_1200/WhatsApp%20Image%202022-04-12%20at%2012.31.32%20PM.jpeg",
                "‘Occupy Galle Face’: A tent city of resistance beside Colombo’s seat of power"
            )
        )
        data.add(
            DataWidgets(
                WidgetsAdapter.VIEW_WIDGETS_TOP_PICKS,
                "https://www.thehindu.com/news/national/wp9qtu/article65313989.ece/alternates/FREE_1200/2150_13-6-2018_15-31-10_1_MONSOONMEGHALAYA_13062018_01.JPG",
                "No El Nino expected, it will be a ‘normal’ monsoon, says Skymet"
            )
        )
        data.add(
            DataWidgets(
                WidgetsAdapter.VIEW_WIDGETS_TOP_PICKS,
                "https://www.thehindu.com/news/national/wp9qtu/article65313989.ece/alternates/FREE_1200/2150_13-6-2018_15-31-10_1_MONSOONMEGHALAYA_13062018_01.JPG",
                "No El Nino expected, it will be a ‘normal’ monsoon, says Skymet"
            )
        )
        data.add(
            DataWidgets(
                WidgetsAdapter.VIEW_WIDGETS_TOP_PICKS,
                "https://www.thehindu.com/incoming/hl6klt/article65292087.ece/alternates/FREE_1200/Elon_Musk_Twitter_21218.jpg-b14e7.jpg",
                "Elon Musk sued over delay in disclosing Twitter stake"
            )
        )
        data.add(
            DataWidgets(
                WidgetsAdapter.VIEW_WIDGETS_TOP_PICKS,
                "https://www.thehindu.com/incoming/tk3tyh/article65310947.ece/alternates/FREE_1200/Palmking%20in%20Tenkasi.jpg",
                "Rare butterfly Palmking spotted for the first time in Tamil Nadu"
            )
        )
        data.add(
            DataWidgets(
                WidgetsAdapter.VIEW_WIDGETS_TOP_PICKS,
                "https://www.thehindu.com/news/national/qhfhq2/article65313785.ece/alternates/FREE_1200/WhatsApp%20Image%202022-04-12%20at%2012.31.32%20PM.jpeg",
                "‘Occupy Galle Face’: A tent city of resistance beside Colombo’s seat of power"
            )
        )
        return data
    }

}