package axons.forfarm.catproject.presentation.cat_breeds_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import axons.forfarm.catproject.domain.model.GetCatBreedsResponse
import axons.forfarm.catproject.domain.model.GetCatBreedsResponseItem
import axons.forfarm.catproject.domain.usecase.GetCatBreedsUseCase
import axons.forfarm.catproject.utils.Event
import axons.forfarm.catproject.utils.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatBreedsListViewModel @Inject constructor(
    private val getCatBreedsUseCase : GetCatBreedsUseCase,
    private val state: SavedStateHandle
) : ViewModel(){
    private val _textCatBreedsEpoxy = MutableLiveData<String>()
    val textCatBreedsEpoxy = _textCatBreedsEpoxy.asLiveData()
    //on best practice ในการสร้างตัวแปรแบบ LiveData จะต้องประกาศตัวแปรขึ้นมา 2 ตัว
    // 1. ตัวแปรที่เป็น private และเป็น MutableLiveData เอาไว้ใช้เรียกใน class นี้
    //    และเป็นตัวที่จะเปลี่ยนค่าได้ ควรเป็นชื่อเดียวกันแต่มี _ นำหน้าชื่อตัวแปร
    // 2. ตัวแปรที่เป็น public และเป็น LiveData เอาไว้ใช้เรียกใน class ของไฟล์อื่น ๆ


    private val _viewState = MutableLiveData<GetCatBreedsResponse>()
    val viewState = _viewState.asLiveData()

    private val _toast = MutableLiveData<Event<String>>()
    val toast = _toast.asLiveData()


    private val _viewStateItem = MutableLiveData<List<GetCatBreedsResponseItem>>()
    val viewStateItem = _viewStateItem.asLiveData()


    //ค่าใน LiveData จะถูกเรียกเมื่อมีการเข้าฟังก์ชัน init
    fun init(numberOfBreed : Int) {
        viewModelScope.launch {
            val response = getCatBreedsUseCase(numberOfBreed)
                //response.to

            if (response == null) {
                //show error toast
                _toast.postValue(Event("error when calling Api"))
            } else {
                //show image list
                _viewState.value = response!!
            }

        }
        _textCatBreedsEpoxy.value = "NewCatBreeds2"
    }
}

























