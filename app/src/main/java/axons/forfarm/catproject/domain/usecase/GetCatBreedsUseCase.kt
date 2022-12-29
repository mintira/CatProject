package axons.forfarm.catproject.domain.usecase

import axons.forfarm.catproject.domain.model.GetCatBreedsResponse
import axons.forfarm.catproject.domain.repository.CatBreedsRepository
import axons.forfarm.catproject.utils.DISPATCHERS_IO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.withContext

import javax.inject.Inject
import javax.inject.Named

//เป็นสื่อกลางระหว่าง Repository กับ ViewModel
//เอาไว้เช็คว่ามีข้อมูลหรือไม่ ถ้ามีก็จะเอาข้อมูลมาใช้งาน
class GetCatBreedsUseCase @Inject constructor(
    private val repository: CatBreedsRepository,
    @Named(DISPATCHERS_IO) private val ioDispatcher: CoroutineDispatcher
) {
    operator suspend fun invoke(): GetCatBreedsResponse? = withContext(ioDispatcher)  {
        repository.getBreedsDataList()
    }
}