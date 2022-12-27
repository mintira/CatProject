package axons.forfarm.catproject.presentation.cat_detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import axons.forfarm.catproject.domain.model.GetCatImageResponse
import axons.forfarm.catproject.domain.usecase.GetCatImageUseCase
import axons.forfarm.catproject.utils.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CatDetailViewModel @Inject constructor(
    private val state: SavedStateHandle
) : ViewModel() {
    private val _textID = MutableLiveData<String>() //ต้องการส่ง String ออกไป
    val textID = _textID.asLiveData()

    private val _image = MutableLiveData<String>()
    val image = _image.asLiveData()
    //มีค่าที่เป็น private และค่าที่เป็น puclic
    //private - assign ใน viewmodel
    //public - observe

    //รับ param เข้ามา แล้วส่งค่าเป็น liveData ออกไป
    fun init (image: String, id: String) {
        _image.value = image
        _textID.value = "ID "+id //assign ค่า ให้ text id เวลามาเพิ่มข้อมูล ต้องมาเพิ่มใน view model
    }
}