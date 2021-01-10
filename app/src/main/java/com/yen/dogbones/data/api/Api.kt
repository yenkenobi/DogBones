package com.yen.dogbones.data.api

import com.yen.dogbones.domain.Image
import retrofit2.http.GET

interface Api {

    @GET("/api/breeds/image/random")
    suspend fun getRandomBreedImage(): Image

}