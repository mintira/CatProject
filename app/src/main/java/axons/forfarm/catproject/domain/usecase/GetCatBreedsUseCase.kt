package axons.forfarm.catproject.domain.usecase

import axons.forfarm.catproject.domain.model.GetCatBreedsResponse
import axons.forfarm.catproject.domain.repository.CatBreedsRepository
import axons.forfarm.catproject.utils.DISPATCHERS_IO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.withContext

import javax.inject.Inject
import javax.inject.Named

class GetCatBreedsUseCase @Inject constructor(
    private val repository: CatBreedsRepository,
    @Named(DISPATCHERS_IO) private val ioDispatcher: CoroutineDispatcher
) {
    operator suspend fun invoke(number: Int): GetCatBreedsResponse? = withContext(ioDispatcher)  {
        repository.getBreedsDataList(number)
    }
}