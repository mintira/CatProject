package axons.forfarm.catproject.presentation.cat_image_list.controller

import android.content.Context
import android.content.res.Resources
import android.util.Log
import androidx.lifecycle.MutableLiveData
import axons.forfarm.catproject.domain.model.GetCatImageResponse
import axons.forfarm.catproject.domain.model.GetCatImageResponseItem
import axons.forfarm.catproject.presentation.cat_image_list.controller.model.CatImageEpoxyModel
import axons.forfarm.catproject.utils.Event
import axons.forfarm.catproject.utils.asLiveData
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.stickyheader.StickyHeaderCallbacks
import javax.inject.Inject

class CatImageListEpoxyController @Inject constructor(val resources: Resources) :
    EpoxyController() {

    private val _onClickImage = MutableLiveData<Event<GetCatImageResponseItem>>()
    val onClickImage = _onClickImage.asLiveData()

    var viewState: GetCatImageResponse? = null
        set(value) {
            field = value
            requestModelBuild()
        }


    override fun buildModels() {
        try {
            val viewState = viewState ?: return

            viewState.forEach { data ->
                CatImageEpoxyModel(data) {
                    _onClickImage.value = Event(it)
                }.id("image ${data.id}").addTo(this)
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


}