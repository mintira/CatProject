package axons.forfarm.catproject.domain.usecase

import android.graphics.Bitmap
import axons.forfarm.catproject.domain.model.GetCatImageResponse
import axons.forfarm.catproject.domain.repository.CatImageRepository
import axons.forfarm.catproject.utils.DISPATCHERS_IO
import axons.forfarm.catproject.utils.DISPATCHERS_UNCONFINED
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class GetCatImageUseCase @Inject constructor(
    private val repository: CatImageRepository,
    @Named(DISPATCHERS_IO) private val ioDispatcher: CoroutineDispatcher
) {

    operator suspend fun invoke(number: Int): GetCatImageResponse? = withContext(ioDispatcher) {
        repository.getImage(number)
    }


}