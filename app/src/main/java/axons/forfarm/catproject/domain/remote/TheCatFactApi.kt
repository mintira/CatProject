package axons.forfarm.catproject.domain.remote

import axons.forfarm.catproject.domain.model.GetCatBreedsResponse
import axons.forfarm.catproject.domain.model.GetCatBreedsResponseItem
import axons.forfarm.catproject.domain.model.GetCatFactResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TheCatFactApi {
    @GET("/fact")
    suspend fun getCatFact(

    ): GetCatFactResponse?

    @GET("/breeds")
    suspend fun getCatBreeds(
    //@Query("limit") number: Int,
//    @Query("page") page: Int,
    ): GetCatBreedsResponse?
}
//  เวลาให้ endpoint ใหม่ url เดียวกัน
//    @GET("/.......")
//    suspend fun get.....(
//
//    ): Get.......Response?
