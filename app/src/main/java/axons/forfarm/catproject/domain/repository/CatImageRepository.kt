package axons.forfarm.catproject.domain.repository

import axons.forfarm.catproject.domain.model.GetCatImageResponse
import axons.forfarm.catproject.domain.remote.TheCatApi
import axons.forfarm.catproject.utils.DISPATCHERS_IO
import axons.forfarm.catproject.utils.DISPATCHERS_MAIN
import axons.forfarm.catproject.utils.DISPATCHERS_UNCONFINED
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class CatImageRepository @Inject constructor(
    private val theCatApi: TheCatApi,
    @Named(DISPATCHERS_UNCONFINED) private val unConfinedDispatcher: CoroutineDispatcher
) {
    suspend fun getImage(number: Int) = withContext(unConfinedDispatcher) {
        theCatApi.getCatImage(number)
    }

}