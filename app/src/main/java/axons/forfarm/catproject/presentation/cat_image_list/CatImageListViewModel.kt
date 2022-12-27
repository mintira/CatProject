package axons.forfarm.catproject.presentation.cat_image_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import axons.forfarm.catproject.domain.model.GetCatImageResponse
import axons.forfarm.catproject.domain.model.GetCatImageResponseItem
import axons.forfarm.catproject.domain.usecase.GetCatImageUseCase
import axons.forfarm.catproject.utils.Event
import axons.forfarm.catproject.utils.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatImageListViewModel @Inject constructor(
    private val getCatImageUseCase: GetCatImageUseCase,
    private val state: SavedStateHandle
) : ViewModel() {

    private val _viewState = MutableLiveData<GetCatImageResponse>()
    val viewState = _viewState.asLiveData()

    private val _toast = MutableLiveData<Event<String>>()
    val toast = _toast.asLiveData()

    private val _navigateToCatDetail = MutableLiveData<Event<GetCatImageResponseItem>>()
    //รับค่ามาเป็น data class
    val navigateToCatDetail = _navigateToCatDetail.asLiveData()

    //รับ param เข้ามา แล้วส่งค่าเป็น liveData ออกไป
    fun init(numberOfImage: Int) {
        viewModelScope.launch {

            val response = getCatImageUseCase(numberOfImage)
            if (response == null) {
                //show error toast
                _toast.postValue(Event("error when calling Api"))
            } else {
                //show breeds list
                _viewState.value = response!!
            }


        }
    }


    //step2 กำหนดให้เปลี่ยนหน้า
    fun onClickImage(clickedItem: GetCatImageResponseItem) {
//        _toast.value = Event(clickedItem.id)
        _navigateToCatDetail.value = Event(clickedItem)
        //livedata navigate พอถูก Aissign ค่า ก็จะไป observe ที่ fragment
    }
}