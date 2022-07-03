package ns.thkmmproject.android.home_screens.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import ns.thkmmproject.model.Databean
import ns.thkmmproject.model.SectionModel
import ns.thkmmproject.model.SubDataBean
import ns.thkmmproject.network.ApiCall

class HomeRepository {
    private val mainScope = MainScope()

    var sectionData = MutableLiveData<ArrayList<Databean>>()
    val resultSection: LiveData<ArrayList<Databean>> get() = sectionData

    fun sectionCall() {
        mainScope.launch {
            kotlin.runCatching {
                ApiCall().getSectionModel()
            }.onSuccess {
                Log.e("RESPONSE_SECTION",""+it)

                val sectionsItem = Databean("","Home", ArrayList<SubDataBean>())
                it.data.add(0,sectionsItem)

                sectionData.value = it.data

            }.onFailure {
                Log.e("onFailure","Error: ${it.localizedMessage}")
            }
        }
    }


}