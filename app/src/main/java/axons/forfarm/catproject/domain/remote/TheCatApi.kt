package axons.forfarm.catproject.domain.remote

import axons.forfarm.catproject.domain.model.GetCatImageResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TheCatApi {

    @GET("/v1/images/search")
    suspend fun getCatImage(
        @Query("limit") number: Int,
    ): GetCatImageResponse?

}