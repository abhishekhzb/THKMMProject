package ns.thkmmproject.android.home_screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ns.thkmmproject.model.Databean

class HomeViewModel(private val homeRepository: HomeRepository) :ViewModel() {

    fun onSectionCall() {
        homeRepository.sectionCall()
    }

    val resultSection: LiveData<ArrayList<Databean>>
        get() = homeRepository.resultSection

}