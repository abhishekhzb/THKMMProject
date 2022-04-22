package com.ns.tabactivity.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ns.thehindu.android.Data
import com.ns.thehindu.android.adapters.ArticleAdapter
import ns.thkmmproject.android.R
import ns.thkmmproject.android.databinding.FragmentMainBinding

/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel
    private var _binding: FragmentMainBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val root = binding.root

         recyclerviewArticle()







//        val textView: TextView = binding.sectionLabel
//        pageViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun recyclerviewArticle() {
        val recyclerView = binding.root.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        val data = arrayList()
        val adapter = ArticleAdapter(requireContext(), data)
        recyclerView.adapter = adapter
    }

    private fun arrayList(): ArrayList<Data> {
        val data = ArrayList<Data>()
        // for (i in 1..20) {
        data.add(
            Data(
                ArticleAdapter.VIEW_TYPE_SEARCH,
                "https://www.thehindu.com/news/national/qhfhq2/article65313785.ece/alternates/FREE_1200/WhatsApp%20Image%202022-04-12%20at%2012.31.32%20PM.jpeg",
                "‘Occupy Galle Face’: A tent city of resistance beside Colombo’s seat of power"
            )
        )
        data.add(
            Data(
                ArticleAdapter.VIEW_TYPE_HOME_TOP_BANNER,
                "https://www.thehindu.com/news/national/qhfhq2/article65313785.ece/alternates/FREE_1200/WhatsApp%20Image%202022-04-12%20at%2012.31.32%20PM.jpeg",
                "‘Occupy Galle Face’: A tent city of resistance beside Colombo’s seat of power"
            )
        )
        data.add(
            Data(
                ArticleAdapter.VIEW_TYPE_ARTICLE_LIST,
                "https://www.thehindu.com/incoming/tk3tyh/article65310947.ece/alternates/FREE_1200/Palmking%20in%20Tenkasi.jpg",
                "Rare butterfly Palmking spotted for the first time in Tamil Nadu"
            )
        )
        data.add(
            Data(
                ArticleAdapter.VIEW_TYPE_ARTICLE_LIST,
                "https://www.thehindu.com/incoming/hl6klt/article65292087.ece/alternates/FREE_1200/Elon_Musk_Twitter_21218.jpg-b14e7.jpg",
                "Elon Musk sued over delay in disclosing Twitter stake"
            )
        )
        data.add(
            Data(
                ArticleAdapter.VIEW_TYPE_ARTICLE_LIST,
                "https://www.thehindu.com/news/national/wp9qtu/article65313989.ece/alternates/FREE_1200/2150_13-6-2018_15-31-10_1_MONSOONMEGHALAYA_13062018_01.JPG",
                "No El Nino expected, it will be a ‘normal’ monsoon, says Skymet"
            )
        )
        data.add(
            Data(
                ArticleAdapter.VIEW_TYPE_HORIZONTAL_LIST,
                "https://www.thehindu.com/news/national/wp9qtu/article65313989.ece/alternates/FREE_1200/2150_13-6-2018_15-31-10_1_MONSOONMEGHALAYA_13062018_01.JPG",
                "No El Nino expected, it will be a ‘normal’ monsoon, says Skymet"
            )
        )
        data.add(
            Data(
                ArticleAdapter.VIEW_TYPE_ADS,
                "https://www.thehindu.com/incoming/hl6klt/article65292087.ece/alternates/FREE_1200/Elon_Musk_Twitter_21218.jpg-b14e7.jpg",
                "Elon Musk sued over delay in disclosing Twitter stake"
            )
        )
        data.add(
            Data(
                ArticleAdapter.VIEW_TYPE_ARTICLE_LIST,
                "https://www.thehindu.com/incoming/tk3tyh/article65310947.ece/alternates/FREE_1200/Palmking%20in%20Tenkasi.jpg",
                "Rare butterfly Palmking spotted for the first time in Tamil Nadu"
            )
        )
        data.add(
            Data(
                ArticleAdapter.VIEW_TYPE_ARTICLE_LIST,
                "https://www.thehindu.com/news/national/qhfhq2/article65313785.ece/alternates/FREE_1200/WhatsApp%20Image%202022-04-12%20at%2012.31.32%20PM.jpeg",
                "‘Occupy Galle Face’: A tent city of resistance beside Colombo’s seat of power"
            )
        )
        data.add(
            Data(
                ArticleAdapter.VIEW_TYPE_ARTICLE_LIST,
                "https://www.thehindu.com/news/national/wp9qtu/article65313989.ece/alternates/FREE_1200/2150_13-6-2018_15-31-10_1_MONSOONMEGHALAYA_13062018_01.JPG",
                "No El Nino expected, it will be a ‘normal’ monsoon, says Skymet"
            )
        )
        data.add(
            Data(
                ArticleAdapter.VIEW_TYPE_ARTICLE_LIST,
                "https://www.thehindu.com/incoming/hl6klt/article65292087.ece/alternates/FREE_1200/Elon_Musk_Twitter_21218.jpg-b14e7.jpg",
                "Elon Musk sued over delay in disclosing Twitter stake"
            )
        )
        data.add(
            Data(
                ArticleAdapter.VIEW_TYPE_ADS,
                "https://www.thehindu.com/incoming/hl6klt/article65292087.ece/alternates/FREE_1200/Elon_Musk_Twitter_21218.jpg-b14e7.jpg",
                "Elon Musk sued over delay in disclosing Twitter stake"
            )
        )
        data.add(
            Data(
                ArticleAdapter.VIEW_TYPE_ARTICLE_LIST,
                "https://www.thehindu.com/incoming/tk3tyh/article65310947.ece/alternates/FREE_1200/Palmking%20in%20Tenkasi.jpg",
                "Rare butterfly Palmking spotted for the first time in Tamil Nadu"
            )
        )
        data.add(
            Data(
                ArticleAdapter.VIEW_TYPE_ARTICLE_LIST,
                "https://www.thehindu.com/news/national/qhfhq2/article65313785.ece/alternates/FREE_1200/WhatsApp%20Image%202022-04-12%20at%2012.31.32%20PM.jpeg",
                "‘Occupy Galle Face’: A tent city of resistance beside Colombo’s seat of power"
            )
        )
        data.add(
            Data(
                ArticleAdapter.VIEW_TYPE_ARTICLE_LIST,
                "https://www.thehindu.com/news/national/wp9qtu/article65313989.ece/alternates/FREE_1200/2150_13-6-2018_15-31-10_1_MONSOONMEGHALAYA_13062018_01.JPG",
                "No El Nino expected, it will be a ‘normal’ monsoon, says Skymet"
            )
        )
        data.add(
            Data(
                ArticleAdapter.VIEW_TYPE_ARTICLE_LIST,
                "https://www.thehindu.com/news/national/qhfhq2/article65313785.ece/alternates/FREE_1200/WhatsApp%20Image%202022-04-12%20at%2012.31.32%20PM.jpeg",
                "‘Occupy Galle Face’: A tent city of resistance beside Colombo’s seat of power"
            )
        )
        data.add(
            Data(
                ArticleAdapter.VIEW_TYPE_ARTICLE_LIST,
                "https://www.thehindu.com/news/national/wp9qtu/article65313989.ece/alternates/FREE_1200/2150_13-6-2018_15-31-10_1_MONSOONMEGHALAYA_13062018_01.JPG",
                "No El Nino expected, it will be a ‘normal’ monsoon, says Skymet"
            )
        )
        data.add(
            Data(
                ArticleAdapter.VIEW_TYPE_ARTICLE_LIST,
                "https://www.thehindu.com/news/national/qhfhq2/article65313785.ece/alternates/FREE_1200/WhatsApp%20Image%202022-04-12%20at%2012.31.32%20PM.jpeg",
                "‘Occupy Galle Face’: A tent city of resistance beside Colombo’s seat of power"
            )
        )
        data.add(
            Data(
                ArticleAdapter.VIEW_TYPE_ARTICLE_LIST,
                "https://www.thehindu.com/news/national/wp9qtu/article65313989.ece/alternates/FREE_1200/2150_13-6-2018_15-31-10_1_MONSOONMEGHALAYA_13062018_01.JPG",
                "No El Nino expected, it will be a ‘normal’ monsoon, says Skymet"
            )
        )
        data.add(
            Data(
                ArticleAdapter.VIEW_TYPE_FRAGMENT,
                "https://www.thehindu.com/news/national/qhfhq2/article65313785.ece/alternates/FREE_1200/WhatsApp%20Image%202022-04-12%20at%2012.31.32%20PM.jpeg",
                "‘Occupy Galle Face’: A tent city of resistance beside Colombo’s seat of power"
            )
        )
        data.add(
            Data(
                ArticleAdapter.VIEW_TYPE_ARTICLE_LIST,
                "https://www.thehindu.com/news/national/wp9qtu/article65313989.ece/alternates/FREE_1200/2150_13-6-2018_15-31-10_1_MONSOONMEGHALAYA_13062018_01.JPG",
                "No El Nino expected, it will be a ‘normal’ monsoon, says Skymet"
            )
        )
        data.add(
            Data(
                ArticleAdapter.VIEW_TYPE_ARTICLE_LIST,
                "https://www.thehindu.com/news/national/qhfhq2/article65313785.ece/alternates/FREE_1200/WhatsApp%20Image%202022-04-12%20at%2012.31.32%20PM.jpeg",
                "‘Occupy Galle Face’: A tent city of resistance beside Colombo’s seat of power"
            )
        )
        data.add(
            Data(
                ArticleAdapter.VIEW_TYPE_ARTICLE_LIST,
                "https://www.thehindu.com/news/national/wp9qtu/article65313989.ece/alternates/FREE_1200/2150_13-6-2018_15-31-10_1_MONSOONMEGHALAYA_13062018_01.JPG",
                "No El Nino expected, it will be a ‘normal’ monsoon, says Skymet"
            )
        )
        return data
    }
}