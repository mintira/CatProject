package axons.forfarm.catproject.presentation.cat_breeds_detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import axons.forfarm.catproject.utils.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CatBreedsDetailViewModel @Inject constructor(
    private val state: SavedStateHandle
) : ViewModel() {
    private val _catBreeds = MutableLiveData<String>()
    val catBreeds = _catBreeds.asLiveData()

    private val _catCountry = MutableLiveData<String>()
    val catCountry = _catCountry.asLiveData()

    private val _catCoat = MutableLiveData<String>()
    val catCoat = _catCoat.asLiveData()

    private val _catPattern = MutableLiveData<String>()
    val catPattern = _catPattern.asLiveData()

    fun init (catBreeds: String, catCountry: String, catCoat: String, catPattern: String) {
        _catBreeds.value = "สายพันธุ์ : " + catBreeds
        _catCountry.value = "ประเทศ : " + catCountry
        _catCoat.value = "ขน : " + catCoat
        _catPattern.value = "ลาย : " + catPattern
    }
}