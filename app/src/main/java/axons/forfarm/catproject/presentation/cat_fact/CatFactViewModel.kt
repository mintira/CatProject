package axons.forfarm.catproject.presentation.cat_fact

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import axons.forfarm.catproject.domain.repository.CatFactRepository
import axons.forfarm.catproject.utils.Event
import axons.forfarm.catproject.utils.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatFactViewModel @Inject constructor(
    private val catFactRepository: CatFactRepository,
    private val state: SavedStateHandle
) : ViewModel() {
    private val _fact = MutableLiveData<Event<String?>>() //ถ้าส่งคาที่เป็น null ต้องใส่? หลัง String
    val fact = _fact.asLiveData()

    fun init() {
        _fact.value = Event("")
        viewModelScope.launch {
            val factText = catFactRepository.getText()
            _fact.value = Event(factText) //ถ้าเป็น Event ต้องครอบด้วย Event()
        }
    }
}