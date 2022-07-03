package com.ns.tabactivity.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ns.thehindu.android.adapters.ArticleAdapter
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import ns.thkmmproject.network.ApiCall
import ns.thkmmproject.model.ArticleModel
import ns.thkmmproject.android.R
import ns.thkmmproject.android.databinding.FragmentMainBinding
import ns.thkmmproject.model.SectionListItem

/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel
    private var _binding: FragmentMainBinding? = null
    private val mainScope = MainScope()

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
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sectionId = arguments?.getString(ARG_SECTION_ID)
        makeServerRequestArticle(sectionId)

    }


    private fun makeServerRequestArticle(sectionId: String?) {
        mainScope.launch {
            kotlin.runCatching {
                ApiCall().getArticleModel(sectionId =sectionId,propertyId = "")
            }.onSuccess {
                val its = it

                // val len = myStr?.length ?: -1
                // will return -1 if myStr is null else will return length
                adapter?.let {
                    adapter?.insertBulkItemData(its, 5)
                } ?:let {
                    recyclerviewArticleLive(its)

                    // Send request to get Sports Data
                    makeServerRequestVerticalWidgets()

                }

                // Send the request to get Sports Data
            }.onFailure {
                Log.e("onFailure","Error: ${it.localizedMessage}")
            }
        }
    }

    private fun makeServerRequestVerticalWidgets(){
        mainScope.launch {
            kotlin.runCatching {
                ApiCall().getWidgetArticleModel(sectionId ="",propertyId = "2")
            }.onSuccess {
                val its = it
                Log.e("HORIZONTAL_WIDGETS",""+its.data[0].section)
            }.onFailure {
                Log.e("onFailure","Error: ${it.localizedMessage}")
            }
        }
    }


    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"
        private const val ARG_SECTION_ID = "section_id"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int, _sectionId : String): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                    putString(ARG_SECTION_ID, _sectionId)

                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private var adapter : ArticleAdapter? = null;

    private fun recyclerviewArticleLive(articleData: MutableList<SectionListItem>) {
        val recyclerView = binding.root.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        adapter = ArticleAdapter(requireContext(), articleData)
        recyclerView.adapter = adapter

    }

}