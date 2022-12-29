package axons.forfarm.catproject.domain.repository

import axons.forfarm.catproject.domain.model.GetCatBreedsResponse
import axons.forfarm.catproject.domain.remote.TheCatFactApi
import axons.forfarm.catproject.utils.DISPATCHERS_UNCONFINED
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class CatBreedsRepository @Inject constructor(
    private val theCatFactApi: TheCatFactApi,
    @Named(DISPATCHERS_UNCONFINED) private val unConfinedDispatcher: CoroutineDispatcher
){
    suspend fun getBreedsDataList() = withContext(unConfinedDispatcher) {
        theCatFactApi.getCatBreeds()
    }
}