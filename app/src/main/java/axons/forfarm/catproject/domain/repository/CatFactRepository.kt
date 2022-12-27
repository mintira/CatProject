package axons.forfarm.catproject.domain.repository

import axons.forfarm.catproject.domain.remote.TheCatFactApi
import axons.forfarm.catproject.utils.DISPATCHERS_UNCONFINED
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Named

class CatFactRepository @Inject constructor( //การไปขออะไรที่เคยสร้างไว้แล้ว
    private val theCatFactApi: TheCatFactApi,
    @Named(DISPATCHERS_UNCONFINED) private val unConfinedDispatcher: CoroutineDispatcher
){
    suspend fun getText() : String? {//ให้คืนค่า String ออกมาให้ตอนเรียก
        return theCatFactApi.getCatFact()?.fact
        //เพื่อเอาแค่ fact ออกไปข้างนอก ใส่ ? เพื่อให้ return null เมื่อไม่มีค่าจาก API ส่งมา
    }

}