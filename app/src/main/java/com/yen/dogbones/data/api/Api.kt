package com.yen.dogbones.data.api

import com.yen.dogbones.data.api.model.ImageResponse
import com.yen.dogbones.data.api.model.ImagesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("/api/breeds/image/random")
    suspend fun getRandomBreedImage(): ImageResponse

    @GET("/api/breeds/image/random/{count}")
    suspend fun getRandomBreedImages(@Path("count") count: Int): ImagesResponse

}