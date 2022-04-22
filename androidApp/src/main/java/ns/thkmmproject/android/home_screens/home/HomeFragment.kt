package ns.thkmmproject.android.home_screens.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.ns.tabactivity.ui.main.SectionsPagerAdapter
import com.ns.thehindu.android.Data
import com.ns.thehindu.android.adapters.ArticleAdapter
import ns.thkmmproject.android.R
import ns.thkmmproject.android.ZoomOutPageTransformer
import ns.thkmmproject.android.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        //viewpager
        val fm : FragmentManager = (context as AppCompatActivity).supportFragmentManager
        val sectionsPagerAdapter = SectionsPagerAdapter(requireActivity(), fm)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
      //  viewPager.setPageTransformer(true, ZoomOutPageTransformer())
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)

        // recyclerviewArticle()

        return binding.root
    }



















//    private fun recyclerviewArticle() {
//        val recyclerView = binding.root.findViewById<RecyclerView>(R.id.recyclerview)
//        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
//
//        val data = arrayList()
//        val adapter = ArticleAdapter(requireContext(), data)
//        recyclerView.adapter = adapter
//    }

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