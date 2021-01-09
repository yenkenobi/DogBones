package com.yen.dogbones.data.api

import com.yen.dogbones.domain.Image
import retrofit2.http.GET

interface Api {

    @GET("/breeds/image/random")
    suspend fun getRandomBreedImage(): Image

}