package axons.forfarm.catproject.presentation.cat_main_menu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import axons.forfarm.catproject.utils.Event
import axons.forfarm.catproject.utils.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatMainMenuViewModel @Inject constructor(val state: SavedStateHandle) : ViewModel() {

}