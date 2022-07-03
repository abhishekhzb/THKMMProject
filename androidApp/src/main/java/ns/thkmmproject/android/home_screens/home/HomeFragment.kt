package ns.thkmmproject.android.home_screens.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.ns.tabactivity.ui.main.SectionsPagerAdapter
import kotlinx.coroutines.MainScope
import ns.thkmmproject.model.Databean
import ns.thkmmproject.android.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private val mainScope = MainScope()
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        homeViewModel = ViewModelProvider(requireActivity(),HomeFactory(HomeRepository())).get(HomeViewModel::class.java)

        homeViewModel.onSectionCall()

        homeViewModel.resultSection.observe(requireActivity(),
            {
                //viewpager code after success
                 viewpagerCall(it)
                Log.e("Viewpgaer","ViewCalled")
            }
        )




//        mainScope.launch {
//            kotlin.runCatching {
//                ApiCall().getSectionModel()
//            }.onSuccess {
//                Log.e("RESPONSE_SECTION0",""+it)
//
//                val sectionsItem = Databean("","Home", ArrayList<SubDataBean>())
//                it.data.add(0,sectionsItem)
//
//                //viewpager code after success
//                viewpagerCall(it.data as List<Databean>)
//
//            }.onFailure {
//                Log.e("onFailure","Error: ${it.localizedMessage}")
//            }
//        }
        return binding.root
    }

    private fun viewpagerCall(sections: ArrayList<Databean>) {
        val sectionsPagerAdapter = SectionsPagerAdapter(requireActivity(), childFragmentManager, sections)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        //  viewPager.setPageTransformer(true, ZoomOutPageTransformer())
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)
    }


}